package me.lyft.android.application;

import android.content.res.Resources;
import dagger.internal.Binding;
import dagger.internal.Linker;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import me.lyft.android.analytics.studies.SplitFareAnalytics;
import me.lyft.android.application.passenger.IPassengerRideProvider;
import me.lyft.android.data.ContactsDatabaseHelper;
import me.lyft.android.infrastructure.lyft.ILyftApi;
import me.lyft.android.infrastructure.splitfare.ISplitFareService;
import me.lyft.android.providers.ContactsProvider;

public final class ApplicationServicesModule$$ModuleAdapter$ProvideSplitFareServiceProvidesAdapter
  extends ProvidesBinding<ISplitFareService>
{
  private Binding<ContactsDatabaseHelper> contactsDatabaseHelper;
  private Binding<ContactsProvider> contactsProvider;
  private Binding<ILyftApi> lyftApi;
  private final ApplicationServicesModule module;
  private Binding<Resources> resources;
  private Binding<IPassengerRideProvider> rideProvider;
  private Binding<SplitFareAnalytics> splitFareAnalytics;
  
  public ApplicationServicesModule$$ModuleAdapter$ProvideSplitFareServiceProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
  {
    super("me.lyft.android.infrastructure.splitfare.ISplitFareService", true, "me.lyft.android.application.ApplicationServicesModule", "provideSplitFareService");
    module = paramApplicationServicesModule;
    setLibrary(true);
  }
  
  public void attach(Linker paramLinker)
  {
    contactsDatabaseHelper = paramLinker.requestBinding("me.lyft.android.data.ContactsDatabaseHelper", ApplicationServicesModule.class, getClass().getClassLoader());
    lyftApi = paramLinker.requestBinding("me.lyft.android.infrastructure.lyft.ILyftApi", ApplicationServicesModule.class, getClass().getClassLoader());
    rideProvider = paramLinker.requestBinding("me.lyft.android.application.passenger.IPassengerRideProvider", ApplicationServicesModule.class, getClass().getClassLoader());
    contactsProvider = paramLinker.requestBinding("me.lyft.android.providers.ContactsProvider", ApplicationServicesModule.class, getClass().getClassLoader());
    resources = paramLinker.requestBinding("android.content.res.Resources", ApplicationServicesModule.class, getClass().getClassLoader());
    splitFareAnalytics = paramLinker.requestBinding("me.lyft.android.analytics.studies.SplitFareAnalytics", ApplicationServicesModule.class, getClass().getClassLoader());
  }
  
  public ISplitFareService get()
  {
    return module.provideSplitFareService((ContactsDatabaseHelper)contactsDatabaseHelper.get(), (ILyftApi)lyftApi.get(), (IPassengerRideProvider)rideProvider.get(), (ContactsProvider)contactsProvider.get(), (Resources)resources.get(), (SplitFareAnalytics)splitFareAnalytics.get());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet1.add(contactsDatabaseHelper);
    paramSet1.add(lyftApi);
    paramSet1.add(rideProvider);
    paramSet1.add(contactsProvider);
    paramSet1.add(resources);
    paramSet1.add(splitFareAnalytics);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ApplicationServicesModule..ModuleAdapter.ProvideSplitFareServiceProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */