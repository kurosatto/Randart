package com.Randart.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.Randart.Art;
import com.Randart.MyAdapter;
import com.Randart.R;
import java.io.IOException;
import java.util.ArrayList;
import com.Randart.Record;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import org.jetbrains.annotations.NotNull;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class HomeFragment extends Fragment implements MyAdapter.AdapterOnClickHandler {
  private RecyclerView rv;
  private RecyclerView.Adapter mAdapter;
  private RecyclerView.LayoutManager layoutManager;
  private OnFragmentInteractionListener mListener;

  public HomeFragment() {
  }


  public static HomeFragment newInstance() {
    HomeFragment fragment = new HomeFragment();
    Bundle args = new Bundle();
    fragment.setArguments(args);
    return fragment;
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    final View rootView = inflater.inflate(R.layout.fragment_home, container, false);
    rv = (RecyclerView) rootView.findViewById(R.id.main_rv);
    rv.setHasFixedSize(true);
    layoutManager = new LinearLayoutManager(getActivity());
    rv.setLayoutManager(layoutManager);

    String id = "a24b63c0-97a1-11ea-b217-c12cbfb1b504";
    OkHttpClient client = new OkHttpClient();
    HttpUrl.Builder urlBuilder = HttpUrl.parse("https://api.harvardartmuseums.org/object?").newBuilder();
    urlBuilder.addQueryParameter("sort", "random");
    urlBuilder.addQueryParameter("hasimage", "1");
    urlBuilder.addQueryParameter("apikey", id);
    String url = urlBuilder.build().toString();
    Request request = new Request.Builder().url(url).build();
    client.newCall(request).enqueue(new Callback() {
      @Override
      public void onFailure(@NotNull Call call, @NotNull IOException e) {
        e.printStackTrace();
      }
      @Override
      public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
        if(!response.isSuccessful()){
          throw new IOException("Unexpected Code" + response);
        }else{
          Moshi moshi = new Moshi.Builder().build();
          JsonAdapter<Record> jsonAdapter = moshi.adapter(Record.class);
          Record record = jsonAdapter.fromJson(response.body().string());
          final ArrayList<Art> body = (ArrayList) record.records;

          getActivity().runOnUiThread(new Runnable() {
           @Override
            public void run() {
              rv = rootView.findViewById(R.id.main_rv);
              mAdapter = new MyAdapter(body, HomeFragment.this);
              rv.setAdapter(mAdapter);
            }
          });
        }
      }
    });
    return rootView;
  }

  public void onButtonPressed(Uri uri) {
    if (mListener != null) {
      mListener.onFragmentInteraction(uri);
    }
  }

  @Override
  public void onAttach(Context context) {
    super.onAttach(context);
    if (context instanceof OnFragmentInteractionListener) {
      mListener = (OnFragmentInteractionListener) context;
    } else {
      throw new RuntimeException(context.toString()
              + " must implement OnFragmentInteractionListener");
    }
  }

  @Override
  public void onDetach() {
    super.onDetach();
    mListener = null;
  }


  public interface OnFragmentInteractionListener {
    void onFragmentInteraction(Uri uri);
  }



  @Override
  public void onClick(int position) {

  }
}
