package com.example.myapplication;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecycleFragment extends Fragment {

    private final static String KEY_ARRAY_LIST="KEY_ARRAY_LIST";
    private final static int SPAN_COUNT_PORTAIT=3;
    private final static int SPAN_COUNT_LANDSCAPE=4;
    ArrayList<Integer> arrayList = new ArrayList<>();
    int spanCount; //число столбцов в recyclerView


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Инициализация arrayList
        if(savedInstanceState==null){
            arrayList=getArrayList();
        } else {
            arrayList=savedInstanceState.getIntegerArrayList(KEY_ARRAY_LIST);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState ){
        View view = inflater.inflate(R.layout.fragment_recycle,container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recycle);

        //Установка числа столбцов в зависимости от ориентации экрана
        if(getResources().getConfiguration().orientation== Configuration.ORIENTATION_PORTRAIT){
            spanCount=SPAN_COUNT_PORTAIT;
        } else {
            spanCount=SPAN_COUNT_LANDSCAPE;
        }
        recyclerView.setLayoutManager(new GridLayoutManager( inflater.getContext(), spanCount) );


        final DataAdapter adapter = new DataAdapter(inflater.getContext(), arrayList);
        recyclerView.setAdapter(adapter);

        Button button=view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              arrayList.add(arrayList.size()+1);
              adapter.notifyDataSetChanged();
            }
        });
            return view;
        }

        @Override
        public void onSaveInstanceState(@NonNull Bundle outState) {
            //сохранение arrayList
            outState.putIntegerArrayList(KEY_ARRAY_LIST,arrayList);
            super.onSaveInstanceState(outState);
       }

    private ArrayList<Integer> getArrayList(){

        //создание нового ArrayList

        ArrayList<Integer> newArrayList=new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            newArrayList.add(i);
        }
        return  newArrayList;
    }

}

