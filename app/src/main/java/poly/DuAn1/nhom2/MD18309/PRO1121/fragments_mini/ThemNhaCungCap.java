package poly.DuAn1.nhom2.MD18309.PRO1121.fragments_mini;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import poly.DuAn1.nhom2.MD18309.PRO1121.DAO.NhaCungCapDAO;
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
        return view;
    }
}