package com.example.tictactoe;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class IntroAdapter extends FragmentPagerAdapter {

    private final Data[] data = { new Data("Tic-tac-toe is a simple, two-player game that, if played optimally by both players, will always result in a tie.", R.drawable.board_bg),
            new Data("Do more, think less", R.drawable.board_bg),
            new Data("Eat healthy", R.drawable.board_bg)};

    public IntroAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return IntroFragment.newInstance(data[position], position);
    }

    @Override
    public int getCount() {
        return data.length;
    }

}