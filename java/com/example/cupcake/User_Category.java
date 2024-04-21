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

public class User_Category extends AppCompatActivity {

    ListView Listuserview;
    Context context;
    private DBHelper Dbhelper;
    private List<Category> categoryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_category);
        context = this;

        Dbhelper = new DBHelper(this);
        Dbhelper.OpenDB();

        Listuserview = findViewById(R.id.userlistview);
        categoryList = new ArrayList<>();

        categoryList = Dbhelper.ViewAllCategory();

        User_CategoryAdapter adapter = new User_CategoryAdapter(context, R.layout.user_list_category, categoryList);
        Listuserview.setAdapter(adapter);

        Listuserview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Category category = categoryList.get(i);
                Intent Updateproduct = new Intent(User_Category.this, User_Products.class);
                Updateproduct.putExtra("id", String.valueOf(category.getCategoryId()));
                startActivity(Updateproduct);

            }
        });









    }
}