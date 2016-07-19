package me.lyft.android.application.geo;

public abstract interface IEtaRepository
{
  public abstract Long getEta();
  
  public abstract Long getEtd();
  
  public abstract void updateEta(Long paramLong);
  
  public abstract void updateEtd(Long paramLong);
}

/* Location:
 * Qualified Name:     me.lyft.android.application.geo.IEtaRepository
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */