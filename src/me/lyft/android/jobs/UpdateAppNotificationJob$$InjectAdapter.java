package me.lyft.android.jobs;

import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import me.lyft.android.infrastructure.notifications.InAppNotificationService;

public final class UpdateAppNotificationJob$$InjectAdapter
  extends Binding<UpdateAppNotificationJob>
{
  private Binding<InAppNotificationService> inAppNotificationService;
  
  public UpdateAppNotificationJob$$InjectAdapter()
  {
    super("me.lyft.android.jobs.UpdateAppNotificationJob", "members/me.lyft.android.jobs.UpdateAppNotificationJob", false, UpdateAppNotificationJob.class);
  }
  
  public void attach(Linker paramLinker)
  {
    inAppNotificationService = paramLinker.requestBinding("me.lyft.android.infrastructure.notifications.InAppNotificationService", UpdateAppNotificationJob.class, getClass().getClassLoader());
  }
  
  public UpdateAppNotificationJob get()
  {
    UpdateAppNotificationJob localUpdateAppNotificationJob = new UpdateAppNotificationJob();
    injectMembers(localUpdateAppNotificationJob);
    return localUpdateAppNotificationJob;
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(inAppNotificationService);
  }
  
  public void injectMembers(UpdateAppNotificationJob paramUpdateAppNotificationJob)
  {
    inAppNotificationService = ((InAppNotificationService)inAppNotificationService.get());
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.jobs.UpdateAppNotificationJob..InjectAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */