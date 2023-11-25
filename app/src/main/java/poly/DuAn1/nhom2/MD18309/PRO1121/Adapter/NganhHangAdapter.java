package poly.DuAn1.nhom2.MD18309.PRO1121.Adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import poly.DuAn1.nhom2.MD18309.PRO1121.ObjectClass.NganhHang;
import poly.DuAn1.nhom2.MD18309.PRO1121.R;

public class NganhHangAdapter extends RecyclerView.Adapter<NganhHangAdapter.ViewFucker>{
    private final Context context;
    private final ArrayList<NganhHang> nganhHangArrayList;
    private static OnItemClickCallBack onItemClickCallBack;

    public interface OnItemClickCallBack{
        void onClickListener(int id);
    }

    public NganhHangAdapter(Context context, ArrayList<NganhHang> nganhHangArrayList, OnItemClickCallBack onItemClickCallBack) {
        this.context = context;
        this.nganhHangArrayList = nganhHangArrayList;
        NganhHangAdapter.onItemClickCallBack = onItemClickCallBack;
    }

    @NonNull
    @Override
    public ViewFucker onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        View view = inflater.inflate(R.layout.nganh_hang_item, parent, false);
        return new ViewFucker(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewFucker holder, int position) {
        holder.txtTenNganhHang.setText(nganhHangArrayList.get(holder.getAdapterPosition()).getTenNganhHang());
        holder.txtMaHangHang.setText("Mã: "+nganhHangArrayList.get(holder.getAdapterPosition()).getIdNganhHang());
        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Xóa Thành Công(Chắc Thế)", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return nganhHangArrayList.size();
    }

    public static class ViewFucker extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView txtTenNganhHang, txtMaHangHang;
        ImageButton btnDelete;

        public ViewFucker(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            txtTenNganhHang = itemView.findViewById(R.id.txtTenNganhHang);
            txtMaHangHang = itemView.findViewById(R.id.txtMaNganhHang);
            btnDelete = itemView.findViewById(R.id.btnDeleteLS);
        }

        @Override
        public void onClick(View v) {
            onItemClickCallBack.onClickListener(Integer.parseInt(txtMaHangHang.getText().toString().replaceAll("[^0-9]", "")));
        }
    }
}
