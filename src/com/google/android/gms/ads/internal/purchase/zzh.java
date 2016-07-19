package com.google.android.gms.ads.internal.purchase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.SystemClock;
import com.google.android.gms.internal.zzir;
import com.google.android.gms.internal.zzkh;
import java.util.Locale;

@zzir
public class zzh
{
  private static final Object zzail = new Object();
  private static final String zzbxo = String.format(Locale.US, "CREATE TABLE IF NOT EXISTS %s ( %s INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, %s TEXT NOT NULL, %s TEXT NOT NULL, %s INTEGER)", new Object[] { "InAppPurchase", "purchase_id", "product_id", "developer_payload", "record_time" });
  private static zzh zzbxq;
  private final zza zzbxp;
  
  zzh(Context paramContext)
  {
    zzbxp = new zza(paramContext, "google_inapp_purchase.db");
  }
  
  public static zzh zzs(Context paramContext)
  {
    synchronized (zzail)
    {
      if (zzbxq == null) {
        zzbxq = new zzh(paramContext);
      }
      paramContext = zzbxq;
      return paramContext;
    }
  }
  
  public int getRecordCount()
  {
    localObject4 = null;
    Object localObject1 = null;
    Object localObject5;
    synchronized (zzail)
    {
      localObject5 = getWritableDatabase();
      if (localObject5 == null) {
        return 0;
      }
    }
    try
    {
      localObject5 = ((SQLiteDatabase)localObject5).rawQuery("select count(*) from InAppPurchase", null);
      localObject1 = localObject5;
      localObject4 = localObject5;
      if (((Cursor)localObject5).moveToFirst())
      {
        localObject1 = localObject5;
        localObject4 = localObject5;
        int i = ((Cursor)localObject5).getInt(0);
        if (localObject5 != null) {
          ((Cursor)localObject5).close();
        }
        return i;
        localObject2 = finally;
        throw ((Throwable)localObject2);
      }
    }
    catch (SQLiteException localSQLiteException)
    {
      localObject4 = localObject2;
      String str = String.valueOf(localSQLiteException.getMessage());
      localObject4 = localObject2;
      if (str.length() == 0) {
        break label164;
      }
      localObject4 = localObject2;
      for (str = "Error getting record count".concat(str);; str = new String("Error getting record count"))
      {
        localObject4 = localObject2;
        zzkh.zzcy(str);
        if (localObject2 == null) {
          break;
        }
        ((Cursor)localObject2).close();
        break;
        localObject4 = localObject2;
      }
    }
    finally
    {
      if (localObject4 == null) {
        break label191;
      }
      ((Cursor)localObject4).close();
    }
    return 0;
  }
  
  public SQLiteDatabase getWritableDatabase()
  {
    try
    {
      SQLiteDatabase localSQLiteDatabase = zzbxp.getWritableDatabase();
      return localSQLiteDatabase;
    }
    catch (SQLiteException localSQLiteException)
    {
      zzkh.zzcy("Error opening writable conversion tracking database");
    }
    return null;
  }
  
  public zzf zza(Cursor paramCursor)
  {
    if (paramCursor == null) {
      return null;
    }
    return new zzf(paramCursor.getLong(0), paramCursor.getString(1), paramCursor.getString(2));
  }
  
  public void zza(zzf paramzzf)
  {
    if (paramzzf == null) {
      return;
    }
    SQLiteDatabase localSQLiteDatabase;
    synchronized (zzail)
    {
      localSQLiteDatabase = getWritableDatabase();
      if (localSQLiteDatabase == null) {
        return;
      }
    }
    localSQLiteDatabase.delete("InAppPurchase", String.format(Locale.US, "%s = %d", new Object[] { "purchase_id", Long.valueOf(zzbxj) }), null);
  }
  
  public void zzb(zzf paramzzf)
  {
    if (paramzzf == null) {
      return;
    }
    SQLiteDatabase localSQLiteDatabase;
    synchronized (zzail)
    {
      localSQLiteDatabase = getWritableDatabase();
      if (localSQLiteDatabase == null) {
        return;
      }
    }
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("product_id", zzbxl);
    localContentValues.put("developer_payload", zzbxk);
    localContentValues.put("record_time", Long.valueOf(SystemClock.elapsedRealtime()));
    zzbxj = localSQLiteDatabase.insert("InAppPurchase", null, localContentValues);
    if (getRecordCount() > 20000L) {
      zzpu();
    }
  }
  
  /* Error */
  public java.util.List<zzf> zzg(long paramLong)
  {
    // Byte code:
    //   0: getstatic 49	com/google/android/gms/ads/internal/purchase/zzh:zzail	Ljava/lang/Object;
    //   3: astore 7
    //   5: aload 7
    //   7: monitorenter
    //   8: new 190	java/util/LinkedList
    //   11: dup
    //   12: invokespecial 191	java/util/LinkedList:<init>	()V
    //   15: astore 8
    //   17: lload_1
    //   18: lconst_0
    //   19: lcmp
    //   20: ifgt +9 -> 29
    //   23: aload 7
    //   25: monitorexit
    //   26: aload 8
    //   28: areturn
    //   29: aload_0
    //   30: invokevirtual 74	com/google/android/gms/ads/internal/purchase/zzh:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   33: astore 4
    //   35: aload 4
    //   37: ifnonnull +9 -> 46
    //   40: aload 7
    //   42: monitorexit
    //   43: aload 8
    //   45: areturn
    //   46: aload 4
    //   48: ldc 28
    //   50: aconst_null
    //   51: aconst_null
    //   52: aconst_null
    //   53: aconst_null
    //   54: aconst_null
    //   55: ldc -63
    //   57: lload_1
    //   58: invokestatic 196	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   61: invokevirtual 200	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   64: astore 5
    //   66: aload 5
    //   68: astore 4
    //   70: aload 5
    //   72: invokeinterface 88 1 0
    //   77: ifeq +37 -> 114
    //   80: aload 5
    //   82: astore 4
    //   84: aload 8
    //   86: aload_0
    //   87: aload 5
    //   89: invokevirtual 202	com/google/android/gms/ads/internal/purchase/zzh:zza	(Landroid/database/Cursor;)Lcom/google/android/gms/ads/internal/purchase/zzf;
    //   92: invokeinterface 208 2 0
    //   97: pop
    //   98: aload 5
    //   100: astore 4
    //   102: aload 5
    //   104: invokeinterface 211 1 0
    //   109: istore_3
    //   110: iload_3
    //   111: ifne -31 -> 80
    //   114: aload 5
    //   116: ifnull +10 -> 126
    //   119: aload 5
    //   121: invokeinterface 95 1 0
    //   126: aload 7
    //   128: monitorexit
    //   129: aload 8
    //   131: areturn
    //   132: astore 6
    //   134: aconst_null
    //   135: astore 5
    //   137: aload 5
    //   139: astore 4
    //   141: aload 6
    //   143: invokevirtual 98	android/database/sqlite/SQLiteException:getMessage	()Ljava/lang/String;
    //   146: invokestatic 102	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   149: astore 6
    //   151: aload 5
    //   153: astore 4
    //   155: aload 6
    //   157: invokevirtual 105	java/lang/String:length	()I
    //   160: ifeq +48 -> 208
    //   163: aload 5
    //   165: astore 4
    //   167: ldc -43
    //   169: aload 6
    //   171: invokevirtual 111	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   174: astore 6
    //   176: aload 5
    //   178: astore 4
    //   180: aload 6
    //   182: invokestatic 117	com/google/android/gms/internal/zzkh:zzcy	(Ljava/lang/String;)V
    //   185: aload 5
    //   187: ifnull -61 -> 126
    //   190: aload 5
    //   192: invokeinterface 95 1 0
    //   197: goto -71 -> 126
    //   200: astore 4
    //   202: aload 7
    //   204: monitorexit
    //   205: aload 4
    //   207: athrow
    //   208: aload 5
    //   210: astore 4
    //   212: new 38	java/lang/String
    //   215: dup
    //   216: ldc -43
    //   218: invokespecial 119	java/lang/String:<init>	(Ljava/lang/String;)V
    //   221: astore 6
    //   223: goto -47 -> 176
    //   226: astore 6
    //   228: aload 4
    //   230: astore 5
    //   232: aload 6
    //   234: astore 4
    //   236: aload 5
    //   238: ifnull +10 -> 248
    //   241: aload 5
    //   243: invokeinterface 95 1 0
    //   248: aload 4
    //   250: athrow
    //   251: astore 4
    //   253: aconst_null
    //   254: astore 5
    //   256: goto -20 -> 236
    //   259: astore 6
    //   261: goto -124 -> 137
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	264	0	this	zzh
    //   0	264	1	paramLong	long
    //   109	2	3	bool	boolean
    //   33	146	4	localObject1	Object
    //   200	6	4	localObject2	Object
    //   210	39	4	localObject3	Object
    //   251	1	4	localObject4	Object
    //   64	191	5	localObject5	Object
    //   132	10	6	localSQLiteException1	SQLiteException
    //   149	73	6	str	String
    //   226	7	6	localObject6	Object
    //   259	1	6	localSQLiteException2	SQLiteException
    //   3	200	7	localObject7	Object
    //   15	115	8	localLinkedList	java.util.LinkedList
    // Exception table:
    //   from	to	target	type
    //   46	66	132	android/database/sqlite/SQLiteException
    //   8	17	200	finally
    //   23	26	200	finally
    //   29	35	200	finally
    //   40	43	200	finally
    //   119	126	200	finally
    //   126	129	200	finally
    //   190	197	200	finally
    //   202	205	200	finally
    //   241	248	200	finally
    //   248	251	200	finally
    //   70	80	226	finally
    //   84	98	226	finally
    //   102	110	226	finally
    //   141	151	226	finally
    //   155	163	226	finally
    //   167	176	226	finally
    //   180	185	226	finally
    //   212	223	226	finally
    //   46	66	251	finally
    //   70	80	259	android/database/sqlite/SQLiteException
    //   84	98	259	android/database/sqlite/SQLiteException
    //   102	110	259	android/database/sqlite/SQLiteException
  }
  
