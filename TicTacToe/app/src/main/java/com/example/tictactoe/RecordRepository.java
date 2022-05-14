package com.example.tictactoe;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class RecordRepository {
    private GameRecordDao recordDao;
    private LiveData<List<GameRecord>> mAllRecords;

    // Note that in order to unit test the WordRepository, you have to remove the Application
    // dependency. This adds complexity and much more code, and this sample is not about testing.
    // See the BasicSample in the android-architecture-components repository at
    // https://github.com/googlesamples
    RecordRepository(Application application) {
        AppDatabase db = AppDatabase.getDatabase(application);
        recordDao = db.gameRecordDao();
        mAllRecords = recordDao.getTopRecords();
    }

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    LiveData<List<GameRecord>> getTopRecords() {
        return mAllRecords;
    }

    // You must call this on a non-UI thread or your app will throw an exception. Room ensures
    // that you're not doing any long running operations on the main thread, blocking the UI.
    void insert(GameRecord gameRecord) {
        AppDatabase.databaseWriteExecutor.execute(() -> {
            recordDao.insert(gameRecord);
        });
    }
}
