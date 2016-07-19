package com.google.android.gms.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

final class zzer$5
  implements zzet
{
  public void zza(zzll paramzzll, Map<String, String> paramMap)
  {
    paramMap = (String)paramMap.get("urls");
    if (TextUtils.isEmpty(paramMap))
    {
      zzkh.zzcy("URLs missing in canOpenURLs GMSG.");
      return;
    }
    String[] arrayOfString = paramMap.split(",");
    HashMap localHashMap = new HashMap();
    PackageManager localPackageManager = paramzzll.getContext().getPackageManager();
    int j = arrayOfString.length;
    int i = 0;
    if (i < j)
    {
      String str1 = arrayOfString[i];
      paramMap = str1.split(";", 2);
      String str2 = paramMap[0].trim();
      if (paramMap.length > 1)
      {
        paramMap = paramMap[1].trim();
        label102:
        if (localPackageManager.resolveActivity(new Intent(paramMap, Uri.parse(str2)), 65536) == null) {
          break label154;
        }
      }
      label154:
      for (boolean bool = true;; bool = false)
      {
        localHashMap.put(str1, Boolean.valueOf(bool));
        i += 1;
        break;
        paramMap = "android.intent.action.VIEW";
        break label102;
      }
    }
    paramzzll.zza("openableURLs", localHashMap);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzer.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */