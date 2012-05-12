package com.test;

import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;

public class VerbsDataSource {




	// Database fields
	private SQLiteDatabase database;
	private MySQLiteHelper dbHelper;
	private String[] allColumns = { MySQLiteHelper.COLUMN_ID,
			MySQLiteHelper.COLUMN_Verb };

	public VerbsDataSource(Context context) {
		dbHelper = new MySQLiteHelper(context);
	}

	public void open() throws SQLException {
		database = dbHelper.getWritableDatabase();
	}

	public void close() {
		dbHelper.close();
	}

	public Verb createVerb(String Verb) {
		ContentValues values = new ContentValues();
		values.put(MySQLiteHelper.COLUMN_Verb, Verb);
		long insertId = database.insert(MySQLiteHelper.TABLE_VerbS, null,
				values);
		Cursor cursor = database.query(MySQLiteHelper.TABLE_VerbS,
				allColumns, MySQLiteHelper.COLUMN_ID + " = " + insertId, null,
				null, null, null);
		cursor.moveToFirst();
		Verb newVerb = cursorToVerb(cursor);
		cursor.close();
		return newVerb;
	}

	public void deleteVerb(Verb Verb) {
		long id = Verb.getID();
		System.out.println("Verb deleted with id: " + id);
		database.delete(MySQLiteHelper.TABLE_VerbS, MySQLiteHelper.COLUMN_ID
				+ " = " + id, null);
	}

	public List<Verb> getAllVerbs() {
		List<Verb> Verbs = new ArrayList<Verb>();

		Cursor cursor = database.query(MySQLiteHelper.TABLE_VerbS,
				allColumns, null, null, null, null, null);

		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			Verb Verb = cursorToVerb(cursor);
			Verbs.add(Verb);
			cursor.moveToNext();
		}
		// Make sure to close the cursor
		cursor.close();
		return Verbs;
	}

	private Verb cursorToVerb(Cursor cursor) {
		Verb Verb = new Verb();
		Verb.setID(cursor.getLong(0));
		Verb.setWord(cursor.getString(1));
		return Verb;
	}
}


