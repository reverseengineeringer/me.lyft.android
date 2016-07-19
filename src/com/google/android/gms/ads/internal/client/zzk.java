package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.google.android.gms.R.styleable;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.internal.zzir;

@zzir
public final class zzk
{
  private final String zzall;
  private final AdSize[] zzauw;
  
  public zzk(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramContext = paramContext.getResources().obtainAttributes(paramAttributeSet, R.styleable.AdsAttrs);
    paramAttributeSet = paramContext.getString(R.styleable.AdsAttrs_adSize);
    String str = paramContext.getString(R.styleable.AdsAttrs_adSizes);
    int i;
    if (!TextUtils.isEmpty(paramAttributeSet))
    {
      i = 1;
      if (TextUtils.isEmpty(str)) {
        break label106;
      }
      label53:
      if ((i == 0) || (j != 0)) {
        break label112;
      }
    }
    for (zzauw = zzae(paramAttributeSet);; zzauw = zzae(str))
    {
      zzall = paramContext.getString(R.styleable.AdsAttrs_adUnitId);
      if (!TextUtils.isEmpty(zzall)) {
        return;
      }
      throw new IllegalArgumentException("Required XML attribute \"adUnitId\" was missing.");
      i = 0;
      break;
      label106:
      j = 0;
      break label53;
      label112:
      if ((i != 0) || (j == 0)) {
        break label133;
      }
    }
    label133:
    if (i != 0) {
      throw new IllegalArgumentException("Either XML attribute \"adSize\" or XML attribute \"supportedAdSizes\" should be specified, but not both.");
    }
    throw new IllegalArgumentException("Required XML attribute \"adSize\" was missing.");
  }
  
  private static AdSize[] zzae(String paramString)
  {
    String[] arrayOfString1 = paramString.split("\\s*,\\s*");
    AdSize[] arrayOfAdSize = new AdSize[arrayOfString1.length];
    int i = 0;
    if (i < arrayOfString1.length)
    {
      String str = arrayOfString1[i].trim();
      String[] arrayOfString2;
      if (str.matches("^(\\d+|FULL_WIDTH)\\s*[xX]\\s*(\\d+|AUTO_HEIGHT)$"))
      {
        arrayOfString2 = str.split("[xX]");
        arrayOfString2[0] = arrayOfString2[0].trim();
        arrayOfString2[1] = arrayOfString2[1].trim();
      }
      for (;;)
      {
        try
        {
          if ("FULL_WIDTH".equals(arrayOfString2[0]))
          {
            j = -1;
            boolean bool = "AUTO_HEIGHT".equals(arrayOfString2[1]);
            if (!bool) {
              continue;
            }
            k = -2;
            arrayOfAdSize[i] = new AdSize(j, k);
            i += 1;
            break;
          }
          int j = Integer.parseInt(arrayOfString2[0]);
          continue;
          int k = Integer.parseInt(arrayOfString2[1]);
          continue;
          paramString = "Could not parse XML attribute \"adSize\": ".concat(paramString);
        }
        catch (NumberFormatException paramString)
        {
          paramString = String.valueOf(str);
          if (paramString.length() == 0) {}
        }
        for (;;)
        {
          throw new IllegalArgumentException(paramString);
          paramString = new String("Could not parse XML attribute \"adSize\": ");
        }
        if ("BANNER".equals(str))
        {
          arrayOfAdSize[i] = AdSize.BANNER;
        }
        else if ("LARGE_BANNER".equals(str))
        {
          arrayOfAdSize[i] = AdSize.LARGE_BANNER;
        }
        else if ("FULL_BANNER".equals(str))
        {
          arrayOfAdSize[i] = AdSize.FULL_BANNER;
        }
        else if ("LEADERBOARD".equals(str))
        {
          arrayOfAdSize[i] = AdSize.LEADERBOARD;
        }
        else if ("MEDIUM_RECTANGLE".equals(str))
        {
          arrayOfAdSize[i] = AdSize.MEDIUM_RECTANGLE;
        }
        else if ("SMART_BANNER".equals(str))
        {
          arrayOfAdSize[i] = AdSize.SMART_BANNER;
        }
        else if ("WIDE_SKYSCRAPER".equals(str))
        {
          arrayOfAdSize[i] = AdSize.WIDE_SKYSCRAPER;
        }
        else
        {
          if (!"FLUID".equals(str)) {
            break label353;
          }
          arrayOfAdSize[i] = AdSize.FLUID;
        }
      }
      label353:
      paramString = String.valueOf(str);
      if (paramString.length() != 0) {}
      for (paramString = "Could not parse XML attribute \"adSize\": ".concat(paramString);; paramString = new String("Could not parse XML attribute \"adSize\": ")) {
        throw new IllegalArgumentException(paramString);
      }
    }
    if (arrayOfAdSize.length == 0)
    {
      paramString = String.valueOf(paramString);
      if (paramString.length() != 0) {}
      for (paramString = "Could not parse XML attribute \"adSize\": ".concat(paramString);; paramString = new String("Could not parse XML attribute \"adSize\": ")) {
        throw new IllegalArgumentException(paramString);
      }
    }
    return arrayOfAdSize;
  }
  
  public String getAdUnitId()
  {
    return zzall;
  }
  
  public AdSize[] zzl(boolean paramBoolean)
  {
    if ((!paramBoolean) && (zzauw.length != 1)) {
      throw new IllegalArgumentException("The adSizes XML attribute is only allowed on PublisherAdViews.");
    }
    return zzauw;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.client.zzk
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */