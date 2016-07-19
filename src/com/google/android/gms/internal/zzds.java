package com.google.android.gms.internal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.google.android.gms.common.util.zze;

@zzir
public class zzds
{
  private static final Object zzamp = new Object();
  private static zzds zzber;
  private final Context mContext;
  private final zze zzaoa;
  private final zza zzbes;
  private long zzbet;
  
  private zzds(Context paramContext, zze paramzze)
  {
    mContext = paramContext;
    zzbes = new zza(mContext);
    zzaoa = paramzze;
    zzbet = zzdr.zzbeq;
  }
  
  public static zzds zza(Context paramContext, zze paramzze)
  {
    synchronized (zzamp)
    {
      if (zzber == null) {
        zzber = new zzds(paramContext, paramzze);
      }
      paramContext = zzber;
      return paramContext;
    }
  }
  
  private void zza(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    try
    {
      Cursor localCursor = paramSQLiteDatabase.query("directappinstall", new String[] { "path" }, "package = ?", new String[] { paramString }, null, null, null);
      if (localCursor != null)
      {
        if (localCursor.getCount() > 0)
        {
          localCursor.moveToFirst();
          String str = localCursor.getString(localCursor.getColumnIndex("path"));
          if (!TextUtils.isEmpty(str)) {
            zzdt.zzkq().zzd(mContext, str);
          }
          paramSQLiteDatabase.delete("directappinstall", "package = ?", new String[] { paramString });
        }
        localCursor.close();
      }
      paramSQLiteDatabase.delete("directappinstall", "timestamp < ?", new String[] { Long.toString(Long.valueOf(zzaoa.currentTimeMillis() - zzkp()).longValue()) });
      return;
    }
    catch (SQLiteException localSQLiteException)
    {
      for (;;)
      {
        zzkh.zzcw(String.valueOf(paramString).length() + 70 + "No package name " + paramString + " was recorded. Cleaning up records older than one day.");
        Object localObject = null;
      }
    }
  }
  
  private long zzkp()
  {
    return zzbet;
  }
  
  public void zza(long paramLong, String paramString1, String paramString2)
  {
    SQLiteDatabase localSQLiteDatabase = zzbes.getWritableDatabase();
    zza(localSQLiteDatabase, paramString1);
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("reference", Long.valueOf(paramLong));
    localContentValues.put("package", paramString1);
    localContentValues.put("tracking_url", paramString2);
    localContentValues.put("timestamp", Long.valueOf(zzaoa.currentTimeMillis()));
    localSQLiteDatabase.insert("directappinstall", null, localContentValues);
    zzbes.close();
  }
  
  public boolean zzat(String paramString)
  {
    String str = String.valueOf(paramString);
    if (str.length() != 0)
    {
      str = "Deleting entry in direct app install log with file path: ".concat(str);
      zzkh.zzcw(str);
      if (zzbes.getWritableDatabase().delete("directappinstall", "path = ?", new String[] { paramString }) <= 0) {
        break label72;
      }
    }
    label72:
    for (boolean bool = true;; bool = false)
    {
      zzbes.close();
      return bool;
      str = new String("Deleting entry in direct app install log with file path: ");
      break;
    }
  }
  
  private static class zza
    extends SQLiteOpenHelper
  {
    public zza(Context paramContext)
    {
      super("direct_app_install_log.db", null, 1);
    }
    
    public void onCreate(SQLiteDatabase paramSQLiteDatabase)
    {
      paramSQLiteDatabase.execSQL("CREATE TABLE directappinstall( column_id INTEGER PRIMARY KEY AUTOINCREMENT, reference LONG, package TEXT, tracking_url TEXT, timestamp INTEGER, path TEXT);");
    }
    
    public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
    {
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS directappinstall");
      onCreate(paramSQLiteDatabase);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzds
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */