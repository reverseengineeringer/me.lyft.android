package com.leanplum;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import com.leanplum.annotations.Parser;

public class LeanplumApplication
  extends Application
{
  private static LeanplumApplication a;
  
  public static Context getContext()
  {
    return a;
  }
  
  public static LeanplumApplication getInstance()
  {
    return a;
  }
  
  public Resources getResources()
  {
    if (g.a()) {
      return super.getResources();
    }
    return new LeanplumResources(super.getResources());
  }
  
  public void onCreate()
  {
    a = this;
    LeanplumActivityHelper.enableLifecycleCallbacks(this);
    super.onCreate();
    Parser.parseVariables(new Object[] { this });
  }
}

/* Location:
 * Qualified Name:     com.leanplum.LeanplumApplication
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */