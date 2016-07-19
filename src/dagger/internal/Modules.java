package dagger.internal;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public final class Modules
{
  private static void collectIncludedModulesRecursively(Loader paramLoader, ModuleAdapter<?> paramModuleAdapter, Map<Class<?>, ModuleAdapter<?>> paramMap)
  {
    paramModuleAdapter = includes;
    int j = paramModuleAdapter.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramModuleAdapter[i];
      if (!paramMap.containsKey(localObject))
      {
        ModuleAdapter localModuleAdapter = paramLoader.getModuleAdapter((Class)localObject);
        paramMap.put(localObject, localModuleAdapter);
        collectIncludedModulesRecursively(paramLoader, localModuleAdapter, paramMap);
      }
      i += 1;
    }
  }
  
  public static Map<ModuleAdapter<?>, Object> loadModules(Loader paramLoader, Object[] paramArrayOfObject)
  {
    Object localObject1 = new LinkedHashMap(paramArrayOfObject.length);
    int i = 0;
    if (i < paramArrayOfObject.length)
    {
      if ((paramArrayOfObject[i] instanceof Class))
      {
        localObject2 = paramLoader.getModuleAdapter((Class)paramArrayOfObject[i]);
        ((Map)localObject1).put(localObject2, ((ModuleAdapter)localObject2).newModule());
      }
      for (;;)
      {
        i += 1;
        break;
        ((Map)localObject1).put(paramLoader.getModuleAdapter(paramArrayOfObject[i].getClass()), paramArrayOfObject[i]);
      }
    }
    paramArrayOfObject = new LinkedHashMap((Map)localObject1);
    Object localObject2 = new LinkedHashMap();
    localObject1 = ((Map)localObject1).keySet().iterator();
    while (((Iterator)localObject1).hasNext()) {
      collectIncludedModulesRecursively(paramLoader, (ModuleAdapter)((Iterator)localObject1).next(), (Map)localObject2);
    }
    paramLoader = ((Map)localObject2).values().iterator();
    while (paramLoader.hasNext())
    {
      localObject1 = (ModuleAdapter)paramLoader.next();
      if (!paramArrayOfObject.containsKey(localObject1)) {
        paramArrayOfObject.put(localObject1, ((ModuleAdapter)localObject1).newModule());
      }
    }
    return paramArrayOfObject;
  }
}

/* Location:
 * Qualified Name:     dagger.internal.Modules
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */