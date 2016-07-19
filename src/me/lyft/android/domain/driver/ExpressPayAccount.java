package me.lyft.android.domain.driver;

import me.lyft.android.common.INullable;
import me.lyft.android.common.Strings;

public class ExpressPayAccount
  implements INullable
{
  private final boolean failed;
  private final String failedMessage;
  private final String id;
  private final String lastFour;
  private final String successMessage;
  private final String type;
  
  public ExpressPayAccount(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, String paramString5)
  {
    id = Strings.nullOrEmptyToDefault(paramString1, "");
    lastFour = Strings.nullOrEmptyToDefault(paramString2, "");
    type = Strings.nullOrEmptyToDefault(paramString3, "");
    successMessage = Strings.nullOrEmptyToDefault(paramString4, "");
    failed = paramBoolean;
    failedMessage = Strings.nullOrEmptyToDefault(paramString5, "");
  }
  
  public static ExpressPayAccount empty()
  {
    return NullExpressPayAccount.INSTANCE;
  }
  
  public String getFailedMessage()
  {
    return failedMessage;
  }
  
  public String getId()
  {
    return id;
  }
  
  public String getLastFour()
  {
    return lastFour;
  }
  
  public String getSuccessMessage()
  {
    return successMessage;
  }
  
  public String getType()
  {
    return type;
  }
  
  public boolean isFailed()
  {
    return failed;
  }
  
  public boolean isNull()
  {
    return false;
  }
  
  private static class NullExpressPayAccount
    extends ExpressPayAccount
  {
    private static final ExpressPayAccount INSTANCE = new NullExpressPayAccount();
    
    public NullExpressPayAccount()
    {
      super("", "", "", false, "");
    }
    
    public boolean isNull()
    {
      return true;
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.driver.ExpressPayAccount
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */