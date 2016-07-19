package me.lyft.android.controls;

import com.lyft.rx.MessageBus;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import me.lyft.android.application.features.IFeaturesProvider;
import me.lyft.android.common.AppFlow;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.development.IDeveloperTools;
import me.lyft.android.infrastructure.device.IDevice;

public final class PhoneInputView$$InjectAdapter
  extends Binding<PhoneInputView>
{
  private Binding<AppFlow> appFlow;
  private Binding<IDeveloperTools> developerTools;
  private Binding<IDevice> device;
  private Binding<DialogFlow> dialogFlow;
  private Binding<IFeaturesProvider> featuresProvider;
  private Binding<MessageBus> messageBus;
  
  public PhoneInputView$$InjectAdapter()
  {
    super(null, "members/me.lyft.android.controls.PhoneInputView", false, PhoneInputView.class);
  }
  
  public void attach(Linker paramLinker)
  {
    appFlow = paramLinker.requestBinding("me.lyft.android.common.AppFlow", PhoneInputView.class, getClass().getClassLoader());
    dialogFlow = paramLinker.requestBinding("me.lyft.android.common.DialogFlow", PhoneInputView.class, getClass().getClassLoader());
    messageBus = paramLinker.requestBinding("com.lyft.rx.MessageBus", PhoneInputView.class, getClass().getClassLoader());
    device = paramLinker.requestBinding("me.lyft.android.infrastructure.device.IDevice", PhoneInputView.class, getClass().getClassLoader());
    featuresProvider = paramLinker.requestBinding("me.lyft.android.application.features.IFeaturesProvider", PhoneInputView.class, getClass().getClassLoader());
    developerTools = paramLinker.requestBinding("me.lyft.android.development.IDeveloperTools", PhoneInputView.class, getClass().getClassLoader());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(appFlow);
    paramSet2.add(dialogFlow);
    paramSet2.add(messageBus);
    paramSet2.add(device);
    paramSet2.add(featuresProvider);
    paramSet2.add(developerTools);
  }
  
  public void injectMembers(PhoneInputView paramPhoneInputView)
  {
    appFlow = ((AppFlow)appFlow.get());
    dialogFlow = ((DialogFlow)dialogFlow.get());
    messageBus = ((MessageBus)messageBus.get());
    device = ((IDevice)device.get());
    featuresProvider = ((IFeaturesProvider)featuresProvider.get());
    developerTools = ((IDeveloperTools)developerTools.get());
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.controls.PhoneInputView..InjectAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */