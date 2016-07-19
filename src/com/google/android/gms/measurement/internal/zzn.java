package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.text.TextUtils;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzqk;
import java.io.ByteArrayInputStream;
import java.security.MessageDigest;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import javax.security.auth.x500.X500Principal;

public class zzn
  extends zzaa
{
  private static final X500Principal akJ = new X500Principal("CN=Android Debug,O=Android,C=US");
  private String ajg;
  private String ajn;
  private int akK;
  private long akL;
  private String zzcjj;
  private String zzcup;
  private String zzcuq;
  
  zzn(zzx paramzzx)
  {
    super(paramzzx);
  }
  
  String zzbqo()
  {
    zzzg();
    return ajg;
  }
  
  String zzbqu()
  {
    zzzg();
    return ajn;
  }
  
  long zzbqv()
  {
    return zzbtb().zzbqv();
  }
  
  long zzbqw()
  {
    zzzg();
    return akL;
  }
  
  int zzbtp()
  {
    zzzg();
    return akK;
  }
  
  boolean zzbtq()
  {
    try
    {
      Object localObject = getContext().getPackageManager().getPackageInfo(getContext().getPackageName(), 64);
      if ((localObject != null) && (signatures != null) && (signatures.length > 0))
      {
        localObject = signatures[0];
        boolean bool = ((X509Certificate)CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(((Signature)localObject).toByteArray()))).getSubjectX500Principal().equals(akJ);
        return bool;
      }
    }
    catch (CertificateException localCertificateException)
    {
      zzbsz().zzbtr().zzj("Error obtaining certificate", localCertificateException);
      return true;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        zzbsz().zzbtr().zzj("Package name not found", localNameNotFoundException);
      }
    }
  }
  
  protected void zzdq(Status paramStatus)
  {
    if (paramStatus == null)
    {
      zzbsz().zzbtr().log("GoogleService failed to initialize (no status)");
      return;
    }
    zzbsz().zzbtr().zze("GoogleService failed to initialize, status", Integer.valueOf(paramStatus.getStatusCode()), paramStatus.getStatusMessage());
  }
  
  AppMetadata zzlw(String paramString)
  {
    String str1 = zzsi();
    String str2 = zzbqo();
    String str3 = zzxc();
    long l1 = zzbtp();
    String str4 = zzbqu();
    long l2 = zzbqv();
    long l3 = zzbqw();
    boolean bool2 = aja.isEnabled();
    if (!zzbtaalJ) {}
    for (boolean bool1 = true;; bool1 = false) {
      return new AppMetadata(str1, str2, str3, l1, str4, l2, l3, paramString, bool2, bool1, zzbta().zzbqq());
    }
  }
  
  String zzsi()
  {
    zzzg();
    return zzcjj;
  }
  
  protected void zzwv()
  {
    String str3 = "Unknown";
    int j = Integer.MIN_VALUE;
    String str1 = "Unknown";
    PackageManager localPackageManager = getContext().getPackageManager();
    String str4 = getContext().getPackageName();
    Object localObject1 = localPackageManager.getInstallerPackageName(str4);
    Object localObject3;
    Object localObject4;
    String str2;
    if (localObject1 == null)
    {
      localObject3 = "manual_install";
      localObject4 = str1;
      str2 = str3;
    }
    try
    {
      PackageInfo localPackageInfo = localPackageManager.getPackageInfo(getContext().getPackageName(), 0);
      localObject1 = str1;
      i = j;
      str2 = str3;
      if (localPackageInfo != null)
      {
        localObject4 = str1;
        str2 = str3;
        CharSequence localCharSequence = localPackageManager.getApplicationLabel(applicationInfo);
        localObject1 = str1;
        localObject4 = str1;
        str2 = str3;
        if (!TextUtils.isEmpty(localCharSequence))
        {
          localObject4 = str1;
          str2 = str3;
          localObject1 = localCharSequence.toString();
        }
        localObject4 = localObject1;
        str2 = str3;
        str1 = versionName;
        localObject4 = localObject1;
        str2 = str1;
        i = versionCode;
        str2 = str1;
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException1)
    {
      for (;;)
      {
        zzbsz().zzbtr().zzj("Error retrieving package info: appName", localObject4);
        localObject2 = localObject4;
        i = j;
        continue;
        akL = 0L;
        try
        {
          if (zzbtq()) {
            continue;
          }
          localObject3 = localPackageManager.getPackageInfo(getContext().getPackageName(), 64);
          if ((signatures == null) || (signatures.length <= 0)) {
            continue;
          }
          akL = zzal.zzac(((MessageDigest)localObject2).digest(signatures[0].toByteArray()));
        }
        catch (PackageManager.NameNotFoundException localNameNotFoundException2)
        {
          zzbsz().zzbtr().zzj("Package name not found", localNameNotFoundException2);
        }
        continue;
        localStatus = zzqk.zzcb(getContext());
        continue;
        i = 0;
        continue;
        if ((localStatus != null) && (!localStatus.booleanValue()))
        {
          zzbsz().zzbtw().log("Collection disabled with firebase_analytics_collection_enabled=0");
          i = 0;
        }
        else if ((localStatus == null) && (zzbtb().zzaql()))
        {
          zzbsz().zzbtw().log("Collection disabled with google_app_measurement_enable=0");
          i = 0;
        }
        else
        {
          zzbsz().zzbty().log("Collection enabled");
          i = 1;
        }
      }
    }
    zzcjj = str4;
    ajn = ((String)localObject3);
    zzcuq = str2;
    akK = i;
    zzcup = ((String)localObject1);
    localObject1 = zzal.zzfb("MD5");
    if (localObject1 == null)
    {
      zzbsz().zzbtr().log("Could not get MD5 instance");
      akL = -1L;
      if (!zzbtb().zzabc()) {
        break label511;
      }
      localObject1 = zzqk.zzc(getContext(), "-", true);
      if ((localObject1 == null) || (!((Status)localObject1).isSuccess())) {
        break label522;
      }
      i = 1;
      if (i == 0) {
        zzdq((Status)localObject1);
      }
      if (i == 0) {
        break label622;
      }
      localObject1 = zzbtb().zzbsa();
      if (!zzbtb().zzbrz()) {
        break label527;
      }
      zzbsz().zzbtw().log("Collection disabled with firebase_analytics_collection_deactivated=1");
    }
    label511:
    label522:
    label527:
    label622:
    for (int i = 0;; i = 0)
    {
      ajg = "";
      if (!zzbtb().zzabc()) {}
      try
      {
        localObject3 = zzqk.zzaqk();
        localObject1 = localObject3;
        if (TextUtils.isEmpty((CharSequence)localObject3)) {
          localObject1 = "";
        }
        ajg = ((String)localObject1);
        if (i != 0) {
          zzbsz().zzbty().zze("App package, google app id", zzcjj, ajg);
        }
        return;
      }
      catch (IllegalStateException localIllegalStateException)
      {
        Object localObject2;
        Status localStatus;
        zzbsz().zzbtr().zzj("getGoogleAppId or isMeasurementEnabled failed with exception", localIllegalStateException);
        return;
      }
      localObject3 = localObject1;
      if (!"com.android.vending".equals(localObject1)) {
        break;
      }
      localObject3 = "";
      break;
    }
  }
  
  String zzxc()
  {
    zzzg();
    return zzcuq;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.measurement.internal.zzn
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */