package poly.DuAn1.nhom2.MD18309.PRO1121.fragments_mini;

import android.app.AlertDialog;
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

import poly.DuAn1.nhom2.MD18309.PRO1121.DAO.NhaCungCapDAO;
import poly.DuAn1.nhom2.MD18309.PRO1121.ObjectClass.NhaCungCap;
import poly.DuAn1.nhom2.MD18309.PRO1121.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ThemNhaCungCap#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ThemNhaCungCap extends Fragment {
    
    private Context context;
    private int idNCC;
    private NhaCungCapDAO nhaCungCapDAO;
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

    public ThemNhaCungCap() {
        // Required empty public constructor
    }

    public ThemNhaCungCap(Context context, int idNCC, FragmentCallBack fragmentCallBack) {
        this.context = context;
        this.idNCC = idNCC;
        this.nhaCungCapDAO = new NhaCungCapDAO(context);
        this.fragmentCallBack = fragmentCallBack;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ThemNhaCungCap.
     */
    // TODO: Rename and change types and number of parameters
    public static ThemNhaCungCap newInstance(String param1, String param2) {
        ThemNhaCungCap fragment = new ThemNhaCungCap();
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
        View view = inflater.inflate(R.layout.fragment_them_nha_cung_cap, container, false);
        Button btnCancel = view.findViewById(R.id.btnCancel);
        Button btnAdd = view.findViewById(R.id.btnAdd);
        Button btnDelete = view.findViewById(R.id.btnDelete);
        AtomicBoolean editMode = new AtomicBoolean(false);

        TextInputLayout edtTenNCCLayout = view.findViewById(R.id.edtTenNCCLayout);
        TextInputLayout edtHoTenNguoiDaiDienLayOut = view.findViewById(R.id.edtHoTenDaiDienLayout);
        TextInputLayout edtSDTNCCLayout = view.findViewById(R.id.edtSDTNCCLayout);
        TextInputLayout edtDiaChiNCCLayout = view.findViewById(R.id.edtDiaChiNCCLayout);

        TextInputEditText edtTenNCC = view.findViewById(R.id.edtTenNCC);
        TextInputEditText edtHoTenNguoiDaiDien = view.findViewById(R.id.edtHoTenDaiDien);
        TextInputEditText edtSDTNCC = view.findViewById(R.id.edtSDTNCC);
        TextInputEditText edtDiaChiNCC = view.findViewById(R.id.edtDiaChiNCC);

        btnCancel.setOnClickListener(v -> fragmentCallBack.finishCall(0));
        if(idNCC != -1){
            btnAdd.setText("Chỉnh Sửa");
            NhaCungCap nhaCungCap = nhaCungCapDAO.getNhaCungCapByID(idNCC);

            edtDiaChiNCC.setEnabled(false);
            edtTenNCC.setEnabled(false);
            edtSDTNCC.setEnabled(false);
            edtHoTenNguoiDaiDien.setEnabled(false);

            edtTenNCC.setText(nhaCungCap.getTenNhaCungCap());
            edtDiaChiNCC.setText(nhaCungCap.getDiaChiNhaCungCap());
            edtHoTenNguoiDaiDien.setText(nhaCungCap.getHoTenNguoiDaiDien());
            edtSDTNCC.setText(nhaCungCap.getSdtNhaCungCap());
        }else{
            btnDelete.setVisibility(View.GONE);
        }

        btnAdd.setOnClickListener(v -> {
            String tenNCC = edtTenNCC.getText().toString();
            String hoTen = edtHoTenNguoiDaiDien.getText().toString();
            String sDTNCC = edtSDTNCC.getText().toString();
            String diaChiNCC = edtDiaChiNCC.getText().toString();
            if (idNCC != -1){
                if(editMode.get()){
                    if(tenNCC.isEmpty() || hoTen.isEmpty() || sDTNCC.isEmpty() || diaChiNCC.isEmpty()){
                        edtSDTNCCLayout.setError("Trống");
                        edtTenNCCLayout.setError("Trống");
                        edtHoTenNguoiDaiDienLayOut.setError("Trống");
                        edtDiaChiNCCLayout.setError("Trống");
                        Runnable runnable = () -> {
                            edtSDTNCCLayout.setErrorEnabled(false);
                            edtTenNCCLayout.setErrorEnabled(false);
                            edtHoTenNguoiDaiDienLayOut.setErrorEnabled(false);
                            edtDiaChiNCCLayout.setErrorEnabled(false);
                        };
                        Handler handler = new Handler();
                        handler.postDelayed(runnable, 1200);
                    }else{
                        if (nhaCungCapDAO.updateNhaCungCap(new NhaCungCap(idNCC, tenNCC, sDTNCC, hoTen, diaChiNCC, 0))){
                            Toast.makeText(getContext(), "Sửa Thành Công", Toast.LENGTH_SHORT).show();
                            fragmentCallBack.finishCall(1);
                        }else{
                            Toast.makeText(getContext(), "Sửa Thành Bại", Toast.LENGTH_SHORT).show();
                        }
                    }
                }else{
                    btnAdd.setText("Xong");
                    edtDiaChiNCC.setEnabled(true);
                    edtTenNCC.setEnabled(true);
                    edtSDTNCC.setEnabled(true);
                    edtHoTenNguoiDaiDien.setEnabled(true);
                }
                editMode.set(true);
            }else{
                if(tenNCC.isEmpty() || hoTen.isEmpty() || sDTNCC.isEmpty() || diaChiNCC.isEmpty()){
                    edtSDTNCCLayout.setError("Trống");
                    edtTenNCCLayout.setError("Trống");
                    edtHoTenNguoiDaiDienLayOut.setError("Trống");
                    edtDiaChiNCCLayout.setError("Trống");
                    Runnable runnable = () -> {
                        edtSDTNCCLayout.setErrorEnabled(false);
                        edtTenNCCLayout.setErrorEnabled(false);
                        edtHoTenNguoiDaiDienLayOut.setErrorEnabled(false);
                        edtDiaChiNCCLayout.setErrorEnabled(false);
                    };
                    Handler handler = new Handler();
                    handler.postDelayed(runnable, 1200);
                }else{
                    if (nhaCungCapDAO.AddNhaCungCap(new NhaCungCap(0, tenNCC, sDTNCC, hoTen, diaChiNCC, 0))){
                        Toast.makeText(getContext(), "Thêm Thành Công", Toast.LENGTH_SHORT).show();
                        fragmentCallBack.finishCall(1);
                    }else{
                        Toast.makeText(getContext(), "Thêm Thành Bại", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        btnDelete.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
            builder.setTitle("Xác Nhận Xóa");
            builder.setMessage("Chắc Không Đấy Bạn?");
            builder.setPositiveButton("Chắc", (dialog, which) -> {
                if (nhaCungCapDAO.DeleteNhaCungCap(idNCC)){
                    Toast.makeText(getContext(), "Xóa Thành Công", Toast.LENGTH_SHORT).show();
                    fragmentCallBack.finishCall(2);
                }else{
                    Toast.makeText(getContext(), "Xóa Thành Bại", Toast.LENGTH_SHORT).show();
                }
            });
            builder.setNegativeButton("Không", (dialog, which) -> {

            });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        });

        return view;
    }
}