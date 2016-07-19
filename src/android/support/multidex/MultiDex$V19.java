package android.support.multidex;

import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class MultiDex$V19
{
  private static void install(ClassLoader paramClassLoader, List<File> paramList, File paramFile)
    throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException
  {
    Object localObject = MultiDex.access$300(paramClassLoader, "pathList").get(paramClassLoader);
    ArrayList localArrayList = new ArrayList();
    MultiDex.access$400(localObject, "dexElements", makeDexElements(localObject, new ArrayList(paramList), paramFile, localArrayList));
    if (localArrayList.size() > 0)
    {
      paramList = localArrayList.iterator();
      while (paramList.hasNext()) {
        Log.w("MultiDex", "Exception in makeDexElement", (IOException)paramList.next());
      }
      paramFile = MultiDex.access$300(paramClassLoader, "dexElementsSuppressedExceptions");
      localObject = (IOException[])paramFile.get(paramClassLoader);
      if (localObject != null) {
        break label130;
      }
      paramList = (IOException[])localArrayList.toArray(new IOException[localArrayList.size()]);
    }
    for (;;)
    {
      paramFile.set(paramClassLoader, paramList);
      return;
      label130:
      paramList = new IOException[localArrayList.size() + localObject.length];
      localArrayList.toArray(paramList);
      System.arraycopy(localObject, 0, paramList, localArrayList.size(), localObject.length);
    }
  }
  
  private static Object[] makeDexElements(Object paramObject, ArrayList<File> paramArrayList, File paramFile, ArrayList<IOException> paramArrayList1)
    throws IllegalAccessException, InvocationTargetException, NoSuchMethodException
  {
    return (Object[])MultiDex.access$500(paramObject, "makeDexElements", new Class[] { ArrayList.class, File.class, ArrayList.class }).invoke(paramObject, new Object[] { paramArrayList, paramFile, paramArrayList1 });
  }
}

/* Location:
 * Qualified Name:     android.support.multidex.MultiDex.V19
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */