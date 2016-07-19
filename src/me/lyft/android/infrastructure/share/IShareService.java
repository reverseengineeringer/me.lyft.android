package me.lyft.android.infrastructure.share;

public abstract interface IShareService
{
  public abstract void openSmsComposer(String paramString);
  
  public abstract void sendSms(String paramString1, String paramString2);
  
  public abstract void sharePlainText(String paramString1, String paramString2);
  
  public abstract void sharePlainText(String paramString1, String paramString2, String paramString3);
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.share.IShareService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */