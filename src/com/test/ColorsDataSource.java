package com.test;

import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;

public class ColorsDataSource {




	// Database fields
	private SQLiteDatabase database;
	private MySQLiteHelper dbHelper;
	private String[] allColumns = { MySQLiteHelper.COLUMN_ID,
			MySQLiteHelper.COLUMN_Color };

	public ColorsDataSource(Context context) {
		dbHelper = new MySQLiteHelper(context);
	}

	public void open() throws SQLException {
		database = dbHelper.getWritableDatabase();
	}

	public void close() {
		dbHelper.close();
	}

	public Color createColor(String Color) {
		ContentValues values = new ContentValues();
		values.put(MySQLiteHelper.COLUMN_Color, Color);
		long insertId = database.insert(MySQLiteHelper.TABLE_ColorS, null,
				values);
		Cursor cursor = database.query(MySQLiteHelper.TABLE_ColorS,
				allColumns, MySQLiteHelper.COLUMN_ID + " = " + insertId, null,
				null, null, null);
		cursor.moveToFirst();
		Color newColor = cursorToColor(cursor);
		cursor.close();
		return newColor;
	}

	public void deleteColor(Color Color) {
		long id = Color.getID();
		System.out.println("Color deleted with id: " + id);
		database.delete(MySQLiteHelper.TABLE_ColorS, MySQLiteHelper.COLUMN_ID
				+ " = " + id, null);
	}

	public List<Color> getAllColors() {
		List<Color> Colors = new ArrayList<Color>();

		Cursor cursor = database.query(MySQLiteHelper.TABLE_ColorS,
				allColumns, null, null, null, null, null);

		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			Color Color = cursorToColor(cursor);
			Colors.add(Color);
			cursor.moveToNext();
		}
		// Make sure to close the cursor
		cursor.close();
		return Colors;
	}

	private Color cursorToColor(Cursor cursor) {
		Color Color = new Color();
		Color.setID(cursor.getLong(0));
		Color.setWord(cursor.getString(1));
		return Color;
	}
}


