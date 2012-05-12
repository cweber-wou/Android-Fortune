package com.test;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MySQLiteHelper extends SQLiteOpenHelper {

	public static final String TABLE_NounS = "Nouns";
	public static final String COLUMN_ID = "_id";
	public static final String COLUMN_Noun = "Noun";
	public static final String TABLE_TimeS = "Times";
	public static final String COLUMN_Time = "Time";
	public static final String TABLE_ColorS = "Colors";
	public static final String COLUMN_Color = "Color";
	public static final String TABLE_AdjectiveS = "Adjectives";
	public static final String COLUMN_Adjective = "Adjective";
	public static final String TABLE_AdverbS = "Adverbs";
	public static final String COLUMN_Adverb = "Adverb";
	public static final String TABLE_NumberS = "Numbers";
	public static final String COLUMN_Number = "Number";
	public static final String TABLE_VerbS = "Verbs";
	public static final String COLUMN_Verb = "Verb";

	private static final String DATABASE_NAME = "Fortune.db";
	private static final int DATABASE_VERSION = 1;

	// Database creation sql statement
	private static final String DATABASE_CREATE = "create table "
			+ TABLE_NounS + "( " + COLUMN_ID
			+ " integer primary key autoincrement, " + COLUMN_Noun
			+ " text not null);"
			+"create table "
			+ TABLE_TimeS + "( " + COLUMN_ID
			+ " integer primary key autoincrement, " + COLUMN_Time
			+ " text not null);"
			+"create table "
			+ TABLE_ColorS + "( " + COLUMN_ID
			+ " integer primary key autoincrement, " + COLUMN_Color
			+ " text not null);"
			+"create table "
			+ TABLE_AdjectiveS + "( " + COLUMN_ID
			+ " integer primary key autoincrement, " + COLUMN_Adjective
			+ " text not null);"
			+"create table "
			+ TABLE_AdverbS + "( " + COLUMN_ID
			+ " integer primary key autoincrement, " + COLUMN_Adverb
			+ " text not null);"
			+"create table "
			+ TABLE_NumberS + "( " + COLUMN_ID
			+ " integer primary key autoincrement, " + COLUMN_Number
			+ " text not null);"
			+"create table "
			+ TABLE_VerbS + "( " + COLUMN_ID
			+ " integer primary key autoincrement, " + COLUMN_Verb
			+ " text not null);";

	public MySQLiteHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase database) {
		database.execSQL(DATABASE_CREATE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		Log.w(MySQLiteHelper.class.getName(),
				"Upgrading database from version " + oldVersion + " to "
						+ newVersion + ", which will destroy all old data");
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_NounS);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_VerbS);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_NumberS);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_AdverbS);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_AdjectiveS);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_ColorS);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_TimeS);
		onCreate(db);
	}

}
