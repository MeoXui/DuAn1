package poly.DuAn1.nhom2.MD18309.PRO1121;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBFucker extends SQLiteOpenHelper {
    public DBFucker(@Nullable Context context) {
        super(context, "DA1", null, 3);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableTaiKhoan = "CREATE TABLE TAIKHOAN(UserName TEXT PRIMARY KEY, Password TEXT NOT NULL, ROLE TEXT NOT NULL, HoTen TEXT NOT NULL, Phone TEXT(10) NOT NULL, Email TEXT NOT NULL)";
        db.execSQL(createTableTaiKhoan);
        String createTableNhaCungCap = "CREATE TABLE NHACUNGCAP(idNCC INTEGER PRIMARY KEY, TenNCC TEXT NOT NULL, NguoiDaiDien TEXT NOT NULL, DiaChi TEXT NOT NULL, Sdt TEXT NOT NULL)";
        db.execSQL(createTableNhaCungCap);
        String createTableNganhHang = "CREATE TABLE NGANHHANG(idNH INTEGER PRIMARY KEY, TenNH TEXT NOT NULL)";
        db.execSQL(createTableNganhHang);
        String createTableKhachHang = "CREATE TABLE KHACHHANG(idKH INTEGER PRIMARY KEY, HoTen TEXT NOT NULL, Email TEXT NOT NULL, SdtKH TEXT NOT NULL)";
        db.execSQL(createTableKhachHang);
        String createTableCongViec = "CREATE TABLE CONGVIEC(idCV INTEGER PRIMARY KEY, idQuanLy REFERENCES TAIKHOAN(UserName), idNhanVien REFERENCES TAIKHOAN(UserName), TieuDe TEXT NOT NULL, MoTa TEXT NOT NULL, ThoiHan TEXT NOT NULL, TrangThai INTEGER NOT NULL)";
        db.execSQL(createTableCongViec);
        String createTableMatHang = "CREATE TABLE MATHANG(idMH INTEGER PRIMARY KEY, idNCC REFERENCES NhaCungCap(idNCC), idNH REFERENCES NganhHang(idNH), TenMH TEXT NOT NULL, SoLuong REAL NOT NULL,DVT TEXT NOT NULL, GiaNhap INTEGER NOT NULL, GiaBan INTEGER NOT NULL)";
        db.execSQL(createTableMatHang);

        //Dữ liệu mẫu
        String dummyTaiKhoan = "INSERT INTO TAIKHOAN VALUES('admin', 'test1', 'quanly', 'Nguyễn Em Tuấn', '0987654321', 'test@test.com')";
        db.execSQL(dummyTaiKhoan);
        String dummyNhaCungCap = "INSERT INTO NHACUNGCAP VALUES(1, 'NCC1', 'NDD1', 'Địa Chỉ 1', '0123456789'),(2, 'NCC2', 'NDD2', 'Địa Chỉ 2', '0123654789'),(3, 'NCC3', 'NDD3', 'Địa Chỉ 3', '0123456987')";
        db.execSQL(dummyNhaCungCap);
        String dummyNganhHang = "INSERT INTO NGANHHANG VALUES(1, 'Nganh Hang 1'),(2, 'Nganh Hang 2'),(3, 'Nganh Hang 3')";
        db.execSQL(dummyNganhHang);
        String dummyKhachHang = "INSERT INTO KHACHHANG VALUES(1, 'KH1', 'Email1', '0911111111'),(2, 'KH2', 'Email2', '0922222222'),(3, 'KH3', 'Email3', '0933333333')";
        db.execSQL(dummyKhachHang);
        String dummyCongViec = "INSERT INTO CONGVIEC VALUES(1, 'admin', 'nhanvien1', 'Dọn Kho', 'Còn gì để nói k?', '01-01-2069', 0), (2, 'admin', 'nhanvien2', 'Sắp Xếp Kho', 'Sắp Xếp Hàng Mới Về', '01-02-2069', 0)";
        db.execSQL(dummyCongViec);
        String dummyMatHang = "INSERT INTO MATHANG VALUES(1, 1, 1, 'MH1', 1, 'KG', 10000, 20000),(2, 3, 3, 'MH1', 3, 'Tấn', 20000, 69000)";
        db.execSQL(dummyMatHang);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion){
            String deleteTaiKhoan = "DROP TABLE IF EXISTS TAIKHOAN";
            db.execSQL(deleteTaiKhoan);
            String deleteNhaCungCap = "DROP TABLE IF EXISTS NHACUNGCAP";
            db.execSQL(deleteNhaCungCap);
            String deleteNganhHang = "DROP TABLE IF EXISTS NGANHHANG";
            db.execSQL(deleteNganhHang);
            String deleteKhachHang = "DROP TABLE IF EXISTS KHACHHANG";
            db.execSQL(deleteKhachHang);
            String deleteCongViec = "DROP TABLE IF EXISTS CONGVIEC";
            db.execSQL(deleteCongViec);
            String deleteMatHang = "DROP TABLE IF EXISTS MATHANG";
            db.execSQL(deleteMatHang);
            onCreate(db);
        }
    }
}
