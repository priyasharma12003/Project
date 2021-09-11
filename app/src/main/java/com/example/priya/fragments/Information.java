package com.example.priya.fragments;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.priya.R;

public class Information extends Dialog {
    TextView txtname,txtemail,txtpass,tvid,txtdob;
    ImageView image;
    String name,email,password,dob;
    int id;
    Bitmap mBitmap;

    public Information(@NonNull Context context,String name,String email,String password,String dob,int id,Bitmap mBitmap) {
        super(context);
        this.id=id;
        this.name=name;
        this.email=email;
        this.password=password;
        this.dob=dob;
        this.mBitmap=mBitmap;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_information);
        txtname=findViewById(R.id.display_name);
        txtemail=findViewById(R.id.display_email);
        txtpass=findViewById(R.id.display_password);
        tvid=findViewById(R.id.display_id);
        image=findViewById(R.id.display_image);
        txtdob=findViewById(R.id.display_dob);


        txtname.setText(name);
        txtemail.setText(email);
        txtpass.setText(password);
        tvid.setText(String.valueOf(id));
        txtdob.setText(dob);
        image.setImageBitmap(mBitmap);
    }

}