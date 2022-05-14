package com.example.tictactoe;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class IntroActivity extends AppCompatActivity {

    final String SHOW_KEY = "show";
    ViewPager pager;
    TabLayout dots;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        Intent prevIntent = getIntent();
        boolean isFromMenu = prevIntent.getBooleanExtra("isFromMenu",false);


        if (isFirstTime() || isFromMenu) {

            pager = findViewById(R.id.pager);
            pager.setAdapter(new IntroAdapter(getSupportFragmentManager()));
            pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                }

                @Override
                public void onPageSelected(int position) {

                    if (position == dots.getTabCount()-1) {
                        button.setText(R.string.finishedIntro);
                    } else {
                        button.setText(R.string.skip);
                    }
                }

                @Override
                public void onPageScrollStateChanged(int state) {

                }
            });

            dots = findViewById(R.id.dots);
            dots.setupWithViewPager(pager, true);

            button = findViewById(R.id.button);
            button.setOnClickListener(v -> {
                SharedPreferences p = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor editor = p.edit();
                editor.putBoolean(SHOW_KEY, false);
                editor.commit();
                Intent intent = new Intent();
                intent.setClass(v.getContext(), MainMenuActivity.class);
                startActivity(intent);
            });
        }
        else{
            Intent intent = new Intent();
            intent.setClass(this, MainMenuActivity.class);
            startActivity(intent);
            finish();
        }
    }

    private boolean isFirstTime() {
        SharedPreferences p = getPreferences(MODE_PRIVATE);
        return p.getBoolean(SHOW_KEY, true);
    }
}
