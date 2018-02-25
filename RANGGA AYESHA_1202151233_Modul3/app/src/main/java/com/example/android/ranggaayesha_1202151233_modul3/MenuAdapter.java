package com.example.android.ranggaayesha_1202151233_modul3;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.LinkedList;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuViewHolder>  {

    //Deklarasi objek
    private final LinkedList<String> Judul;
    private final LinkedList<String> Desc;
    private final LinkedList<Integer> image;
    private LayoutInflater mInflater;
    private Context context;

    public MenuAdapter(Context context, LinkedList<String> Judul,
                       LinkedList<String> Desc, LinkedList<Integer> image) {
        mInflater = LayoutInflater.from(context);
        this.Judul = Judul;
        this.Desc = Desc;
        this.image = image;
    }

    @Override
    public MenuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Inflate layout item menu list ketika membuka activity list menu
        View mItemView = mInflater.inflate(R.layout.activity_list, parent, false);
        return new MenuViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(MenuViewHolder holder, int position) {
        //Mendapatkan posisi dari Judul desc dan kawannya
        String itemTitle = Judul.get(position);
        String itemDesc = Desc.get(position);
        int itemImage = image.get(position);

        //Meletakkan teks dan gambar kedalam posisi yang sebelumnya didapatkan
        holder.menuJudul.setText(itemTitle);
        holder.menuDesc.setText(itemDesc);
        holder.menuImage.setImageResource(itemImage);
    }

    @Override
    public int getItemCount() {
        return Judul.size();
    }

    class MenuViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public final TextView menuJudul;
        public final TextView menuDesc;
        public final ImageView menuImage;
        final MenuAdapter mAdapter;

        public MenuViewHolder(View itemView, MenuAdapter adapter) {
            super(itemView);
            menuJudul = itemView.findViewById(R.id.textJudul);
            menuDesc = itemView.findViewById(R.id.textDesc);
            menuImage = itemView.findViewById(R.id.imageLogo);
            this.mAdapter = adapter;
            context = itemView.getContext();
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            //Mengambil posisi item yang dipilih
            int mPosition = getLayoutPosition();

            //Mengambil data dari item yang dipilih
            String itemJudul = Judul.get(mPosition);
            String itemDesc = Desc.get(mPosition);
            int itemImage = image.get(mPosition);

            //Melanjutkan data ke aktifitas berikutnya
            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra("Judul", itemJudul);
            intent.putExtra("Desc", itemDesc);
            intent.putExtra("image", itemImage);
            context.startActivity(intent);

            //Memberikan informasi bila ada perubahan pada saat data masuk ke aktifitas berikutnya
            mAdapter.notifyDataSetChanged();
        }
    }
}

