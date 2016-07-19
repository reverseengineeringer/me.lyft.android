package me.lyft.android.common;

public abstract interface IAppStore
{
  public abstract String getAppStoreSource();
  
  public abstract void openInstallingStore();
  
  public abstract boolean wasInstalledFromSamsungStore();
}

/* Location:
 * Qualified Name:     me.lyft.android.common.IAppStore
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */