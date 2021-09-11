package com.example.priya.retrofit;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.priya.model.Model;
import com.example.priya.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RetrofitFragment extends Fragment {
    RecyclerView mRecyclerView;
    RetroAdapter adapter;
    String url = "https://jsonplaceholder.typicode.com";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_retrofit, container, false);
        mRecyclerView = view.findViewById(R.id.retro_recycler);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.addItemDecoration(new
                DividerItemDecoration(getActivity(),
                DividerItemDecoration.VERTICAL));

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //convert json data to myapi class
        myapi api = retrofit.create(myapi.class);
        //create call of model class
        //returning call of list type.
        Call<List<Model>> call = api.getmodel();

        //call gets in processing.
        //call of enqueue class and receive response data.
        call.enqueue(new Callback<List<Model>>() {
            @Override
            public void onResponse(Call<List<Model>> call, Response<List<Model>> response) {
                List<Model> data = response.body();//All the data gets in  list data.


                adapter = new RetroAdapter(getContext(), data);
                mRecyclerView.setAdapter(adapter);

                //for textview
//                for(int i=0;i<data.size();i++)
//                    tv.append("SL NO:"+data.get(i).getId()+"\n+ Title:"+data.get(i).getTitle()+"\n+ Body:"+data.get(i).getBody()+"\n\n\n");
            }

            @Override
            public void onFailure(Call<List<Model>> call, Throwable t) {

            }
        });

        return view;

    }
}