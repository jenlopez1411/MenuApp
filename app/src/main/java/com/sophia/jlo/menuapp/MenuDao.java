package com.sophia.jlo.menuapp;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface MenuDao {
    @Insert
    void insert(Menu menu);

    @Update
    void update(Menu menu);

    @Delete
    void delete(Menu menu);

    @Query("DELETE FROM menu_table")
    void deleteAllMenu();

    @Query("SELECT * FROM menu_table ORDER BY id ASC")
    List<Menu> getAllMenu();
}
