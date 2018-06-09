package com.example.android.p8_;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.android.p8_.ContractClass.BooksEntry;

public class HelperClass extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "bookstore.db";
    private static final int DATABASE_VERSION = 1;

    public HelperClass(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_ENTRIES =
                "CREATE TABLE " + BooksEntry.TABLE_NAME + " (" +
                BooksEntry._ID + " INTEGER PRIMARY KEY, " +
                BooksEntry.COLUMN_NAME + " TEXT NOT NULL, " +
                BooksEntry.COLUMN_PRICE + " INTEGER  NOT NULL, " +
                BooksEntry.COLUMN_QUANTITY + " INTEGER, " +
                BooksEntry.COLUMN_IMAGE + " TEXT, " +
                BooksEntry.COLUMN_SUPPLIER + " TEXT, " +
                BooksEntry.COLUMN_SUPER_PHONE_NUMBER + " INTEGER);";

        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // exec delete
        onCreate(db);
    }
}
