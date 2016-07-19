package com.lyft.scoop.dagger;

import android.content.Context;
import android.view.View;
import com.lyft.scoop.Scoop;
import com.lyft.scoop.Scoop.Builder;
import com.lyft.scoop.Screen;
import dagger.ObjectGraph;

public class DaggerInjector
{
  private ObjectGraph objectGraph;
  
  public DaggerInjector(ObjectGraph paramObjectGraph)
  {
    objectGraph = paramObjectGraph;
  }
  
  public static Scoop extend(Scoop paramScoop, Object... paramVarArgs)
  {
    Screen localScreen = Screen.fromScoop(paramScoop);
    return new Scoop.Builder(localScreen.getClass().getSimpleName(), paramScoop).service("screen", localScreen).service("dagger", fromScoop(paramScoop).extend(paramVarArgs)).build();
  }
  
  public static DaggerInjector fromContext(Context paramContext)
  {
    return (DaggerInjector)Scoop.fromContext(paramContext).findService("dagger");
  }
  
  public static DaggerInjector fromScoop(Scoop paramScoop)
  {
    return (DaggerInjector)paramScoop.findService("dagger");
  }
  
  public static DaggerInjector fromView(View paramView)
  {
    return (DaggerInjector)Scoop.fromView(paramView).findService("dagger");
  }
  
  public DaggerInjector extend(Object... paramVarArgs)
  {
    return new DaggerInjector(objectGraph.plus(paramVarArgs));
  }
  
  public <T> T get(Class<T> paramClass)
  {
    return (T)objectGraph.get(paramClass);
  }
  
  public <T> void inject(T paramT)
  {
    objectGraph.inject(paramT);
  }
}

/* Location:
 * Qualified Name:     com.lyft.scoop.dagger.DaggerInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */