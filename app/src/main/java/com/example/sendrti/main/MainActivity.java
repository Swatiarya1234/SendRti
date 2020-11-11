package com.example.sendrti.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.sendrti.PrefrenceUtil.PrefrenceUtil;
import com.example.sendrti.R;
import com.example.sendrti.Splashscreen.SplashScreenActivity;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private NavController navController;
    private TextView textview,textview3;
    private ImageView imageview;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        View headerView = navigationView.getHeaderView(0);
        textview = (TextView) headerView.findViewById(R.id.name);
        textview3 = (TextView)headerView.findViewById(R.id.emailaddress);
        imageview = (ImageView) headerView.findViewById(R.id.imageView);

        Intent intent = getIntent();
        String id = intent.getStringExtra("Username");
        String idname = intent.getStringExtra("Email");

        Intent intent1 = getIntent();
        String id2 = intent.getStringExtra("name");
        String email = intent.getStringExtra("Email");


        PrefrenceUtil.init(getApplicationContext());
        textview.setText(id);
        textview3.setText(idname);
        firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser account = firebaseAuth.getCurrentUser();

        try{
            
            assert account != null;
            Uri uri = account.getPhotoUrl();
            Glide.with(this).load(uri).apply(new RequestOptions()
                    .placeholder(R.mipmap.ic_launcher)
                    .fitCenter())
                    .into(imageview);
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
        getMenuInflater().inflate(R.menu.mainnavcontroller, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_home) {

            navController.navigate(R.id.nav_Home2);
            //   navController.navigate(R.id.nav_Home2);
            // navController.navigate(R.id.action_HomeSecondFragment_to_HomeFragment);
            // your code
            return true;
        }
        if(id == R.id.action_notifiaction){

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


