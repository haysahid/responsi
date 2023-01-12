package com.example.responsi0669.room;

import android.app.Application;

import androidx.room.Room;

public class AppApplication extends Application {
    public static AppDatabase db;

    @Override
    public void onCreate() {
        super.onCreate();
        db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "user").allowMainThreadQueries().build();
    }
}
