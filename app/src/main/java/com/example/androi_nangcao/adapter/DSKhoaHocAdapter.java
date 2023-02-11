package com.example.androi_nangcao.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androi_nangcao.R;
import com.example.androi_nangcao.Service.DangKiVaHuyService;
import com.example.androi_nangcao.model.Monhoc;

import java.util.ArrayList;

public class DSKhoaHocAdapter extends RecyclerView.Adapter<DSKhoaHocAdapter.ViewHolder> {
    private Context context;
    private ArrayList<Monhoc> list;

    public DSKhoaHocAdapter(Context context, ArrayList<Monhoc> list) {
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
        holder.txtCode.setText(String.valueOf(list.get(position).getCode()));
        holder.txtTeacher.setText(String.valueOf(list.get(position).getTeacher()));

        SharedPreferences sharedPreferences = context.getSharedPreferences("DATA",Context.MODE_PRIVATE);
        int idNguoiDung = sharedPreferences.getInt("idNguoiDung",-1);

        if (idNguoiDung == list.get(holder.getAdapterPosition()).getId()){
            holder.btnDangki.setText("Hủy đăng kí");

            holder.btnDangki.setBackgroundColor(Color.RED);
        }else {
            holder.btnDangki.setText("Đăng kí");
            holder.btnDangki.setBackgroundColor(Color.rgb(241,164,49));
        }
        holder.btnDangki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //type 1: đăng kí, 0: hủy đăng kí
                int type =-1;
                if (idNguoiDung == list.get(holder.getAdapterPosition()).getId()){
                    type=0;
                }else {
                    type=1;
                }

                Intent intent = new Intent(context, DangKiVaHuyService.class);
                Bundle bundle = new Bundle();
                bundle.putInt("idNguoiDung",idNguoiDung);
                bundle.putString("code",list.get(holder.getAdapterPosition()).getCode());
                bundle.putInt("type",type);
                intent.putExtras(bundle);
                context.startService(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtName, txtCode,txtTeacher;
        Button btnDangki;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtCode=itemView.findViewById(R.id.txtCode);
            txtTeacher=itemView.findViewById(R.id.txtTeacher);
            txtName=itemView.findViewById(R.id.txtName);
            btnDangki=itemView.findViewById(R.id.btnDangKi);
        }
    }
}
