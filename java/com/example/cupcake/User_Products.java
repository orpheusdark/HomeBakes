package com.example.cupcake;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class User_Products extends AppCompatActivity {

    ListView ListProduct;
    Context context;
    private DBHelper Dbhelper;
    private List<Product> productList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_products);

        context = this;

        Dbhelper = new DBHelper(this);
        Dbhelper.OpenDB();


        ListProduct = findViewById(R.id.UProductList);

        final String CategortId = getIntent().getStringExtra("id");

        productList = new ArrayList<>();
        productList = Dbhelper.ViewProducts(CategortId);

        ProductAdapter adapter = new ProductAdapter(context, R.layout.list_products, productList);
        ListProduct.setAdapter(adapter);

        ListProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Product product = productList.get(i);
                Intent Order = new Intent(User_Products.this, BuyProduct.class);
                Order.putExtra("id", String.valueOf(product.getProductID()));
                Order.putExtra("Name", String.valueOf(product.getProductName()));
                Order.putExtra("Category Name", String.valueOf(Dbhelper.getCategoryName(product.getCategoryID())));
                Order.putExtra("Quantity", String.valueOf(product.getQuantity()));
                Order.putExtra("Price", String.valueOf(product.getPrice()));
                startActivity(Order);

            }
        });



    }
}