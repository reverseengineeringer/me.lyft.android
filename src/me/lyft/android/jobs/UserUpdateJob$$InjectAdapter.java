package me.lyft.android.jobs;

import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import me.lyft.android.application.IUserProvider;
import me.lyft.android.application.payment.ICouponService;
import me.lyft.android.application.profile.IProfileService;
import me.lyft.android.application.ride.IUserUiService;

public final class UserUpdateJob$$InjectAdapter
  extends Binding<UserUpdateJob>
{
  private Binding<ICouponService> couponService;
  private Binding<IProfileService> profileService;
  private Binding<IUserProvider> userProvider;
  private Binding<IUserUiService> userUiService;
  
  public UserUpdateJob$$InjectAdapter()
  {
    super(null, "members/me.lyft.android.jobs.UserUpdateJob", false, UserUpdateJob.class);
  }
  
  public void attach(Linker paramLinker)
  {
    userProvider = paramLinker.requestBinding("me.lyft.android.application.IUserProvider", UserUpdateJob.class, getClass().getClassLoader());
    couponService = paramLinker.requestBinding("me.lyft.android.application.payment.ICouponService", UserUpdateJob.class, getClass().getClassLoader());
    userUiService = paramLinker.requestBinding("me.lyft.android.application.ride.IUserUiService", UserUpdateJob.class, getClass().getClassLoader());
    profileService = paramLinker.requestBinding("me.lyft.android.application.profile.IProfileService", UserUpdateJob.class, getClass().getClassLoader());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(userProvider);
    paramSet2.add(couponService);
    paramSet2.add(userUiService);
    paramSet2.add(profileService);
  }
  
  public void injectMembers(UserUpdateJob paramUserUpdateJob)
  {
    userProvider = ((IUserProvider)userProvider.get());
    couponService = ((ICouponService)couponService.get());
    userUiService = ((IUserUiService)userUiService.get());
    profileService = ((IProfileService)profileService.get());
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.jobs.UserUpdateJob..InjectAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */