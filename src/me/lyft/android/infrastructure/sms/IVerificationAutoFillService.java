package me.lyft.android.infrastructure.sms;

import android.content.Context;
import rx.Observable;

public abstract interface IVerificationAutoFillService
{
  public abstract Observable<String> observeCode(Context paramContext);
  
  public abstract void setPhoneNumber(String paramString);
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.sms.IVerificationAutoFillService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */