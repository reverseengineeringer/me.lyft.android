package me.lyft.android.application.invite;

import me.lyft.android.domain.invite.WarmWelcome;
import rx.Observable;

public abstract interface IWarmWelcomeService
{
  public abstract void checkForWarmWelcomeAssignment(String paramString);
  
  public abstract Observable<WarmWelcome> observeWarmWelcome();
}

/* Location:
 * Qualified Name:     me.lyft.android.application.invite.IWarmWelcomeService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */