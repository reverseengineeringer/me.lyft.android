package me.lyft.android.common;

import dagger.internal.Binding;
import dagger.internal.BindingsGroup;
import dagger.internal.Linker;
import dagger.internal.ModuleAdapter;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import me.lyft.android.LyftApplication;
import me.lyft.android.application.ILogoutService;
import me.lyft.android.errorhandling.IDefaultErrorHandler;

public final class CommonModule$$ModuleAdapter
  extends ModuleAdapter<CommonModule>
{
  private static final Class<?>[] INCLUDES = new Class[0];
  private static final String[] INJECTS = new String[0];
  private static final Class<?>[] STATIC_INJECTIONS = new Class[0];
  
  public CommonModule$$ModuleAdapter()
  {
    super(CommonModule.class, INJECTS, STATIC_INJECTIONS, false, INCLUDES, false, true);
  }
  
  public void getBindings(BindingsGroup paramBindingsGroup, CommonModule paramCommonModule)
  {
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.common.AppFlow", new ProvideAppFlowProvidesAdapter(paramCommonModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.common.DialogFlow", new ProvideDialogFlowProvidesAdapter(paramCommonModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.common.ActivityController", new ProvideActivityControllerProvidesAdapter(paramCommonModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.errorhandling.IDefaultErrorHandler", new ProvideDefaultErrorHandlerProvidesAdapter(paramCommonModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.common.IAppStore", new ProvideAppStoreProvidesAdapter(paramCommonModule));
  }
  
  public CommonModule newModule()
  {
    return new CommonModule();
  }
  
  public static final class ProvideActivityControllerProvidesAdapter
    extends ProvidesBinding<ActivityController>
  {
    private final CommonModule module;
    
    public ProvideActivityControllerProvidesAdapter(CommonModule paramCommonModule)
    {
      super(true, "me.lyft.android.common.CommonModule", "provideActivityController");
      module = paramCommonModule;
      setLibrary(true);
    }
    
    public ActivityController get()
    {
      return module.provideActivityController();
    }
  }
  
  public static final class ProvideAppFlowProvidesAdapter
    extends ProvidesBinding<AppFlow>
  {
    private final CommonModule module;
    
    public ProvideAppFlowProvidesAdapter(CommonModule paramCommonModule)
    {
      super(true, "me.lyft.android.common.CommonModule", "provideAppFlow");
      module = paramCommonModule;
      setLibrary(true);
    }
    
    public AppFlow get()
    {
      return module.provideAppFlow();
    }
  }
  
  public static final class ProvideAppStoreProvidesAdapter
    extends ProvidesBinding<IAppStore>
  {
    private Binding<LyftApplication> application;
    private final CommonModule module;
    
    public ProvideAppStoreProvidesAdapter(CommonModule paramCommonModule)
    {
      super(true, "me.lyft.android.common.CommonModule", "provideAppStore");
      module = paramCommonModule;
      setLibrary(true);
    }
    
    public void attach(Linker paramLinker)
    {
      application = paramLinker.requestBinding("me.lyft.android.LyftApplication", CommonModule.class, getClass().getClassLoader());
    }
    
    public IAppStore get()
    {
      return module.provideAppStore((LyftApplication)application.get());
    }
    
    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(application);
    }
  }
  
  public static final class ProvideDefaultErrorHandlerProvidesAdapter
    extends ProvidesBinding<IDefaultErrorHandler>
  {
    private Binding<AppFlow> appFlow;
    private Binding<DialogFlow> dialogFlow;
    private Binding<ILogoutService> logoutService;
    private final CommonModule module;
    
    public ProvideDefaultErrorHandlerProvidesAdapter(CommonModule paramCommonModule)
    {
      super(false, "me.lyft.android.common.CommonModule", "provideDefaultErrorHandler");
      module = paramCommonModule;
      setLibrary(true);
    }
    
    public void attach(Linker paramLinker)
    {
      appFlow = paramLinker.requestBinding("me.lyft.android.common.AppFlow", CommonModule.class, getClass().getClassLoader());
      dialogFlow = paramLinker.requestBinding("me.lyft.android.common.DialogFlow", CommonModule.class, getClass().getClassLoader());
      logoutService = paramLinker.requestBinding("me.lyft.android.application.ILogoutService", CommonModule.class, getClass().getClassLoader());
    }
    
    public IDefaultErrorHandler get()
    {
      return module.provideDefaultErrorHandler((AppFlow)appFlow.get(), (DialogFlow)dialogFlow.get(), (ILogoutService)logoutService.get());
    }
    
    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(appFlow);
      paramSet1.add(dialogFlow);
      paramSet1.add(logoutService);
    }
  }
  
  public static final class ProvideDialogFlowProvidesAdapter
    extends ProvidesBinding<DialogFlow>
  {
    private final CommonModule module;
    
    public ProvideDialogFlowProvidesAdapter(CommonModule paramCommonModule)
    {
      super(true, "me.lyft.android.common.CommonModule", "provideDialogFlow");
      module = paramCommonModule;
      setLibrary(true);
    }
    
    public DialogFlow get()
    {
      return module.provideDialogFlow();
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.common.CommonModule..ModuleAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */