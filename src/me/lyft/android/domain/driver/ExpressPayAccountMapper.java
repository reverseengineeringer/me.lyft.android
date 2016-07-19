package me.lyft.android.domain.driver;

import com.lyft.android.api.dto.ExpressPayAccountDTO;

public class ExpressPayAccountMapper
{
  public static ExpressPayAccount fromDTO(ExpressPayAccountDTO paramExpressPayAccountDTO)
  {
    if (paramExpressPayAccountDTO == null) {
      return ExpressPayAccount.empty();
    }
    return new ExpressPayAccount(id, lastFour, type, successMessage, failed.booleanValue(), failedMessage);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.driver.ExpressPayAccountMapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */