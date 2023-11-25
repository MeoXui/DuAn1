package poly.DuAn1.nhom2.MD18309.PRO1121.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import poly.DuAn1.nhom2.MD18309.PRO1121.Adapter.ViewPager2Adapter;
import poly.DuAn1.nhom2.MD18309.PRO1121.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HoaDon#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HoaDon extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HoaDon() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment hoadon.
     */
    // TODO: Rename and change types and number of parameters
    public static HoaDon newInstance(String param1, String param2) {
        HoaDon fragment = new HoaDon();
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
        View view = inflater.inflate(R.layout.fragment_hoadon, container, false);
        //Khai Báo
        TabLayout tabLayout = view.findViewById(R.id.tabLayout);
        ViewPager2 viewPager2 = view.findViewById(R.id.viewPager);

        //Tạo ViewPager Adapter
        ViewPager2Adapter viewPager2Adapter = new ViewPager2Adapter(this);
        viewPager2.setAdapter(viewPager2Adapter);

        tabLayout.setTabRippleColor(null);

        new TabLayoutMediator(tabLayout, viewPager2, (tab, position) -> {
            switch (position){
                case 0:
                    tab.setText("Hóa Đơn Bán");
                    break;
                case 1:
                    tab.setText("Hóa Đơn Nhập");
                    break;
                default:
                    break;
            }
        }).attach();
        return view;
    }
}