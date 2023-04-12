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

        Bundle args = new Bundle();
        Fragment fragment = null;

        // Create fragment object based on tab position

        if(position == 0){
            fragment = new TipFragment();
            args.putInt(TipFragment.ARG_ID, position + 1);
        }
        else if(position == 1){
            fragment = new TemperatureFragment();
            args.putInt(TemperatureFragment.ARG_ID, position + 1);
        }
        else if(position == 2) {
            fragment = new DistanceFragment();
            args.putInt(DistanceFragment.ARG_ID, position + 1);
        }

        fragment.setArguments(args);

        return fragment;

    }

    @Override
    public int getItemCount() {
        return NUM_TABS;
    }

}