package com.example.cupcake;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class User_Order extends AppCompatActivity {

    Button BTNOBack;
    ListView Olistview;
    Context context;
    private DBHelper Dbhelper;
    private List<Order> ordertList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_order);
        context = this;

        Dbhelper = new DBHelper(this);
        Dbhelper.OpenDB();

        BTNOBack = findViewById(R.id.btnOback2);
        Olistview = findViewById(R.id.OrderListC);

        ordertList = new ArrayList<>();
        ordertList = Dbhelper.ViewAllOrders();

        OrderAdapter adapter = new OrderAdapter(context, R.layout.list_order, ordertList);
        Olistview.setAdapter(adapter);

        BTNOBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Products = new Intent(User_Order.this, User_Home.class);
                startActivity(Products);
            }
        });



    }
}