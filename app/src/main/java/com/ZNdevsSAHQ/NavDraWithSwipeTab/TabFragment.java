package com.ZNdevsSAHQ.NavDraWithSwipeTab;

/**
 * made by sahq on 05/08/2020.
 */


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;

public class TabFragment extends Fragment {

    public static TabLayout tabLayout;
    public static ViewPager viewPager;
    public static int int_items = 5;
    private int[] tabIcons = {
            R.drawable.ic_home,
            R.drawable.ic_beam,
            R.drawable.ic_toys,
            R.drawable.ic_info,
            R.drawable.ic_email
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        //this inflates out tab layout file.
        View x =  inflater.inflate(R.layout.tab_fragment_layout,null);
        // set up stuff.
        tabLayout = x.findViewById(R.id.tabs);
        viewPager = x.findViewById(R.id.viewpager);



        // create a new adapter for our pageViewer. This adapters returns child fragments as per the positon of the page Viewer.
        viewPager.setAdapter(new MyAdapter(getChildFragmentManager()));

        // this is a workaround
        tabLayout.post(new Runnable() {
            @Override
            public void run() {
                //provide the viewPager to TabLayout.
                tabLayout.setupWithViewPager(viewPager);
                setupTabIcons();
            }
        });
        //to preload the adjacent tabs. This makes transition smooth.
        viewPager.setOffscreenPageLimit(2);

       return x;
   }
    private void setupTabIcons() {
        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
        tabLayout.getTabAt(2).setIcon(tabIcons[2]);
        tabLayout.getTabAt(3).setIcon(tabIcons[3]);
        tabLayout.getTabAt(4).setIcon(tabIcons[4]);
    }
    class MyAdapter extends FragmentPagerAdapter {

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        //return the fragment with respect to page position.
        @Override
        public Fragment getItem(int position)
        {
            switch (position){
                case 0 : return new Tab1();
                case 1 : return new Tab2();
                case 2 : return new Tab3();
                case 3 : return new Tab4();
                case 4 : return new Tab5();
            }
            return null;
        }

        @Override
        public int getCount() {

            return int_items;

        }

        //This method returns the title of the tab according to the position.
        @Override
        public CharSequence getPageTitle(int position) {

            switch (position){
                case 0 :
                    return "Tab1";
                case 1 :
                    return "Tab2";
                case 2:
                    return "Tab3";
                case 3:
                    return "Tab4";
                case 4:
                    return "Tab5";
            }
            return null;
        }
    }
}