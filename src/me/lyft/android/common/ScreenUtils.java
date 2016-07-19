package me.lyft.android.common;

import com.lyft.scoop.RouteChange;
import com.lyft.scoop.Screen;
import java.util.List;

public class ScreenUtils
{
  public static String getFormattedName(Screen paramScreen)
  {
    if ((paramScreen instanceof IHasName)) {}
    StringBuilder localStringBuilder;
    for (paramScreen = ((IHasName)paramScreen).getName();; paramScreen = paramScreen.getClass().getName())
    {
      paramScreen = paramScreen.replaceAll(".*\\$", "");
      localStringBuilder = new StringBuilder();
      int i = 0;
      while (i < paramScreen.length())
      {
        char c2 = paramScreen.charAt(i);
        char c1 = c2;
        if (Character.isUpperCase(c2))
        {
          c2 = Character.toLowerCase(c2);
          c1 = c2;
          if (i != 0)
          {
            localStringBuilder.append('_');
            c1 = c2;
          }
        }
        localStringBuilder.append(c1);
        i += 1;
      }
    }
    return localStringBuilder.toString().replaceAll("_screen$", "");
  }
  
  public static Screen nextScreenFromRouteChange(RouteChange paramRouteChange)
  {
    Object localObject = null;
    List localList = toPath;
    paramRouteChange = (RouteChange)localObject;
    if (!localList.isEmpty()) {
      paramRouteChange = (Screen)localList.get(localList.size() - 1);
    }
    return paramRouteChange;
  }
  
  public static boolean sameSingleInstanceScreen(Screen paramScreen1, Screen paramScreen2)
  {
    return (ObjectUtils.hasAnnotation(paramScreen1, SingleInstance.class)) && (paramScreen1.equals(paramScreen2));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.common.ScreenUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */