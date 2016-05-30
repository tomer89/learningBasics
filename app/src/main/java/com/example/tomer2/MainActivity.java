package com.example.tomer2;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;

public class MainActivity extends Activity implements OnClickListener{



	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		populateListView();

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	protected void openExpensesFragment(){
		expenseFragment expenseFrag = new expenseFragment();
		FragmentManager manager = getFragmentManager();
		FragmentTransaction transaction = manager.beginTransaction();
		transaction.add(R.id.activity_main, expenseFrag, "expenseFragment");
		transaction.commit();
		//registerClickCallback();
	}


	private void populateListView(){
		//for simple String listView on TNB there is a tuturial for fragment type of lists
		//youtube https://www.youtube.com/watch?v=eAPFgC9URqc
		//TNB
		//https://www.youtube.com/watch?v=U_Jvk4G28YE
		//here is my next step https://www.youtube.com/watch?v=nOdSARCVYic
		// Create list of items
		String[] items = {"expenses","income","summary"};
		int[] images = {R.drawable.expns};
		TextView[] textViews = {(TextView)findViewById(R.id.expensesView)};

		//build adapter
		CustomAdapter adapter = new CustomAdapter(this, R.layout.expenses_row_in_list);
		ListView list = (ListView) findViewById(R.id.mainListView);
		list.setAdapter(adapter);
		//have to build objects that have all the details of stuff inside (I am on https://www.youtube.com/watch?v=DzpwvZ4S27g at 15 minutes)
		adapter.add();
		//configure
		this.registerClickCallback(list);
	}


	private void registerClickCallback(ListView list){
		list.setOnItemClickListener(new AdapterView.OnItemClickListener()
		{

			@Override
			public void onItemClick(AdapterView<?> parent, View viewClicked, int position, long id) {
				TextView textView = (TextView) viewClicked;


				switch((String)textView.getText()){
				case "expenses":
					openExpensesFragment();
				}

			}
		});
	}

	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){

		}
	}
}
