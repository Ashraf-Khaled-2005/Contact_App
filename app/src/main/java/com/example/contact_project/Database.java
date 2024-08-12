package com.example.contact_project;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class Database extends SQLiteOpenHelper {
    private String KTable_Name = "Users";
    private String KColum_UserName = "username";
    private String KColum_Number = "number";
    private SQLiteDatabase db;
    private ContentValues values;
private Cursor cursor;

    public Database(@Nullable Context context) {
        super(context, "Contact_Info", null, 6);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " +KTable_Name+ "(id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + KColum_UserName + " TEXT, "
                + KColum_Number + " TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }
    public void deleteAllUsers() {
        db = getWritableDatabase();
        db.delete(KTable_Name, null, null);  // This will delete all rows from the Users table
    }


    boolean InsertData(User user) {
        db = getWritableDatabase();
        values = new ContentValues();
        values.put(KColum_UserName, user.getName());
        values.put(KColum_Number, user.getNumber());
        long result=db.insert(KTable_Name,null,values);
        return  result>0;

    }
    ArrayList<User> GetAllData() {
        ArrayList<User> userArrayList = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();  // Ensure db is initialized properly

        Cursor cursor = null;
        try {
            cursor = db.rawQuery("SELECT * FROM " + KTable_Name, null);

            if (cursor != null && cursor.moveToFirst()) {
                do {
                    int id = cursor.getInt(0); // Use column names or indices
                    String name = cursor.getString(1);
                    String number = cursor.getString(2);
                    userArrayList.add(new User(id, name, number));
                } while (cursor.moveToNext());
            }
        } catch (Exception e) {
            e.printStackTrace();  // Log the exception if needed
        } finally {
            if (cursor != null) {
                cursor.close();  // Always close the cursor to avoid memory leaks
            }
        }

        return userArrayList;  // Return the list which will be empty if no rows are found
    }

}