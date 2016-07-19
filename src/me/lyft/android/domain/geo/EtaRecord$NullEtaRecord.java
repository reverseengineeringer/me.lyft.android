package me.lyft.android.domain.geo;

public class EtaRecord$NullEtaRecord
  extends EtaRecord
{
  private static final EtaRecord instance = new NullEtaRecord();
  
  public EtaRecord$NullEtaRecord()
  {
    super(null, null);
  }
  
  public boolean isNull()
  {
    return true;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.geo.EtaRecord.NullEtaRecord
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */