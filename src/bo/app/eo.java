package bo.app;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build.VERSION;
import com.appboy.Constants;
import com.appboy.support.AppboyLogger;
import com.appboy.support.StringUtils;
import java.util.HashMap;
import java.util.Map;

public final class eo
  extends SQLiteOpenHelper
{
  private static final String a = String.format("%s.%s", new Object[] { Constants.APPBOY_LOG_TAG_PREFIX, eo.class.getName() });
  private static volatile Map<String, eo> b = new HashMap();
  private static final String c = String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT UNIQUE NOT NULL, %s INTEGER NOT NULL, %s INTEGER, %s TEXT, %s TEXT, %s REAL, %s REAL, %s INTEGER NOT NULL CHECK(%s IN (%s, %s)), %s INTEGER NOT NULL CHECK(%s IN (%s, %s)), %s INTEGER NOT NULL CHECK(%s IN (%s, %s)));", new Object[] { "ab_sessions", "_id", "session_id", "start_time", "end_time", "latitude", "longitude", "altitude", "accuracy", "new_sent", "new_sent", Integer.valueOf(1), Integer.valueOf(0), "sealed", "sealed", Integer.valueOf(1), Integer.valueOf(0), "endtime_sent", "endtime_sent", Integer.valueOf(1), Integer.valueOf(0) });
  private static final String d = String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT, %s TEXT NOT NULL, %s TEXT NOT NULL, %s INTEGER NOT NULL);", new Object[] { "ab_events", "_id", "session_id", "event_type", "event_data", "timestamp" });
  
  private eo(Context paramContext, String paramString)
  {
    super(paramContext, paramString, null, 2);
  }
  
  public static eo a(Context paramContext, String paramString)
  {
    if (StringUtils.isNullOrBlank(paramString)) {
      paramString = "appboy.db";
    }
    for (;;)
    {
      if (!b.containsKey(paramString)) {}
      try
      {
        if (!b.containsKey(paramString))
        {
          paramContext = new eo(paramContext, paramString);
          b.put(paramString, paramContext);
          return paramContext;
          paramString = String.format("%s.%s", new Object[] { "appboy.db", paramString });
          continue;
        }
        return (eo)b.get(paramString);
      }
      finally
      {
        paramContext = finally;
        throw paramContext;
      }
    }
  }
  
  public final void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    AppboyLogger.i(a, String.format("Creating %s table", new Object[] { "ab_sessions" }));
    paramSQLiteDatabase.execSQL(c);
    AppboyLogger.i(a, String.format("Creating %s table", new Object[] { "ab_events" }));
    paramSQLiteDatabase.execSQL(d);
  }
  
  public final void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    AppboyLogger.i(a, String.format("Downgrading storage from version %d to %d. Dropping all current tables.", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    paramSQLiteDatabase.execSQL(String.format("DROP TABLE IF EXISTS %s;", new Object[] { "ab_events" }));
    paramSQLiteDatabase.execSQL(String.format("DROP TABLE IF EXISTS %s;", new Object[] { "ab_sessions" }));
    onCreate(paramSQLiteDatabase);
  }
  
  public final void onOpen(SQLiteDatabase paramSQLiteDatabase)
  {
    super.onOpen(paramSQLiteDatabase);
    if (Build.VERSION.SDK_INT >= 16) {
      paramSQLiteDatabase.setForeignKeyConstraintsEnabled(true);
    }
    while (paramSQLiteDatabase.isReadOnly()) {
      return;
    }
    paramSQLiteDatabase.execSQL("PRAGMA foreign_keys = ON;");
  }
  
  public final void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    if (paramInt2 == 2)
    {
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS sessions");
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS appboy_events");
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS ab_sessions");
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS ab_events");
      onCreate(paramSQLiteDatabase);
      return;
    }
    AppboyLogger.e(a, String.format("Received call to onUpgrade with unknown upgrade version %d.  Please contact Appboy to report this error.", new Object[] { Integer.valueOf(paramInt2) }));
  }
}

/* Location:
 * Qualified Name:     bo.app.eo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */