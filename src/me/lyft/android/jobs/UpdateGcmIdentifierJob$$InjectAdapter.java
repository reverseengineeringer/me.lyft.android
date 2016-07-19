package me.lyft.android.jobs;

import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import me.lyft.android.application.IUserProvider;
import me.lyft.android.infrastructure.gcm.IGcmIdService;
import me.lyft.android.infrastructure.lyft.ILyftApi;

public final class UpdateGcmIdentifierJob$$InjectAdapter
  extends Binding<UpdateGcmIdentifierJob>
{
  private Binding<IGcmIdService> gcmIdService;
  private Binding<ILyftApi> lyftApi;
  private Binding<IUserProvider> userProvider;
  
  public UpdateGcmIdentifierJob$$InjectAdapter()
  {
    super("me.lyft.android.jobs.UpdateGcmIdentifierJob", "members/me.lyft.android.jobs.UpdateGcmIdentifierJob", false, UpdateGcmIdentifierJob.class);
  }
  
  public void attach(Linker paramLinker)
  {
    lyftApi = paramLinker.requestBinding("me.lyft.android.infrastructure.lyft.ILyftApi", UpdateGcmIdentifierJob.class, getClass().getClassLoader());
    gcmIdService = paramLinker.requestBinding("me.lyft.android.infrastructure.gcm.IGcmIdService", UpdateGcmIdentifierJob.class, getClass().getClassLoader());
    userProvider = paramLinker.requestBinding("me.lyft.android.application.IUserProvider", UpdateGcmIdentifierJob.class, getClass().getClassLoader());
  }
  
  public UpdateGcmIdentifierJob get()
  {
    UpdateGcmIdentifierJob localUpdateGcmIdentifierJob = new UpdateGcmIdentifierJob();
    injectMembers(localUpdateGcmIdentifierJob);
    return localUpdateGcmIdentifierJob;
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(lyftApi);
    paramSet2.add(gcmIdService);
    paramSet2.add(userProvider);
  }
  
  public void injectMembers(UpdateGcmIdentifierJob paramUpdateGcmIdentifierJob)
  {
    lyftApi = ((ILyftApi)lyftApi.get());
    gcmIdService = ((IGcmIdService)gcmIdService.get());
    userProvider = ((IUserProvider)userProvider.get());
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.jobs.UpdateGcmIdentifierJob..InjectAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */