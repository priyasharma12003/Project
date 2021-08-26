package com.example.priya;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.example.priya.databinding.DataItemBinding;

import java.util.List;

public class DataAdapter extends RecyclerView.Adapter <DataAdapter.viewholder>
{
    List<DataUser>mlist;
    Context mContext;

    public DataAdapter(List<DataUser> mlist, Context context) {
        this.mlist = mlist;
        mContext = context;
    }

    @Override
    public viewholder onCreateViewHolder( ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(mContext);
       DataItemBinding dataItemBinding=DataItemBinding.inflate(layoutInflater,parent,false);
       return new viewholder(dataItemBinding);


    }

    @Override
    public void onBindViewHolder(DataAdapter.viewholder holder, int position) {

        DataUser user=mlist.get(position);
        holder.mDataItemBinding.setUser(user);
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    class viewholder extends RecyclerView.ViewHolder{
        DataItemBinding mDataItemBinding;

        public viewholder(DataItemBinding dataItemBinding) {
            super(dataItemBinding.getRoot());
            this.mDataItemBinding=dataItemBinding;


        }
    }
}
