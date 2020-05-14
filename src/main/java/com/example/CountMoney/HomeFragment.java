package com.example.CountMoney;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;


public class HomeFragment extends Fragment {
    ViewPager vp_pages;
//
//    @Override
//    public void onStart() {
//        super.onStart();
//        PagerAdapter pagerAdapter = new FragmentAdapter(getActivity().getSupportFragmentManager());
//        vp_pages.setAdapter(pagerAdapter);
//    }


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        View v = inflater.inflate(R.layout.fragment_home, container, false);
        vp_pages = v.findViewById(R.id.vp_pages);
        PagerAdapter pagerAdapter = new FragmentAdapter(getChildFragmentManager());
        vp_pages.setAdapter(pagerAdapter);

        TabLayout tbl_pages = v.findViewById(R.id.tabs);
        tbl_pages.setupWithViewPager(vp_pages);
        Log.d("FragmentList",getActivity().getSupportFragmentManager().getFragments().toString());
        return v;
    }


}

class FragmentAdapter extends FragmentStatePagerAdapter {

    public FragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fg = null;
        switch (position) {
            case 0:
                fg = new alcVSgas();

                break;
            case 1:
                fg = new custoViagem();
                break;
            case 2:
                fg = new lucroApp();
                break;
        }
        return fg;
    }

    @Override
    public int getCount() {
        return 3;
    }


    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            //
            //Your tab titles
            //
            case 0:
                return "Álcool VS Gasolina";
            case 1:
                return "Gasto combustível";
            case 2:
                return "Lucro app";
            default:
                return null;
        }
    }
}