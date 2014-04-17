package com.example.qwikserve.gui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainactivity);

        Button a = (Button) findViewById(R.id.button1);
        Button b = (Button) findViewById(R.id.button2);
        a.setOnClickListener(this);
        b.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.button1)// if ordering button is clicked
        {   //start the ordering module and kill this activity
            Intent intent1 = new Intent(MainActivity.this,OrderMain.class);
            startActivity(intent1);
            finish();
        }
        else if (v.getId()== R.id.button2)// chef module is clicked
        {
            Intent intent1 = new Intent(MainActivity.this , CookScreen.class);
            startActivity(intent1);
            finish();
        }
    }
}
