package com.Randart.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.Randart.Art;
import com.Randart.MyAdapter3;
import com.Randart.R;
import com.Randart.Record;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import org.jetbrains.annotations.NotNull;
import java.io.IOException;
import java.util.ArrayList;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class CategoryFragment extends Fragment implements MyAdapter3.AdapterOnClickHandler {
  private RecyclerView rv;
  private RecyclerView.Adapter mAdapter;
  private RecyclerView.LayoutManager layoutManager;
  private OnFragmentInteractionListener mListener;
  private Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12;
  public CategoryFragment() {
  }


  public static CategoryFragment newInstance() {
    CategoryFragment fragment = new CategoryFragment();
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
    final View rootView = inflater.inflate(R.layout.fragment_category, container, false);
    b1 = rootView.findViewById(R.id.button);
    b2 = rootView.findViewById(R.id.button2);
    b3 = rootView.findViewById(R.id.button3);

    rv = (RecyclerView) rootView.findViewById(R.id.main_rv3);
    rv.setHasFixedSize(true);
    layoutManager = new LinearLayoutManager(getActivity());
    rv.setLayoutManager(layoutManager);
    final String id = "a24b63c0-97a1-11ea-b217-c12cbfb1b504";
    final OkHttpClient client = new OkHttpClient();
    HttpUrl.Builder urlBuilder = HttpUrl.parse("https://api.harvardartmuseums.org/object?").newBuilder();
    urlBuilder.addQueryParameter("sort", "random");
    urlBuilder.addQueryParameter("hasimage", "1");
    //urlBuilder.addQueryParameter("category", "Greek");
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
              rv = rootView.findViewById(R.id.main_rv3);
              mAdapter = new MyAdapter3(body, CategoryFragment.this);
              rv.setAdapter(mAdapter);
            }
          });
        }
      }
    });
    b1.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        rv = (RecyclerView) rootView.findViewById(R.id.main_rv3);
        rv.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(layoutManager);
        final String id = "a24b63c0-97a1-11ea-b217-c12cbfb1b504";
        final OkHttpClient client = new OkHttpClient();
        HttpUrl.Builder urlBuilder = HttpUrl.parse("https://api.harvardartmuseums.org/object?").newBuilder();
        urlBuilder.addQueryParameter("sort", "random");
        urlBuilder.addQueryParameter("hasimage", "1");
        urlBuilder.addQueryParameter("culture", "Greek");
        urlBuilder.addQueryParameter("apikey", id);
        String url = urlBuilder.build().toString();
        Log.d("test", urlBuilder.build().toString());
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
                  rv = rootView.findViewById(R.id.main_rv3);
                  mAdapter = new MyAdapter3(body, CategoryFragment.this);
                  rv.setAdapter(mAdapter);
                }
              });
            }
          }
        });

      }
    });
    b2 = rootView.findViewById(R.id.button2);
    b2.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        rv = (RecyclerView) rootView.findViewById(R.id.main_rv3);
        rv.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(layoutManager);
        final String id = "a24b63c0-97a1-11ea-b217-c12cbfb1b504";
        final OkHttpClient client = new OkHttpClient();
        HttpUrl.Builder urlBuilder = HttpUrl.parse("https://api.harvardartmuseums.org/object?").newBuilder();
        urlBuilder.addQueryParameter("sort", "random");
        urlBuilder.addQueryParameter("hasimage", "1");
        urlBuilder.addQueryParameter("culture", "Roman");
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
                  rv = rootView.findViewById(R.id.main_rv3);
                  mAdapter = new MyAdapter3(body, CategoryFragment.this);
                  rv.setAdapter(mAdapter);
                }
              });
            }
          }
        });

      }
    });
    b3 = rootView.findViewById(R.id.button3);
    b3.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        rv = (RecyclerView) rootView.findViewById(R.id.main_rv3);
        rv.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(layoutManager);
        final String id = "a24b63c0-97a1-11ea-b217-c12cbfb1b504";
        final OkHttpClient client = new OkHttpClient();
        HttpUrl.Builder urlBuilder = HttpUrl.parse("https://api.harvardartmuseums.org/object?").newBuilder();
        urlBuilder.addQueryParameter("sort", "random");
        urlBuilder.addQueryParameter("hasimage", "1");
        urlBuilder.addQueryParameter("culture", "Persian");
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
                  rv = rootView.findViewById(R.id.main_rv3);
                  mAdapter = new MyAdapter3(body, CategoryFragment.this);
                  rv.setAdapter(mAdapter);
                }
              });
            }
          }
        });

      }
    });

    b4 = rootView.findViewById(R.id.button4);
    b4.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        rv = (RecyclerView) rootView.findViewById(R.id.main_rv3);
        rv.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(layoutManager);
        final String id = "a24b63c0-97a1-11ea-b217-c12cbfb1b504";
        final OkHttpClient client = new OkHttpClient();
        HttpUrl.Builder urlBuilder = HttpUrl.parse("https://api.harvardartmuseums.org/object?").newBuilder();
        urlBuilder.addQueryParameter("sort", "random");
        urlBuilder.addQueryParameter("hasimage", "1");
        urlBuilder.addQueryParameter("culture", "Byzantine");
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
                  rv = rootView.findViewById(R.id.main_rv3);
                  mAdapter = new MyAdapter3(body, CategoryFragment.this);
                  rv.setAdapter(mAdapter);
                }
              });
            }
          }
        });

      }
    });

    b5 = rootView.findViewById(R.id.button5);
    b5.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        rv = (RecyclerView) rootView.findViewById(R.id.main_rv3);
        rv.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(layoutManager);
        final String id = "a24b63c0-97a1-11ea-b217-c12cbfb1b504";
        final OkHttpClient client = new OkHttpClient();
        HttpUrl.Builder urlBuilder = HttpUrl.parse("https://api.harvardartmuseums.org/object?").newBuilder();
        urlBuilder.addQueryParameter("sort", "random");
        urlBuilder.addQueryParameter("hasimage", "1");
        urlBuilder.addQueryParameter("culture", "Chinese");
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
                  rv = rootView.findViewById(R.id.main_rv3);
                  mAdapter = new MyAdapter3(body, CategoryFragment.this);
                  rv.setAdapter(mAdapter);
                }
              });
            }
          }
        });

      }
    });

    b6 = rootView.findViewById(R.id.button6);
    b6.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        rv = (RecyclerView) rootView.findViewById(R.id.main_rv3);
        rv.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(layoutManager);
        final String id = "a24b63c0-97a1-11ea-b217-c12cbfb1b504";
        final OkHttpClient client = new OkHttpClient();
        HttpUrl.Builder urlBuilder = HttpUrl.parse("https://api.harvardartmuseums.org/object?").newBuilder();
        urlBuilder.addQueryParameter("sort", "random");
        urlBuilder.addQueryParameter("hasimage", "1");
        urlBuilder.addQueryParameter("culture", "Japanese");
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
                  rv = rootView.findViewById(R.id.main_rv3);
                  mAdapter = new MyAdapter3(body, CategoryFragment.this);
                  rv.setAdapter(mAdapter);
                }
              });
            }
          }
        });

      }
    });

    b7 = rootView.findViewById(R.id.button7);
    b7.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        rv = (RecyclerView) rootView.findViewById(R.id.main_rv3);
        rv.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(layoutManager);
        final String id = "a24b63c0-97a1-11ea-b217-c12cbfb1b504";
        final OkHttpClient client = new OkHttpClient();
        HttpUrl.Builder urlBuilder = HttpUrl.parse("https://api.harvardartmuseums.org/object?").newBuilder();
        urlBuilder.addQueryParameter("sort", "random");
        urlBuilder.addQueryParameter("hasimage", "1");
        urlBuilder.addQueryParameter("culture", "Korean");
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
                  rv = rootView.findViewById(R.id.main_rv3);
                  mAdapter = new MyAdapter3(body, CategoryFragment.this);
                  rv.setAdapter(mAdapter);
                }
              });
            }
          }
        });

      }
    });

    b8 = rootView.findViewById(R.id.button8);
    b8.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        rv = (RecyclerView) rootView.findViewById(R.id.main_rv3);
        rv.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(layoutManager);
        final String id = "a24b63c0-97a1-11ea-b217-c12cbfb1b504";
        final OkHttpClient client = new OkHttpClient();
        HttpUrl.Builder urlBuilder = HttpUrl.parse("https://api.harvardartmuseums.org/object?").newBuilder();
        urlBuilder.addQueryParameter("sort", "random");
        urlBuilder.addQueryParameter("hasimage", "1");
        urlBuilder.addQueryParameter("culture", "Indian");
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
                  rv = rootView.findViewById(R.id.main_rv3);
                  mAdapter = new MyAdapter3(body, CategoryFragment.this);
                  rv.setAdapter(mAdapter);
                }
              });
            }
          }
        });

      }
    });

    b9 = rootView.findViewById(R.id.button9);
    b9.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        rv = (RecyclerView) rootView.findViewById(R.id.main_rv3);
        rv.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(layoutManager);
        final String id = "a24b63c0-97a1-11ea-b217-c12cbfb1b504";
        final OkHttpClient client = new OkHttpClient();
        HttpUrl.Builder urlBuilder = HttpUrl.parse("https://api.harvardartmuseums.org/object?").newBuilder();
        urlBuilder.addQueryParameter("sort", "random");
        urlBuilder.addQueryParameter("hasimage", "1");
        urlBuilder.addQueryParameter("culture", "British");
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
                  rv = rootView.findViewById(R.id.main_rv3);
                  mAdapter = new MyAdapter3(body, CategoryFragment.this);
                  rv.setAdapter(mAdapter);
                }
              });
            }
          }
        });

      }
    });

    b10 = rootView.findViewById(R.id.button10);
    b10.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        rv = (RecyclerView) rootView.findViewById(R.id.main_rv3);
        rv.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(layoutManager);
        final String id = "a24b63c0-97a1-11ea-b217-c12cbfb1b504";
        final OkHttpClient client = new OkHttpClient();
        HttpUrl.Builder urlBuilder = HttpUrl.parse("https://api.harvardartmuseums.org/object?").newBuilder();
        urlBuilder.addQueryParameter("sort", "random");
        urlBuilder.addQueryParameter("hasimage", "1");
        urlBuilder.addQueryParameter("culture", "French");
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
                  rv = rootView.findViewById(R.id.main_rv3);
                  mAdapter = new MyAdapter3(body, CategoryFragment.this);
                  rv.setAdapter(mAdapter);
                }
              });
            }
          }
        });

      }
    });

    b11 = rootView.findViewById(R.id.button11);
    b11.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        rv = (RecyclerView) rootView.findViewById(R.id.main_rv3);
        rv.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(layoutManager);
        final String id = "a24b63c0-97a1-11ea-b217-c12cbfb1b504";
        final OkHttpClient client = new OkHttpClient();
        HttpUrl.Builder urlBuilder = HttpUrl.parse("https://api.harvardartmuseums.org/object?").newBuilder();
        urlBuilder.addQueryParameter("sort", "random");
        urlBuilder.addQueryParameter("hasimage", "1");
        urlBuilder.addQueryParameter("culture", "German");
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
                  rv = rootView.findViewById(R.id.main_rv3);
                  mAdapter = new MyAdapter3(body, CategoryFragment.this);
                  rv.setAdapter(mAdapter);
                }
              });
            }
          }
        });

      }
    });

    b12 = rootView.findViewById(R.id.button12);
    b12.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        rv = (RecyclerView) rootView.findViewById(R.id.main_rv3);
        rv.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(layoutManager);
        final String id = "a24b63c0-97a1-11ea-b217-c12cbfb1b504";
        final OkHttpClient client = new OkHttpClient();
        HttpUrl.Builder urlBuilder = HttpUrl.parse("https://api.harvardartmuseums.org/object?").newBuilder();
        urlBuilder.addQueryParameter("sort", "random");
        urlBuilder.addQueryParameter("hasimage", "1");
        urlBuilder.addQueryParameter("culture", "Flemish");
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
                  rv = rootView.findViewById(R.id.main_rv3);
                  mAdapter = new MyAdapter3(body, CategoryFragment.this);
                  rv.setAdapter(mAdapter);
                }
              });
            }
          }
        });

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
