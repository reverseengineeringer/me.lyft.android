package rx.plugins;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

public class RxJavaPlugins
{
  static final RxJavaErrorHandler DEFAULT_ERROR_HANDLER = new RxJavaErrorHandler() {};
  private static final RxJavaPlugins INSTANCE = new RxJavaPlugins();
  private final AtomicReference<RxJavaErrorHandler> errorHandler = new AtomicReference();
  private final AtomicReference<RxJavaObservableExecutionHook> observableExecutionHook = new AtomicReference();
  private final AtomicReference<RxJavaSchedulersHook> schedulersHook = new AtomicReference();
  
  public static RxJavaPlugins getInstance()
  {
    return INSTANCE;
  }
  
  static Object getPluginImplementationViaProperty(Class<?> paramClass, Properties paramProperties)
  {
    String str2 = paramClass.getSimpleName();
    String str1 = paramProperties.getProperty("rxjava.plugin." + str2 + ".implementation");
    Object localObject = str1;
    if (str1 == null)
    {
      Iterator localIterator = paramProperties.entrySet().iterator();
      String str3;
      do
      {
        localObject = str1;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (Map.Entry)localIterator.next();
        str3 = ((Map.Entry)localObject).getKey().toString();
      } while ((!str3.startsWith("rxjava.plugin.")) || (!str3.endsWith(".class")) || (!str2.equals(((Map.Entry)localObject).getValue().toString())));
      localObject = str3.substring(0, str3.length() - ".class".length()).substring("rxjava.plugin.".length());
      str1 = "rxjava.plugin." + (String)localObject + ".impl";
      paramProperties = paramProperties.getProperty(str1);
      localObject = paramProperties;
      if (paramProperties == null) {
        throw new RuntimeException("Implementing class declaration for " + str2 + " missing: " + str1);
      }
    }
    if (localObject != null) {
      try
      {
        paramClass = Class.forName((String)localObject).asSubclass(paramClass).newInstance();
        return paramClass;
      }
      catch (ClassCastException paramClass)
      {
        throw new RuntimeException(str2 + " implementation is not an instance of " + str2 + ": " + (String)localObject);
      }
      catch (ClassNotFoundException paramClass)
      {
        throw new RuntimeException(str2 + " implementation class not found: " + (String)localObject, paramClass);
      }
      catch (InstantiationException paramClass)
      {
        throw new RuntimeException(str2 + " implementation not able to be instantiated: " + (String)localObject, paramClass);
      }
      catch (IllegalAccessException paramClass)
      {
        throw new RuntimeException(str2 + " implementation not able to be accessed: " + (String)localObject, paramClass);
      }
    }
    return null;
  }
  
  public RxJavaErrorHandler getErrorHandler()
  {
    Object localObject;
    if (errorHandler.get() == null)
    {
      localObject = getPluginImplementationViaProperty(RxJavaErrorHandler.class, System.getProperties());
      if (localObject != null) {
        break label46;
      }
      errorHandler.compareAndSet(null, DEFAULT_ERROR_HANDLER);
    }
    for (;;)
    {
      return (RxJavaErrorHandler)errorHandler.get();
      label46:
      errorHandler.compareAndSet(null, (RxJavaErrorHandler)localObject);
    }
  }
  
  public RxJavaObservableExecutionHook getObservableExecutionHook()
  {
    Object localObject;
    if (observableExecutionHook.get() == null)
    {
      localObject = getPluginImplementationViaProperty(RxJavaObservableExecutionHook.class, System.getProperties());
      if (localObject != null) {
        break label46;
      }
      observableExecutionHook.compareAndSet(null, RxJavaObservableExecutionHookDefault.getInstance());
    }
    for (;;)
    {
      return (RxJavaObservableExecutionHook)observableExecutionHook.get();
      label46:
      observableExecutionHook.compareAndSet(null, (RxJavaObservableExecutionHook)localObject);
    }
  }
  
  public RxJavaSchedulersHook getSchedulersHook()
  {
    Object localObject;
    if (schedulersHook.get() == null)
    {
      localObject = getPluginImplementationViaProperty(RxJavaSchedulersHook.class, System.getProperties());
      if (localObject != null) {
        break label46;
      }
      schedulersHook.compareAndSet(null, RxJavaSchedulersHook.getDefaultInstance());
    }
    for (;;)
    {
      return (RxJavaSchedulersHook)schedulersHook.get();
      label46:
      schedulersHook.compareAndSet(null, (RxJavaSchedulersHook)localObject);
    }
  }
  
  public void registerErrorHandler(RxJavaErrorHandler paramRxJavaErrorHandler)
  {
    if (!errorHandler.compareAndSet(null, paramRxJavaErrorHandler)) {
      throw new IllegalStateException("Another strategy was already registered: " + errorHandler.get());
    }
  }
  
  public void registerObservableExecutionHook(RxJavaObservableExecutionHook paramRxJavaObservableExecutionHook)
  {
    if (!observableExecutionHook.compareAndSet(null, paramRxJavaObservableExecutionHook)) {
      throw new IllegalStateException("Another strategy was already registered: " + observableExecutionHook.get());
    }
  }
  
  public void registerSchedulersHook(RxJavaSchedulersHook paramRxJavaSchedulersHook)
  {
    if (!schedulersHook.compareAndSet(null, paramRxJavaSchedulersHook)) {
      throw new IllegalStateException("Another strategy was already registered: " + schedulersHook.get());
    }
  }
  
  void reset()
  {
    INSTANCEerrorHandler.set(null);
    INSTANCEobservableExecutionHook.set(null);
    INSTANCEschedulersHook.set(null);
  }
}

/* Location:
 * Qualified Name:     rx.plugins.RxJavaPlugins
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */