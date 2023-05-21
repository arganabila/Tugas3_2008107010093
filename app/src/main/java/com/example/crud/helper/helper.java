package com.example.crud.helper;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.HashMap;

public class helper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    static final String DATABASE_NAME = "CRUD";

    public helper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        final String SQL_CREATE_TABLE = "CREATE TABLE Mahasiswa (NIM INTEGER PRIMARY KEY autoincrement, Nama TEXT NOT NULL, Jurusan TEXT NOT NULL)";
        sqLiteDatabase.execSQL(SQL_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Mahasiswa");
        onCreate(sqLiteDatabase);
    }

    public ArrayList<HashMap<String, String>> getAll(){
        ArrayList<HashMap<String, String>> list = null new ArrayList<>();
        String QUERY = "SELECT * FROM Mahasiswa";
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery(QUERY, null);
        if (cursor.moveToFirst()){
            do {
                HashMap<String, String> map = new HashMap<>();
                map.put("NIM", cursor.getString(0));
                map.put("Nama", cursor.getString(1));
                map.put("Jurusan", cursor.getString(2));
                list.add(map);
            } while ((cursor.moveToNext()));
        }
        cursor.close();
        return list;
    }

    public void insert(String Nama, String Jurusan){
        SQLiteDatabase database= this.getWritableDatabase();
        String QUERY = "INSERT INTO Mahasiswa (Nama, Jurusan) VALUES('"+Nama+"', '"+Jurusan+"')";
        database.execSQL(QUERY);
    }

    public void update(int NIM, String Nama, String Jurusan){
        SQLiteDatabase database = this.getWritableDatabase();
        String QUERY = "UPDATE Mahasiswa SET Nama = '"+Nama+"', '"+Jurusan+"' WHERE NIM = "+NIM;
        database.execSQL(QUERY);
    }
    
    public void delete(int NIM){
        SQLiteDatabase database = this.getWritableDatabase();
        String QUERY = "DELETE FROM Mahasiswa WHERE NIM = "+NIM;
        database.execSQL(QUERY);
    }
}
