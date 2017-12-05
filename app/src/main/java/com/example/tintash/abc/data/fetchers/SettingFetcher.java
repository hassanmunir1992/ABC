package com.example.tintash.abc.data.fetchers;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.content.Context;
import android.support.annotation.Nullable;

import com.example.tintash.abc.app.App;
import com.example.tintash.abc.data.dao.SettingDao;
import com.example.tintash.abc.data.entities.Setting;
import com.example.tintash.abc.data.utils.CRUDAsyncTask;

import java.util.List;

/**
 * Created by Tintash on 12/5/2017.
 */

public class SettingFetcher  {

    private Context mContext;

    private SettingDao settingDao;

    private LifecycleOwner owner;

    public SettingFetcher(Context context) {

        mContext = context;
        this.settingDao = App.getAppDatabase().getSettingDao();
    }

    public SettingFetcher(LifecycleOwner owner, Context context) {
        this(context);
        this.owner = owner;
    }

    public LiveData<List<Setting>> getSettings() {

        final MutableLiveData<List<Setting>> mutableLiveData = new MutableLiveData<>();
        LiveData<List<Setting>> livedata = settingDao.getSetting();
        livedata.observe(owner, new Observer<List<Setting>>() {
            @Override
            public void onChanged(@Nullable List<Setting> settings) {
                if(!settings.isEmpty())
                    mutableLiveData.setValue(settings);
            }
        });

        return mutableLiveData;
    }

    public void insertSetting(Setting... settings) {

        CRUDAsyncTask<Setting> settingCRUDAsyncTask = new CRUDAsyncTask<>(this.settingDao, null, settings);
        settingCRUDAsyncTask.execute(CRUDAsyncTask.INSERT);

    }
}
