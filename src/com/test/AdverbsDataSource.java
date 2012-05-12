package com.test;

import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;

public class AdverbsDataSource {




	// Database fields
	private SQLiteDatabase database;
	private MySQLiteHelper dbHelper;
	private String[] allColumns = { MySQLiteHelper.COLUMN_ID,
			MySQLiteHelper.COLUMN_Adverb };

	public AdverbsDataSource(Context context) {
		dbHelper = new MySQLiteHelper(context);
	}

	public void open() throws SQLException {
		database = dbHelper.getWritableDatabase();
	}

	public void close() {
		dbHelper.close();
	}

	public Adverb createAdverb(String Adverb) {
		ContentValues values = new ContentValues();
		values.put(MySQLiteHelper.COLUMN_Adverb, Adverb);
		long insertId = database.insert(MySQLiteHelper.TABLE_AdverbS, null,
				values);
		Cursor cursor = database.query(MySQLiteHelper.TABLE_AdverbS,
				allColumns, MySQLiteHelper.COLUMN_ID + " = " + insertId, null,
				null, null, null);
		cursor.moveToFirst();
		Adverb newAdverb = cursorToAdverb(cursor);
		cursor.close();
		return newAdverb;
	}

	public void deleteAdverb(Adverb Adverb) {
		long id = Adverb.getID();
		System.out.println("Adverb deleted with id: " + id);
		database.delete(MySQLiteHelper.TABLE_AdverbS, MySQLiteHelper.COLUMN_ID
				+ " = " + id, null);
	}

	public List<Adverb> getAllAdverbs() {
		List<Adverb> Adverbs = new ArrayList<Adverb>();

		Cursor cursor = database.query(MySQLiteHelper.TABLE_AdverbS,
				allColumns, null, null, null, null, null);

		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			Adverb Adverb = cursorToAdverb(cursor);
			Adverbs.add(Adverb);
			cursor.moveToNext();
		}
		// Make sure to close the cursor
		cursor.close();
		return Adverbs;
	}

	private Adverb cursorToAdverb(Cursor cursor) {
		Adverb Adverb = new Adverb();
		Adverb.setID(cursor.getLong(0));
		Adverb.setWord(cursor.getString(1));
		return Adverb;
	}
}


