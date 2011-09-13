package com.datedate.main;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;

public class DateDateMain extends MapActivity implements OnClickListener{
	private MapView mapView;
	private MapController mapController;
	
	// All Views of DateDateMain
	private LinearLayout view_login;
	
	// Login in View
	private EditText login_uid;
	private EditText login_pwd;
	private CheckBox login_save;
	private Button login_btn;

	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.view_datedate);
		initMap();
	}


	private void initMap() {
		mapView = (MapView) findViewById(R.id.main_mapview);
		//overlay = new MyLocationOverlay(this, mapView);
		// zoom control
		mapView.setBuiltInZoomControls(false);

		// Map Controller
		mapController = mapView.getController();
		mapController.setZoom(16);
	}
	
	private void initLogin() {
		view_login = (LinearLayout) findViewById(R.id.main_view_login);
		login_uid = (EditText) findViewById(R.id.login_uid);
		login_pwd = (EditText) findViewById(R.id.login_pwd);
		login_save = (CheckBox) findViewById(R.id.login_checkbox_info);
		login_btn = (Button) findViewById(R.id.login_btn_login);
		view_login.setVisibility(LinearLayout.VISIBLE);
	}
	

	@Override
	protected void onStart() {
		super.onStart();
	}

	@Override
	protected void onResume() {
		super.onResume();       
	}

	@Override
	protected void onRestart() {
		super.onRestart();
	}

	@Override
	protected void onPause() {
		super.onPause();
	}

	@Override
	protected void onStop() {
		super.onStop();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
	}

	@Override
	public void onClick(View v) {
		switch(v.getId()) {
		
		// View Login
		case R.id.login_btn_login :
			break;
		}
		
	}


}
