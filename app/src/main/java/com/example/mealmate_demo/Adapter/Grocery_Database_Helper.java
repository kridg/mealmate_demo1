package com.example.mealmate_demo.Adapter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.util.Log;

import androidx.annotation.Nullable;

public class Grocery_Database_Helper extends SQLiteOpenHelper {
    public static final String TABLE_NAME="grocery_table";
    public static final String COLUMN="id";
    public static final String PRICE="price";
    public static final String DESCRIPTION="description";
    public static final String IMAGE="image";
    public static final String PURCHASE="purchase";

    public Grocery_Database_Helper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlQuery= "CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                TABLE_NAME + " TEXT NOT NULL, " +
                PRICE + " TEXT NOT NULL, " +
                DESCRIPTION + " TEXT, " +
                IMAGE + " TEXT, " +
                PURCHASE + " INTEGER)";
        db.execSQL(sqlQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sqlQuery= "DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(sqlQuery);
        onCreate(db);
    }
    public Cursor queryData(String sqlQuery){
        SQLiteDatabase db=getWritableDatabase();
        return db.rawQuery(sqlQuery,null);
    }
    public Boolean insert(
            String name,
            double price,
            String description,
            String image,
            boolean purchase
    ) {
        SQLiteDatabase database = getWritableDatabase();
        String sql = "INSERT INTO " + TABLE_NAME + " VALUES (NULL, ?, ?, ?, ?, ?)";
        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();
        statement.bindString(1, name);
        statement.bindDouble(2, price);
        statement.bindString(3, description);
        statement.bindString(4, image);
        statement.bindLong(5, purchase ? 1 : 0);
        long result = statement.executeInsert();
        database.close();
        return result != -1;
    }
    public Cursor getElementById(int id) {
        SQLiteDatabase database = getWritableDatabase();

        String sqlQuery = "SELECT * FROM " + TABLE_NAME + " WHERE "+ COLUMN +"=?";
        return database.rawQuery(
                sqlQuery,
                new String[]{String.valueOf(id)}
        );
    }
    public Cursor getAll() {
        SQLiteDatabase database = getReadableDatabase();
        String sqlQuery = "SELECT * FROM " + TABLE_NAME;
        return database.rawQuery(sqlQuery, null);
    }

    public Boolean update(
            int id,
            String name,
            double price,
            String description,
            String image,
            boolean purchased
    ) {
        SQLiteDatabase database = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(TABLE_NAME, name);
        cv.put(PRICE, price);
        cv.put(DESCRIPTION, description);
        cv.put(IMAGE, image);
        cv.put(PURCHASE, purchased);
        int result = database.update(TABLE_NAME, cv, COLUMN+ "=?", new String[]{String.valueOf(id)});
        Log.d("Database helper:", "result: "+ result);
        database.close();
        return result != -1;
    }
    public void delete(long id) {
        SQLiteDatabase database = getWritableDatabase();
        database.delete(
                TABLE_NAME,
                COLUMN + "=?",
                new String[]{String.valueOf(id)});
    }
}
