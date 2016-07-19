package me.lyft.android.jobs;

import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import me.lyft.android.application.geo.IEtaRepository;

public final class EtaUpdateJob$$InjectAdapter
  extends Binding<EtaUpdateJob>
{
  private Binding<IEtaRepository> etaRepository;
  
  public EtaUpdateJob$$InjectAdapter()
  {
    super(null, "members/me.lyft.android.jobs.EtaUpdateJob", false, EtaUpdateJob.class);
  }
  
  public void attach(Linker paramLinker)
  {
    etaRepository = paramLinker.requestBinding("me.lyft.android.application.geo.IEtaRepository", EtaUpdateJob.class, getClass().getClassLoader());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(etaRepository);
  }
  
  public void injectMembers(EtaUpdateJob paramEtaUpdateJob)
  {
    etaRepository = ((IEtaRepository)etaRepository.get());
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.jobs.EtaUpdateJob..InjectAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */