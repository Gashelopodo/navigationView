package com.gashe.navigationview;

import android.support.design.internal.NavigationMenu;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private boolean menu_visible;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        menu_visible = false;

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_fingerprint_black_24dp);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NavigationView navigationView = (NavigationView)findViewById(R.id.myNavigationView);
        navigationView.setNavigationItemSelectedListener(new NavigationMenuListener(this));

        drawerLayout = (DrawerLayout)findViewById(R.id.myDrawer);

    }

    public void closeMenu(){

        drawerLayout.closeDrawers();
        menu_visible = false;

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                if(menu_visible){
                    drawerLayout.closeDrawers();
                    menu_visible = false;
                }else{
                    drawerLayout.openDrawer(GravityCompat.START);
                    menu_visible = true;
                }
        }

        return super.onOptionsItemSelected(item);
    }
}
