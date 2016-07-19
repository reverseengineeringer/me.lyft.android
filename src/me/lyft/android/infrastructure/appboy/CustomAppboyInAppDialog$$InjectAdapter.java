package me.lyft.android.infrastructure.appboy;

import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.deeplinks.DeepLinkManager;
import me.lyft.android.managers.ImageLoader;
import me.lyft.android.ui.dialogs.DialogContainerView;

public final class CustomAppboyInAppDialog$$InjectAdapter
  extends Binding<CustomAppboyInAppDialog>
{
  private Binding<DeepLinkManager> deepLinkManager;
  private Binding<DialogFlow> dialogFlow;
  private Binding<ImageLoader> imageLoader;
  private Binding<DialogContainerView> supertype;
  
  public CustomAppboyInAppDialog$$InjectAdapter()
  {
    super(null, "members/me.lyft.android.infrastructure.appboy.CustomAppboyInAppDialog", false, CustomAppboyInAppDialog.class);
  }
  
  public void attach(Linker paramLinker)
  {
    dialogFlow = paramLinker.requestBinding("me.lyft.android.common.DialogFlow", CustomAppboyInAppDialog.class, getClass().getClassLoader());
    deepLinkManager = paramLinker.requestBinding("me.lyft.android.deeplinks.DeepLinkManager", CustomAppboyInAppDialog.class, getClass().getClassLoader());
    imageLoader = paramLinker.requestBinding("me.lyft.android.managers.ImageLoader", CustomAppboyInAppDialog.class, getClass().getClassLoader());
    supertype = paramLinker.requestBinding("members/me.lyft.android.ui.dialogs.DialogContainerView", CustomAppboyInAppDialog.class, getClass().getClassLoader(), false, true);
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(dialogFlow);
    paramSet2.add(deepLinkManager);
    paramSet2.add(imageLoader);
    paramSet2.add(supertype);
  }
  
  public void injectMembers(CustomAppboyInAppDialog paramCustomAppboyInAppDialog)
  {
    dialogFlow = ((DialogFlow)dialogFlow.get());
    deepLinkManager = ((DeepLinkManager)deepLinkManager.get());
    imageLoader = ((ImageLoader)imageLoader.get());
    supertype.injectMembers(paramCustomAppboyInAppDialog);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.appboy.CustomAppboyInAppDialog..InjectAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */