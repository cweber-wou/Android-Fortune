package com.test;

import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;

public class TimesDataSource {




	// Database fields
	private SQLiteDatabase database;
	private MySQLiteHelper dbHelper;
	private String[] allColumns = { MySQLiteHelper.COLUMN_ID,
			MySQLiteHelper.COLUMN_Time };

	public TimesDataSource(Context context) {
		dbHelper = new MySQLiteHelper(context);
	}

	public void open() throws SQLException {
		database = dbHelper.getWritableDatabase();
	}

	public void close() {
		dbHelper.close();
	}

	public Time createTime(String Time) {
		ContentValues values = new ContentValues();
		values.put(MySQLiteHelper.COLUMN_Time, Time);
		long insertId = database.insert(MySQLiteHelper.TABLE_TimeS, null,
				values);
		Cursor cursor = database.query(MySQLiteHelper.TABLE_TimeS,
				allColumns, MySQLiteHelper.COLUMN_ID + " = " + insertId, null,
				null, null, null);
		cursor.moveToFirst();
		Time newTime = cursorToTime(cursor);
		cursor.close();
		return newTime;
	}

	public void deleteTime(Time Time) {
		long id = Time.getID();
		System.out.println("Time deleted with id: " + id);
		database.delete(MySQLiteHelper.TABLE_TimeS, MySQLiteHelper.COLUMN_ID
				+ " = " + id, null);
	}

	public List<Time> getAllTimes() {
		List<Time> Times = new ArrayList<Time>();

		Cursor cursor = database.query(MySQLiteHelper.TABLE_TimeS,
				allColumns, null, null, null, null, null);

		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			Time Time = cursorToTime(cursor);
			Times.add(Time);
			cursor.moveToNext();
		}
		// Make sure to close the cursor
		cursor.close();
		return Times;
	}

	private Time cursorToTime(Cursor cursor) {
		Time Time = new Time();
		Time.setID(cursor.getLong(0));
		Time.setWord(cursor.getString(1));
		return Time;
	}
}


