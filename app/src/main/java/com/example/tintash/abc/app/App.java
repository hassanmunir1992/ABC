package com.example.tintash.abc.app;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.example.tintash.abc.data.AppDatabase;

/**
 * Created by Tintash on 12/2/2017.
 */

public class App extends Application {

    public static App instance = null;

    private static AppDatabase appDatabase = null;

    @Override
    public void onCreate() {
        super.onCreate();
        App.instance = this;
        getAppDatabase();
    }

    public static synchronized App getInstance() {
        return App.instance;
    }

    public static AppDatabase getAppDatabase() {
        if (App.appDatabase == null) {
            App.appDatabase = Room.databaseBuilder(App.getInstance().getApplicationContext(), AppDatabase.class, "ABC.db")
                    .build();
        }
        return App.appDatabase;

    }
}
