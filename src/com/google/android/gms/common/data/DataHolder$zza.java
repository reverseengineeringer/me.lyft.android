package com.google.android.gms.common.data;

import com.google.android.gms.common.internal.zzab;
import java.util.ArrayList;
import java.util.HashMap;

public class DataHolder$zza
{
  private final String[] vO;
  private final ArrayList<HashMap<String, Object>> vX;
  private final String vY;
  private final HashMap<Object, Integer> vZ;
  private boolean wa;
  private String wb;
  
  private DataHolder$zza(String[] paramArrayOfString, String paramString)
  {
    vO = ((String[])zzab.zzaa(paramArrayOfString));
    vX = new ArrayList();
    vY = paramString;
    vZ = new HashMap();
    wa = false;
    wb = null;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.data.DataHolder.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */