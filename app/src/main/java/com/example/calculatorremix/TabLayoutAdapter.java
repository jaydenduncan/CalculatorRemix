package com.example.calculatorremix;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class TabLayoutAdapter extends FragmentStateAdapter {

    public static final int NUM_TABS = 3;

    public TabLayoutAdapter(Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        /*

        Fragment fragment = new TabLayoutFragment();

        Bundle args = new Bundle();
        args.putInt(TabLayoutFragment.ARG_ID, position + 1);
        fragment.setArguments(args);

        return fragment;

         */

        Fragment fragment = null;

        if(position == 0){
            fragment = new TipFragment();
        }
        else if(position == 1){
            fragment = new TemperatureFragment();
        }
        else if(position == 2) {
            fragment = new DistanceFragment();
        }

        Bundle args = new Bundle();
        args.putInt(TipFragment.ARG_ID, position + 1);
        fragment.setArguments(args);

        return fragment;

    }

    @Override
    public int getItemCount() {
        return NUM_TABS;
    }

}