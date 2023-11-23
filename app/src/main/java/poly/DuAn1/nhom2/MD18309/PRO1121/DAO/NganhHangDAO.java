package poly.DuAn1.nhom2.MD18309.PRO1121.DAO;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import poly.DuAn1.nhom2.MD18309.PRO1121.DBFucker;
import poly.DuAn1.nhom2.MD18309.PRO1121.ObjectClass.NganhHang;

public class NganhHangDAO {
    private final DBFucker dbFucker;

    public NganhHangDAO(Context context) {
        this.dbFucker = new DBFucker(context);
    }

    public ArrayList<NganhHang> getNganhHangList(){
        SQLiteDatabase database = dbFucker.getReadableDatabase();
        ArrayList<NganhHang> listNH = new ArrayList<>();
        database.beginTransaction();
        try{
            Cursor cursor = database.rawQuery("SELECT * FROM NGANHHANG", null);
            if(cursor != null && cursor.getCount() > 0){
                cursor.moveToFirst();
                while (!cursor.isAfterLast()) {
                    listNH.add(new NganhHang(cursor.getInt(0), cursor.getString(1)));
                    cursor.moveToNext();
                }
                cursor.close();
            }
            database.setTransactionSuccessful();
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            database.endTransaction();
        }
        return listNH;
    }
}
