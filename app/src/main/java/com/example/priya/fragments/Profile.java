package com.example.priya.fragments;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.priya.data.UserDao;
import com.example.priya.data.UserDatabase;
import com.example.priya.R;

public class Profile extends Fragment {
TextView p_name,p_email;
Button logout;
UserDao database;
SharedPreferences mSharedPreferences;
SharedPreferences.Editor mEditor;
Bitmap mBitmap;
int id;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_profile, container, false);

        p_name=view.findViewById(R.id.Profile_name);
        p_email=view.findViewById(R.id.Profile_Email);
        logout=view.findViewById(R.id.logout);
        ImageView imageView=view.findViewById(R.id.Profile_image);
        database=UserDatabase.getUserDatabase(getContext()).getuserDao();

        mSharedPreferences= PreferenceManager.getDefaultSharedPreferences(getContext());
        id= mSharedPreferences.getInt("id",id);
        mEditor=mSharedPreferences.edit();

//storing image
        new Thread(new Runnable() {
            @Override
            public void run() {
                mBitmap=database.getProfileImg(id);
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                   imageView.setImageBitmap(mBitmap);
                    }
                });
            }
        }).start();


        String usernametxt=mSharedPreferences.getString("logged_user",null);
        String emailtxt=mSharedPreferences.getString("logged_email",null);

        p_name.setText(usernametxt);
        p_email.setText(emailtxt);



        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* SessionManagement sessionManagement=new SessionManagement(getContext());
                sessionManagement.removeSession();
                movetologin();*/



                mEditor.clear();
                mEditor.apply();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.Linear,new Login()).commit();

            }
        });
                return view;
    }
}
