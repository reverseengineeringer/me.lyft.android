package com.leanplum;

import android.app.Activity;
import android.app.Application;
import android.content.res.Resources;
import android.os.Build.VERSION;
import com.leanplum.annotations.Parser;
import com.leanplum.callbacks.VariablesChangedCallback;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class LeanplumActivityHelper
{
  static boolean a = false;
  static Activity b;
  private static boolean c;
  private static Queue<VariablesChangedCallback> g = new LinkedList();
  private Activity d;
  private LeanplumResources e;
  private LeanplumInflater f;
  
  public LeanplumActivityHelper(Activity paramActivity)
  {
    d = paramActivity;
    Leanplum.setApplicationContext(paramActivity.getApplicationContext());
    Parser.parseVariables(new Object[] { paramActivity });
  }
  
  private static void d(Activity arg0)
  {
    a = false;
    b = ???;
    if ((Leanplum.b) || (Leanplum.c))
    {
      Leanplum.c();
      ??? = c.b();
      if (??? != null) {
        ???.updateGeofencing();
      }
    }
    for (;;)
    {
      synchronized (g)
      {
        LinkedList localLinkedList = new LinkedList(g);
        g.clear();
        ??? = localLinkedList.iterator();
        if (!???.hasNext()) {
          return;
        }
      }
      ((VariablesChangedCallback)???.next()).variablesChanged();
    }
  }
  
  private static void e(Activity paramActivity)
  {
    if (a)
    {
      Leanplum.b();
      ag localag = c.b();
      if (localag != null) {
        localag.updateGeofencing();
      }
    }
    if (b == paramActivity) {
      b = null;
    }
  }
  
  public static void enableLifecycleCallbacks(Application paramApplication)
  {
    Leanplum.setApplicationContext(paramApplication.getApplicationContext());
    if (Build.VERSION.SDK_INT < 14) {
      return;
    }
    paramApplication.registerActivityLifecycleCallbacks(new O());
    c = true;
  }
  
  public static Activity getCurrentActivity()
  {
    return b;
  }
  
  public static void queueActionUponActive(VariablesChangedCallback paramVariablesChangedCallback)
  {
    if ((b != null) && (!b.isFinishing()) && (!a))
    {
      paramVariablesChangedCallback.variablesChanged();
      return;
    }
    synchronized (g)
    {
      g.add(paramVariablesChangedCallback);
      return;
    }
  }
  
  public LeanplumResources getLeanplumResources()
  {
    return getLeanplumResources(null);
  }
  
  public LeanplumResources getLeanplumResources(Resources paramResources)
  {
    if (e != null) {
      return e;
    }
    Resources localResources = paramResources;
    if (paramResources == null) {
      localResources = d.getResources();
    }
    if ((localResources instanceof LeanplumResources)) {
      return (LeanplumResources)localResources;
    }
    e = new LeanplumResources(localResources);
    return e;
  }
  
  public void onPause()
  {
    if (!c)
    {
      Activity localActivity = d;
      a = true;
    }
  }
  
  public void onResume()
  {
    if (!c) {
      d(d);
    }
  }
  
  public void onStop()
  {
    if (!c) {
      e(d);
    }
  }
  
  public void setContentView(int paramInt)
  {
    if (f == null) {
      f = LeanplumInflater.from(d);
    }
    d.setContentView(f.inflate(paramInt));
  }
}

/* Location:
 * Qualified Name:     com.leanplum.LeanplumActivityHelper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */