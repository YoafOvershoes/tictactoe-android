package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class GameRecordsActivity extends AppCompatActivity {

    public static final int NEW_WORD_ACTIVITY_REQUEST_CODE = 1;

    private RecordViewModel mRecordViewModel;
    RecyclerView recyclerView;
    static final int NOT_A_GAME_RECORD = -1;
    ArrayList<GameRecord> gameRecords;
    int gameTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        gameTime = getIntent().getIntExtra("game_time", -1);
        gameRecords = new ArrayList<GameRecord>();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_records);

        recyclerView = findViewById(R.id.recordsview);
        final RecordListApadter recordListApadter = new RecordListApadter(new RecordListApadter.RecordDiff());
        recyclerView.setAdapter(recordListApadter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mRecordViewModel = new ViewModelProvider(this).get(RecordViewModel.class);


        mRecordViewModel.getTopRecords().observe(this, records -> {
            // Update the cached copy of the words in the adapter.
            recordListApadter.submitList(records);
            gameRecords.clear();

            for (int recordIndex = 0; recordIndex < records.size(); recordIndex++) {
                Log.i("Record", "" + records.get(recordIndex).record);
                gameRecords.add(records.get(recordIndex));
            }

            if (gameTime != NOT_A_GAME_RECORD) {
                for (int recordIndex = 0; recordIndex < records.size(); recordIndex++) {
                    if (gameTime < records.get(recordIndex).getRecord()) {
                        Log.i("RecordSurpassed", "old time " + records.get(recordIndex).record + " new time " + gameTime);
                        finish();
                    }
                }
            }

        });
    }
}