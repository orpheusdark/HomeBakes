package com.example.cupcake;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class DBHelper
{
    private Context con;
    private SQLiteDatabase db;

    public DBHelper(Context con)
    {
        this.con=con;
    }

    public DBHelper OpenDB()
    {
        DBConnector dbCon = new DBConnector(con);
        db=dbCon.getWritableDatabase();

        return this;
    }




//-------------------------------------- Registration --------------------------------------------//


    public boolean CreateUser(User user)
    {
        try
        {
            ContentValues cv = new ContentValues();
            cv.put("Name", user.getName());
            cv.put("Email", user.getEmail());
            cv.put("MobileNo", user.getMobileNo());
            cv.put("Password", user.getPassword());
            cv.put("Usertype", user.getUsertype());
            db.insert("user_infor",null, cv);
            return true;
        }
        catch (Exception ex)
        {
            Toast.makeText(con, ex.getMessage(), Toast.LENGTH_LONG).show();
            return false;
        }
    }




//-------------------------------------- Login ---------------------------------------------------//


    //check username and password correct for login and usertype return to display
    public ArrayList<User> ValidLogin(String Name, String Password)
    {
        ArrayList<User> userList = new ArrayList();
        try
        {
            Cursor cursor = db.rawQuery("Select * From user_infor Where Name ='"+Name+"' and Password = '"+Password+"' ", null);
            if (cursor.moveToFirst())
            {
                do {
                    User user = new User();
                    user.setName(cursor.getString(1));
                    user.setPassword(cursor.getString(4));
                    user.setUsertype(cursor.getString(5));

                    userList.add(user);
                }while (cursor.moveToNext());
            }
        }
        catch (Exception ex){
            Toast.makeText(con, ex.getMessage(), Toast.LENGTH_LONG).show();
        }
        return userList;

    }





//------------------------------------- Category -------------------------------------------------//


// Add Category
    public boolean InsertCategory(Category category) {
        try {
            ContentValues cv = new ContentValues();
            cv.put("CategoryId", category.getCategoryId());
            cv.put("CategoryName", category.getCategoryName());

            db.insert("Category", null, cv);
            return true;
        } catch (Exception ex) {
            Toast.makeText(con, ex.getMessage(), Toast.LENGTH_LONG).show();
        }
        return false;

    }



//View all category
    public  List<Category> ViewAllCategory()
    {
        List<Category> categorys = new ArrayList<>();

        Cursor cursor = db.rawQuery(" Select * From Category ", null);

        if (cursor.moveToFirst())
        {
            do{
                Category category = new Category();
                category.setCategoryId(cursor.getString(0));
                category.setCategoryName(cursor.getString(1));

                categorys.add(category);


            }while (cursor.moveToNext());
        }
        return categorys;

    }


//Delete Category
    public void deletecategory(String id)
    {
        db.delete("Category","CategoryID =?", new String[]{id});
        db.close();
    }


// update category value inserting after Category clicking
    public ArrayList<Category> updatecategoryinsert(String id)
    {
        ArrayList<Category> categoryList = new ArrayList();
        try
        {
            Cursor cursor = db.rawQuery("Select * From Category Where CategoryID ='"+id+"'", null);
            if (cursor.moveToFirst())
            {
                do {
                    Category category = new Category();
                    category.setCategoryId(cursor.getString(0));
                    category.setCategoryName(cursor.getString(1));


                    categoryList.add(category);
                }while (cursor.moveToNext());
            }
        }
        catch (Exception ex){
            Toast.makeText(con, ex.getMessage(), Toast.LENGTH_LONG).show();
        }
        return categoryList;

    }


//Update category
    public int UpdateCategory(Category category)
    {
        ContentValues cv = new ContentValues();
        cv.put("CategoryID", category.getCategoryId());
        cv.put("CategoryName", category.getCategoryName());

        int states = db.update("Category",cv,"CategoryID =?", new String[]{String.valueOf(category.getCategoryId())});

        return states;

    }






//------------------------------------- Products -------------------------------------------------//



    public boolean InsertProduct (Product product){
        try {
            ContentValues cv = new ContentValues();
            cv.put("ProductId", product.getProductID());
            cv.put("ProductName", product.getProductName());
            cv.put("CategoryId", product.getCategoryID());
            cv.put("Quantity", product.getQuantity());
            cv.put("Price", product.getPrice());

            db.insert("Product",null,cv);
            return true;
        }catch (Exception ex)
        {
            Toast.makeText(con,ex.getMessage(),Toast.LENGTH_LONG).show();
            return false;
        }
    }


    public Vector<String> getCategory_Name() {
        Vector<String> vecCategory = new Vector<String>();
        try {
            Cursor cursor = db.rawQuery("Select CategoryName from Category", null);
            if (cursor.moveToFirst()) {
                do {
                    vecCategory.add(cursor.getString(0));
                } while (cursor.moveToNext());
            }
        } catch (Exception ex) {
            Toast.makeText(con, ex.getMessage(), Toast.LENGTH_LONG).show();
        }
        return vecCategory;
    }



    //get category id for after category name select and the name change to id and save into database
    public String getCategory_Id(String CategoryName)
    {
        String CategoryId=null;
        try{
            Cursor cursor= db.rawQuery("Select CategoryID from Category where CategoryName='"+CategoryName+"'",null);
            if (cursor.moveToFirst())
            {
                CategoryId=cursor.getString(0);
            }
        }
        catch (Exception ex)
        {
            Toast.makeText(con,ex.getMessage(),Toast.LENGTH_LONG).show();
        }
        return CategoryId;
    }



    //View all Products
    public  List<Product> ViewAllProducts()
    {
        List<Product> products = new ArrayList<>();

        Cursor cursor = db.rawQuery(" Select * From Product ", null);

        if (cursor.moveToFirst())
        {
            do{
                Product product = new Product();
                product.setProductID(cursor.getString(0));
                product.setProductName(cursor.getString(1));
                product.setCategoryID(cursor.getString(2));
                product.setQuantity(cursor.getInt(3));
                product.setPrice(cursor.getInt(4));

                products.add(product);


            }while (cursor.moveToNext());
        }
        return products;
    }


    //Delete Category
    public void deleteproduct(String id)
    {
        db.delete("Product","ProductID =?", new String[]{id});
        db.close();
    }


    // update category value inserting after Category clicking
    public ArrayList<Product> updateproductinsert(String id)
    {
        ArrayList<Product> ProductList = new ArrayList();
        try
        {
            Cursor cursor = db.rawQuery("Select * From Product Where ProductID ='"+id+"'", null);
            if (cursor.moveToFirst())
            {
                do {
                    Product product = new Product();
                    product.setProductID(cursor.getString(0));
                    product.setProductName(cursor.getString(1));
                    product.setCategoryID(cursor.getString(2));
                    product.setQuantity(cursor.getInt(3));
                    product.setPrice(cursor.getInt(4));

                    ProductList.add(product);

                }while (cursor.moveToNext());
            }
        }
        catch (Exception ex){
            Toast.makeText(con, ex.getMessage(), Toast.LENGTH_LONG).show();
        }
        return ProductList;

    }



    //Update Product
    public int UpdateProduct(Product product)
    {
        ContentValues cv = new ContentValues();
        cv.put("ProductName", product.getProductName());
        cv.put("Quantity", product.getQuantity());
        cv.put("Price", product.getPrice());

        int states = db.update("Product",cv,"ProductID =?", new String[]{String.valueOf(product.getProductID())});

        return states;

    }


    public String getCategoryName(String id)
    {
        String CategoryName=null;
        try{
            Cursor cursor= db.rawQuery("Select * from Category where CategoryID ='"+id+"'",null);
            if (cursor.moveToFirst())
            {
                CategoryName = cursor.getString(1);
            }
        }
        catch (Exception ex)
        {
            Toast.makeText(con,ex.getMessage(),Toast.LENGTH_LONG).show();
        }
        return CategoryName;
    }



    //View Products user based on category
    public  List<Product> ViewProducts(String id)
    {
        List<Product> products = new ArrayList<>();

        Cursor cursor = db.rawQuery(" Select * From Product where CategoryID ='"+id+"'", null);

        if (cursor.moveToFirst())
        {
            do{
                Product product = new Product();
                product.setProductID(cursor.getString(0));
                product.setProductName(cursor.getString(1));
                product.setCategoryID(cursor.getString(2));
                product.setQuantity(cursor.getInt(3));
                product.setPrice(cursor.getInt(4));

                products.add(product);


            }while (cursor.moveToNext());
        }
        return products;
    }



//--------------------------------------- Orders -------------------------------------------------//


    public boolean InsertOrder(Order order) {
        try {
            ContentValues cv = new ContentValues();
            cv.put("CustomerName", order.getCustomername());
            cv.put("ProductID", order.getProductID());
            cv.put("Quantity", order.getQuantity());
            cv.put("Total", order.getTotal());

            db.insert("Orders", null, cv);
            return true;
        } catch (Exception ex) {
            Toast.makeText(con, ex.getMessage(), Toast.LENGTH_LONG).show();
        }
        return false;

    }


    //View all Orders
    public  List<Order> ViewAllOrders()
    {
        List<Order> orders = new ArrayList<>();

        Cursor cursor = db.rawQuery(" Select * From Orders ", null);

        if (cursor.moveToFirst())
        {
            do{
                Order order = new Order();

                order.setOrderID(cursor.getString(0));
                order.setCustomername(cursor.getString(1));
                order.setProductID(cursor.getString(2));
                order.setQuantity(cursor.getInt(3));
                order.setTotal(cursor.getInt(4));

                orders.add(order);


            }while (cursor.moveToNext());
        }
        return orders;
    }


}
