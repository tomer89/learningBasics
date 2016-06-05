package com.example.tomer2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends ArrayAdapter {
    List list = new ArrayList();

    static class DataHandler{
        ImageView thumbNail;

        TextView textExpense ;
        ImageView imageExpns ;
        Button btnExpense;
        EditText editExpense;
    }

	public CustomAdapter(Context context, int resource) {
		super(context, resource);
		// TODO Auto-generated constructor stub
	}

    @Override
    public void add(Object object) {
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }


    @Override
	public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub

        View row;
        DataHandler data;

        row = convertView;
        data = new DataHandler();

        if (convertView == null) {
            LayoutInflater inflator = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            //what is this check in https://www.youtube.com/watch?v=DzpwvZ4S27g (row layout)
            row = inflator.inflate(R.layout.expenses_row_in_list, parent, false);
            data.btnExpense = (Button) row.findViewById(R.id.btnEnterExpns);
            data.textExpense = (TextView) row.findViewById(R.id.expensesView);
            data.imageExpns = (ImageView) row.findViewById(R.id.expenseImage);
            data.editExpense = (EditText) row.findViewById(R.id.editExpense);
            row.setTag(data);
        } else {
            data = (DataHandler) row.getTag();
        }

        rowDataProvider rowData;
        rowData = (rowDataProvider) this.getItem(position);
        data.imageExpns.setImageResource((ImageView)rowData.getIconById());

        return super.getView((position, convertView, parent));
    }
}
