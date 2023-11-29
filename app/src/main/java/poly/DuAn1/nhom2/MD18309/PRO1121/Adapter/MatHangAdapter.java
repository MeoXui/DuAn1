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

import poly.DuAn1.nhom2.MD18309.PRO1121.DAO.MatHangDAO;
import poly.DuAn1.nhom2.MD18309.PRO1121.ObjectClass.MatHang;
import poly.DuAn1.nhom2.MD18309.PRO1121.R;

public class MatHangAdapter extends RecyclerView.Adapter<MatHangAdapter.ViewFucker>{

    private final Context context;
    private ArrayList<MatHang> matHangArrayList;
    private final MatHangDAO matHangDAO;
    private static OnItemClickCallBack onItemClickCallBack;

    public interface OnItemClickCallBack{
        void onClickListener(int id);
    }

    public MatHangAdapter(Context context, ArrayList<MatHang> matHangArrayList, OnItemClickCallBack onItemClickCallBack) {
        this.context = context;
        this.matHangDAO = new MatHangDAO(context);
        this.matHangArrayList = matHangArrayList;
        MatHangAdapter.onItemClickCallBack = onItemClickCallBack;
//        GetData();
    }

    private void GetData(){
        matHangArrayList = matHangDAO.getMatHangList();
    }

    @NonNull
    @Override
    public ViewFucker onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        View view = inflater.inflate(R.layout.mat_hang_item, parent, false);
        return new ViewFucker(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewFucker holder, int position) {
        holder.txtTenMatHang.setText(matHangArrayList.get(holder.getAdapterPosition()).getTenMatHang());
        holder.txtMaMatHang.setText("Mã: "+matHangArrayList.get(holder.getAdapterPosition()).getIdMatHang());
        holder.txtSoLuong.setText("Số Lượng: "+matHangArrayList.get(holder.getAdapterPosition()).getSoLuongMatHang()+" "+matHangArrayList.get(holder.getAdapterPosition()).getDonViTinh());
        holder.txtGiaBan.setText("Giá Bán: "+matHangArrayList.get(holder.getAdapterPosition()).getGiaMatHang()+" VNĐ");

        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Xóa Thành Công(Chắc Thế)", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return matHangArrayList.size();
    }

    public static class ViewFucker extends RecyclerView.ViewHolder implements View.OnLongClickListener, View.OnClickListener {
        TextView txtTenMatHang, txtMaMatHang, txtSoLuong, txtGiaBan;
        ImageButton btnDelete;
        public ViewFucker(@NonNull View itemView) {
            super(itemView);
            itemView.setOnLongClickListener(this);
            itemView.setOnClickListener(this);
            txtTenMatHang = itemView.findViewById(R.id.txtTenMatHang);
            txtMaMatHang = itemView.findViewById(R.id.txtMaMatHang);
            txtSoLuong = itemView.findViewById(R.id.txtSoLuong);
            txtGiaBan = itemView.findViewById(R.id.txtGiaMatHang);
            btnDelete = itemView.findViewById(R.id.btnDeleteS);
        }

        @Override
        public void onClick(View v) {
//            onItemClickCallBack.onClickListener(Integer.parseInt(txtMaMatHang.getText().toString().replaceAll("[^0-9]", "")));
        }

        @Override
        public boolean onLongClick(View v) {
            onItemClickCallBack.onClickListener(Integer.parseInt(txtMaMatHang.getText().toString().replaceAll("[^0-9]", "")));
            return true;
        }
    }
}
