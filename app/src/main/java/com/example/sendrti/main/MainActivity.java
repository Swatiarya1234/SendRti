package com.example.sendrti.main;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.sendrti.PrefrenceUtil.PrefrenceUtil;
import com.example.sendrti.R;
import com.example.sendrti.Splashscreen.SplashScreenActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

//This is my Main activity file
public class MainActivity extends AppCompatActivity {

    private AppCompatActivity mAppBarConfiguration;
    private NavController navcontroller;
    private TextView textview,textview3;
    private ImageView imageview;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavController navigationView = findViewById(R.id.nav_view);
        View headerView = navigationView.getHeaderView(0);
        textview = (TextView) headerView.findViewById(R.id.text2);
        textview3 = (TextView)headerView.findViewById(R.id.textView);
        imageview = (ImageView) headerView.findViewById(R.id.imagebtn2);

        Intent intent = getIntent();
        String id = intent.getStringExtra("Username");
        String idname = intent.getStringExtra("Email");

        PrefrenceUtil.init(getApplicationContext());
        textview.setText(id);
        textview3.setText(idname);
        firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser account = firebaseAuth.getCurrentUser();

        try{

            assert account != null;
            Uri uri = account.getPhotoUrl();
            RequestOptions requestOptions = new RequestOptions();
            requestOptions.placeholder(R.drawable.backgroundblack);
            requestOptions.error(R.drawable.email);
            Glide.with(this).load(uri).apply(new RequestOptions().placeholder(R.drawable.backgroundblack).error(R.drawable.background2)).into(imageview);

            //   imageview.setBackgroundResource(uri);
        }
        catch (NullPointerException e){
            Toast.makeText(getApplicationContext(),"image not found",Toast.LENGTH_LONG).show();
        }
        mAppBarConfiguration = new AppBarConfiguration.Builder(R.id.nav_Home2, R.id.nav_myrti, R.id.nav_Dashboard, R.id.nav_Query, R.id.nav_EmailQuery, R.id.nav_pricing2)
                .setDrawerLayout(drawer)
                .build();

        MenuItem logout = navigationView.getMenu().findItem(R.id.nav_Logout);
        logout.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(){

            @Override
            public boolean onMenuItemClick(MenuItem item) {

                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getApplication(), SplashScreenActivity.class);
                startActivity(intent);
//do your stuff
                return true;
            }
        });

        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_item_one) {

            navController.navigate(R.id.nav_Home2);
            //   navController.navigate(R.id.nav_Home2);
            // navController.navigate(R.id.action_HomeSecondFragment_to_HomeFragment);
            // your code
            return true;
        }
        if(id == R.id.action_item_two){

            //navController.navigate(R.id.nav_home);
            navController.navigate(R.id.nav_notification);

            return true;
        }
//        if(id == R.id.action_item_three){
//
//            Intent intent = new Intent(this, SendRtiSplashscreen.class);
//            startActivity(intent);
//        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {

        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}
