package com.example.calculatorremix;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class TabLayoutAdapter extends FragmentStateAdapter {

    public static final int NUM_TABS = 4;

    public TabLayoutAdapter(Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        Fragment fragment = new TabLayoutFragment();

        Bundle args = new Bundle();
        args.putInt(TabLayoutFragment.ARG_ID, position + 1);
        fragment.setArguments(args);

        return fragment;

    }

    @Override
    public int getItemCount() {
        return NUM_TABS;
    }

}