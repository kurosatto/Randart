package com.Randart.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.Randart.Art;
import com.Randart.MainActivity;
import com.Randart.MyAdapter2;
import com.Randart.R;

import java.util.ArrayList;

public class FavFragment extends Fragment implements MyAdapter2.AdapterOnClickHandler {
  private RecyclerView rv;
  private RecyclerView.Adapter mAdapter;
  private RecyclerView.LayoutManager layoutManager;
  private OnFragmentInteractionListener mListener;
  private ArrayList<Art> artList = new ArrayList();

  public FavFragment() {
  }


  public static FavFragment newInstance() {
    FavFragment fragment = new FavFragment();
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
    final View rootView = inflater.inflate(R.layout.fragment_fav, container, false);
    rv = (RecyclerView) rootView.findViewById(R.id.main_rv2);
    rv.setHasFixedSize(true);
    layoutManager = new LinearLayoutManager(getActivity());
    rv.setLayoutManager(layoutManager);

    artList = MainActivity.favList;

    mAdapter = new MyAdapter2(artList, this);
    rv.setAdapter(mAdapter);

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
