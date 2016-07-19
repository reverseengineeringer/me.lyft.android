package com.google.android.gms.ads.internal.util.client;

import com.google.android.gms.ads.internal.client.zzm;
import com.google.android.gms.internal.zzir;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

@zzir
public class zzc
  implements zza.zza
{
  private final String zzbjj;
  
  public zzc()
  {
    this(null);
  }
  
  public zzc(String paramString)
  {
    zzbjj = paramString;
  }
  
  public void zzcs(String paramString)
  {
    for (;;)
    {
      try
      {
        localObject1 = String.valueOf(paramString);
        if (((String)localObject1).length() != 0)
        {
          localObject1 = "Pinging URL: ".concat((String)localObject1);
          zzb.zzcw((String)localObject1);
          localObject1 = (HttpURLConnection)new URL(paramString).openConnection();
        }
      }
      catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
      {
        Object localObject1;
        int i;
        str1 = String.valueOf(localIndexOutOfBoundsException.getMessage());
        zzb.zzcy(String.valueOf(paramString).length() + 32 + String.valueOf(str1).length() + "Error while parsing ping URL: " + paramString + ". " + str1);
        return;
      }
      catch (IOException localIOException)
      {
        String str1;
        String str2 = String.valueOf(localIOException.getMessage());
        zzb.zzcy(String.valueOf(paramString).length() + 27 + String.valueOf(str2).length() + "Error while pinging URL: " + paramString + ". " + str2);
        return;
      }
      catch (RuntimeException localRuntimeException)
      {
        String str3 = String.valueOf(localRuntimeException.getMessage());
        zzb.zzcy(String.valueOf(paramString).length() + 27 + String.valueOf(str3).length() + "Error while pinging URL: " + paramString + ". " + str3);
      }
      try
      {
        zzm.zziw().zza(true, (HttpURLConnection)localObject1, zzbjj);
        i = ((HttpURLConnection)localObject1).getResponseCode();
        if ((i < 200) || (i >= 300)) {
          zzb.zzcy(String.valueOf(paramString).length() + 65 + "Received non-success response code " + i + " from pinging URL: " + paramString);
        }
        ((HttpURLConnection)localObject1).disconnect();
        return;
      }
      finally
      {
        str1.disconnect();
      }
      localObject1 = new String("Pinging URL: ");
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.util.client.zzc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */