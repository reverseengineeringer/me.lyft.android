package me.lyft.android.infrastructure.splitfare;

import me.lyft.android.application.ApplicationServiceException;
import me.lyft.android.common.IHasReason;
import me.lyft.android.common.Preconditions;

public class SplitFareServiceException
  extends ApplicationServiceException
  implements IHasReason
{
  public static final String REASON_EMPTY_INVITE_LIST = "empty_invite_list";
  public static final String REASON_LAPSED = "splitfare_request_lapsed";
  private final String reason;
  
  public SplitFareServiceException(String paramString)
  {
    Preconditions.checkNotNull(paramString);
    reason = paramString;
  }
  
  public String getReason()
  {
    return reason;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.splitfare.SplitFareServiceException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */