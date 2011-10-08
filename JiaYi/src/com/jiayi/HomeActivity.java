package com.jiayi;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

public class HomeActivity extends Activity {
    /** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		
		new CountDownTimer(2000, 1000) {
			
			@Override
			public void onTick(long millisUntilFinished) {
				// TODO Auto-generated method stub
				//txt_cd.setText("" + millisUntilFinished /  1000);
			}
			
			@Override
			public void onFinish() {
				// TODO Auto-generated method stub
				// go to the Main View
				Intent view_main = new Intent(HomeActivity.this, MainActivity.class);
				startActivity(view_main);
			}
		}.start();

	}
    
	@Override
	protected void onRestart() {
		finish();
		super.onRestart();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
	}
}