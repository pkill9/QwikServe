package com.example.qwikserve.gui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

public class AddSides extends Activity implements View.OnClickListener{

    private Order order;
    RadioGroup side;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addsides);

        side = (RadioGroup) findViewById(R.id.radiogroup4);
        Button cont = (Button) findViewById(R.id.button10);

        cont.setOnClickListener(this);

        Intent intent1 = getIntent();
        order = (Order) intent1.getSerializableExtra("com.example.qwikserve.gui.Order.class");
    }

    @Override
    public void onClick(View v)
    {

        if (v.getId() == R.id.button10)
        {
            switch (side.getCheckedRadioButtonId())
            {
                case R.id.radioButton10:
                    order.addSide("mashed potatoes");
                    break;
                case R.id.radioButton11:
                    order.addSide("caesar salad");
                    break;
                case R.id.radioButton12:
                    order.addSide("french fries");
                    break;
            }



            if (!order.isCombo())
            {// if the order is not a combo
                switch (side.getCheckedRadioButtonId())
                {
                    case R.id.radioButton10:
                        order.addCost(2.0);
                        break;
                    case R.id.radioButton11:
                        order.addCost(3.0);
                        break;
                    case R.id.radioButton12:
                        order.addCost(2.5);
                        break;
                }
            }//end if is combo

            Intent intent2 = new Intent(AddSides.this,AddMain.class);
            intent2.putExtra("com.example.qwikserve.gui.Order.class",order);
            startActivity(intent2);
            finish();
        }// end getId if

    }//end onClick
}
