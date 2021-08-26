package com.example.priya;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class DataBinding extends Fragment {

    //List<DataUser> datalist;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_data_binding, container, false);
       // datalist = new ArrayList<>();
        RecyclerView recyclerView = view.findViewById(R.id.Datarecycler);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));

        /*datalist.add(new DataUser("Jhon Doe", 70, true, "https://picsum.photos/id/237/200"));
        datalist.add(new DataUser("Charles Dickens", 70, true, "https://picsum.photos/id/238/200"));
        datalist.add(new DataUser("Harry Potter", 70, false, "https://picsum.photos/id/239/200"));
        datalist.add(new DataUser("Jessica Simpson", 70, true, "https://picsum.photos/id/240/200"));
        datalist.add(new DataUser("Paul Addams", 70, false, "https://picsum.photos/id/241/200"));*/
        DataAdapter dataAdapter = new DataAdapter(getlist(), getContext());
        recyclerView.setAdapter(dataAdapter);


        return view;
    }


    private List<DataUser> getlist() {
        List<DataUser> mlist = new ArrayList<>();
        mlist.add(new DataUser("Jhon Doe", 70, true, "https://picsum.photos/id/237/200"));
        mlist.add(new DataUser("Charles Dickens", 70, true, "https://picsum.photos/id/238/200"));
        mlist.add(new DataUser("Harry Potter", 70, false, "https://picsum.photos/id/239/200"));
        mlist.add(new DataUser("Jessica Simpson", 70, true, "https://picsum.photos/id/240/200"));
        mlist.add(new DataUser("Paul Addams", 70, false, "https://picsum.photos/id/241/200"));
        return mlist;
    }

}