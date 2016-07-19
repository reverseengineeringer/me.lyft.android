package me.lyft.android.application.settings;

import me.lyft.android.common.Unit;
import rx.Observable;

public abstract interface ISettingsService
{
  public abstract Observable<Unit> agreeToCoarseLocations();
  
  public abstract Observable<Unit> enableCarpoolDriverDispatch(boolean paramBoolean);
  
  public abstract Observable<Unit> requestVerificationCode(String paramString);
  
  public abstract Observable<Unit> updateEmail(String paramString);
  
  public abstract Observable<Unit> verifyPhone(String paramString1, String paramString2);
}

/* Location:
 * Qualified Name:     me.lyft.android.application.settings.ISettingsService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */