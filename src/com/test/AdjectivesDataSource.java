package com.test;

import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;

public class AdjectivesDataSource {




	// Database fields
	private SQLiteDatabase database;
	private MySQLiteHelper dbHelper;
	private String[] allColumns = { MySQLiteHelper.COLUMN_ID,
			MySQLiteHelper.COLUMN_Adjective };

	public AdjectivesDataSource(Context context) {
		dbHelper = new MySQLiteHelper(context);
	}

	public void open() throws SQLException {
		database = dbHelper.getWritableDatabase();
	}

	public void close() {
		dbHelper.close();
	}

	public Adjective createAdjective(String Adjective) {
		ContentValues values = new ContentValues();
		values.put(MySQLiteHelper.COLUMN_Adjective, Adjective);
		long insertId = database.insert(MySQLiteHelper.TABLE_AdjectiveS, null,
				values);
		Cursor cursor = database.query(MySQLiteHelper.TABLE_AdjectiveS,
				allColumns, MySQLiteHelper.COLUMN_ID + " = " + insertId, null,
				null, null, null);
		cursor.moveToFirst();
		Adjective newAdjective = cursorToAdjective(cursor);
		cursor.close();
		return newAdjective;
	}

	public void deleteAdjective(Adjective Adjective) {
		long id = Adjective.getID();
		System.out.println("Adjective deleted with id: " + id);
		database.delete(MySQLiteHelper.TABLE_AdjectiveS, MySQLiteHelper.COLUMN_ID
				+ " = " + id, null);
	}

	public List<Adjective> getAllAdjectives() {
		List<Adjective> Adjectives = new ArrayList<Adjective>();

		Cursor cursor = database.query(MySQLiteHelper.TABLE_AdjectiveS,
				allColumns, null, null, null, null, null);

		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			Adjective Adjective = cursorToAdjective(cursor);
			Adjectives.add(Adjective);
			cursor.moveToNext();
		}
		// Make sure to close the cursor
		cursor.close();
		return Adjectives;
	}

	private Adjective cursorToAdjective(Cursor cursor) {
		Adjective Adjective = new Adjective();
		Adjective.setID(cursor.getLong(0));
		Adjective.setWord(cursor.getString(1));
		return Adjective;
	}
}


