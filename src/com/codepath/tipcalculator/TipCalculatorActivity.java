package com.codepath.tipcalculator;

import java.text.DecimalFormat;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TipCalculatorActivity extends Activity {

	private EditText amtTotalet;
	private TextView tipTotaltv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tip_calculator);

		amtTotalet = (EditText) findViewById(R.id.amttotaled);
		tipTotaltv = (TextView) findViewById(R.id.tiptotalView);
		setupButtonListener();
	}

	public void setupButtonListener() {
		final Button tenpctBtn = (Button) findViewById(R.id.pct10btn);
		tenpctBtn.setOnClickListener(new OnClickListener(){
			public void onClick(View v) {
				double tip = getInputAmount()*0.1;
				formatAmountandDisplay(tip);	       }
		});

		final Button fifteenpctBtn = (Button) findViewById(R.id.pct15btn);
		fifteenpctBtn.setOnClickListener(new OnClickListener(){
			public void onClick(View v) {
				double tip = getInputAmount()*0.15;
				formatAmountandDisplay(tip);	       }
		});

		final Button twentypctBtn = (Button) findViewById(R.id.pct20btn);
		twentypctBtn.setOnClickListener(new OnClickListener(){
			public void onClick(View v) {
				double tip = getInputAmount()*0.2;
				formatAmountandDisplay(tip);	       }
		});
	}

	protected double getInputAmount(){
		double amount;
		try{
			String s = amtTotalet.getText().toString();
			amount = Double.parseDouble(s);
		} catch (Exception e) {
			amount = 0;
		}
		return(amount);
	}

	protected void formatAmountandDisplay(double amount) {
		DecimalFormat df = new DecimalFormat("#.##");
		String tip = df.format(amount);
		tipTotaltv.setText(tip);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tip_calculator, menu);

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

}
