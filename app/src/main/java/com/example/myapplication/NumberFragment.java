package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class NumberFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View view= inflater.inflate(R.layout.fragment_number, container, false);

        //Получение числа
        Bundle bundle= getArguments();
        if(bundle!=null){

            TextView textViewNumber = view.findViewById(R.id.textViewNumber);

            int number=bundle.getInt(MainActivity.NUMBER);
            textViewNumber.setText(""+number);
            if(number % 2==0){
                textViewNumber.setTextColor(getResources().getColor(R.color.red));
            } else{
                textViewNumber.setTextColor(getResources().getColor(R.color.blue));
            }
        }
        return view;
    }

}
