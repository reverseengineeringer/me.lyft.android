package me.lyft.android.domain.driverdocuments;

import java.text.DateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import me.lyft.android.common.DateUtils;
import me.lyft.android.common.INullable;
import me.lyft.android.common.Strings;

public class Insurance
  extends DriverDocument
  implements INullable
{
  private static final DateFormat DATE_FORMAT = DateUtils.createDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
  private static final long DAY_IN_MILLIS = TimeUnit.HOURS.toMillis(24L);
  public static final long POST_EXPIRATION_DAYS = 60L;
  public static final long PRE_EXPIRATION_DAYS = 30L;
  Date expirationDate;
  String state;
  
  public Insurance()
  {
    super(null, null, DriverDocument.Status.NONE);
  }
  
  public Insurance(String paramString1, String paramString2, DriverDocument.Status paramStatus, String paramString3, String paramString4)
  {
    super(paramString1, paramString2, paramStatus);
    state = paramString3;
    expirationDate = parseExpirationDate(paramString4);
  }
  
  public String expirationDateToString()
  {
    return DATE_FORMAT.format(expirationDate);
  }
  
  public Date getExpirationDate()
  {
    return expirationDate;
  }
  
  public String getState()
  {
    return state;
  }
  
  public boolean isApprovedButExpiringSoon()
  {
    if (getExpirationDate() == null) {}
    long l;
    do
    {
      return false;
      Date localDate = getExpirationDate();
      l = System.currentTimeMillis() - localDate.getTime();
    } while ((!isApproved()) || (l >= DAY_IN_MILLIS) || (TimeUnit.DAYS.convert(Math.abs(l), TimeUnit.MILLISECONDS) > 30L));
    return true;
  }
  
  public boolean isExpiredOrExpiringSoon()
  {
    return (isExpired()) || (isApprovedButExpiringSoon());
  }
  
  public boolean isNull()
  {
    return false;
  }
  
  public Date parseExpirationDate(String paramString)
  {
    Date localDate = null;
    if (!Strings.isNullOrEmpty(paramString)) {}
    try
    {
      localDate = DATE_FORMAT.parse(paramString);
      return localDate;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  public void setExpirationDate(Date paramDate)
  {
    expirationDate = paramDate;
  }
  
  public void setState(String paramString)
  {
    state = paramString;
  }
  
  public boolean shouldShowInsuranceExpirationDialog()
  {
    if (expirationDate == null) {}
    long l;
    do
    {
      return false;
      l = System.currentTimeMillis() - expirationDate.getTime();
    } while (((l >= 0L) || (TimeUnit.DAYS.convert(Math.abs(l), TimeUnit.MILLISECONDS) >= 30L)) && ((l <= 0L) || (TimeUnit.DAYS.convert(Math.abs(l), TimeUnit.MILLISECONDS) >= 60L)));
    return true;
  }
  
  public static class NullInsurance
    extends Insurance
  {
    private static final NullInsurance INSTANCE = new NullInsurance();
    
    NullInsurance()
    {
      super(null, DriverDocument.Status.NONE, null, null);
    }
    
    public static NullInsurance getInstance()
    {
      return INSTANCE;
    }
    
    public boolean isNull()
    {
      return true;
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.driverdocuments.Insurance
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */