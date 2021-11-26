package com.example.login_data;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class Logindb extends SQLiteOpenHelper {
public static final String dbname="Ldb.db";
public static  final String tbname="tb";
    public static  final String F1="name";
    public static  final String F2="pwd";
    public Logindb( Context context) {
        super(context, dbname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String Q1=" CREATE TABLE "+tbname+" ( " + F1 + " TEXT, " + F2 + " TEXT)";

        db.execSQL(Q1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
 db.execSQL("DROP TABLE IF EXISTS "+tbname);
    }

    public void addNewUser(String Uname,String Pwd)
    {
        SQLiteDatabase db1=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(F1,Uname);
        values.put(F2,Pwd);
        db1.insert(tbname,null,values);
        db1.close();
    }

}
