package com.example.tomer2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends ArrayAdapter<String> {

	public CustomAdapter(Context context, int resource) {
		super(context, resource);
		// TODO Auto-generated constructor stub
	}

    @Override
    public void add(String object) {
        super.add(object);
    }

    @Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		LayoutInflater inflator = LayoutInflater.from(getContext());
		View customView = inflator.inflate(R.layout.expenses_row_in_list, parent, false);
        String singleExpense = getItem(position);

        if(singleExpense == "expense") {


            TextView textExpense = (TextView) customView.findViewById(R.id.expensesView);
            ImageView imageExpns = (ImageView) customView.findViewById(R.id.expenseImage);
            Button btnExpense = (Button) customView.findViewById(R.id.btnEnterExpns);
            EditText editExpense = (EditText) customView.findViewById(R.id.editExpense);
        }

		
		return customView;
		
	}
	
	
	
}
