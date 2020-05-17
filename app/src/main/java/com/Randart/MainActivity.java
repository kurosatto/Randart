package com.Randart;

import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.Randart.fragments.CategoryFragment;
import com.Randart.fragments.FavFragment;
import com.Randart.fragments.HomeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements HomeFragment.OnFragmentInteractionListener, FavFragment.OnFragmentInteractionListener, CategoryFragment.OnFragmentInteractionListener{

  BottomNavigationView bottomNavigation;
  public static ArrayList<Art> favList = new ArrayList();
  public static ArrayList<String> IDList = new ArrayList();

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    bottomNavigation = findViewById(R.id.bottom_navigation);
    bottomNavigation.setOnNavigationItemSelectedListener(navigationItemSelectedListener);
    openFragment(HomeFragment.newInstance());

  }

  public void openFragment(Fragment fragment) {
    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
    transaction.replace(R.id.container, fragment);
    transaction.addToBackStack(null);
    transaction.commit();
  }

  BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener =
      new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override public boolean onNavigationItemSelected(@NonNull MenuItem item) {
          switch (item.getItemId()) {
            case R.id.navigation_home:
              openFragment(HomeFragment.newInstance());
              return true;
            case R.id.navigation_sms:
              openFragment(FavFragment.newInstance());
              return true;
            case R.id.navigation_notifications:
              openFragment(CategoryFragment.newInstance());
              return true;
          }
          return false;
        }
      };

  @Override
  public void onFragmentInteraction(Uri uri) {

  }
}
