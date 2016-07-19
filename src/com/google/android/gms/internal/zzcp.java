package com.google.android.gms.internal;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@zzir
public abstract class zzcp
{
  private static MessageDigest zzasx = null;
  protected Object zzail = new Object();
  
  abstract byte[] zzaa(String paramString);
  
  protected MessageDigest zzie()
  {
    for (;;)
    {
      MessageDigest localMessageDigest;
      int i;
      synchronized (zzail)
      {
        if (zzasx != null)
        {
          localMessageDigest = zzasx;
          return localMessageDigest;
        }
        i = 0;
        if (i >= 2) {}
      }
      try
      {
        zzasx = MessageDigest.getInstance("MD5");
        i += 1;
        continue;
        localMessageDigest = zzasx;
        return localMessageDigest;
        localObject2 = finally;
        throw ((Throwable)localObject2);
      }
      catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
      {
        for (;;) {}
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzcp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */