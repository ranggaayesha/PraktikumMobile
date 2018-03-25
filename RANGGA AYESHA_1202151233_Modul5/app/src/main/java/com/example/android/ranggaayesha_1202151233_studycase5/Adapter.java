package com.example.android.ranggaayesha_1202151233_studycase5;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by RANGGAAYESHA on 3/25/2018.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.holder> {
    //Deklarasi variable yang akan digunakan
    private Context cntx;
    private List<AddDataActivity> list;
    int color;

    //Konstruktor
    public Adapter(Context cntx, ArrayList<AddDataActivity> list, int color){
        this.cntx=cntx;
        this.list=list;
        this.color=color;
    }

    //Menentukan viewholder untuk recyclerview
    @Override
    public holder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Membuat view baru
        View view = LayoutInflater.from(cntx).inflate(R.layout.cardview_list, parent, false);
        holder hldr = new holder(view);
        return hldr;
    }

    //Menyetting nilai yang didapatkan pada viewholder
    @Override
    public void onBindViewHolder(holder holder, int position) {
        AddDataActivity data = list.get(position);
        holder.ToDo.setText(data.getTodo());
        holder.Description.setText(data.getDesc());
        holder.Priority.setText(data.getPrior());
        holder.cardv.setCardBackgroundColor(cntx.getResources().getColor(this.color));
    }

    //Mendapatkan jumlah list
    @Override
    public int getItemCount() {
        return list.size();
    }

    //Mendapatkan list dari adapter
    public AddDataActivity getData(int position){
        return list.get(position);
    }

    //Untuk menghapus list pada todolist
    public void deleteData(int i){
        //Remove item yang terpilih
        list.remove(i);
        //Memberi notifikasi item yang di remove
        notifyItemRemoved(i);
        notifyItemRangeChanged(i, list.size());
    }

    class holder extends RecyclerView.ViewHolder{
        //Deklarasi variable yang akan digunakan
        public TextView ToDo, Description, Priority;
        public CardView cardv;
        public holder(View itemView){
            super(itemView);

            //Mengakses id text view pada layout dan juga cardview
            ToDo = itemView.findViewById(R.id.headline);
            Description = itemView.findViewById(R.id.explanation);
            Priority = itemView.findViewById(R.id.number);
            cardv = itemView.findViewById(R.id.cardlist);
        }
    }
}
