package me.lyft.android.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class Enums
{
  public static <T extends Enum<T>> List<T> asList(Class<T> paramClass, List<String> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty()))
    {
      paramList = Collections.emptyList();
      return paramList;
    }
    ArrayList localArrayList = new ArrayList(paramList.size());
    Iterator localIterator = paramList.iterator();
    for (;;)
    {
      paramList = localArrayList;
      if (!localIterator.hasNext()) {
        break;
      }
      paramList = valueOf(paramClass, (String)localIterator.next(), null);
      if (paramList != null) {
        localArrayList.add(paramList);
      }
    }
  }
  
  public static <T extends Enum<T>> List<T> asList(Class<T> paramClass, String... paramVarArgs)
  {
    return asList(paramClass, Arrays.asList(paramVarArgs));
  }
  
  public static <T extends Enum<T>> T valueOf(Class<T> paramClass, String paramString, T paramT)
  {
    if (paramString == null) {}
    Enum localEnum;
    do
    {
      while (!paramClass.hasNext())
      {
        return paramT;
        paramClass = EnumSet.allOf(paramClass).iterator();
      }
      localEnum = (Enum)paramClass.next();
    } while ((!Objects.equals(localEnum.name().toLowerCase(Locale.ENGLISH), paramString.toLowerCase(Locale.ENGLISH))) && (!Objects.equals(localEnum.name().toLowerCase(), paramString)));
    return localEnum;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.common.Enums
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */