package com.example.phone;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

public class dbcon extends SQLiteOpenHelper {

    public static class FeedEntry implements BaseColumns {

        private static final String TABLE_NAME = "cart";
        private static final String COLUMN_ID = "Id";
        private static final String COLUMN_ITEM = "Item";
        /*private static final String COLUMN_COLOR = "Color";
        private static final String COLUMN_MEMORY = "Memory";*/
        private static final String COLUMN_QNT = "Qnt";
        private static final String COLUMN_TOTAL = "Totl";
    }

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "contacts.db";
    SQLiteDatabase db;

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + FeedEntry.TABLE_NAME + " (" +
                    FeedEntry.COLUMN_ID + "  INTEGER PRIMARY KEY," +
                    FeedEntry.COLUMN_ITEM + " TEXT," +
                    //FeedEntry.COLUMN_COLOR + " TEXT," +
                    //FeedEntry.COLUMN_MEMORY + " TEXT," +
                    FeedEntry.COLUMN_QNT + " TEXT,"+
                    FeedEntry.COLUMN_TOTAL + " TEXT)";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + FeedEntry.TABLE_NAME;


    public dbcon(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
    public Cursor getdata(){
        db=getWritableDatabase();
        Cursor res=db.rawQuery("SELECT * FROM cart",null);
        return res;

    }

    public void InsertContacts(Contact contact) {
        db = getWritableDatabase();
        //To get , how many column in ur table
        String query = "SELECT * FROM " + FeedEntry.TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        int count = cursor.getCount();

        ContentValues contentvalues = new ContentValues();
        contentvalues.put(FeedEntry.COLUMN_ID, count + 1);
        contentvalues.put(FeedEntry.COLUMN_ITEM , contact.Getitem());

        contentvalues.put(FeedEntry.COLUMN_QNT, contact.Getqnt());
        contentvalues.put(FeedEntry.COLUMN_TOTAL, contact.Gettotal());
        db.insert(FeedEntry.TABLE_NAME, null, contentvalues);
        db.close();
    }


}