  /* Error */
  public void zzpu()
  {
    // Byte code:
    //   0: getstatic 49	com/google/android/gms/ads/internal/purchase/zzh:zzail	Ljava/lang/Object;
    //   3: astore 4
    //   5: aload 4
    //   7: monitorenter
    //   8: aload_0
    //   9: invokevirtual 74	com/google/android/gms/ads/internal/purchase/zzh:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   12: astore_1
    //   13: aload_1
    //   14: ifnonnull +7 -> 21
    //   17: aload 4
    //   19: monitorexit
    //   20: return
    //   21: aload_1
    //   22: ldc 28
    //   24: aconst_null
    //   25: aconst_null
    //   26: aconst_null
    //   27: aconst_null
    //   28: aconst_null
    //   29: ldc -63
    //   31: ldc -39
    //   33: invokevirtual 200	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   36: astore_2
    //   37: aload_2
    //   38: ifnull +25 -> 63
    //   41: aload_2
    //   42: astore_1
    //   43: aload_2
    //   44: invokeinterface 88 1 0
    //   49: ifeq +14 -> 63
    //   52: aload_2
    //   53: astore_1
    //   54: aload_0
    //   55: aload_0
    //   56: aload_2
    //   57: invokevirtual 202	com/google/android/gms/ads/internal/purchase/zzh:zza	(Landroid/database/Cursor;)Lcom/google/android/gms/ads/internal/purchase/zzf;
    //   60: invokevirtual 219	com/google/android/gms/ads/internal/purchase/zzh:zza	(Lcom/google/android/gms/ads/internal/purchase/zzf;)V
    //   63: aload_2
    //   64: ifnull +9 -> 73
    //   67: aload_2
    //   68: invokeinterface 95 1 0
    //   73: aload 4
    //   75: monitorexit
    //   76: return
    //   77: astore_1
    //   78: aload 4
    //   80: monitorexit
    //   81: aload_1
    //   82: athrow
    //   83: astore_3
    //   84: aconst_null
    //   85: astore_2
    //   86: aload_2
    //   87: astore_1
    //   88: aload_3
    //   89: invokevirtual 98	android/database/sqlite/SQLiteException:getMessage	()Ljava/lang/String;
    //   92: invokestatic 102	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   95: astore_3
    //   96: aload_2
    //   97: astore_1
    //   98: aload_3
    //   99: invokevirtual 105	java/lang/String:length	()I
    //   102: ifeq +31 -> 133
    //   105: aload_2
    //   106: astore_1
    //   107: ldc -35
    //   109: aload_3
    //   110: invokevirtual 111	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   113: astore_3
    //   114: aload_2
    //   115: astore_1
    //   116: aload_3
    //   117: invokestatic 117	com/google/android/gms/internal/zzkh:zzcy	(Ljava/lang/String;)V
    //   120: aload_2
    //   121: ifnull -48 -> 73
    //   124: aload_2
    //   125: invokeinterface 95 1 0
    //   130: goto -57 -> 73
    //   133: aload_2
    //   134: astore_1
    //   135: new 38	java/lang/String
    //   138: dup
    //   139: ldc -35
    //   141: invokespecial 119	java/lang/String:<init>	(Ljava/lang/String;)V
    //   144: astore_3
    //   145: goto -31 -> 114
    //   148: astore_3
    //   149: aload_1
    //   150: astore_2
    //   151: aload_3
    //   152: astore_1
    //   153: aload_2
    //   154: ifnull +9 -> 163
    //   157: aload_2
    //   158: invokeinterface 95 1 0
    //   163: aload_1
    //   164: athrow
    //   165: astore_1
    //   166: aconst_null
    //   167: astore_2
    //   168: goto -15 -> 153
    //   171: astore_3
    //   172: goto -86 -> 86
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	175	0	this	zzh
    //   12	42	1	localObject1	Object
    //   77	5	1	localObject2	Object
    //   87	77	1	localObject3	Object
    //   165	1	1	localObject4	Object
    //   36	132	2	localObject5	Object
    //   83	6	3	localSQLiteException1	SQLiteException
    //   95	50	3	str	String
    //   148	4	3	localObject6	Object
    //   171	1	3	localSQLiteException2	SQLiteException
    //   3	76	4	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   8	13	77	finally
    //   17	20	77	finally
    //   67	73	77	finally
    //   73	76	77	finally
    //   78	81	77	finally
    //   124	130	77	finally
    //   157	163	77	finally
    //   163	165	77	finally
    //   21	37	83	android/database/sqlite/SQLiteException
    //   43	52	148	finally
    //   54	63	148	finally
    //   88	96	148	finally
    //   98	105	148	finally
    //   107	114	148	finally
    //   116	120	148	finally
    //   135	145	148	finally
    //   21	37	165	finally
    //   43	52	171	android/database/sqlite/SQLiteException
    //   54	63	171	android/database/sqlite/SQLiteException
  }
  
  public class zza
    extends SQLiteOpenHelper
  {
    public zza(Context paramContext, String paramString)
    {
      super(paramString, null, 4);
    }
    
    public void onCreate(SQLiteDatabase paramSQLiteDatabase)
    {
      paramSQLiteDatabase.execSQL(zzh.zzbxo);
    }
    
    public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
    {
      zzkh.zzcx(64 + "Database updated from version " + paramInt1 + " to version " + paramInt2);
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS InAppPurchase");
      onCreate(paramSQLiteDatabase);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.purchase.zzh
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */