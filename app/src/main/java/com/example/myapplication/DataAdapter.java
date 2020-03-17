package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {

    private LayoutInflater inflater;
    private ArrayList<Integer> arrayList;
    public static Listener listener;

    DataAdapter(Context context,  ArrayList<Integer> arrayList){
        this.arrayList=arrayList;
        this.inflater= LayoutInflater.from(context);
        this.listener= (Listener) context; // интерфейс для передачи числа в MainActivity
    }

    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view=inflater.inflate(R.layout.recycle_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DataAdapter.ViewHolder holder, final int position){
        holder.textView.setText(arrayList.get(position).toString());

        //Установка цвета числа
        if (arrayList.get(position)%2==0){
            holder.textView.setTextColor(ContextCompat.getColor(inflater.getContext(), R.color.red));
        } else {
            holder.textView.setTextColor(ContextCompat.getColor(inflater.getContext(), R.color.blue));
        }

        // Обработка нажатий на число
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.openNumberFragment(arrayList.get(position));
            }
        });

    }

    @Override
    public int getItemCount(){
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView textView;

        ViewHolder( View view){
            super(view);
            textView=view.findViewById(R.id.textView);
        }

    }

    // интерфейс для передачи числа в MainActivity по нажатию
    interface Listener {
        void openNumberFragment(int number);
    }


}
