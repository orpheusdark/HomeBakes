package com.example.cupcake;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ProductAdapter extends ArrayAdapter<Product>
{
    private Context context;
    private int resource;
    List<Product> productList;

    ProductAdapter(Context context, int resource, List<Product> productList)
    {
        super(context, resource,productList);
        this.context = context;
        this.resource = resource;
        this.productList = productList;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View row = inflater.inflate(resource, parent, false);



        TextView Name = row.findViewById(R.id.txtName);
        TextView Quantity = row.findViewById(R.id.txtQuantity);
        TextView Price = row.findViewById(R.id.txtPrice);

        Product product = productList.get(position);
        Name.setText(product.getProductName());
        Quantity.setText(String.valueOf(product.getQuantity()));
        Price.setText(String.valueOf(product.getPrice()));

        return row;

    }
}
