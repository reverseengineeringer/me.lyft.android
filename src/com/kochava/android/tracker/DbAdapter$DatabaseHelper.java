package com.kochava.android.tracker;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.kochava.android.util.Logging;

class DbAdapter$DatabaseHelper
  extends SQLiteOpenHelper
{
  DbAdapter$DatabaseHelper(Context paramContext)
  {
    super(paramContext, "KochavaFeatureTracker", null, 2);
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE events (_id INTEGER PRIMARY KEY AUTOINCREMENT, data STRING NOT NULL,created_at INTEGER NOT NULL);");
    Logging.Log("DATABASE_CREATE_2 : CREATE TABLE keys (id STRING NOT NULL PRIMARY KEY, data STRING NOT NULL);");
    paramSQLiteDatabase.execSQL("CREATE TABLE keys (id STRING NOT NULL PRIMARY KEY, data STRING NOT NULL);");
    Logging.Log("DATABASE_CREATE_2 : Done");
    paramSQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS time_idx ON events (created_at);");
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    Logging.Log("Upgrading database from version " + paramInt1 + " to " + paramInt2);
    paramSQLiteDatabase.execSQL("DROP TABLE events");
    paramSQLiteDatabase.execSQL("CREATE TABLE events (_id INTEGER PRIMARY KEY AUTOINCREMENT, data STRING NOT NULL,created_at INTEGER NOT NULL);");
    paramSQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS time_idx ON events (created_at);");
  }
}

/* Location:
 * Qualified Name:     com.kochava.android.tracker.DbAdapter.DatabaseHelper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */