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


// getting the bundle back from the android
        Bundle bundle = getIntent().getExtras();



// getting the string back;
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

        }

      String type2 = bundle.getString("GooglepayUsername");



//            Intent intent1 = getIntent();
//            String id2 = intent1.getStringExtra("Username");
//            String email = intent1.getStringExtra("Email");
//            startActivity(intent1);
//            textview.setText(id2);
//            textview3.setText(email);





       // String loginwithmail = getIntent().getStringExtra("loginwithemail");
       // String loginwithguest = getIntent().getStringExtra("loginwithguest");





//        assert sendbirdtype != null;
//        if(sendbirdtype.equals("intent")) {
//
//           String id = PrefrenceUtil.getUserId();
//           String nickname = PrefrenceUtil.getUserId();
//           textview.setText(id);
//           textview3.setText(nickname);
//        }
//
//        assert loginwithmail != null;
//        if(loginwithmail.equals("googlelogin")){
//
//            String id = getIntent().getStringExtra("Username");
//            String nickname = getIntent().getStringExtra("Email");
//            textview.setText(id);
//            textview3.setText(nickname);
//            firebaseAuth = FirebaseAuth.getInstance();
//            FirebaseUser account = firebaseAuth.getCurrentUser();
//
//            try{
//
//                assert account != null;
//                Uri uri = account.getPhotoUrl();
//                Glide.with(this).load(uri).apply(new RequestOptions()
//                        .placeholder(R.mipmap.ic_launcher)
//                        .fitCenter())
//                        .into(imageview);
//                //   imageview.setBackgroundResource(uri);
//            }
//            catch (NullPointerException e){
//                Toast.makeText(getApplicationContext(),"image not found",Toast.LENGTH_LONG).show();
//            }
//        }




        //String name = getPackageName();



//        textview.setText(id);
//        textview3.setText(idname);

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


