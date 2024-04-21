package com.example.cupcake;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class CategoryAdapter extends ArrayAdapter<Category>
{
    private Context context;
    private int resource;
    List<Category> categoryList;

    CategoryAdapter(Context context, int resource, List<Category> categoryList)
    {
        super(context, resource, categoryList);
        this.context = context;
        this.resource = resource;
        this.categoryList = categoryList;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View row = inflater.inflate(resource,parent, false);

        TextView Name = row.findViewById(R.id.txtCName);
        TextView Id = row.findViewById(R.id.txtCId);

        Category category = categoryList.get(position);
        Name.setText(category.getCategoryName());
        Id.setText(category.getCategoryId());



        return row;
    }
}
