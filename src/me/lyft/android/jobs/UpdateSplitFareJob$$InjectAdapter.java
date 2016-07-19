package me.lyft.android.jobs;

import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import me.lyft.android.persistence.splitfare.ISplitFareRequestRepository;

public final class UpdateSplitFareJob$$InjectAdapter
  extends Binding<UpdateSplitFareJob>
{
  private Binding<ISplitFareRequestRepository> splitFareRequestRepository;
  
  public UpdateSplitFareJob$$InjectAdapter()
  {
    super(null, "members/me.lyft.android.jobs.UpdateSplitFareJob", false, UpdateSplitFareJob.class);
  }
  
  public void attach(Linker paramLinker)
  {
    splitFareRequestRepository = paramLinker.requestBinding("me.lyft.android.persistence.splitfare.ISplitFareRequestRepository", UpdateSplitFareJob.class, getClass().getClassLoader());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(splitFareRequestRepository);
  }
  
  public void injectMembers(UpdateSplitFareJob paramUpdateSplitFareJob)
  {
    splitFareRequestRepository = ((ISplitFareRequestRepository)splitFareRequestRepository.get());
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.jobs.UpdateSplitFareJob..InjectAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */