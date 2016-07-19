package dagger;

import dagger.internal.Binding;
import dagger.internal.BindingsGroup;
import dagger.internal.FailoverLoader;
import dagger.internal.Keys;
import dagger.internal.Linker;
import dagger.internal.Loader;
import dagger.internal.ModuleAdapter;
import dagger.internal.Modules;
import dagger.internal.ProblemDetector;
import dagger.internal.SetBinding;
import dagger.internal.StaticInjection;
import dagger.internal.ThrowingErrorHandler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public abstract class ObjectGraph
{
  public static ObjectGraph create(Object... paramVarArgs)
  {
    return DaggerObjectGraph.makeGraph(null, new FailoverLoader(), paramVarArgs);
  }
  
  static ObjectGraph createWith(Loader paramLoader, Object... paramVarArgs)
  {
    return DaggerObjectGraph.makeGraph(null, paramLoader, paramVarArgs);
  }
  
  public abstract <T> T get(Class<T> paramClass);
  
  public abstract <T> T inject(T paramT);
  
  public abstract void injectStatics();
  
  public abstract ObjectGraph plus(Object... paramVarArgs);
  
  public abstract void validate();
  
  static class DaggerObjectGraph
    extends ObjectGraph
  {
    private final DaggerObjectGraph base;
    private final Map<String, Class<?>> injectableTypes;
    private final Linker linker;
    private final Loader plugin;
    private final List<SetBinding<?>> setBindings;
    private final Map<Class<?>, StaticInjection> staticInjections;
    
    DaggerObjectGraph(DaggerObjectGraph paramDaggerObjectGraph, Linker paramLinker, Loader paramLoader, Map<Class<?>, StaticInjection> paramMap, Map<String, Class<?>> paramMap1, List<SetBinding<?>> paramList)
    {
      base = paramDaggerObjectGraph;
      linker = ((Linker)checkNotNull(paramLinker, "linker"));
      plugin = ((Loader)checkNotNull(paramLoader, "plugin"));
      staticInjections = ((Map)checkNotNull(paramMap, "staticInjections"));
      injectableTypes = ((Map)checkNotNull(paramMap1, "injectableTypes"));
      setBindings = ((List)checkNotNull(paramList, "setBindings"));
    }
    
    private static <T> T checkNotNull(T paramT, String paramString)
    {
      if (paramT == null) {
        throw new NullPointerException(paramString);
      }
      return paramT;
    }
    
    private Binding<?> getInjectableTypeBinding(ClassLoader paramClassLoader, String paramString1, String paramString2)
    {
      Class localClass = null;
      for (Object localObject = this;; localObject = base) {
        if (localObject != null)
        {
          localClass = (Class)injectableTypes.get(paramString1);
          if (localClass == null) {}
        }
        else
        {
          if (localClass != null) {
            break;
          }
          throw new IllegalArgumentException("No inject registered for " + paramString1 + ". You must explicitly add it to the 'injects' option in one of your modules.");
        }
      }
      synchronized (linker)
      {
        localObject = linker.requestBinding(paramString2, localClass, paramClassLoader, false, true);
        if (localObject != null)
        {
          paramString1 = (String)localObject;
          if (((Binding)localObject).isLinked()) {}
        }
        else
        {
          linker.linkRequested();
          paramString1 = linker.requestBinding(paramString2, localClass, paramClassLoader, false, true);
        }
        return paramString1;
      }
    }
    
    private Map<String, Binding<?>> linkEverything()
    {
      ??? = linker.fullyLinkedBindings();
      if (??? != null) {
        return (Map<String, Binding<?>>)???;
      }
      synchronized (linker)
      {
        Map localMap = linker.fullyLinkedBindings();
        if (localMap != null) {
          return localMap;
        }
        linkStaticInjections();
        linkInjectableTypes();
        localMap = linker.linkAll();
        return localMap;
      }
    }
    
    private void linkInjectableTypes()
    {
      Iterator localIterator = injectableTypes.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        linker.requestBinding((String)localEntry.getKey(), localEntry.getValue(), ((Class)localEntry.getValue()).getClassLoader(), false, true);
      }
    }
    
    private void linkStaticInjections()
    {
      Iterator localIterator = staticInjections.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        StaticInjection localStaticInjection2 = (StaticInjection)localEntry.getValue();
        StaticInjection localStaticInjection1 = localStaticInjection2;
        if (localStaticInjection2 == null)
        {
          localStaticInjection1 = plugin.getStaticInjection((Class)localEntry.getKey());
          localEntry.setValue(localStaticInjection1);
        }
        localStaticInjection1.attach(linker);
      }
    }
    
    static ObjectGraph makeGraph(DaggerObjectGraph paramDaggerObjectGraph, Loader paramLoader, Object... paramVarArgs)
    {
      LinkedHashMap localLinkedHashMap1 = new LinkedHashMap();
      LinkedHashMap localLinkedHashMap2 = new LinkedHashMap();
      if (paramDaggerObjectGraph == null) {}
      ObjectGraph.OverridesBindings localOverridesBindings;
      Map.Entry localEntry;
      ModuleAdapter localModuleAdapter;
      for (ObjectGraph.StandardBindings localStandardBindings = new ObjectGraph.StandardBindings();; localStandardBindings = new ObjectGraph.StandardBindings(setBindings))
      {
        localOverridesBindings = new ObjectGraph.OverridesBindings();
        Iterator localIterator = Modules.loadModules(paramLoader, paramVarArgs).entrySet().iterator();
        if (!localIterator.hasNext()) {
          break label257;
        }
        localEntry = (Map.Entry)localIterator.next();
        localModuleAdapter = (ModuleAdapter)localEntry.getKey();
        i = 0;
        while (i < injectableTypes.length)
        {
          localLinkedHashMap1.put(injectableTypes[i], moduleClass);
          i += 1;
        }
      }
      int i = 0;
      while (i < staticInjections.length)
      {
        localLinkedHashMap2.put(staticInjections[i], null);
        i += 1;
      }
      for (;;)
      {
        try
        {
          if (overrides)
          {
            paramVarArgs = localOverridesBindings;
            localModuleAdapter.getBindings(paramVarArgs, localEntry.getValue());
          }
        }
        catch (IllegalArgumentException paramDaggerObjectGraph)
        {
          throw new IllegalArgumentException(moduleClass.getSimpleName() + ": " + paramDaggerObjectGraph.getMessage(), paramDaggerObjectGraph);
        }
        paramVarArgs = localStandardBindings;
      }
      label257:
      if (paramDaggerObjectGraph != null) {}
      for (paramVarArgs = linker;; paramVarArgs = null)
      {
        paramVarArgs = new Linker(paramVarArgs, paramLoader, new ThrowingErrorHandler());
        paramVarArgs.installBindings(localStandardBindings);
        paramVarArgs.installBindings(localOverridesBindings);
        return new DaggerObjectGraph(paramDaggerObjectGraph, paramVarArgs, paramLoader, localLinkedHashMap2, localLinkedHashMap1, ObjectGraph.StandardBindings.access$000(localStandardBindings));
      }
    }
    
    public <T> T get(Class<T> paramClass)
    {
      String str2 = Keys.get(paramClass);
      if (paramClass.isInterface()) {}
      for (String str1 = str2;; str1 = Keys.getMembersKey(paramClass)) {
        return (T)getInjectableTypeBinding(paramClass.getClassLoader(), str1, str2).get();
      }
    }
    
    public <T> T inject(T paramT)
    {
      String str = Keys.getMembersKey(paramT.getClass());
      getInjectableTypeBinding(paramT.getClass().getClassLoader(), str, str).injectMembers(paramT);
      return paramT;
    }
    
    public void injectStatics()
    {
      synchronized (linker)
      {
        linkStaticInjections();
        linker.linkRequested();
        linkStaticInjections();
        ??? = staticInjections.entrySet().iterator();
        if (((Iterator)???).hasNext()) {
          ((StaticInjection)((Map.Entry)((Iterator)???).next()).getValue()).inject();
        }
      }
    }
    
    public ObjectGraph plus(Object... paramVarArgs)
    {
      linkEverything();
      return makeGraph(this, plugin, paramVarArgs);
    }
    
    public void validate()
    {
      Map localMap = linkEverything();
      new ProblemDetector().detectProblems(localMap.values());
    }
  }
  
  private static final class OverridesBindings
    extends BindingsGroup
  {
    public Binding<?> contributeSetBinding(String paramString, SetBinding<?> paramSetBinding)
    {
      throw new IllegalArgumentException("Module overrides cannot contribute set bindings.");
    }
  }
  
  private static final class StandardBindings
    extends BindingsGroup
  {
    private final List<SetBinding<?>> setBindings;
    
    public StandardBindings()
    {
      setBindings = new ArrayList();
    }
    
    public StandardBindings(List<SetBinding<?>> paramList)
    {
      setBindings = new ArrayList(paramList.size());
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        SetBinding localSetBinding = new SetBinding((SetBinding)paramList.next());
        setBindings.add(localSetBinding);
        put(provideKey, localSetBinding);
      }
    }
    
    public Binding<?> contributeSetBinding(String paramString, SetBinding<?> paramSetBinding)
    {
      setBindings.add(paramSetBinding);
      return super.put(paramString, paramSetBinding);
    }
  }
}

/* Location:
 * Qualified Name:     dagger.ObjectGraph
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */