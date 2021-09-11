package com.example.priya.data;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.priya.BitmapConverter;
import com.example.priya.model.User;

@TypeConverters(BitmapConverter.class)
@Database(entities = {User.class}, version = 1)
public abstract class UserDatabase extends RoomDatabase {

    public abstract UserDao getuserDao();

    private static final String dbNme="db_user";
    private static UserDatabase userDatabase;

    public static synchronized UserDatabase getUserDatabase(Context context){

        if(userDatabase==null){
            userDatabase= Room.databaseBuilder(context,UserDatabase.class,dbNme)
                    .build();

        }
        return userDatabase;


    }
   // public abstract UserDao getUserDao();


}
