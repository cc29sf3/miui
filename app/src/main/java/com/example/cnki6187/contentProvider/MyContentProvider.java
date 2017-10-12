package com.example.cnki6187.contentProvider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.icu.text.StringSearch;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;


/**
 * Created by cnki6187 on 2017/10/10.
 */

public class MyContentProvider extends ContentProvider {

    //static final String PROVIDER_NAME ="com.example.cnki6187.contentProvider.MyContentProvider";
    static public final Uri uri=Uri.parse("content://com.example.cnki6187.contentProvider.MyContentProvider/users");
    static private final int USERS=1;
    static private final int USER_ID=0;
    public static final UriMatcher uriMatcher;
    static{
        uriMatcher=new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(uri.getAuthority(),"users",USERS);
        uriMatcher.addURI(uri.getAuthority(),"users/#",USER_ID);
    }

    private MySqliteHelper sqliteHelper;
    private SQLiteDatabase wdb;
    private SQLiteDatabase rdb;

    @Override
    public boolean onCreate() {
        sqliteHelper= MySqliteHelper.getInstance(getContext());
        wdb=sqliteHelper.getWritableDatabase();
        rdb=sqliteHelper.getReadableDatabase();
        return false;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        if(sqliteHelper==null)
            return null;
        int result=uriMatcher.match(uri);
        switch (result)
        {
            case USERS:
                return rdb.query(MySqliteHelper.TestTable.TABLE_NAME,projection,selection,selectionArgs,null,null,sortOrder);
            case USER_ID:
                return rdb.query(MySqliteHelper.TestTable.TABLE_NAME,projection,
                        MySqliteHelper.TestTable._ID+"=?",
                        new String[]{uri.getLastPathSegment()},
                        null,null,sortOrder);
            default:
                return null;
        }
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        if(sqliteHelper==null)
            return null;
        long id=wdb.insert(MySqliteHelper.TestTable.TABLE_NAME,null,values);
        if(id>0)
            return Uri.withAppendedPath(uri, String.valueOf(id));
        else
            return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        if(sqliteHelper==null)
            return 0;
        int result=uriMatcher.match(uri);
        switch (result){
            case USERS:
                return wdb.delete(MySqliteHelper.TestTable.TABLE_NAME,selection,selectionArgs);
            case USER_ID:
                return wdb.delete(MySqliteHelper.TestTable.TABLE_NAME,
                        MySqliteHelper.TestTable._ID+"=?",
                        new String[] {uri.getLastPathSegment()});
            default:
                return 0;
        }

    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        if(sqliteHelper==null)
            return 0;
        int result=uriMatcher.match(uri);
        switch (result) {
            case USERS:
                return wdb.update(MySqliteHelper.TestTable.TABLE_NAME,values,selection,selectionArgs);
            case USER_ID:
                return wdb.update(MySqliteHelper.TestTable.TABLE_NAME,values,
                        MySqliteHelper.TestTable._ID+"=?",
                        new String[] {uri.getLastPathSegment()});
            default:
                return 0;
        }
    }
}
