package com.lyft.scoop.dagger;

import com.lyft.scoop.Scoop;
import com.lyft.scoop.Scoop.Builder;
import com.lyft.scoop.Screen;
import com.lyft.scoop.ScreenScoopFactory;

public class DaggerScreenScoopFactory
  extends ScreenScoopFactory
{
  protected Scoop addServices(Scoop.Builder paramBuilder, Screen paramScreen, Scoop paramScoop)
  {
    paramScoop = DaggerInjector.fromScoop(paramScoop);
    DaggerModule localDaggerModule = (DaggerModule)paramScreen.getClass().getAnnotation(DaggerModule.class);
    if (localDaggerModule == null) {
      return paramBuilder.service("dagger", paramScoop).build();
    }
    try
    {
      paramScoop = paramScoop.extend(new Object[] { localDaggerModule.value().newInstance() });
      return paramBuilder.service("dagger", paramScoop).build();
    }
    catch (Throwable paramBuilder)
    {
      throw new RuntimeException("Failed to instantiate module for screen: " + paramScreen.getClass().getSimpleName(), paramBuilder);
    }
  }
}

/* Location:
 * Qualified Name:     com.lyft.scoop.dagger.DaggerScreenScoopFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */