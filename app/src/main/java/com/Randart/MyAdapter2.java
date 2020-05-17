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

public class MyAdapter2 extends RecyclerView.Adapter<MyAdapter2.MyViewHolder> {
    TextView title;
    ImageView url;
    private ArrayList<Art> mDataset;
    private static AdapterOnClickHandler mAdapterOnClickHandler;
    public ImageButton delButton;
    public ImageButton shareButton;


    public MyAdapter2(ArrayList<Art> myDataset, AdapterOnClickHandler clickHandler) {
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
    public MyAdapter2.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {

        LinearLayout v = (LinearLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item2, parent, false);
        title = v.findViewById(R.id.title2);
        url = v.findViewById(R.id.url2);
        delButton = v.findViewById(R.id.delButton);
        shareButton = v.findViewById(R.id.shareButton2);
        final MyViewHolder vh = new MyViewHolder(v);
        Log.d("test", "0");
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        Picasso.get()
                .load(mDataset.get(position).primaryimageurl)
                .resize(200,200)
                .into(url );
        title.setText(mDataset.get(position).title);
        delButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(MainActivity.IDList.contains(mDataset.get(position).objectid )){
                    int i = MainActivity.IDList.indexOf(mDataset.get(position).objectid);
                    MainActivity.favList.remove(i);
                    MainActivity.IDList.remove(i);
                    notifyItemRemoved(i);
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
