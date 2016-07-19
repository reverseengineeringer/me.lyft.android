package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Iterator;

@zzir
public class zzcl
{
  private final Object zzail = new Object();
  private final int zzart;
  private final int zzaru;
  private final int zzarv;
  private final zzcq zzarw;
  private ArrayList<String> zzarx = new ArrayList();
  private ArrayList<String> zzary = new ArrayList();
  private int zzarz = 0;
  private int zzasa = 0;
  private int zzasb = 0;
  private int zzasc;
  private String zzasd = "";
  private String zzase = "";
  
  public zzcl(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    zzart = paramInt1;
    zzaru = paramInt2;
    zzarv = paramInt3;
    zzarw = new zzcq(paramInt4);
  }
  
  private String zza(ArrayList<String> paramArrayList, int paramInt)
  {
    if (paramArrayList.isEmpty()) {
      paramArrayList = "";
    }
    Object localObject;
    do
    {
      return paramArrayList;
      localObject = new StringBuffer();
      paramArrayList = paramArrayList.iterator();
      do
      {
        if (!paramArrayList.hasNext()) {
          break;
        }
        ((StringBuffer)localObject).append((String)paramArrayList.next());
        ((StringBuffer)localObject).append(' ');
      } while (((StringBuffer)localObject).length() <= paramInt);
      ((StringBuffer)localObject).deleteCharAt(((StringBuffer)localObject).length() - 1);
      localObject = ((StringBuffer)localObject).toString();
      paramArrayList = (ArrayList<String>)localObject;
    } while (((String)localObject).length() < paramInt);
    return ((String)localObject).substring(0, paramInt);
  }
  
  private void zzf(String paramString, boolean paramBoolean)
  {
    if ((paramString == null) || (paramString.length() < zzarv)) {
      return;
    }
    synchronized (zzail)
    {
      zzarx.add(paramString);
      zzarz += paramString.length();
      if (paramBoolean) {
        zzary.add(paramString);
      }
      return;
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof zzcl)) {}
    do
    {
      return false;
      if (paramObject == this) {
        return true;
      }
      paramObject = (zzcl)paramObject;
    } while ((((zzcl)paramObject).zzhr() == null) || (!((zzcl)paramObject).zzhr().equals(zzhr())));
    return true;
  }
  
  public int getScore()
  {
    return zzasc;
  }
  
  public int hashCode()
  {
    return zzhr().hashCode();
  }
  
  public String toString()
  {
    int i = zzasa;
    int j = zzasc;
    int k = zzarz;
    String str1 = String.valueOf(zza(zzarx, 100));
    String str2 = String.valueOf(zza(zzary, 100));
    String str3 = zzasd;
    String str4 = zzase;
    return String.valueOf(str1).length() + 133 + String.valueOf(str2).length() + String.valueOf(str3).length() + String.valueOf(str4).length() + "ActivityContent fetchId: " + i + " score:" + j + " total_length:" + k + "\n text: " + str1 + "\n viewableText" + str2 + "\n signture: " + str3 + "\n viewableSignture: " + str4;
  }
  
  int zza(int paramInt1, int paramInt2)
  {
    return zzart * paramInt1 + zzaru * paramInt2;
  }
  
  public void zzd(String arg1, boolean paramBoolean)
  {
    zzf(???, paramBoolean);
    synchronized (zzail)
    {
      if (zzasb < 0) {
        zzkh.zzcw("ActivityContent: negative number of WebViews.");
      }
      zzhw();
      return;
    }
  }
  
  public void zze(String paramString, boolean paramBoolean)
  {
    zzf(paramString, paramBoolean);
  }
  
  public boolean zzhq()
  {
    for (;;)
    {
      synchronized (zzail)
      {
        if (zzasb == 0)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public String zzhr()
  {
    return zzasd;
  }
  
  public String zzhs()
  {
    return zzase;
  }
  
  public void zzht()
  {
    synchronized (zzail)
    {
      zzasc -= 100;
      return;
    }
  }
  
  public void zzhu()
  {
    synchronized (zzail)
    {
      zzasb -= 1;
      return;
    }
  }
  
  public void zzhv()
  {
    synchronized (zzail)
    {
      zzasb += 1;
      return;
    }
  }
  
  public void zzhw()
  {
    synchronized (zzail)
    {
      int i = zza(zzarz, zzasa);
      if (i > zzasc)
      {
        zzasc = i;
        zzasd = zzarw.zza(zzarx);
        zzase = zzarw.zza(zzary);
      }
      return;
    }
  }
  
  int zzhx()
  {
    return zzarz;
  }
  
  public void zzl(int paramInt)
  {
    zzasa = paramInt;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzcl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */