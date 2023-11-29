package poly.DuAn1.nhom2.MD18309.PRO1121.Adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import poly.DuAn1.nhom2.MD18309.PRO1121.ObjectClass.NhaCungCap;
import poly.DuAn1.nhom2.MD18309.PRO1121.R;

public class NhaCungCapAdapter extends RecyclerView.Adapter<NhaCungCapAdapter.ViewFucker> {

    private final Context context;
    private final ArrayList<NhaCungCap> nhaCungCapArrayList;
    private static OnItemClickCallBack onItemClickCallBack;

    public interface OnItemClickCallBack{
        void onItemClick(int id);
    }

    public NhaCungCapAdapter(Context context, ArrayList<NhaCungCap> nhaCungCapArrayList, OnItemClickCallBack onItemClickCallBack) {
        this.context = context;
        this.nhaCungCapArrayList = nhaCungCapArrayList;
        NhaCungCapAdapter.onItemClickCallBack = onItemClickCallBack;
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
        holder.txtTenNCC.setText(nhaCungCapArrayList.get(holder.getAdapterPosition()).getTenNhaCungCap());
        holder.txtMaNCC.setText("Mã: "+nhaCungCapArrayList.get(holder.getAdapterPosition()).getIdNhaCungCap());
        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Xóa Thành Công(Chắc Thế)", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return nhaCungCapArrayList.size();
    }

    public static class ViewFucker extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

        TextView txtTenNCC, txtMaNCC;
        ImageButton btnDelete;
        public ViewFucker(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
            txtTenNCC = itemView.findViewById(R.id.txtTenNganhHang);
            txtMaNCC = itemView.findViewById(R.id.txtMaNganhHang);
            btnDelete = itemView.findViewById(R.id.btnDeleteLS);
        }

        @Override
        public void onClick(View v) {
        }

        @Override
        public boolean onLongClick(View v) {
            onItemClickCallBack.onItemClick(Integer.parseInt(txtMaNCC.getText().toString().replaceAll("[^0-9]", "")));
            return true;
        }
    }
}
