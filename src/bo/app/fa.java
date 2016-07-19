package bo.app;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.appboy.Constants;
import com.appboy.support.AppboyLogger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class fa
  implements ez
{
  private static final String a = String.format("%s.%s", new Object[] { Constants.APPBOY_LOG_TAG_PREFIX, fa.class.getName() });
  private static final String[] b = { "session_id", "start_time", "end_time", "new_sent", "endtime_sent" };
  private static final String[] c = { "session_id", "event_type", "event_data", "timestamp" };
  private SQLiteDatabase d;
  private final eo e;
  
  public fa(eo parameo)
  {
    e = parameo;
  }
  
  private static ContentValues a(db paramdb, cs paramcs)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("session_id", paramdb.toString());
    localContentValues.put("event_type", bs);
    localContentValues.put("event_data", paramcs.c().toString());
    localContentValues.put("timestamp", Double.valueOf(paramcs.a()));
    return localContentValues;
  }
  
  private cx a(Cursor paramCursor)
  {
    for (;;)
    {
      try
      {
        Object localObject5 = String.format("%s = ?", new Object[] { "session_id" });
        Object localObject6;
        double d1;
        Object localObject1;
        if (paramCursor.moveToFirst())
        {
          localObject6 = paramCursor.getString(paramCursor.getColumnIndex("session_id"));
          d1 = paramCursor.getDouble(paramCursor.getColumnIndex("start_time"));
          i = paramCursor.getColumnIndex("end_time");
          if (paramCursor.isNull(i)) {
            break label302;
          }
          localObject1 = Double.valueOf(paramCursor.getDouble(i));
          i = paramCursor.getColumnIndex("new_sent");
          if (paramCursor.isNull(i)) {
            break label296;
          }
          i = paramCursor.getInt(i);
          paramCursor.close();
          localObject5 = c().query("ab_events", c, (String)localObject5, new String[] { localObject6 }, null, null, null);
        }
        Object localObject7;
        boolean bool;
        int i = 0;
      }
      finally
      {
        try
        {
          localObject7 = c((Cursor)localObject5);
          localObject6 = db.a((String)localObject6);
          localObject7 = new cp(new HashSet((Collection)localObject7));
          if (!a(i))
          {
            bool = true;
            localObject1 = new cx((db)localObject6, d1, (Double)localObject1, (cp)localObject7, bool, false, false);
            if (paramCursor != null) {
              paramCursor.close();
            }
            if (localObject5 != null) {
              ((Cursor)localObject5).close();
            }
            return (cx)localObject1;
          }
          bool = false;
          continue;
          if (paramCursor != null) {
            paramCursor.close();
          }
          return null;
        }
        finally
        {
          continue;
        }
        localObject2 = finally;
        localObject5 = null;
        if (paramCursor != null) {
          paramCursor.close();
        }
        if (localObject5 != null) {
          ((Cursor)localObject5).close();
        }
      }
      label296:
      continue;
      label302:
      Object localObject4 = null;
    }
  }
  
  private static boolean a(int paramInt)
  {
    return paramInt == 1;
  }
  
  private static Collection<cx> b(Cursor paramCursor)
  {
    ArrayList localArrayList = new ArrayList();
    int i = paramCursor.getColumnIndex("session_id");
    int j = paramCursor.getColumnIndex("start_time");
    int k = paramCursor.getColumnIndex("end_time");
    int m = paramCursor.getColumnIndex("new_sent");
    int n = paramCursor.getColumnIndex("endtime_sent");
    if (paramCursor.moveToNext())
    {
      Object localObject = paramCursor.getString(i);
      double d1 = paramCursor.getDouble(j);
      double d2 = paramCursor.getDouble(k);
      int i1 = paramCursor.getInt(m);
      int i2 = paramCursor.getInt(n);
      cp localcp = new cp(new HashSet());
      localObject = db.a((String)localObject);
      if (!a(i1)) {}
      for (boolean bool = true;; bool = false)
      {
        localArrayList.add(new cx((db)localObject, d1, Double.valueOf(d2), localcp, bool, true, a(i2)));
        break;
      }
    }
    return localArrayList;
  }
  
  private static Double c(cx paramcx)
  {
    Double localDouble = paramcx.a();
    paramcx = localDouble;
    if (localDouble == null) {
      paramcx = Double.valueOf(fg.b());
    }
    return paramcx;
  }
  
  private static Collection<cs> c(Cursor paramCursor)
  {
    ArrayList localArrayList = new ArrayList();
    int i = paramCursor.getColumnIndex("event_type");
    int j = paramCursor.getColumnIndex("event_data");
    int k = paramCursor.getColumnIndex("timestamp");
    while (paramCursor.moveToNext())
    {
      String str1 = paramCursor.getString(i);
      String str2 = paramCursor.getString(j);
      double d1 = paramCursor.getDouble(k);
      try
      {
        localArrayList.add(dd.a(str1, str2, d1));
      }
      catch (JSONException localJSONException)
      {
        AppboyLogger.e(a, String.format("Could not create AppboyEvent from [type=%s, data=%s, timestamp=%f] ... Skipping", new Object[] { str1, str2, Double.valueOf(d1) }));
      }
    }
    return localArrayList;
  }
  
  public final cx a()
  {
    try
    {
      Object localObject = String.format("%s = ?", new Object[] { "sealed" });
      localObject = c().query("ab_sessions", b, (String)localObject, new String[] { "0" }, null, null, null);
      if (((Cursor)localObject).getCount() > 1) {
        AppboyLogger.e(a, "Got > 1 session while trying to get stored open session. " + ((Cursor)localObject).getCount() + " open sessions in database");
      }
      localObject = a((Cursor)localObject);
      return (cx)localObject;
    }
    catch (Exception localException)
    {
      AppboyLogger.e(a, "Failed to retrieve stored open session.", localException);
    }
    return null;
  }
  
  public final void a(cx paramcx)
  {
    int j = 1;
    if (paramcx != null)
    {
      c().beginTransaction();
      for (;;)
      {
        try
        {
          b(paramcx);
          Object localObject1 = paramcx.e();
          Object localObject2 = new ContentValues();
          ((ContentValues)localObject2).put("session_id", d.toString());
          ((ContentValues)localObject2).put("start_time", Double.valueOf(e));
          ((ContentValues)localObject2).put("end_time", c(paramcx));
          if (paramcx.b())
          {
            i = 1;
            ((ContentValues)localObject2).put("new_sent", Integer.valueOf(i));
            if (!paramcx.d()) {
              break label285;
            }
            i = 1;
            ((ContentValues)localObject2).put("endtime_sent", Integer.valueOf(i));
            if (!paramcx.c()) {
              break label290;
            }
            i = j;
            ((ContentValues)localObject2).put("sealed", Integer.valueOf(i));
            c().beginTransaction();
            try
            {
              long l = c().insertWithOnConflict("ab_sessions", null, (ContentValues)localObject2, 5);
              localObject2 = a;
              String.format("Inserted session into row %d", new Object[] { Long.valueOf(l) });
              localObject1 = a.iterator();
              if (!((Iterator)localObject1).hasNext()) {
                break;
              }
              localObject2 = (cs)((Iterator)localObject1).next();
              l = c().insert("ab_events", null, a(d, (cs)localObject2));
              localObject2 = a;
              String.format("Inserted event into row %d", new Object[] { Long.valueOf(l) });
              continue;
              paramcx = finally;
            }
            finally {}
          }
          i = 0;
        }
        finally
        {
          c().endTransaction();
        }
        continue;
        label285:
        int i = 0;
        continue;
        label290:
        i = 0;
      }
      c().setTransactionSuccessful();
      c().endTransaction();
      c().setTransactionSuccessful();
      c().endTransaction();
      return;
    }
    AppboyLogger.e(a, "Erroneously received upsertSession call with null session value.  Please report this result to Appboy.");
  }
  
  public final void a(cx paramcx, cs paramcs)
  {
    int i;
    if (!dd.a(paramcs))
    {
      Object localObject = d;
      if (c().insert("ab_events", null, a((db)localObject, paramcs)) == -1L) {
        AppboyLogger.w(a, String.format("Failed to insert event [%s] for session with ID [%s]", new Object[] { paramcs.toString(), ((db)localObject).toString() }));
      }
      paramcs = new ContentValues();
      paramcs.put("end_time", c(paramcx));
      localObject = String.format("%s = ? AND %s = ?", new Object[] { "sealed", "session_id" });
      String str = String.valueOf(d);
      i = c().updateWithOnConflict("ab_sessions", paramcs, (String)localObject, new String[] { "0", str }, 2);
      if (!paramcx.c()) {
        break label161;
      }
      if (i == 0) {
        paramcx = a;
      }
    }
    label161:
    while (i == 1) {
      return;
    }
    AppboyLogger.w(a, String.format("Attempt to update end time affected %d rows, expected just one.", new Object[] { Integer.valueOf(i) }));
  }
  
  /* Error */
  public final Collection<cx> b()
  {
    // Byte code:
    //   0: new 174	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 175	java/util/ArrayList:<init>	()V
    //   7: astore 4
    //   9: ldc 109
    //   11: iconst_1
    //   12: anewarray 4	java/lang/Object
    //   15: dup
    //   16: iconst_0
    //   17: ldc -43
    //   19: aastore
    //   20: invokestatic 36	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   23: astore 5
    //   25: ldc 109
    //   27: iconst_1
    //   28: anewarray 4	java/lang/Object
    //   31: dup
    //   32: iconst_0
    //   33: ldc 40
    //   35: aastore
    //   36: invokestatic 36	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   39: astore 7
    //   41: getstatic 38	bo/app/fa:a	Ljava/lang/String;
    //   44: astore 6
    //   46: aload_0
    //   47: invokevirtual 141	bo/app/fa:c	()Landroid/database/sqlite/SQLiteDatabase;
    //   50: ldc -41
    //   52: getstatic 50	bo/app/fa:b	[Ljava/lang/String;
    //   55: aload 5
    //   57: iconst_1
    //   58: anewarray 32	java/lang/String
    //   61: dup
    //   62: iconst_0
    //   63: ldc_w 347
    //   66: aastore
    //   67: aconst_null
    //   68: aconst_null
    //   69: aconst_null
    //   70: invokevirtual 149	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   73: astore 6
    //   75: getstatic 38	bo/app/fa:a	Ljava/lang/String;
    //   78: ldc_w 349
    //   81: iconst_1
    //   82: anewarray 4	java/lang/Object
    //   85: dup
    //   86: iconst_0
    //   87: aload 6
    //   89: invokeinterface 221 1 0
    //   94: invokestatic 269	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   97: aastore
    //   98: invokestatic 36	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   101: invokestatic 352	com/appboy/support/AppboyLogger:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   104: pop
    //   105: aload 6
    //   107: invokestatic 354	bo/app/fa:b	(Landroid/database/Cursor;)Ljava/util/Collection;
    //   110: astore 5
    //   112: aload 6
    //   114: invokeinterface 138 1 0
    //   119: aload 5
    //   121: invokeinterface 357 1 0
    //   126: astore 8
    //   128: aload 8
    //   130: invokeinterface 301 1 0
    //   135: ifeq +194 -> 329
    //   138: aload 8
    //   140: invokeinterface 305 1 0
    //   145: checkcast 169	bo/app/cx
    //   148: astore 9
    //   150: aload 9
    //   152: getfield 257	bo/app/cx:d	Lbo/app/db;
    //   155: invokevirtual 74	bo/app/db:toString	()Ljava/lang/String;
    //   158: astore 5
    //   160: aload_0
    //   161: invokevirtual 141	bo/app/fa:c	()Landroid/database/sqlite/SQLiteDatabase;
    //   164: ldc -113
    //   166: getstatic 58	bo/app/fa:c	[Ljava/lang/String;
    //   169: aload 7
    //   171: iconst_1
    //   172: anewarray 32	java/lang/String
    //   175: dup
    //   176: iconst_0
    //   177: aload 5
    //   179: aastore
    //   180: aconst_null
    //   181: aconst_null
    //   182: aconst_null
    //   183: invokevirtual 149	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   186: astore 5
    //   188: new 157	bo/app/cp
    //   191: dup
    //   192: new 159	java/util/HashSet
    //   195: dup
    //   196: aload 5
    //   198: invokestatic 152	bo/app/fa:c	(Landroid/database/Cursor;)Ljava/util/Collection;
    //   201: invokespecial 162	java/util/HashSet:<init>	(Ljava/util/Collection;)V
    //   204: invokespecial 165	bo/app/cp:<init>	(Ljava/util/Set;)V
    //   207: astore 10
    //   209: aload 9
    //   211: getfield 257	bo/app/cx:d	Lbo/app/db;
    //   214: astore 11
    //   216: aload 9
    //   218: getfield 260	bo/app/cx:e	D
    //   221: dstore_1
    //   222: aload 9
    //   224: invokevirtual 189	bo/app/cx:a	()Ljava/lang/Double;
    //   227: astore 12
    //   229: aload 9
    //   231: invokevirtual 264	bo/app/cx:b	()Z
    //   234: ifne +70 -> 304
    //   237: iconst_1
    //   238: istore_3
    //   239: aload 4
    //   241: new 169	bo/app/cx
    //   244: dup
    //   245: aload 11
    //   247: dload_1
    //   248: aload 12
    //   250: aload 10
    //   252: iload_3
    //   253: iconst_1
    //   254: aload 9
    //   256: invokevirtual 274	bo/app/cx:d	()Z
    //   259: invokespecial 172	bo/app/cx:<init>	(Lbo/app/db;DLjava/lang/Double;Lbo/app/cp;ZZZ)V
    //   262: invokeinterface 358 2 0
    //   267: pop
    //   268: aload 5
    //   270: ifnull -142 -> 128
    //   273: aload 5
    //   275: invokeinterface 138 1 0
    //   280: goto -152 -> 128
    //   283: astore 4
    //   285: aload 6
    //   287: astore 5
    //   289: aload 5
    //   291: ifnull +10 -> 301
    //   294: aload 5
    //   296: invokeinterface 138 1 0
    //   301: aload 4
    //   303: athrow
    //   304: iconst_0
    //   305: istore_3
    //   306: goto -67 -> 239
    //   309: astore 4
    //   311: aconst_null
    //   312: astore 5
    //   314: aload 5
    //   316: ifnull +10 -> 326
    //   319: aload 5
    //   321: invokeinterface 138 1 0
    //   326: aload 4
    //   328: athrow
    //   329: aload 6
    //   331: ifnull +10 -> 341
    //   334: aload 6
    //   336: invokeinterface 138 1 0
    //   341: aload 4
    //   343: areturn
    //   344: astore 4
    //   346: aconst_null
    //   347: astore 5
    //   349: goto -60 -> 289
    //   352: astore 4
    //   354: goto -40 -> 314
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	357	0	this	fa
    //   221	27	1	d1	double
    //   238	68	3	bool	boolean
    //   7	233	4	localArrayList	ArrayList
    //   283	19	4	localObject1	Object
    //   309	33	4	localCollection	Collection<cx>
    //   344	1	4	localObject2	Object
    //   352	1	4	localObject3	Object
    //   23	325	5	localObject4	Object
    //   44	291	6	localObject5	Object
    //   39	131	7	str	String
    //   126	13	8	localIterator	Iterator
    //   148	107	9	localcx	cx
    //   207	44	10	localcp	cp
    //   214	32	11	localdb	db
    //   227	22	12	localDouble	Double
    // Exception table:
    //   from	to	target	type
    //   75	128	283	finally
    //   128	160	283	finally
    //   273	280	283	finally
    //   319	326	283	finally
    //   326	329	283	finally
    //   160	188	309	finally
    //   46	75	344	finally
    //   188	237	352	finally
    //   239	268	352	finally
  }
  
  public final void b(cx paramcx)
  {
    c().beginTransaction();
    try
    {
      String str = String.format("%s = ?", new Object[] { "session_id" });
      String[] arrayOfString = new String[1];
      arrayOfString[0] = d.toString();
      int i = c().delete("ab_sessions", str, arrayOfString);
      paramcx = a;
      String.format("Deleting session removed %d rows.", new Object[] { Integer.valueOf(i) });
      paramcx = String.format("%s = ?", new Object[] { "session_id" });
      i = c().delete("ab_events", paramcx, arrayOfString);
      paramcx = a;
      String.format("Deleting session events removed %d rows.", new Object[] { Integer.valueOf(i) });
      c().setTransactionSuccessful();
      return;
    }
    finally
    {
      c().endTransaction();
    }
  }
  
  public final SQLiteDatabase c()
  {
    try
    {
      if ((d == null) || (!d.isOpen())) {
        d = e.getWritableDatabase();
      }
      SQLiteDatabase localSQLiteDatabase = d;
      return localSQLiteDatabase;
    }
    finally {}
  }
}

/* Location:
 * Qualified Name:     bo.app.fa
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */