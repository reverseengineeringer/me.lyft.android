package com.kochava.android.tracker;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import com.kochava.android.util.Logging;

public class DbAdapter
{
  private DatabaseHelper kDb;
  
  public DbAdapter(Context paramContext)
  {
    kDb = new DatabaseHelper(paramContext);
  }
  
  /* Error */
  public int addEvent(org.json.JSONObject paramJSONObject, boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 24
    //   4: invokestatic 30	com/kochava/android/util/Logging:Log	(Ljava/lang/String;)V
    //   7: aconst_null
    //   8: astore 9
    //   10: aconst_null
    //   11: astore 8
    //   13: iconst_m1
    //   14: istore 5
    //   16: aload 8
    //   18: astore 7
    //   20: aload 9
    //   22: astore 6
    //   24: aload_0
    //   25: getfield 18	com/kochava/android/tracker/DbAdapter:kDb	Lcom/kochava/android/tracker/DbAdapter$DatabaseHelper;
    //   28: invokevirtual 34	com/kochava/android/tracker/DbAdapter$DatabaseHelper:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   31: astore 10
    //   33: aload 8
    //   35: astore 7
    //   37: aload 9
    //   39: astore 6
    //   41: new 36	android/content/ContentValues
    //   44: dup
    //   45: invokespecial 37	android/content/ContentValues:<init>	()V
    //   48: astore 11
    //   50: aload 8
    //   52: astore 7
    //   54: aload 9
    //   56: astore 6
    //   58: aload 11
    //   60: ldc 39
    //   62: aload_1
    //   63: invokevirtual 45	org/json/JSONObject:toString	()Ljava/lang/String;
    //   66: invokevirtual 49	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   69: iload_2
    //   70: ifeq +106 -> 176
    //   73: aload 8
    //   75: astore 7
    //   77: aload 9
    //   79: astore 6
    //   81: aload 11
    //   83: ldc 51
    //   85: iconst_0
    //   86: invokestatic 57	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   89: invokevirtual 60	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   92: aload 8
    //   94: astore 7
    //   96: aload 9
    //   98: astore 6
    //   100: aload 10
    //   102: ldc 62
    //   104: aconst_null
    //   105: aload 11
    //   107: invokevirtual 68	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   110: pop2
    //   111: aload 8
    //   113: astore 7
    //   115: aload 9
    //   117: astore 6
    //   119: aload 10
    //   121: ldc 70
    //   123: aconst_null
    //   124: invokevirtual 74	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   127: astore_1
    //   128: aload_1
    //   129: astore 7
    //   131: aload_1
    //   132: astore 6
    //   134: aload_1
    //   135: invokeinterface 80 1 0
    //   140: istore 4
    //   142: iload 4
    //   144: istore 5
    //   146: aload_0
    //   147: getfield 18	com/kochava/android/tracker/DbAdapter:kDb	Lcom/kochava/android/tracker/DbAdapter$DatabaseHelper;
    //   150: invokevirtual 83	com/kochava/android/tracker/DbAdapter$DatabaseHelper:close	()V
    //   153: iload 5
    //   155: istore 4
    //   157: aload_1
    //   158: ifnull +13 -> 171
    //   161: aload_1
    //   162: invokeinterface 84 1 0
    //   167: iload 5
    //   169: istore 4
    //   171: aload_0
    //   172: monitorexit
    //   173: iload 4
    //   175: ireturn
    //   176: iload_3
    //   177: ifeq +87 -> 264
    //   180: aload 8
    //   182: astore 7
    //   184: aload 9
    //   186: astore 6
    //   188: aload 11
    //   190: ldc 51
    //   192: iconst_1
    //   193: invokestatic 57	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   196: invokevirtual 60	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   199: goto -107 -> 92
    //   202: astore_1
    //   203: aload 7
    //   205: astore 6
    //   207: new 86	java/lang/StringBuilder
    //   210: dup
    //   211: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   214: ldc 89
    //   216: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: aload_1
    //   220: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   223: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   226: invokestatic 100	com/kochava/android/util/Logging:LogError	(Ljava/lang/String;)V
    //   229: aload_0
    //   230: getfield 18	com/kochava/android/tracker/DbAdapter:kDb	Lcom/kochava/android/tracker/DbAdapter$DatabaseHelper;
    //   233: invokevirtual 83	com/kochava/android/tracker/DbAdapter$DatabaseHelper:close	()V
    //   236: iload 5
    //   238: istore 4
    //   240: aload 7
    //   242: ifnull -71 -> 171
    //   245: aload 7
    //   247: invokeinterface 84 1 0
    //   252: iload 5
    //   254: istore 4
    //   256: goto -85 -> 171
    //   259: astore_1
    //   260: aload_0
    //   261: monitorexit
    //   262: aload_1
    //   263: athrow
    //   264: aload 8
    //   266: astore 7
    //   268: aload 9
    //   270: astore 6
    //   272: aload 11
    //   274: ldc 51
    //   276: invokestatic 106	java/lang/System:currentTimeMillis	()J
    //   279: invokestatic 111	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   282: invokevirtual 114	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   285: goto -193 -> 92
    //   288: astore_1
    //   289: aload_0
    //   290: getfield 18	com/kochava/android/tracker/DbAdapter:kDb	Lcom/kochava/android/tracker/DbAdapter$DatabaseHelper;
    //   293: invokevirtual 83	com/kochava/android/tracker/DbAdapter$DatabaseHelper:close	()V
    //   296: aload 6
    //   298: ifnull +10 -> 308
    //   301: aload 6
    //   303: invokeinterface 84 1 0
    //   308: aload_1
    //   309: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	310	0	this	DbAdapter
    //   0	310	1	paramJSONObject	org.json.JSONObject
    //   0	310	2	paramBoolean1	boolean
    //   0	310	3	paramBoolean2	boolean
    //   140	115	4	i	int
    //   14	239	5	j	int
    //   22	280	6	localObject1	Object
    //   18	249	7	localObject2	Object
    //   11	254	8	localObject3	Object
    //   8	261	9	localObject4	Object
    //   31	89	10	localSQLiteDatabase	SQLiteDatabase
    //   48	225	11	localContentValues	ContentValues
    // Exception table:
    //   from	to	target	type
    //   24	33	202	android/database/sqlite/SQLiteException
    //   41	50	202	android/database/sqlite/SQLiteException
    //   58	69	202	android/database/sqlite/SQLiteException
    //   81	92	202	android/database/sqlite/SQLiteException
    //   100	111	202	android/database/sqlite/SQLiteException
    //   119	128	202	android/database/sqlite/SQLiteException
    //   134	142	202	android/database/sqlite/SQLiteException
    //   188	199	202	android/database/sqlite/SQLiteException
    //   272	285	202	android/database/sqlite/SQLiteException
    //   2	7	259	finally
    //   146	153	259	finally
    //   161	167	259	finally
    //   171	173	259	finally
    //   229	236	259	finally
    //   245	252	259	finally
    //   260	262	259	finally
    //   289	296	259	finally
    //   301	308	259	finally
    //   308	310	259	finally
    //   24	33	288	finally
    //   41	50	288	finally
    //   58	69	288	finally
    //   81	92	288	finally
    //   100	111	288	finally
    //   119	128	288	finally
    //   134	142	288	finally
    //   188	199	288	finally
    //   207	229	288	finally
    //   272	285	288	finally
  }
  
  /* Error */
  public void cleanupEvents(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 118
    //   4: invokestatic 30	com/kochava/android/util/Logging:Log	(Ljava/lang/String;)V
    //   7: aload_0
    //   8: getfield 18	com/kochava/android/tracker/DbAdapter:kDb	Lcom/kochava/android/tracker/DbAdapter$DatabaseHelper;
    //   11: invokevirtual 34	com/kochava/android/tracker/DbAdapter$DatabaseHelper:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   14: ldc 62
    //   16: new 86	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   23: ldc 120
    //   25: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: lload_1
    //   29: invokevirtual 123	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   32: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   35: aconst_null
    //   36: invokevirtual 127	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   39: pop
    //   40: aload_0
    //   41: getfield 18	com/kochava/android/tracker/DbAdapter:kDb	Lcom/kochava/android/tracker/DbAdapter$DatabaseHelper;
    //   44: invokevirtual 83	com/kochava/android/tracker/DbAdapter$DatabaseHelper:close	()V
    //   47: aload_0
    //   48: monitorexit
    //   49: return
    //   50: astore_3
    //   51: new 86	java/lang/StringBuilder
    //   54: dup
    //   55: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   58: ldc -128
    //   60: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: aload_3
    //   64: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   67: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   70: invokestatic 100	com/kochava/android/util/Logging:LogError	(Ljava/lang/String;)V
    //   73: aload_0
    //   74: getfield 18	com/kochava/android/tracker/DbAdapter:kDb	Lcom/kochava/android/tracker/DbAdapter$DatabaseHelper;
    //   77: invokevirtual 83	com/kochava/android/tracker/DbAdapter$DatabaseHelper:close	()V
    //   80: goto -33 -> 47
    //   83: astore_3
    //   84: aload_0
    //   85: monitorexit
    //   86: aload_3
    //   87: athrow
    //   88: astore_3
    //   89: aload_0
    //   90: getfield 18	com/kochava/android/tracker/DbAdapter:kDb	Lcom/kochava/android/tracker/DbAdapter$DatabaseHelper;
    //   93: invokevirtual 83	com/kochava/android/tracker/DbAdapter$DatabaseHelper:close	()V
    //   96: aload_3
    //   97: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	98	0	this	DbAdapter
    //   0	98	1	paramLong	long
    //   50	14	3	localSQLiteException	SQLiteException
    //   83	4	3	localObject1	Object
    //   88	9	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   7	40	50	android/database/sqlite/SQLiteException
    //   2	7	83	finally
    //   40	47	83	finally
    //   47	49	83	finally
    //   73	80	83	finally
    //   84	86	83	finally
    //   89	98	83	finally
    //   7	40	88	finally
    //   51	73	88	finally
  }
  
  /* Error */
  public String generateDataString()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aconst_null
    //   3: astore 10
    //   5: aconst_null
    //   6: astore 7
    //   8: aconst_null
    //   9: astore 8
    //   11: aconst_null
    //   12: astore 9
    //   14: aconst_null
    //   15: astore_3
    //   16: aconst_null
    //   17: astore 4
    //   19: aload 7
    //   21: astore 5
    //   23: aload_3
    //   24: astore_2
    //   25: aload 10
    //   27: astore 6
    //   29: aload_0
    //   30: getfield 18	com/kochava/android/tracker/DbAdapter:kDb	Lcom/kochava/android/tracker/DbAdapter$DatabaseHelper;
    //   33: invokevirtual 134	com/kochava/android/tracker/DbAdapter$DatabaseHelper:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   36: astore 11
    //   38: aload 7
    //   40: astore 5
    //   42: aload_3
    //   43: astore_2
    //   44: aload 10
    //   46: astore 6
    //   48: aload 11
    //   50: ldc -120
    //   52: aconst_null
    //   53: invokevirtual 74	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   56: astore 7
    //   58: aload 7
    //   60: astore 5
    //   62: aload_3
    //   63: astore_2
    //   64: aload 7
    //   66: astore 6
    //   68: new 138	org/json/JSONArray
    //   71: dup
    //   72: invokespecial 139	org/json/JSONArray:<init>	()V
    //   75: astore 10
    //   77: aload 7
    //   79: astore 5
    //   81: aload 4
    //   83: astore_2
    //   84: aload 4
    //   86: astore_3
    //   87: aload 7
    //   89: astore 6
    //   91: aload 7
    //   93: invokeinterface 143 1 0
    //   98: ifeq +341 -> 439
    //   101: aload 7
    //   103: astore 5
    //   105: aload 4
    //   107: astore_2
    //   108: aload 7
    //   110: astore 6
    //   112: aload 7
    //   114: aload 7
    //   116: ldc 51
    //   118: invokeinterface 147 2 0
    //   123: invokeinterface 151 2 0
    //   128: ldc -103
    //   130: invokevirtual 159	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   133: ifeq +488 -> 621
    //   136: ldc -103
    //   138: astore_3
    //   139: aload 7
    //   141: astore 5
    //   143: aload_3
    //   144: astore_2
    //   145: aload 7
    //   147: astore 6
    //   149: aload 11
    //   151: ldc -95
    //   153: aconst_null
    //   154: invokevirtual 74	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   157: astore 4
    //   159: aload 7
    //   161: astore 5
    //   163: aload_3
    //   164: astore_2
    //   165: aload 7
    //   167: astore 6
    //   169: aload 4
    //   171: invokeinterface 143 1 0
    //   176: istore_1
    //   177: iload_1
    //   178: ifeq +190 -> 368
    //   181: aload 7
    //   183: astore 5
    //   185: aload_3
    //   186: astore_2
    //   187: aload 7
    //   189: astore 6
    //   191: aload 10
    //   193: new 41	org/json/JSONObject
    //   196: dup
    //   197: aload 4
    //   199: aload 4
    //   201: ldc 39
    //   203: invokeinterface 147 2 0
    //   208: invokeinterface 151 2 0
    //   213: invokespecial 163	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   216: invokevirtual 166	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   219: pop
    //   220: aload_3
    //   221: ldc -103
    //   223: if_acmpne -64 -> 159
    //   226: ldc -88
    //   228: astore_3
    //   229: goto -70 -> 159
    //   232: astore 11
    //   234: aload 7
    //   236: astore 5
    //   238: aload_3
    //   239: astore_2
    //   240: aload 7
    //   242: astore 6
    //   244: getstatic 174	com/kochava/android/tracker/Global:DEBUGERROR	Z
    //   247: ifeq -88 -> 159
    //   250: aload 7
    //   252: astore 5
    //   254: aload_3
    //   255: astore_2
    //   256: aload 7
    //   258: astore 6
    //   260: aload 11
    //   262: invokevirtual 177	org/json/JSONException:printStackTrace	()V
    //   265: goto -106 -> 159
    //   268: astore_3
    //   269: aload 5
    //   271: astore 6
    //   273: new 86	java/lang/StringBuilder
    //   276: dup
    //   277: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   280: ldc -78
    //   282: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   285: aload_3
    //   286: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   289: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   292: invokestatic 100	com/kochava/android/util/Logging:LogError	(Ljava/lang/String;)V
    //   295: aload_0
    //   296: getfield 18	com/kochava/android/tracker/DbAdapter:kDb	Lcom/kochava/android/tracker/DbAdapter$DatabaseHelper;
    //   299: invokevirtual 83	com/kochava/android/tracker/DbAdapter$DatabaseHelper:close	()V
    //   302: aload 9
    //   304: astore 6
    //   306: aload_2
    //   307: astore 8
    //   309: aload 5
    //   311: ifnull +17 -> 328
    //   314: aload 5
    //   316: invokeinterface 84 1 0
    //   321: aload_2
    //   322: astore 8
    //   324: aload 9
    //   326: astore 6
    //   328: aload 8
    //   330: ifnull +395 -> 725
    //   333: aload 6
    //   335: ifnull +390 -> 725
    //   338: new 86	java/lang/StringBuilder
    //   341: dup
    //   342: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   345: aload 8
    //   347: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   350: ldc -76
    //   352: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: aload 6
    //   357: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   360: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   363: astore_2
    //   364: aload_0
    //   365: monitorexit
    //   366: aload_2
    //   367: areturn
    //   368: aload 7
    //   370: astore 5
    //   372: aload_3
    //   373: astore_2
    //   374: aload 7
    //   376: astore 6
    //   378: aload 4
    //   380: invokeinterface 84 1 0
    //   385: aload 7
    //   387: astore 5
    //   389: aload_3
    //   390: astore_2
    //   391: aload 7
    //   393: astore 6
    //   395: aload 10
    //   397: new 41	org/json/JSONObject
    //   400: dup
    //   401: aload 7
    //   403: aload 7
    //   405: ldc 39
    //   407: invokeinterface 147 2 0
    //   412: invokeinterface 151 2 0
    //   417: invokespecial 163	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   420: invokevirtual 166	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   423: pop
    //   424: aload 7
    //   426: astore 5
    //   428: aload_3
    //   429: astore_2
    //   430: aload 7
    //   432: astore 6
    //   434: ldc -74
    //   436: invokestatic 30	com/kochava/android/util/Logging:Log	(Ljava/lang/String;)V
    //   439: aload 7
    //   441: astore 5
    //   443: aload_3
    //   444: astore_2
    //   445: aload 8
    //   447: astore 4
    //   449: aload 7
    //   451: astore 6
    //   453: aload 10
    //   455: invokevirtual 185	org/json/JSONArray:length	()I
    //   458: ifle +59 -> 517
    //   461: aload 7
    //   463: astore 5
    //   465: aload_3
    //   466: astore_2
    //   467: aload 7
    //   469: astore 6
    //   471: new 86	java/lang/StringBuilder
    //   474: dup
    //   475: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   478: ldc -69
    //   480: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   483: aload 10
    //   485: invokevirtual 188	org/json/JSONArray:toString	()Ljava/lang/String;
    //   488: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   491: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   494: invokestatic 30	com/kochava/android/util/Logging:Log	(Ljava/lang/String;)V
    //   497: aload 7
    //   499: astore 5
    //   501: aload_3
    //   502: astore_2
    //   503: aload 7
    //   505: astore 6
    //   507: aload 10
    //   509: invokevirtual 188	org/json/JSONArray:toString	()Ljava/lang/String;
    //   512: invokestatic 194	com/kochava/android/util/Base64Coder:encodeString	(Ljava/lang/String;)Ljava/lang/String;
    //   515: astore 4
    //   517: aload_0
    //   518: getfield 18	com/kochava/android/tracker/DbAdapter:kDb	Lcom/kochava/android/tracker/DbAdapter$DatabaseHelper;
    //   521: invokevirtual 83	com/kochava/android/tracker/DbAdapter$DatabaseHelper:close	()V
    //   524: aload 4
    //   526: astore 6
    //   528: aload_3
    //   529: astore 8
    //   531: aload 7
    //   533: ifnull -205 -> 328
    //   536: aload 7
    //   538: invokeinterface 84 1 0
    //   543: aload 4
    //   545: astore 6
    //   547: aload_3
    //   548: astore 8
    //   550: goto -222 -> 328
    //   553: astore_2
    //   554: aload_0
    //   555: monitorexit
    //   556: aload_2
    //   557: athrow
    //   558: astore 4
    //   560: aload 7
    //   562: astore 5
    //   564: aload_3
    //   565: astore_2
    //   566: aload 7
    //   568: astore 6
    //   570: new 86	java/lang/StringBuilder
    //   573: dup
    //   574: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   577: ldc -60
    //   579: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   582: aload 4
    //   584: invokevirtual 197	org/json/JSONException:toString	()Ljava/lang/String;
    //   587: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   590: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   593: invokestatic 100	com/kochava/android/util/Logging:LogError	(Ljava/lang/String;)V
    //   596: goto -172 -> 424
    //   599: astore_2
    //   600: aload_0
    //   601: getfield 18	com/kochava/android/tracker/DbAdapter:kDb	Lcom/kochava/android/tracker/DbAdapter$DatabaseHelper;
    //   604: invokevirtual 83	com/kochava/android/tracker/DbAdapter$DatabaseHelper:close	()V
    //   607: aload 6
    //   609: ifnull +10 -> 619
    //   612: aload 6
    //   614: invokeinterface 84 1 0
    //   619: aload_2
    //   620: athrow
    //   621: aload 7
    //   623: astore 5
    //   625: aload 4
    //   627: astore_2
    //   628: aload 7
    //   630: astore 6
    //   632: aload 4
    //   634: astore_3
    //   635: aload 7
    //   637: invokeinterface 200 1 0
    //   642: ifeq +31 -> 673
    //   645: aload 7
    //   647: astore 5
    //   649: aload 4
    //   651: astore_2
    //   652: aload 7
    //   654: astore 6
    //   656: aload 7
    //   658: aload 7
    //   660: ldc 51
    //   662: invokeinterface 147 2 0
    //   667: invokeinterface 151 2 0
    //   672: astore_3
    //   673: aload 7
    //   675: astore 5
    //   677: aload_3
    //   678: astore_2
    //   679: aload 7
    //   681: astore 6
    //   683: aload 10
    //   685: new 41	org/json/JSONObject
    //   688: dup
    //   689: aload 7
    //   691: aload 7
    //   693: ldc 39
    //   695: invokeinterface 147 2 0
    //   700: invokeinterface 151 2 0
    //   705: invokespecial 163	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   708: invokevirtual 166	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   711: pop
    //   712: aload_3
    //   713: astore 4
    //   715: goto -638 -> 77
    //   718: astore_2
    //   719: aload_3
    //   720: astore 4
    //   722: goto -645 -> 77
    //   725: aload_0
    //   726: monitorexit
    //   727: aconst_null
    //   728: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	729	0	this	DbAdapter
    //   176	2	1	bool	boolean
    //   24	479	2	localObject1	Object
    //   553	4	2	localObject2	Object
    //   565	1	2	localSQLiteException1	SQLiteException
    //   599	21	2	localObject3	Object
    //   627	52	2	localObject4	Object
    //   718	1	2	localJSONException1	org.json.JSONException
    //   15	240	3	localObject5	Object
    //   268	297	3	localSQLiteException2	SQLiteException
    //   634	86	3	localObject6	Object
    //   17	527	4	localObject7	Object
    //   558	92	4	localJSONException2	org.json.JSONException
    //   713	8	4	localObject8	Object
    //   21	655	5	localCursor1	android.database.Cursor
    //   27	655	6	localObject9	Object
    //   6	686	7	localCursor2	android.database.Cursor
    //   9	540	8	localObject10	Object
    //   12	313	9	localObject11	Object
    //   3	681	10	localJSONArray	org.json.JSONArray
    //   36	114	11	localSQLiteDatabase	SQLiteDatabase
    //   232	29	11	localJSONException3	org.json.JSONException
    // Exception table:
    //   from	to	target	type
    //   191	220	232	org/json/JSONException
    //   29	38	268	android/database/sqlite/SQLiteException
    //   48	58	268	android/database/sqlite/SQLiteException
    //   68	77	268	android/database/sqlite/SQLiteException
    //   91	101	268	android/database/sqlite/SQLiteException
    //   112	136	268	android/database/sqlite/SQLiteException
    //   149	159	268	android/database/sqlite/SQLiteException
    //   169	177	268	android/database/sqlite/SQLiteException
    //   191	220	268	android/database/sqlite/SQLiteException
    //   244	250	268	android/database/sqlite/SQLiteException
    //   260	265	268	android/database/sqlite/SQLiteException
    //   378	385	268	android/database/sqlite/SQLiteException
    //   395	424	268	android/database/sqlite/SQLiteException
    //   434	439	268	android/database/sqlite/SQLiteException
    //   453	461	268	android/database/sqlite/SQLiteException
    //   471	497	268	android/database/sqlite/SQLiteException
    //   507	517	268	android/database/sqlite/SQLiteException
    //   570	596	268	android/database/sqlite/SQLiteException
    //   635	645	268	android/database/sqlite/SQLiteException
    //   656	673	268	android/database/sqlite/SQLiteException
    //   683	712	268	android/database/sqlite/SQLiteException
    //   295	302	553	finally
    //   314	321	553	finally
    //   338	366	553	finally
    //   517	524	553	finally
    //   536	543	553	finally
    //   554	556	553	finally
    //   600	607	553	finally
    //   612	619	553	finally
    //   619	621	553	finally
    //   725	727	553	finally
    //   395	424	558	org/json/JSONException
    //   29	38	599	finally
    //   48	58	599	finally
    //   68	77	599	finally
    //   91	101	599	finally
    //   112	136	599	finally
    //   149	159	599	finally
    //   169	177	599	finally
    //   191	220	599	finally
    //   244	250	599	finally
    //   260	265	599	finally
    //   273	295	599	finally
    //   378	385	599	finally
    //   395	424	599	finally
    //   434	439	599	finally
    //   453	461	599	finally
    //   471	497	599	finally
    //   507	517	599	finally
    //   570	596	599	finally
    //   635	645	599	finally
    //   656	673	599	finally
    //   683	712	599	finally
    //   683	712	718	org/json/JSONException
  }
  
  /* Error */
  public String getApplicationData(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull +13 -> 16
    //   6: aload_1
    //   7: invokevirtual 204	java/lang/String:trim	()Ljava/lang/String;
    //   10: invokevirtual 205	java/lang/String:length	()I
    //   13: ifne +8 -> 21
    //   16: aload_0
    //   17: monitorexit
    //   18: ldc -49
    //   20: areturn
    //   21: aconst_null
    //   22: astore_3
    //   23: aconst_null
    //   24: astore_2
    //   25: aload_0
    //   26: getfield 18	com/kochava/android/tracker/DbAdapter:kDb	Lcom/kochava/android/tracker/DbAdapter$DatabaseHelper;
    //   29: invokevirtual 134	com/kochava/android/tracker/DbAdapter$DatabaseHelper:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   32: new 86	java/lang/StringBuilder
    //   35: dup
    //   36: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   39: ldc -47
    //   41: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: aload_1
    //   45: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: ldc -45
    //   50: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   56: aconst_null
    //   57: invokevirtual 74	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   60: astore_1
    //   61: aload_1
    //   62: astore_2
    //   63: aload_1
    //   64: astore_3
    //   65: aload_1
    //   66: invokeinterface 143 1 0
    //   71: ifeq +50 -> 121
    //   74: aload_1
    //   75: astore_2
    //   76: aload_1
    //   77: astore_3
    //   78: aload_1
    //   79: aload_1
    //   80: ldc 39
    //   82: invokeinterface 147 2 0
    //   87: invokeinterface 151 2 0
    //   92: astore 4
    //   94: aload_0
    //   95: getfield 18	com/kochava/android/tracker/DbAdapter:kDb	Lcom/kochava/android/tracker/DbAdapter$DatabaseHelper;
    //   98: invokevirtual 83	com/kochava/android/tracker/DbAdapter$DatabaseHelper:close	()V
    //   101: aload_1
    //   102: ifnull +9 -> 111
    //   105: aload_1
    //   106: invokeinterface 84 1 0
    //   111: aload_0
    //   112: monitorexit
    //   113: aload 4
    //   115: areturn
    //   116: astore_1
    //   117: aload_0
    //   118: monitorexit
    //   119: aload_1
    //   120: athrow
    //   121: aload_0
    //   122: getfield 18	com/kochava/android/tracker/DbAdapter:kDb	Lcom/kochava/android/tracker/DbAdapter$DatabaseHelper;
    //   125: invokevirtual 83	com/kochava/android/tracker/DbAdapter$DatabaseHelper:close	()V
    //   128: aload_1
    //   129: ifnull +9 -> 138
    //   132: aload_1
    //   133: invokeinterface 84 1 0
    //   138: aload_0
    //   139: monitorexit
    //   140: aconst_null
    //   141: areturn
    //   142: astore_1
    //   143: aload_2
    //   144: astore_3
    //   145: new 86	java/lang/StringBuilder
    //   148: dup
    //   149: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   152: ldc -78
    //   154: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: aload_1
    //   158: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   161: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   164: invokestatic 100	com/kochava/android/util/Logging:LogError	(Ljava/lang/String;)V
    //   167: aload_0
    //   168: getfield 18	com/kochava/android/tracker/DbAdapter:kDb	Lcom/kochava/android/tracker/DbAdapter$DatabaseHelper;
    //   171: invokevirtual 83	com/kochava/android/tracker/DbAdapter$DatabaseHelper:close	()V
    //   174: aload_2
    //   175: ifnull -37 -> 138
    //   178: aload_2
    //   179: invokeinterface 84 1 0
    //   184: goto -46 -> 138
    //   187: astore_1
    //   188: aload_0
    //   189: getfield 18	com/kochava/android/tracker/DbAdapter:kDb	Lcom/kochava/android/tracker/DbAdapter$DatabaseHelper;
    //   192: invokevirtual 83	com/kochava/android/tracker/DbAdapter$DatabaseHelper:close	()V
    //   195: aload_3
    //   196: ifnull +9 -> 205
    //   199: aload_3
    //   200: invokeinterface 84 1 0
    //   205: aload_1
    //   206: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	207	0	this	DbAdapter
    //   0	207	1	paramString	String
    //   24	155	2	str1	String
    //   22	178	3	localObject	Object
    //   92	22	4	str2	String
    // Exception table:
    //   from	to	target	type
    //   6	16	116	finally
    //   16	18	116	finally
    //   94	101	116	finally
    //   105	111	116	finally
    //   111	113	116	finally
    //   117	119	116	finally
    //   121	128	116	finally
    //   132	138	116	finally
    //   138	140	116	finally
    //   167	174	116	finally
    //   178	184	116	finally
    //   188	195	116	finally
    //   199	205	116	finally
    //   205	207	116	finally
    //   25	61	142	android/database/sqlite/SQLiteException
    //   65	74	142	android/database/sqlite/SQLiteException
    //   78	94	142	android/database/sqlite/SQLiteException
    //   25	61	187	finally
    //   65	74	187	finally
    //   78	94	187	finally
    //   145	167	187	finally
  }
  
  public void insertApplicationData(String paramString1, String paramString2)
  {
    if (paramString1 != null) {}
    for (;;)
    {
      SQLiteDatabase localSQLiteDatabase;
      ContentValues localContentValues;
      try
      {
        if (paramString1.trim().length() == 0) {
          return;
        }
      }
      finally {}
      try
      {
        localSQLiteDatabase = kDb.getWritableDatabase();
        localContentValues = new ContentValues();
        localContentValues.put("id", paramString1);
        localContentValues.put("data", paramString2);
        localSQLiteDatabase.insert("keys", null, localContentValues);
      }
      catch (SQLiteException paramString1)
      {
        Logging.LogError("addEvent" + paramString1);
      }
      finally
      {
        kDb.close();
        if (0 == 0) {
          break label151;
        }
        throw new NullPointerException();
      }
    }
  }
  
  public void updateApplicationData(String paramString1, String paramString2)
  {
    if (paramString1 != null) {}
    for (;;)
    {
      SQLiteDatabase localSQLiteDatabase;
      ContentValues localContentValues;
      try
      {
        if (paramString1.trim().length() == 0) {
          return;
        }
      }
      finally {}
      try
      {
        localSQLiteDatabase = kDb.getWritableDatabase();
        localContentValues = new ContentValues();
        localContentValues.put("data", paramString2);
        localSQLiteDatabase.update("keys", localContentValues, "id='" + paramString1 + "'", null);
      }
      catch (SQLiteException paramString1)
      {
        Logging.LogError("addEvent" + paramString1);
      }
      finally
      {
        kDb.close();
        if (0 == 0) {
          break label166;
        }
        throw new NullPointerException();
      }
    }
  }
  
  private static class DatabaseHelper
    extends SQLiteOpenHelper
  {
    DatabaseHelper(Context paramContext)
    {
      super("KochavaFeatureTracker", null, 2);
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
}

/* Location:
 * Qualified Name:     com.kochava.android.tracker.DbAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */