package com.test;

import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;

public class NounsDataSource {




	// Database fields
	private SQLiteDatabase database;
	private MySQLiteHelper dbHelper;
	private String[] allColumns = { MySQLiteHelper.COLUMN_ID,
			MySQLiteHelper.COLUMN_Noun };

	public NounsDataSource(Context context) {
		dbHelper = new MySQLiteHelper(context);
	}

	public void open() throws SQLException {
		database = dbHelper.getWritableDatabase();
	}

	public void close() {
		dbHelper.close();
	}

	public Noun createNoun(String Noun) {
		ContentValues values = new ContentValues();
		values.put(MySQLiteHelper.COLUMN_Noun, Noun);
		long insertId = database.insert(MySQLiteHelper.TABLE_NounS, null,
				values);
		Cursor cursor = database.query(MySQLiteHelper.TABLE_NounS,
				allColumns, MySQLiteHelper.COLUMN_ID + " = " + insertId, null,
				null, null, null);
		cursor.moveToFirst();
		Noun newNoun = cursorToNoun(cursor);
		cursor.close();
		return newNoun;
	}

	public void deleteNoun(Noun Noun) {
		long id = Noun.getID();
		System.out.println("Noun deleted with id: " + id);
		database.delete(MySQLiteHelper.TABLE_NounS, MySQLiteHelper.COLUMN_ID
				+ " = " + id, null);
	}

	public List<Noun> getAllNouns() {
		List<Noun> Nouns = new ArrayList<Noun>();

		Cursor cursor = database.query(MySQLiteHelper.TABLE_NounS,
				allColumns, null, null, null, null, null);

		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			Noun Noun = cursorToNoun(cursor);
			Nouns.add(Noun);
			cursor.moveToNext();
		}
		// Make sure to close the cursor
		cursor.close();
		return Nouns;
	}

	private Noun cursorToNoun(Cursor cursor) {
		Noun Noun = new Noun();
		Noun.setID(cursor.getLong(0));
		Noun.setWord(cursor.getString(1));
		return Noun;
	}
}


