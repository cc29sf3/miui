package com.example.cnki6187.contentProvider;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

/**
 * Created by cnki6187 on 2017/10/11.
 */

public class MySqliteHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "test.db";
    private static final String SQL_DELETE_TEST_TABLE = "DROP TABLE IF EXISTS " +
            TestTable.TABLE_NAME;
    private static final String SQL_CREATE_TEST_TABLE = "CREATE TABLE " + TestTable.TABLE_NAME +
            " (" +
            TestTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            TestTable.COLUMN_NAME_NAME + " TEXT, " +
            TestTable.COLUMN_NAME_AGE + " INTEGER, " +
            TestTable.COLUMN_NAME_HEAD_ID + " INTEGER, " +
            " )";



    private static MySqliteHelper mInstance;
    public SQLiteDatabase wdb;
    public SQLiteDatabase rdb;

    public static MySqliteHelper getInstance(Context context) {
        if(mInstance==null){
            synchronized(MySqliteHelper.class){
                if(mInstance==null){
                    mInstance=new MySqliteHelper(context);
                }
            }
        }
        return mInstance;
    }

    private MySqliteHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
        wdb=mInstance.getWritableDatabase();
        rdb=mInstance.getReadableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TEST_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_TEST_TABLE);
        onCreate(db);
    }

    public class TestTable implements BaseColumns{
        public static final String TABLE_NAME = "user";
        public static final String COLUMN_NAME_NAME = "name";
        public static final String COLUMN_NAME_AGE = "age";
        public static final String COLUMN_NAME_HEAD_ID = "headID";
    }
}
