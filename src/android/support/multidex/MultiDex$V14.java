package android.support.multidex;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

final class MultiDex$V14
{
  private static void install(ClassLoader paramClassLoader, List<File> paramList, File paramFile)
    throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException
  {
    paramClassLoader = MultiDex.access$300(paramClassLoader, "pathList").get(paramClassLoader);
    MultiDex.access$400(paramClassLoader, "dexElements", makeDexElements(paramClassLoader, new ArrayList(paramList), paramFile));
  }
  
  private static Object[] makeDexElements(Object paramObject, ArrayList<File> paramArrayList, File paramFile)
    throws IllegalAccessException, InvocationTargetException, NoSuchMethodException
  {
    return (Object[])MultiDex.access$500(paramObject, "makeDexElements", new Class[] { ArrayList.class, File.class }).invoke(paramObject, new Object[] { paramArrayList, paramFile });
  }
}

/* Location:
 * Qualified Name:     android.support.multidex.MultiDex.V14
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */