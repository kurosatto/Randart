package com.Randart;

import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    TextView title;
    ImageView url;
    TextView totaluniquepageviews;
    public ImageButton favButton;
    public ImageButton shareButton;
    private ArrayList<Art> mDataset;
    private static AdapterOnClickHandler mAdapterOnClickHandler;


    public MyAdapter(ArrayList<Art> myDataset, AdapterOnClickHandler clickHandler) {
        mDataset = myDataset;
        mAdapterOnClickHandler = clickHandler;
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public LinearLayout linearLayout;
        public MyViewHolder(LinearLayout v) {
            super(v);
            linearLayout = v;
            v.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int adapterPosition = getAdapterPosition();
            mAdapterOnClickHandler.onClick(adapterPosition);
        }
    }


    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {

        LinearLayout v = (LinearLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        title = v.findViewById(R.id.title);
        url = v.findViewById(R.id.url);
        totaluniquepageviews = v.findViewById(R.id.totaluniquepageviews);
        favButton = v.findViewById(R.id.favButton);
        shareButton = v.findViewById(R.id.shareButton);
        final MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {


        Picasso.get()
                .load(mDataset.get(position).primaryimageurl)
                .resize(1000,1000)
                .into(url );
        title.setText(mDataset.get(position).title);
        favButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!MainActivity.IDList.contains(mDataset.get(position).objectid )){
                    MainActivity.favList.add(mDataset.get(position));
                    MainActivity.IDList.add(mDataset.get(position).objectid);
                }
            }
        });

        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent();
                i.setAction(Intent.ACTION_VIEW);
                i.setData(Uri.parse(mDataset.get(position).url));
                v.getContext().startActivity(i);
            }
        });
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public interface AdapterOnClickHandler {
        // you can define the parameters to be what you need
        void onClick(int position);
    }
}
