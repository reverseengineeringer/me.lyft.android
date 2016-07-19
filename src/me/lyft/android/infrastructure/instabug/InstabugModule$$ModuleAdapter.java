package me.lyft.android.infrastructure.instabug;

import dagger.internal.BindingsGroup;
import dagger.internal.ModuleAdapter;
import dagger.internal.ProvidesBinding;

public final class InstabugModule$$ModuleAdapter
  extends ModuleAdapter<InstabugModule>
{
  private static final Class<?>[] INCLUDES = new Class[0];
  private static final String[] INJECTS = new String[0];
  private static final Class<?>[] STATIC_INJECTIONS = new Class[0];
  
  public InstabugModule$$ModuleAdapter()
  {
    super(InstabugModule.class, INJECTS, STATIC_INJECTIONS, false, INCLUDES, false, true);
  }
  
  public void getBindings(BindingsGroup paramBindingsGroup, InstabugModule paramInstabugModule)
  {
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.infrastructure.instabug.IInstabugService", new ProvideIInstabugServiceProvidesAdapter(paramInstabugModule));
  }
  
  public InstabugModule newModule()
  {
    return new InstabugModule();
  }
  
  public static final class ProvideIInstabugServiceProvidesAdapter
    extends ProvidesBinding<IInstabugService>
  {
    private final InstabugModule module;
    
    public ProvideIInstabugServiceProvidesAdapter(InstabugModule paramInstabugModule)
    {
      super(true, "me.lyft.android.infrastructure.instabug.InstabugModule", "provideIInstabugService");
      module = paramInstabugModule;
      setLibrary(true);
    }
    
    public IInstabugService get()
    {
      return module.provideIInstabugService();
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.instabug.InstabugModule..ModuleAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */