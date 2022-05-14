package com.example.tictactoe;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.ArrayList;

@Dao
public interface GameRecordDao {
    @Query("SELECT * FROM game_record ORDER BY record LIMIT 10")
    LiveData<ArrayList<GameRecord>> getTopRecords();

    @Insert
    void insertAll(GameRecord... records);
}
