package poly.DuAn1.nhom2.MD18309.PRO1121.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import poly.DuAn1.nhom2.MD18309.PRO1121.ObjectClass.MatHang;
import poly.DuAn1.nhom2.MD18309.PRO1121.R;

public class MatHangAdapter extends RecyclerView.Adapter<MatHangAdapter.ViewFucker>{

    private Context context;
    private ArrayList<MatHang> matHangArrayList;

    public MatHangAdapter(Context context, ArrayList<MatHang> matHangArrayList) {
        this.context = context;
        this.matHangArrayList = matHangArrayList;
    }

    @NonNull
    @Override
    public ViewFucker onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        View view = inflater.inflate(R.layout.mat_hang_item, parent, false);
        return new ViewFucker(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewFucker holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public static class ViewFucker extends RecyclerView.ViewHolder{
        TextView txtTenMatHang, txtMaMatHang, txtSoLuong, txtGiaBan;
        ImageButton btnDelete;
        public ViewFucker(@NonNull View itemView) {
            super(itemView);
            txtTenMatHang = itemView.findViewById(R.id.txtTenMatHang);
            txtMaMatHang = itemView.findViewById(R.id.txtMaMatHang);
            txtSoLuong = itemView.findViewById(R.id.txtSoLuong);
            txtGiaBan = itemView.findViewById(R.id.txtGiaMatHang);
            btnDelete = itemView.findViewById(R.id.btnDeleteS);
        }
    }
}
