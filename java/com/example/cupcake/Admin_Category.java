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

public class Admin_Category extends AppCompatActivity {

    Button BTNAddCategory, BTNBack;
    ListView Listview;
    Context context;
    private DBHelper Dbhelper;
    private List<Category> categoryList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_category);
        context = this;

        Dbhelper = new DBHelper(this);
        Dbhelper.OpenDB();

        BTNAddCategory = findViewById(R.id.btnAddCategory);
        BTNBack = findViewById(R.id.btnCback);
        Listview = findViewById(R.id.OrderListC);

        categoryList = new ArrayList<>();

        categoryList = Dbhelper.ViewAllCategory();

        CategoryAdapter adapter = new CategoryAdapter(context, R.layout.list_catagory, categoryList);

        Listview.setAdapter(adapter);


        Listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Category category = categoryList.get(i);

                AlertDialog.Builder builder = new AlertDialog.Builder(context);

                builder.setTitle(category.getCategoryName());
                builder.setMessage(category.getCategoryId());

                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        startActivity(new Intent(context,Admin_Category.class));

                    }
                });

                builder.setNegativeButton("Update", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        Intent UpdateCategory = new Intent(Admin_Category.this, Admin_Update_Category.class);
                        UpdateCategory.putExtra("id", String.valueOf(category.getCategoryId()));
                        startActivity(UpdateCategory);

                    }
                });

                builder.setNeutralButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        Dbhelper.deletecategory(category.getCategoryId());
                        Toast.makeText(getApplicationContext(),"Category Delete successful", Toast.LENGTH_LONG).show();
                        Intent DeleteCategory = new Intent(Admin_Category.this, Admin_Category.class);
                        startActivity(DeleteCategory);
                    }
                });

                builder.show();

            }
        });


        BTNAddCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent AddCategory = new Intent(Admin_Category.this, Admin_Add_Category.class);
                startActivity(AddCategory);
            }
        });

        BTNBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Back = new Intent(Admin_Category.this, Admin_Home.class);
                startActivity(Back);
            }
        });


    }


}