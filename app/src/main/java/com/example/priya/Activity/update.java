package com.example.priya.Activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.priya.Data.UserDatabase;
import com.example.priya.Model.User;
import com.example.priya.R;

public class update extends AppCompatActivity {

    EditText name, lastname, email, psswd;
    Button update_btn;
    UserDatabase mUserDatabase;
    int idno;
    int id;
    SharedPreferences mSharedPreferences;
    SharedPreferences.Editor mEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        name = findViewById(R.id.update_name);
        lastname = findViewById(R.id.update_last);
        email = findViewById(R.id.update_mail);
        psswd = findViewById(R.id.update_password);
        update_btn = findViewById(R.id.update_btn);

        id = getIntent().getIntExtra("id", 0);
        mSharedPreferences= PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        idno= mSharedPreferences.getInt("id",id);
        mEditor=mSharedPreferences.edit();
        if(id!=idno) {
            update_btn.setVisibility(View.GONE);
        }
        else {
            mUserDatabase = UserDatabase.getUserDatabase(this);
            update_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    new Thread(new Runnable() {
                        @Override
                        public void run() {

                            User user = mUserDatabase.getuserDao().getId(id);
                            user.setUsername(name.getText().toString());
                            user.setLastname(lastname.getText().toString());
                            user.setEmail(email.getText().toString());
                            user.setPassword(psswd.getText().toString());

                            mUserDatabase.getuserDao().updateuser(user);


                        }
                    }).start();

                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(), "Updated Successfully", Toast.LENGTH_LONG).show();
                        }
                    });
                    finish();
                }
            });
        }

    }
}


//        list=mUserDatabase.getuserDao().getAlldata();
//        for(User ob: list){
//            if(idno==ob.getId())
//            {
//            name=ob.getUsername();
//            email=ob.getEmail();
//        }


//        mUserDatabase.getuserDao().getId(id);
//        mUserDatabase.getuserDao().updateuser();
