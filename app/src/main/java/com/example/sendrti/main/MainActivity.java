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
import android.util.Log;
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

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private NavController navController;
    private TextView name,emailAddress;
    private ImageView profilePic;
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
        name = (TextView) headerView.findViewById(R.id.name);
        emailAddress = (TextView)headerView.findViewById(R.id.emailaddress);
        profilePic = (ImageView) headerView.findViewById(R.id.imageView);
        PrefrenceUtil.init(getApplicationContext());
        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            String type = bundle.getString("key");
            if(type != null) {
                if (type.contains("Sendbirdtype")) {

                    String nickname = bundle.getString("nickname");
                    String email = bundle.getString("email");
                    emailAddress.setText(email);
                    name.setText(nickname);

                }
            }

            if(type != null){
                if(type.contains("Paymentgateway"))
                {
                       String nickname = bundle.getString("Username");
                       String email = bundle.getString("Email");
                       emailAddress.setText(email);
                       name.setText(nickname);
                       Menu nav_Menu = navigationView.getMenu();
                       nav_Menu.findItem(R.id.nav_Query).setVisible(false);
                       firebaseAuth = FirebaseAuth.getInstance();
                       FirebaseUser account = firebaseAuth.getCurrentUser();

                     try{
                              assert account != null;
                              Uri uri = account.getPhotoUrl();
                              Glide.with(this).load(uri).apply(new RequestOptions()
                              .placeholder(R.mipmap.ic_launcher)
                              .fitCenter())
                              .into(profilePic);
                //   imageview.setBackgroundResource(uri);
                       }
            catch (NullPointerException e){
                         Toast.makeText(getApplicationContext(),"image not found",Toast.LENGTH_LONG).show();
                  }
                }
            }
            if(type !=null){

                if(type.contains("continueasguest"))
                {
                    String nickname = bundle.getString("User");
                    name.setText(nickname);
                    emailAddress.setVisibility(View.GONE);
                    Menu nav_Menu = navigationView.getMenu();
                    nav_Menu.findItem(R.id.nav_Query).setVisible(false);

                }
            }
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
            return true;
        }
        if(id == R.id.action_notifiaction){
            navController.navigate(R.id.nav_notification);

            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {

        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}


