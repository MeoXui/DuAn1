package poly.DuAn1.nhom2.MD18309.PRO1121.DAO;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import poly.DuAn1.nhom2.MD18309.PRO1121.DBFucker;
import poly.DuAn1.nhom2.MD18309.PRO1121.ObjectClass.NhaCungCap;

public class NhaCungCapDAO {

    private DBFucker dbFucker;

    public NhaCungCapDAO(Context context) {
        this.dbFucker = new DBFucker(context);
    }

    public ArrayList<NhaCungCap> getNhaCungCapList(){
        SQLiteDatabase database = dbFucker.getReadableDatabase();
        ArrayList<NhaCungCap> listNCC = new ArrayList<>();
        database.beginTransaction();
        try{
            Cursor cursor = database.rawQuery("SELECT * FROM NhaCungCap", null);
            if(cursor != null && cursor.getCount() > 0){
                cursor.moveToFirst();
                while (!cursor.isAfterLast()) {
                    listNCC.add(new NhaCungCap(cursor.getInt(0), cursor.getString(1), cursor.getString(4), cursor.getString(2), cursor.getString(3)));
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
        return listNCC;
    }
    
}
