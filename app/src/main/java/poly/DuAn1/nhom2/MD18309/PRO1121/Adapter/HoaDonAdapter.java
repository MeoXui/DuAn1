package poly.DuAn1.nhom2.MD18309.PRO1121.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import poly.DuAn1.nhom2.MD18309.PRO1121.DAO.HoaDonDAO;
import poly.DuAn1.nhom2.MD18309.PRO1121.DAO.MatHangDAO;
import poly.DuAn1.nhom2.MD18309.PRO1121.DAO.TaiKhoanDAO;
import poly.DuAn1.nhom2.MD18309.PRO1121.ObjectClass.HoaDon;
import poly.DuAn1.nhom2.MD18309.PRO1121.ObjectClass.MatHang;
import poly.DuAn1.nhom2.MD18309.PRO1121.ObjectClass.TaiKhoan;
import poly.DuAn1.nhom2.MD18309.PRO1121.R;

public class HoaDonAdapter extends RecyclerView.Adapter<HoaDonAdapter.ViewFucker> {

    private final Context context;
    private final HoaDonDAO hoaDonDAO;
    private final TaiKhoanDAO taiKhoanDAO;
    private final MatHangDAO matHangDAO;
    private ArrayList<HoaDon> hoaDonArrayList;
    private ArrayList<TaiKhoan> taiKhoanArrayList;
//    private ArrayList<MatHang> matHangArrayList;

    private OnItemClickCallBack onItemClickCallBack;

    public interface OnItemClickCallBack{
        void onClickListener(int id, int holderPOS);
    }

    public HoaDonAdapter(Context context, ArrayList<HoaDon> hoaDonArrayList, OnItemClickCallBack onItemClickCallBack) {
        this.context = context;
        this.hoaDonDAO = new HoaDonDAO(context);
        this.taiKhoanDAO = new TaiKhoanDAO(context);
        this.matHangDAO = new MatHangDAO(context);
        this.hoaDonArrayList = hoaDonArrayList;
        this.taiKhoanArrayList = taiKhoanDAO.getListTaiKhoan();
        this.onItemClickCallBack = onItemClickCallBack;
    }

    private void getData(){
        hoaDonArrayList = hoaDonDAO.getHoaDonList();
//        matHangArrayList = matHangDAO.getMatHangList();
        taiKhoanArrayList = taiKhoanDAO.getListTaiKhoan();
    }

    private TaiKhoan findTaiKhoan(String userName){
        for (int i = 0; i <= taiKhoanArrayList.size(); i++){
            if (taiKhoanArrayList.get(i).getUserName().equalsIgnoreCase(userName)){
                return taiKhoanArrayList.get(i);
            }
        }
        return null;
    }

    @NonNull
    @Override
    public ViewFucker onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        View view = inflater.inflate(R.layout.hoa_don_item, parent, false);
        return new ViewFucker(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewFucker holder, int position) {
        holder.holderPOS = holder.getAdapterPosition();
        holder.txtTenNguoiTao.setText("N.T: "+findTaiKhoan(hoaDonArrayList.get(holder.getAdapterPosition()).getIdNguoiTao()).getHoTen());
        holder.txtMaHoaDon.setText("Hóa Đơn: "+hoaDonArrayList.get(holder.getAdapterPosition()).getIdHD());
        holder.txtNgayTao.setText("Tạo: "+hoaDonArrayList.get(holder.getAdapterPosition()).getNgayTao());
    }

    @Override
    public int getItemCount() {
        return hoaDonArrayList.size();
    }

    public class ViewFucker extends RecyclerView.ViewHolder implements View.OnLongClickListener{

        private int holderPOS;
        CheckBox txtMaHoaDon;
        TextView txtTenNguoiTao, txtNgayTao, txtGiaHoaDon;

        public ViewFucker(@NonNull View itemView) {
            super(itemView);
            itemView.setOnLongClickListener(this);
            txtMaHoaDon = itemView.findViewById(R.id.txtMaHoaDon);
            txtGiaHoaDon = itemView.findViewById(R.id.txtGiaHoaDon);
            txtNgayTao = itemView.findViewById(R.id.txtNgayTao);
            txtTenNguoiTao = itemView.findViewById(R.id.txtTenNguoiTao);
        }

        @Override
        public boolean onLongClick(View v) {
            onItemClickCallBack.onClickListener(Integer.parseInt(txtMaHoaDon.getText().toString().replaceAll("[^0-9]", "")), holderPOS);
            return true;
        }
    }
}
