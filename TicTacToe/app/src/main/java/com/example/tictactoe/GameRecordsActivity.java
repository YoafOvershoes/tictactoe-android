package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class GameRecordsActivity extends AppCompatActivity {

    public static final int NEW_WORD_ACTIVITY_REQUEST_CODE = 1;

    private RecordViewModel mRecordViewModel;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
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
        });

    }
}