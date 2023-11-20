package poly.DuAn1.nhom2.MD18309.PRO1121;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import poly.DuAn1.nhom2.MD18309.PRO1121.fragments.HoaDon;
import poly.DuAn1.nhom2.MD18309.PRO1121.fragments.KhoHang;
import poly.DuAn1.nhom2.MD18309.PRO1121.fragments.Menu;
import poly.DuAn1.nhom2.MD18309.PRO1121.fragments.TrangChu;

public class MainActivity extends AppCompatActivity {
    private final FragmentManager fragmentManager = getSupportFragmentManager();
    KhoHang khoHang = null;
    HoaDon hoaDon = null;
    Menu menu = null;
    TrangChu trangChu = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNav);
        bottomNavigationView.setItemRippleColor(null);
        bottomNavigationView.setSelectedItemId(R.id.trangchu);
        fragmentManager.beginTransaction().replace(R.id.framelayout, new TrangChu()).commit();


        bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.trangchu) {
                trangChu = new TrangChu();
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
}