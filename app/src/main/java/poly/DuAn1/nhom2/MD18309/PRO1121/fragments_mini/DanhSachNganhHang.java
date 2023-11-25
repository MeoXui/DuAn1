package poly.DuAn1.nhom2.MD18309.PRO1121.fragments_mini;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import poly.DuAn1.nhom2.MD18309.PRO1121.Adapter.NganhHangAdapter;
import poly.DuAn1.nhom2.MD18309.PRO1121.DAO.NganhHangDAO;
import poly.DuAn1.nhom2.MD18309.PRO1121.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DanhSachNganhHang#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DanhSachNganhHang extends Fragment implements NganhHangAdapter.OnItemClickCallBack {

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
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        EditText edtSearch = view.findViewById(R.id.edtSearch);
        Button btnAdd = view.findViewById(R.id.btnAdd);

        //Setup RecyclerView
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(new NganhHangAdapter(getContext(), new NganhHangDAO(getContext()).getNganhHangList(), this));

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Thêm Thành Công(Chắc Thế)", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    @Override
    public void onClickListener(int id) {
        System.out.println(id);
        Toast.makeText(getContext(), "Tưởng Tượng Màn Hình Thông Tin Chi Tiết", Toast.LENGTH_SHORT).show();
    }
}