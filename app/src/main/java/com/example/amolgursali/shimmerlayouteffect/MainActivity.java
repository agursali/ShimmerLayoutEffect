package com.example.amolgursali.shimmerlayouteffect;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import com.cooltechworks.views.shimmer.ShimmerRecyclerView;
import com.example.amolgursali.shimmerlayouteffect.Adapter.RecyclerViewAdapter;
import com.example.amolgursali.shimmerlayouteffect.GetSet.EmpGetSet;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ShimmerRecyclerView shimmerRecyclerView;
    RecyclerView.LayoutManager linearLayout;
    ArrayList<EmpGetSet> empgetSet=new ArrayList<>();
    RecyclerViewAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        shimmerRecyclerView=(ShimmerRecyclerView)findViewById(R.id.shimmer_recycler_view);
        linearLayout=new LinearLayoutManager(getApplicationContext());
        shimmerRecyclerView.setLayoutManager(linearLayout);
        adapter=new RecyclerViewAdapter(getApplicationContext(),empgetSet);
        shimmerRecyclerView.setAdapter(adapter);
        shimmerRecyclerView.showShimmerAdapter();

        shimmerRecyclerView.postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                loadcards();
            }
        },2000);

    }

    private void loadcards()
    {
        for(int i=0;i<10;i++)
        {
            EmpGetSet e=new EmpGetSet();
            e.setEmpid("EmpID"+i);
            e.setEmpname("Name="+"Amol");
            e.setEmpmono("Mo.No="+"12345678");
            e.setEmpphoto(""+R.mipmap.ic_launcher);
            empgetSet.add(e);
        }
        shimmerRecyclerView.hideShimmerAdapter();
    }

}
