package poly.DuAn1.nhom2.MD18309.PRO1121.fragments_mini;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import poly.DuAn1.nhom2.MD18309.PRO1121.DAO.TaiKhoanDAO;
import poly.DuAn1.nhom2.MD18309.PRO1121.R;

public class DoiMatKhau extends Fragment {

    private FragmentCallBack fragmentCallBack;
    private String tk;
    private TaiKhoanDAO TKDAO;

    public interface FragmentCallBack{
        void exitFragment();
    }

    public DoiMatKhau() {}

    public DoiMatKhau(FragmentCallBack fragmentCallBack,String tk, Context context) {
        this.fragmentCallBack = fragmentCallBack;
        this.tk = tk;
        TKDAO = new TaiKhoanDAO(context);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_doimatkhau, container, false);

        TextView TVUN = view.findViewById(R.id.tv_un);
        TVUN.setText(tk);

        EditText EdtOP = view.findViewById(R.id.edt_old_pass),
                EdtNP = view.findViewById(R.id.edt_new_pass),
                EdtRNP = view.findViewById(R.id.edt_re_new_pass);
        Button BtnDONE = view.findViewById(R.id.btn_done),
                BtnCancel = view.findViewById(R.id.btn_cancel);

        BtnDONE.setOnClickListener(v -> {
            if(Check(EdtOP,EdtNP,EdtRNP)){
                if(TKDAO.changePass(tk,EdtOP.getText().toString(),EdtNP.getText().toString())) {
                    Toast.makeText(getContext(), "Tay đổi mật khẩu thành công", Toast.LENGTH_SHORT).show();
                    EdtOP.setText("");
                    EdtNP.setText("");
                    EdtRNP.setText("");
                    fragmentCallBack.exitFragment();
                }
                else
                    Toast.makeText(getContext(), "Thay đổi thất bại, đã xẩy ra lỗi", Toast.LENGTH_SHORT).show();
            }
        });

        BtnCancel.setOnClickListener(v -> {
            EdtOP.setText("");
            EdtNP.setText("");
            EdtRNP.setText("");
            fragmentCallBack.exitFragment();
        });

        return view;
    }

    private boolean Check(EditText edtOP, EditText edtNP, EditText edtRNP) {
        String sOP = edtOP.getText().toString(),
                sNP = edtNP.getText().toString(),
                sRNP = edtRNP.getText().toString(),
                ee = "Vui lòng không bỏ trống thông tin";
        boolean check = true;
        if(sOP.isEmpty()){
            edtOP.setError(ee);
            check = false;
        }
        if(sNP.isEmpty()){
            edtNP.setError(ee);
            check = false;
        }
        if(sRNP.isEmpty()){
            edtRNP.setError(ee);
            check = false;
        }
        if(!sNP.equals(sRNP)){
            edtRNP.setError("Mật khẩu nhập lại chưa khớp");
            check = false;
        }
        return check;
    }
}
