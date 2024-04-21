package com.example.cupcake;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBConnector extends SQLiteOpenHelper
{
    public DBConnector(Context context)
    {
        super(context, "Cupcake", null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE user_infor (ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, Name VARCHAR, Email VARCHAR, MobileNo VARCHAR, Password VARCHAR, Usertype VARCHAR)");
        db.execSQL("create table Category (CategoryID VARCHAR PRIMARY KEY  NOT NULl, CategoryName VARCHAR)");
        db.execSQL("create table Product (ProductID VARCHAR PRIMARY KEY  NOT NULL,ProductName VARCHAR,CategoryID VARCHAR, Quantity INTEGER, Price INTEGER, FOREIGN KEY(CategoryID) REFERENCES Category(CategoryID) )");
        db.execSQL("create table Orders (OrderID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULl, CustomerName VARCHAR, ProductID VARCHAR, Quantity INTEGER, Total INTEGER, FOREIGN KEY(ProductID) REFERENCES Product(ProductID))");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }
}
