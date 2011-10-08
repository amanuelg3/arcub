package com.jiayi.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;

public class JiaYiDB {
	private SQLiteDatabase db;
	private final Context context;

	private final String dbname;
	private final MyDBhelper dbhelper;
	
	public JiaYiDB(Context c) {
		context = c;
		dbname = "jiayi_db";
		dbhelper = new MyDBhelper(context, dbname, 
					null, Constants.DATABASE_VERSION);
		
	}
	
	public void close() {
		db.close();
	}
	
	public void open() throws SQLiteException {
		try {
			db = dbhelper.getWritableDatabase();
		} catch(SQLiteException ex) {
			//Log.v("Open database exception caught", ex.getMessage());
			db = dbhelper.getReadableDatabase();
		}
	}
	
	
}
