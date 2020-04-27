package com.example.login;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;

import com.example.login.room.app.App;
import com.example.login.room.dao.UserDao;
import com.example.login.room.database.AppDataBase;
import com.example.login.room.entity.User;

public class MyContentProvider extends ContentProvider {

   private final String TAG = "MyProvider";
   private static final String AUTHORITY = "com.example.login.provider";
   private static final String USER = "user";

   private static final UriMatcher URI_MATCHER = new UriMatcher(UriMatcher.NO_MATCH);

   private static final int USER_TABLE_CODE = 100;
   private static final int USER_ROW_CODE = 101;

   private UserDao dataBase;

   static {
       URI_MATCHER.addURI(AUTHORITY, USER,USER_TABLE_CODE);
       URI_MATCHER.addURI(AUTHORITY, USER + "/*",USER_ROW_CODE);
   }

    public MyContentProvider() {
    }

    @Override
    public boolean onCreate() {
        if (getContext() != null)
        {
            dataBase = App.getRoomComponent().getAppDataBase().userDao();
            return true;
        }
        return false;
    }



    @Override
    public String getType(Uri uri) {
        switch (URI_MATCHER.match(uri))
        {
                case USER_TABLE_CODE:
                    return "vnd.android.cursor.dir/" + AUTHORITY + "." + USER;
                case USER_ROW_CODE:
                    return "vnd.android.cursor.item/" + AUTHORITY + "." + USER;
                default:
                    throw new UnsupportedOperationException("Not yet implemented");

        }
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {

        int code = URI_MATCHER.match(uri);

        if (code != USER_TABLE_CODE && code != USER_ROW_CODE) return null;

        if (code == USER_TABLE_CODE)
        {
            return dataBase.getTadble();
        }
        else
        {
            return dataBase.getTadbleItem(ContentUris.parseId(uri));
        }
   }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        // TODO: Implement this to handle requests to insert a new row.
        throw new UnsupportedOperationException("Not yet implemented");
    }





    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        // TODO: Implement this to handle requests to update one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        // Implement this to handle requests to delete one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
