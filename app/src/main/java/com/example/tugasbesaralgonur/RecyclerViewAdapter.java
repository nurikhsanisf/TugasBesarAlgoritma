package com.example.tugasbesaralgonur;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private LayoutInflater mInflater;
    private List<DataWarga> dataWargas;
    private Context mContext;
    DataHelper SQLLite;

    public RecyclerViewAdapter(Context context, List<DataWarga> dataWargas){
        this.mInflater  = LayoutInflater.from(context);
        this.dataWargas = dataWargas;
        this.mContext   = context;
        SQLLite = new DataHelper(context);

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.recycler_view_layout, parent, false);
        return new RecyclerViewAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.tvValueNik.setText(dataWargas.get(position).getNik());
        holder.tvValueName.setText(dataWargas.get(position).getNama());
        holder.tvValueJenkel.setText(dataWargas.get(position).getJenisKelamin());
        holder.tvValueAlamat.setText(dataWargas.get(position).getAlamat()+" Dusun "+ dataWargas.get(position).getDusun());
        holder.tvValueStatus.setText(dataWargas.get(position).getStatusWarga());
        holder.btnHapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hapusDataWargas(dataWargas.get(position).getId());
                Intent intent = new Intent(mContext, MainActivity.class);
                mContext.startActivity(intent);
            }
        });

        holder.btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, UpdateFormActivity.class);
                intent.putExtra("COLOMNS_ID", dataWargas.get(position).getId());
                mContext.startActivity(intent);

                notifyDataSetChanged();
            }
        });
    }

    private void hapusDataWargas(String id) {
        int a = Integer.parseInt(id);
        SQLLite.delete(a);
    }

    @Override
    public int getItemCount() {
        return dataWargas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvValueNik, tvValueName, tvValueJenkel, tvValueAlamat, tvValueStatus;
        Button btnEdit, btnHapus;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvValueNik = itemView.findViewById(R.id.tv_value_nik);
            tvValueName = itemView.findViewById(R.id.tv_value_nama);
            tvValueJenkel = itemView.findViewById(R.id.tv_value_jenkel);
            tvValueAlamat = itemView.findViewById(R.id.tv_value_alamat);
            tvValueStatus = itemView.findViewById(R.id.tv_value_status);
            btnEdit = itemView.findViewById(R.id.btn_edit);
            btnHapus = itemView.findViewById(R.id.btn_hapus);
        }
    }
}
