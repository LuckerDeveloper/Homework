package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements  DataAdapter.Listener  {

    final static String NUMBER_FRAGMENT="NUMBER_FRAGMENT";
    final static String NUMBER="NUMBER";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager;
        Fragment recycleFragment;

        if(savedInstanceState==null){
            recycleFragment= new RecycleFragment();
            fragmentManager=getSupportFragmentManager();
                        fragmentManager
                    .beginTransaction()
                    .add(R.id.container, recycleFragment)
                    .commit();
        }
    }

    @Override
    public void openNumberFragment(int number) {

        //создание фрагмента с числом
        FragmentManager fragmentManager;
        NumberFragment numberFragment;

        numberFragment= new NumberFragment();
        Bundle bundle= new Bundle();
        bundle.putInt(NUMBER, number);
        numberFragment.setArguments(bundle);

        fragmentManager=getSupportFragmentManager();
        fragmentManager
                .beginTransaction()
                .replace(R.id.container, numberFragment, NUMBER_FRAGMENT)
                .addToBackStack(null)
                .commit();
    }
}


