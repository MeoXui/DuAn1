package poly.DuAn1.nhom2.MD18309.PRO1121.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import poly.DuAn1.nhom2.MD18309.PRO1121.ObjectClass.TaiKhoan;
import poly.DuAn1.nhom2.MD18309.PRO1121.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Menu#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Menu extends Fragment {

    private TaiKhoan taiKhoan;
    private FragmentCallBack fragmentCallBack;

    public interface FragmentCallBack{
        void logout();
    }

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Menu() {
        // Required empty public constructor
    }

    public Menu(TaiKhoan taiKhoan, FragmentCallBack fragmentCallBack) {
        this.taiKhoan = taiKhoan;
        this.fragmentCallBack = fragmentCallBack;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment menu.
     */
    // TODO: Rename and change types and number of parameters
    public static Menu newInstance(String param1, String param2) {
        Menu fragment = new Menu();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu, container, false);

        //Khai Báo
        TextView txtHoTen = view.findViewById(R.id.txtHoTen);
        TextView txtChucVu = view.findViewById(R.id.txtRole);
        ImageView imgProfile = view.findViewById(R.id.imgProfile);
        LinearLayout btnLogOut = view.findViewById(R.id.btnLogOut);

        //Hiện Thị Thông Tin
        txtHoTen.setText(taiKhoan.getHoTen());
//        txtChucVu.setText(taiKhoan.getRole());
        if (taiKhoan.getRole().equalsIgnoreCase("QUANLY")){
            imgProfile.setImageResource(R.drawable.user_admin);
            txtChucVu.setText("Quản Lý");
        } else if (taiKhoan.getRole().equalsIgnoreCase("NhanVien")) {
            imgProfile.setImageResource(R.drawable.user_admin);
            txtChucVu.setText("Nhân Viên");
        }else {
            imgProfile.setImageResource(R.drawable.user_admin);
            txtChucVu.setText("Người Dùng");
        }

        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentCallBack.logout();
            }
        });

        return view;
    }
}