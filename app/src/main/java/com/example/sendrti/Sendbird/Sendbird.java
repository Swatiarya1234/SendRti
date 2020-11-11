package com.example.sendrti.Sendbird;

import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sendrti.R;
import com.example.sendrti.Splashscreen.ConnectionManager;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.sendbird.android.OpenChannel;
import com.sendbird.android.OpenChannelListQuery;
import com.sendbird.android.SendBirdException;

import java.util.List;

import static android.app.Activity.RESULT_OK;

public class Sendbird extends Fragment {

    private SendbirdViewModel mViewModel;
    public static final String EXTRA_OPEN_CHANNEL_URL = "OPEN_CHANNEL_URL";
    private static final int INTENT_REQUEST_NEW_OPEN_CHANNEL = 402;

    private static final int CHANNEL_LIST_LIMIT = 15;
    private static final String CONNECTION_HANDLER_ID = "CONNECTION_HANDLER_OPEN_CHANNEL_LIST";

    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLayoutManager;
    private OpenChannelListAdapter mChannelListAdapter;
    private SwipeRefreshLayout mSwipeRefresh;
    private FloatingActionButton mCreateChannelFab;


    private OpenChannelListQuery mChannelListQuery;

    public static Sendbird newInstance() {

        //Sendbird fragment = new Sendbird();
        Sendbird fragment = new Sendbird();
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.sendbird_fragment, container, false);
        setRetainInstance(true);
        setHasOptionsMenu(true);

       // (getActivity()).setActionBarTitle(getResources().getString(R.string.all_open_channels));

        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_open_channel_list);
        mChannelListAdapter = new OpenChannelListAdapter(getContext());

        // Set color?
        mSwipeRefresh = (SwipeRefreshLayout) view.findViewById(R.id.swipe_layout_open_channel_list);

        // Swipe down to refresh channel list.
        mSwipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mSwipeRefresh.setRefreshing(true);
              //  mSwipeRefresh.setRefreshing(true);
                refresh();
            }
        });

        mCreateChannelFab = (FloatingActionButton) view.findViewById(R.id.fab_open_channel_list);
        mCreateChannelFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), CreateOpenChannelActivity.class);
                startActivityForResult(intent, INTENT_REQUEST_NEW_OPEN_CHANNEL);
               // startActivityForResult(intent,INTENT_REQUEST_NEW_OPEN_CHANNEL);

            }
        });

        setUpRecyclerView();
        setUpChannelListAdapter(view);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        ConnectionManager.addConnectionManagementHandler(CONNECTION_HANDLER_ID, new ConnectionManager.ConnectionManagementHandler() {
            @Override
            public void onConnected(boolean reconnect) {

                refresh();
            }
        });
    }
    @Override
    public void onPause() {
        super.onPause();
        ConnectionManager.removeConnectionManagementHandler(CONNECTION_HANDLER_ID);
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        if(requestCode == INTENT_REQUEST_NEW_OPEN_CHANNEL){
//
//        }

        if (requestCode == INTENT_REQUEST_NEW_OPEN_CHANNEL) {
            if (resultCode == RESULT_OK) {
                refresh();
            }
        }
    }

    void setUpRecyclerView() {


        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mChannelListAdapter);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));

        // If user scrolls to bottom of the list, loads more channels.
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                if (mLayoutManager.findLastVisibleItemPosition() == mChannelListAdapter.getItemCount() - 1) {
                    loadNextChannelList();
                }
            }
        });
    }

    // Set touch listeners to RecyclerView items
    private void setUpChannelListAdapter(final View view) {
        mChannelListAdapter.setOnItemClickListener(new OpenChannelListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(OpenChannel channel) {

                String channelUrl = channel.getUrl();
                Log.d("ChannelUrl",channelUrl);
                Log.d("Channelname",channel.getName());
                OpenChatFragment fragment2 = new OpenChatFragment(channel);
               // OpenChatFragemnt fragment2 = new OpenChatFragment(channel);
                OpenChatFragment fragment = OpenChatFragment.newInstance(channelUrl);
                Navigation.findNavController(view).navigate(R.id.action_ChatFrament);

            }
        });

        mChannelListAdapter.setOnItemLongClickListener(new OpenChannelListAdapter.OnItemLongClickListener() {
            @Override
            public void onItemLongPress(OpenChannel channel) {

            }
        });
    }

    private void refresh() {
       // refreshChannelList(CHANNEL_LIST_LIMIT);
        refreshChannelList(CHANNEL_LIST_LIMIT);
    }

    /**
     * Creates a new query to get the list of the user's Open Channels,
     * then replaces the existing dataset.
     *
     * @param numChannels   The number of channels to load.
     */
    void refreshChannelList(int numChannels) {
        mChannelListQuery = OpenChannel.createOpenChannelListQuery();
        mChannelListQuery.setLimit(numChannels);
        mChannelListQuery.next(new OpenChannelListQuery.OpenChannelListQueryResultHandler() {
            @Override
            public void onResult(List<OpenChannel> list, SendBirdException e) {
                if (e != null) {
                    e.printStackTrace();
                    return;
                }

                mChannelListAdapter.setOpenChannelList(list);

                if (mSwipeRefresh.isRefreshing()) {
                    mSwipeRefresh.setRefreshing(false);
                }
            }
        });
    }

    /**
     * Loads the next channels from the current query instance.
     */
    void loadNextChannelList() {
        if (mChannelListQuery != null) {
            mChannelListQuery.next(new OpenChannelListQuery.OpenChannelListQueryResultHandler() {
                @Override
                public void onResult(List<OpenChannel> list, SendBirdException e) {
                    if (e != null) {
                        e.printStackTrace();
                        return;
                    }

                    for (OpenChannel channel : list) {
                        mChannelListAdapter.addLast(channel);
                        Log.d("name",channel.getName());
                    }
                }
            });
        }
    }



    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(SendbirdViewModel.class);
        // TODO: Use the ViewModel
    }

}
