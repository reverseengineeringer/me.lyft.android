package me.lyft.android.application.terms;

import me.lyft.android.common.Unit;
import rx.Observable;

public abstract interface ITermsService
{
  public abstract Observable<Unit> acceptTermsOfService();
  
  public abstract Observable<Unit> acceptTermsOfService(String paramString);
}

/* Location:
 * Qualified Name:     me.lyft.android.application.terms.ITermsService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */