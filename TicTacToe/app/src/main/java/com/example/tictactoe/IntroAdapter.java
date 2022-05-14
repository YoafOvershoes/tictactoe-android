package com.example.tictactoe;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class IntroAdapter extends FragmentPagerAdapter {

    private final Data[] data = { new Data("Tic-tac-toe is a simple, two-player game each one mark X or O on his turn.",
            R.drawable.intro1),
            new Data("X play",R.drawable.intro2),
            new Data("O play",R.drawable.intro3),
            new Data("X play",R.drawable.intro4),
            new Data("O play",R.drawable.intro5),
            new Data("The player who succeeds in placing three of their marks in a horizontal, vertical, or diagonal row is the winner! X Won!",R.drawable.intro6),
    };

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