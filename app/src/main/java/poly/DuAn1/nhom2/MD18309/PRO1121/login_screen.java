package poly.DuAn1.nhom2.MD18309.PRO1121;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import poly.DuAn1.nhom2.MD18309.PRO1121.DAO.TaiKhoanDAO;
import poly.DuAn1.nhom2.MD18309.PRO1121.ObjectClass.TaiKhoan;

public class login_screen extends AppCompatActivity {
    public static final String KEY_TK = "TK";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        Handler handler = new Handler();

//        ThuThuDAO thuThuDAO = new ThuThuDAO(Activity_Login.this);
        TaiKhoanDAO taiKhoanDAO = new TaiKhoanDAO(login_screen.this);

        EditText edtUsername = findViewById(R.id.edtUsername);
        EditText edtPassword = findViewById(R.id.edtPassword);
        Button btnForgot = findViewById(R.id.btnForgot);
        Button btnLogin = findViewById(R.id.btnLogin);
        CheckBox rememberMe = findViewById(R.id.chkRemember);
        TextInputLayout edtUsernameLayout = findViewById(R.id.edtUsernameLayout);
        TextInputLayout edtPasswordLayout = findViewById(R.id.edtPasswordLayout);

        SharedPreferences sharedPreferences = getSharedPreferences("DBRR", MODE_PRIVATE);

        if (sharedPreferences.getBoolean("remember", false)){
            rememberMe.setChecked(sharedPreferences.getBoolean("remember", false));
            edtUsername.setText(sharedPreferences.getString("TK", ""));
            edtPassword.setText(sharedPreferences.getString("MK", ""));
        }

        btnForgot.setOnClickListener(v -> {
            edtUsername.setText("");
            edtUsername.clearFocus();
            edtPassword.setText("");
            edtPassword.clearFocus();
            rememberMe.setChecked(false);
        });

        btnLogin.setOnClickListener(v -> {
            String tk = edtUsername.getText().toString();
            String mk = edtPassword.getText().toString();
            if (tk.isEmpty() && mk.isEmpty()) {
                edtUsernameLayout.setError("Không Được Để Trống Bạn Êyyy >:Đ");
                edtPasswordLayout.setError("Không Được Để Trống Bạn Êyyy >:Đ");
                rememberMe.setEnabled(false);
                Runnable runnable = () -> {
                    edtUsernameLayout.setErrorEnabled(false);
                    edtPasswordLayout.setErrorEnabled(false);
                    rememberMe.setEnabled(true);
                };
                handler.postDelayed(runnable, 1000);
            }else if (tk.isEmpty()){
                edtUsernameLayout.setError("Không Được Để Trống Bạn Êyyy >:Đ");
                rememberMe.setEnabled(false);
                Runnable runnable = () ->{
                    edtUsernameLayout.setErrorEnabled(false);
                    rememberMe.setEnabled(true);
                };
                handler.postDelayed(runnable, 1000);
            }else if (mk.isEmpty()){
                edtPasswordLayout.setError("Không Được Để Trống Bạn Êyyy >:Đ");
                rememberMe.setEnabled(false);
                Runnable runnable = () -> {
                    edtPasswordLayout.setErrorEnabled(false);
                    rememberMe.setEnabled(true);
                };
                handler.postDelayed(runnable, 1000);
            } else{
                TaiKhoan taiKhoan = taiKhoanDAO.login(tk, mk);
                if (taiKhoan != null) {
                    edtUsername.setText("");
                    edtPassword.setText("");
                    Intent login = new Intent(login_screen.this, MainActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable(KEY_TK, taiKhoan);
                    login.putExtras(bundle);
                    startActivity(login);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("TK", tk);
                    editor.putString("MK", mk);
                    editor.putBoolean("remember", rememberMe.isChecked());
                    editor.apply();
                    Toast.makeText(login_screen.this, "Đăng Nhập Thành Công", Toast.LENGTH_SHORT).show();
                }else{
                    edtUsernameLayout.setError("Chắc Là Sai Đó :V");
                    edtPasswordLayout.setError("Chắc Là Sai Đó :V");
                    rememberMe.setEnabled(false);
                    Runnable runnable = () -> {
                        edtUsernameLayout.setErrorEnabled(false);
                        edtPasswordLayout.setErrorEnabled(false);
                        rememberMe.setEnabled(true);
                    };
                    handler.postDelayed(runnable, 1200);
//                    Toast.makeText(login_screen.this, "Đăng Nhập Thành Bại", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}