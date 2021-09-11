package com.example.priya.activity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.priya.DataBinding;
import com.example.priya.fragments.Login;
import com.example.priya.fragments.Profile;
import com.example.priya.fragments.UserList;
import com.example.priya.fragments.Signup;
import com.example.priya.R;
import com.example.priya.retrofit.RetrofitFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
   // Button login, signup, user, retrofit,databinding;
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
    public boolean onOptionsItemSelected( MenuItem item) {


        Profile fourth = new Profile();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.Linear, fourth);
        transaction.commit();

        //for multiple menues
       /* switch (item.getItemId())
{
    case  R.id.Retrofit :
        Profile fourth = new Profile();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.Linear, fourth);
        transaction.commit();
        break;
    case R.id.Search:
        UserList third = new UserList();
        FragmentTransaction trans =getSupportFragmentManager().beginTransaction();
        trans.replace(R.id.Linear, third);
        trans.commit();
        break;


}*/
        return super.onOptionsItemSelected(item);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         //with bottom navigation
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);

        Login first = new Login();
        Fragment fragment = null;
        fragment = new Login();
        getSupportFragmentManager().beginTransaction().replace(R.id.Linear, fragment).commit();
    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListener=new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(MenuItem item) {
            Fragment selectedFragment = null;
            switch (item.getItemId()) {
                case R.id.mlogin:
                    selectedFragment = new Login();
                    break;
                case R.id.msignup:
                    selectedFragment = new Signup();
                    break;
                case R.id.muserlist:
                    selectedFragment = new UserList();
                    break;
                case R.id.mretrofit:
                    selectedFragment = new RetrofitFragment();
                    break;
                case R.id.mdatabinding:
                    selectedFragment = new DataBinding();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.Linear, selectedFragment).commit();
            return  true;

        }
    };
}





















          //with buttons
        /*login = findViewById(R.id.button);
        signup = findViewById(R.id.button2);
        user = findViewById(R.id.button3);
        layout = findViewById(R.id.Linear);
        retrofit = findViewById(R.id.button4);
        databinding=findViewById(R.id.button5);

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

        databinding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               DataBinding fifth = new DataBinding();
                Fragment fragment = null;
                fragment = new DataBinding();
                getSupportFragmentManager().beginTransaction().replace(R.id.Linear, fragment).commit();
            }
        });
        */

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



