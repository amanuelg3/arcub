package com.jiayi;

import org.jivesoftware.smack.XMPPConnection;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.jiayi.xmpp.UserLogin;
import com.jiayi.xmpp.XMPPUtility;

public class MainActivity extends MapActivity implements OnClickListener{
	private MapView mapView;
	private MapController mapController;
	
	// All Views of JiaYi MainActivity
	private LinearLayout view_login;
	private LinearLayout view_status;
	private LinearLayout view_menu;
	
	// Login in View
	private EditText login_uid;
	private EditText login_pwd;
	private CheckBox login_save;
	private Button login_btn;
	private SharedPreferences prefs;
	private UserLogin uLogin;
	
	// Status view
	private TextView status_label;
	private TextView status;
	private Button status_btn_refresh;
	private Button status_btn_loc;
	private Button status_btn_self;
	private boolean lover_status;
	
	// Menu view
	
	
	
	// Location
	private Drawable xuyi;
	private Drawable dingjia;
	
	
	private XMPPConnection conn = null;
	private XMPPUtility xmpp;
	
	private GeoPoint jiaLocation = new GeoPoint(49011071, 8430151);
	private GeoPoint yiLocation = new GeoPoint(48727492, 9123924);
	private GeoPoint loverLocation;
	private GeoPoint selfLocation;
	
	private String loverID;

	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// Initialize JiaYi Main Activity
		super.onCreate(savedInstanceState);
		setContentView(R.layout.userview);
		initMap();
		initLogin();
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
		if (conn != null)
			conn.disconnect();
		super.onDestroy();
	}

	@Override
	public void onClick(View v) {
		switch(v.getId()) {
		
		// View Login
		case R.id.login_btn_login :
			String uid = login_uid.getText().toString().trim();
			String pwd = login_pwd.getText().toString().trim();
			
			uLogin = new UserLogin(uid, pwd);
			conn = uLogin.connectServer();
			if (conn != null) {
				if(login_save.isChecked()) {
					// Save the username and password
					Editor mEditor = prefs.edit();
					mEditor.putString("userid", uid);
					mEditor.commit();
					mEditor.putString("password", pwd);
					mEditor.commit();
				}
				view_login.setVisibility(LinearLayout.INVISIBLE);
				initJiaYiStatus();
			} else {
				makeToast("Account or Password is not correct", 0);
			}
			
			break;
		case R.id.status_btn_refresh :
			if (xmpp.getAvailableUser(loverID)) {
				status.setText("在线");
				status.setTextColor(getResources().getColor(R.color.red));
			} else {
				status.setText("离线");
				status.setTextColor(getResources().getColor(R.color.black));
			}
			break;
		case R.id.status_btn_locate :
			mapController.animateTo(loverLocation);
			break;
		case R.id.status_btn_self :
			mapController.animateTo(selfLocation);
			break;
		}
		
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
		// View Login
		view_login = (LinearLayout) findViewById(R.id.main_view_login);
		view_login.setVisibility(LinearLayout.VISIBLE);
		
		login_uid = (EditText) findViewById(R.id.login_uid);
		login_pwd = (EditText) findViewById(R.id.login_pwd);
		login_save = (CheckBox) findViewById(R.id.login_checkbox_info);
		login_btn = (Button) findViewById(R.id.login_btn_login);
		
		prefs = getSharedPreferences("USERACCOUNT", MODE_PRIVATE);
		String uid = prefs.getString("userid", null);
		String pwd = prefs.getString("password", null);
		if (uid != null && pwd != null) {
			login_uid.setText(uid);
			login_pwd.setText(pwd);
		}
		
		login_btn.setOnClickListener(this);
	}
	
	private void initJiaYiStatus() {
		xmpp = new XMPPUtility(conn);
		
		// View Status
		view_status = (LinearLayout) findViewById(R.id.main_view_status);
		view_status.setVisibility(LinearLayout.VISIBLE);
		
		status_label = (TextView) findViewById(R.id.lover_status_label);
		status = (TextView) findViewById(R.id.lover_status);
		
		status_btn_refresh = (Button) findViewById(R.id.status_btn_refresh);
		status_btn_refresh.setOnClickListener(this);
		status_btn_loc = (Button) findViewById(R.id.status_btn_locate);
		status_btn_loc.setOnClickListener(this);
		status_btn_self = (Button) findViewById(R.id.status_btn_self);
		status_btn_self.setOnClickListener(this);
		
		
		dingjia = this.getResources().getDrawable(R.drawable.dingjia);
		xuyi = this.getResources().getDrawable(R.drawable.xuyi01);
		
		if (uLogin.user.equals("jia.ding")) {
			selfLocation = jiaLocation;
			loverLocation = yiLocation;
			loverID = "yi.xu@jabber.org";
			status_label.setText("许翌目前状态:");
			lover_status = xmpp.getAvailableUser(loverID);
			if(lover_status){
				status.setText("在线");
				status.setTextColor(getResources().getColor(R.color.red));
			} else {
				status.setText("离线");
				status.setTextColor(getResources().getColor(R.color.black));
			}
		}			
		else {
			selfLocation = yiLocation;
			loverLocation = jiaLocation;
			loverID = "jia.ding@jabber.org";
			status_label.setText("丁佳目前状态:");
			lover_status = xmpp.getAvailableUser(loverID);
			if(lover_status) {
				status.setText("在线");
				status.setTextColor(getResources().getColor(R.color.red));
			} else {
				status.setText("离线");
				status.setTextColor(getResources().getColor(R.color.black));
			}
		}
		
		initPosition();
	}
	
	private void initPosition() {
		if (uLogin.user.equals("jia.ding")) {
			drawUserPortrait(dingjia, jiaLocation);
			drawClickableUserPortrait(xuyi, yiLocation);
		} else {
			drawUserPortrait(xuyi, yiLocation);
			drawClickableUserPortrait(dingjia, jiaLocation);
		}
	}
	
	private void initMenu() {
		view_menu = (LinearLayout) findViewById(R.id.main_view_menu);
		view_menu.setVisibility(LinearLayout.VISIBLE);
	}
	
	private boolean varifyLoginFormat(String uid, String pwd) {
		//if ()
		return true;
	}
	
	private void makeToast(String content, int time) {
		if (time == 0) {
			Toast.makeText(this, content, Toast.LENGTH_SHORT).show();
		} else {
			Toast.makeText(this, content, Toast.LENGTH_LONG).show();
		}
		
	}
	
	private void drawUserPortrait(Drawable portrait, GeoPoint point) {
		mapController.animateTo(point);

		MapView.LayoutParams mScreenLayoutParams = new MapView.LayoutParams(MapView.LayoutParams.WRAP_CONTENT, 
				MapView.LayoutParams.WRAP_CONTENT, 
				point,
				MapView.LayoutParams.CENTER|MapView.LayoutParams.MODE_MAP);

			ImageView img = new ImageView(this);
			img.setImageDrawable(portrait);

			mapView.addView(img, mScreenLayoutParams);
	}
	
	private void drawClickableUserPortrait(Drawable portrait, GeoPoint point) {
		mapController.animateTo(point);

		MapView.LayoutParams mScreenLayoutParams = new MapView.LayoutParams(MapView.LayoutParams.WRAP_CONTENT, 
				MapView.LayoutParams.WRAP_CONTENT, 
				point,
				MapView.LayoutParams.CENTER|MapView.LayoutParams.MODE_MAP);

			ImageView img = new ImageView(this);
			img.setImageDrawable(portrait);
			img.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					initMenu();
				}
			});
			mapView.addView(img, mScreenLayoutParams);
	}
	
	
}
