package com.team5.myapplication;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.util.Log;

import androidx.annotation.Nullable;

import com.team5.model.Feedback;

import java.util.ArrayList;
import java.util.List;

public class MyDataBase extends SQLiteOpenHelper {
    private static final int DB_VERSION = 1;
    private static final  String DB_NAME = "danhgia.sqlite";
    private static final String TBL_NAME="Baidanhgia";
    private static final String COL_B_ID="B_ID";
    private static final String COL_B_DES="B_Des";
    private static final String COL_B_PHOTO="B_Photo";

    public MyDataBase(@Nullable Context context){
                      super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql= "CREATE TABLE IF NOT EXISTS " + TBL_NAME + "(" + COL_B_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                 + COL_B_DES + " VARCHAR(200)," + COL_B_PHOTO + " BLOB)"  ;
                sqLiteDatabase.execSQL(sql);
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TBL_NAME);
        onCreate(sqLiteDatabase);
    }
    public void queryExec( String sql){
        SQLiteDatabase db=getWritableDatabase();
        db.execSQL(sql);
    }
    public Cursor getData(String sql){
        SQLiteDatabase db= getWritableDatabase();
        return db.rawQuery(sql, null);
    }
    public List<Feedback> getAllFeedbacks() {
        List<Feedback> feedbackList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        // Truy vấn dữ liệu từ bảng Baidanhgia
        String query = "SELECT * FROM " + TBL_NAME;
        Cursor cursor = db.rawQuery(query, null);

        if (cursor != null) {
            while (cursor.moveToNext()) {
                // Lấy dữ liệu từ cursor
                int idIndex = cursor.getColumnIndex(COL_B_ID);
                int desIndex = cursor.getColumnIndex(COL_B_DES);
                int photoIndex = cursor.getColumnIndex(COL_B_PHOTO);

                if (idIndex == -1 || desIndex == -1 || photoIndex == -1) {
                    // Xử lý trường hợp không tìm thấy cột
                    Log.e("DatabaseError", "Column not found");
                } else {
                    int id = cursor.getInt(idIndex);
                    String description = cursor.getString(desIndex);
                    byte[] photo = cursor.getBlob(photoIndex);
                    Feedback feedback = new Feedback(id, description, photo);
                    feedbackList.add(feedback);
                }
            }
            cursor.close();
        }
        return feedbackList;
    }

    public boolean insertData(String des, byte[] photo){
        try {
            SQLiteDatabase db = getWritableDatabase();
            String sql = "INSERT INTO " + TBL_NAME + " VALUES(null, ?, ?)";
            SQLiteStatement statement = db.compileStatement(sql);

            statement.bindString(1, des);

            if (photo != null) {
                statement.bindBlob(2, photo);
            } else {
                statement.bindNull(2); // Gắn giá trị NULL nếu photo không có
            }

            statement.executeInsert();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
