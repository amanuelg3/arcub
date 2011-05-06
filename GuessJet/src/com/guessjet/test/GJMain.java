package com.guessjet.test;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class GJMain extends Activity implements OnClickListener {
    /** Called when the activity is first created. */
    
    private Button main_btn_pc;
    private Button main_btn_pp;
    private Button main_btn_about;
    private Button main_btn_exit;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        main_btn_pc = (Button) findViewById(R.id.main_btn_pc);
        main_btn_pp = (Button) findViewById(R.id.main_btn_pp);
        main_btn_about = (Button) findViewById(R.id.main_btn_how);
        main_btn_exit = (Button) findViewById(R.id.main_btn_exit);
        
        main_btn_pc.setOnClickListener(this);
        main_btn_pp.setOnClickListener(this);
        main_btn_about.setOnClickListener(this);
        main_btn_exit.setOnClickListener(this);
        
        main_btn_pp.setEnabled(false);
    }

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()) {
		case R.id.main_btn_pc :
			break;
		case R.id.main_btn_pp :
			break;
		case R.id.main_btn_how :
			break;
		case R.id.main_btn_exit :
			finish();
			break;
		}
	}
}