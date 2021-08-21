package com.example.priya.Activity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.priya.Fragments.Login_page;
import com.example.priya.Fragments.Profile;
import com.example.priya.Fragments.UserList;
import com.example.priya.Fragments.signup;
import com.example.priya.R;
import com.example.priya.RetrofitFragment;

public class MainActivity extends AppCompatActivity {
    Button login, signup, user, retrofit;
    LinearLayout layout;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
//        Retrofit fourth = new Retrofit();
//        Fragment fragment = null;
//        fragment = new Retrofit();
//        getSupportFragmentManager().beginTransaction().replace(R.id.Linear, fragment).commit();
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        Profile fourth = new Profile();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.Linear, fourth);
        transaction.commit();
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = findViewById(R.id.button);
        signup = findViewById(R.id.button2);
        user = findViewById(R.id.button3);
        layout = findViewById(R.id.Linear);
        retrofit = findViewById(R.id.button4);

        Login_page first = new Login_page();
        Fragment fragment = null;
        fragment = new Login_page();
        getSupportFragmentManager().beginTransaction().replace(R.id.Linear, fragment).commit();


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Login_page first = new Login_page();
                Fragment fragment = null;
                fragment = new Login_page();
                getSupportFragmentManager().beginTransaction().replace(R.id.Linear, fragment).commit();

               /* FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.Linear,first);
                transaction.commit();*/
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                com.example.priya.Fragments.signup second = new signup();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.Linear, second);
                transaction.commit();

            }
        });

        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserList third = new UserList();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.Linear, third);
                transaction.commit();

            }
        });

        retrofit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RetrofitFragment fourth = new RetrofitFragment();
                Fragment fragment = null;
                fragment = new RetrofitFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.Linear, fragment).commit();
            }
        });
//        sign.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                User user=new User();
//                user.setUsername(fname.getText().toString());
//                user.setEmail(email.getText().toString());
//                user.setPassword(password1.getText().toString());
//                if (validateInput(user))
//                {
//                    UserDatabase userDatabase=UserDatabase.getUserDatabase(getApplicationContext());
//                    UserDao userDao=userDatabase.userDao();
//                    new Thread(new Runnable() {
//                        @Override
//                        public void run() {
//                            userDao.registeruser(user);
//                            runOnUiThread(new Runnable() {
//                                @Override
//                                public void run() {
//                                    Toast.makeText(getApplicationContext(),"User Registered",Toast.LENGTH_LONG).show();
//                                }
//                            });
//
//                        }
//                    }).start();
//                }
//                else
//                {
//                    Toast.makeText(getApplicationContext(),"FILL ALL FIELD",Toast.LENGTH_LONG).show();
//
//                }
//            }
//        });
//    }
//    public Boolean validateInput(User user){
//
//        if(user.getUsername().isEmpty() ||
//                user.getPassword().isEmpty()||
//                user.getEmail().isEmpty())
//            return false;
//        else {
//            return true;
//
//        }
//    }
    }
}