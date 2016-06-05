package com.example.tomer2;

import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by user on 05-Jun-16.
 */
public class rowDataProvider {
    ImageButton icon;
    TextView viewValue;
    Button enterExpenseIncomeButton;
    EditText enterExpenseIncomeText;
    android.view.View iconId;
    int viewValueId;
    int enterExpenseIncomeButtonId;
    int enterExpenseIncomeTextId;


    public rowDataProvider(int iconId, int viewValueId, int enterExpenseIncomeButtonId, int enterExpenseIncomeTextId) {
        this.iconId = iconId;
        this.viewValueId = viewValueId;
        this.enterExpenseIncomeButtonId = enterExpenseIncomeButtonId;
        this.enterExpenseIncomeTextId = enterExpenseIncomeTextId;

        icon = (ImageButton) iconId;
    }

    public ImageButton getIcon() {
        return icon;
    }


    public android.view.View getIconById() {

        return iconId;
    }

    public TextView getViewValue() {
        return viewValue;
    }

    public Button getEnterExpenseIncomeButton() {
        return enterExpenseIncomeButton;
    }

    public EditText getEnterExpenseIncomeText() {
        return enterExpenseIncomeText;
    }
}
