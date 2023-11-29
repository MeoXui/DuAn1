package poly.DuAn1.nhom2.MD18309.PRO1121.fragments_mini;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.concurrent.atomic.AtomicBoolean;

import poly.DuAn1.nhom2.MD18309.PRO1121.DAO.NganhHangDAO;
import poly.DuAn1.nhom2.MD18309.PRO1121.ObjectClass.NganhHang;
import poly.DuAn1.nhom2.MD18309.PRO1121.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ThemNganhHang#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ThemNganhHang extends Fragment {

    private Context context;
    private int idNH;
    private NganhHangDAO nganhHangDAO;
    FragmentCallBack fragmentCallBack;

    public interface FragmentCallBack{
        void finishCall(int result);
    }

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ThemNganhHang() {
        // Required empty public constructor
    }

    public ThemNganhHang(Context context, int idNH, FragmentCallBack fragmentCallBack) {
        this.context = context;
        this.idNH = idNH;
        this.nganhHangDAO = new NganhHangDAO(context);
        this.fragmentCallBack = fragmentCallBack;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ThemNganhHang.
     */
    // TODO: Rename and change types and number of parameters
    public static ThemNganhHang newInstance(String param1, String param2) {
        ThemNganhHang fragment = new ThemNganhHang();
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
        View view = inflater.inflate(R.layout.fragment_them_nganh_hang, container, false);

        Button btnCancel = view.findViewById(R.id.btnCancel);
        Button btnAdd = view.findViewById(R.id.btnAdd);
        AtomicBoolean editMode = new AtomicBoolean(false);
        TextInputLayout edtTenNganhHangLayout = view.findViewById(R.id.edtTennganhhangLayout);
        TextInputEditText edtTenNganhHang = view.findViewById(R.id.edtTennganhhang);

        btnCancel.setOnClickListener(v -> fragmentCallBack.finishCall(0));

        if(idNH != -1){
            btnAdd.setText("Chỉnh Sửa");
            edtTenNganhHang.setEnabled(false);
            edtTenNganhHang.setText(nganhHangDAO.getNganhHangByID(idNH).getTenNganhHang());
        }

        btnAdd.setOnClickListener(v -> {
            String tenNganhHang = edtTenNganhHang.getText().toString();
            if (idNH != -1){
                if (editMode.get()){

                    Toast.makeText(getContext(), "Sửa Thành Bại", Toast.LENGTH_SHORT).show();
                }else{
                    btnAdd.setText("Xong");
                    edtTenNganhHang.setEnabled(true);
                    edtTenNganhHang.requestFocus();
                }
                editMode.set(true);
            }else {
                if (tenNganhHang.isEmpty()){
                    edtTenNganhHangLayout.setError("Trống");
                    Runnable runnable = () -> edtTenNganhHangLayout.setErrorEnabled(false);
                    Handler handler = new Handler();
                    handler.postDelayed(runnable, 1200);
                }else{
                    if(nganhHangDAO.AddNganhHang(new NganhHang(0, tenNganhHang, 0))){
                        Toast.makeText(getContext(), "Thêm Thành Công", Toast.LENGTH_SHORT).show();
                        fragmentCallBack.finishCall(1);
                    }else{
                        Toast.makeText(getContext(), "Thêm Thành Bại", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        return view;
    }
}