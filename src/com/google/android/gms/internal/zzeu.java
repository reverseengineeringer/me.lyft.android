package com.google.android.gms.internal;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzu;
import java.io.BufferedOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzir
public class zzeu
  implements zzet
{
  private final Context mContext;
  private final VersionInfoParcel zzalm;
  
  public zzeu(Context paramContext, VersionInfoParcel paramVersionInfoParcel)
  {
    mContext = paramContext;
    zzalm = paramVersionInfoParcel;
  }
  
  protected zzc zza(zzb paramzzb)
  {
    HttpURLConnection localHttpURLConnection;
    try
    {
      localHttpURLConnection = (HttpURLConnection)paramzzb.zzlh().openConnection();
      zzu.zzfq().zza(mContext, zzalm.zzcs, false, localHttpURLConnection);
      localObject1 = paramzzb.zzli().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (zza)((Iterator)localObject1).next();
        localHttpURLConnection.addRequestProperty(((zza)localObject2).getKey(), ((zza)localObject2).getValue());
      }
      if (TextUtils.isEmpty(paramzzb.zzlj())) {
        break label144;
      }
    }
    catch (Exception paramzzb)
    {
      return new zzc(false, null, paramzzb.toString());
    }
    localHttpURLConnection.setDoOutput(true);
    Object localObject1 = paramzzb.zzlj().getBytes();
    localHttpURLConnection.setFixedLengthStreamingMode(localObject1.length);
    Object localObject2 = new BufferedOutputStream(localHttpURLConnection.getOutputStream());
    ((BufferedOutputStream)localObject2).write((byte[])localObject1);
    ((BufferedOutputStream)localObject2).close();
    label144:
    localObject1 = new ArrayList();
    if (localHttpURLConnection.getHeaderFields() != null)
    {
      localObject2 = localHttpURLConnection.getHeaderFields().entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject2).next();
        Iterator localIterator = ((List)localEntry.getValue()).iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          ((ArrayList)localObject1).add(new zza((String)localEntry.getKey(), str));
        }
      }
    }
    paramzzb = new zzc(true, new zzd(paramzzb.zzlg(), localHttpURLConnection.getResponseCode(), (List)localObject1, zzu.zzfq().zza(new InputStreamReader(localHttpURLConnection.getInputStream()))), null);
    return paramzzb;
  }
  
  protected JSONObject zza(zzd paramzzd)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("http_request_id", paramzzd.zzlg());
      if (paramzzd.getBody() != null) {
        localJSONObject.put("body", paramzzd.getBody());
      }
      JSONArray localJSONArray = new JSONArray();
      Iterator localIterator = paramzzd.zzll().iterator();
      while (localIterator.hasNext())
      {
        zza localzza = (zza)localIterator.next();
        localJSONArray.put(new JSONObject().put("key", localzza.getKey()).put("value", localzza.getValue()));
      }
      localJSONObject.put("headers", localJSONArray);
    }
    catch (JSONException paramzzd)
    {
      zzkh.zzb("Error constructing JSON for http response.", paramzzd);
      return localJSONObject;
    }
    localJSONObject.put("response_code", paramzzd.getResponseCode());
    return localJSONObject;
  }
  
  public void zza(final zzll paramzzll, final Map<String, String> paramMap)
  {
    zzkk.zza(new Runnable()
    {
      public void run()
      {
        zzkh.zzcw("Received Http request.");
        final Object localObject = (String)paramMap.get("http_request");
        localObject = zzaw((String)localObject);
        if (localObject == null)
        {
          zzkh.e("Response should not be null.");
          return;
        }
        zzkl.zzclg.post(new Runnable()
        {
          public void run()
          {
            zzbii.zzb("fetchHttpRequestCompleted", localObject);
            zzkh.zzcw("Dispatched http response.");
          }
        });
      }
    });
  }
  
  /* Error */
  public JSONObject zzaw(String paramString)
  {
    // Byte code:
    //   0: new 201	org/json/JSONObject
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 262	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   8: astore 4
    //   10: new 201	org/json/JSONObject
    //   13: dup
    //   14: invokespecial 202	org/json/JSONObject:<init>	()V
    //   17: astore_3
    //   18: ldc_w 264
    //   21: astore_1
    //   22: aload 4
    //   24: ldc -52
    //   26: invokevirtual 268	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   29: astore_2
    //   30: aload_2
    //   31: astore_1
    //   32: aload_0
    //   33: aload_0
    //   34: aload 4
    //   36: invokevirtual 271	com/google/android/gms/internal/zzeu:zzc	(Lorg/json/JSONObject;)Lcom/google/android/gms/internal/zzeu$zzb;
    //   39: invokevirtual 273	com/google/android/gms/internal/zzeu:zza	(Lcom/google/android/gms/internal/zzeu$zzb;)Lcom/google/android/gms/internal/zzeu$zzc;
    //   42: astore 4
    //   44: aload_2
    //   45: astore_1
    //   46: aload 4
    //   48: invokevirtual 276	com/google/android/gms/internal/zzeu$zzc:isSuccess	()Z
    //   51: ifeq +68 -> 119
    //   54: aload_2
    //   55: astore_1
    //   56: aload_3
    //   57: ldc_w 278
    //   60: aload_0
    //   61: aload 4
    //   63: invokevirtual 282	com/google/android/gms/internal/zzeu$zzc:zzlk	()Lcom/google/android/gms/internal/zzeu$zzd;
    //   66: invokevirtual 284	com/google/android/gms/internal/zzeu:zza	(Lcom/google/android/gms/internal/zzeu$zzd;)Lorg/json/JSONObject;
    //   69: invokevirtual 209	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   72: pop
    //   73: aload_2
    //   74: astore_1
    //   75: aload_3
    //   76: ldc_w 286
    //   79: iconst_1
    //   80: invokevirtual 289	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   83: pop
    //   84: aload_3
    //   85: areturn
    //   86: astore_1
    //   87: ldc_w 291
    //   90: invokestatic 294	com/google/android/gms/internal/zzkh:e	(Ljava/lang/String;)V
    //   93: new 201	org/json/JSONObject
    //   96: dup
    //   97: invokespecial 202	org/json/JSONObject:<init>	()V
    //   100: ldc_w 286
    //   103: iconst_0
    //   104: invokevirtual 289	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   107: astore_1
    //   108: aload_1
    //   109: areturn
    //   110: astore_1
    //   111: new 201	org/json/JSONObject
    //   114: dup
    //   115: invokespecial 202	org/json/JSONObject:<init>	()V
    //   118: areturn
    //   119: aload_2
    //   120: astore_1
    //   121: aload_3
    //   122: ldc_w 278
    //   125: new 201	org/json/JSONObject
    //   128: dup
    //   129: invokespecial 202	org/json/JSONObject:<init>	()V
    //   132: ldc -52
    //   134: aload_2
    //   135: invokevirtual 209	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   138: invokevirtual 209	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   141: pop
    //   142: aload_2
    //   143: astore_1
    //   144: aload_3
    //   145: ldc_w 286
    //   148: iconst_0
    //   149: invokevirtual 289	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   152: pop
    //   153: aload_2
    //   154: astore_1
    //   155: aload_3
    //   156: ldc_w 296
    //   159: aload 4
    //   161: invokevirtual 299	com/google/android/gms/internal/zzeu$zzc:getReason	()Ljava/lang/String;
    //   164: invokevirtual 209	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   167: pop
    //   168: aload_3
    //   169: areturn
    //   170: astore_2
    //   171: aload_3
    //   172: ldc_w 278
    //   175: new 201	org/json/JSONObject
    //   178: dup
    //   179: invokespecial 202	org/json/JSONObject:<init>	()V
    //   182: ldc -52
    //   184: aload_1
    //   185: invokevirtual 209	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   188: invokevirtual 209	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   191: pop
    //   192: aload_3
    //   193: ldc_w 286
    //   196: iconst_0
    //   197: invokevirtual 289	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   200: pop
    //   201: aload_3
    //   202: ldc_w 296
    //   205: aload_2
    //   206: invokevirtual 103	java/lang/Exception:toString	()Ljava/lang/String;
    //   209: invokevirtual 209	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   212: pop
    //   213: aload_3
    //   214: areturn
    //   215: astore_1
    //   216: aload_3
    //   217: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	218	0	this	zzeu
    //   0	218	1	paramString	String
    //   29	125	2	str	String
    //   170	36	2	localException	Exception
    //   17	200	3	localJSONObject	JSONObject
    //   8	152	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   0	10	86	org/json/JSONException
    //   93	108	110	org/json/JSONException
    //   22	30	170	java/lang/Exception
    //   32	44	170	java/lang/Exception
    //   46	54	170	java/lang/Exception
    //   56	73	170	java/lang/Exception
    //   75	84	170	java/lang/Exception
    //   121	142	170	java/lang/Exception
    //   144	153	170	java/lang/Exception
    //   155	168	170	java/lang/Exception
    //   171	213	215	org/json/JSONException
  }
  
  protected zzb zzc(JSONObject paramJSONObject)
  {
    String str1 = paramJSONObject.optString("http_request_id");
    Object localObject1 = paramJSONObject.optString("url");
    String str2 = paramJSONObject.optString("post_body", null);
    try
    {
      localObject1 = new URL((String)localObject1);
      localArrayList = new ArrayList();
      localObject2 = paramJSONObject.optJSONArray("headers");
      paramJSONObject = (JSONObject)localObject2;
      if (localObject2 == null) {
        paramJSONObject = new JSONArray();
      }
      int i = 0;
      for (;;)
      {
        if (i >= paramJSONObject.length()) {
          break label140;
        }
        localObject2 = paramJSONObject.optJSONObject(i);
        if (localObject2 != null) {
          break;
        }
        i += 1;
      }
    }
    catch (MalformedURLException localMalformedURLException)
    {
      ArrayList localArrayList;
      URL localURL;
      for (;;)
      {
        Object localObject2;
        zzkh.zzb("Error constructing http request.", localMalformedURLException);
        localURL = null;
        continue;
        localArrayList.add(new zza(((JSONObject)localObject2).optString("key"), ((JSONObject)localObject2).optString("value")));
      }
      label140:
      return new zzb(str1, localURL, localArrayList, str2);
    }
  }
  
  @zzir
  static class zza
  {
    private final String mValue;
    private final String zzaxn;
    
    public zza(String paramString1, String paramString2)
    {
      zzaxn = paramString1;
      mValue = paramString2;
    }
    
    public String getKey()
    {
      return zzaxn;
    }
    
    public String getValue()
    {
      return mValue;
    }
  }
  
  @zzir
  static class zzb
  {
    private final String zzbim;
    private final URL zzbin;
    private final ArrayList<zzeu.zza> zzbio;
    private final String zzbip;
    
    public zzb(String paramString1, URL paramURL, ArrayList<zzeu.zza> paramArrayList, String paramString2)
    {
      zzbim = paramString1;
      zzbin = paramURL;
      if (paramArrayList == null) {}
      for (zzbio = new ArrayList();; zzbio = paramArrayList)
      {
        zzbip = paramString2;
        return;
      }
    }
    
    public String zzlg()
    {
      return zzbim;
    }
    
    public URL zzlh()
    {
      return zzbin;
    }
    
    public ArrayList<zzeu.zza> zzli()
    {
      return zzbio;
    }
    
    public String zzlj()
    {
      return zzbip;
    }
  }
  
  @zzir
  class zzc
  {
    private final zzeu.zzd zzbiq;
    private final boolean zzbir;
    private final String zzbis;
    
    public zzc(boolean paramBoolean, zzeu.zzd paramzzd, String paramString)
    {
      zzbir = paramBoolean;
      zzbiq = paramzzd;
      zzbis = paramString;
    }
    
    public String getReason()
    {
      return zzbis;
    }
    
    public boolean isSuccess()
    {
      return zzbir;
    }
    
    public zzeu.zzd zzlk()
    {
      return zzbiq;
    }
  }
  
  @zzir
  static class zzd
  {
    private final String zzbfm;
    private final String zzbim;
    private final int zzbit;
    private final List<zzeu.zza> zzbiu;
    
    public zzd(String paramString1, int paramInt, List<zzeu.zza> paramList, String paramString2)
    {
      zzbim = paramString1;
      zzbit = paramInt;
      if (paramList == null) {}
      for (zzbiu = new ArrayList();; zzbiu = paramList)
      {
        zzbfm = paramString2;
        return;
      }
    }
    
    public String getBody()
    {
      return zzbfm;
    }
    
    public int getResponseCode()
    {
      return zzbit;
    }
    
    public String zzlg()
    {
      return zzbim;
    }
    
    public Iterable<zzeu.zza> zzll()
    {
      return zzbiu;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzeu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */