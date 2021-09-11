package com.example.priya.fragments;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.priya.R;
import com.example.priya.data.UserDao;
import com.example.priya.data.UserDatabase;
import com.example.priya.model.User;

public class ForgotPassword extends Dialog {
    String email, pass;
    Button update;
    UserDao database;
    Context mContext;

    public ForgotPassword(Context context) {
        super(context);
        this.mContext = context;
    }

    TextView txtnew, txtpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_forgot_password);
        txtnew = findViewById(R.id.email);
        txtpass = findViewById(R.id.cpass);
        update = findViewById(R.id.fupdate);

        // email=txtnew.getText().toString();
        // pass = txtpass.getText().toString();


        database = UserDatabase.getUserDatabase(mContext).getuserDao();

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {

                        User ob = database.checkEmail(txtnew.getText().toString());
                        if (ob != null) {
                            ob.setPassword(txtpass.getText().toString());
                            //ob.setPassword(pass);
                            database.updateuser(ob);
                            new Handler(Looper.getMainLooper()).post(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(mContext, "Password Updated!", Toast.LENGTH_SHORT).show();
                                }
                            });

                        } else {
                            new Handler(Looper.getMainLooper()).post(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(mContext, "Enter Valid Email!", Toast.LENGTH_SHORT).show();
                                }
                            });


                        }
                    }
                }).start();
            }
        });

    }
}