package com.example.tomer2;

import java.util.regex.Pattern;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class incomeFragment extends Fragment {

	EditText expensesEdit; 
	TextView expenseView;
	Button expnsBtn;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.expense_layout, container, false);		
		
		expensesEdit = (EditText)view.findViewById(R.id.editExpense);
		expenseView = (TextView)view.findViewById(R.id.expensesView);
		this.showExpenses();
		
		expnsBtn = (Button)view.findViewById(R.id.btnEnterExpns);

		expnsBtn.setOnClickListener(
				new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						buttonClicked(v);
					}
				});
		return view;
	}
	
	
	/**
	 * After entering a number to the expense area this method will remember and add the expense
	 */
	private void enterExpense(){
		//		create sharedpreference and an editor to play with shared...
		//		Get from user the expense we spent.
		SharedPreferences sharedPreferences = this.getActivity().getSharedPreferences("myData", Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = sharedPreferences.edit();
		
		String text = expensesEdit.getText().toString(); 
		
		if (Pattern.matches("[a-zA-Z]+", text) == false) {
			Long expense = Long.parseLong(text);

			addEntryToSum(expense);
			
			enterThisEntryToHistory(expense);
			
			this.showExpenses();
		}
		else{
			AlertDialog.Builder enteredChars = new AlertDialog.Builder(this.getActivity());
			enteredChars.setMessage("הכנס רק ספרות")
			.setPositiveButton("אישור", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					dialog.dismiss();
				}
			})
			.create();
			enteredChars.show();
			/*MyFragment frag = new MyFragment();
			FragmentManager manager = getFragmentManager();
			FragmentTransaction transaction = manager.beginTransaction();
			transaction.add(R.id.my_layout, frag, "hey");
			transaction.commit();
			//transaction.remove(frag);
			//transaction.commit();
			*/
		}

	}
	
	
	

	/**
	 * Pressing on "show expenses will show the amount of expenses until now
	 */
	private void showExpenses(){
		SharedPreferences sharedPreferences = this.getActivity().getSharedPreferences("myData", Context.MODE_PRIVATE);
		Long expenses = sharedPreferences.getLong("complete expenses", 0);
		
		expenseView.setText(String.valueOf(expenses));
	}
	

	
	
	
	
	
	/**
	 * adds the expense to the whole sum of expenses
	 * @param expense the amount to add to the whole sum of expenses
	 */
	private void addEntryToSum(Long expense){
		SharedPreferences sharedPreferences = this.getActivity().getSharedPreferences("myData", Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = sharedPreferences.edit();
		Long totalExpenses = sharedPreferences.getLong("complete expenses", 0) + expense;
		editor.putLong("complete expenses", totalExpenses);
		editor.putLong("last amount",expense);
		editor.commit();
	}
	
	/**
	 * Adds the last expense entry to a history of transactions. This is sort of built like an array
	 * @param expense the entry to add to history
	 */
	private void enterThisEntryToHistory(Long expense){
		SharedPreferences sharedPreferences = this.getActivity().getSharedPreferences("myData", Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = sharedPreferences.edit();
		editor.putLong("expenseEntries" + this.getIndexOfLastEntry(), expense);
		editor.commit();
	}
	
	private int getIndexOfLastEntry(){
		SharedPreferences sharedPreferences = this.getActivity().getSharedPreferences("myData", Context.MODE_PRIVATE);
		return sharedPreferences.getInt("indexLastEntry", 0);
	}
	
	
	
	private void buttonClicked(View view){
		switch(view.getId())
		{
		case R.id.btnEnterExpns:
			this.enterExpense();
			break;
		default:
			expenseView.setText("broke");
		}
	}

}
