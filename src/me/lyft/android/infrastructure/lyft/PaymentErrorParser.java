package me.lyft.android.infrastructure.lyft;

import java.util.Iterator;
import java.util.List;
import me.lyft.android.application.payment.InvalidCardException;
import me.lyft.android.application.payment.InvalidCardException.Reason;
import me.lyft.android.application.payment.InvalidPayPalException;
import me.lyft.android.application.payment.InvalidWalletException;
import me.lyft.android.application.payment.PaymentException;
import me.lyft.android.common.Strings;
import me.lyft.android.domain.lyft.LyftValidationError;
import me.lyft.android.infrastructure.androidpay.AndroidPayServiceException;
import me.lyft.android.infrastructure.paypal.PayPalServiceException;
import me.lyft.android.infrastructure.stripe.StripeInvalidCardException;
import me.lyft.android.infrastructure.stripe.StripeServiceException;

public class PaymentErrorParser
{
  public static Throwable parse(Throwable paramThrowable)
  {
    if (StripeServiceException.class.isAssignableFrom(paramThrowable.getClass()))
    {
      paramThrowable = (StripeServiceException)paramThrowable;
      if ((paramThrowable instanceof StripeInvalidCardException)) {
        return new InvalidCardException(InvalidCardException.Reason.STRIPE_ERROR, paramThrowable.getMessage(), paramThrowable);
      }
      return new PaymentException(paramThrowable.getMessage(), paramThrowable, "stripe_error");
    }
    if ((paramThrowable instanceof LyftApiException))
    {
      LyftApiException localLyftApiException = (LyftApiException)paramThrowable;
      if (localLyftApiException.getStatusCode() == 422)
      {
        String str = "Invalid card";
        paramThrowable = InvalidCardException.Reason.INVALID_CARD_ERROR;
        Iterator localIterator = localLyftApiException.getValidationErrors().iterator();
        while (localIterator.hasNext())
        {
          LyftValidationError localLyftValidationError = (LyftValidationError)localIterator.next();
          if (localLyftValidationError.getReason().equalsIgnoreCase(InvalidCardException.Reason.PAYPAL_DECLINED.toString())) {
            return new InvalidPayPalException(localLyftValidationError.getMessage(), localLyftApiException, localLyftValidationError.getReason());
          }
          if (!Strings.isNullOrEmpty(localLyftValidationError.getMessage()))
          {
            str = localLyftValidationError.getMessage();
            paramThrowable = InvalidCardException.Reason.SERVER_VALIDATION_ERROR;
          }
        }
        if (!Strings.isNullOrEmpty(localLyftApiException.getLyftErrorMessage()))
        {
          str = localLyftApiException.getLyftErrorMessage();
          paramThrowable = InvalidCardException.Reason.SERVER_VALIDATION_ERROR;
        }
        return new InvalidCardException(paramThrowable, str, localLyftApiException);
      }
      return new PaymentException("Failed to save card", localLyftApiException, "save_server_error_" + localLyftApiException.getStatusCode());
    }
    if ((paramThrowable instanceof AndroidPayServiceException)) {
      return new InvalidWalletException("Unable to create wallet card", paramThrowable, ((AndroidPayServiceException)paramThrowable).getReason());
    }
    if ((paramThrowable instanceof PayPalServiceException)) {
      return new InvalidPayPalException("Unable to link PayPal account", paramThrowable, ((PayPalServiceException)paramThrowable).getReason());
    }
    return paramThrowable;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.lyft.PaymentErrorParser
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */