package me.lyft.android.jobs;

import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import me.lyft.android.persistence.ride.IPassengerRideReceiptService;

public final class UpdatePassengerRideReceiptJob$$InjectAdapter
  extends Binding<UpdatePassengerRideReceiptJob>
{
  private Binding<IPassengerRideReceiptService> rideFareRepository;
  
  public UpdatePassengerRideReceiptJob$$InjectAdapter()
  {
    super(null, "members/me.lyft.android.jobs.UpdatePassengerRideReceiptJob", false, UpdatePassengerRideReceiptJob.class);
  }
  
  public void attach(Linker paramLinker)
  {
    rideFareRepository = paramLinker.requestBinding("me.lyft.android.persistence.ride.IPassengerRideReceiptService", UpdatePassengerRideReceiptJob.class, getClass().getClassLoader());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(rideFareRepository);
  }
  
  public void injectMembers(UpdatePassengerRideReceiptJob paramUpdatePassengerRideReceiptJob)
  {
    rideFareRepository = ((IPassengerRideReceiptService)rideFareRepository.get());
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.jobs.UpdatePassengerRideReceiptJob..InjectAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */