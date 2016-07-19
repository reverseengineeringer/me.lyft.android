package com.google.android.gms.internal;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.regex.Pattern;

public class zzaer
{
  public static final Uri CONTENT_URI = Uri.parse("content://com.google.android.gsf.gservices");
  public static final Uri aLW = Uri.parse("content://com.google.android.gsf.gservices/prefix");
  public static final Pattern aLX = Pattern.compile("^(1|true|t|on|yes|y)$", 2);
  public static final Pattern aLY = Pattern.compile("^(0|false|f|off|no|n)$", 2);
  private static HashMap<String, String> aLZ;
  private static Object aMa;
  private static String[] aMb = new String[0];
  private static Context aMc = null;
  
  public static long getLong(ContentResolver paramContentResolver, String paramString, long paramLong)
  {
    paramContentResolver = getString(paramContentResolver, paramString);
    long l = paramLong;
    if (paramContentResolver != null) {}
    try
    {
      l = Long.parseLong(paramContentResolver);
      return l;
    }
    catch (NumberFormatException paramContentResolver) {}
    return paramLong;
  }
  
  public static String getString(ContentResolver paramContentResolver, String paramString)
  {
    return zza(paramContentResolver, paramString, null);
  }
  
  public static String zza(ContentResolver paramContentResolver, String paramString1, String paramString2)
  {
    Object localObject2;
    try
    {
      zza(paramContentResolver);
      localObject2 = aMa;
      if (aLZ.containsKey(paramString1))
      {
        paramContentResolver = (String)aLZ.get(paramString1);
        if (paramContentResolver != null) {
          paramString2 = paramContentResolver;
        }
        return paramString2;
      }
      localObject1 = aMb;
      int j = localObject1.length;
      int i = 0;
      while (i < j)
      {
        str = paramString2;
        if (paramString1.startsWith(localObject1[i])) {
          break label229;
        }
        i += 1;
      }
    }
    finally {}
    tmp102_99[0] = paramString1;
    Object localObject1 = paramContentResolver.query(CONTENT_URI, null, null, tmp102_99, null);
    if (localObject1 != null) {}
    try
    {
      if (!((Cursor)localObject1).moveToFirst())
      {
        aLZ.put(paramString1, null);
        str = paramString2;
        return paramString2;
      }
      paramContentResolver = ((Cursor)localObject1).getString(1);
      try
      {
        if (localObject2 == aMa) {
          aLZ.put(paramString1, paramContentResolver);
        }
        if (paramContentResolver != null) {
          paramString2 = paramContentResolver;
        }
        str = paramString2;
        return paramString2;
      }
      finally {}
      return str;
    }
    finally
    {
      if (localObject1 != null) {
        ((Cursor)localObject1).close();
      }
    }
  }
  
  public static Map<String, String> zza(ContentResolver paramContentResolver, String... paramVarArgs)
  {
    paramContentResolver = paramContentResolver.query(aLW, null, null, paramVarArgs, null);
    paramVarArgs = new TreeMap();
    if (paramContentResolver == null) {
      return paramVarArgs;
    }
    try
    {
      if (paramContentResolver.moveToNext()) {
        paramVarArgs.put(paramContentResolver.getString(0), paramContentResolver.getString(1));
      }
      return paramVarArgs;
    }
    finally
    {
      paramContentResolver.close();
    }
  }
  
  private static void zza(final ContentResolver paramContentResolver)
  {
    if (aLZ == null)
    {
      aLZ = new HashMap();
      aMa = new Object();
      new Thread("Gservices")
      {
        public void run()
        {
          Looper.prepare();
          paramContentResolver.registerContentObserver(zzaer.CONTENT_URI, true, new ContentObserver(new Handler(Looper.myLooper()))
          {
            public void onChange(boolean paramAnonymous2Boolean)
            {
              try
              {
                zzaer.zzcjl().clear();
                zzaer.zzbb(new Object());
                if (zzaer.zzcjm().length > 0) {
                  zzaer.zzb(aMd, zzaer.zzcjm());
                }
                return;
              }
              finally {}
            }
          });
          Looper.loop();
        }
      }.start();
    }
  }
  
  public static void zzb(ContentResolver paramContentResolver, String... paramVarArgs)
  {
    Map localMap = zza(paramContentResolver, paramVarArgs);
    try
    {
      zza(paramContentResolver);
      aMb = paramVarArgs;
      paramContentResolver = localMap.entrySet().iterator();
      while (paramContentResolver.hasNext())
      {
        paramVarArgs = (Map.Entry)paramContentResolver.next();
        aLZ.put((String)paramVarArgs.getKey(), (String)paramVarArgs.getValue());
      }
    }
    finally {}
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzaer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */