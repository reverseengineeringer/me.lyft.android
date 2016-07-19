package me.lyft.android.common;

import dagger.internal.ProvidesBinding;

public final class CommonModule$$ModuleAdapter$ProvideDialogFlowProvidesAdapter
  extends ProvidesBinding<DialogFlow>
{
  private final CommonModule module;
  
  public CommonModule$$ModuleAdapter$ProvideDialogFlowProvidesAdapter(CommonModule paramCommonModule)
  {
    super("me.lyft.android.common.DialogFlow", true, "me.lyft.android.common.CommonModule", "provideDialogFlow");
    module = paramCommonModule;
    setLibrary(true);
  }
  
  public DialogFlow get()
  {
    return module.provideDialogFlow();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.common.CommonModule..ModuleAdapter.ProvideDialogFlowProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */