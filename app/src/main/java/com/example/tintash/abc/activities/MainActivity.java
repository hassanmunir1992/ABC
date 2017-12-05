package com.example.tintash.abc.activities;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.tintash.abc.R;
import com.example.tintash.abc.adapters.DrawerAdapter;
import com.example.tintash.abc.fragments.SettingsFragment;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, DrawerLayout.DrawerListener {

    public static final String HOME = "HOME";
    public static final String SETTINGS = "Settings";

    public static final String FRAGMENT_TAG = "fragment_tag";
    private FragmentManager fragmentManager;

    private Toolbar toolbar;

    private DrawerLayout mDrawerLayout;
    private ListView drawerlistview;
    private ActionBarDrawerToggle drawerToggle;
    private int mDrawerSelectedPosition = 0;
    private boolean itemSlected;
    private DrawerAdapter mDrawerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setToolbar();
        setupDrawer();

    }

    private void setToolbar() {
        this.toolbar = (Toolbar) this.findViewById(R.id.toolbar);
        this.setSupportActionBar(this.toolbar);

    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }

    private void setupDrawer() {

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerlistview = (ListView) mDrawerLayout.findViewById(R.id.list);
        String[] names = {"Home", "Settings"};
        int[] icons = {};
        mDrawerAdapter = new DrawerAdapter(this, names, icons);
        drawerlistview.setAdapter(mDrawerAdapter);
        drawerlistview.setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);
        drawerlistview.setItemChecked(0, true);
        drawerlistview.setOnItemClickListener(this);
        drawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, 0, 0);
        drawerToggle.setDrawerIndicatorEnabled(true);
        mDrawerLayout.addDrawerListener(this);


    }

    @Override
    public void onDrawerSlide(View drawerView, float slideOffset) {

    }

    @Override
    public void onDrawerOpened(View drawerView) {

    }

    @Override
    public void onDrawerClosed(View drawerView) {
        if (itemSlected)
            navigateToDesiredFragment();

        itemSlected = false;
    }

    @Override
    public void onDrawerStateChanged(int newState) {

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        itemSlected = true;
        this.mDrawerSelectedPosition = i;
        mDrawerLayout.closeDrawers();

    }

    private void displayFragment(Fragment fragment) {
        //getting FragmentManager
        fragmentManager = this.getSupportFragmentManager();
        //getting FragmentTransaction
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //replacing fragment with passed fragment
        fragmentTransaction.replace(R.id.frame_layout, fragment, MainActivity.FRAGMENT_TAG);
        //adding transaction to backStack
        //fragmentTransaction.addToBackStack(Consts.BACK_STACK_STATE_NAME);
        //committing fragmentTransaction
        fragmentTransaction.commit();

    }

    private void navigateToDesiredFragment() {
        switch (mDrawerSelectedPosition) {

            case 0:


                break;
            case 1:

                displayFragment(new SettingsFragment());

                break;


        }
    }


}
