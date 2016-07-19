package me.lyft.android.application.geo;

public class EtaRepository
  implements IEtaRepository
{
  Long eta;
  Long etd;
  
  public Long getEta()
  {
    return eta;
  }
  
  public Long getEtd()
  {
    return etd;
  }
  
  public void updateEta(Long paramLong)
  {
    eta = paramLong;
  }
  
  public void updateEtd(Long paramLong)
  {
    etd = paramLong;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.geo.EtaRepository
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */