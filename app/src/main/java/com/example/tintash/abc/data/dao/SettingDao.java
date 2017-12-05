package com.example.tintash.abc.data.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.example.tintash.abc.data.entities.Setting;

import java.util.List;
import java.util.Set;

/**
 * Created by Tintash on 12/5/2017.
 */

@Dao
public interface SettingDao extends GenericDao<Setting> {

    @Override
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insert(Setting... setting);

    @Query("SELECT * FROM " + Setting.TABLE_NAME)
    public LiveData<List<Setting>> getSetting();
}
