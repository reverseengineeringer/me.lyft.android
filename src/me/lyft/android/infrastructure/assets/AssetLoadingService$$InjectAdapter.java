package me.lyft.android.infrastructure.assets;

import android.content.Context;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import me.lyft.android.infrastructure.device.IDevice;
import me.lyft.android.managers.ImageLoader;

public final class AssetLoadingService$$InjectAdapter
  extends Binding<AssetLoadingService>
{
  private Binding<Context> context;
  private Binding<IDevice> device;
  private Binding<ImageLoader> picasso;
  
  public AssetLoadingService$$InjectAdapter()
  {
    super("me.lyft.android.infrastructure.assets.AssetLoadingService", "members/me.lyft.android.infrastructure.assets.AssetLoadingService", false, AssetLoadingService.class);
  }
  
  public void attach(Linker paramLinker)
  {
    context = paramLinker.requestBinding("android.content.Context", AssetLoadingService.class, getClass().getClassLoader());
    device = paramLinker.requestBinding("me.lyft.android.infrastructure.device.IDevice", AssetLoadingService.class, getClass().getClassLoader());
    picasso = paramLinker.requestBinding("me.lyft.android.managers.ImageLoader", AssetLoadingService.class, getClass().getClassLoader());
  }
  
  public AssetLoadingService get()
  {
    return new AssetLoadingService((Context)context.get(), (IDevice)device.get(), (ImageLoader)picasso.get());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet1.add(context);
    paramSet1.add(device);
    paramSet1.add(picasso);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.assets.AssetLoadingService..InjectAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */