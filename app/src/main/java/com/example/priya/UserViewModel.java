package com.example.priya;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.priya.Data.UserDatabase;
import com.example.priya.Model.User;

import java.util.List;

public class UserViewModel extends AndroidViewModel {
UserDatabase mUserDatabase;


    public UserViewModel( Application application) {
        super(application);
        mUserDatabase=UserDatabase.getUserDatabase(application.getApplicationContext());
    }

    public LiveData<List<User>> getAllUsers(){

        return mUserDatabase.getuserDao().findallUsers();
    }

}
