package com.example.priya.fragments;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.priya.R;
import com.example.priya.data.UserDatabase;
import com.example.priya.model.User;

public class Login extends Fragment {
    private EditText name;
    private EditText password;
   private Button login1;
   private TextView forgot;
//   List<User> list;
    UserDatabase mUserDatabase;
    String username, passwordtxt;
    SharedPreferences mSharedPreferences;
    SharedPreferences.Editor mEditor;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login_page, container, false);
        mUserDatabase = UserDatabase.getUserDatabase(getContext());
        mSharedPreferences= PreferenceManager.getDefaultSharedPreferences(getContext());
        mEditor=mSharedPreferences.edit();
//       mUserDatabase= Room.databaseBuilder(getContext(),UserDatabase.class,"db_users").build();
       // list = new ArrayList<>();
        name = view.findViewById(R.id.username);
        password = view.findViewById(R.id.pass);
        login1 = view.findViewById(R.id.login1);
        forgot=view.findViewById(R.id.fpass);



        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ForgotPassword dialog=new ForgotPassword(getContext());
                //dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.BLACK));
                dialog.show();
            }
        });


        login1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = name.getText().toString();
                passwordtxt = password.getText().toString();

                if(username.isEmpty() && passwordtxt.isEmpty()) {
                    name.setError("Required");
                    password.setError("Required");
                    Toast.makeText(getContext(), "Fill All Field", Toast.LENGTH_LONG).show();
                }
                else {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            //list = mUserDatabase.getuserDao().getAlldata();

                              User user=  mUserDatabase.getuserDao().login(username,passwordtxt);

                             //  if(!user==null){
                            if (user.getUsername().equals(username) && user.getPassword().equals(passwordtxt)) {
                                new Handler(Looper.getMainLooper()).post(new Runnable() {
                                    @Override
                                    public void run() {
                                        mEditor.putString("logged_user", user.getUsername());
                                        mEditor.putString("logged_email", user.getEmail());
                                        mEditor.putInt("id",user.getId());
                                        mEditor.apply();
                                        Toast.makeText(getContext(), "logged in with : " + user.getUsername(), Toast.LENGTH_SHORT).show();
                                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.Linear, new Profile()).commit();
                                    }
                                });
                            }
                            else{

                            }














                            /*for (User user : list) {
                                if (user.getUsername().equals(username) && user.getPassword().equals(passwordtxt)) {
                                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                                        @Override
                                        public void run() {
                                            Toast.makeText(getContext(), user.getUsername(), Toast.LENGTH_SHORT).show();
                                        }
                                    });
                                }
//                                else

//                                    Toast.makeText(getContext(),"Invalid credentials",Toast.LENGTH_LONG).show();

                            }*/

                        }
                    }).start();

                }

            }

        });


        return view;

    }



}
