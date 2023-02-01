package com.example.androi_nangcao.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androi_nangcao.R;
import com.example.androi_nangcao.modle.khoa_hoc;

import java.util.ArrayList;

public class DangKiMonHocAdapter extends RecyclerView.Adapter<DangKiMonHocAdapter.ViewHolder> {
    private Context context;
    private ArrayList<khoa_hoc> list;

    public DangKiMonHocAdapter(Context context, ArrayList<khoa_hoc> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        View view = inflater.inflate((R.layout.item_khoa_hoc), parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtName.setText(String.valueOf(list.get(position).getName()));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtName, txtCode;
        Button btnDangki;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtCode=itemView.findViewById(R.id.txtCode);
            txtName=itemView.findViewById(R.id.txtName);
            btnDangki=itemView.findViewById(R.id.btnDangKi);
        }
    }
}
