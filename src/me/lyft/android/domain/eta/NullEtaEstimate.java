package me.lyft.android.domain.eta;

public class NullEtaEstimate
  extends EtaEstimate
{
  public static final NullEtaEstimate INSTANCE = new NullEtaEstimate();
  
  NullEtaEstimate()
  {
    super(0L, null, true);
  }
  
  public static NullEtaEstimate create()
  {
    return INSTANCE;
  }
  
  public Long etaInMinutes()
  {
    return null;
  }
  
  public boolean isNull()
  {
    return true;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.eta.NullEtaEstimate
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */