package com.gashe.navigationview;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.view.MenuItem;
import android.widget.TextView;

/**
 * Created by cice on 18/2/17.
 */

public class NavigationMenuListener implements NavigationView.OnNavigationItemSelectedListener {

    private Context context;

    public NavigationMenuListener(Context context) {
        this.context = context;
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        MainActivity activity = (MainActivity)context;
        TextView textView = (TextView)activity.findViewById(R.id.myTextView);

        String opcionmenu = (String) item.getTitle();
        textView.setText(opcionmenu);

        activity.closeMenu();

        return false;
    }
}
