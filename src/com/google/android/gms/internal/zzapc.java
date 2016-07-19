package com.google.android.gms.internal;

import java.io.IOException;

public abstract class zzapc
{
  protected volatile int bik = -1;
  
  public static final <T extends zzapc> T zza(T paramT, byte[] paramArrayOfByte)
    throws zzapb
  {
    return zzb(paramT, paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static final void zza(zzapc paramzzapc, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      paramArrayOfByte = zzaov.zzc(paramArrayOfByte, paramInt1, paramInt2);
      paramzzapc.zza(paramArrayOfByte);
      paramArrayOfByte.ab();
      return;
    }
    catch (IOException paramzzapc)
    {
      throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", paramzzapc);
    }
  }
  
  public static final <T extends zzapc> T zzb(T paramT, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws zzapb
  {
    try
    {
      paramArrayOfByte = zzaou.zzb(paramArrayOfByte, paramInt1, paramInt2);
      paramT.zzb(paramArrayOfByte);
      paramArrayOfByte.zzaef(0);
      return paramT;
    }
    catch (zzapb paramT)
    {
      throw paramT;
    }
    catch (IOException paramT)
    {
      throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).");
    }
  }
  
  public static final byte[] zzf(zzapc paramzzapc)
  {
    byte[] arrayOfByte = new byte[paramzzapc.ao()];
    zza(paramzzapc, arrayOfByte, 0, arrayOfByte.length);
    return arrayOfByte;
  }
  
  public zzapc ad()
    throws CloneNotSupportedException
  {
    return (zzapc)super.clone();
  }
  
  public int an()
  {
    if (bik < 0) {
      ao();
    }
    return bik;
  }
  
  public int ao()
  {
    int i = zzy();
    bik = i;
    return i;
  }
  
  public String toString()
  {
    return zzapd.zzg(this);
  }
  
  public void zza(zzaov paramzzaov)
    throws IOException
  {}
  
  public abstract zzapc zzb(zzaou paramzzaou)
    throws IOException;
  
  protected int zzy()
  {
    return 0;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzapc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */