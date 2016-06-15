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

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity implements OnClickListener{

	private Intent intent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);


	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
			case R.id.btnEnterExpns:
				intent.putExtra("frag", 1);
		}
	}
}
