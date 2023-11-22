package poly.DuAn1.nhom2.MD18309.PRO1121;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import poly.DuAn1.nhom2.MD18309.PRO1121.ObjectClass.TaiKhoan;
import poly.DuAn1.nhom2.MD18309.PRO1121.fragments.HoaDon;
import poly.DuAn1.nhom2.MD18309.PRO1121.fragments.KhoHang;
import poly.DuAn1.nhom2.MD18309.PRO1121.fragments.Menu;
import poly.DuAn1.nhom2.MD18309.PRO1121.fragments.TrangChu;

public class MainActivity extends AppCompatActivity {
    private FragmentManager fragmentManager;
    private KhoHang khoHang = null;
    private HoaDon hoaDon = null;
    private Menu menu = null;
    private TrangChu trangChu = null;
    private TaiKhoan taiKhoan = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();

        if(savedInstanceState != null){
            taiKhoan = (TaiKhoan) savedInstanceState.getSerializable(login_screen.KEY_TK);
        }else {
            taiKhoan = (TaiKhoan) getIntent().getSerializableExtra(login_screen.KEY_TK);
        }
        trangChu = new TrangChu(taiKhoan);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNav);
        bottomNavigationView.setItemRippleColor(null);
        bottomNavigationView.setSelectedItemId(R.id.trangchu);
        fragmentManager.beginTransaction().replace(R.id.framelayout, trangChu).commit();

        bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.trangchu) {
                trangChu = new TrangChu(taiKhoan);
                fragmentManager.beginTransaction().replace(R.id.framelayout, trangChu).commit();
            } else if (item.getItemId() == R.id.hoadon) {
                hoaDon = new HoaDon();
                fragmentManager.beginTransaction().replace(R.id.framelayout, hoaDon).commit();
            } else if (item.getItemId() == R.id.khohang) {
                khoHang = new KhoHang();
                fragmentManager.beginTransaction().replace(R.id.framelayout, khoHang).commit();
            } else if (item.getItemId() == R.id.menu) {
                menu = new Menu();
                fragmentManager.beginTransaction().replace(R.id.framelayout, menu).commit();
            }
            return true;
        });
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        System.out.println(taiKhoan.getHoTen());
        outState.putSerializable(login_screen.KEY_TK, taiKhoan);
    }

}