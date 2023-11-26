package poly.DuAn1.nhom2.MD18309.PRO1121.fragments_mini;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

import poly.DuAn1.nhom2.MD18309.PRO1121.Adapter.NganhHangAdapter;
import poly.DuAn1.nhom2.MD18309.PRO1121.DAO.NganhHangDAO;
import poly.DuAn1.nhom2.MD18309.PRO1121.DAO.NhaCungCapDAO;
import poly.DuAn1.nhom2.MD18309.PRO1121.ObjectClass.MatHang;
import poly.DuAn1.nhom2.MD18309.PRO1121.ObjectClass.NganhHang;
import poly.DuAn1.nhom2.MD18309.PRO1121.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DanhSachNganhHang#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DanhSachNganhHang extends Fragment implements NganhHangAdapter.OnItemClickCallBack {

    private RecyclerView recyclerView;
    private FragmentManager fragmentManager;
    private NganhHangDAO nganhHangDAO;
//    private ArrayList<NganhHang> nganhHangArrayList;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DanhSachNganhHang() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DanhSachNganhHangf.
     */
    // TODO: Rename and change types and number of parameters
    public static DanhSachNganhHang newInstance(String param1, String param2) {
        DanhSachNganhHang fragment = new DanhSachNganhHang();
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
        View view = inflater.inflate(R.layout.fragment_danh_sach_nganh_hang, container, false);

        //Khai Báo
        recyclerView = view.findViewById(R.id.recyclerView);
        EditText edtSearch = view.findViewById(R.id.edtSearch);
        Button btnAdd = view.findViewById(R.id.btnAdd);
        nganhHangDAO = new NganhHangDAO(getContext());
        ArrayList<NganhHang> nganhHangArrayList = nganhHangDAO.getNganhHangList();
        ArrayList<NganhHang> listTimKiem = new ArrayList<>();

        //Tìm Kiếm Theo Tên
        edtSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                listTimKiem.clear();
                for (NganhHang nganhHang: nganhHangArrayList){
                    if(!s.toString().isEmpty()){
                        if (nganhHang.getTenNganhHang().contains(s)){
                            listTimKiem.add(nganhHang);
                            setAdapter(listTimKiem);
                        }else{
                            setAdapter(listTimKiem);
                        }
                    }else{
                        setAdapter(nganhHangArrayList);
                    }
                }
            }
            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        //Setup RecyclerView
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        setAdapter(nganhHangArrayList);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Thêm Thành Công(Chắc Thế)", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    private void setAdapter(ArrayList<NganhHang> nganhHangArrayList){
        recyclerView.setAdapter(new NganhHangAdapter(getContext(), nganhHangArrayList, this));
    }

    @Override
    public void onClickListener(int id) {
        System.out.println(id);
        Toast.makeText(getContext(), "Tưởng Tượng Màn Hình Thông Tin Chi Tiết", Toast.LENGTH_SHORT).show();
    }
}