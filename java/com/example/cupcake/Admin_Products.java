package com.example.cupcake;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Admin_Products extends AppCompatActivity {

    Button BTNAddProducts, BTNPBack;
    ListView Plistview;
    Context context;
    private DBHelper Dbhelper;
    private List<Product> productList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_products);
        context = this;

        Dbhelper = new DBHelper(this);
        Dbhelper.OpenDB();

        BTNAddProducts = findViewById(R.id.BtnAddPro);
        BTNPBack = findViewById(R.id.btnPback);
        Plistview = findViewById(R.id.ProductsList);

        productList = new ArrayList<>();
        productList = Dbhelper.ViewAllProducts();

        ProductAdapter adapter = new ProductAdapter(context, R.layout.list_products, productList);
        Plistview.setAdapter(adapter);

        Plistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Product product = productList.get(i);

                AlertDialog.Builder builder = new AlertDialog.Builder(context);

                builder.setTitle(product.getProductName());
                builder.setMessage(String.valueOf(product.getPrice()));


                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        Intent Adminproduct = new Intent(Admin_Products.this, Admin_Products.class);
                        startActivity(Adminproduct);

                    }
                });

                builder.setNegativeButton("Update", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        Intent Updateproduct = new Intent(Admin_Products.this, Admin_Update_Product.class);
                        Updateproduct.putExtra("id", String.valueOf(product.getProductID()));
                        startActivity(Updateproduct);

                    }
                });

                builder.setNeutralButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        Dbhelper.deleteproduct(product.getProductID());
                        Toast.makeText(getApplicationContext(),"Product Delete successful", Toast.LENGTH_LONG).show();
                        Intent DeleteProduct = new Intent(Admin_Products.this, Admin_Products.class);
                        startActivity(DeleteProduct);

                    }
                });

                builder.show();

            }
        });



        BTNAddProducts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent Products = new Intent(Admin_Products.this, Admin_Add_Products.class);
                startActivity(Products);
            }
        });


        BTNPBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Back = new Intent(Admin_Products.this, Admin_Home.class);
                startActivity(Back);
            }
        });









    }
}