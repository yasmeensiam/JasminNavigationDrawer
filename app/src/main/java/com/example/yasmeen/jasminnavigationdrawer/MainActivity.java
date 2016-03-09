package com.example.yasmeen.jasminnavigationdrawer;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.PersistableBundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import java.util.ArrayList;

import Adapter.SlidingMenuAdapter;
import Model.ItemSlideMenu;
import layout.Fragment1;
import layout.Fragment2;
import layout.Fragment3;

public class MainActivity extends ActionBarActivity {
    ArrayList<ItemSlideMenu> itemSlideMenus;
    SlidingMenuAdapter slidingMenuAdapter;
    ListView listView;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.slidMenu);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        itemSlideMenus = new ArrayList<>();
        itemSlideMenus.add(new ItemSlideMenu(R.drawable.email, "email"));
        itemSlideMenus.add(new ItemSlideMenu(R.drawable.password, "password"));
        itemSlideMenus.add(new ItemSlideMenu(R.drawable.user_name, "uer name"));
        slidingMenuAdapter = new SlidingMenuAdapter(this, itemSlideMenus);
        listView.setAdapter(slidingMenuAdapter);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        setTitle(itemSlideMenus.get(0).getTitle());
        listView.setItemChecked(0, true);
        drawerLayout.closeDrawer(listView);
        ReplaceFragment(0);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                setTitle(itemSlideMenus.get(position).getTitle());
                listView.setItemChecked(position, true);
                ReplaceFragment(position);
                drawerLayout.closeDrawer(listView);

            }
        });
        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout ,R.string.open, R.string.close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                invalidateOptionsMenu();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                invalidateOptionsMenu();
            }
        };
        drawerLayout.setDrawerListener(actionBarDrawerToggle);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onPostCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onPostCreate(savedInstanceState, persistentState);
        actionBarDrawerToggle.syncState();
    }

    private void ReplaceFragment(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new Fragment1();
                break;
            case 1:
                fragment = new Fragment2();
                break;
            case 2:
                fragment = new Fragment3();
                break;
        }
        if (null != fragment) {
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.mainContent,fragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
    }
}
