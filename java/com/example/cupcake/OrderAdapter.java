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

public class OrderAdapter extends ArrayAdapter<Order>
{
    private Context context;
    private int resource;
    List<Order> OrderList;

    OrderAdapter(Context context, int resource, List<Order> OrderList)
    {
        super(context, resource, OrderList);
        this.context = context;
        this.resource = resource;
        this.OrderList = OrderList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View row = inflater.inflate(resource,parent, false);



        TextView PID = row.findViewById(R.id.OPID);
        TextView Quantity = row.findViewById(R.id.OQU);



        Order order = OrderList.get(position);
        PID.setText(order.getProductID());
        Quantity.setText(String.valueOf(order.getQuantity()));


        return row;
    }
}
