package me.lyft.android.managers;

import com.squareup.picasso.Picasso;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;

public final class ImageLoader$$InjectAdapter
  extends Binding<ImageLoader>
{
  private Binding<Picasso> picasso;
  
  public ImageLoader$$InjectAdapter()
  {
    super("me.lyft.android.managers.ImageLoader", "members/me.lyft.android.managers.ImageLoader", true, ImageLoader.class);
  }
  
  public void attach(Linker paramLinker)
  {
    picasso = paramLinker.requestBinding("com.squareup.picasso.Picasso", ImageLoader.class, getClass().getClassLoader());
  }
  
  public ImageLoader get()
  {
    return new ImageLoader((Picasso)picasso.get());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet1.add(picasso);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.managers.ImageLoader..InjectAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */