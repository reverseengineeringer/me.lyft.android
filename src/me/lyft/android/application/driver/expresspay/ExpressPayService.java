package me.lyft.android.application.driver.expresspay;

import com.lyft.android.api.dto.CreateExpressPayAccountDTO;
import com.lyft.android.api.dto.ExpressPayAccountDTO;
import com.lyft.android.api.dto.ExpressPayDTO;
import java.util.Iterator;
import java.util.List;
import me.lyft.android.analytics.core.ActionAnalytics;
import me.lyft.android.analytics.core.events.ActionEvent.Action;
import me.lyft.android.application.IUserProvider;
import me.lyft.android.common.Strings;
import me.lyft.android.common.Unit;
import me.lyft.android.domain.User;
import me.lyft.android.domain.driver.ExpressPayAccountMapper;
import me.lyft.android.domain.driver.ExpressPayMapper;
import me.lyft.android.domain.lyft.LyftValidationError;
import me.lyft.android.domain.payment.ICard;
import me.lyft.android.infrastructure.lyft.ILyftApi;
import me.lyft.android.infrastructure.lyft.LyftApiException;
import me.lyft.android.infrastructure.lyft.PaymentErrorParser;
import me.lyft.android.infrastructure.stripe.IStripeService;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

public class ExpressPayService
  implements IExpressPayService
{
  public static final String CARD = "card";
  private final IExpressPayRepository expressPayRepository;
  private final ILyftApi lyftApi;
  private final IStripeService stripeService;
  private final IUserProvider userProvider;
  
  public ExpressPayService(ILyftApi paramILyftApi, IUserProvider paramIUserProvider, IExpressPayRepository paramIExpressPayRepository, IStripeService paramIStripeService)
  {
    lyftApi = paramILyftApi;
    userProvider = paramIUserProvider;
    expressPayRepository = paramIExpressPayRepository;
    stripeService = paramIStripeService;
  }
  
  private Observable<Unit> createOrUpdateDebitCard(ICard paramICard, final ActionEvent.Action paramAction)
  {
    paramAction = (ActionAnalytics)new ActionAnalytics(paramAction).trackInitiation();
    stripeService.validateCardAndCreateToken(paramICard).flatMap(new Func1()
    {
      public Observable<ExpressPayAccountDTO> call(String paramAnonymousString)
      {
        return lyftApi.createOrUpdateDebitCard(userProvider.getUser().getId(), new CreateExpressPayAccountDTO("card", paramAnonymousString));
      }
    }).doOnNext(new Action1()
    {
      public void call(ExpressPayAccountDTO paramAnonymousExpressPayAccountDTO)
      {
        paramAction.trackSuccess();
        expressPayRepository.setExpressAccount(ExpressPayAccountMapper.fromDTO(paramAnonymousExpressPayAccountDTO));
      }
    }).onErrorResumeNext(new Func1()
    {
      public Observable<ExpressPayAccountDTO> call(Throwable paramAnonymousThrowable)
      {
        paramAction.trackFailure(paramAnonymousThrowable);
        return Observable.error(PaymentErrorParser.parse(paramAnonymousThrowable));
      }
    }).map(Unit.func1());
  }
  
  private <T> Observable<T> handleExpressPayError(Throwable paramThrowable)
  {
    if ((paramThrowable instanceof LyftApiException))
    {
      LyftApiException localLyftApiException = (LyftApiException)paramThrowable;
      if (localLyftApiException.getStatusCode() == 422)
      {
        paramThrowable = "Server validation error";
        String str = "SERVER_VALIDATION_ERROR";
        Iterator localIterator = localLyftApiException.getValidationErrors().iterator();
        while (localIterator.hasNext())
        {
          LyftValidationError localLyftValidationError = (LyftValidationError)localIterator.next();
          if (!Strings.isNullOrEmpty(localLyftValidationError.getMessage()))
          {
            paramThrowable = localLyftValidationError.getMessage();
            str = localLyftValidationError.getReason();
          }
        }
        paramThrowable = new ExpressPayException(paramThrowable, localLyftApiException, str);
      }
    }
    for (;;)
    {
      return Observable.error(paramThrowable);
      paramThrowable = new ExpressPayException("Unable to submit Express Pay", paramThrowable, "express_pay_server_error");
    }
  }
  
  public Observable<Unit> createDebitCard(ICard paramICard)
  {
    return createOrUpdateDebitCard(paramICard, ActionEvent.Action.ADD_DEBIT_CARD);
  }
  
  public Observable<Unit> getExpressPay()
  {
    lyftApi.getExpressPay(userProvider.getUser().getId()).onErrorResumeNext(new Func1()
    {
      public Observable<ExpressPayDTO> call(Throwable paramAnonymousThrowable)
      {
        return ExpressPayService.this.handleExpressPayError(paramAnonymousThrowable);
      }
    }).doOnNext(new Action1()
    {
      public void call(ExpressPayDTO paramAnonymousExpressPayDTO)
      {
        expressPayRepository.setExpressPay(ExpressPayMapper.fromExpressPayDTO(paramAnonymousExpressPayDTO));
        expressPayRepository.setExpressAccount(ExpressPayAccountMapper.fromDTO(expressAccount));
      }
    }).map(Unit.func1());
  }
  
  public Observable<Unit> submitPayout()
  {
    lyftApi.submitPayout(userProvider.getUser().getId()).onErrorResumeNext(new Func1()
    {
      public Observable<Unit> call(Throwable paramAnonymousThrowable)
      {
        return ExpressPayService.this.handleExpressPayError(paramAnonymousThrowable);
      }
    }).map(Unit.func1());
  }
  
  public Observable<Unit> updateDebitCard(ICard paramICard)
  {
    if (paramICard.isEmpty()) {
      return Unit.just();
    }
    return createOrUpdateDebitCard(paramICard, ActionEvent.Action.EDIT_DEBIT_CARD);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.driver.expresspay.ExpressPayService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */