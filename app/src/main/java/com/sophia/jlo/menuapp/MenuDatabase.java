package com.sophia.jlo.menuapp;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
@Database(entities = {Menu.class}, version = 1, exportSchema = false)
public abstract class MenuDatabase extends RoomDatabase {
    public static final String DB_NAME = "MENU_DATABASE";
    private static MenuDatabase object;
    public abstract MenuDao getMenuDao();
    public MenuDatabase mMenuDatabase(final Context context){
        if(object == null){
            object = Room.databaseBuilder(context, MenuDatabase.class, DB_NAME).build();

        }
        return object;
    }
}
