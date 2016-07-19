package com.google.android.gms.measurement.internal;

import android.annotation.TargetApi;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.CursorWindow;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build.VERSION;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.internal.zzaov;
import com.google.android.gms.internal.zzun.zza;
import com.google.android.gms.internal.zzun.zzb;
import com.google.android.gms.internal.zzun.zze;
import com.google.android.gms.internal.zzup.zzb;
import com.google.android.gms.internal.zzup.zze;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class zze
  extends zzaa
{
  private static final Map<String, String> ajJ = new ArrayMap(16);
  private final zzc ajK;
  private final zzah ajL = new zzah(zzyw());
  
  static
  {
    ajJ.put("app_version", "ALTER TABLE apps ADD COLUMN app_version TEXT;");
    ajJ.put("app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;");
    ajJ.put("gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;");
    ajJ.put("dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;");
    ajJ.put("measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;");
    ajJ.put("last_bundle_start_timestamp", "ALTER TABLE apps ADD COLUMN last_bundle_start_timestamp INTEGER;");
    ajJ.put("day", "ALTER TABLE apps ADD COLUMN day INTEGER;");
    ajJ.put("daily_public_events_count", "ALTER TABLE apps ADD COLUMN daily_public_events_count INTEGER;");
    ajJ.put("daily_events_count", "ALTER TABLE apps ADD COLUMN daily_events_count INTEGER;");
    ajJ.put("daily_conversions_count", "ALTER TABLE apps ADD COLUMN daily_conversions_count INTEGER;");
    ajJ.put("remote_config", "ALTER TABLE apps ADD COLUMN remote_config BLOB;");
    ajJ.put("config_fetched_time", "ALTER TABLE apps ADD COLUMN config_fetched_time INTEGER;");
    ajJ.put("failed_config_fetch_time", "ALTER TABLE apps ADD COLUMN failed_config_fetch_time INTEGER;");
    ajJ.put("app_version_int", "ALTER TABLE apps ADD COLUMN app_version_int INTEGER;");
    ajJ.put("firebase_instance_id", "ALTER TABLE apps ADD COLUMN firebase_instance_id TEXT;");
    ajJ.put("daily_error_events_count", "ALTER TABLE apps ADD COLUMN daily_error_events_count INTEGER;");
  }
  
  zze(zzx paramzzx)
  {
    super(paramzzx);
    paramzzx = zzaab();
    ajK = new zzc(getContext(), paramzzx);
  }
  
  @TargetApi(11)
  static int zza(Cursor paramCursor, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 11) {
      return paramCursor.getType(paramInt);
    }
    CursorWindow localCursorWindow = ((SQLiteCursor)paramCursor).getWindow();
    int i = paramCursor.getPosition();
    if (localCursorWindow.isNull(i, paramInt)) {
      return 0;
    }
    if (localCursorWindow.isLong(i, paramInt)) {
      return 1;
    }
    if (localCursorWindow.isFloat(i, paramInt)) {
      return 2;
    }
    if (localCursorWindow.isString(i, paramInt)) {
      return 3;
    }
    if (localCursorWindow.isBlob(i, paramInt)) {
      return 4;
    }
    return -1;
  }
  
  private long zza(String paramString, String[] paramArrayOfString, long paramLong)
  {
    SQLiteDatabase localSQLiteDatabase = getWritableDatabase();
    Object localObject = null;
    String[] arrayOfString = null;
    try
    {
      paramArrayOfString = localSQLiteDatabase.rawQuery(paramString, paramArrayOfString);
      arrayOfString = paramArrayOfString;
      localObject = paramArrayOfString;
      long l;
      if (paramArrayOfString.moveToFirst())
      {
        arrayOfString = paramArrayOfString;
        localObject = paramArrayOfString;
        paramLong = paramArrayOfString.getLong(0);
        l = paramLong;
        if (paramArrayOfString != null)
        {
          paramArrayOfString.close();
          l = paramLong;
        }
      }
      do
      {
        return l;
        l = paramLong;
      } while (paramArrayOfString == null);
      paramArrayOfString.close();
      return paramLong;
    }
    catch (SQLiteException paramArrayOfString)
    {
      localObject = arrayOfString;
      zzbsz().zzbtr().zze("Database error", paramString, paramArrayOfString);
      localObject = arrayOfString;
      throw paramArrayOfString;
    }
    finally
    {
      if (localObject != null) {
        ((Cursor)localObject).close();
      }
    }
  }
  
  private void zza(String paramString, zzun.zza paramzza)
  {
    int k = 0;
    zzzg();
    zzwu();
    zzab.zzhs(paramString);
    zzab.zzaa(paramzza);
    zzab.zzaa(anY);
    zzab.zzaa(anX);
    if (anW == null) {
      zzbsz().zzbtt().log("Audience with no ID");
    }
    label236:
    label281:
    label290:
    label291:
    for (;;)
    {
      return;
      int n = anW.intValue();
      Object localObject = anY;
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        if (aoa == null)
        {
          zzbsz().zzbtt().zze("Event filter with no ID. Audience definition ignored. appId, audienceId", paramString, anW);
          return;
        }
        i += 1;
      }
      localObject = anX;
      j = localObject.length;
      i = 0;
      while (i < j)
      {
        if (aoa == null)
        {
          zzbsz().zzbtt().zze("Property filter with no ID. Audience definition ignored. appId, audienceId", paramString, anW);
          return;
        }
        i += 1;
      }
      int m = 1;
      localObject = anY;
      int i1 = localObject.length;
      j = 0;
      i = m;
      if (j < i1)
      {
        if (!zza(paramString, n, localObject[j])) {
          i = 0;
        }
      }
      else
      {
        if (i == 0) {
          break label290;
        }
        paramzza = anX;
        m = paramzza.length;
        j = 0;
        if (j >= m) {
          break label290;
        }
        if (zza(paramString, n, paramzza[j])) {
          break label281;
        }
        i = k;
      }
      for (;;)
      {
        if (i != 0) {
          break label291;
        }
        zzz(paramString, n);
        return;
        j += 1;
        break;
        j += 1;
        break label236;
      }
    }
  }
  
  private boolean zza(String paramString, int paramInt, zzun.zzb paramzzb)
  {
    zzzg();
    zzwu();
    zzab.zzhs(paramString);
    zzab.zzaa(paramzzb);
    if (TextUtils.isEmpty(aob))
    {
      zzbsz().zzbtt().zze("Event filter had no event name. Audience definition ignored. audienceId, filterId", Integer.valueOf(paramInt), String.valueOf(aoa));
      return false;
    }
    try
    {
      byte[] arrayOfByte = new byte[paramzzb.ao()];
      Object localObject = zzaov.zzba(arrayOfByte);
      paramzzb.zza((zzaov)localObject);
      ((zzaov)localObject).ab();
      localObject = new ContentValues();
      ((ContentValues)localObject).put("app_id", paramString);
      ((ContentValues)localObject).put("audience_id", Integer.valueOf(paramInt));
      ((ContentValues)localObject).put("filter_id", aoa);
      ((ContentValues)localObject).put("event_name", aob);
      ((ContentValues)localObject).put("data", arrayOfByte);
      return false;
    }
    catch (IOException paramString)
    {
      try
      {
        if (getWritableDatabase().insertWithOnConflict("event_filters", null, (ContentValues)localObject, 5) == -1L) {
          zzbsz().zzbtr().log("Failed to insert event filter (got -1)");
        }
        return true;
      }
      catch (SQLiteException paramString)
      {
        zzbsz().zzbtr().zzj("Error storing event filter", paramString);
      }
      paramString = paramString;
      zzbsz().zzbtr().zzj("Configuration loss. Failed to serialize event filter", paramString);
      return false;
    }
  }
  
  private boolean zza(String paramString, int paramInt, zzun.zze paramzze)
  {
    zzzg();
    zzwu();
    zzab.zzhs(paramString);
    zzab.zzaa(paramzze);
    if (TextUtils.isEmpty(aoq))
    {
      zzbsz().zzbtt().zze("Property filter had no property name. Audience definition ignored. audienceId, filterId", Integer.valueOf(paramInt), String.valueOf(aoa));
      return false;
    }
    try
    {
      byte[] arrayOfByte = new byte[paramzze.ao()];
      Object localObject = zzaov.zzba(arrayOfByte);
      paramzze.zza((zzaov)localObject);
      ((zzaov)localObject).ab();
      localObject = new ContentValues();
      ((ContentValues)localObject).put("app_id", paramString);
      ((ContentValues)localObject).put("audience_id", Integer.valueOf(paramInt));
      ((ContentValues)localObject).put("filter_id", aoa);
      ((ContentValues)localObject).put("property_name", aoq);
      ((ContentValues)localObject).put("data", arrayOfByte);
      try
      {
        if (getWritableDatabase().insertWithOnConflict("property_filters", null, (ContentValues)localObject, 5) == -1L)
        {
          zzbsz().zzbtr().log("Failed to insert property filter (got -1)");
          return false;
        }
      }
      catch (SQLiteException paramString)
      {
        zzbsz().zzbtr().zzj("Error storing property filter", paramString);
        return false;
      }
      return true;
    }
    catch (IOException paramString)
    {
      zzbsz().zzbtr().zzj("Configuration loss. Failed to serialize property filter", paramString);
      return false;
    }
  }
  
  private long zzb(String paramString, String[] paramArrayOfString)
  {
    SQLiteDatabase localSQLiteDatabase = getWritableDatabase();
    Object localObject = null;
    String[] arrayOfString = null;
    try
    {
      paramArrayOfString = localSQLiteDatabase.rawQuery(paramString, paramArrayOfString);
      arrayOfString = paramArrayOfString;
      localObject = paramArrayOfString;
      if (paramArrayOfString.moveToFirst())
      {
        arrayOfString = paramArrayOfString;
        localObject = paramArrayOfString;
        long l = paramArrayOfString.getLong(0);
        if (paramArrayOfString != null) {
          paramArrayOfString.close();
        }
        return l;
      }
      arrayOfString = paramArrayOfString;
      localObject = paramArrayOfString;
      throw new SQLiteException("Database returned empty set");
    }
    catch (SQLiteException paramArrayOfString)
    {
      localObject = arrayOfString;
      zzbsz().zzbtr().zze("Database error", paramString, paramArrayOfString);
      localObject = arrayOfString;
      throw paramArrayOfString;
    }
    finally
    {
      if (localObject != null) {
        ((Cursor)localObject).close();
      }
    }
  }
  
  private boolean zzbti()
  {
    return getContext().getDatabasePath(zzaab()).exists();
  }
  
  public void beginTransaction()
  {
    zzzg();
    getWritableDatabase().beginTransaction();
  }
  
  public void endTransaction()
  {
    zzzg();
    getWritableDatabase().endTransaction();
  }
  
  SQLiteDatabase getWritableDatabase()
  {
    zzwu();
    try
    {
      SQLiteDatabase localSQLiteDatabase = ajK.getWritableDatabase();
      return localSQLiteDatabase;
    }
    catch (SQLiteException localSQLiteException)
    {
      zzbsz().zzbtt().zzj("Error opening database", localSQLiteException);
      throw localSQLiteException;
    }
  }
  
  public void setTransactionSuccessful()
  {
    zzzg();
    getWritableDatabase().setTransactionSuccessful();
  }
  
  /* Error */
  public zza zza(long paramLong, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    // Byte code:
    //   0: aload_3
    //   1: invokestatic 229	com/google/android/gms/common/internal/zzab:zzhs	(Ljava/lang/String;)Ljava/lang/String;
    //   4: pop
    //   5: aload_0
    //   6: invokevirtual 223	com/google/android/gms/measurement/internal/zze:zzwu	()V
    //   9: aload_0
    //   10: invokevirtual 220	com/google/android/gms/measurement/internal/zze:zzzg	()V
    //   13: new 6	com/google/android/gms/measurement/internal/zze$zza
    //   16: dup
    //   17: invokespecial 412	com/google/android/gms/measurement/internal/zze$zza:<init>	()V
    //   20: astore 9
    //   22: aload_0
    //   23: invokevirtual 180	com/google/android/gms/measurement/internal/zze:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   26: astore 10
    //   28: aload 10
    //   30: ldc_w 414
    //   33: iconst_5
    //   34: anewarray 303	java/lang/String
    //   37: dup
    //   38: iconst_0
    //   39: ldc 62
    //   41: aastore
    //   42: dup
    //   43: iconst_1
    //   44: ldc 70
    //   46: aastore
    //   47: dup
    //   48: iconst_2
    //   49: ldc 66
    //   51: aastore
    //   52: dup
    //   53: iconst_3
    //   54: ldc 74
    //   56: aastore
    //   57: dup
    //   58: iconst_4
    //   59: ldc 98
    //   61: aastore
    //   62: ldc_w 416
    //   65: iconst_1
    //   66: anewarray 303	java/lang/String
    //   69: dup
    //   70: iconst_0
    //   71: aload_3
    //   72: aastore
    //   73: aconst_null
    //   74: aconst_null
    //   75: aconst_null
    //   76: invokevirtual 420	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   79: astore 8
    //   81: aload 8
    //   83: astore 7
    //   85: aload 8
    //   87: invokeinterface 190 1 0
    //   92: ifne +36 -> 128
    //   95: aload 8
    //   97: astore 7
    //   99: aload_0
    //   100: invokevirtual 201	com/google/android/gms/measurement/internal/zze:zzbsz	()Lcom/google/android/gms/measurement/internal/zzp;
    //   103: invokevirtual 250	com/google/android/gms/measurement/internal/zzp:zzbtt	()Lcom/google/android/gms/measurement/internal/zzp$zza;
    //   106: ldc_w 422
    //   109: aload_3
    //   110: invokevirtual 360	com/google/android/gms/measurement/internal/zzp$zza:zzj	(Ljava/lang/String;Ljava/lang/Object;)V
    //   113: aload 8
    //   115: ifnull +10 -> 125
    //   118: aload 8
    //   120: invokeinterface 197 1 0
    //   125: aload 9
    //   127: areturn
    //   128: aload 8
    //   130: astore 7
    //   132: aload 8
    //   134: iconst_0
    //   135: invokeinterface 194 2 0
    //   140: lload_1
    //   141: lcmp
    //   142: ifne +71 -> 213
    //   145: aload 8
    //   147: astore 7
    //   149: aload 9
    //   151: aload 8
    //   153: iconst_1
    //   154: invokeinterface 194 2 0
    //   159: putfield 426	com/google/android/gms/measurement/internal/zze$zza:ajN	J
    //   162: aload 8
    //   164: astore 7
    //   166: aload 9
    //   168: aload 8
    //   170: iconst_2
    //   171: invokeinterface 194 2 0
    //   176: putfield 429	com/google/android/gms/measurement/internal/zze$zza:ajM	J
    //   179: aload 8
    //   181: astore 7
    //   183: aload 9
    //   185: aload 8
    //   187: iconst_3
    //   188: invokeinterface 194 2 0
    //   193: putfield 432	com/google/android/gms/measurement/internal/zze$zza:ajO	J
    //   196: aload 8
    //   198: astore 7
    //   200: aload 9
    //   202: aload 8
    //   204: iconst_4
    //   205: invokeinterface 194 2 0
    //   210: putfield 435	com/google/android/gms/measurement/internal/zze$zza:ajP	J
    //   213: aload 8
    //   215: astore 7
    //   217: aload 9
    //   219: aload 9
    //   221: getfield 426	com/google/android/gms/measurement/internal/zze$zza:ajN	J
    //   224: lconst_1
    //   225: ladd
    //   226: putfield 426	com/google/android/gms/measurement/internal/zze$zza:ajN	J
    //   229: iload 4
    //   231: ifeq +19 -> 250
    //   234: aload 8
    //   236: astore 7
    //   238: aload 9
    //   240: aload 9
    //   242: getfield 429	com/google/android/gms/measurement/internal/zze$zza:ajM	J
    //   245: lconst_1
    //   246: ladd
    //   247: putfield 429	com/google/android/gms/measurement/internal/zze$zza:ajM	J
    //   250: iload 5
    //   252: ifeq +19 -> 271
    //   255: aload 8
    //   257: astore 7
    //   259: aload 9
    //   261: aload 9
    //   263: getfield 432	com/google/android/gms/measurement/internal/zze$zza:ajO	J
    //   266: lconst_1
    //   267: ladd
    //   268: putfield 432	com/google/android/gms/measurement/internal/zze$zza:ajO	J
    //   271: iload 6
    //   273: ifeq +19 -> 292
    //   276: aload 8
    //   278: astore 7
    //   280: aload 9
    //   282: aload 9
    //   284: getfield 435	com/google/android/gms/measurement/internal/zze$zza:ajP	J
    //   287: lconst_1
    //   288: ladd
    //   289: putfield 435	com/google/android/gms/measurement/internal/zze$zza:ajP	J
    //   292: aload 8
    //   294: astore 7
    //   296: new 323	android/content/ContentValues
    //   299: dup
    //   300: invokespecial 325	android/content/ContentValues:<init>	()V
    //   303: astore 11
    //   305: aload 8
    //   307: astore 7
    //   309: aload 11
    //   311: ldc 62
    //   313: lload_1
    //   314: invokestatic 440	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   317: invokevirtual 443	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   320: aload 8
    //   322: astore 7
    //   324: aload 11
    //   326: ldc 66
    //   328: aload 9
    //   330: getfield 429	com/google/android/gms/measurement/internal/zze$zza:ajM	J
    //   333: invokestatic 440	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   336: invokevirtual 443	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   339: aload 8
    //   341: astore 7
    //   343: aload 11
    //   345: ldc 70
    //   347: aload 9
    //   349: getfield 426	com/google/android/gms/measurement/internal/zze$zza:ajN	J
    //   352: invokestatic 440	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   355: invokevirtual 443	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   358: aload 8
    //   360: astore 7
    //   362: aload 11
    //   364: ldc 74
    //   366: aload 9
    //   368: getfield 432	com/google/android/gms/measurement/internal/zze$zza:ajO	J
    //   371: invokestatic 440	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   374: invokevirtual 443	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   377: aload 8
    //   379: astore 7
    //   381: aload 11
    //   383: ldc 98
    //   385: aload 9
    //   387: getfield 435	com/google/android/gms/measurement/internal/zze$zza:ajP	J
    //   390: invokestatic 440	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   393: invokevirtual 443	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   396: aload 8
    //   398: astore 7
    //   400: aload 10
    //   402: ldc_w 414
    //   405: aload 11
    //   407: ldc_w 416
    //   410: iconst_1
    //   411: anewarray 303	java/lang/String
    //   414: dup
    //   415: iconst_0
    //   416: aload_3
    //   417: aastore
    //   418: invokevirtual 447	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   421: pop
    //   422: aload 8
    //   424: ifnull +10 -> 434
    //   427: aload 8
    //   429: invokeinterface 197 1 0
    //   434: aload 9
    //   436: areturn
    //   437: astore_3
    //   438: aconst_null
    //   439: astore 8
    //   441: aload 8
    //   443: astore 7
    //   445: aload_0
    //   446: invokevirtual 201	com/google/android/gms/measurement/internal/zze:zzbsz	()Lcom/google/android/gms/measurement/internal/zzp;
    //   449: invokevirtual 207	com/google/android/gms/measurement/internal/zzp:zzbtr	()Lcom/google/android/gms/measurement/internal/zzp$zza;
    //   452: ldc_w 449
    //   455: aload_3
    //   456: invokevirtual 360	com/google/android/gms/measurement/internal/zzp$zza:zzj	(Ljava/lang/String;Ljava/lang/Object;)V
    //   459: aload 8
    //   461: ifnull +10 -> 471
    //   464: aload 8
    //   466: invokeinterface 197 1 0
    //   471: aload 9
    //   473: areturn
    //   474: astore_3
    //   475: aconst_null
    //   476: astore 7
    //   478: aload 7
    //   480: ifnull +10 -> 490
    //   483: aload 7
    //   485: invokeinterface 197 1 0
    //   490: aload_3
    //   491: athrow
    //   492: astore_3
    //   493: goto -15 -> 478
    //   496: astore_3
    //   497: goto -56 -> 441
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	500	0	this	zze
    //   0	500	1	paramLong	long
    //   0	500	3	paramString	String
    //   0	500	4	paramBoolean1	boolean
    //   0	500	5	paramBoolean2	boolean
    //   0	500	6	paramBoolean3	boolean
    //   83	401	7	localCursor1	Cursor
    //   79	386	8	localCursor2	Cursor
    //   20	452	9	localzza	zza
    //   26	375	10	localSQLiteDatabase	SQLiteDatabase
    //   303	103	11	localContentValues	ContentValues
    // Exception table:
    //   from	to	target	type
    //   22	81	437	android/database/sqlite/SQLiteException
    //   22	81	474	finally
    //   85	95	492	finally
    //   99	113	492	finally
    //   132	145	492	finally
    //   149	162	492	finally
    //   166	179	492	finally
    //   183	196	492	finally
    //   200	213	492	finally
    //   217	229	492	finally
    //   238	250	492	finally
    //   259	271	492	finally
    //   280	292	492	finally
    //   296	305	492	finally
    //   309	320	492	finally
    //   324	339	492	finally
    //   343	358	492	finally
    //   362	377	492	finally
    //   381	396	492	finally
    //   400	422	492	finally
    //   445	459	492	finally
    //   85	95	496	android/database/sqlite/SQLiteException
    //   99	113	496	android/database/sqlite/SQLiteException
    //   132	145	496	android/database/sqlite/SQLiteException
    //   149	162	496	android/database/sqlite/SQLiteException
    //   166	179	496	android/database/sqlite/SQLiteException
    //   183	196	496	android/database/sqlite/SQLiteException
    //   200	213	496	android/database/sqlite/SQLiteException
    //   217	229	496	android/database/sqlite/SQLiteException
    //   238	250	496	android/database/sqlite/SQLiteException
    //   259	271	496	android/database/sqlite/SQLiteException
    //   280	292	496	android/database/sqlite/SQLiteException
    //   296	305	496	android/database/sqlite/SQLiteException
    //   309	320	496	android/database/sqlite/SQLiteException
    //   324	339	496	android/database/sqlite/SQLiteException
    //   343	358	496	android/database/sqlite/SQLiteException
    //   362	377	496	android/database/sqlite/SQLiteException
    //   381	396	496	android/database/sqlite/SQLiteException
    //   400	422	496	android/database/sqlite/SQLiteException
  }
  
  void zza(ContentValues paramContentValues, String paramString, Object paramObject)
  {
    zzab.zzhs(paramString);
    zzab.zzaa(paramObject);
    if ((paramObject instanceof String))
    {
      paramContentValues.put(paramString, (String)paramObject);
      return;
    }
    if ((paramObject instanceof Long))
    {
      paramContentValues.put(paramString, (Long)paramObject);
      return;
    }
    if ((paramObject instanceof Double))
    {
      paramContentValues.put(paramString, (Double)paramObject);
      return;
    }
    throw new IllegalArgumentException("Invalid value type");
  }
  
  public void zza(zzup.zze paramzze)
  {
    zzwu();
    zzzg();
    zzab.zzaa(paramzze);
    zzab.zzhs(zzck);
    zzab.zzaa(aoW);
    zzbtd();
    long l = zzyw().currentTimeMillis();
    if ((aoW.longValue() < l - zzbtb().zzbsb()) || (aoW.longValue() > zzbtb().zzbsb() + l)) {
      zzbsz().zzbtt().zze("Storing bundle outside of the max uploading time span. now, timestamp", Long.valueOf(l), aoW);
    }
    try
    {
      byte[] arrayOfByte = new byte[paramzze.ao()];
      Object localObject = zzaov.zzba(arrayOfByte);
      paramzze.zza((zzaov)localObject);
      ((zzaov)localObject).ab();
      arrayOfByte = zzbsv().zzj(arrayOfByte);
      zzbsz().zzbty().zzj("Saving bundle, size", Integer.valueOf(arrayOfByte.length));
      localObject = new ContentValues();
      ((ContentValues)localObject).put("app_id", zzck);
      ((ContentValues)localObject).put("bundle_end_timestamp", aoW);
      ((ContentValues)localObject).put("data", arrayOfByte);
      return;
    }
    catch (IOException paramzze)
    {
      try
      {
        if (getWritableDatabase().insert("queue", null, (ContentValues)localObject) == -1L) {
          zzbsz().zzbtr().log("Failed to insert bundle (got -1)");
        }
        return;
      }
      catch (SQLiteException paramzze)
      {
        zzbsz().zzbtr().zzj("Error storing bundle", paramzze);
      }
      paramzze = paramzze;
      zzbsz().zzbtr().zzj("Data loss. Failed to serialize bundle", paramzze);
      return;
    }
  }
  
  public void zza(zza paramzza)
  {
    zzab.zzaa(paramzza);
    zzwu();
    zzzg();
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("app_id", paramzza.zzsi());
    localContentValues.put("app_instance_id", paramzza.zzawj());
    localContentValues.put("gmp_app_id", paramzza.zzbqo());
    localContentValues.put("resettable_device_id_hash", paramzza.zzbqp());
    localContentValues.put("last_bundle_index", Long.valueOf(paramzza.zzbqy()));
    localContentValues.put("last_bundle_start_timestamp", Long.valueOf(paramzza.zzbqr()));
    localContentValues.put("last_bundle_end_timestamp", Long.valueOf(paramzza.zzbqs()));
    localContentValues.put("app_version", paramzza.zzxc());
    localContentValues.put("app_store", paramzza.zzbqu());
    localContentValues.put("gmp_version", Long.valueOf(paramzza.zzbqv()));
    localContentValues.put("dev_cert_hash", Long.valueOf(paramzza.zzbqw()));
    localContentValues.put("measurement_enabled", Boolean.valueOf(paramzza.zzbqx()));
    localContentValues.put("day", Long.valueOf(paramzza.zzbrc()));
    localContentValues.put("daily_public_events_count", Long.valueOf(paramzza.zzbrd()));
    localContentValues.put("daily_events_count", Long.valueOf(paramzza.zzbre()));
    localContentValues.put("daily_conversions_count", Long.valueOf(paramzza.zzbrf()));
    localContentValues.put("config_fetched_time", Long.valueOf(paramzza.zzbqz()));
    localContentValues.put("failed_config_fetch_time", Long.valueOf(paramzza.zzbra()));
    localContentValues.put("app_version_int", Long.valueOf(paramzza.zzbqt()));
    localContentValues.put("firebase_instance_id", paramzza.zzbqq());
    localContentValues.put("daily_error_events_count", Long.valueOf(paramzza.zzbrg()));
    try
    {
      if (getWritableDatabase().insertWithOnConflict("apps", null, localContentValues, 5) == -1L) {
        zzbsz().zzbtr().log("Failed to insert/update app (got -1)");
      }
      return;
    }
    catch (SQLiteException paramzza)
    {
      zzbsz().zzbtr().zzj("Error storing app", paramzza);
    }
  }
  
  /* Error */
  public void zza(zzh paramzzh, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 223	com/google/android/gms/measurement/internal/zze:zzwu	()V
    //   4: aload_0
    //   5: invokevirtual 220	com/google/android/gms/measurement/internal/zze:zzzg	()V
    //   8: aload_1
    //   9: invokestatic 233	com/google/android/gms/common/internal/zzab:zzaa	(Ljava/lang/Object;)Ljava/lang/Object;
    //   12: pop
    //   13: aload_1
    //   14: getfield 617	com/google/android/gms/measurement/internal/zzh:zzcjj	Ljava/lang/String;
    //   17: invokestatic 229	com/google/android/gms/common/internal/zzab:zzhs	(Ljava/lang/String;)Ljava/lang/String;
    //   20: pop
    //   21: new 619	com/google/android/gms/internal/zzup$zzb
    //   24: dup
    //   25: invokespecial 620	com/google/android/gms/internal/zzup$zzb:<init>	()V
    //   28: astore 5
    //   30: aload 5
    //   32: aload_1
    //   33: getfield 623	com/google/android/gms/measurement/internal/zzh:ajX	J
    //   36: invokestatic 440	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   39: putfield 626	com/google/android/gms/internal/zzup$zzb:aoM	Ljava/lang/Long;
    //   42: aload 5
    //   44: aload_1
    //   45: getfield 630	com/google/android/gms/measurement/internal/zzh:ajY	Lcom/google/android/gms/measurement/internal/EventParams;
    //   48: invokevirtual 635	com/google/android/gms/measurement/internal/EventParams:size	()I
    //   51: anewarray 637	com/google/android/gms/internal/zzup$zzc
    //   54: putfield 641	com/google/android/gms/internal/zzup$zzb:aoK	[Lcom/google/android/gms/internal/zzup$zzc;
    //   57: aload_1
    //   58: getfield 630	com/google/android/gms/measurement/internal/zzh:ajY	Lcom/google/android/gms/measurement/internal/EventParams;
    //   61: invokevirtual 645	com/google/android/gms/measurement/internal/EventParams:iterator	()Ljava/util/Iterator;
    //   64: astore 6
    //   66: iconst_0
    //   67: istore 4
    //   69: aload 6
    //   71: invokeinterface 650 1 0
    //   76: ifeq +72 -> 148
    //   79: aload 6
    //   81: invokeinterface 654 1 0
    //   86: checkcast 303	java/lang/String
    //   89: astore 8
    //   91: new 637	com/google/android/gms/internal/zzup$zzc
    //   94: dup
    //   95: invokespecial 655	com/google/android/gms/internal/zzup$zzc:<init>	()V
    //   98: astore 7
    //   100: aload 5
    //   102: getfield 641	com/google/android/gms/internal/zzup$zzb:aoK	[Lcom/google/android/gms/internal/zzup$zzc;
    //   105: iload 4
    //   107: aload 7
    //   109: aastore
    //   110: aload 7
    //   112: aload 8
    //   114: putfield 658	com/google/android/gms/internal/zzup$zzc:name	Ljava/lang/String;
    //   117: aload_1
    //   118: getfield 630	com/google/android/gms/measurement/internal/zzh:ajY	Lcom/google/android/gms/measurement/internal/EventParams;
    //   121: aload 8
    //   123: invokevirtual 662	com/google/android/gms/measurement/internal/EventParams:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   126: astore 8
    //   128: aload_0
    //   129: invokevirtual 499	com/google/android/gms/measurement/internal/zze:zzbsv	()Lcom/google/android/gms/measurement/internal/zzal;
    //   132: aload 7
    //   134: aload 8
    //   136: invokevirtual 665	com/google/android/gms/measurement/internal/zzal:zza	(Lcom/google/android/gms/internal/zzup$zzc;Ljava/lang/Object;)V
    //   139: iload 4
    //   141: iconst_1
    //   142: iadd
    //   143: istore 4
    //   145: goto -76 -> 69
    //   148: aload 5
    //   150: invokevirtual 666	com/google/android/gms/internal/zzup$zzb:ao	()I
    //   153: newarray <illegal type>
    //   155: astore 6
    //   157: aload 6
    //   159: invokestatic 315	com/google/android/gms/internal/zzaov:zzba	([B)Lcom/google/android/gms/internal/zzaov;
    //   162: astore 7
    //   164: aload 5
    //   166: aload 7
    //   168: invokevirtual 667	com/google/android/gms/internal/zzup$zzb:zza	(Lcom/google/android/gms/internal/zzaov;)V
    //   171: aload 7
    //   173: invokevirtual 321	com/google/android/gms/internal/zzaov:ab	()V
    //   176: aload_0
    //   177: invokevirtual 201	com/google/android/gms/measurement/internal/zze:zzbsz	()Lcom/google/android/gms/measurement/internal/zzp;
    //   180: invokevirtual 507	com/google/android/gms/measurement/internal/zzp:zzbty	()Lcom/google/android/gms/measurement/internal/zzp$zza;
    //   183: ldc_w 669
    //   186: aload_1
    //   187: getfield 672	com/google/android/gms/measurement/internal/zzh:mName	Ljava/lang/String;
    //   190: aload 6
    //   192: arraylength
    //   193: invokestatic 301	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   196: invokevirtual 215	com/google/android/gms/measurement/internal/zzp$zza:zze	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   199: new 323	android/content/ContentValues
    //   202: dup
    //   203: invokespecial 325	android/content/ContentValues:<init>	()V
    //   206: astore 5
    //   208: aload 5
    //   210: ldc_w 327
    //   213: aload_1
    //   214: getfield 617	com/google/android/gms/measurement/internal/zzh:zzcjj	Ljava/lang/String;
    //   217: invokevirtual 330	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   220: aload 5
    //   222: ldc_w 673
    //   225: aload_1
    //   226: getfield 672	com/google/android/gms/measurement/internal/zzh:mName	Ljava/lang/String;
    //   229: invokevirtual 330	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   232: aload 5
    //   234: ldc_w 675
    //   237: aload_1
    //   238: getfield 678	com/google/android/gms/measurement/internal/zzh:pz	J
    //   241: invokestatic 440	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   244: invokevirtual 443	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   247: aload 5
    //   249: ldc_w 680
    //   252: lload_2
    //   253: invokestatic 440	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   256: invokevirtual 443	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   259: aload 5
    //   261: ldc_w 341
    //   264: aload 6
    //   266: invokevirtual 344	android/content/ContentValues:put	(Ljava/lang/String;[B)V
    //   269: aload_0
    //   270: invokevirtual 180	com/google/android/gms/measurement/internal/zze:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   273: ldc_w 682
    //   276: aconst_null
    //   277: aload 5
    //   279: invokevirtual 517	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   282: ldc2_w 351
    //   285: lcmp
    //   286: ifne +16 -> 302
    //   289: aload_0
    //   290: invokevirtual 201	com/google/android/gms/measurement/internal/zze:zzbsz	()Lcom/google/android/gms/measurement/internal/zzp;
    //   293: invokevirtual 207	com/google/android/gms/measurement/internal/zzp:zzbtr	()Lcom/google/android/gms/measurement/internal/zzp$zza;
    //   296: ldc_w 684
    //   299: invokevirtual 256	com/google/android/gms/measurement/internal/zzp$zza:log	(Ljava/lang/String;)V
    //   302: return
    //   303: astore_1
    //   304: aload_0
    //   305: invokevirtual 201	com/google/android/gms/measurement/internal/zze:zzbsz	()Lcom/google/android/gms/measurement/internal/zzp;
    //   308: invokevirtual 207	com/google/android/gms/measurement/internal/zzp:zzbtr	()Lcom/google/android/gms/measurement/internal/zzp$zza;
    //   311: ldc_w 686
    //   314: aload_1
    //   315: invokevirtual 360	com/google/android/gms/measurement/internal/zzp$zza:zzj	(Ljava/lang/String;Ljava/lang/Object;)V
    //   318: return
    //   319: astore_1
    //   320: aload_0
    //   321: invokevirtual 201	com/google/android/gms/measurement/internal/zze:zzbsz	()Lcom/google/android/gms/measurement/internal/zzp;
    //   324: invokevirtual 207	com/google/android/gms/measurement/internal/zzp:zzbtr	()Lcom/google/android/gms/measurement/internal/zzp$zza;
    //   327: ldc_w 688
    //   330: aload_1
    //   331: invokevirtual 360	com/google/android/gms/measurement/internal/zzp$zza:zzj	(Ljava/lang/String;Ljava/lang/Object;)V
    //   334: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	335	0	this	zze
    //   0	335	1	paramzzh	zzh
    //   0	335	2	paramLong	long
    //   67	77	4	i	int
    //   28	250	5	localObject1	Object
    //   64	201	6	localObject2	Object
    //   98	74	7	localObject3	Object
    //   89	46	8	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   148	176	303	java/io/IOException
    //   269	302	319	android/database/sqlite/SQLiteException
  }
  
  public void zza(zzi paramzzi)
  {
    zzab.zzaa(paramzzi);
    zzwu();
    zzzg();
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("app_id", zzcjj);
    localContentValues.put("name", mName);
    localContentValues.put("lifetime_count", Long.valueOf(ajZ));
    localContentValues.put("current_bundle_count", Long.valueOf(aka));
    localContentValues.put("last_fire_timestamp", Long.valueOf(akb));
    try
    {
      if (getWritableDatabase().insertWithOnConflict("events", null, localContentValues, 5) == -1L) {
        zzbsz().zzbtr().log("Failed to insert/update event aggregates (got -1)");
      }
      return;
    }
    catch (SQLiteException paramzzi)
    {
      zzbsz().zzbtr().zzj("Error storing event aggregates", paramzzi);
    }
  }
  
  /* Error */
  void zza(String paramString, int paramInt, com.google.android.gms.internal.zzup.zzf paramzzf)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 220	com/google/android/gms/measurement/internal/zze:zzzg	()V
    //   4: aload_0
    //   5: invokevirtual 223	com/google/android/gms/measurement/internal/zze:zzwu	()V
    //   8: aload_1
    //   9: invokestatic 229	com/google/android/gms/common/internal/zzab:zzhs	(Ljava/lang/String;)Ljava/lang/String;
    //   12: pop
    //   13: aload_3
    //   14: invokestatic 233	com/google/android/gms/common/internal/zzab:zzaa	(Ljava/lang/Object;)Ljava/lang/Object;
    //   17: pop
    //   18: aload_3
    //   19: invokevirtual 718	com/google/android/gms/internal/zzup$zzf:ao	()I
    //   22: newarray <illegal type>
    //   24: astore 4
    //   26: aload 4
    //   28: invokestatic 315	com/google/android/gms/internal/zzaov:zzba	([B)Lcom/google/android/gms/internal/zzaov;
    //   31: astore 5
    //   33: aload_3
    //   34: aload 5
    //   36: invokevirtual 719	com/google/android/gms/internal/zzup$zzf:zza	(Lcom/google/android/gms/internal/zzaov;)V
    //   39: aload 5
    //   41: invokevirtual 321	com/google/android/gms/internal/zzaov:ab	()V
    //   44: new 323	android/content/ContentValues
    //   47: dup
    //   48: invokespecial 325	android/content/ContentValues:<init>	()V
    //   51: astore_3
    //   52: aload_3
    //   53: ldc_w 327
    //   56: aload_1
    //   57: invokevirtual 330	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   60: aload_3
    //   61: ldc_w 332
    //   64: iload_2
    //   65: invokestatic 301	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   68: invokevirtual 335	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   71: aload_3
    //   72: ldc_w 721
    //   75: aload 4
    //   77: invokevirtual 344	android/content/ContentValues:put	(Ljava/lang/String;[B)V
    //   80: aload_0
    //   81: invokevirtual 180	com/google/android/gms/measurement/internal/zze:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   84: ldc_w 723
    //   87: aconst_null
    //   88: aload_3
    //   89: iconst_5
    //   90: invokevirtual 350	android/database/sqlite/SQLiteDatabase:insertWithOnConflict	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;I)J
    //   93: ldc2_w 351
    //   96: lcmp
    //   97: ifne +16 -> 113
    //   100: aload_0
    //   101: invokevirtual 201	com/google/android/gms/measurement/internal/zze:zzbsz	()Lcom/google/android/gms/measurement/internal/zzp;
    //   104: invokevirtual 207	com/google/android/gms/measurement/internal/zzp:zzbtr	()Lcom/google/android/gms/measurement/internal/zzp$zza;
    //   107: ldc_w 725
    //   110: invokevirtual 256	com/google/android/gms/measurement/internal/zzp$zza:log	(Ljava/lang/String;)V
    //   113: return
    //   114: astore_1
    //   115: aload_0
    //   116: invokevirtual 201	com/google/android/gms/measurement/internal/zze:zzbsz	()Lcom/google/android/gms/measurement/internal/zzp;
    //   119: invokevirtual 207	com/google/android/gms/measurement/internal/zzp:zzbtr	()Lcom/google/android/gms/measurement/internal/zzp$zza;
    //   122: ldc_w 727
    //   125: aload_1
    //   126: invokevirtual 360	com/google/android/gms/measurement/internal/zzp$zza:zzj	(Ljava/lang/String;Ljava/lang/Object;)V
    //   129: return
    //   130: astore_1
    //   131: aload_0
    //   132: invokevirtual 201	com/google/android/gms/measurement/internal/zze:zzbsz	()Lcom/google/android/gms/measurement/internal/zzp;
    //   135: invokevirtual 207	com/google/android/gms/measurement/internal/zzp:zzbtr	()Lcom/google/android/gms/measurement/internal/zzp$zza;
    //   138: ldc_w 729
    //   141: aload_1
    //   142: invokevirtual 360	com/google/android/gms/measurement/internal/zzp$zza:zzj	(Ljava/lang/String;Ljava/lang/Object;)V
    //   145: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	146	0	this	zze
    //   0	146	1	paramString	String
    //   0	146	2	paramInt	int
    //   0	146	3	paramzzf	com.google.android.gms.internal.zzup.zzf
    //   24	52	4	arrayOfByte	byte[]
    //   31	9	5	localzzaov	zzaov
    // Exception table:
    //   from	to	target	type
    //   18	44	114	java/io/IOException
    //   80	113	130	android/database/sqlite/SQLiteException
  }
  
  /* Error */
  public void zza(String paramString, long paramLong, zzb paramzzb)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aload 4
    //   5: invokestatic 233	com/google/android/gms/common/internal/zzab:zzaa	(Ljava/lang/Object;)Ljava/lang/Object;
    //   8: pop
    //   9: aload_0
    //   10: invokevirtual 223	com/google/android/gms/measurement/internal/zze:zzwu	()V
    //   13: aload_0
    //   14: invokevirtual 220	com/google/android/gms/measurement/internal/zze:zzzg	()V
    //   17: aload 7
    //   19: astore 6
    //   21: aload_0
    //   22: invokevirtual 180	com/google/android/gms/measurement/internal/zze:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   25: astore 10
    //   27: aload 7
    //   29: astore 6
    //   31: aload_1
    //   32: invokestatic 295	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   35: ifeq +204 -> 239
    //   38: aload 7
    //   40: astore 6
    //   42: aload 10
    //   44: ldc_w 732
    //   47: iconst_1
    //   48: anewarray 303	java/lang/String
    //   51: dup
    //   52: iconst_0
    //   53: lload_2
    //   54: invokestatic 735	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   57: aastore
    //   58: invokevirtual 186	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   61: astore_1
    //   62: aload_1
    //   63: astore 6
    //   65: aload_1
    //   66: astore 7
    //   68: aload_1
    //   69: invokeinterface 190 1 0
    //   74: istore 5
    //   76: iload 5
    //   78: ifne +14 -> 92
    //   81: aload_1
    //   82: ifnull +9 -> 91
    //   85: aload_1
    //   86: invokeinterface 197 1 0
    //   91: return
    //   92: aload_1
    //   93: astore 6
    //   95: aload_1
    //   96: astore 7
    //   98: aload_1
    //   99: iconst_0
    //   100: invokeinterface 739 2 0
    //   105: astore 8
    //   107: aload_1
    //   108: astore 6
    //   110: aload_1
    //   111: astore 7
    //   113: aload_1
    //   114: iconst_1
    //   115: invokeinterface 739 2 0
    //   120: astore 9
    //   122: aload_1
    //   123: astore 6
    //   125: aload_1
    //   126: astore 7
    //   128: aload_1
    //   129: invokeinterface 197 1 0
    //   134: aload 9
    //   136: astore 7
    //   138: aload_1
    //   139: astore 6
    //   141: aload 6
    //   143: astore_1
    //   144: aload 10
    //   146: ldc_w 741
    //   149: iconst_1
    //   150: anewarray 303	java/lang/String
    //   153: dup
    //   154: iconst_0
    //   155: ldc_w 743
    //   158: aastore
    //   159: ldc_w 745
    //   162: iconst_2
    //   163: anewarray 303	java/lang/String
    //   166: dup
    //   167: iconst_0
    //   168: aload 8
    //   170: aastore
    //   171: dup
    //   172: iconst_1
    //   173: aload 7
    //   175: aastore
    //   176: aconst_null
    //   177: aconst_null
    //   178: ldc_w 747
    //   181: ldc_w 749
    //   184: invokevirtual 752	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   187: astore 9
    //   189: aload 9
    //   191: astore_1
    //   192: aload 9
    //   194: astore 6
    //   196: aload 9
    //   198: invokeinterface 190 1 0
    //   203: ifne +140 -> 343
    //   206: aload 9
    //   208: astore_1
    //   209: aload 9
    //   211: astore 6
    //   213: aload_0
    //   214: invokevirtual 201	com/google/android/gms/measurement/internal/zze:zzbsz	()Lcom/google/android/gms/measurement/internal/zzp;
    //   217: invokevirtual 207	com/google/android/gms/measurement/internal/zzp:zzbtr	()Lcom/google/android/gms/measurement/internal/zzp$zza;
    //   220: ldc_w 754
    //   223: invokevirtual 256	com/google/android/gms/measurement/internal/zzp$zza:log	(Ljava/lang/String;)V
    //   226: aload 9
    //   228: ifnull -137 -> 91
    //   231: aload 9
    //   233: invokeinterface 197 1 0
    //   238: return
    //   239: aload 7
    //   241: astore 6
    //   243: aload 10
    //   245: ldc_w 756
    //   248: iconst_1
    //   249: anewarray 303	java/lang/String
    //   252: dup
    //   253: iconst_0
    //   254: aload_1
    //   255: aastore
    //   256: invokevirtual 186	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   259: astore 8
    //   261: aload 8
    //   263: astore 6
    //   265: aload 8
    //   267: astore 7
    //   269: aload 8
    //   271: invokeinterface 190 1 0
    //   276: istore 5
    //   278: iload 5
    //   280: ifne +16 -> 296
    //   283: aload 8
    //   285: ifnull -194 -> 91
    //   288: aload 8
    //   290: invokeinterface 197 1 0
    //   295: return
    //   296: aload 8
    //   298: astore 6
    //   300: aload 8
    //   302: astore 7
    //   304: aload 8
    //   306: iconst_0
    //   307: invokeinterface 739 2 0
    //   312: astore 9
    //   314: aload 8
    //   316: astore 6
    //   318: aload 8
    //   320: astore 7
    //   322: aload 8
    //   324: invokeinterface 197 1 0
    //   329: aload 9
    //   331: astore 7
    //   333: aload 8
    //   335: astore 6
    //   337: aload_1
    //   338: astore 8
    //   340: goto -199 -> 141
    //   343: aload 9
    //   345: astore_1
    //   346: aload 9
    //   348: astore 6
    //   350: aload 9
    //   352: iconst_0
    //   353: invokeinterface 760 2 0
    //   358: invokestatic 766	com/google/android/gms/internal/zzaou:zzaz	([B)Lcom/google/android/gms/internal/zzaou;
    //   361: astore 12
    //   363: aload 9
    //   365: astore_1
    //   366: aload 9
    //   368: astore 6
    //   370: new 463	com/google/android/gms/internal/zzup$zze
    //   373: dup
    //   374: invokespecial 767	com/google/android/gms/internal/zzup$zze:<init>	()V
    //   377: astore 11
    //   379: aload 9
    //   381: astore_1
    //   382: aload 9
    //   384: astore 6
    //   386: aload 11
    //   388: aload 12
    //   390: invokevirtual 770	com/google/android/gms/internal/zzup$zze:zzb	(Lcom/google/android/gms/internal/zzaou;)Lcom/google/android/gms/internal/zzapc;
    //   393: checkcast 463	com/google/android/gms/internal/zzup$zze
    //   396: astore 12
    //   398: aload 9
    //   400: astore_1
    //   401: aload 9
    //   403: astore 6
    //   405: aload 9
    //   407: invokeinterface 773 1 0
    //   412: ifeq +23 -> 435
    //   415: aload 9
    //   417: astore_1
    //   418: aload 9
    //   420: astore 6
    //   422: aload_0
    //   423: invokevirtual 201	com/google/android/gms/measurement/internal/zze:zzbsz	()Lcom/google/android/gms/measurement/internal/zzp;
    //   426: invokevirtual 250	com/google/android/gms/measurement/internal/zzp:zzbtt	()Lcom/google/android/gms/measurement/internal/zzp$zza;
    //   429: ldc_w 775
    //   432: invokevirtual 256	com/google/android/gms/measurement/internal/zzp$zza:log	(Ljava/lang/String;)V
    //   435: aload 9
    //   437: astore_1
    //   438: aload 9
    //   440: astore 6
    //   442: aload 9
    //   444: invokeinterface 197 1 0
    //   449: aload 9
    //   451: astore_1
    //   452: aload 9
    //   454: astore 6
    //   456: aload 4
    //   458: aload 11
    //   460: invokeinterface 777 2 0
    //   465: aload 9
    //   467: astore_1
    //   468: aload 9
    //   470: astore 6
    //   472: aload 10
    //   474: ldc_w 682
    //   477: iconst_4
    //   478: anewarray 303	java/lang/String
    //   481: dup
    //   482: iconst_0
    //   483: ldc_w 747
    //   486: aastore
    //   487: dup
    //   488: iconst_1
    //   489: ldc_w 673
    //   492: aastore
    //   493: dup
    //   494: iconst_2
    //   495: ldc_w 675
    //   498: aastore
    //   499: dup
    //   500: iconst_3
    //   501: ldc_w 341
    //   504: aastore
    //   505: ldc_w 745
    //   508: iconst_2
    //   509: anewarray 303	java/lang/String
    //   512: dup
    //   513: iconst_0
    //   514: aload 8
    //   516: aastore
    //   517: dup
    //   518: iconst_1
    //   519: aload 7
    //   521: aastore
    //   522: aconst_null
    //   523: aconst_null
    //   524: ldc_w 747
    //   527: aconst_null
    //   528: invokevirtual 752	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   531: astore 7
    //   533: aload 7
    //   535: astore_1
    //   536: aload_1
    //   537: astore 6
    //   539: aload_1
    //   540: astore 7
    //   542: aload_1
    //   543: invokeinterface 190 1 0
    //   548: ifne +72 -> 620
    //   551: aload_1
    //   552: astore 6
    //   554: aload_1
    //   555: astore 7
    //   557: aload_0
    //   558: invokevirtual 201	com/google/android/gms/measurement/internal/zze:zzbsz	()Lcom/google/android/gms/measurement/internal/zzp;
    //   561: invokevirtual 250	com/google/android/gms/measurement/internal/zzp:zzbtt	()Lcom/google/android/gms/measurement/internal/zzp$zza;
    //   564: ldc_w 779
    //   567: invokevirtual 256	com/google/android/gms/measurement/internal/zzp$zza:log	(Ljava/lang/String;)V
    //   570: aload_1
    //   571: ifnull -480 -> 91
    //   574: aload_1
    //   575: invokeinterface 197 1 0
    //   580: return
    //   581: astore 4
    //   583: aload 9
    //   585: astore_1
    //   586: aload 9
    //   588: astore 6
    //   590: aload_0
    //   591: invokevirtual 201	com/google/android/gms/measurement/internal/zze:zzbsz	()Lcom/google/android/gms/measurement/internal/zzp;
    //   594: invokevirtual 207	com/google/android/gms/measurement/internal/zzp:zzbtr	()Lcom/google/android/gms/measurement/internal/zzp$zza;
    //   597: ldc_w 781
    //   600: aload 8
    //   602: aload 4
    //   604: invokevirtual 215	com/google/android/gms/measurement/internal/zzp$zza:zze	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   607: aload 9
    //   609: ifnull -518 -> 91
    //   612: aload 9
    //   614: invokeinterface 197 1 0
    //   619: return
    //   620: aload_1
    //   621: astore 6
    //   623: aload_1
    //   624: astore 7
    //   626: aload_1
    //   627: iconst_0
    //   628: invokeinterface 194 2 0
    //   633: lstore_2
    //   634: aload_1
    //   635: astore 6
    //   637: aload_1
    //   638: astore 7
    //   640: aload_1
    //   641: iconst_3
    //   642: invokeinterface 760 2 0
    //   647: invokestatic 766	com/google/android/gms/internal/zzaou:zzaz	([B)Lcom/google/android/gms/internal/zzaou;
    //   650: astore 10
    //   652: aload_1
    //   653: astore 6
    //   655: aload_1
    //   656: astore 7
    //   658: new 619	com/google/android/gms/internal/zzup$zzb
    //   661: dup
    //   662: invokespecial 620	com/google/android/gms/internal/zzup$zzb:<init>	()V
    //   665: astore 9
    //   667: aload_1
    //   668: astore 6
    //   670: aload_1
    //   671: astore 7
    //   673: aload 9
    //   675: aload 10
    //   677: invokevirtual 782	com/google/android/gms/internal/zzup$zzb:zzb	(Lcom/google/android/gms/internal/zzaou;)Lcom/google/android/gms/internal/zzapc;
    //   680: checkcast 619	com/google/android/gms/internal/zzup$zzb
    //   683: astore 10
    //   685: aload_1
    //   686: astore 6
    //   688: aload_1
    //   689: astore 7
    //   691: aload 9
    //   693: aload_1
    //   694: iconst_1
    //   695: invokeinterface 739 2 0
    //   700: putfield 783	com/google/android/gms/internal/zzup$zzb:name	Ljava/lang/String;
    //   703: aload_1
    //   704: astore 6
    //   706: aload_1
    //   707: astore 7
    //   709: aload 9
    //   711: aload_1
    //   712: iconst_2
    //   713: invokeinterface 194 2 0
    //   718: invokestatic 440	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   721: putfield 786	com/google/android/gms/internal/zzup$zzb:aoL	Ljava/lang/Long;
    //   724: aload_1
    //   725: astore 6
    //   727: aload_1
    //   728: astore 7
    //   730: aload 4
    //   732: lload_2
    //   733: aload 9
    //   735: invokeinterface 789 4 0
    //   740: istore 5
    //   742: iload 5
    //   744: ifne +39 -> 783
    //   747: aload_1
    //   748: ifnull -657 -> 91
    //   751: aload_1
    //   752: invokeinterface 197 1 0
    //   757: return
    //   758: astore 9
    //   760: aload_1
    //   761: astore 6
    //   763: aload_1
    //   764: astore 7
    //   766: aload_0
    //   767: invokevirtual 201	com/google/android/gms/measurement/internal/zze:zzbsz	()Lcom/google/android/gms/measurement/internal/zzp;
    //   770: invokevirtual 207	com/google/android/gms/measurement/internal/zzp:zzbtr	()Lcom/google/android/gms/measurement/internal/zzp$zza;
    //   773: ldc_w 791
    //   776: aload 8
    //   778: aload 9
    //   780: invokevirtual 215	com/google/android/gms/measurement/internal/zzp$zza:zze	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   783: aload_1
    //   784: astore 6
    //   786: aload_1
    //   787: astore 7
    //   789: aload_1
    //   790: invokeinterface 773 1 0
    //   795: istore 5
    //   797: iload 5
    //   799: ifne -179 -> 620
    //   802: aload_1
    //   803: ifnull -712 -> 91
    //   806: aload_1
    //   807: invokeinterface 197 1 0
    //   812: return
    //   813: astore_1
    //   814: aload 6
    //   816: astore 7
    //   818: aload_0
    //   819: invokevirtual 201	com/google/android/gms/measurement/internal/zze:zzbsz	()Lcom/google/android/gms/measurement/internal/zzp;
    //   822: invokevirtual 207	com/google/android/gms/measurement/internal/zzp:zzbtr	()Lcom/google/android/gms/measurement/internal/zzp$zza;
    //   825: ldc_w 793
    //   828: aload_1
    //   829: invokevirtual 360	com/google/android/gms/measurement/internal/zzp$zza:zzj	(Ljava/lang/String;Ljava/lang/Object;)V
    //   832: aload 6
    //   834: ifnull -743 -> 91
    //   837: aload 6
    //   839: invokeinterface 197 1 0
    //   844: return
    //   845: astore 4
    //   847: aconst_null
    //   848: astore_1
    //   849: aload_1
    //   850: ifnull +9 -> 859
    //   853: aload_1
    //   854: invokeinterface 197 1 0
    //   859: aload 4
    //   861: athrow
    //   862: astore 4
    //   864: aload 7
    //   866: astore_1
    //   867: goto -18 -> 849
    //   870: astore 4
    //   872: goto -23 -> 849
    //   875: astore_1
    //   876: goto -62 -> 814
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	879	0	this	zze
    //   0	879	1	paramString	String
    //   0	879	2	paramLong	long
    //   0	879	4	paramzzb	zzb
    //   74	724	5	bool	boolean
    //   19	819	6	localObject1	Object
    //   1	864	7	localObject2	Object
    //   105	672	8	localObject3	Object
    //   120	614	9	localObject4	Object
    //   758	21	9	localIOException	IOException
    //   25	659	10	localObject5	Object
    //   377	82	11	localzze	zzup.zze
    //   361	36	12	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   386	398	581	java/io/IOException
    //   673	685	758	java/io/IOException
    //   21	27	813	android/database/sqlite/SQLiteException
    //   31	38	813	android/database/sqlite/SQLiteException
    //   42	62	813	android/database/sqlite/SQLiteException
    //   68	76	813	android/database/sqlite/SQLiteException
    //   98	107	813	android/database/sqlite/SQLiteException
    //   113	122	813	android/database/sqlite/SQLiteException
    //   128	134	813	android/database/sqlite/SQLiteException
    //   243	261	813	android/database/sqlite/SQLiteException
    //   269	278	813	android/database/sqlite/SQLiteException
    //   304	314	813	android/database/sqlite/SQLiteException
    //   322	329	813	android/database/sqlite/SQLiteException
    //   542	551	813	android/database/sqlite/SQLiteException
    //   557	570	813	android/database/sqlite/SQLiteException
    //   626	634	813	android/database/sqlite/SQLiteException
    //   640	652	813	android/database/sqlite/SQLiteException
    //   658	667	813	android/database/sqlite/SQLiteException
    //   673	685	813	android/database/sqlite/SQLiteException
    //   691	703	813	android/database/sqlite/SQLiteException
    //   709	724	813	android/database/sqlite/SQLiteException
    //   730	742	813	android/database/sqlite/SQLiteException
    //   766	783	813	android/database/sqlite/SQLiteException
    //   789	797	813	android/database/sqlite/SQLiteException
    //   21	27	845	finally
    //   31	38	845	finally
    //   42	62	845	finally
    //   243	261	845	finally
    //   68	76	862	finally
    //   98	107	862	finally
    //   113	122	862	finally
    //   128	134	862	finally
    //   269	278	862	finally
    //   304	314	862	finally
    //   322	329	862	finally
    //   542	551	862	finally
    //   557	570	862	finally
    //   626	634	862	finally
    //   640	652	862	finally
    //   658	667	862	finally
    //   673	685	862	finally
    //   691	703	862	finally
    //   709	724	862	finally
    //   730	742	862	finally
    //   766	783	862	finally
    //   789	797	862	finally
    //   818	832	862	finally
    //   144	189	870	finally
    //   196	206	870	finally
    //   213	226	870	finally
    //   350	363	870	finally
    //   370	379	870	finally
    //   386	398	870	finally
    //   405	415	870	finally
    //   422	435	870	finally
    //   442	449	870	finally
    //   456	465	870	finally
    //   472	533	870	finally
    //   590	607	870	finally
    //   144	189	875	android/database/sqlite/SQLiteException
    //   196	206	875	android/database/sqlite/SQLiteException
    //   213	226	875	android/database/sqlite/SQLiteException
    //   350	363	875	android/database/sqlite/SQLiteException
    //   370	379	875	android/database/sqlite/SQLiteException
    //   386	398	875	android/database/sqlite/SQLiteException
    //   405	415	875	android/database/sqlite/SQLiteException
    //   422	435	875	android/database/sqlite/SQLiteException
    //   442	449	875	android/database/sqlite/SQLiteException
    //   456	465	875	android/database/sqlite/SQLiteException
    //   472	533	875	android/database/sqlite/SQLiteException
    //   590	607	875	android/database/sqlite/SQLiteException
  }
  
  public boolean zza(zzak paramzzak)
  {
    zzab.zzaa(paramzzak);
    zzwu();
    zzzg();
    if (zzas(zzcjj, mName) == null) {
      if (zzal.zzmk(mName))
      {
        if (zzb("select count(1) from user_attributes where app_id=? and name not like '!_%' escape '!'", new String[] { zzcjj }) < zzbtb().zzbru()) {}
      }
      else {
        while (zzb("select count(1) from user_attributes where app_id=?", new String[] { zzcjj }) >= zzbtb().zzbrv()) {
          return false;
        }
      }
    }
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("app_id", zzcjj);
    localContentValues.put("name", mName);
    localContentValues.put("set_timestamp", Long.valueOf(anU));
    zza(localContentValues, "value", zzcnr);
    try
    {
      if (getWritableDatabase().insertWithOnConflict("user_attributes", null, localContentValues, 5) == -1L) {
        zzbsz().zzbtr().log("Failed to insert/update user property (got -1)");
      }
      return true;
    }
    catch (SQLiteException paramzzak)
    {
      for (;;)
      {
        zzbsz().zzbtr().zzj("Error storing user property", paramzzak);
      }
    }
  }
  
  String zzaab()
  {
    if (!zzbtb().zzabc()) {
      return zzbtb().zzacc();
    }
    if (zzbtb().zzabd()) {
      return zzbtb().zzacc();
    }
    zzbsz().zzbtu().log("Using secondary database");
    return zzbtb().zzacd();
  }
  
  public void zzac(List<Long> paramList)
  {
    zzab.zzaa(paramList);
    zzwu();
    zzzg();
    StringBuilder localStringBuilder = new StringBuilder("rowid in (");
    int i = 0;
    while (i < paramList.size())
    {
      if (i != 0) {
        localStringBuilder.append(",");
      }
      localStringBuilder.append(((Long)paramList.get(i)).longValue());
      i += 1;
    }
    localStringBuilder.append(")");
    i = getWritableDatabase().delete("raw_events", localStringBuilder.toString(), null);
    if (i != paramList.size()) {
      zzbsz().zzbtr().zze("Deleted fewer rows from raw events table than expected", Integer.valueOf(i), Integer.valueOf(paramList.size()));
    }
  }
  
  /* Error */
  public zzi zzaq(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aload_1
    //   4: invokestatic 229	com/google/android/gms/common/internal/zzab:zzhs	(Ljava/lang/String;)Ljava/lang/String;
    //   7: pop
    //   8: aload_2
    //   9: invokestatic 229	com/google/android/gms/common/internal/zzab:zzhs	(Ljava/lang/String;)Ljava/lang/String;
    //   12: pop
    //   13: aload_0
    //   14: invokevirtual 223	com/google/android/gms/measurement/internal/zze:zzwu	()V
    //   17: aload_0
    //   18: invokevirtual 220	com/google/android/gms/measurement/internal/zze:zzzg	()V
    //   21: aload_0
    //   22: invokevirtual 180	com/google/android/gms/measurement/internal/zze:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   25: ldc_w 710
    //   28: iconst_3
    //   29: anewarray 303	java/lang/String
    //   32: dup
    //   33: iconst_0
    //   34: ldc_w 695
    //   37: aastore
    //   38: dup
    //   39: iconst_1
    //   40: ldc_w 700
    //   43: aastore
    //   44: dup
    //   45: iconst_2
    //   46: ldc_w 705
    //   49: aastore
    //   50: ldc_w 892
    //   53: iconst_2
    //   54: anewarray 303	java/lang/String
    //   57: dup
    //   58: iconst_0
    //   59: aload_1
    //   60: aastore
    //   61: dup
    //   62: iconst_1
    //   63: aload_2
    //   64: aastore
    //   65: aconst_null
    //   66: aconst_null
    //   67: aconst_null
    //   68: invokevirtual 420	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   71: astore 4
    //   73: aload 4
    //   75: invokeinterface 190 1 0
    //   80: istore_3
    //   81: iload_3
    //   82: ifne +19 -> 101
    //   85: aload 4
    //   87: ifnull +10 -> 97
    //   90: aload 4
    //   92: invokeinterface 197 1 0
    //   97: aconst_null
    //   98: astore_1
    //   99: aload_1
    //   100: areturn
    //   101: new 691	com/google/android/gms/measurement/internal/zzi
    //   104: dup
    //   105: aload_1
    //   106: aload_2
    //   107: aload 4
    //   109: iconst_0
    //   110: invokeinterface 194 2 0
    //   115: aload 4
    //   117: iconst_1
    //   118: invokeinterface 194 2 0
    //   123: aload 4
    //   125: iconst_2
    //   126: invokeinterface 194 2 0
    //   131: invokespecial 895	com/google/android/gms/measurement/internal/zzi:<init>	(Ljava/lang/String;Ljava/lang/String;JJJ)V
    //   134: astore 5
    //   136: aload 4
    //   138: invokeinterface 773 1 0
    //   143: ifeq +16 -> 159
    //   146: aload_0
    //   147: invokevirtual 201	com/google/android/gms/measurement/internal/zze:zzbsz	()Lcom/google/android/gms/measurement/internal/zzp;
    //   150: invokevirtual 207	com/google/android/gms/measurement/internal/zzp:zzbtr	()Lcom/google/android/gms/measurement/internal/zzp$zza;
    //   153: ldc_w 897
    //   156: invokevirtual 256	com/google/android/gms/measurement/internal/zzp$zza:log	(Ljava/lang/String;)V
    //   159: aload 5
    //   161: astore_1
    //   162: aload 4
    //   164: ifnull -65 -> 99
    //   167: aload 4
    //   169: invokeinterface 197 1 0
    //   174: aload 5
    //   176: areturn
    //   177: astore 5
    //   179: aconst_null
    //   180: astore 4
    //   182: aload_0
    //   183: invokevirtual 201	com/google/android/gms/measurement/internal/zze:zzbsz	()Lcom/google/android/gms/measurement/internal/zzp;
    //   186: invokevirtual 207	com/google/android/gms/measurement/internal/zzp:zzbtr	()Lcom/google/android/gms/measurement/internal/zzp$zza;
    //   189: ldc_w 899
    //   192: aload_1
    //   193: aload_2
    //   194: aload 5
    //   196: invokevirtual 903	com/google/android/gms/measurement/internal/zzp$zza:zzd	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   199: aload 4
    //   201: ifnull +10 -> 211
    //   204: aload 4
    //   206: invokeinterface 197 1 0
    //   211: aconst_null
    //   212: areturn
    //   213: astore_1
    //   214: aload 5
    //   216: astore_2
    //   217: aload_2
    //   218: ifnull +9 -> 227
    //   221: aload_2
    //   222: invokeinterface 197 1 0
    //   227: aload_1
    //   228: athrow
    //   229: astore_1
    //   230: aload 4
    //   232: astore_2
    //   233: goto -16 -> 217
    //   236: astore_1
    //   237: aload 4
    //   239: astore_2
    //   240: goto -23 -> 217
    //   243: astore 5
    //   245: goto -63 -> 182
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	248	0	this	zze
    //   0	248	1	paramString1	String
    //   0	248	2	paramString2	String
    //   80	2	3	bool	boolean
    //   71	167	4	localCursor	Cursor
    //   1	174	5	localzzi	zzi
    //   177	38	5	localSQLiteException1	SQLiteException
    //   243	1	5	localSQLiteException2	SQLiteException
    // Exception table:
    //   from	to	target	type
    //   21	73	177	android/database/sqlite/SQLiteException
    //   21	73	213	finally
    //   73	81	229	finally
    //   101	159	229	finally
    //   182	199	236	finally
    //   73	81	243	android/database/sqlite/SQLiteException
    //   101	159	243	android/database/sqlite/SQLiteException
  }
  
  public void zzar(String paramString1, String paramString2)
  {
    zzab.zzhs(paramString1);
    zzab.zzhs(paramString2);
    zzwu();
    zzzg();
    try
    {
      int i = getWritableDatabase().delete("user_attributes", "app_id=? and name=?", new String[] { paramString1, paramString2 });
      zzbsz().zzbty().zzj("Deleted user attribute rows:", Integer.valueOf(i));
      return;
    }
    catch (SQLiteException localSQLiteException)
    {
      zzbsz().zzbtr().zzd("Error deleting user attribute", paramString1, paramString2, localSQLiteException);
    }
  }
  
  /* Error */
  public zzak zzas(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aload_1
    //   4: invokestatic 229	com/google/android/gms/common/internal/zzab:zzhs	(Ljava/lang/String;)Ljava/lang/String;
    //   7: pop
    //   8: aload_2
    //   9: invokestatic 229	com/google/android/gms/common/internal/zzab:zzhs	(Ljava/lang/String;)Ljava/lang/String;
    //   12: pop
    //   13: aload_0
    //   14: invokevirtual 223	com/google/android/gms/measurement/internal/zze:zzwu	()V
    //   17: aload_0
    //   18: invokevirtual 220	com/google/android/gms/measurement/internal/zze:zzzg	()V
    //   21: aload_0
    //   22: invokevirtual 180	com/google/android/gms/measurement/internal/zze:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   25: ldc_w 832
    //   28: iconst_2
    //   29: anewarray 303	java/lang/String
    //   32: dup
    //   33: iconst_0
    //   34: ldc_w 820
    //   37: aastore
    //   38: dup
    //   39: iconst_1
    //   40: ldc_w 824
    //   43: aastore
    //   44: ldc_w 892
    //   47: iconst_2
    //   48: anewarray 303	java/lang/String
    //   51: dup
    //   52: iconst_0
    //   53: aload_1
    //   54: aastore
    //   55: dup
    //   56: iconst_1
    //   57: aload_2
    //   58: aastore
    //   59: aconst_null
    //   60: aconst_null
    //   61: aconst_null
    //   62: invokevirtual 420	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   65: astore 4
    //   67: aload 4
    //   69: invokeinterface 190 1 0
    //   74: istore_3
    //   75: iload_3
    //   76: ifne +19 -> 95
    //   79: aload 4
    //   81: ifnull +10 -> 91
    //   84: aload 4
    //   86: invokeinterface 197 1 0
    //   91: aconst_null
    //   92: astore_1
    //   93: aload_1
    //   94: areturn
    //   95: new 796	com/google/android/gms/measurement/internal/zzak
    //   98: dup
    //   99: aload_1
    //   100: aload_2
    //   101: aload 4
    //   103: iconst_0
    //   104: invokeinterface 194 2 0
    //   109: aload_0
    //   110: aload 4
    //   112: iconst_1
    //   113: invokevirtual 911	com/google/android/gms/measurement/internal/zze:zzb	(Landroid/database/Cursor;I)Ljava/lang/Object;
    //   116: invokespecial 914	com/google/android/gms/measurement/internal/zzak:<init>	(Ljava/lang/String;Ljava/lang/String;JLjava/lang/Object;)V
    //   119: astore 5
    //   121: aload 4
    //   123: invokeinterface 773 1 0
    //   128: ifeq +16 -> 144
    //   131: aload_0
    //   132: invokevirtual 201	com/google/android/gms/measurement/internal/zze:zzbsz	()Lcom/google/android/gms/measurement/internal/zzp;
    //   135: invokevirtual 207	com/google/android/gms/measurement/internal/zzp:zzbtr	()Lcom/google/android/gms/measurement/internal/zzp$zza;
    //   138: ldc_w 916
    //   141: invokevirtual 256	com/google/android/gms/measurement/internal/zzp$zza:log	(Ljava/lang/String;)V
    //   144: aload 5
    //   146: astore_1
    //   147: aload 4
    //   149: ifnull -56 -> 93
    //   152: aload 4
    //   154: invokeinterface 197 1 0
    //   159: aload 5
    //   161: areturn
    //   162: astore 5
    //   164: aconst_null
    //   165: astore 4
    //   167: aload_0
    //   168: invokevirtual 201	com/google/android/gms/measurement/internal/zze:zzbsz	()Lcom/google/android/gms/measurement/internal/zzp;
    //   171: invokevirtual 207	com/google/android/gms/measurement/internal/zzp:zzbtr	()Lcom/google/android/gms/measurement/internal/zzp$zza;
    //   174: ldc_w 918
    //   177: aload_1
    //   178: aload_2
    //   179: aload 5
    //   181: invokevirtual 903	com/google/android/gms/measurement/internal/zzp$zza:zzd	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   184: aload 4
    //   186: ifnull +10 -> 196
    //   189: aload 4
    //   191: invokeinterface 197 1 0
    //   196: aconst_null
    //   197: areturn
    //   198: astore_1
    //   199: aload 5
    //   201: astore_2
    //   202: aload_2
    //   203: ifnull +9 -> 212
    //   206: aload_2
    //   207: invokeinterface 197 1 0
    //   212: aload_1
    //   213: athrow
    //   214: astore_1
    //   215: aload 4
    //   217: astore_2
    //   218: goto -16 -> 202
    //   221: astore_1
    //   222: aload 4
    //   224: astore_2
    //   225: goto -23 -> 202
    //   228: astore 5
    //   230: goto -63 -> 167
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	233	0	this	zze
    //   0	233	1	paramString1	String
    //   0	233	2	paramString2	String
    //   74	2	3	bool	boolean
    //   65	158	4	localCursor	Cursor
    //   1	159	5	localzzak	zzak
    //   162	38	5	localSQLiteException1	SQLiteException
    //   228	1	5	localSQLiteException2	SQLiteException
    // Exception table:
    //   from	to	target	type
    //   21	67	162	android/database/sqlite/SQLiteException
    //   21	67	198	finally
    //   67	75	214	finally
    //   95	144	214	finally
    //   167	184	221	finally
    //   67	75	228	android/database/sqlite/SQLiteException
    //   95	144	228	android/database/sqlite/SQLiteException
  }
  
  /* Error */
  Map<Integer, List<zzun.zzb>> zzat(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 220	com/google/android/gms/measurement/internal/zze:zzzg	()V
    //   4: aload_0
    //   5: invokevirtual 223	com/google/android/gms/measurement/internal/zze:zzwu	()V
    //   8: aload_1
    //   9: invokestatic 229	com/google/android/gms/common/internal/zzab:zzhs	(Ljava/lang/String;)Ljava/lang/String;
    //   12: pop
    //   13: aload_2
    //   14: invokestatic 229	com/google/android/gms/common/internal/zzab:zzhs	(Ljava/lang/String;)Ljava/lang/String;
    //   17: pop
    //   18: new 24	android/support/v4/util/ArrayMap
    //   21: dup
    //   22: invokespecial 921	android/support/v4/util/ArrayMap:<init>	()V
    //   25: astore 8
    //   27: aload_0
    //   28: invokevirtual 180	com/google/android/gms/measurement/internal/zze:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   31: astore 5
    //   33: aload 5
    //   35: ldc_w 346
    //   38: iconst_2
    //   39: anewarray 303	java/lang/String
    //   42: dup
    //   43: iconst_0
    //   44: ldc_w 332
    //   47: aastore
    //   48: dup
    //   49: iconst_1
    //   50: ldc_w 341
    //   53: aastore
    //   54: ldc_w 923
    //   57: iconst_2
    //   58: anewarray 303	java/lang/String
    //   61: dup
    //   62: iconst_0
    //   63: aload_1
    //   64: aastore
    //   65: dup
    //   66: iconst_1
    //   67: aload_2
    //   68: aastore
    //   69: aconst_null
    //   70: aconst_null
    //   71: aconst_null
    //   72: invokevirtual 420	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   75: astore 5
    //   77: aload 5
    //   79: astore_2
    //   80: aload 5
    //   82: invokeinterface 190 1 0
    //   87: ifne +24 -> 111
    //   90: aload 5
    //   92: astore_2
    //   93: invokestatic 928	java/util/Collections:emptyMap	()Ljava/util/Map;
    //   96: astore_1
    //   97: aload 5
    //   99: ifnull +10 -> 109
    //   102: aload 5
    //   104: invokeinterface 197 1 0
    //   109: aload_1
    //   110: areturn
    //   111: aload 5
    //   113: astore_2
    //   114: aload 5
    //   116: iconst_1
    //   117: invokeinterface 760 2 0
    //   122: invokestatic 766	com/google/android/gms/internal/zzaou:zzaz	([B)Lcom/google/android/gms/internal/zzaou;
    //   125: astore 6
    //   127: aload 5
    //   129: astore_2
    //   130: new 263	com/google/android/gms/internal/zzun$zzb
    //   133: dup
    //   134: invokespecial 929	com/google/android/gms/internal/zzun$zzb:<init>	()V
    //   137: astore 9
    //   139: aload 5
    //   141: astore_2
    //   142: aload 9
    //   144: aload 6
    //   146: invokevirtual 930	com/google/android/gms/internal/zzun$zzb:zzb	(Lcom/google/android/gms/internal/zzaou;)Lcom/google/android/gms/internal/zzapc;
    //   149: checkcast 263	com/google/android/gms/internal/zzun$zzb
    //   152: astore 6
    //   154: aload 5
    //   156: astore_2
    //   157: aload 5
    //   159: iconst_0
    //   160: invokeinterface 933 2 0
    //   165: istore_3
    //   166: aload 5
    //   168: astore_2
    //   169: aload 8
    //   171: iload_3
    //   172: invokestatic 301	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   175: invokeinterface 935 2 0
    //   180: checkcast 862	java/util/List
    //   183: astore 7
    //   185: aload 7
    //   187: astore 6
    //   189: aload 7
    //   191: ifnonnull +32 -> 223
    //   194: aload 5
    //   196: astore_2
    //   197: new 937	java/util/ArrayList
    //   200: dup
    //   201: invokespecial 938	java/util/ArrayList:<init>	()V
    //   204: astore 6
    //   206: aload 5
    //   208: astore_2
    //   209: aload 8
    //   211: iload_3
    //   212: invokestatic 301	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   215: aload 6
    //   217: invokeinterface 40 3 0
    //   222: pop
    //   223: aload 5
    //   225: astore_2
    //   226: aload 6
    //   228: aload 9
    //   230: invokeinterface 942 2 0
    //   235: pop
    //   236: aload 5
    //   238: astore_2
    //   239: aload 5
    //   241: invokeinterface 773 1 0
    //   246: istore 4
    //   248: iload 4
    //   250: ifne -139 -> 111
    //   253: aload 5
    //   255: ifnull +10 -> 265
    //   258: aload 5
    //   260: invokeinterface 197 1 0
    //   265: aload 8
    //   267: areturn
    //   268: astore 6
    //   270: aload 5
    //   272: astore_2
    //   273: aload_0
    //   274: invokevirtual 201	com/google/android/gms/measurement/internal/zze:zzbsz	()Lcom/google/android/gms/measurement/internal/zzp;
    //   277: invokevirtual 207	com/google/android/gms/measurement/internal/zzp:zzbtr	()Lcom/google/android/gms/measurement/internal/zzp$zza;
    //   280: ldc_w 944
    //   283: aload_1
    //   284: aload 6
    //   286: invokevirtual 215	com/google/android/gms/measurement/internal/zzp$zza:zze	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   289: goto -53 -> 236
    //   292: astore_1
    //   293: aload 5
    //   295: astore_2
    //   296: aload_0
    //   297: invokevirtual 201	com/google/android/gms/measurement/internal/zze:zzbsz	()Lcom/google/android/gms/measurement/internal/zzp;
    //   300: invokevirtual 207	com/google/android/gms/measurement/internal/zzp:zzbtr	()Lcom/google/android/gms/measurement/internal/zzp$zza;
    //   303: ldc_w 946
    //   306: aload_1
    //   307: invokevirtual 360	com/google/android/gms/measurement/internal/zzp$zza:zzj	(Ljava/lang/String;Ljava/lang/Object;)V
    //   310: aload 5
    //   312: ifnull +10 -> 322
    //   315: aload 5
    //   317: invokeinterface 197 1 0
    //   322: aconst_null
    //   323: areturn
    //   324: astore_1
    //   325: aconst_null
    //   326: astore_2
    //   327: aload_2
    //   328: ifnull +9 -> 337
    //   331: aload_2
    //   332: invokeinterface 197 1 0
    //   337: aload_1
    //   338: athrow
    //   339: astore_1
    //   340: goto -13 -> 327
    //   343: astore_1
    //   344: aconst_null
    //   345: astore 5
    //   347: goto -54 -> 293
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	350	0	this	zze
    //   0	350	1	paramString1	String
    //   0	350	2	paramString2	String
    //   165	47	3	i	int
    //   246	3	4	bool	boolean
    //   31	315	5	localObject1	Object
    //   125	102	6	localObject2	Object
    //   268	17	6	localIOException	IOException
    //   183	7	7	localList	List
    //   25	241	8	localArrayMap	ArrayMap
    //   137	92	9	localzzb	zzun.zzb
    // Exception table:
    //   from	to	target	type
    //   142	154	268	java/io/IOException
    //   80	90	292	android/database/sqlite/SQLiteException
    //   93	97	292	android/database/sqlite/SQLiteException
    //   114	127	292	android/database/sqlite/SQLiteException
    //   130	139	292	android/database/sqlite/SQLiteException
    //   142	154	292	android/database/sqlite/SQLiteException
    //   157	166	292	android/database/sqlite/SQLiteException
    //   169	185	292	android/database/sqlite/SQLiteException
    //   197	206	292	android/database/sqlite/SQLiteException
    //   209	223	292	android/database/sqlite/SQLiteException
    //   226	236	292	android/database/sqlite/SQLiteException
    //   239	248	292	android/database/sqlite/SQLiteException
    //   273	289	292	android/database/sqlite/SQLiteException
    //   33	77	324	finally
    //   80	90	339	finally
    //   93	97	339	finally
    //   114	127	339	finally
    //   130	139	339	finally
    //   142	154	339	finally
    //   157	166	339	finally
    //   169	185	339	finally
    //   197	206	339	finally
    //   209	223	339	finally
    //   226	236	339	finally
    //   239	248	339	finally
    //   273	289	339	finally
    //   296	310	339	finally
    //   33	77	343	android/database/sqlite/SQLiteException
  }
  
  /* Error */
  Map<Integer, List<zzun.zze>> zzau(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 220	com/google/android/gms/measurement/internal/zze:zzzg	()V
    //   4: aload_0
    //   5: invokevirtual 223	com/google/android/gms/measurement/internal/zze:zzwu	()V
    //   8: aload_1
    //   9: invokestatic 229	com/google/android/gms/common/internal/zzab:zzhs	(Ljava/lang/String;)Ljava/lang/String;
    //   12: pop
    //   13: aload_2
    //   14: invokestatic 229	com/google/android/gms/common/internal/zzab:zzhs	(Ljava/lang/String;)Ljava/lang/String;
    //   17: pop
    //   18: new 24	android/support/v4/util/ArrayMap
    //   21: dup
    //   22: invokespecial 921	android/support/v4/util/ArrayMap:<init>	()V
    //   25: astore 8
    //   27: aload_0
    //   28: invokevirtual 180	com/google/android/gms/measurement/internal/zze:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   31: astore 5
    //   33: aload 5
    //   35: ldc_w 373
    //   38: iconst_2
    //   39: anewarray 303	java/lang/String
    //   42: dup
    //   43: iconst_0
    //   44: ldc_w 332
    //   47: aastore
    //   48: dup
    //   49: iconst_1
    //   50: ldc_w 341
    //   53: aastore
    //   54: ldc_w 950
    //   57: iconst_2
    //   58: anewarray 303	java/lang/String
    //   61: dup
    //   62: iconst_0
    //   63: aload_1
    //   64: aastore
    //   65: dup
    //   66: iconst_1
    //   67: aload_2
    //   68: aastore
    //   69: aconst_null
    //   70: aconst_null
    //   71: aconst_null
    //   72: invokevirtual 420	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   75: astore 5
    //   77: aload 5
    //   79: astore_2
    //   80: aload 5
    //   82: invokeinterface 190 1 0
    //   87: ifne +24 -> 111
    //   90: aload 5
    //   92: astore_2
    //   93: invokestatic 928	java/util/Collections:emptyMap	()Ljava/util/Map;
    //   96: astore_1
    //   97: aload 5
    //   99: ifnull +10 -> 109
    //   102: aload 5
    //   104: invokeinterface 197 1 0
    //   109: aload_1
    //   110: areturn
    //   111: aload 5
    //   113: astore_2
    //   114: aload 5
    //   116: iconst_1
    //   117: invokeinterface 760 2 0
    //   122: invokestatic 766	com/google/android/gms/internal/zzaou:zzaz	([B)Lcom/google/android/gms/internal/zzaou;
    //   125: astore 6
    //   127: aload 5
    //   129: astore_2
    //   130: new 270	com/google/android/gms/internal/zzun$zze
    //   133: dup
    //   134: invokespecial 951	com/google/android/gms/internal/zzun$zze:<init>	()V
    //   137: astore 9
    //   139: aload 5
    //   141: astore_2
    //   142: aload 9
    //   144: aload 6
    //   146: invokevirtual 952	com/google/android/gms/internal/zzun$zze:zzb	(Lcom/google/android/gms/internal/zzaou;)Lcom/google/android/gms/internal/zzapc;
    //   149: checkcast 270	com/google/android/gms/internal/zzun$zze
    //   152: astore 6
    //   154: aload 5
    //   156: astore_2
    //   157: aload 5
    //   159: iconst_0
    //   160: invokeinterface 933 2 0
    //   165: istore_3
    //   166: aload 5
    //   168: astore_2
    //   169: aload 8
    //   171: iload_3
    //   172: invokestatic 301	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   175: invokeinterface 935 2 0
    //   180: checkcast 862	java/util/List
    //   183: astore 7
    //   185: aload 7
    //   187: astore 6
    //   189: aload 7
    //   191: ifnonnull +32 -> 223
    //   194: aload 5
    //   196: astore_2
    //   197: new 937	java/util/ArrayList
    //   200: dup
    //   201: invokespecial 938	java/util/ArrayList:<init>	()V
    //   204: astore 6
    //   206: aload 5
    //   208: astore_2
    //   209: aload 8
    //   211: iload_3
    //   212: invokestatic 301	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   215: aload 6
    //   217: invokeinterface 40 3 0
    //   222: pop
    //   223: aload 5
    //   225: astore_2
    //   226: aload 6
    //   228: aload 9
    //   230: invokeinterface 942 2 0
    //   235: pop
    //   236: aload 5
    //   238: astore_2
    //   239: aload 5
    //   241: invokeinterface 773 1 0
    //   246: istore 4
    //   248: iload 4
    //   250: ifne -139 -> 111
    //   253: aload 5
    //   255: ifnull +10 -> 265
    //   258: aload 5
    //   260: invokeinterface 197 1 0
    //   265: aload 8
    //   267: areturn
    //   268: astore 6
    //   270: aload 5
    //   272: astore_2
    //   273: aload_0
    //   274: invokevirtual 201	com/google/android/gms/measurement/internal/zze:zzbsz	()Lcom/google/android/gms/measurement/internal/zzp;
    //   277: invokevirtual 207	com/google/android/gms/measurement/internal/zzp:zzbtr	()Lcom/google/android/gms/measurement/internal/zzp$zza;
    //   280: ldc_w 944
    //   283: aload_1
    //   284: aload 6
    //   286: invokevirtual 215	com/google/android/gms/measurement/internal/zzp$zza:zze	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   289: goto -53 -> 236
    //   292: astore_1
    //   293: aload 5
    //   295: astore_2
    //   296: aload_0
    //   297: invokevirtual 201	com/google/android/gms/measurement/internal/zze:zzbsz	()Lcom/google/android/gms/measurement/internal/zzp;
    //   300: invokevirtual 207	com/google/android/gms/measurement/internal/zzp:zzbtr	()Lcom/google/android/gms/measurement/internal/zzp$zza;
    //   303: ldc_w 946
    //   306: aload_1
    //   307: invokevirtual 360	com/google/android/gms/measurement/internal/zzp$zza:zzj	(Ljava/lang/String;Ljava/lang/Object;)V
    //   310: aload 5
    //   312: ifnull +10 -> 322
    //   315: aload 5
    //   317: invokeinterface 197 1 0
    //   322: aconst_null
    //   323: areturn
    //   324: astore_1
    //   325: aconst_null
    //   326: astore_2
    //   327: aload_2
    //   328: ifnull +9 -> 337
    //   331: aload_2
    //   332: invokeinterface 197 1 0
    //   337: aload_1
    //   338: athrow
    //   339: astore_1
    //   340: goto -13 -> 327
    //   343: astore_1
    //   344: aconst_null
    //   345: astore 5
    //   347: goto -54 -> 293
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	350	0	this	zze
    //   0	350	1	paramString1	String
    //   0	350	2	paramString2	String
    //   165	47	3	i	int
    //   246	3	4	bool	boolean
    //   31	315	5	localObject1	Object
    //   125	102	6	localObject2	Object
    //   268	17	6	localIOException	IOException
    //   183	7	7	localList	List
    //   25	241	8	localArrayMap	ArrayMap
    //   137	92	9	localzze	zzun.zze
    // Exception table:
    //   from	to	target	type
    //   142	154	268	java/io/IOException
    //   80	90	292	android/database/sqlite/SQLiteException
    //   93	97	292	android/database/sqlite/SQLiteException
    //   114	127	292	android/database/sqlite/SQLiteException
    //   130	139	292	android/database/sqlite/SQLiteException
    //   142	154	292	android/database/sqlite/SQLiteException
    //   157	166	292	android/database/sqlite/SQLiteException
    //   169	185	292	android/database/sqlite/SQLiteException
    //   197	206	292	android/database/sqlite/SQLiteException
    //   209	223	292	android/database/sqlite/SQLiteException
    //   226	236	292	android/database/sqlite/SQLiteException
    //   239	248	292	android/database/sqlite/SQLiteException
    //   273	289	292	android/database/sqlite/SQLiteException
    //   33	77	324	finally
    //   80	90	339	finally
    //   93	97	339	finally
    //   114	127	339	finally
    //   130	139	339	finally
    //   142	154	339	finally
    //   157	166	339	finally
    //   169	185	339	finally
    //   197	206	339	finally
    //   209	223	339	finally
    //   226	236	339	finally
    //   239	248	339	finally
    //   273	289	339	finally
    //   296	310	339	finally
    //   33	77	343	android/database/sqlite/SQLiteException
  }
  
  /* Error */
  public long zzb(zzup.zze paramzze)
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 223	com/google/android/gms/measurement/internal/zze:zzwu	()V
    //   4: aload_0
    //   5: invokevirtual 220	com/google/android/gms/measurement/internal/zze:zzzg	()V
    //   8: aload_1
    //   9: invokestatic 233	com/google/android/gms/common/internal/zzab:zzaa	(Ljava/lang/Object;)Ljava/lang/Object;
    //   12: pop
    //   13: aload_1
    //   14: getfield 466	com/google/android/gms/internal/zzup$zze:zzck	Ljava/lang/String;
    //   17: invokestatic 229	com/google/android/gms/common/internal/zzab:zzhs	(Ljava/lang/String;)Ljava/lang/String;
    //   20: pop
    //   21: aload_1
    //   22: invokevirtual 494	com/google/android/gms/internal/zzup$zze:ao	()I
    //   25: newarray <illegal type>
    //   27: astore 4
    //   29: aload 4
    //   31: invokestatic 315	com/google/android/gms/internal/zzaov:zzba	([B)Lcom/google/android/gms/internal/zzaov;
    //   34: astore 5
    //   36: aload_1
    //   37: aload 5
    //   39: invokevirtual 495	com/google/android/gms/internal/zzup$zze:zza	(Lcom/google/android/gms/internal/zzaov;)V
    //   42: aload 5
    //   44: invokevirtual 321	com/google/android/gms/internal/zzaov:ab	()V
    //   47: aload_0
    //   48: invokevirtual 499	com/google/android/gms/measurement/internal/zze:zzbsv	()Lcom/google/android/gms/measurement/internal/zzal;
    //   51: aload 4
    //   53: invokevirtual 958	com/google/android/gms/measurement/internal/zzal:zzad	([B)J
    //   56: lstore_2
    //   57: new 323	android/content/ContentValues
    //   60: dup
    //   61: invokespecial 325	android/content/ContentValues:<init>	()V
    //   64: astore 5
    //   66: aload 5
    //   68: ldc_w 327
    //   71: aload_1
    //   72: getfield 466	com/google/android/gms/internal/zzup$zze:zzck	Ljava/lang/String;
    //   75: invokevirtual 330	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   78: aload 5
    //   80: ldc_w 680
    //   83: lload_2
    //   84: invokestatic 440	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   87: invokevirtual 443	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   90: aload 5
    //   92: ldc_w 743
    //   95: aload 4
    //   97: invokevirtual 344	android/content/ContentValues:put	(Ljava/lang/String;[B)V
    //   100: aload_0
    //   101: invokevirtual 180	com/google/android/gms/measurement/internal/zze:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   104: ldc_w 741
    //   107: aconst_null
    //   108: aload 5
    //   110: iconst_4
    //   111: invokevirtual 350	android/database/sqlite/SQLiteDatabase:insertWithOnConflict	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;I)J
    //   114: pop2
    //   115: lload_2
    //   116: lreturn
    //   117: astore_1
    //   118: aload_0
    //   119: invokevirtual 201	com/google/android/gms/measurement/internal/zze:zzbsz	()Lcom/google/android/gms/measurement/internal/zzp;
    //   122: invokevirtual 207	com/google/android/gms/measurement/internal/zzp:zzbtr	()Lcom/google/android/gms/measurement/internal/zzp$zza;
    //   125: ldc_w 960
    //   128: aload_1
    //   129: invokevirtual 360	com/google/android/gms/measurement/internal/zzp$zza:zzj	(Ljava/lang/String;Ljava/lang/Object;)V
    //   132: aload_1
    //   133: athrow
    //   134: astore_1
    //   135: aload_0
    //   136: invokevirtual 201	com/google/android/gms/measurement/internal/zze:zzbsz	()Lcom/google/android/gms/measurement/internal/zzp;
    //   139: invokevirtual 207	com/google/android/gms/measurement/internal/zzp:zzbtr	()Lcom/google/android/gms/measurement/internal/zzp$zza;
    //   142: ldc_w 962
    //   145: aload_1
    //   146: invokevirtual 360	com/google/android/gms/measurement/internal/zzp$zza:zzj	(Ljava/lang/String;Ljava/lang/Object;)V
    //   149: aload_1
    //   150: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	151	0	this	zze
    //   0	151	1	paramzze	zzup.zze
    //   56	60	2	l	long
    //   27	69	4	arrayOfByte	byte[]
    //   34	75	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   21	47	117	java/io/IOException
    //   100	115	134	android/database/sqlite/SQLiteException
  }
  
  Object zzb(Cursor paramCursor, int paramInt)
  {
    int i = zza(paramCursor, paramInt);
    switch (i)
    {
    default: 
      zzbsz().zzbtr().zzj("Loaded invalid unknown value type, ignoring it", Integer.valueOf(i));
      return null;
    case 0: 
      zzbsz().zzbtr().log("Loaded invalid null value from database");
      return null;
    case 1: 
      return Long.valueOf(paramCursor.getLong(paramInt));
    case 2: 
      return Double.valueOf(paramCursor.getDouble(paramInt));
    case 3: 
      return paramCursor.getString(paramInt);
    }
    zzbsz().zzbtr().log("Loaded invalid blob type value, ignoring it");
    return null;
  }
  
  void zzb(String paramString, zzun.zza[] paramArrayOfzza)
  {
    zzzg();
    zzwu();
    zzab.zzhs(paramString);
    zzab.zzaa(paramArrayOfzza);
    SQLiteDatabase localSQLiteDatabase = getWritableDatabase();
    localSQLiteDatabase.beginTransaction();
    try
    {
      zzlr(paramString);
      int j = paramArrayOfzza.length;
      int i = 0;
      while (i < j)
      {
        zza(paramString, paramArrayOfzza[i]);
        i += 1;
      }
      localSQLiteDatabase.setTransactionSuccessful();
      return;
    }
    finally
    {
      localSQLiteDatabase.endTransaction();
    }
  }
  
  public void zzbg(long paramLong)
  {
    zzwu();
    zzzg();
    if (getWritableDatabase().delete("queue", "rowid=?", new String[] { String.valueOf(paramLong) }) != 1) {
      zzbsz().zzbtr().log("Deleted fewer rows from queue than expected");
    }
  }
  
  /* Error */
  public String zzbh(long paramLong)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aload_0
    //   4: invokevirtual 223	com/google/android/gms/measurement/internal/zze:zzwu	()V
    //   7: aload_0
    //   8: invokevirtual 220	com/google/android/gms/measurement/internal/zze:zzzg	()V
    //   11: aload_0
    //   12: invokevirtual 180	com/google/android/gms/measurement/internal/zze:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   15: ldc_w 993
    //   18: iconst_1
    //   19: anewarray 303	java/lang/String
    //   22: dup
    //   23: iconst_0
    //   24: lload_1
    //   25: invokestatic 735	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   28: aastore
    //   29: invokevirtual 186	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   32: astore_3
    //   33: aload_3
    //   34: astore 4
    //   36: aload_3
    //   37: invokeinterface 190 1 0
    //   42: ifne +40 -> 82
    //   45: aload_3
    //   46: astore 4
    //   48: aload_0
    //   49: invokevirtual 201	com/google/android/gms/measurement/internal/zze:zzbsz	()Lcom/google/android/gms/measurement/internal/zzp;
    //   52: invokevirtual 507	com/google/android/gms/measurement/internal/zzp:zzbty	()Lcom/google/android/gms/measurement/internal/zzp$zza;
    //   55: ldc_w 995
    //   58: invokevirtual 256	com/google/android/gms/measurement/internal/zzp$zza:log	(Ljava/lang/String;)V
    //   61: aload 6
    //   63: astore 4
    //   65: aload_3
    //   66: ifnull +13 -> 79
    //   69: aload_3
    //   70: invokeinterface 197 1 0
    //   75: aload 6
    //   77: astore 4
    //   79: aload 4
    //   81: areturn
    //   82: aload_3
    //   83: astore 4
    //   85: aload_3
    //   86: iconst_0
    //   87: invokeinterface 739 2 0
    //   92: astore 5
    //   94: aload 5
    //   96: astore 4
    //   98: aload_3
    //   99: ifnull -20 -> 79
    //   102: aload_3
    //   103: invokeinterface 197 1 0
    //   108: aload 5
    //   110: areturn
    //   111: astore 5
    //   113: aconst_null
    //   114: astore_3
    //   115: aload_3
    //   116: astore 4
    //   118: aload_0
    //   119: invokevirtual 201	com/google/android/gms/measurement/internal/zze:zzbsz	()Lcom/google/android/gms/measurement/internal/zzp;
    //   122: invokevirtual 207	com/google/android/gms/measurement/internal/zzp:zzbtr	()Lcom/google/android/gms/measurement/internal/zzp$zza;
    //   125: ldc_w 997
    //   128: aload 5
    //   130: invokevirtual 360	com/google/android/gms/measurement/internal/zzp$zza:zzj	(Ljava/lang/String;Ljava/lang/Object;)V
    //   133: aload 6
    //   135: astore 4
    //   137: aload_3
    //   138: ifnull -59 -> 79
    //   141: aload_3
    //   142: invokeinterface 197 1 0
    //   147: aconst_null
    //   148: areturn
    //   149: astore_3
    //   150: aconst_null
    //   151: astore 4
    //   153: aload 4
    //   155: ifnull +10 -> 165
    //   158: aload 4
    //   160: invokeinterface 197 1 0
    //   165: aload_3
    //   166: athrow
    //   167: astore_3
    //   168: goto -15 -> 153
    //   171: astore 5
    //   173: goto -58 -> 115
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	176	0	this	zze
    //   0	176	1	paramLong	long
    //   32	110	3	localCursor	Cursor
    //   149	17	3	localObject1	Object
    //   167	1	3	localObject2	Object
    //   34	125	4	localObject3	Object
    //   92	17	5	str	String
    //   111	18	5	localSQLiteException1	SQLiteException
    //   171	1	5	localSQLiteException2	SQLiteException
    //   1	133	6	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   11	33	111	android/database/sqlite/SQLiteException
    //   11	33	149	finally
    //   36	45	167	finally
    //   48	61	167	finally
    //   85	94	167	finally
    //   118	133	167	finally
    //   36	45	171	android/database/sqlite/SQLiteException
    //   48	61	171	android/database/sqlite/SQLiteException
    //   85	94	171	android/database/sqlite/SQLiteException
  }
  
  /* Error */
  public String zzbtc()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: invokevirtual 180	com/google/android/gms/measurement/internal/zze:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   7: astore_1
    //   8: aload_1
    //   9: ldc_w 1000
    //   12: aconst_null
    //   13: invokevirtual 186	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   16: astore_1
    //   17: aload_1
    //   18: astore_2
    //   19: aload_1
    //   20: invokeinterface 190 1 0
    //   25: ifeq +29 -> 54
    //   28: aload_1
    //   29: astore_2
    //   30: aload_1
    //   31: iconst_0
    //   32: invokeinterface 739 2 0
    //   37: astore_3
    //   38: aload_3
    //   39: astore_2
    //   40: aload_1
    //   41: ifnull +11 -> 52
    //   44: aload_1
    //   45: invokeinterface 197 1 0
    //   50: aload_3
    //   51: astore_2
    //   52: aload_2
    //   53: areturn
    //   54: aload 4
    //   56: astore_2
    //   57: aload_1
    //   58: ifnull -6 -> 52
    //   61: aload_1
    //   62: invokeinterface 197 1 0
    //   67: aconst_null
    //   68: areturn
    //   69: astore_3
    //   70: aconst_null
    //   71: astore_1
    //   72: aload_1
    //   73: astore_2
    //   74: aload_0
    //   75: invokevirtual 201	com/google/android/gms/measurement/internal/zze:zzbsz	()Lcom/google/android/gms/measurement/internal/zzp;
    //   78: invokevirtual 207	com/google/android/gms/measurement/internal/zzp:zzbtr	()Lcom/google/android/gms/measurement/internal/zzp$zza;
    //   81: ldc_w 1002
    //   84: aload_3
    //   85: invokevirtual 360	com/google/android/gms/measurement/internal/zzp$zza:zzj	(Ljava/lang/String;Ljava/lang/Object;)V
    //   88: aload 4
    //   90: astore_2
    //   91: aload_1
    //   92: ifnull -40 -> 52
    //   95: aload_1
    //   96: invokeinterface 197 1 0
    //   101: aconst_null
    //   102: areturn
    //   103: astore_1
    //   104: aconst_null
    //   105: astore_2
    //   106: aload_2
    //   107: ifnull +9 -> 116
    //   110: aload_2
    //   111: invokeinterface 197 1 0
    //   116: aload_1
    //   117: athrow
    //   118: astore_1
    //   119: goto -13 -> 106
    //   122: astore_3
    //   123: goto -51 -> 72
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	126	0	this	zze
    //   7	89	1	localObject1	Object
    //   103	14	1	localObject2	Object
    //   118	1	1	localObject3	Object
    //   18	93	2	localObject4	Object
    //   37	14	3	str	String
    //   69	16	3	localSQLiteException1	SQLiteException
    //   122	1	3	localSQLiteException2	SQLiteException
    //   1	88	4	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   8	17	69	android/database/sqlite/SQLiteException
    //   8	17	103	finally
    //   19	28	118	finally
    //   30	38	118	finally
    //   74	88	118	finally
    //   19	28	122	android/database/sqlite/SQLiteException
    //   30	38	122	android/database/sqlite/SQLiteException
  }
  
  void zzbtd()
  {
    zzwu();
    zzzg();
    if (!zzbti()) {}
    long l1;
    long l2;
    do
    {
      return;
      l1 = zzbtaaly.get();
      l2 = zzyw().elapsedRealtime();
    } while (Math.abs(l2 - l1) <= zzbtb().zzbsc());
    zzbtaaly.set(l2);
    zzbte();
  }
  
  void zzbte()
  {
    zzwu();
    zzzg();
    if (!zzbti()) {}
    int i;
    do
    {
      return;
      i = getWritableDatabase().delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[] { String.valueOf(zzyw().currentTimeMillis()), String.valueOf(zzbtb().zzbsb()) });
    } while (i <= 0);
    zzbsz().zzbty().zzj("Deleted stale rows. rowsDeleted", Integer.valueOf(i));
  }
  
  public long zzbtf()
  {
    return zza("select max(bundle_end_timestamp) from queue", null, 0L);
  }
  
  public long zzbtg()
  {
    return zza("select max(timestamp) from raw_events", null, 0L);
  }
  
  public boolean zzbth()
  {
    return zzb("select count(1) > 0 from raw_events", null) != 0L;
  }
  
  public void zzd(String paramString, byte[] paramArrayOfByte)
  {
    zzab.zzhs(paramString);
    zzwu();
    zzzg();
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("remote_config", paramArrayOfByte);
    try
    {
      if (getWritableDatabase().update("apps", localContentValues, "app_id = ?", new String[] { paramString }) == 0L) {
        zzbsz().zzbtr().log("Failed to update remote config (got 0)");
      }
      return;
    }
    catch (SQLiteException paramString)
    {
      zzbsz().zzbtr().zzj("Error storing remote config", paramString);
    }
  }
  
  /* Error */
  public List<zzak> zzln(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aload_1
    //   4: invokestatic 229	com/google/android/gms/common/internal/zzab:zzhs	(Ljava/lang/String;)Ljava/lang/String;
    //   7: pop
    //   8: aload_0
    //   9: invokevirtual 223	com/google/android/gms/measurement/internal/zze:zzwu	()V
    //   12: aload_0
    //   13: invokevirtual 220	com/google/android/gms/measurement/internal/zze:zzzg	()V
    //   16: new 937	java/util/ArrayList
    //   19: dup
    //   20: invokespecial 938	java/util/ArrayList:<init>	()V
    //   23: astore 8
    //   25: aload_0
    //   26: invokevirtual 180	com/google/android/gms/measurement/internal/zze:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   29: astore 6
    //   31: aload_0
    //   32: invokevirtual 486	com/google/android/gms/measurement/internal/zze:zzbtb	()Lcom/google/android/gms/measurement/internal/zzd;
    //   35: invokevirtual 818	com/google/android/gms/measurement/internal/zzd:zzbrv	()I
    //   38: istore_2
    //   39: aload 6
    //   41: ldc_w 832
    //   44: iconst_3
    //   45: anewarray 303	java/lang/String
    //   48: dup
    //   49: iconst_0
    //   50: ldc_w 673
    //   53: aastore
    //   54: dup
    //   55: iconst_1
    //   56: ldc_w 820
    //   59: aastore
    //   60: dup
    //   61: iconst_2
    //   62: ldc_w 824
    //   65: aastore
    //   66: ldc_w 416
    //   69: iconst_1
    //   70: anewarray 303	java/lang/String
    //   73: dup
    //   74: iconst_0
    //   75: aload_1
    //   76: aastore
    //   77: aconst_null
    //   78: aconst_null
    //   79: ldc_w 747
    //   82: iload_2
    //   83: invokestatic 1061	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   86: invokevirtual 752	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   89: astore 6
    //   91: aload 6
    //   93: invokeinterface 190 1 0
    //   98: istore_3
    //   99: iload_3
    //   100: ifne +18 -> 118
    //   103: aload 6
    //   105: ifnull +10 -> 115
    //   108: aload 6
    //   110: invokeinterface 197 1 0
    //   115: aload 8
    //   117: areturn
    //   118: aload 6
    //   120: iconst_0
    //   121: invokeinterface 739 2 0
    //   126: astore 7
    //   128: aload 6
    //   130: iconst_1
    //   131: invokeinterface 194 2 0
    //   136: lstore 4
    //   138: aload_0
    //   139: aload 6
    //   141: iconst_2
    //   142: invokevirtual 911	com/google/android/gms/measurement/internal/zze:zzb	(Landroid/database/Cursor;I)Ljava/lang/Object;
    //   145: astore 9
    //   147: aload 9
    //   149: ifnonnull +43 -> 192
    //   152: aload_0
    //   153: invokevirtual 201	com/google/android/gms/measurement/internal/zze:zzbsz	()Lcom/google/android/gms/measurement/internal/zzp;
    //   156: invokevirtual 207	com/google/android/gms/measurement/internal/zzp:zzbtr	()Lcom/google/android/gms/measurement/internal/zzp$zza;
    //   159: ldc_w 1063
    //   162: invokevirtual 256	com/google/android/gms/measurement/internal/zzp$zza:log	(Ljava/lang/String;)V
    //   165: aload 6
    //   167: invokeinterface 773 1 0
    //   172: istore_3
    //   173: iload_3
    //   174: ifne -56 -> 118
    //   177: aload 6
    //   179: ifnull +10 -> 189
    //   182: aload 6
    //   184: invokeinterface 197 1 0
    //   189: aload 8
    //   191: areturn
    //   192: aload 8
    //   194: new 796	com/google/android/gms/measurement/internal/zzak
    //   197: dup
    //   198: aload_1
    //   199: aload 7
    //   201: lload 4
    //   203: aload 9
    //   205: invokespecial 914	com/google/android/gms/measurement/internal/zzak:<init>	(Ljava/lang/String;Ljava/lang/String;JLjava/lang/Object;)V
    //   208: invokeinterface 942 2 0
    //   213: pop
    //   214: goto -49 -> 165
    //   217: astore 7
    //   219: aload_0
    //   220: invokevirtual 201	com/google/android/gms/measurement/internal/zze:zzbsz	()Lcom/google/android/gms/measurement/internal/zzp;
    //   223: invokevirtual 207	com/google/android/gms/measurement/internal/zzp:zzbtr	()Lcom/google/android/gms/measurement/internal/zzp$zza;
    //   226: ldc_w 1065
    //   229: aload_1
    //   230: aload 7
    //   232: invokevirtual 215	com/google/android/gms/measurement/internal/zzp$zza:zze	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   235: aload 6
    //   237: ifnull +10 -> 247
    //   240: aload 6
    //   242: invokeinterface 197 1 0
    //   247: aconst_null
    //   248: areturn
    //   249: astore_1
    //   250: aload 7
    //   252: astore 6
    //   254: aload 6
    //   256: ifnull +10 -> 266
    //   259: aload 6
    //   261: invokeinterface 197 1 0
    //   266: aload_1
    //   267: athrow
    //   268: astore_1
    //   269: goto -15 -> 254
    //   272: astore_1
    //   273: goto -19 -> 254
    //   276: astore 7
    //   278: aconst_null
    //   279: astore 6
    //   281: goto -62 -> 219
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	284	0	this	zze
    //   0	284	1	paramString	String
    //   38	45	2	i	int
    //   98	76	3	bool	boolean
    //   136	66	4	l	long
    //   29	251	6	localObject1	Object
    //   1	199	7	str	String
    //   217	34	7	localSQLiteException1	SQLiteException
    //   276	1	7	localSQLiteException2	SQLiteException
    //   23	170	8	localArrayList	java.util.ArrayList
    //   145	59	9	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   91	99	217	android/database/sqlite/SQLiteException
    //   118	147	217	android/database/sqlite/SQLiteException
    //   152	165	217	android/database/sqlite/SQLiteException
    //   165	173	217	android/database/sqlite/SQLiteException
    //   192	214	217	android/database/sqlite/SQLiteException
    //   25	91	249	finally
    //   91	99	268	finally
    //   118	147	268	finally
    //   152	165	268	finally
    //   165	173	268	finally
    //   192	214	268	finally
    //   219	235	272	finally
    //   25	91	276	android/database/sqlite/SQLiteException
  }
  
  /* Error */
  public zza zzlo(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 229	com/google/android/gms/common/internal/zzab:zzhs	(Ljava/lang/String;)Ljava/lang/String;
    //   4: pop
    //   5: aload_0
    //   6: invokevirtual 223	com/google/android/gms/measurement/internal/zze:zzwu	()V
    //   9: aload_0
    //   10: invokevirtual 220	com/google/android/gms/measurement/internal/zze:zzzg	()V
    //   13: aload_0
    //   14: invokevirtual 180	com/google/android/gms/measurement/internal/zze:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   17: ldc_w 414
    //   20: bipush 20
    //   22: anewarray 303	java/lang/String
    //   25: dup
    //   26: iconst_0
    //   27: ldc_w 531
    //   30: aastore
    //   31: dup
    //   32: iconst_1
    //   33: ldc_w 536
    //   36: aastore
    //   37: dup
    //   38: iconst_2
    //   39: ldc_w 541
    //   42: aastore
    //   43: dup
    //   44: iconst_3
    //   45: ldc_w 546
    //   48: aastore
    //   49: dup
    //   50: iconst_4
    //   51: ldc 58
    //   53: aastore
    //   54: dup
    //   55: iconst_5
    //   56: ldc_w 554
    //   59: aastore
    //   60: dup
    //   61: bipush 6
    //   63: ldc 32
    //   65: aastore
    //   66: dup
    //   67: bipush 7
    //   69: ldc 42
    //   71: aastore
    //   72: dup
    //   73: bipush 8
    //   75: ldc 46
    //   77: aastore
    //   78: dup
    //   79: bipush 9
    //   81: ldc 50
    //   83: aastore
    //   84: dup
    //   85: bipush 10
    //   87: ldc 54
    //   89: aastore
    //   90: dup
    //   91: bipush 11
    //   93: ldc 62
    //   95: aastore
    //   96: dup
    //   97: bipush 12
    //   99: ldc 66
    //   101: aastore
    //   102: dup
    //   103: bipush 13
    //   105: ldc 70
    //   107: aastore
    //   108: dup
    //   109: bipush 14
    //   111: ldc 74
    //   113: aastore
    //   114: dup
    //   115: bipush 15
    //   117: ldc 82
    //   119: aastore
    //   120: dup
    //   121: bipush 16
    //   123: ldc 86
    //   125: aastore
    //   126: dup
    //   127: bipush 17
    //   129: ldc 90
    //   131: aastore
    //   132: dup
    //   133: bipush 18
    //   135: ldc 94
    //   137: aastore
    //   138: dup
    //   139: bipush 19
    //   141: ldc 98
    //   143: aastore
    //   144: ldc_w 416
    //   147: iconst_1
    //   148: anewarray 303	java/lang/String
    //   151: dup
    //   152: iconst_0
    //   153: aload_1
    //   154: aastore
    //   155: aconst_null
    //   156: aconst_null
    //   157: aconst_null
    //   158: invokevirtual 420	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   161: astore 7
    //   163: aload 7
    //   165: astore 6
    //   167: aload 7
    //   169: invokeinterface 190 1 0
    //   174: istore_3
    //   175: iload_3
    //   176: ifne +19 -> 195
    //   179: aload 7
    //   181: ifnull +10 -> 191
    //   184: aload 7
    //   186: invokeinterface 197 1 0
    //   191: aconst_null
    //   192: astore_1
    //   193: aload_1
    //   194: areturn
    //   195: aload 7
    //   197: astore 6
    //   199: new 526	com/google/android/gms/measurement/internal/zza
    //   202: dup
    //   203: aload_0
    //   204: getfield 1072	com/google/android/gms/measurement/internal/zze:aja	Lcom/google/android/gms/measurement/internal/zzx;
    //   207: aload_1
    //   208: invokespecial 1075	com/google/android/gms/measurement/internal/zza:<init>	(Lcom/google/android/gms/measurement/internal/zzx;Ljava/lang/String;)V
    //   211: astore 8
    //   213: aload 7
    //   215: astore 6
    //   217: aload 8
    //   219: aload 7
    //   221: iconst_0
    //   222: invokeinterface 739 2 0
    //   227: invokevirtual 1078	com/google/android/gms/measurement/internal/zza:zzkz	(Ljava/lang/String;)V
    //   230: aload 7
    //   232: astore 6
    //   234: aload 8
    //   236: aload 7
    //   238: iconst_1
    //   239: invokeinterface 739 2 0
    //   244: invokevirtual 1081	com/google/android/gms/measurement/internal/zza:zzla	(Ljava/lang/String;)V
    //   247: aload 7
    //   249: astore 6
    //   251: aload 8
    //   253: aload 7
    //   255: iconst_2
    //   256: invokeinterface 739 2 0
    //   261: invokevirtual 1084	com/google/android/gms/measurement/internal/zza:zzlb	(Ljava/lang/String;)V
    //   264: aload 7
    //   266: astore 6
    //   268: aload 8
    //   270: aload 7
    //   272: iconst_3
    //   273: invokeinterface 194 2 0
    //   278: invokevirtual 1087	com/google/android/gms/measurement/internal/zza:zzay	(J)V
    //   281: aload 7
    //   283: astore 6
    //   285: aload 8
    //   287: aload 7
    //   289: iconst_4
    //   290: invokeinterface 194 2 0
    //   295: invokevirtual 1089	com/google/android/gms/measurement/internal/zza:zzat	(J)V
    //   298: aload 7
    //   300: astore 6
    //   302: aload 8
    //   304: aload 7
    //   306: iconst_5
    //   307: invokeinterface 194 2 0
    //   312: invokevirtual 1091	com/google/android/gms/measurement/internal/zza:zzau	(J)V
    //   315: aload 7
    //   317: astore 6
    //   319: aload 8
    //   321: aload 7
    //   323: bipush 6
    //   325: invokeinterface 739 2 0
    //   330: invokevirtual 1094	com/google/android/gms/measurement/internal/zza:setAppVersion	(Ljava/lang/String;)V
    //   333: aload 7
    //   335: astore 6
    //   337: aload 8
    //   339: aload 7
    //   341: bipush 7
    //   343: invokeinterface 739 2 0
    //   348: invokevirtual 1097	com/google/android/gms/measurement/internal/zza:zzld	(Ljava/lang/String;)V
    //   351: aload 7
    //   353: astore 6
    //   355: aload 8
    //   357: aload 7
    //   359: bipush 8
    //   361: invokeinterface 194 2 0
    //   366: invokevirtual 1100	com/google/android/gms/measurement/internal/zza:zzaw	(J)V
    //   369: aload 7
    //   371: astore 6
    //   373: aload 8
    //   375: aload 7
    //   377: bipush 9
    //   379: invokeinterface 194 2 0
    //   384: invokevirtual 1103	com/google/android/gms/measurement/internal/zza:zzax	(J)V
    //   387: aload 7
    //   389: astore 6
    //   391: aload 7
    //   393: bipush 10
    //   395: invokeinterface 1106 2 0
    //   400: ifeq +252 -> 652
    //   403: iconst_1
    //   404: istore_2
    //   405: goto +351 -> 756
    //   408: aload 7
    //   410: astore 6
    //   412: aload 8
    //   414: iload_3
    //   415: invokevirtual 1110	com/google/android/gms/measurement/internal/zza:setMeasurementEnabled	(Z)V
    //   418: aload 7
    //   420: astore 6
    //   422: aload 8
    //   424: aload 7
    //   426: bipush 11
    //   428: invokeinterface 194 2 0
    //   433: invokevirtual 1113	com/google/android/gms/measurement/internal/zza:zzbb	(J)V
    //   436: aload 7
    //   438: astore 6
    //   440: aload 8
    //   442: aload 7
    //   444: bipush 12
    //   446: invokeinterface 194 2 0
    //   451: invokevirtual 1116	com/google/android/gms/measurement/internal/zza:zzbc	(J)V
    //   454: aload 7
    //   456: astore 6
    //   458: aload 8
    //   460: aload 7
    //   462: bipush 13
    //   464: invokeinterface 194 2 0
    //   469: invokevirtual 1119	com/google/android/gms/measurement/internal/zza:zzbd	(J)V
    //   472: aload 7
    //   474: astore 6
    //   476: aload 8
    //   478: aload 7
    //   480: bipush 14
    //   482: invokeinterface 194 2 0
    //   487: invokevirtual 1122	com/google/android/gms/measurement/internal/zza:zzbe	(J)V
    //   490: aload 7
    //   492: astore 6
    //   494: aload 8
    //   496: aload 7
    //   498: bipush 15
    //   500: invokeinterface 194 2 0
    //   505: invokevirtual 1124	com/google/android/gms/measurement/internal/zza:zzaz	(J)V
    //   508: aload 7
    //   510: astore 6
    //   512: aload 8
    //   514: aload 7
    //   516: bipush 16
    //   518: invokeinterface 194 2 0
    //   523: invokevirtual 1126	com/google/android/gms/measurement/internal/zza:zzba	(J)V
    //   526: aload 7
    //   528: astore 6
    //   530: aload 7
    //   532: bipush 17
    //   534: invokeinterface 1106 2 0
    //   539: ifeq +130 -> 669
    //   542: ldc2_w 1127
    //   545: lstore 4
    //   547: aload 7
    //   549: astore 6
    //   551: aload 8
    //   553: lload 4
    //   555: invokevirtual 1131	com/google/android/gms/measurement/internal/zza:zzav	(J)V
    //   558: aload 7
    //   560: astore 6
    //   562: aload 8
    //   564: aload 7
    //   566: bipush 18
    //   568: invokeinterface 739 2 0
    //   573: invokevirtual 1134	com/google/android/gms/measurement/internal/zza:zzlc	(Ljava/lang/String;)V
    //   576: aload 7
    //   578: astore 6
    //   580: aload 8
    //   582: aload 7
    //   584: bipush 19
    //   586: invokeinterface 194 2 0
    //   591: invokevirtual 1137	com/google/android/gms/measurement/internal/zza:zzbf	(J)V
    //   594: aload 7
    //   596: astore 6
    //   598: aload 8
    //   600: invokevirtual 1140	com/google/android/gms/measurement/internal/zza:zzbqn	()V
    //   603: aload 7
    //   605: astore 6
    //   607: aload 7
    //   609: invokeinterface 773 1 0
    //   614: ifeq +20 -> 634
    //   617: aload 7
    //   619: astore 6
    //   621: aload_0
    //   622: invokevirtual 201	com/google/android/gms/measurement/internal/zze:zzbsz	()Lcom/google/android/gms/measurement/internal/zzp;
    //   625: invokevirtual 207	com/google/android/gms/measurement/internal/zzp:zzbtr	()Lcom/google/android/gms/measurement/internal/zzp$zza;
    //   628: ldc_w 1142
    //   631: invokevirtual 256	com/google/android/gms/measurement/internal/zzp$zza:log	(Ljava/lang/String;)V
    //   634: aload 8
    //   636: astore_1
    //   637: aload 7
    //   639: ifnull -446 -> 193
    //   642: aload 7
    //   644: invokeinterface 197 1 0
    //   649: aload 8
    //   651: areturn
    //   652: aload 7
    //   654: astore 6
    //   656: aload 7
    //   658: bipush 10
    //   660: invokeinterface 933 2 0
    //   665: istore_2
    //   666: goto +90 -> 756
    //   669: aload 7
    //   671: astore 6
    //   673: aload 7
    //   675: bipush 17
    //   677: invokeinterface 933 2 0
    //   682: istore_2
    //   683: iload_2
    //   684: i2l
    //   685: lstore 4
    //   687: goto -140 -> 547
    //   690: astore 8
    //   692: aconst_null
    //   693: astore 7
    //   695: aload 7
    //   697: astore 6
    //   699: aload_0
    //   700: invokevirtual 201	com/google/android/gms/measurement/internal/zze:zzbsz	()Lcom/google/android/gms/measurement/internal/zzp;
    //   703: invokevirtual 207	com/google/android/gms/measurement/internal/zzp:zzbtr	()Lcom/google/android/gms/measurement/internal/zzp$zza;
    //   706: ldc_w 1144
    //   709: aload_1
    //   710: aload 8
    //   712: invokevirtual 215	com/google/android/gms/measurement/internal/zzp$zza:zze	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   715: aload 7
    //   717: ifnull +10 -> 727
    //   720: aload 7
    //   722: invokeinterface 197 1 0
    //   727: aconst_null
    //   728: areturn
    //   729: astore_1
    //   730: aconst_null
    //   731: astore 6
    //   733: aload 6
    //   735: ifnull +10 -> 745
    //   738: aload 6
    //   740: invokeinterface 197 1 0
    //   745: aload_1
    //   746: athrow
    //   747: astore_1
    //   748: goto -15 -> 733
    //   751: astore 8
    //   753: goto -58 -> 695
    //   756: iload_2
    //   757: ifeq +8 -> 765
    //   760: iconst_1
    //   761: istore_3
    //   762: goto -354 -> 408
    //   765: iconst_0
    //   766: istore_3
    //   767: goto -359 -> 408
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	770	0	this	zze
    //   0	770	1	paramString	String
    //   404	353	2	i	int
    //   174	593	3	bool	boolean
    //   545	141	4	l	long
    //   165	574	6	localCursor1	Cursor
    //   161	560	7	localCursor2	Cursor
    //   211	439	8	localzza	zza
    //   690	21	8	localSQLiteException1	SQLiteException
    //   751	1	8	localSQLiteException2	SQLiteException
    // Exception table:
    //   from	to	target	type
    //   13	163	690	android/database/sqlite/SQLiteException
    //   13	163	729	finally
    //   167	175	747	finally
    //   199	213	747	finally
    //   217	230	747	finally
    //   234	247	747	finally
    //   251	264	747	finally
    //   268	281	747	finally
    //   285	298	747	finally
    //   302	315	747	finally
    //   319	333	747	finally
    //   337	351	747	finally
    //   355	369	747	finally
    //   373	387	747	finally
    //   391	403	747	finally
    //   412	418	747	finally
    //   422	436	747	finally
    //   440	454	747	finally
    //   458	472	747	finally
    //   476	490	747	finally
    //   494	508	747	finally
    //   512	526	747	finally
    //   530	542	747	finally
    //   551	558	747	finally
    //   562	576	747	finally
    //   580	594	747	finally
    //   598	603	747	finally
    //   607	617	747	finally
    //   621	634	747	finally
    //   656	666	747	finally
    //   673	683	747	finally
    //   699	715	747	finally
    //   167	175	751	android/database/sqlite/SQLiteException
    //   199	213	751	android/database/sqlite/SQLiteException
    //   217	230	751	android/database/sqlite/SQLiteException
    //   234	247	751	android/database/sqlite/SQLiteException
    //   251	264	751	android/database/sqlite/SQLiteException
    //   268	281	751	android/database/sqlite/SQLiteException
    //   285	298	751	android/database/sqlite/SQLiteException
    //   302	315	751	android/database/sqlite/SQLiteException
    //   319	333	751	android/database/sqlite/SQLiteException
    //   337	351	751	android/database/sqlite/SQLiteException
    //   355	369	751	android/database/sqlite/SQLiteException
    //   373	387	751	android/database/sqlite/SQLiteException
    //   391	403	751	android/database/sqlite/SQLiteException
    //   412	418	751	android/database/sqlite/SQLiteException
    //   422	436	751	android/database/sqlite/SQLiteException
    //   440	454	751	android/database/sqlite/SQLiteException
    //   458	472	751	android/database/sqlite/SQLiteException
    //   476	490	751	android/database/sqlite/SQLiteException
    //   494	508	751	android/database/sqlite/SQLiteException
    //   512	526	751	android/database/sqlite/SQLiteException
    //   530	542	751	android/database/sqlite/SQLiteException
    //   551	558	751	android/database/sqlite/SQLiteException
    //   562	576	751	android/database/sqlite/SQLiteException
    //   580	594	751	android/database/sqlite/SQLiteException
    //   598	603	751	android/database/sqlite/SQLiteException
    //   607	617	751	android/database/sqlite/SQLiteException
    //   621	634	751	android/database/sqlite/SQLiteException
    //   656	666	751	android/database/sqlite/SQLiteException
    //   673	683	751	android/database/sqlite/SQLiteException
  }
  
  public long zzlp(String paramString)
  {
    zzab.zzhs(paramString);
    zzwu();
    zzzg();
    try
    {
      int i = getWritableDatabase().delete("raw_events", "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[] { paramString, String.valueOf(zzbtb().zzlm(paramString)) });
      return i;
    }
    catch (SQLiteException paramString)
    {
      zzbsz().zzbtr().zzj("Error deleting over the limit events", paramString);
    }
    return 0L;
  }
  
  /* Error */
  public byte[] zzlq(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 229	com/google/android/gms/common/internal/zzab:zzhs	(Ljava/lang/String;)Ljava/lang/String;
    //   4: pop
    //   5: aload_0
    //   6: invokevirtual 223	com/google/android/gms/measurement/internal/zze:zzwu	()V
    //   9: aload_0
    //   10: invokevirtual 220	com/google/android/gms/measurement/internal/zze:zzzg	()V
    //   13: aload_0
    //   14: invokevirtual 180	com/google/android/gms/measurement/internal/zze:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   17: ldc_w 414
    //   20: iconst_1
    //   21: anewarray 303	java/lang/String
    //   24: dup
    //   25: iconst_0
    //   26: ldc 78
    //   28: aastore
    //   29: ldc_w 416
    //   32: iconst_1
    //   33: anewarray 303	java/lang/String
    //   36: dup
    //   37: iconst_0
    //   38: aload_1
    //   39: aastore
    //   40: aconst_null
    //   41: aconst_null
    //   42: aconst_null
    //   43: invokevirtual 420	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   46: astore 4
    //   48: aload 4
    //   50: astore_3
    //   51: aload 4
    //   53: invokeinterface 190 1 0
    //   58: istore_2
    //   59: iload_2
    //   60: ifne +19 -> 79
    //   63: aload 4
    //   65: ifnull +10 -> 75
    //   68: aload 4
    //   70: invokeinterface 197 1 0
    //   75: aconst_null
    //   76: astore_1
    //   77: aload_1
    //   78: areturn
    //   79: aload 4
    //   81: astore_3
    //   82: aload 4
    //   84: iconst_0
    //   85: invokeinterface 760 2 0
    //   90: astore 5
    //   92: aload 4
    //   94: astore_3
    //   95: aload 4
    //   97: invokeinterface 773 1 0
    //   102: ifeq +19 -> 121
    //   105: aload 4
    //   107: astore_3
    //   108: aload_0
    //   109: invokevirtual 201	com/google/android/gms/measurement/internal/zze:zzbsz	()Lcom/google/android/gms/measurement/internal/zzp;
    //   112: invokevirtual 207	com/google/android/gms/measurement/internal/zzp:zzbtr	()Lcom/google/android/gms/measurement/internal/zzp$zza;
    //   115: ldc_w 1158
    //   118: invokevirtual 256	com/google/android/gms/measurement/internal/zzp$zza:log	(Ljava/lang/String;)V
    //   121: aload 5
    //   123: astore_1
    //   124: aload 4
    //   126: ifnull -49 -> 77
    //   129: aload 4
    //   131: invokeinterface 197 1 0
    //   136: aload 5
    //   138: areturn
    //   139: astore 5
    //   141: aconst_null
    //   142: astore 4
    //   144: aload 4
    //   146: astore_3
    //   147: aload_0
    //   148: invokevirtual 201	com/google/android/gms/measurement/internal/zze:zzbsz	()Lcom/google/android/gms/measurement/internal/zzp;
    //   151: invokevirtual 207	com/google/android/gms/measurement/internal/zzp:zzbtr	()Lcom/google/android/gms/measurement/internal/zzp$zza;
    //   154: ldc_w 1160
    //   157: aload_1
    //   158: aload 5
    //   160: invokevirtual 215	com/google/android/gms/measurement/internal/zzp$zza:zze	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   163: aload 4
    //   165: ifnull +10 -> 175
    //   168: aload 4
    //   170: invokeinterface 197 1 0
    //   175: aconst_null
    //   176: areturn
    //   177: astore_1
    //   178: aconst_null
    //   179: astore_3
    //   180: aload_3
    //   181: ifnull +9 -> 190
    //   184: aload_3
    //   185: invokeinterface 197 1 0
    //   190: aload_1
    //   191: athrow
    //   192: astore_1
    //   193: goto -13 -> 180
    //   196: astore 5
    //   198: goto -54 -> 144
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	201	0	this	zze
    //   0	201	1	paramString	String
    //   58	2	2	bool	boolean
    //   50	135	3	localCursor1	Cursor
    //   46	123	4	localCursor2	Cursor
    //   90	47	5	arrayOfByte	byte[]
    //   139	20	5	localSQLiteException1	SQLiteException
    //   196	1	5	localSQLiteException2	SQLiteException
    // Exception table:
    //   from	to	target	type
    //   13	48	139	android/database/sqlite/SQLiteException
    //   13	48	177	finally
    //   51	59	192	finally
    //   82	92	192	finally
    //   95	105	192	finally
    //   108	121	192	finally
    //   147	163	192	finally
    //   51	59	196	android/database/sqlite/SQLiteException
    //   82	92	196	android/database/sqlite/SQLiteException
    //   95	105	196	android/database/sqlite/SQLiteException
    //   108	121	196	android/database/sqlite/SQLiteException
  }
  
  void zzlr(String paramString)
  {
    zzzg();
    zzwu();
    zzab.zzhs(paramString);
    SQLiteDatabase localSQLiteDatabase = getWritableDatabase();
    localSQLiteDatabase.delete("property_filters", "app_id=?", new String[] { paramString });
    localSQLiteDatabase.delete("event_filters", "app_id=?", new String[] { paramString });
  }
  
  /* Error */
  Map<Integer, com.google.android.gms.internal.zzup.zzf> zzls(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 220	com/google/android/gms/measurement/internal/zze:zzzg	()V
    //   4: aload_0
    //   5: invokevirtual 223	com/google/android/gms/measurement/internal/zze:zzwu	()V
    //   8: aload_1
    //   9: invokestatic 229	com/google/android/gms/common/internal/zzab:zzhs	(Ljava/lang/String;)Ljava/lang/String;
    //   12: pop
    //   13: aload_0
    //   14: invokevirtual 180	com/google/android/gms/measurement/internal/zze:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   17: astore 4
    //   19: aload 4
    //   21: ldc_w 723
    //   24: iconst_2
    //   25: anewarray 303	java/lang/String
    //   28: dup
    //   29: iconst_0
    //   30: ldc_w 332
    //   33: aastore
    //   34: dup
    //   35: iconst_1
    //   36: ldc_w 721
    //   39: aastore
    //   40: ldc_w 416
    //   43: iconst_1
    //   44: anewarray 303	java/lang/String
    //   47: dup
    //   48: iconst_0
    //   49: aload_1
    //   50: aastore
    //   51: aconst_null
    //   52: aconst_null
    //   53: aconst_null
    //   54: invokevirtual 420	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   57: astore 4
    //   59: aload 4
    //   61: invokeinterface 190 1 0
    //   66: istore_3
    //   67: iload_3
    //   68: ifne +17 -> 85
    //   71: aload 4
    //   73: ifnull +10 -> 83
    //   76: aload 4
    //   78: invokeinterface 197 1 0
    //   83: aconst_null
    //   84: areturn
    //   85: new 24	android/support/v4/util/ArrayMap
    //   88: dup
    //   89: invokespecial 921	android/support/v4/util/ArrayMap:<init>	()V
    //   92: astore 5
    //   94: aload 4
    //   96: iconst_0
    //   97: invokeinterface 933 2 0
    //   102: istore_2
    //   103: aload 4
    //   105: iconst_1
    //   106: invokeinterface 760 2 0
    //   111: invokestatic 766	com/google/android/gms/internal/zzaou:zzaz	([B)Lcom/google/android/gms/internal/zzaou;
    //   114: astore 7
    //   116: new 717	com/google/android/gms/internal/zzup$zzf
    //   119: dup
    //   120: invokespecial 1163	com/google/android/gms/internal/zzup$zzf:<init>	()V
    //   123: astore 6
    //   125: aload 6
    //   127: aload 7
    //   129: invokevirtual 1164	com/google/android/gms/internal/zzup$zzf:zzb	(Lcom/google/android/gms/internal/zzaou;)Lcom/google/android/gms/internal/zzapc;
    //   132: checkcast 717	com/google/android/gms/internal/zzup$zzf
    //   135: astore 7
    //   137: aload 5
    //   139: iload_2
    //   140: invokestatic 301	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   143: aload 6
    //   145: invokeinterface 40 3 0
    //   150: pop
    //   151: aload 4
    //   153: invokeinterface 773 1 0
    //   158: istore_3
    //   159: iload_3
    //   160: ifne -66 -> 94
    //   163: aload 4
    //   165: ifnull +10 -> 175
    //   168: aload 4
    //   170: invokeinterface 197 1 0
    //   175: aload 5
    //   177: areturn
    //   178: astore 6
    //   180: aload_0
    //   181: invokevirtual 201	com/google/android/gms/measurement/internal/zze:zzbsz	()Lcom/google/android/gms/measurement/internal/zzp;
    //   184: invokevirtual 207	com/google/android/gms/measurement/internal/zzp:zzbtr	()Lcom/google/android/gms/measurement/internal/zzp$zza;
    //   187: ldc_w 1166
    //   190: aload_1
    //   191: iload_2
    //   192: invokestatic 301	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   195: aload 6
    //   197: invokevirtual 903	com/google/android/gms/measurement/internal/zzp$zza:zzd	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   200: goto -49 -> 151
    //   203: astore 5
    //   205: aload 4
    //   207: astore_1
    //   208: aload 5
    //   210: astore 4
    //   212: aload_0
    //   213: invokevirtual 201	com/google/android/gms/measurement/internal/zze:zzbsz	()Lcom/google/android/gms/measurement/internal/zzp;
    //   216: invokevirtual 207	com/google/android/gms/measurement/internal/zzp:zzbtr	()Lcom/google/android/gms/measurement/internal/zzp$zza;
    //   219: ldc_w 1168
    //   222: aload 4
    //   224: invokevirtual 360	com/google/android/gms/measurement/internal/zzp$zza:zzj	(Ljava/lang/String;Ljava/lang/Object;)V
    //   227: aload_1
    //   228: ifnull +9 -> 237
    //   231: aload_1
    //   232: invokeinterface 197 1 0
    //   237: aconst_null
    //   238: areturn
    //   239: astore_1
    //   240: aconst_null
    //   241: astore 4
    //   243: aload 4
    //   245: ifnull +10 -> 255
    //   248: aload 4
    //   250: invokeinterface 197 1 0
    //   255: aload_1
    //   256: athrow
    //   257: astore_1
    //   258: goto -15 -> 243
    //   261: astore 5
    //   263: aload_1
    //   264: astore 4
    //   266: aload 5
    //   268: astore_1
    //   269: goto -26 -> 243
    //   272: astore 4
    //   274: aconst_null
    //   275: astore_1
    //   276: goto -64 -> 212
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	279	0	this	zze
    //   0	279	1	paramString	String
    //   102	90	2	i	int
    //   66	94	3	bool	boolean
    //   17	248	4	localObject1	Object
    //   272	1	4	localSQLiteException1	SQLiteException
    //   92	84	5	localArrayMap	ArrayMap
    //   203	6	5	localSQLiteException2	SQLiteException
    //   261	6	5	localObject2	Object
    //   123	21	6	localzzf	com.google.android.gms.internal.zzup.zzf
    //   178	18	6	localIOException	IOException
    //   114	22	7	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   125	137	178	java/io/IOException
    //   59	67	203	android/database/sqlite/SQLiteException
    //   85	94	203	android/database/sqlite/SQLiteException
    //   94	125	203	android/database/sqlite/SQLiteException
    //   125	137	203	android/database/sqlite/SQLiteException
    //   137	151	203	android/database/sqlite/SQLiteException
    //   151	159	203	android/database/sqlite/SQLiteException
    //   180	200	203	android/database/sqlite/SQLiteException
    //   19	59	239	finally
    //   59	67	257	finally
    //   85	94	257	finally
    //   94	125	257	finally
    //   125	137	257	finally
    //   137	151	257	finally
    //   151	159	257	finally
    //   180	200	257	finally
    //   212	227	261	finally
    //   19	59	272	android/database/sqlite/SQLiteException
  }
  
  void zzlt(String paramString)
  {
    zzzg();
    zzwu();
    zzab.zzhs(paramString);
    try
    {
      SQLiteDatabase localSQLiteDatabase = getWritableDatabase();
      String[] arrayOfString = new String[1];
      arrayOfString[0] = paramString;
      int i = localSQLiteDatabase.delete("events", "app_id=?", arrayOfString);
      int j = localSQLiteDatabase.delete("user_attributes", "app_id=?", arrayOfString);
      int k = localSQLiteDatabase.delete("apps", "app_id=?", arrayOfString);
      int m = localSQLiteDatabase.delete("raw_events", "app_id=?", arrayOfString);
      int n = localSQLiteDatabase.delete("raw_events_metadata", "app_id=?", arrayOfString);
      int i1 = localSQLiteDatabase.delete("event_filters", "app_id=?", arrayOfString);
      int i2 = localSQLiteDatabase.delete("property_filters", "app_id=?", arrayOfString);
      i = localSQLiteDatabase.delete("audience_filter_values", "app_id=?", arrayOfString) + (i + 0 + j + k + m + n + i1 + i2);
      if (i > 0) {
        zzbsz().zzbty().zze("Deleted application data. app, records", paramString, Integer.valueOf(i));
      }
      return;
    }
    catch (SQLiteException localSQLiteException)
    {
      zzbsz().zzbtr().zze("Error deleting application data. appId, error", paramString, localSQLiteException);
    }
  }
  
  public void zzlu(String paramString)
  {
    SQLiteDatabase localSQLiteDatabase = getWritableDatabase();
    try
    {
      localSQLiteDatabase.execSQL("delete from raw_events_metadata where app_id=? and metadata_fingerprint not in (select distinct metadata_fingerprint from raw_events where app_id=?)", new String[] { paramString, paramString });
      return;
    }
    catch (SQLiteException paramString)
    {
      zzbsz().zzbtr().zzj("Failed to remove unused event metadata", paramString);
    }
  }
  
  public long zzlv(String paramString)
  {
    zzab.zzhs(paramString);
    return zza("select count(1) from events where app_id=? and name not like '!_%' escape '!'", new String[] { paramString }, 0L);
  }
  
  /* Error */
  public List<android.util.Pair<zzup.zze, Long>> zzn(String paramString, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 6
    //   3: aload_0
    //   4: invokevirtual 223	com/google/android/gms/measurement/internal/zze:zzwu	()V
    //   7: aload_0
    //   8: invokevirtual 220	com/google/android/gms/measurement/internal/zze:zzzg	()V
    //   11: iload_2
    //   12: ifle +112 -> 124
    //   15: iconst_1
    //   16: istore 5
    //   18: iload 5
    //   20: invokestatic 1191	com/google/android/gms/common/internal/zzab:zzbn	(Z)V
    //   23: iload_3
    //   24: ifle +106 -> 130
    //   27: iload 6
    //   29: istore 5
    //   31: iload 5
    //   33: invokestatic 1191	com/google/android/gms/common/internal/zzab:zzbn	(Z)V
    //   36: aload_1
    //   37: invokestatic 229	com/google/android/gms/common/internal/zzab:zzhs	(Ljava/lang/String;)Ljava/lang/String;
    //   40: pop
    //   41: aload_0
    //   42: invokevirtual 180	com/google/android/gms/measurement/internal/zze:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   45: ldc_w 513
    //   48: iconst_2
    //   49: anewarray 303	java/lang/String
    //   52: dup
    //   53: iconst_0
    //   54: ldc_w 747
    //   57: aastore
    //   58: dup
    //   59: iconst_1
    //   60: ldc_w 341
    //   63: aastore
    //   64: ldc_w 416
    //   67: iconst_1
    //   68: anewarray 303	java/lang/String
    //   71: dup
    //   72: iconst_0
    //   73: aload_1
    //   74: aastore
    //   75: aconst_null
    //   76: aconst_null
    //   77: ldc_w 747
    //   80: iload_2
    //   81: invokestatic 1061	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   84: invokevirtual 752	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   87: astore 9
    //   89: aload 9
    //   91: invokeinterface 190 1 0
    //   96: ifne +40 -> 136
    //   99: invokestatic 1195	java/util/Collections:emptyList	()Ljava/util/List;
    //   102: astore 10
    //   104: aload 10
    //   106: astore_1
    //   107: aload 9
    //   109: ifnull +13 -> 122
    //   112: aload 9
    //   114: invokeinterface 197 1 0
    //   119: aload 10
    //   121: astore_1
    //   122: aload_1
    //   123: areturn
    //   124: iconst_0
    //   125: istore 5
    //   127: goto -109 -> 18
    //   130: iconst_0
    //   131: istore 5
    //   133: goto -102 -> 31
    //   136: new 937	java/util/ArrayList
    //   139: dup
    //   140: invokespecial 938	java/util/ArrayList:<init>	()V
    //   143: astore 10
    //   145: iconst_0
    //   146: istore_2
    //   147: aload 9
    //   149: iconst_0
    //   150: invokeinterface 194 2 0
    //   155: lstore 7
    //   157: aload 9
    //   159: iconst_1
    //   160: invokeinterface 760 2 0
    //   165: astore 11
    //   167: aload_0
    //   168: invokevirtual 499	com/google/android/gms/measurement/internal/zze:zzbsv	()Lcom/google/android/gms/measurement/internal/zzal;
    //   171: aload 11
    //   173: invokevirtual 1198	com/google/android/gms/measurement/internal/zzal:zzab	([B)[B
    //   176: astore 11
    //   178: aload 10
    //   180: invokeinterface 1200 1 0
    //   185: ifne +67 -> 252
    //   188: aload 11
    //   190: arraylength
    //   191: istore 4
    //   193: iload 4
    //   195: iload_2
    //   196: iadd
    //   197: iload_3
    //   198: if_icmple +54 -> 252
    //   201: aload 9
    //   203: ifnull +10 -> 213
    //   206: aload 9
    //   208: invokeinterface 197 1 0
    //   213: aload 10
    //   215: areturn
    //   216: astore 11
    //   218: aload_0
    //   219: invokevirtual 201	com/google/android/gms/measurement/internal/zze:zzbsz	()Lcom/google/android/gms/measurement/internal/zzp;
    //   222: invokevirtual 207	com/google/android/gms/measurement/internal/zzp:zzbtr	()Lcom/google/android/gms/measurement/internal/zzp$zza;
    //   225: ldc_w 1202
    //   228: aload_1
    //   229: aload 11
    //   231: invokevirtual 215	com/google/android/gms/measurement/internal/zzp$zza:zze	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   234: aload 9
    //   236: invokeinterface 773 1 0
    //   241: ifeq -40 -> 201
    //   244: iload_2
    //   245: iload_3
    //   246: if_icmpgt -45 -> 201
    //   249: goto -102 -> 147
    //   252: aload 11
    //   254: invokestatic 766	com/google/android/gms/internal/zzaou:zzaz	([B)Lcom/google/android/gms/internal/zzaou;
    //   257: astore 13
    //   259: new 463	com/google/android/gms/internal/zzup$zze
    //   262: dup
    //   263: invokespecial 767	com/google/android/gms/internal/zzup$zze:<init>	()V
    //   266: astore 12
    //   268: aload 12
    //   270: aload 13
    //   272: invokevirtual 770	com/google/android/gms/internal/zzup$zze:zzb	(Lcom/google/android/gms/internal/zzaou;)Lcom/google/android/gms/internal/zzapc;
    //   275: checkcast 463	com/google/android/gms/internal/zzup$zze
    //   278: astore 13
    //   280: aload 11
    //   282: arraylength
    //   283: iload_2
    //   284: iadd
    //   285: istore_2
    //   286: aload 10
    //   288: aload 12
    //   290: lload 7
    //   292: invokestatic 440	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   295: invokestatic 1208	android/util/Pair:create	(Ljava/lang/Object;Ljava/lang/Object;)Landroid/util/Pair;
    //   298: invokeinterface 942 2 0
    //   303: pop
    //   304: goto -70 -> 234
    //   307: astore 10
    //   309: aload_0
    //   310: invokevirtual 201	com/google/android/gms/measurement/internal/zze:zzbsz	()Lcom/google/android/gms/measurement/internal/zzp;
    //   313: invokevirtual 207	com/google/android/gms/measurement/internal/zzp:zzbtr	()Lcom/google/android/gms/measurement/internal/zzp$zza;
    //   316: ldc_w 1210
    //   319: aload_1
    //   320: aload 10
    //   322: invokevirtual 215	com/google/android/gms/measurement/internal/zzp$zza:zze	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   325: invokestatic 1195	java/util/Collections:emptyList	()Ljava/util/List;
    //   328: astore 10
    //   330: aload 10
    //   332: astore_1
    //   333: aload 9
    //   335: ifnull -213 -> 122
    //   338: aload 9
    //   340: invokeinterface 197 1 0
    //   345: aload 10
    //   347: areturn
    //   348: astore 11
    //   350: aload_0
    //   351: invokevirtual 201	com/google/android/gms/measurement/internal/zze:zzbsz	()Lcom/google/android/gms/measurement/internal/zzp;
    //   354: invokevirtual 207	com/google/android/gms/measurement/internal/zzp:zzbtr	()Lcom/google/android/gms/measurement/internal/zzp$zza;
    //   357: ldc_w 1212
    //   360: aload_1
    //   361: aload 11
    //   363: invokevirtual 215	com/google/android/gms/measurement/internal/zzp$zza:zze	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   366: goto -132 -> 234
    //   369: astore_1
    //   370: aconst_null
    //   371: astore 9
    //   373: aload 9
    //   375: ifnull +10 -> 385
    //   378: aload 9
    //   380: invokeinterface 197 1 0
    //   385: aload_1
    //   386: athrow
    //   387: astore_1
    //   388: goto -15 -> 373
    //   391: astore_1
    //   392: goto -19 -> 373
    //   395: astore 10
    //   397: aconst_null
    //   398: astore 9
    //   400: goto -91 -> 309
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	403	0	this	zze
    //   0	403	1	paramString	String
    //   0	403	2	paramInt1	int
    //   0	403	3	paramInt2	int
    //   191	6	4	i	int
    //   16	116	5	bool1	boolean
    //   1	27	6	bool2	boolean
    //   155	136	7	l	long
    //   87	312	9	localCursor	Cursor
    //   102	185	10	localObject1	Object
    //   307	14	10	localSQLiteException1	SQLiteException
    //   328	18	10	localList	List
    //   395	1	10	localSQLiteException2	SQLiteException
    //   165	24	11	arrayOfByte	byte[]
    //   216	65	11	localIOException1	IOException
    //   348	14	11	localIOException2	IOException
    //   266	23	12	localzze	zzup.zze
    //   257	22	13	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   157	178	216	java/io/IOException
    //   89	104	307	android/database/sqlite/SQLiteException
    //   136	145	307	android/database/sqlite/SQLiteException
    //   147	157	307	android/database/sqlite/SQLiteException
    //   157	178	307	android/database/sqlite/SQLiteException
    //   178	193	307	android/database/sqlite/SQLiteException
    //   218	234	307	android/database/sqlite/SQLiteException
    //   234	244	307	android/database/sqlite/SQLiteException
    //   252	268	307	android/database/sqlite/SQLiteException
    //   268	280	307	android/database/sqlite/SQLiteException
    //   280	304	307	android/database/sqlite/SQLiteException
    //   350	366	307	android/database/sqlite/SQLiteException
    //   268	280	348	java/io/IOException
    //   41	89	369	finally
    //   89	104	387	finally
    //   136	145	387	finally
    //   147	157	387	finally
    //   157	178	387	finally
    //   178	193	387	finally
    //   218	234	387	finally
    //   234	244	387	finally
    //   252	268	387	finally
    //   268	280	387	finally
    //   280	304	387	finally
    //   350	366	387	finally
    //   309	330	391	finally
    //   41	89	395	android/database/sqlite/SQLiteException
  }
  
  protected void zzwv() {}
  
  public void zzy(String paramString, int paramInt)
  {
    zzab.zzhs(paramString);
    zzwu();
    zzzg();
    try
    {
      getWritableDatabase().execSQL("delete from user_attributes where app_id=? and name in (select name from user_attributes where app_id=? and name like '_ltv_%' order by set_timestamp desc limit ?,10);", new String[] { paramString, paramString, String.valueOf(paramInt) });
      return;
    }
    catch (SQLiteException localSQLiteException)
    {
      zzbsz().zzbtr().zze("Error pruning currencies", paramString, localSQLiteException);
    }
  }
  
  void zzz(String paramString, int paramInt)
  {
    zzzg();
    zzwu();
    zzab.zzhs(paramString);
    SQLiteDatabase localSQLiteDatabase = getWritableDatabase();
    localSQLiteDatabase.delete("property_filters", "app_id=? and audience_id=?", new String[] { paramString, String.valueOf(paramInt) });
    localSQLiteDatabase.delete("event_filters", "app_id=? and audience_id=?", new String[] { paramString, String.valueOf(paramInt) });
  }
  
  public static class zza
  {
    long ajM;
    long ajN;
    long ajO;
    long ajP;
  }
  
  static abstract interface zzb
  {
    public abstract boolean zza(long paramLong, zzup.zzb paramzzb);
    
    public abstract void zzc(zzup.zze paramzze);
  }
  
  private class zzc
    extends SQLiteOpenHelper
  {
    zzc(Context paramContext, String paramString)
    {
      super(paramString, null, 1);
    }
    
    private void zza(SQLiteDatabase paramSQLiteDatabase, String paramString1, String paramString2, String paramString3, Map<String, String> paramMap)
      throws SQLiteException
    {
      if (!zzb(paramSQLiteDatabase, paramString1)) {
        paramSQLiteDatabase.execSQL(paramString2);
      }
      try
      {
        zza(paramSQLiteDatabase, paramString1, paramString3, paramMap);
        return;
      }
      catch (SQLiteException paramSQLiteDatabase)
      {
        zzbsz().zzbtr().zzj("Failed to verify columns on table that was just created", paramString1);
        throw paramSQLiteDatabase;
      }
    }
    
    private void zza(SQLiteDatabase paramSQLiteDatabase, String paramString1, String paramString2, Map<String, String> paramMap)
      throws SQLiteException
    {
      Set localSet = zzc(paramSQLiteDatabase, paramString1);
      paramString2 = paramString2.split(",");
      int j = paramString2.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramString2[i];
        if (!localSet.remove(localObject)) {
          throw new SQLiteException(String.valueOf(paramString1).length() + 35 + String.valueOf(localObject).length() + "Table " + paramString1 + " is missing required column: " + (String)localObject);
        }
        i += 1;
      }
      if (paramMap != null)
      {
        paramString2 = paramMap.entrySet().iterator();
        while (paramString2.hasNext())
        {
          paramMap = (Map.Entry)paramString2.next();
          if (!localSet.remove(paramMap.getKey())) {
            paramSQLiteDatabase.execSQL((String)paramMap.getValue());
          }
        }
      }
      if (!localSet.isEmpty()) {
        throw new SQLiteException(String.valueOf(paramString1).length() + 30 + "Table " + paramString1 + " table has extra columns");
      }
    }
    
    /* Error */
    private boolean zzb(SQLiteDatabase paramSQLiteDatabase, String paramString)
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore 4
      //   3: aload_1
      //   4: ldc -121
      //   6: iconst_1
      //   7: anewarray 62	java/lang/String
      //   10: dup
      //   11: iconst_0
      //   12: ldc -119
      //   14: aastore
      //   15: ldc -117
      //   17: iconst_1
      //   18: anewarray 62	java/lang/String
      //   21: dup
      //   22: iconst_0
      //   23: aload_2
      //   24: aastore
      //   25: aconst_null
      //   26: aconst_null
      //   27: aconst_null
      //   28: invokevirtual 143	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
      //   31: astore_1
      //   32: aload_1
      //   33: astore 4
      //   35: aload 4
      //   37: astore_1
      //   38: aload 4
      //   40: invokeinterface 148 1 0
      //   45: istore_3
      //   46: aload 4
      //   48: ifnull +10 -> 58
      //   51: aload 4
      //   53: invokeinterface 152 1 0
      //   58: iload_3
      //   59: ireturn
      //   60: astore 5
      //   62: aconst_null
      //   63: astore 4
      //   65: aload 4
      //   67: astore_1
      //   68: aload_0
      //   69: getfield 13	com/google/android/gms/measurement/internal/zze$zzc:ajQ	Lcom/google/android/gms/measurement/internal/zze;
      //   72: invokevirtual 38	com/google/android/gms/measurement/internal/zze:zzbsz	()Lcom/google/android/gms/measurement/internal/zzp;
      //   75: invokevirtual 155	com/google/android/gms/measurement/internal/zzp:zzbtt	()Lcom/google/android/gms/measurement/internal/zzp$zza;
      //   78: ldc -99
      //   80: aload_2
      //   81: aload 5
      //   83: invokevirtual 161	com/google/android/gms/measurement/internal/zzp$zza:zze	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
      //   86: aload 4
      //   88: ifnull +10 -> 98
      //   91: aload 4
      //   93: invokeinterface 152 1 0
      //   98: iconst_0
      //   99: ireturn
      //   100: astore_1
      //   101: aload 4
      //   103: astore_2
      //   104: aload_2
      //   105: ifnull +9 -> 114
      //   108: aload_2
      //   109: invokeinterface 152 1 0
      //   114: aload_1
      //   115: athrow
      //   116: astore 4
      //   118: aload_1
      //   119: astore_2
      //   120: aload 4
      //   122: astore_1
      //   123: goto -19 -> 104
      //   126: astore 5
      //   128: goto -63 -> 65
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	131	0	this	zzc
      //   0	131	1	paramSQLiteDatabase	SQLiteDatabase
      //   0	131	2	paramString	String
      //   45	14	3	bool	boolean
      //   1	101	4	localSQLiteDatabase	SQLiteDatabase
      //   116	5	4	localObject	Object
      //   60	22	5	localSQLiteException1	SQLiteException
      //   126	1	5	localSQLiteException2	SQLiteException
      // Exception table:
      //   from	to	target	type
      //   3	32	60	android/database/sqlite/SQLiteException
      //   3	32	100	finally
      //   38	46	116	finally
      //   68	86	116	finally
      //   38	46	126	android/database/sqlite/SQLiteException
    }
    
    private Set<String> zzc(SQLiteDatabase paramSQLiteDatabase, String paramString)
    {
      HashSet localHashSet = new HashSet();
      paramSQLiteDatabase = paramSQLiteDatabase.rawQuery(String.valueOf(paramString).length() + 22 + "SELECT * FROM " + paramString + " LIMIT 0", null);
      try
      {
        Collections.addAll(localHashSet, paramSQLiteDatabase.getColumnNames());
        return localHashSet;
      }
      finally
      {
        paramSQLiteDatabase.close();
      }
    }
    
    public SQLiteDatabase getWritableDatabase()
    {
      if (!zze.zza(zze.this).zzx(zzbtb().zzbrw())) {
        throw new SQLiteException("Database open failed");
      }
      try
      {
        SQLiteDatabase localSQLiteDatabase = super.getWritableDatabase();
        return localSQLiteDatabase;
      }
      catch (SQLiteException localSQLiteException1)
      {
        zze.zza(zze.this).start();
        zzbsz().zzbtr().log("Opening the database failed, dropping and recreating it");
        Object localObject = zzaab();
        getContext().getDatabasePath((String)localObject).delete();
        try
        {
          localObject = super.getWritableDatabase();
          zze.zza(zze.this).clear();
          return (SQLiteDatabase)localObject;
        }
        catch (SQLiteException localSQLiteException2)
        {
          zzbsz().zzbtr().zzj("Failed to open freshly created database", localSQLiteException2);
          throw localSQLiteException2;
        }
      }
    }
    
    public void onCreate(SQLiteDatabase paramSQLiteDatabase)
    {
      if (Build.VERSION.SDK_INT >= 9)
      {
        paramSQLiteDatabase = new File(paramSQLiteDatabase.getPath());
        paramSQLiteDatabase.setReadable(false, false);
        paramSQLiteDatabase.setWritable(false, false);
        paramSQLiteDatabase.setReadable(true, true);
        paramSQLiteDatabase.setWritable(true, true);
      }
    }
    
    public void onOpen(SQLiteDatabase paramSQLiteDatabase)
    {
      Cursor localCursor;
      if (Build.VERSION.SDK_INT < 15) {
        localCursor = paramSQLiteDatabase.rawQuery("PRAGMA journal_mode=memory", null);
      }
      try
      {
        localCursor.moveToFirst();
        localCursor.close();
        zza(paramSQLiteDatabase, "events", "CREATE TABLE IF NOT EXISTS events ( app_id TEXT NOT NULL, name TEXT NOT NULL, lifetime_count INTEGER NOT NULL, current_bundle_count INTEGER NOT NULL, last_fire_timestamp INTEGER NOT NULL, PRIMARY KEY (app_id, name)) ;", "app_id,name,lifetime_count,current_bundle_count,last_fire_timestamp", null);
        zza(paramSQLiteDatabase, "user_attributes", "CREATE TABLE IF NOT EXISTS user_attributes ( app_id TEXT NOT NULL, name TEXT NOT NULL, set_timestamp INTEGER NOT NULL, value BLOB NOT NULL, PRIMARY KEY (app_id, name)) ;", "app_id,name,set_timestamp,value", null);
        zza(paramSQLiteDatabase, "apps", "CREATE TABLE IF NOT EXISTS apps ( app_id TEXT NOT NULL, app_instance_id TEXT, gmp_app_id TEXT, resettable_device_id_hash TEXT, last_bundle_index INTEGER NOT NULL, last_bundle_end_timestamp INTEGER NOT NULL, PRIMARY KEY (app_id)) ;", "app_id,app_instance_id,gmp_app_id,resettable_device_id_hash,last_bundle_index,last_bundle_end_timestamp", zze.zzbtj());
        zza(paramSQLiteDatabase, "queue", "CREATE TABLE IF NOT EXISTS queue ( app_id TEXT NOT NULL, bundle_end_timestamp INTEGER NOT NULL, data BLOB NOT NULL);", "app_id,bundle_end_timestamp,data", null);
        zza(paramSQLiteDatabase, "raw_events_metadata", "CREATE TABLE IF NOT EXISTS raw_events_metadata ( app_id TEXT NOT NULL, metadata_fingerprint INTEGER NOT NULL, metadata BLOB NOT NULL, PRIMARY KEY (app_id, metadata_fingerprint));", "app_id,metadata_fingerprint,metadata", null);
        zza(paramSQLiteDatabase, "raw_events", "CREATE TABLE IF NOT EXISTS raw_events ( app_id TEXT NOT NULL, name TEXT NOT NULL, timestamp INTEGER NOT NULL, metadata_fingerprint INTEGER NOT NULL, data BLOB NOT NULL);", "app_id,name,timestamp,metadata_fingerprint,data", null);
        zza(paramSQLiteDatabase, "event_filters", "CREATE TABLE IF NOT EXISTS event_filters ( app_id TEXT NOT NULL, audience_id INTEGER NOT NULL, filter_id INTEGER NOT NULL, event_name TEXT NOT NULL, data BLOB NOT NULL, PRIMARY KEY (app_id, event_name, audience_id, filter_id));", "app_id,audience_id,filter_id,event_name,data", null);
        zza(paramSQLiteDatabase, "property_filters", "CREATE TABLE IF NOT EXISTS property_filters ( app_id TEXT NOT NULL, audience_id INTEGER NOT NULL, filter_id INTEGER NOT NULL, property_name TEXT NOT NULL, data BLOB NOT NULL, PRIMARY KEY (app_id, property_name, audience_id, filter_id));", "app_id,audience_id,filter_id,property_name,data", null);
        zza(paramSQLiteDatabase, "audience_filter_values", "CREATE TABLE IF NOT EXISTS audience_filter_values ( app_id TEXT NOT NULL, audience_id INTEGER NOT NULL, current_results BLOB, PRIMARY KEY (app_id, audience_id));", "app_id,audience_id,current_results", null);
        return;
      }
      finally
      {
        localCursor.close();
      }
    }
    
    public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.measurement.internal.zze
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */