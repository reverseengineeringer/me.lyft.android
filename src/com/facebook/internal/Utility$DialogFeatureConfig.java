package com.facebook.internal;

import android.net.Uri;
import org.json.JSONArray;
import org.json.JSONObject;

public class Utility$DialogFeatureConfig
{
  private String dialogName;
  private Uri fallbackUrl;
  private String featureName;
  private int[] featureVersionSpec;
  
  private Utility$DialogFeatureConfig(String paramString1, String paramString2, Uri paramUri, int[] paramArrayOfInt)
  {
    dialogName = paramString1;
    featureName = paramString2;
    fallbackUrl = paramUri;
    featureVersionSpec = paramArrayOfInt;
  }
  
  private static DialogFeatureConfig parseDialogConfig(JSONObject paramJSONObject)
  {
    Object localObject = paramJSONObject.optString("name");
    if (Utility.isNullOrEmpty((String)localObject)) {}
    String str1;
    String str2;
    do
    {
      do
      {
        return null;
        localObject = ((String)localObject).split("\\|");
      } while (localObject.length != 2);
      str1 = localObject[0];
      str2 = localObject[1];
    } while ((Utility.isNullOrEmpty(str1)) || (Utility.isNullOrEmpty(str2)));
    String str3 = paramJSONObject.optString("url");
    localObject = null;
    if (!Utility.isNullOrEmpty(str3)) {
      localObject = Uri.parse(str3);
    }
    return new DialogFeatureConfig(str1, str2, (Uri)localObject, parseVersionSpec(paramJSONObject.optJSONArray("versions")));
  }
  
  private static int[] parseVersionSpec(JSONArray paramJSONArray)
  {
    Object localObject = null;
    if (paramJSONArray != null)
    {
      int m = paramJSONArray.length();
      int[] arrayOfInt = new int[m];
      int j = 0;
      for (;;)
      {
        localObject = arrayOfInt;
        if (j < m)
        {
          int k = paramJSONArray.optInt(j, -1);
          int i = k;
          if (k == -1)
          {
            localObject = paramJSONArray.optString(j);
            i = k;
            if (Utility.isNullOrEmpty((String)localObject)) {}
          }
          try
          {
            i = Integer.parseInt((String)localObject);
            arrayOfInt[j] = i;
            j += 1;
          }
          catch (NumberFormatException localNumberFormatException)
          {
            for (;;)
            {
              Utility.logd("FacebookSDK", localNumberFormatException);
              i = -1;
            }
          }
        }
      }
    }
    return localNumberFormatException;
  }
  
  public String getDialogName()
  {
    return dialogName;
  }
  
  public Uri getFallbackUrl()
  {
    return fallbackUrl;
  }
  
  public String getFeatureName()
  {
    return featureName;
  }
  
  public int[] getVersionSpec()
  {
    return featureVersionSpec;
  }
}

/* Location:
 * Qualified Name:     com.facebook.internal.Utility.DialogFeatureConfig
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */