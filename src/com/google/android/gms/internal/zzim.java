package com.google.android.gms.internal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.os.RemoteException;
import android.support.v4.util.SimpleArrayMap;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.formats.zza;
import com.google.android.gms.ads.internal.formats.zzc;
import com.google.android.gms.ads.internal.formats.zzf;
import com.google.android.gms.ads.internal.formats.zzh.zza;
import com.google.android.gms.ads.internal.formats.zzi;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.util.zzo;
import com.google.android.gms.dynamic.zze;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzir
public class zzim
  implements Callable<zzjy>
{
  private static final long zzbyx = TimeUnit.SECONDS.toMillis(60L);
  private final Context mContext;
  private final Object zzail = new Object();
  private final zzil zzbgf;
  private final zzas zzbgh;
  private final zzjy.zza zzbxv;
  private int zzbym;
  private final zzkr zzbzg;
  private final zzq zzbzh;
  private boolean zzbzi;
  private List<String> zzbzj;
  private JSONObject zzbzk;
  
  public zzim(Context paramContext, zzq paramzzq, zzkr paramzzkr, zzas paramzzas, zzjy.zza paramzza)
  {
    mContext = paramContext;
    zzbzh = paramzzq;
    zzbzg = paramzzkr;
    zzbxv = paramzza;
    zzbgh = paramzzas;
    zzbgf = zza(paramContext, paramzza, paramzzq, paramzzas);
    zzbgf.zzqh();
    zzbzi = false;
    zzbym = -2;
    zzbzj = null;
  }
  
  private zzh.zza zza(zza paramzza, JSONObject paramJSONObject, String paramString)
    throws ExecutionException, InterruptedException, JSONException
  {
    if (zzqt()) {
      return null;
    }
    JSONObject localJSONObject = paramJSONObject.getJSONObject("tracking_urls_and_actions");
    Object localObject = zzc(localJSONObject, "impression_tracking_urls");
    if (localObject == null) {}
    for (localObject = null;; localObject = Arrays.asList((Object[])localObject))
    {
      zzbzj = ((List)localObject);
      zzbzk = localJSONObject.optJSONObject("active_view");
      paramzza = paramzza.zza(this, paramJSONObject);
      if (paramzza != null) {
        break;
      }
      zzkh.e("Failed to retrieve ad assets.");
      return null;
    }
    paramzza.zzb(new zzi(mContext, zzbzh, zzbgf, zzbgh, paramJSONObject, paramzza, zzbxv.zzcit.zzaou, paramString));
    return paramzza;
  }
  
  private zzlc<zzc> zza(JSONObject paramJSONObject, final boolean paramBoolean1, boolean paramBoolean2)
    throws JSONException
  {
    if (paramBoolean1) {}
    final double d;
    for (String str = paramJSONObject.getString("url");; str = paramJSONObject.optString("url"))
    {
      d = paramJSONObject.optDouble("scale", 1.0D);
      if (!TextUtils.isEmpty(str)) {
        break;
      }
      zza(0, paramBoolean1);
      return new zzla(null);
    }
    if (paramBoolean2) {
      return new zzla(new zzc(null, Uri.parse(str), d));
    }
    zzbzg.zza(str, new zzkr.zza()
    {
      public zzc zzg(InputStream paramAnonymousInputStream)
      {
        try
        {
          paramAnonymousInputStream = zzo.zzk(paramAnonymousInputStream);
          if (paramAnonymousInputStream == null)
          {
            zza(2, paramBoolean1);
            return null;
          }
        }
        catch (IOException paramAnonymousInputStream)
        {
          for (;;)
          {
            paramAnonymousInputStream = null;
          }
          paramAnonymousInputStream = BitmapFactory.decodeByteArray(paramAnonymousInputStream, 0, paramAnonymousInputStream.length);
          if (paramAnonymousInputStream == null)
          {
            zza(2, paramBoolean1);
            return null;
          }
          paramAnonymousInputStream.setDensity((int)(160.0D * d));
        }
        return new zzc(new BitmapDrawable(Resources.getSystem(), paramAnonymousInputStream), Uri.parse(zzbqy), d);
      }
      
      public zzc zzqu()
      {
        zza(2, paramBoolean1);
        return null;
      }
    });
  }
  
  private void zza(zzh.zza paramzza)
  {
    if (!(paramzza instanceof zzf)) {
      return;
    }
    final Object localObject = (zzf)paramzza;
    paramzza = new zzb();
    localObject = new zzet()
    {
      public void zza(zzll paramAnonymouszzll, Map<String, String> paramAnonymousMap)
      {
        paramAnonymouszzll = (String)paramAnonymousMap.get("asset");
        zzim.zza(zzim.this, localObject, paramAnonymouszzll);
      }
    };
    zzcad = ((zzet)localObject);
    zzbgf.zza(new zzil.zza()
    {
      public void zze(zzfx paramAnonymouszzfx)
      {
        paramAnonymouszzfx.zza("/nativeAdCustomClick", localObject);
      }
    });
  }
  
  private zzjy zzb(zzh.zza paramzza)
  {
    for (;;)
    {
      synchronized (zzail)
      {
        int j = zzbym;
        int i = j;
        if (paramzza == null)
        {
          i = j;
          if (zzbym == -2) {
            i = 0;
          }
        }
        if (i != -2)
        {
          paramzza = null;
          return new zzjy(zzbxv.zzcit.zzcav, null, zzbxv.zzciu.zzbnq, i, zzbxv.zzciu.zzbnr, zzbzj, zzbxv.zzciu.orientation, zzbxv.zzciu.zzbnw, zzbxv.zzcit.zzcay, false, null, null, null, null, null, 0L, zzbxv.zzaoy, zzbxv.zzciu.zzccb, zzbxv.zzcio, zzbxv.zzcip, zzbxv.zzciu.zzcch, zzbzk, paramzza, null, null, null, zzbxv.zzciu.zzccu, zzbxv.zzciu.zzccv, null, zzbxv.zzciu.zzbnt);
        }
      }
    }
  }
  
  private Integer zzb(JSONObject paramJSONObject, String paramString)
  {
    try
    {
      paramJSONObject = paramJSONObject.getJSONObject(paramString);
      int i = Color.rgb(paramJSONObject.getInt("r"), paramJSONObject.getInt("g"), paramJSONObject.getInt("b"));
      return Integer.valueOf(i);
    }
    catch (JSONException paramJSONObject) {}
    return null;
  }
  
  private void zzb(zzec paramzzec, String paramString)
  {
    try
    {
      zzeg localzzeg = zzbzh.zzv(paramzzec.getCustomTemplateId());
      if (localzzeg != null) {
        localzzeg.zza(paramzzec, paramString);
      }
      return;
    }
    catch (RemoteException paramzzec)
    {
      zzkh.zzd(String.valueOf(paramString).length() + 40 + "Failed to call onCustomClick for asset " + paramString + ".", paramzzec);
    }
  }
  
  private String[] zzc(JSONObject paramJSONObject, String paramString)
    throws JSONException
  {
    paramJSONObject = paramJSONObject.optJSONArray(paramString);
    if (paramJSONObject == null) {
      return null;
    }
    paramString = new String[paramJSONObject.length()];
    int i = 0;
    while (i < paramJSONObject.length())
    {
      paramString[i] = paramJSONObject.getString(i);
      i += 1;
    }
    return paramString;
  }
  
  private JSONObject zzcc(final String paramString)
    throws ExecutionException, InterruptedException, TimeoutException, JSONException
  {
    if (zzqt()) {
      return null;
    }
    final zzkz localzzkz = new zzkz();
    paramString = new zzil.zza()
    {
      public void zze(final zzfx paramAnonymouszzfx)
      {
        Object localObject = new zzet()
        {
          public void zza(zzll paramAnonymous2zzll, Map<String, String> paramAnonymous2Map)
          {
            paramAnonymouszzfx.zzb("/nativeAdPreProcess", zzbzl.zzcad);
            try
            {
              paramAnonymous2zzll = (String)paramAnonymous2Map.get("success");
              if (!TextUtils.isEmpty(paramAnonymous2zzll))
              {
                zzbzm.zzi(new JSONObject(paramAnonymous2zzll).getJSONArray("ads").getJSONObject(0));
                return;
              }
            }
            catch (JSONException paramAnonymous2zzll)
            {
              zzkh.zzb("Malformed native JSON response.", paramAnonymous2zzll);
              zzan(0);
              zzab.zza(zzqt(), "Unable to set the ad state error!");
              zzbzm.zzi(null);
            }
          }
        };
        zzbzl.zzcad = ((zzet)localObject);
        paramAnonymouszzfx.zza("/nativeAdPreProcess", (zzet)localObject);
        try
        {
          localObject = new JSONObject(zzazzciu.body);
          ((JSONObject)localObject).put("ads_id", paramString);
          paramAnonymouszzfx.zza("google.afma.nativeAds.preProcessJsonGmsg", (JSONObject)localObject);
          return;
        }
        catch (JSONException paramAnonymouszzfx)
        {
          zzkh.zzd("Exception occurred while invoking javascript", paramAnonymouszzfx);
          localzzkz.zzi(null);
        }
      }
      
      public void zzqr()
      {
        localzzkz.zzi(null);
      }
    };
    zzbgf.zza(paramString);
    return (JSONObject)localzzkz.get(zzbyx, TimeUnit.MILLISECONDS);
  }
  
  private static List<Drawable> zzh(List<zzc> paramList)
    throws RemoteException
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add((Drawable)zze.zzad(((zzc)paramList.next()).zzkv()));
    }
    return localArrayList;
  }
  
  zzil zza(Context paramContext, zzjy.zza paramzza, zzq paramzzq, zzas paramzzas)
  {
    return new zzil(paramContext, paramzza, paramzzq, paramzzas);
  }
  
  public zzlc<zzc> zza(JSONObject paramJSONObject, String paramString, boolean paramBoolean1, boolean paramBoolean2)
    throws JSONException
  {
    if (paramBoolean1) {}
    for (paramJSONObject = paramJSONObject.getJSONObject(paramString);; paramJSONObject = paramJSONObject.optJSONObject(paramString))
    {
      paramString = paramJSONObject;
      if (paramJSONObject == null) {
        paramString = new JSONObject();
      }
      return zza(paramString, paramBoolean1, paramBoolean2);
    }
  }
  
  public List<zzlc<zzc>> zza(JSONObject paramJSONObject, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
    throws JSONException
  {
    if (paramBoolean1) {}
    ArrayList localArrayList;
    for (paramJSONObject = paramJSONObject.getJSONArray(paramString);; paramJSONObject = paramJSONObject.optJSONArray(paramString))
    {
      localArrayList = new ArrayList();
      if ((paramJSONObject != null) && (paramJSONObject.length() != 0)) {
        break;
      }
      zza(0, paramBoolean1);
      return localArrayList;
    }
    if (paramBoolean3) {}
    for (int i = paramJSONObject.length();; i = 1)
    {
      int j = 0;
      while (j < i)
      {
        JSONObject localJSONObject = paramJSONObject.getJSONObject(j);
        paramString = localJSONObject;
        if (localJSONObject == null) {
          paramString = new JSONObject();
        }
        localArrayList.add(zza(paramString, paramBoolean1, paramBoolean2));
        j += 1;
      }
    }
    return localArrayList;
  }
  
  public Future<zzc> zza(JSONObject paramJSONObject, String paramString, boolean paramBoolean)
    throws JSONException
  {
    paramString = paramJSONObject.getJSONObject(paramString);
    boolean bool = paramString.optBoolean("require", true);
    paramJSONObject = paramString;
    if (paramString == null) {
      paramJSONObject = new JSONObject();
    }
    return zza(paramJSONObject, bool, paramBoolean);
  }
  
  public void zza(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {
      zzan(paramInt);
    }
  }
  
  public void zzan(int paramInt)
  {
    synchronized (zzail)
    {
      zzbzi = true;
      zzbym = paramInt;
      return;
    }
  }
  
  protected zza zzf(JSONObject paramJSONObject)
    throws ExecutionException, InterruptedException, JSONException, TimeoutException
  {
    if (zzqt()) {
      return null;
    }
    final String str = paramJSONObject.getString("template_id");
    boolean bool1;
    if (zzbxv.zzcit.zzapm != null)
    {
      bool1 = zzbxv.zzcit.zzapm.zzbgt;
      if (zzbxv.zzcit.zzapm == null) {
        break label98;
      }
    }
    label98:
    for (boolean bool2 = zzbxv.zzcit.zzapm.zzbgv;; bool2 = false)
    {
      if (!"2".equals(str)) {
        break label103;
      }
      return new zzin(bool1, bool2);
      bool1 = false;
      break;
    }
    label103:
    if ("1".equals(str)) {
      return new zzio(bool1, bool2);
    }
    if ("3".equals(str))
    {
      str = paramJSONObject.getString("custom_template_id");
      final zzkz localzzkz = new zzkz();
      zzkl.zzclg.post(new Runnable()
      {
        public void run()
        {
          localzzkz.zzi((zzeh)zzim.zzb(zzim.this).zzfb().get(str));
        }
      });
      if (localzzkz.get(zzbyx, TimeUnit.MILLISECONDS) != null) {
        return new zzip(bool1);
      }
      paramJSONObject = String.valueOf(paramJSONObject.getString("custom_template_id"));
      if (paramJSONObject.length() != 0)
      {
        paramJSONObject = "No handler for custom template: ".concat(paramJSONObject);
        zzkh.e(paramJSONObject);
      }
    }
    for (;;)
    {
      return null;
      paramJSONObject = new String("No handler for custom template: ");
      break;
      zzan(0);
    }
  }
  
  public zzlc<zza> zzg(JSONObject paramJSONObject)
    throws JSONException
  {
    JSONObject localJSONObject = paramJSONObject.optJSONObject("attribution");
    if (localJSONObject == null) {
      return new zzla(null);
    }
    final String str = localJSONObject.optString("text");
    final int j = localJSONObject.optInt("text_size", -1);
    final Integer localInteger1 = zzb(localJSONObject, "text_color");
    final Integer localInteger2 = zzb(localJSONObject, "bg_color");
    final int k = localJSONObject.optInt("animation_ms", 1000);
    final int m = localJSONObject.optInt("presentation_ms", 4000);
    final int i;
    if ((zzbxv.zzcit.zzapm != null) && (zzbxv.zzcit.zzapm.versionCode >= 2))
    {
      i = zzbxv.zzcit.zzapm.zzbgw;
      paramJSONObject = new ArrayList();
      if (localJSONObject.optJSONArray("images") == null) {
        break label200;
      }
      paramJSONObject = zza(localJSONObject, "images", false, false, true);
    }
    for (;;)
    {
      zzlb.zza(zzlb.zzn(paramJSONObject), new zzlb.zza()
      {
        public zza zzj(List<zzc> paramAnonymousList)
        {
          if (paramAnonymousList != null) {
            for (;;)
            {
              try
              {
                if (paramAnonymousList.isEmpty()) {
                  break;
                }
                String str = str;
                List localList = zzim.zzi(paramAnonymousList);
                Integer localInteger1 = localInteger2;
                Integer localInteger2 = localInteger1;
                if (j > 0)
                {
                  paramAnonymousList = Integer.valueOf(j);
                  paramAnonymousList = new zza(str, localList, localInteger1, localInteger2, paramAnonymousList, m + k, i);
                }
              }
              catch (RemoteException paramAnonymousList)
              {
                zzkh.zzb("Could not get attribution icon", paramAnonymousList);
                return null;
              }
              paramAnonymousList = null;
            }
          }
          paramAnonymousList = null;
          return paramAnonymousList;
        }
      });
      i = 1;
      break;
      label200:
      paramJSONObject.add(zza(localJSONObject, "image", false, false));
    }
  }
  
  public zzjy zzqs()
  {
    try
    {
      zzbgf.zzqi();
      Object localObject = UUID.randomUUID().toString();
      JSONObject localJSONObject = zzcc((String)localObject);
      localObject = zza(zzf(localJSONObject), localJSONObject, (String)localObject);
      zza((zzh.zza)localObject);
      localObject = zzb((zzh.zza)localObject);
      return (zzjy)localObject;
    }
    catch (JSONException localJSONException)
    {
      zzkh.zzd("Malformed native JSON response.", localJSONException);
      if (!zzbzi) {
        zzan(0);
      }
      return zzb(null);
    }
    catch (TimeoutException localTimeoutException)
    {
      for (;;)
      {
        zzkh.zzd("Timeout when loading native ad.", localTimeoutException);
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;) {}
    }
    catch (ExecutionException localExecutionException)
    {
      for (;;) {}
    }
    catch (CancellationException localCancellationException)
    {
      for (;;) {}
    }
  }
  
  public boolean zzqt()
  {
    synchronized (zzail)
    {
      boolean bool = zzbzi;
      return bool;
    }
  }
  
  public static abstract interface zza<T extends zzh.zza>
  {
    public abstract T zza(zzim paramzzim, JSONObject paramJSONObject)
      throws JSONException, InterruptedException, ExecutionException;
  }
  
  class zzb
  {
    public zzet zzcad;
    
    zzb() {}
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzim
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */