package com.leanplum;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.util.Log;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class LeanplumResources
  extends Resources
{
  public LeanplumResources(Resources paramResources)
  {
    super(paramResources.getAssets(), paramResources.getDisplayMetrics(), paramResources.getConfiguration());
  }
  
  final <T> Var<T> a(int paramInt)
  {
    for (;;)
    {
      Object localObject8;
      Object localObject9;
      Object localObject10;
      Object localObject11;
      Iterator localIterator;
      try
      {
        localObject8 = getResourceEntryName(paramInt);
        localObject9 = getResourceTypeName(paramInt);
        if (FileManager.a == null) {
          return null;
        }
        localObject10 = (HashMap)FileManager.a.objectForKeyPath(new Object[0]);
        HashMap localHashMap = new HashMap();
        synchronized (aU.a)
        {
          localObject11 = ((HashMap)localObject10).keySet().iterator();
          Object localObject1;
          if (!((Iterator)localObject11).hasNext())
          {
            localObject4 = new HashMap();
            localObject1 = localHashMap.keySet().iterator();
            if (((Iterator)localObject1).hasNext()) {
              break label421;
            }
            localObject6 = getConfiguration();
            localObject5 = getDisplayMetrics();
            localObject1 = new HashSet();
            ??? = localHashMap.keySet().iterator();
            if (((Iterator)???).hasNext()) {
              break label451;
            }
            localObject6 = an.values();
            int i = localObject6.length;
            paramInt = 0;
            if (paramInt < i) {
              break label554;
            }
            localObject1 = localHashMap.keySet().iterator();
            if (((Iterator)localObject1).hasNext())
            {
              localObject1 = (String)((Iterator)localObject1).next();
              localObject1 = aU.b("__Android Resources." + (String)localObject1 + "." + (String)localHashMap.get(localObject1));
              return (Var<T>)localObject1;
            }
          }
          else
          {
            String str = (String)((Iterator)localObject11).next();
            if (!str.toLowerCase().startsWith((String)localObject9)) {
              continue;
            }
            localIterator = ((HashMap)((HashMap)localObject10).get(str)).keySet().iterator();
            localObject1 = null;
            if (localIterator.hasNext()) {
              break label354;
            }
            if (localObject1 == null) {
              continue;
            }
            localHashMap.put(str, localObject1);
          }
        }
        return null;
      }
      catch (Exception localException)
      {
        Log.e("Leanplum", "Error getting resource", localException);
      }
      label354:
      Object localObject5 = (String)localIterator.next();
      Object localObject6 = ((String)localObject5).replace("\\.", ".");
      paramInt = ((String)localObject6).lastIndexOf('.');
      Object localObject4 = localObject6;
      if (paramInt >= 0) {
        localObject4 = ((String)localObject6).substring(0, paramInt);
      }
      boolean bool = ((String)localObject4).equals(localObject8);
      if (bool)
      {
        Object localObject3 = localObject5;
        continue;
        label421:
        localObject5 = (String)((Iterator)localObject3).next();
        ((Map)localObject4).put(localObject5, am.a((String)localObject5));
        continue;
        label451:
        localObject8 = (String)((Iterator)???).next();
        localObject9 = (am)((Map)localObject4).get(localObject8);
        localObject10 = a.keySet().iterator();
        while (((Iterator)localObject10).hasNext())
        {
          localObject11 = (an)((Iterator)localObject10).next();
          if (((an)localObject11).a().a(a.get(localObject11), (Configuration)localObject6)) {
            ((Set)localObject3).add(localObject8);
          }
        }
        label554:
        ??? = localObject6[paramInt];
        localObject8 = new HashMap();
        localObject9 = ((Set)localObject3).iterator();
        for (;;)
        {
          if (!((Iterator)localObject9).hasNext())
          {
            ??? = ((an)???).a().a((Map)localObject8, (DisplayMetrics)localObject5);
            if (((Map)???).isEmpty()) {
              break;
            }
            localObject3 = ((Map)???).keySet();
            break;
          }
          localObject10 = (String)((Iterator)localObject9).next();
          localObject11 = geta.get(???);
          if (localObject11 != null) {
            ((Map)localObject8).put(localObject10, localObject11);
          }
        }
        paramInt += 1;
      }
    }
  }
  
  public Drawable getDrawable(int paramInt)
  {
    Object localObject = a(paramInt);
    if (localObject != null)
    {
      int i = ((Var)localObject).overrideResId();
      if (i != 0) {
        localObject = super.getDrawable(i);
      }
      Drawable localDrawable;
      do
      {
        return (Drawable)localObject;
        if (a.equals(((Var)localObject).defaultValue())) {
          break;
        }
        localDrawable = Drawable.createFromStream(((Var)localObject).stream(), ((Var)localObject).fileValue());
        localObject = localDrawable;
      } while (localDrawable != null);
    }
    return super.getDrawable(paramInt);
  }
}

/* Location:
 * Qualified Name:     com.leanplum.LeanplumResources
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */