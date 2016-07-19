package me.lyft.android.application.android.mpmetrics;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.io.File;

class MPDbAdapter$MPDatabaseHelper
  extends SQLiteOpenHelper
{
  private final File mDatabaseFile;
  
  MPDbAdapter$MPDatabaseHelper(Context paramContext, String paramString)
  {
    super(paramContext, paramString, null, 4);
    mDatabaseFile = paramContext.getDatabasePath(paramString);
  }
  
  public void deleteDatabase()
  {
    close();
    mDatabaseFile.delete();
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL(MPDbAdapter.access$000());
    paramSQLiteDatabase.execSQL(MPDbAdapter.access$100());
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + MPDbAdapter.Table.EVENTS.getName());
    paramSQLiteDatabase.execSQL(MPDbAdapter.access$000());
    paramSQLiteDatabase.execSQL(MPDbAdapter.access$100());
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.android.mpmetrics.MPDbAdapter.MPDatabaseHelper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */