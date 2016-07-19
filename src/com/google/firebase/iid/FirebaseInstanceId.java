package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.support.annotation.Keep;
import android.support.v4.util.ArrayMap;
import android.util.Base64;
import android.util.Log;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import java.io.IOException;
import java.security.KeyPair;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.util.Map;

public class FirebaseInstanceId
{
  private static Map<String, FirebaseInstanceId> abO = new ArrayMap();
  private static zze baE;
  private final FirebaseApp baF;
  private final zzd baG;
  private final String baH;
  
  private FirebaseInstanceId(FirebaseApp paramFirebaseApp, zzd paramzzd)
  {
    baF = paramFirebaseApp;
    baG = paramzzd;
    baH = zzcwu();
    if (baH == null) {
      throw new IllegalStateException("IID failing to initialize, FirebaseApp is missing project ID");
    }
    FirebaseInstanceIdService.zza(baF.getApplicationContext(), this);
  }
  
  public static FirebaseInstanceId getInstance()
  {
    return getInstance(FirebaseApp.getInstance());
  }
  
  @Keep
  public static FirebaseInstanceId getInstance(FirebaseApp paramFirebaseApp)
  {
    try
    {
      FirebaseInstanceId localFirebaseInstanceId = (FirebaseInstanceId)abO.get(paramFirebaseApp.getOptions().getApplicationId());
      Object localObject = localFirebaseInstanceId;
      if (localFirebaseInstanceId == null)
      {
        localObject = zzd.zzb(paramFirebaseApp.getApplicationContext(), null);
        if (baE == null) {
          baE = new zze(((zzd)localObject).zzcxa());
        }
        localObject = new FirebaseInstanceId(paramFirebaseApp, (zzd)localObject);
        abO.put(paramFirebaseApp.getOptions().getApplicationId(), localObject);
      }
      return (FirebaseInstanceId)localObject;
    }
    finally {}
  }
  
  static String zza(KeyPair paramKeyPair)
  {
    paramKeyPair = paramKeyPair.getPublic().getEncoded();
    try
    {
      paramKeyPair = MessageDigest.getInstance("SHA1").digest(paramKeyPair);
      paramKeyPair[0] = ((byte)((paramKeyPair[0] & 0xF) + 112 & 0xFF));
      paramKeyPair = Base64.encodeToString(paramKeyPair, 0, 8, 11);
      return paramKeyPair;
    }
    catch (NoSuchAlgorithmException paramKeyPair)
    {
      Log.w("FirebaseInstanceId", "Unexpected error, device missing required alghorithms");
    }
    return null;
  }
  
  static void zza(Context paramContext, zzg paramzzg)
  {
    paramzzg.zzbna();
    paramzzg = new Intent();
    paramzzg.putExtra("CMD", "RST");
    paramContext.sendBroadcast(FirebaseInstanceIdInternalReceiver.zzh(paramContext, paramzzg));
  }
  
  static int zzdf(Context paramContext)
  {
    try
    {
      int i = getPackageManagergetPackageInfogetPackageName0versionCode;
      return i;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      paramContext = String.valueOf(paramContext);
      Log.w("FirebaseInstanceId", String.valueOf(paramContext).length() + 38 + "Never happens: can't find own package " + paramContext);
    }
    return 0;
  }
  
  static String zzdg(Context paramContext)
  {
    try
    {
      paramContext = getPackageManagergetPackageInfogetPackageName0versionName;
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      paramContext = String.valueOf(paramContext);
      Log.w("FirebaseInstanceId", String.valueOf(paramContext).length() + 38 + "Never happens: can't find own package " + paramContext);
    }
    return null;
  }
  
  static void zzdh(Context paramContext)
  {
    Intent localIntent = new Intent();
    localIntent.setPackage(paramContext.getPackageName());
    localIntent.putExtra("CMD", "SYNC");
    paramContext.sendBroadcast(FirebaseInstanceIdInternalReceiver.zzh(paramContext, localIntent));
  }
  
  static String zzej(Context paramContext)
  {
    return getInstancebaF.getOptions().getApplicationId();
  }
  
  static String zzz(byte[] paramArrayOfByte)
  {
    return Base64.encodeToString(paramArrayOfByte, 11);
  }
  
  public String getId()
  {
    return zza(baG.zzbmt());
  }
  
  public String getToken()
  {
    String str = zzcwv();
    if (str == null) {
      FirebaseInstanceIdService.zzek(baF.getApplicationContext());
    }
    return str;
  }
  
  public String getToken(String paramString1, String paramString2)
    throws IOException
  {
    return baG.getToken(paramString1, paramString2, null);
  }
  
  String zzcwu()
  {
    Object localObject = baF.getOptions().getGcmSenderId();
    if (localObject != null) {}
    String str;
    do
    {
      do
      {
        return (String)localObject;
        str = baF.getOptions().getApplicationId();
        localObject = str;
      } while (!str.startsWith("1:"));
      localObject = str.split(":");
      if (localObject.length < 2) {
        return null;
      }
      str = localObject[1];
      localObject = str;
    } while (!str.isEmpty());
    return null;
  }
  
  String zzcwv()
  {
    return baG.zzcxa().zzi("", baH, "*");
  }
  
  String zzcww()
    throws IOException
  {
    return getToken(baH, "*");
  }
  
  zze zzcwx()
  {
    return baE;
  }
  
  void zzsg(String paramString)
    throws IOException
  {
    if (getToken() == null) {
      throw new IOException("token not available");
    }
    Bundle localBundle = new Bundle();
    Object localObject = String.valueOf("/topics/");
    String str1 = String.valueOf(paramString);
    String str2;
    if (str1.length() != 0)
    {
      localObject = ((String)localObject).concat(str1);
      localBundle.putString("gcm.topic", (String)localObject);
      localObject = baG;
      str1 = getToken();
      str2 = String.valueOf("/topics/");
      paramString = String.valueOf(paramString);
      if (paramString.length() == 0) {
        break label122;
      }
    }
    label122:
    for (paramString = str2.concat(paramString);; paramString = new String(str2))
    {
      ((zzd)localObject).getToken(str1, paramString, localBundle);
      return;
      localObject = new String((String)localObject);
      break;
    }
  }
  
  void zzsh(String paramString)
    throws IOException
  {
    if (getToken() == null) {
      throw new IOException("token not available");
    }
    Bundle localBundle = new Bundle();
    Object localObject = String.valueOf("/topics/");
    String str1 = String.valueOf(paramString);
    String str2;
    if (str1.length() != 0)
    {
      localObject = ((String)localObject).concat(str1);
      localBundle.putString("gcm.topic", (String)localObject);
      localObject = baG;
      str1 = getToken();
      str2 = String.valueOf("/topics/");
      paramString = String.valueOf(paramString);
      if (paramString.length() == 0) {
        break label121;
      }
    }
    label121:
    for (paramString = str2.concat(paramString);; paramString = new String(str2))
    {
      ((zzd)localObject).zzb(str1, paramString, localBundle);
      return;
      localObject = new String((String)localObject);
      break;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.firebase.iid.FirebaseInstanceId
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */