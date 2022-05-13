package com.example.tictactoe;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.ArrayList;

@Dao
public interface GameRecordDao {
    @Query("SELECT * FROM gamerecord ORDER BY record LIMIT 10")
    ArrayList<GameRecord> getTopRecords();

    @Insert
    void insertAll(GameRecord... records);
}
