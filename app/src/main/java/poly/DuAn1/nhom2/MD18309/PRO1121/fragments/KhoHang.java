package poly.DuAn1.nhom2.MD18309.PRO1121.fragments;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import poly.DuAn1.nhom2.MD18309.PRO1121.Adapter.MatHangAdapter;
import poly.DuAn1.nhom2.MD18309.PRO1121.Adapter.OptionItemAdapter;
import poly.DuAn1.nhom2.MD18309.PRO1121.ObjectClass.OptionItem;
import poly.DuAn1.nhom2.MD18309.PRO1121.R;
import poly.DuAn1.nhom2.MD18309.PRO1121.fragments_mini.DanhSachMatHang;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link KhoHang#newInstance} factory method to
 * create an instance of this fragment.
 */
public class KhoHang extends Fragment implements OptionItemAdapter.OptionCallBack {

    private DanhSachMatHang danhSachMatHang;
    private FragmentManager fragmentManager;
    private RecyclerView recyclerView;
    private TextView toolBarTitle;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public KhoHang() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment khohang.
     */
    // TODO: Rename and change types and number of parameters
    public static KhoHang newInstance(String param1, String param2) {
        KhoHang fragment = new KhoHang();
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
        View view = inflater.inflate(R.layout.fragment_khohang, container, false);

        //Khai Báo
        Button btnTest = view.findViewById(R.id.btnTest);
        recyclerView = view.findViewById(R.id.recyclerView);
        Toolbar toolbar = view.findViewById(R.id.toolbar);
        toolBarTitle = view.findViewById(R.id.toolBarTitle);
        fragmentManager = getChildFragmentManager();
        ArrayList<OptionItem> optionItemArrayList = new ArrayList<>();

        //Danh Sách Menu
        optionItemArrayList.add(new OptionItem("Danh Sách Mặt Hàng", R.drawable.box_selected));
        optionItemArrayList.add(new OptionItem("Danh Sách Nhà Cung Cấp", R.drawable.box_selected));
        optionItemArrayList.add(new OptionItem("Danh Sách Ngành Hàng", R.drawable.box_selected));

        //Setup toolbar
        toolbar.setTitle("");
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setHomeButtonEnabled(false);

        //Khai Báo Fragment(Tạm Thời)
        danhSachMatHang = new DanhSachMatHang();

        btnTest.setVisibility(View.INVISIBLE);

        //Nút hiện danh sách(Tạm Thời)
        btnTest.setOnClickListener(v -> {
            ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            ((AppCompatActivity)getActivity()).getSupportActionBar().setHomeButtonEnabled(true);
            fragmentManager.beginTransaction().replace(R.id.framelayout, danhSachMatHang).commit();
            recyclerView.setVisibility(View.INVISIBLE);
            toolBarTitle.setText("Danh Sách Mặt Hàng");
            System.out.println("Test");
        });

        //Bắt sự kiện quay về
        toolbar.setNavigationOnClickListener(v -> {
            ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(false);
            ((AppCompatActivity)getActivity()).getSupportActionBar().setHomeButtonEnabled(false);
            fragmentManager.beginTransaction().remove(danhSachMatHang).commit();
            toolBarTitle.setText("Quản Lý Kho Hàng");
//            btnTest.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.VISIBLE);
        });

        //Setup RecyclerView
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(new OptionItemAdapter(getContext(), optionItemArrayList, this));
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL));


        return view;
    }

    //Mở Menu Vừa Chọn
    @Override
    public void onOptionItemClickListener(int position) {
        System.out.println(position);
        if (position == 0){
            openDanhSachMatHang();
        }
    }

    private void openDanhSachMatHang(){
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setHomeButtonEnabled(true);
        fragmentManager.beginTransaction().replace(R.id.framelayout, danhSachMatHang).commit();
        recyclerView.setVisibility(View.INVISIBLE);
        toolBarTitle.setText("Danh Sách Mặt Hàng");
        System.out.println("OK");
    }
}