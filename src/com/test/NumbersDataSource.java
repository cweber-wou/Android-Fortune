package com.test;

import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;

public class NumbersDataSource {




	// Database fields
	private SQLiteDatabase database;
	private MySQLiteHelper dbHelper;
	private String[] allColumns = { MySQLiteHelper.COLUMN_ID,
			MySQLiteHelper.COLUMN_Number };

	public NumbersDataSource(Context context) {
		dbHelper = new MySQLiteHelper(context);
	}

	public void open() throws SQLException {
		database = dbHelper.getWritableDatabase();
	}

	public void close() {
		dbHelper.close();
	}

	public Number createNumber(String Number) {
		ContentValues values = new ContentValues();
		values.put(MySQLiteHelper.COLUMN_Number, Number);
		long insertId = database.insert(MySQLiteHelper.TABLE_NumberS, null,
				values);
		Cursor cursor = database.query(MySQLiteHelper.TABLE_NumberS,
				allColumns, MySQLiteHelper.COLUMN_ID + " = " + insertId, null,
				null, null, null);
		cursor.moveToFirst();
		Number newNumber = cursorToNumber(cursor);
		cursor.close();
		return newNumber;
	}

	public void deleteNumber(Number Number) {
		long id = Number.getID();
		System.out.println("Number deleted with id: " + id);
		database.delete(MySQLiteHelper.TABLE_NumberS, MySQLiteHelper.COLUMN_ID
				+ " = " + id, null);
	}

	public List<Number> getAllNumbers() {
		List<Number> Numbers = new ArrayList<Number>();

		Cursor cursor = database.query(MySQLiteHelper.TABLE_NumberS,
				allColumns, null, null, null, null, null);

		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			Number Number = cursorToNumber(cursor);
			Numbers.add(Number);
			cursor.moveToNext();
		}
		// Make sure to close the cursor
		cursor.close();
		return Numbers;
	}

	private Number cursorToNumber(Cursor cursor) {
		Number Number = new Number();
		Number.setID(cursor.getLong(0));
		Number.setWord(cursor.getString(1));
		return Number;
	}
}


