package com.google.android.gms.internal;

public class zzaot
{
  private final byte[] bhO = new byte['Ā'];
  private int bhP;
  private int bhQ;
  
  public zzaot(byte[] paramArrayOfByte)
  {
    int j = 0;
    while (j < 256)
    {
      bhO[j] = ((byte)j);
      j += 1;
    }
    int k = 0;
    j = 0;
    while (j < 256)
    {
      k = k + bhO[j] + paramArrayOfByte[(j % paramArrayOfByte.length)] & 0xFF;
      int i = bhO[j];
      bhO[j] = bhO[k];
      bhO[k] = i;
      j += 1;
    }
    bhP = 0;
    bhQ = 0;
  }
  
  public void zzay(byte[] paramArrayOfByte)
  {
    int m = bhP;
    int k = bhQ;
    int j = 0;
    while (j < paramArrayOfByte.length)
    {
      m = m + 1 & 0xFF;
      k = k + bhO[m] & 0xFF;
      int i = bhO[m];
      bhO[m] = bhO[k];
      bhO[k] = i;
      paramArrayOfByte[j] = ((byte)(paramArrayOfByte[j] ^ bhO[(bhO[m] + bhO[k] & 0xFF)]));
      j += 1;
    }
    bhP = m;
    bhQ = k;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzaot
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */