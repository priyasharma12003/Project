package com.example.priya.Fragments;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.priya.Data.UserDatabase;
import com.example.priya.Model.User;
import com.example.priya.R;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class signup extends Fragment {
    EditText fname, lname, email, password1, cpass,date;
    Button sign;
    UserDatabase mUserDatabase;
    ImageView camera;
    Bitmap bitmap;
int year,day,month;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_signup, container, false);

        bitmap= BitmapFactory.decodeResource(getResources(),R.drawable.logo);

        fname = view.findViewById(R.id.name);
        lname = view.findViewById(R.id.last);
        email = view.findViewById(R.id.mail);
        password1 = view.findViewById(R.id.password);
        cpass = view.findViewById(R.id.confirm_password);
        sign = view.findViewById(R.id.sign);
        camera = view.findViewById(R.id.camera);
        date=view.findViewById(R.id.dp);




        mUserDatabase = UserDatabase.getUserDatabase(getContext());
//       mUserDatabase= Room.databaseBuilder(getContext(),UserDatabase.class,"db_users").build();
        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textname = fname.getText().toString();
                String textlast = lname.getText().toString();
                String textpass = password1.getText().toString();
                String textemail = email.getText().toString();

                if (textname.isEmpty()
                        && textemail.isEmpty()
                        && textlast.isEmpty()
                        && textpass.isEmpty())
                    Toast.makeText(getContext(), "Fill out Fields.", Toast.LENGTH_LONG).show();
                else

                    new Thread(new Runnable() {
                        @Override
                        public void run() {

                            User user = new User(textname, textpass, textemail, textlast);
                            user.setBitmap(bitmap);
                            //insert the record.
                            mUserDatabase.getuserDao().registeruser(user);
                            new Handler(Looper.getMainLooper()).post(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(getContext(), "Registered!", Toast.LENGTH_SHORT).show();
                                }
                            });

                        }
                    }).start();

            }
        });

        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent intent=new Intent((MediaStore.ACTION_IMAGE_CAPTURE);
                // startActivityForResult(intent,100);
                selectimage();
            }
        });

//        Calendar calendar = new Calendar.getInstance();
        Calendar calendar=Calendar.getInstance();

        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
        year=calendar.get(Calendar.YEAR);
        month=calendar.get(Calendar.MONTH);
        day=calendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog=new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        calendar.set(Calendar.YEAR,year);
                        calendar.set(Calendar.MONTH,month);
                        calendar.set(Calendar.DAY_OF_MONTH,dayOfMonth);
//                        date.setText(SimpleDateFormat.getDateInstance().format(calendar.getTime()));
                        date.setText(SimpleDateFormat.getDateInstance().format(calendar.getTime()));

                    }
                },year,month,day);
                datePickerDialog.show();
            }
        });


        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
         //for camera:
        // bitmap=(Bitmap)data.getExtras().get("data");
        // camera.setImageBitmap(bitmap);

        if (requestCode == 1001) {
            //path of file image
            Uri uri = data.getData();

            try {
                //converting image to bitmap.
                bitmap = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), uri);
                camera.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }


        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    public void selectimage() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, 1001);

    }


}








































  /*
    public Boolean validateInput(User user)
    {

        if (user.getUsername().isEmpty() ||
                user.getPassword().isEmpty() ||
                user.getEmail().isEmpty())
            return false;
        else
            return true;


    }

    */