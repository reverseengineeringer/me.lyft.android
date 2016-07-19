package com.google.android.gms.ads.internal;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.view.View.OnClickListener;
import com.google.android.gms.ads.internal.formats.zzd;
import com.google.android.gms.internal.zzdu;
import com.google.android.gms.internal.zzdu.zza;
import com.google.android.gms.internal.zzet;
import com.google.android.gms.internal.zzgd;
import com.google.android.gms.internal.zzgi;
import com.google.android.gms.internal.zzgo;
import com.google.android.gms.internal.zzgr;
import com.google.android.gms.internal.zzgs;
import com.google.android.gms.internal.zzir;
import com.google.android.gms.internal.zzjy;
import com.google.android.gms.internal.zzkh;
import com.google.android.gms.internal.zzll;
import com.google.android.gms.internal.zzlm;
import com.google.android.gms.internal.zzlm.zza;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzir
public class zzn
{
  private static zzd zza(zzgr paramzzgr)
    throws RemoteException
  {
    return new zzd(paramzzgr.getHeadline(), paramzzgr.getImages(), paramzzgr.getBody(), paramzzgr.zzkw(), paramzzgr.getCallToAction(), paramzzgr.getStarRating(), paramzzgr.getStore(), paramzzgr.getPrice(), null, paramzzgr.getExtras());
  }
  
  private static com.google.android.gms.ads.internal.formats.zze zza(zzgs paramzzgs)
    throws RemoteException
  {
    return new com.google.android.gms.ads.internal.formats.zze(paramzzgs.getHeadline(), paramzzgs.getImages(), paramzzgs.getBody(), paramzzgs.zzla(), paramzzgs.getCallToAction(), paramzzgs.getAdvertiser(), null, paramzzgs.getExtras());
  }
  
  static zzet zza(zzgr paramzzgr, final zzgs paramzzgs, final zzf.zza paramzza)
  {
    new zzet()
    {
      public void zza(zzll paramAnonymouszzll, Map<String, String> paramAnonymousMap)
      {
        paramAnonymousMap = paramAnonymouszzll.getView();
        if (paramAnonymousMap == null) {}
        do
        {
          return;
          try
          {
            if (zzn.this == null) {
              continue;
            }
            if (!getOverrideClickHandling())
            {
              zzk(com.google.android.gms.dynamic.zze.zzae(paramAnonymousMap));
              paramzza.onClick();
              return;
            }
          }
          catch (RemoteException paramAnonymouszzll)
          {
            zzkh.zzd("Unable to call handleClick on mapper", paramAnonymouszzll);
            return;
          }
          zzn.zzb(paramAnonymouszzll);
          return;
        } while (paramzzgs == null);
        if (!paramzzgs.getOverrideClickHandling())
        {
          paramzzgs.zzk(com.google.android.gms.dynamic.zze.zzae(paramAnonymousMap));
          paramzza.onClick();
          return;
        }
        zzn.zzb(paramAnonymouszzll);
      }
    };
  }
  
  static zzet zza(CountDownLatch paramCountDownLatch)
  {
    new zzet()
    {
      public void zza(zzll paramAnonymouszzll, Map<String, String> paramAnonymousMap)
      {
        countDown();
        paramAnonymouszzll = paramAnonymouszzll.getView();
        if (paramAnonymouszzll == null) {
          return;
        }
        paramAnonymouszzll.setVisibility(0);
      }
    };
  }
  
  private static String zza(Bitmap paramBitmap)
  {
    Object localObject = new ByteArrayOutputStream();
    if (paramBitmap == null)
    {
      zzkh.zzcy("Bitmap is null. Returning empty string");
      return "";
    }
    paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, (OutputStream)localObject);
    localObject = Base64.encodeToString(((ByteArrayOutputStream)localObject).toByteArray(), 0);
    paramBitmap = String.valueOf("data:image/png;base64,");
    localObject = String.valueOf(localObject);
    if (((String)localObject).length() != 0) {
      return paramBitmap.concat((String)localObject);
    }
    return new String(paramBitmap);
  }
  
  static String zza(zzdu paramzzdu)
  {
    if (paramzzdu == null)
    {
      zzkh.zzcy("Image is null. Returning empty string");
      return "";
    }
    try
    {
      Object localObject = paramzzdu.getUri();
      if (localObject != null)
      {
        localObject = ((Uri)localObject).toString();
        return (String)localObject;
      }
    }
    catch (RemoteException localRemoteException)
    {
      zzkh.zzcy("Unable to get image uri. Trying data uri next");
    }
    return zzb(paramzzdu);
  }
  
  private static JSONObject zza(Bundle paramBundle, String paramString)
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    if ((paramBundle == null) || (TextUtils.isEmpty(paramString))) {
      return localJSONObject;
    }
    paramString = new JSONObject(paramString);
    Iterator localIterator = paramString.keys();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (paramBundle.containsKey(str)) {
        if ("image".equals(paramString.getString(str)))
        {
          Object localObject = paramBundle.get(str);
          if ((localObject instanceof Bitmap)) {
            localJSONObject.put(str, zza((Bitmap)localObject));
          } else {
            zzkh.zzcy("Invalid type. An image type extra should return a bitmap");
          }
        }
        else if ((paramBundle.get(str) instanceof Bitmap))
        {
          zzkh.zzcy("Invalid asset type. Bitmap should be returned only for image type");
        }
        else
        {
          localJSONObject.put(str, String.valueOf(paramBundle.get(str)));
        }
      }
    }
    return localJSONObject;
  }
  
  public static void zza(zzjy paramzzjy, zzf.zza paramzza)
  {
    zzgs localzzgs = null;
    zzll localzzll;
    if ((paramzzjy != null) && (zzg(paramzzjy)))
    {
      localzzll = zzbtq;
      if (localzzll == null) {
        break label43;
      }
    }
    label43:
    for (View localView = localzzll.getView(); localView == null; localView = null)
    {
      zzkh.zzcy("AdWebView is null");
      return;
    }
    List localList;
    for (;;)
    {
      try
      {
        if (zzbor != null)
        {
          localList = zzbor.zzbnm;
          if ((localList != null) && (!localList.isEmpty())) {
            break;
          }
          zzkh.zzcy("No template ids present in mediation response");
          return;
        }
      }
      catch (RemoteException paramzzjy)
      {
        zzkh.zzd("Error occurred while recording impression and registering for clicks", paramzzjy);
        return;
      }
      localList = null;
    }
    if (zzbos != null) {}
    for (zzgr localzzgr = zzbos.zzmq();; localzzgr = null)
    {
      if (zzbos != null) {
        localzzgs = zzbos.zzmr();
      }
      if ((localList.contains("2")) && (localzzgr != null))
      {
        localzzgr.zzl(com.google.android.gms.dynamic.zze.zzae(localView));
        if (!localzzgr.getOverrideImpressionRecording()) {
          localzzgr.recordImpression();
        }
        localzzll.zzuk().zza("/nativeExpressViewClicked", zza(localzzgr, null, paramzza));
        return;
      }
      if ((localList.contains("1")) && (localzzgs != null))
      {
        localzzgs.zzl(com.google.android.gms.dynamic.zze.zzae(localView));
        if (!localzzgs.getOverrideImpressionRecording()) {
          localzzgs.recordImpression();
        }
        localzzll.zzuk().zza("/nativeExpressViewClicked", zza(null, localzzgs, paramzza));
        return;
      }
      zzkh.zzcy("No matching template id and mapper");
      return;
    }
  }
  
  private static void zza(zzll paramzzll)
  {
    View.OnClickListener localOnClickListener = paramzzll.zzux();
    if (localOnClickListener != null) {
      localOnClickListener.onClick(paramzzll.getView());
    }
  }
  
  private static void zza(final zzll paramzzll, zzd paramzzd, final String paramString)
  {
    paramzzll.zzuk().zza(new zzlm.zza()
    {
      public void zza(zzll paramAnonymouszzll, boolean paramAnonymousBoolean)
      {
        try
        {
          paramAnonymouszzll = new JSONObject();
          paramAnonymouszzll.put("headline", getHeadline());
          paramAnonymouszzll.put("body", getBody());
          paramAnonymouszzll.put("call_to_action", getCallToAction());
          paramAnonymouszzll.put("price", getPrice());
          paramAnonymouszzll.put("star_rating", String.valueOf(getStarRating()));
          paramAnonymouszzll.put("store", getStore());
          paramAnonymouszzll.put("icon", zzn.zza(zzkw()));
          localObject1 = new JSONArray();
          Object localObject2 = getImages();
          if (localObject2 != null)
          {
            localObject2 = ((List)localObject2).iterator();
            while (((Iterator)localObject2).hasNext()) {
              ((JSONArray)localObject1).put(zzn.zza(zzn.zzf(((Iterator)localObject2).next())));
            }
          }
          paramAnonymouszzll.put("images", localObject1);
        }
        catch (JSONException paramAnonymouszzll)
        {
          zzkh.zzd("Exception occurred when loading assets", paramAnonymouszzll);
          return;
        }
        paramAnonymouszzll.put("extras", zzn.zzb(getExtras(), paramString));
        Object localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("assets", paramAnonymouszzll);
        ((JSONObject)localObject1).put("template_id", "2");
        paramzzll.zza("google.afma.nativeExpressAds.loadAssets", (JSONObject)localObject1);
      }
    });
  }
  
  private static void zza(final zzll paramzzll, com.google.android.gms.ads.internal.formats.zze paramzze, final String paramString)
  {
    paramzzll.zzuk().zza(new zzlm.zza()
    {
      public void zza(zzll paramAnonymouszzll, boolean paramAnonymousBoolean)
      {
        try
        {
          paramAnonymouszzll = new JSONObject();
          paramAnonymouszzll.put("headline", getHeadline());
          paramAnonymouszzll.put("body", getBody());
          paramAnonymouszzll.put("call_to_action", getCallToAction());
          paramAnonymouszzll.put("advertiser", getAdvertiser());
          paramAnonymouszzll.put("logo", zzn.zza(zzla()));
          localObject1 = new JSONArray();
          Object localObject2 = getImages();
          if (localObject2 != null)
          {
            localObject2 = ((List)localObject2).iterator();
            while (((Iterator)localObject2).hasNext()) {
              ((JSONArray)localObject1).put(zzn.zza(zzn.zzf(((Iterator)localObject2).next())));
            }
          }
          paramAnonymouszzll.put("images", localObject1);
        }
        catch (JSONException paramAnonymouszzll)
        {
          zzkh.zzd("Exception occurred when loading assets", paramAnonymouszzll);
          return;
        }
        paramAnonymouszzll.put("extras", zzn.zzb(getExtras(), paramString));
        Object localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("assets", paramAnonymouszzll);
        ((JSONObject)localObject1).put("template_id", "1");
        paramzzll.zza("google.afma.nativeExpressAds.loadAssets", (JSONObject)localObject1);
      }
    });
  }
  
  private static void zza(zzll paramzzll, CountDownLatch paramCountDownLatch)
  {
    paramzzll.zzuk().zza("/nativeExpressAssetsLoaded", zza(paramCountDownLatch));
    paramzzll.zzuk().zza("/nativeExpressAssetsLoadingFailed", zzb(paramCountDownLatch));
  }
  
  public static boolean zza(zzll paramzzll, zzgi paramzzgi, CountDownLatch paramCountDownLatch)
  {
    boolean bool1 = false;
    try
    {
      boolean bool2 = zzb(paramzzll, paramzzgi, paramCountDownLatch);
      bool1 = bool2;
    }
    catch (RemoteException paramzzll)
    {
      for (;;)
      {
        zzkh.zzd("Unable to invoke load assets", paramzzll);
      }
    }
    catch (RuntimeException paramzzll)
    {
      paramCountDownLatch.countDown();
      throw paramzzll;
    }
    if (!bool1) {
      paramCountDownLatch.countDown();
    }
    return bool1;
  }
  
  static zzet zzb(CountDownLatch paramCountDownLatch)
  {
    new zzet()
    {
      public void zza(zzll paramAnonymouszzll, Map<String, String> paramAnonymousMap)
      {
        zzkh.zzcy("Adapter returned an ad, but assets substitution failed");
        countDown();
        paramAnonymouszzll.destroy();
      }
    };
  }
  
  private static String zzb(zzdu paramzzdu)
  {
    try
    {
      paramzzdu = paramzzdu.zzkv();
      if (paramzzdu == null)
      {
        zzkh.zzcy("Drawable is null. Returning empty string");
        return "";
      }
      paramzzdu = (Drawable)com.google.android.gms.dynamic.zze.zzad(paramzzdu);
      if (!(paramzzdu instanceof BitmapDrawable))
      {
        zzkh.zzcy("Drawable is not an instance of BitmapDrawable. Returning empty string");
        return "";
      }
    }
    catch (RemoteException paramzzdu)
    {
      zzkh.zzcy("Unable to get drawable. Returning empty string");
      return "";
    }
    return zza(((BitmapDrawable)paramzzdu).getBitmap());
  }
  
  private static boolean zzb(zzll paramzzll, zzgi paramzzgi, CountDownLatch paramCountDownLatch)
    throws RemoteException
  {
    Object localObject = paramzzll.getView();
    if (localObject == null)
    {
      zzkh.zzcy("AdWebView is null");
      return false;
    }
    ((View)localObject).setVisibility(4);
    localObject = zzbor.zzbnm;
    if ((localObject == null) || (((List)localObject).isEmpty()))
    {
      zzkh.zzcy("No template ids present in mediation response");
      return false;
    }
    zza(paramzzll, paramCountDownLatch);
    paramCountDownLatch = zzbos.zzmq();
    zzgs localzzgs = zzbos.zzmr();
    if ((((List)localObject).contains("2")) && (paramCountDownLatch != null))
    {
      zza(paramzzll, zza(paramCountDownLatch), zzbor.zzbnl);
      paramCountDownLatch = zzbor.zzbnj;
      paramzzgi = zzbor.zzbnk;
      if (paramzzgi == null) {
        break label189;
      }
      paramzzll.loadDataWithBaseURL(paramzzgi, paramCountDownLatch, "text/html", "UTF-8", null);
    }
    for (;;)
    {
      return true;
      if ((((List)localObject).contains("1")) && (localzzgs != null))
      {
        zza(paramzzll, zza(localzzgs), zzbor.zzbnl);
        break;
      }
      zzkh.zzcy("No matching template id and mapper");
      return false;
      label189:
      paramzzll.loadData(paramCountDownLatch, "text/html", "UTF-8");
    }
  }
  
  private static zzdu zze(Object paramObject)
  {
    if ((paramObject instanceof IBinder)) {
      return zzdu.zza.zzy((IBinder)paramObject);
    }
    return null;
  }
  
  public static View zzf(zzjy paramzzjy)
  {
    if (paramzzjy == null)
    {
      zzkh.e("AdState is null");
      return null;
    }
    if ((zzg(paramzzjy)) && (zzbtq != null)) {
      return zzbtq.getView();
    }
    for (;;)
    {
      try
      {
        if (zzbos != null)
        {
          paramzzjy = zzbos.getView();
          if (paramzzjy == null)
          {
            zzkh.zzcy("View in mediation adapter is null.");
            return null;
          }
          paramzzjy = (View)com.google.android.gms.dynamic.zze.zzad(paramzzjy);
          return paramzzjy;
        }
      }
      catch (RemoteException paramzzjy)
      {
        zzkh.zzd("Could not get View from mediation adapter.", paramzzjy);
        return null;
      }
      paramzzjy = null;
    }
  }
  
  public static boolean zzg(zzjy paramzzjy)
  {
    return (paramzzjy != null) && (zzccc) && (zzbor != null) && (zzbor.zzbnj != null);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.zzn
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */