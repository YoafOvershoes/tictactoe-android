package com.example.tictactoe;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface GameRecordDao {
    @Query("SELECT * FROM game_record ORDER BY record LIMIT 10")
    LiveData<List<GameRecord>> getTopRecords();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertAll(GameRecord... records);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(GameRecord record);

    @Query("DELETE FROM game_record")
    void deleteAll();
}
