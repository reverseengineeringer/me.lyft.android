package me.lyft.android.jobs;

import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import me.lyft.android.infrastructure.splitfare.ISplitFareService;
import me.lyft.android.persistence.splitfare.ISplitFareStateRepository;

public final class UpdateSplitFareStateJob$$InjectAdapter
  extends Binding<UpdateSplitFareStateJob>
{
  private Binding<ISplitFareService> splitFareService;
  private Binding<ISplitFareStateRepository> splitFareStateRepository;
  
  public UpdateSplitFareStateJob$$InjectAdapter()
  {
    super(null, "members/me.lyft.android.jobs.UpdateSplitFareStateJob", false, UpdateSplitFareStateJob.class);
  }
  
  public void attach(Linker paramLinker)
  {
    splitFareStateRepository = paramLinker.requestBinding("me.lyft.android.persistence.splitfare.ISplitFareStateRepository", UpdateSplitFareStateJob.class, getClass().getClassLoader());
    splitFareService = paramLinker.requestBinding("me.lyft.android.infrastructure.splitfare.ISplitFareService", UpdateSplitFareStateJob.class, getClass().getClassLoader());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(splitFareStateRepository);
    paramSet2.add(splitFareService);
  }
  
  public void injectMembers(UpdateSplitFareStateJob paramUpdateSplitFareStateJob)
  {
    splitFareStateRepository = ((ISplitFareStateRepository)splitFareStateRepository.get());
    splitFareService = ((ISplitFareService)splitFareService.get());
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.jobs.UpdateSplitFareStateJob..InjectAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */