package poly.DuAn1.nhom2.MD18309.PRO1121.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import poly.DuAn1.nhom2.MD18309.PRO1121.fragments_mini.DanhSachHoaDonBan;
import poly.DuAn1.nhom2.MD18309.PRO1121.fragments_mini.DanhSachHoaDonNhap;

public class ViewPager2Adapter extends FragmentStateAdapter {

    public ViewPager2Adapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position == 0){
            return new DanhSachHoaDonBan();
        } else if (position == 1) {
            return new DanhSachHoaDonNhap();
        }else {
            return new DanhSachHoaDonBan();
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
