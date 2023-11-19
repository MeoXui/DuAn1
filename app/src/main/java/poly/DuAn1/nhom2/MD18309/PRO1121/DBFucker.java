package poly.DuAn1.nhom2.MD18309.PRO1121;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBFucker extends SQLiteOpenHelper {
    public DBFucker(@Nullable Context context) {
        super(context, "DA1", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableTaiKhoan = "CREATE TABLE TAIKHOAN(UserName TEXT PRIMARY KEY, Password TEXT NOT NULL, ROLE TEXT NOT NULL, HoTen TEXT NOT NULL, Phone TEXT(10) NOT NULL, Email TEXT NOT NULL)";
        db.execSQL(createTableTaiKhoan);
        String dummyTaiKhoan = "INSERT INTO TAIKHOAN VALUES('admin', 'test1', 'quanly', 'Nguyễn Em Tuấn', '0987654321', 'test@test.com')";
        db.execSQL(dummyTaiKhoan);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion){
            String deleteTaiKhoan = "DROP TABLE IF EXISTS TAIKHOAN";
            db.execSQL(deleteTaiKhoan);
            onCreate(db);
        }
    }
}
