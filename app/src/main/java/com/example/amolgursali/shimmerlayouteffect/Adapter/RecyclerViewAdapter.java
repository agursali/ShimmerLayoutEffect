package com.example.amolgursali.shimmerlayouteffect.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.cooltechworks.views.shimmer.ShimmerAdapter;
import com.example.amolgursali.shimmerlayouteffect.GetSet.EmpGetSet;
import com.example.amolgursali.shimmerlayouteffect.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by AmolGursali on 7/13/2017.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder>
{

    Context context;
    ArrayList<EmpGetSet> empgetSet=new ArrayList<>();
    public RecyclerViewAdapter(Context context, ArrayList<EmpGetSet> empgetSet)
    {
        this.context=context;
        this.empgetSet=empgetSet;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View v;
        v= LayoutInflater.from(context).inflate(R.layout.cards,parent,false);
        RecyclerViewHolder h=new RecyclerViewHolder(v);
        return h;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position)
    {
         holder.empid.setText(empgetSet.get(position).getEmpid());
         holder.empname.setText(empgetSet.get(position).getEmpname());
         holder.empmono.setText(empgetSet.get(position).getEmpmono());
         Picasso.with(context).load(empgetSet.get(position).getEmpphoto()).error(R.mipmap.ic_launcher).into(holder.img);
    }


    @Override
    public int getItemCount()
    {
        return empgetSet.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder
    {

        public TextView empid,empname,empmono;
        public ImageView img;
        public RecyclerViewHolder(View itemView)
        {
            super(itemView);
            empid=(TextView)itemView.findViewById(R.id.empid);
            empname=(TextView)itemView.findViewById(R.id.empname);
            empmono=(TextView)itemView.findViewById(R.id.empmono);
            img=(ImageView)itemView.findViewById(R.id.img);

        }
    }
}
