package com.example.priya;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.priya.model.User;

public class SessionManagement {
    SharedPreferences mSharedPreference;
    SharedPreferences.Editor mEditor;
    String SHARED_PREF_NAME = "session";
    String SESSION_key="session_user";
    String KEY_NAME="name";
String KEY_EMAIL="email";

    public SessionManagement(Context context) {

        //mSharedPreference= PreferenceManager.getDefaultSharedPreferences(context);
        mSharedPreference = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        mEditor = mSharedPreference.edit();
       String str= mSharedPreference.getString(KEY_EMAIL,"");
    }
    public void SaveSession(User user){
        int id=user.getId();
        String name=user.getUsername();
        String email=user.getEmail();
        mEditor.putString(KEY_NAME,name);
        mEditor.putString(KEY_EMAIL,email);
        mEditor.putInt(SESSION_key,id);
        mEditor.apply();

    }

    public int getSession()
    {
        return mSharedPreference.getInt(SESSION_key,-1);
    }
    public void removeSession(){
        mEditor.putInt(SESSION_key,-1);

    }

}