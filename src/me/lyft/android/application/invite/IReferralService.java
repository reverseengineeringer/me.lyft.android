package me.lyft.android.application.invite;

import me.lyft.android.domain.invite.ReferralInfo;
import rx.Observable;

public abstract interface IReferralService
{
  public abstract Observable<ReferralInfo> getReferral();
}

/* Location:
 * Qualified Name:     me.lyft.android.application.invite.IReferralService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */