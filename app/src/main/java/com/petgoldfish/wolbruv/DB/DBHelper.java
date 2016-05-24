package com.petgoldfish.wolbruv.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    //Table Name
    public static final String TABLE_NAME = "device";
    //Column Names
    public static final String COL_ID = "_id";
    public static final String COL_MAC = "_MAC";
    public static final String COL_IP = "_IP";
    public static final String COL_ALIAS = "_alias";
    static final String[] columns = new String[]{DBHelper.COL_ID,
            DBHelper.COL_MAC, DBHelper.COL_IP,
            DBHelper.COL_ALIAS};
    //Database Information
    private static final String DATABASE_NAME = "device.db";
    private static final int DATABASE_VERSION = 1;

    // creation SQLite statement
    private static final String DATABASE_CREATE = "CREATE TABLE " + TABLE_NAME
            + "(" + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COL_MAC + " TEXT NOT NULL, " + COL_IP + " TEXT," + COL_ALIAS + " TEXT NOT NULL);";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        System.out.println("DB Created");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE);
        System.out.println("Table Created");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
        System.out.println("DB Updated");
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}