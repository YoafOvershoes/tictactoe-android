package com.example.tictactoe;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.ArrayList;
import java.util.List;

public class RecordViewModel extends AndroidViewModel {
    private RecordRepository mRepository;
    private final LiveData<List<GameRecord>> mTopRecords;


    public RecordViewModel(Application application) {
        super(application);
        mRepository = new RecordRepository(application);
        mTopRecords = mRepository.getTopRecords();
    }

    LiveData<List<GameRecord>> getTopRecords() {return mTopRecords;}
    public void insert(GameRecord gameRecord) {mRepository.insert(gameRecord);}
}
