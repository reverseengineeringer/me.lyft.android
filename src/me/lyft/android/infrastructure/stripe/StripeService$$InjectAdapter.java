package me.lyft.android.infrastructure.stripe;

import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import me.lyft.android.ILyftPreferences;

public final class StripeService$$InjectAdapter
  extends Binding<StripeService>
{
  private Binding<ILyftPreferences> preferences;
  
  public StripeService$$InjectAdapter()
  {
    super("me.lyft.android.infrastructure.stripe.StripeService", "members/me.lyft.android.infrastructure.stripe.StripeService", false, StripeService.class);
  }
  
  public void attach(Linker paramLinker)
  {
    preferences = paramLinker.requestBinding("me.lyft.android.ILyftPreferences", StripeService.class, getClass().getClassLoader());
  }
  
  public StripeService get()
  {
    return new StripeService((ILyftPreferences)preferences.get());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet1.add(preferences);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.stripe.StripeService..InjectAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */