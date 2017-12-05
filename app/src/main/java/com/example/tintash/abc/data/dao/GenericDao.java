package com.example.tintash.abc.data.dao;

import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Update;

/**
 * Created by Tintash on 12/5/2017.
 */

public interface GenericDao<T> {

    @Insert
    public void insert(T... entities);

    @Delete
    public void delete(T... entities);

    @Update
    public void update(T... entities);
}
