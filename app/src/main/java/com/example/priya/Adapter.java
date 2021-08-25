package com.example.priya;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.priya.Activity.update;
import com.example.priya.Data.UserDatabase;
import com.example.priya.Model.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Adapter  extends RecyclerView.Adapter<Adapter.myviewHolder> implements Filterable {

    List<User> list;
    List<User> backup;
    Context mContext;
    List<User>templist;
    UserDatabase mUserDatabase;
    int idx;

    public Adapter(List<User> list,Context context) {
        this.list = list;
        this.mContext=context;
      backup=new ArrayList<>(list);

        templist=list;
        mUserDatabase=UserDatabase.getUserDatabase(context);

    }
    @Override
    public myviewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.list_item,parent,false);

        return new myviewHolder(view);
    }

    @Override
    public void onBindViewHolder(Adapter.myviewHolder holder, int position) {
        User user=list.get(position);

        holder.name.setText(user.getUsername());
        holder.email.setText(user.getEmail());
        holder.pass.setText(user.getPassword());
        holder.camera.setImageBitmap(user.getBitmap());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public Filter getFilter() {
        return filter;
    }

    Filter filter=new Filter() {
        @Override
        //background thread
        protected FilterResults performFiltering(CharSequence keyword) {
            List<User> filterdata=new ArrayList<>();

            if(keyword.toString().isEmpty())
                filterdata.addAll(backup);
            else{
                for (User ob: backup)
                    if(ob.getUsername().toString().toLowerCase().contains(keyword.toString().toLowerCase()))
                        filterdata.add(ob);
            }

            FilterResults results=new FilterResults();
            results.values=filterdata;
            return results;

        }

        @Override
        //ui thread
        protected void publishResults(CharSequence constraint, FilterResults results) {

            list.clear();
            list.addAll((Collection<? extends User>) results.values);
            notifyDataSetChanged();

        }
    };


    class myviewHolder extends RecyclerView.ViewHolder{
        TextView name,email,pass;
        Button edit;
                ImageView delete;
                ImageView camera;


        public myviewHolder( View itemView) {

            super(itemView);

            name=itemView.findViewById(R.id.name);
            email=itemView.findViewById(R.id.mail);
            pass=itemView.findViewById(R.id.passwprd1);
            edit=itemView.findViewById(R.id.edit);
            delete=itemView.findViewById(R.id.image_delete);
            camera=itemView.findViewById(R.id.imageView);



            edit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                     User usertemp=  list.get(getAdapterPosition());

                   int no= usertemp.getId();

                    Intent i = new Intent(v.getContext(), update.class);
                    i.putExtra("id",no);
                   v.getContext().startActivity(i);

                }
            });

            delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   User user=templist.get(getAdapterPosition());
                   idx=user.getId();
                   new Thread(new Runnable() {
                       @Override
                       public void run() {

                           User userob=mUserDatabase.getuserDao().getId(idx);
                           mUserDatabase.getuserDao().deleteuser(userob);

                           new Handler(Looper.getMainLooper()).post(new Runnable() {
                               @Override
                               public void run() {
                                   Toast.makeText(mContext,"User Deleted Successfully",Toast.LENGTH_LONG).show();

                               }
                           });



                         /*  list=mUserDatabase.getuserDao().getAlldata();

                           for(User user1:list)
                           {
                               int idd= user1.getId();

                               if(idd==idx){
                                   User user2=mUserDatabase.getuserDao().getId(idd);

                                   mUserDatabase.getuserDao().deleteuser(user1);

                                   new Handler(Looper.getMainLooper()).post(new Runnable() {
                                       @Override
                                       public void run() {
                                           Toast.makeText(mContext,"User Deleted Successfully",Toast.LENGTH_LONG).show();
                                       }
                                   });
                               }
                           }
                      */ }
                   }).start();
                }
            });

        }

    }
}
