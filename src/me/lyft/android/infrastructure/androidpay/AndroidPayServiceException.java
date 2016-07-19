package me.lyft.android.infrastructure.androidpay;

import me.lyft.android.common.IHasReason;

public class AndroidPayServiceException
  extends Throwable
  implements IHasReason
{
  public static final int ERROR_CODE_AUTHENTICATION_FAILURE = 411;
  public static final int ERROR_CODE_BUYER_ACCOUNT_ERROR = 409;
  public static final int ERROR_CODE_INVALID_PARAMETERS = 404;
  public static final int ERROR_CODE_INVALID_TRANSACTION = 410;
  public static final int ERROR_CODE_MERCHANT_ACCOUNT_ERROR = 405;
  public static final int ERROR_CODE_SERVICE_UNAVAILABLE = 402;
  public static final int ERROR_CODE_SPENDING_LIMIT_EXCEEDED = 406;
  public static final int ERROR_CODE_UNSUPPORTED_API_VERSION = 412;
  private int errorCode;
  
  public AndroidPayServiceException(int paramInt)
  {
    errorCode = paramInt;
  }
  
  private static String asMeaningfulString(int paramInt)
  {
    switch (paramInt)
    {
    case 403: 
    case 407: 
    case 408: 
    default: 
      return "other_" + paramInt;
    case 402: 
      return "service_unavailable";
    case 404: 
      return "invalid_parameters";
    case 405: 
      return "merchant_account_error";
    case 406: 
      return "spending_limit_exceeded";
    case 409: 
      return "buyer_account_error";
    case 410: 
      return "invalid_transaction";
    case 411: 
      return "authentication_failure";
    }
    return "unsupported_api_version";
  }
  
  public String getMessage()
  {
    return "Failed to save wallet card: " + errorCode;
  }
  
  public String getReason()
  {
    return "wallet_" + asMeaningfulString(errorCode);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.androidpay.AndroidPayServiceException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */