package com.example.priya;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.priya.Model.model;

import java.util.List;

public class RetroAdapter extends RecyclerView.Adapter<RetroAdapter.myviewholder> {
    Context mContext;
    List<model> mModelList;

    public RetroAdapter(Context context, List<model> modelList) {
        mContext = context;
        mModelList = modelList;
    }

    @Override
    public myviewholder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(mContext).inflate(R.layout.retrofitlist,parent,false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(myviewholder holder, int position) {
        model model=mModelList.get(position);
        holder.id.setText(String.valueOf(model.getId()));
        holder.title.setText(model.getTitle());
        holder.description.setText(model.getBody());

    }

    @Override
    public int getItemCount() {
        return mModelList.size();
    }

    class myviewholder extends RecyclerView.ViewHolder{
        TextView id,title,description;
        public myviewholder(View itemView) {
            super(itemView);
            id=itemView.findViewById(R.id.rid);
            title=itemView.findViewById(R.id.rtitle);
            description=itemView.findViewById(R.id.rdesc);
        }
    }
}
