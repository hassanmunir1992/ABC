package com.example.tintash.abc.data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.tintash.abc.data.dao.SettingDao;
import com.example.tintash.abc.data.entities.Setting;

/**
 * Created by Tintash on 12/5/2017.
 */

@Database(entities = {Setting.class},version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract SettingDao getSettingDao();
}
