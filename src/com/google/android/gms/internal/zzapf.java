package com.google.android.gms.internal;

import java.io.IOException;

public final class zzapf
{
  public static final int[] bim = new int[0];
  public static final long[] bin = new long[0];
  public static final float[] bio = new float[0];
  public static final double[] bip = new double[0];
  public static final boolean[] biq = new boolean[0];
  public static final String[] bir = new String[0];
  public static final byte[][] bis = new byte[0][];
  public static final byte[] bit = new byte[0];
  
  static int zzaez(int paramInt)
  {
    return paramInt & 0x7;
  }
  
  public static int zzafa(int paramInt)
  {
    return paramInt >>> 3;
  }
  
  public static int zzaj(int paramInt1, int paramInt2)
  {
    return paramInt1 << 3 | paramInt2;
  }
  
  public static boolean zzb(zzaou paramzzaou, int paramInt)
    throws IOException
  {
    return paramzzaou.zzaeg(paramInt);
  }
  
  public static final int zzc(zzaou paramzzaou, int paramInt)
    throws IOException
  {
    int i = 1;
    int j = paramzzaou.getPosition();
    paramzzaou.zzaeg(paramInt);
    while (paramzzaou.J() == paramInt)
    {
      paramzzaou.zzaeg(paramInt);
      i += 1;
    }
    paramzzaou.zzaek(j);
    return i;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzapf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */