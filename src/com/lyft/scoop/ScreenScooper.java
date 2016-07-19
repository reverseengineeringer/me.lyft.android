package com.lyft.scoop;

import java.util.ArrayList;
import java.util.List;

public class ScreenScooper
{
  private ScreenScoopFactory screenScoopFactory;
  
  public ScreenScooper(ScreenScoopFactory paramScreenScoopFactory)
  {
    screenScoopFactory = paramScreenScoopFactory;
  }
  
  private ArrayList<Scoop> getCurrentScoops(List<Screen> paramList, Scoop paramScoop)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramScoop != null)
    {
      int i = 0;
      while (i < paramList.size())
      {
        localArrayList.add(0, paramScoop);
        paramScoop = paramScoop.getParent();
        i += 1;
      }
    }
    return localArrayList;
  }
  
  private <T> T safeElementGet(List<T> paramList, int paramInt)
  {
    if (paramInt < paramList.size()) {
      return (T)paramList.get(paramInt);
    }
    return null;
  }
  
  public Scoop create(Scoop paramScoop1, Scoop paramScoop2, List<Screen> paramList1, List<Screen> paramList2)
  {
    Object localObject1 = null;
    ArrayList localArrayList = getCurrentScoops(paramList1, paramScoop2);
    int i = 0;
    for (;;)
    {
      localObject2 = localObject1;
      j = i;
      if (i >= paramList1.size()) {
        break label120;
      }
      localObject2 = localObject1;
      j = i;
      if (paramScoop2 == null) {
        break label120;
      }
      Screen localScreen1 = (Screen)safeElementGet(paramList1, i);
      Screen localScreen2 = (Screen)safeElementGet(paramList2, i);
      localObject2 = (Scoop)localArrayList.get(i);
      if (!Screen.equals(localScreen1, localScreen2)) {
        break;
      }
      localObject1 = localObject2;
      i += 1;
    }
    ((Scoop)localObject2).destroy();
    int j = i;
    Object localObject2 = localObject1;
    label120:
    while (j < paramList2.size())
    {
      paramList1 = (Screen)safeElementGet(paramList2, j);
      paramScoop2 = (Scoop)localObject2;
      if (localObject2 == null) {
        paramScoop2 = paramScoop1;
      }
      localObject2 = screenScoopFactory.createScreenScoop(paramList1, paramScoop2);
      j += 1;
    }
    return (Scoop)localObject2;
  }
}

/* Location:
 * Qualified Name:     com.lyft.scoop.ScreenScooper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */