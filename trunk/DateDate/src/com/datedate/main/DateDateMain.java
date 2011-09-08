package com.datedate.main;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;

public class DateDateMain extends MapActivity{
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

	private void initMap() {
		mapView = (MapView) findViewById(R.id.main_mapview);
		//overlay = new MyLocationOverlay(this, mapView);
		// zoom control
		mapView.setBuiltInZoomControls(true);

		// Map Controller
		mapController = mapView.getController();
		mapController.setZoom(16);
	}
	
	private void initLogin() {
		
	}


}
