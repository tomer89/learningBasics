package com.example.tomer2;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

/**
 * Created by user on 05-Jun-16.
 */
public class fragmentControler extends FragmentActivity {

    private incomeFragment income_fragment;
    private expenseFragment expense_fragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_manager);

        // setting portrait mode
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        income_fragment = new incomeFragment();
        expense_fragment = new expenseFragment();


        income_fragment.setArguments(getIntent().getExtras());
        expense_fragment.setArguments(getIntent().getExtras());

        Intent intent = getIntent();
        int frag = intent.getIntExtra("frag", -1);

        // show results of who won for player vrs computer mode:
        if (frag == 1)
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_manager, expense_fragment).commit();
        else if (frag == 2)
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_manager, expense_fragment).commit();

    }

}
