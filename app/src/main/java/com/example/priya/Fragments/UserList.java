package com.example.priya.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.priya.Adapter;
import com.example.priya.Model.User;
import com.example.priya.R;
import com.example.priya.UserViewModel;

import java.util.List;

public class UserList extends Fragment {

   RecyclerView mrecyclerview;
Adapter mAdapter;
UserViewModel mUserViewModel;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user_list, container, false);

        mrecyclerview=view.findViewById(R.id.Rv);
      mrecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        mrecyclerview.addItemDecoration(new
                DividerItemDecoration(getActivity(),
                DividerItemDecoration.VERTICAL));




        mUserViewModel= ViewModelProviders.of(this).get(UserViewModel.class);

        mUserViewModel.getAllUsers().observe(getActivity(), new Observer<List<User>>() {
            @Override
            public void onChanged(List<User> users) {

                mAdapter=new Adapter(users,getContext());
                mrecyclerview.setAdapter(mAdapter);

            }
        });



        return view;
    }

    }