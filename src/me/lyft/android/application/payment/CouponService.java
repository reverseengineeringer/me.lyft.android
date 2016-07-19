package me.lyft.android.application.payment;

import com.lyft.android.api.dto.CouponTemplateDTO;
import com.lyft.android.api.dto.UniversalDTO;
import java.util.List;
import javax.inject.Inject;
import me.lyft.android.analytics.core.ActionAnalytics;
import me.lyft.android.analytics.studies.PaymentAnalytics;
import me.lyft.android.application.IUserProvider;
import me.lyft.android.common.Unit;
import me.lyft.android.domain.User;
import me.lyft.android.domain.invite.CouponInfo;
import me.lyft.android.domain.invite.CouponInfoMapper;
import me.lyft.android.domain.payment.Credit;
import me.lyft.android.infrastructure.lyft.CouponException;
import me.lyft.android.infrastructure.lyft.ILyftApi;
import me.lyft.android.infrastructure.lyft.LyftApiException;
import me.lyft.android.persistence.ISimpleRepository;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

public class CouponService
  implements ICouponService
{
  private final ISimpleRepository<List<Credit>> creditsRepository;
  private final ILyftApi lyftApi;
  private final IUserProvider userProvider;
  
  @Inject
  public CouponService(ILyftApi paramILyftApi, IUserProvider paramIUserProvider, ISimpleRepository<List<Credit>> paramISimpleRepository)
  {
    lyftApi = paramILyftApi;
    userProvider = paramIUserProvider;
    creditsRepository = paramISimpleRepository;
  }
  
  private <T> Observable<T> handleError(Throwable paramThrowable)
  {
    Throwable localThrowable = paramThrowable;
    Object localObject = localThrowable;
    if ((paramThrowable instanceof LyftApiException))
    {
      paramThrowable = (LyftApiException)paramThrowable;
      localObject = localThrowable;
      if (paramThrowable.getStatusCode() == 422)
      {
        localObject = localThrowable;
        if (CouponException.containsCouponValidationError(paramThrowable)) {
          localObject = new CouponException(paramThrowable);
        }
      }
    }
    return Observable.error((Throwable)localObject);
  }
  
  public Observable<Unit> applyCoupon(String paramString)
  {
    final ActionAnalytics localActionAnalytics = PaymentAnalytics.trackAddPaymentMethod("coupon");
    lyftApi.applyCoupon(userProvider.getUser().getId(), paramString).doOnNext(new Action1()
    {
      public void call(UniversalDTO paramAnonymousUniversalDTO)
      {
        localActionAnalytics.trackSuccess();
      }
    }).onErrorResumeNext(new Func1()
    {
      public Observable<UniversalDTO> call(Throwable paramAnonymousThrowable)
      {
        localActionAnalytics.trackFailure(paramAnonymousThrowable);
        return CouponService.this.handleError(paramAnonymousThrowable);
      }
    }).map(Unit.func1());
  }
  
  public Observable<List<Credit>> observeCredits()
  {
    return creditsRepository.observe().distinctUntilChanged();
  }
  
  public Observable<CouponInfo> observeUserCouponInfo()
  {
    lyftApi.getCouponInformation(userProvider.getUser().getReferralCode()).map(new Func1()
    {
      public CouponInfo call(CouponTemplateDTO paramAnonymousCouponTemplateDTO)
      {
        return CouponInfoMapper.fromCouponTemplateDTO(paramAnonymousCouponTemplateDTO);
      }
    }).onErrorResumeNext(new Func1()
    {
      public Observable<CouponInfo> call(Throwable paramAnonymousThrowable)
      {
        return Observable.just(CouponInfo.empty());
      }
    });
  }
  
  public void updateCredits(List<Credit> paramList)
  {
    creditsRepository.update(paramList);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.payment.CouponService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */