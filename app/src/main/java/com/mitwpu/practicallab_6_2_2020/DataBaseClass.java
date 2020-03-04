package com.mitwpu.practicallab_6_2_2020;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;
import android.util.Log;

public class DataBaseClass extends SQLiteOpenHelper {
/*
    public static final String DATABASE_NAME="student.db";
    public static final String TABLE_NAME="student_table";
    public static final String COL_1="ID";
    public static final String COL_2="NAME";
    public static final String COL_3="SURNAME";
    public static final String COL_4="MARKS";*/


    SQLiteDatabase sqLiteDatabaseObj;//instance for the entire database



    public DataBaseClass(Context context,String database_Name) {
        super(context, database_Name, null, 1);
        sqLiteDatabaseObj=this.getWritableDatabase();
        onCreate(sqLiteDatabaseObj);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public Boolean createTable(String createTableQuery){
        // template CREATE TABLE IF NOT EXISTS student(ID INTEGER PRIMARY KEY AUTOINCREMENT , NAME TEXT,SURNAME TEXT,MARKS INTEGER)

        try
        {
            sqLiteDatabaseObj.execSQL(createTableQuery);
            return true;//if the query executes properly return true
        }
        catch (Exception e)
        {
            return false;//if the query execution  throws an error return false
        }

    }


    public Boolean deleteData(String deleteSql){

        try{
            //delete from student where ID="+id;
            sqLiteDatabaseObj.execSQL(deleteSql);
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }



    }

    public Boolean insertData(String insertSql){
        try{
            sqLiteDatabaseObj.execSQL(insertSql);
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }

    public Cursor display(String selectQuery){
        try{
            Cursor cursor=sqLiteDatabaseObj.rawQuery(selectQuery,null);
            return cursor;
        }
        catch (Exception e)
        {
            return null;
        }
    }







}
