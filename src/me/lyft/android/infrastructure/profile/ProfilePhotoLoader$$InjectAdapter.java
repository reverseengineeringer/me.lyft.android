package me.lyft.android.infrastructure.profile;

import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import me.lyft.android.application.IUserProvider;
import me.lyft.android.managers.ImageLoader;

public final class ProfilePhotoLoader$$InjectAdapter
  extends Binding<ProfilePhotoLoader>
{
  private Binding<ImageLoader> imageLoader;
  private Binding<IUserProvider> userProvider;
  
  public ProfilePhotoLoader$$InjectAdapter()
  {
    super("me.lyft.android.infrastructure.profile.ProfilePhotoLoader", "members/me.lyft.android.infrastructure.profile.ProfilePhotoLoader", true, ProfilePhotoLoader.class);
  }
  
  public void attach(Linker paramLinker)
  {
    imageLoader = paramLinker.requestBinding("me.lyft.android.managers.ImageLoader", ProfilePhotoLoader.class, getClass().getClassLoader());
    userProvider = paramLinker.requestBinding("me.lyft.android.application.IUserProvider", ProfilePhotoLoader.class, getClass().getClassLoader());
  }
  
  public ProfilePhotoLoader get()
  {
    return new ProfilePhotoLoader((ImageLoader)imageLoader.get(), (IUserProvider)userProvider.get());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet1.add(imageLoader);
    paramSet1.add(userProvider);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.profile.ProfilePhotoLoader..InjectAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */