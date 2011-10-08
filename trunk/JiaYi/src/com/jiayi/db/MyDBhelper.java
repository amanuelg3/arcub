package com.jiayi.db;

/*
 *  MyDBhelper.java
    Copyright (C) 2011  Jia Ding
	Contact: realyoungdj@gmail.com
	
    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.

 */

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.util.Log;

public class MyDBhelper extends SQLiteOpenHelper{
	public String create_table_jiayiMsg;
	public String create_table_jiayiLoc;
	public String create_table_jiayiDate;

	
	public MyDBhelper(Context context, String dataname, CursorFactory factory, 
						int version) {
		super(context, dataname, factory, version);
		create_table_jiayiMsg = "create table if not exists " +
						Constants.MSG_TABLE_NAME + " (" +
						Constants.MSG_KEY_ID + " integer primary key autoincrement, " +
						Constants.MSG_DLV_NAME + " text not null, " +
						Constants.MSG_RCV_NAME + " text not null, " +
						Constants.MSG_TIMESTAMP_NAME + " long not null, " +
						Constants.MSG_CONTENT_NAME + " text not null" +
								");";
		
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		//Log.v("MyDBhelper onCreate" , "Creating all the tables");
		try {
			db.execSQL(create_table_jiayiMsg);
		} catch(SQLiteException ex) {
			//Log.v("MyDBhelper table exception" , ex.getMessage());
		}
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL("drop table if exists " + Constants.MSG_TABLE_NAME);
		onCreate(db);
	}

}
