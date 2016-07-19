package me.lyft.android.application.android.mpmetrics;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class MPDbAdapter
{
  private static final String CREATE_EVENTS_TABLE = "CREATE TABLE " + Table.EVENTS.getName() + " (_id INTEGER PRIMARY KEY AUTOINCREMENT, " + "data" + " STRING NOT NULL, " + "created_at" + " INTEGER NOT NULL);";
  private static final String DATABASE_NAME = "mixpanel";
  private static final int DATABASE_VERSION = 4;
  private static final String EVENTS_TIME_INDEX = "CREATE INDEX IF NOT EXISTS time_idx ON " + Table.EVENTS.getName() + " (" + "created_at" + ");";
  public static final String KEY_CREATED_AT = "created_at";
  public static final String KEY_DATA = "data";
  private static final String LOGTAG = "MixpanelAPI";
  private final MPDatabaseHelper mDb;
  
  public MPDbAdapter(Context paramContext)
  {
    this(paramContext, "mixpanel");
  }
  
  public MPDbAdapter(Context paramContext, String paramString)
  {
    mDb = new MPDatabaseHelper(paramContext, paramString);
  }
  
  public int addJSON(JSONObject paramJSONObject, Table paramTable)
  {
    str = paramTable.getName();
    Object localObject3 = null;
    Object localObject2 = null;
    int j = -1;
    localObject1 = localObject2;
    paramTable = (Table)localObject3;
    try
    {
      SQLiteDatabase localSQLiteDatabase = mDb.getWritableDatabase();
      localObject1 = localObject2;
      paramTable = (Table)localObject3;
      ContentValues localContentValues = new ContentValues();
      localObject1 = localObject2;
      paramTable = (Table)localObject3;
      localContentValues.put("data", paramJSONObject.toString());
      localObject1 = localObject2;
      paramTable = (Table)localObject3;
      localContentValues.put("created_at", Long.valueOf(System.currentTimeMillis()));
      localObject1 = localObject2;
      paramTable = (Table)localObject3;
      localSQLiteDatabase.insert(str, null, localContentValues);
      localObject1 = localObject2;
      paramTable = (Table)localObject3;
      paramJSONObject = localSQLiteDatabase.rawQuery("SELECT COUNT(*) FROM " + str, null);
      localObject1 = paramJSONObject;
      paramTable = paramJSONObject;
      paramJSONObject.moveToFirst();
      localObject1 = paramJSONObject;
      paramTable = paramJSONObject;
      int i = paramJSONObject.getInt(0);
      mDb.close();
      j = i;
      if (paramJSONObject != null)
      {
        paramJSONObject.close();
        j = i;
      }
    }
    catch (SQLiteException paramJSONObject)
    {
      do
      {
        paramTable = (Table)localObject1;
        Log.e("MixpanelAPI", "addJSON " + str + " FAILED. Deleting DB.", paramJSONObject);
        paramTable = (Table)localObject1;
        mDb.deleteDatabase();
        mDb.close();
      } while (localObject1 == null);
      ((Cursor)localObject1).close();
      return -1;
    }
    finally
    {
      mDb.close();
      if (paramTable == null) {
        break label273;
      }
      paramTable.close();
    }
    return j;
  }
  
  public void cleanupEvents(long paramLong, Table paramTable)
  {
    paramTable = paramTable.getName();
    try
    {
      mDb.getWritableDatabase().delete(paramTable, "created_at <= " + paramLong, null);
      return;
    }
    catch (SQLiteException localSQLiteException)
    {
      Log.e("MixpanelAPI", "cleanupEvents " + paramTable + " by time FAILED. Deleting DB.", localSQLiteException);
      mDb.deleteDatabase();
      return;
    }
    finally
    {
      mDb.close();
    }
  }
  
  public void cleanupEvents(String paramString, Table paramTable)
  {
    paramTable = paramTable.getName();
    try
    {
      mDb.getWritableDatabase().delete(paramTable, "_id <= " + paramString, null);
      return;
    }
    catch (SQLiteException paramString)
    {
      Log.e("MixpanelAPI", "cleanupEvents " + paramTable + " by id FAILED. Deleting DB.", paramString);
      mDb.deleteDatabase();
      return;
    }
    finally
    {
      mDb.close();
    }
  }
  
  public void deleteDB()
  {
    mDb.deleteDatabase();
  }
  
  public String[] generateDataString(Table paramTable)
  {
    Object localObject4 = null;
    localObject1 = null;
    Cursor localCursor = null;
    str2 = null;
    String str1 = null;
    localObject3 = paramTable.getName();
    paramTable = localCursor;
    try
    {
      localCursor = mDb.getReadableDatabase().rawQuery("SELECT * FROM " + (String)localObject3 + " ORDER BY " + "created_at" + " ASC LIMIT 50", null);
      paramTable = localCursor;
      localObject1 = localCursor;
      JSONArray localJSONArray = new JSONArray();
      for (;;)
      {
        paramTable = localCursor;
        localObject1 = localCursor;
        if (!localCursor.moveToNext()) {
          break;
        }
        paramTable = localCursor;
        localObject1 = localCursor;
        if (localCursor.isLast())
        {
          paramTable = localCursor;
          localObject1 = localCursor;
          str1 = localCursor.getString(localCursor.getColumnIndex("_id"));
        }
        paramTable = localCursor;
        localObject1 = localCursor;
        try
        {
          localJSONArray.put(new JSONObject(localCursor.getString(localCursor.getColumnIndex("data"))));
        }
        catch (JSONException paramTable) {}
      }
      paramTable = localCursor;
      localObject1 = localCursor;
      if (localJSONArray.length() > 0)
      {
        paramTable = localCursor;
        localObject1 = localCursor;
        str2 = localJSONArray.toString();
      }
      mDb.close();
      localObject1 = str2;
      localObject3 = str1;
      if (localCursor != null)
      {
        localCursor.close();
        localObject3 = str1;
        localObject1 = str2;
      }
    }
    catch (SQLiteException localSQLiteException)
    {
      for (;;)
      {
        localObject1 = paramTable;
        Log.e("MixpanelAPI", "generateDataString " + (String)localObject3, localSQLiteException);
        Object localObject2 = null;
        str2 = null;
        mDb.close();
        localObject1 = str2;
        localObject3 = localObject2;
        if (paramTable != null)
        {
          paramTable.close();
          localObject1 = str2;
          localObject3 = localObject2;
        }
      }
    }
    finally
    {
      mDb.close();
      if (localObject1 == null) {
        break label356;
      }
      ((Cursor)localObject1).close();
    }
    paramTable = (Table)localObject4;
    if (localObject3 != null)
    {
      paramTable = (Table)localObject4;
      if (localObject1 != null)
      {
        paramTable = new String[2];
        paramTable[0] = localObject3;
        paramTable[1] = localObject1;
      }
    }
    return paramTable;
  }
  
  private static class MPDatabaseHelper
    extends SQLiteOpenHelper
  {
    private final File mDatabaseFile;
    
    MPDatabaseHelper(Context paramContext, String paramString)
    {
      super(paramString, null, 4);
      mDatabaseFile = paramContext.getDatabasePath(paramString);
    }
    
    public void deleteDatabase()
    {
      close();
      mDatabaseFile.delete();
    }
    
    public void onCreate(SQLiteDatabase paramSQLiteDatabase)
    {
      paramSQLiteDatabase.execSQL(MPDbAdapter.CREATE_EVENTS_TABLE);
      paramSQLiteDatabase.execSQL(MPDbAdapter.EVENTS_TIME_INDEX);
    }
    
    public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
    {
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + MPDbAdapter.Table.EVENTS.getName());
      paramSQLiteDatabase.execSQL(MPDbAdapter.CREATE_EVENTS_TABLE);
      paramSQLiteDatabase.execSQL(MPDbAdapter.EVENTS_TIME_INDEX);
    }
  }
  
  public static enum Table
  {
    EVENTS("events");
    
    private final String mTableName;
    
    private Table(String paramString)
    {
      mTableName = paramString;
    }
    
    public String getName()
    {
      return mTableName;
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.android.mpmetrics.MPDbAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */