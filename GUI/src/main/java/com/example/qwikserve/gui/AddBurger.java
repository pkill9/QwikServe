package com.example.qwikserve.gui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

public class AddBurger extends Activity implements View.OnClickListener{
    private Order order;
    RadioGroup meat;
    RadioGroup bun;
    RadioGroup size;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addburger);

        meat = (RadioGroup) findViewById(R.id.radiogroup1);
        bun = (RadioGroup) findViewById(R.id.radiogroup2);
        size = (RadioGroup) findViewById(R.id.radiogroup3);
        Button cont = (Button) findViewById(R.id.button9);

        cont.setOnClickListener(this);

        Intent intent1 = getIntent();
        order = (Order) intent1.getSerializableExtra("com.example.qwikserve.gui.Order.class");
    }

    @Override
    public void onClick(View v)
    {
        if (v.getId() == R.id.button9)
        {
            switch (meat.getCheckedRadioButtonId())
            {
                case R.id.radioButton1:
                    order.addBurger("chicken");
                    break;
                case R.id.radioButton2:
                    order.addBurger("beef");
                    break;
                case R.id.radioButton3:
                    order.addBurger("turkey");
                    break;
            }

            switch (bun.getCheckedRadioButtonId())
            {
                case R.id.radioButton4:
                    order.addBurger("plain white");
                    break;
                case R.id.radioButton5:
                    order.addBurger("potato");
                    break;
                case R.id.radioButton6:
                    order.addBurger("pretzel roll");
                    break;
            }

            switch (size.getCheckedRadioButtonId())
            {
                case R.id.radioButton7:
                    order.addBurger("single");
                    break;
                case R.id.radioButton8:
                    order.addBurger("double");
                    break;
                case R.id.radioButton9:
                    order.addBurger("triple");
                    break;
            }

            if (!order.isCombo())
            {// if the order is not a combo
                switch (meat.getCheckedRadioButtonId())
                {// add the cost based on burger type
                    case R.id.radioButton1:
                        order.addCost(7.00);
                        break;
                    case R.id.radioButton2:
                        order.addCost(7.50);
                        break;
                    case R.id.radioButton3:
                        order.addCost(7.00);
                        break;
                }
            }//end if is combo

            Intent intent2 = new Intent(AddBurger.this,AddTopping.class);
            intent2.putExtra("com.example.qwikserve.gui.Order.class",order);
            startActivity(intent2);
            finish();
        }// end getId if
    }//end onClick

}
