package com.example.responsi0669.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UserDao {
    @Query("SELECT * FROM user")
    List<User> getAll();

    @Query("SELECT * FROM user WHERE email=:email")
    User findByEmail(String email);

    @Insert
    void insertAll(User user);

    @Update
    public void update(User user);

    @Delete
    public void deleteUser(User user);
}
