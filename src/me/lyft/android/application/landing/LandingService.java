package me.lyft.android.application.landing;

import com.lyft.android.api.dto.AdditionalAuthMethodDTO;
import com.lyft.android.api.dto.LocationDTO;
import com.lyft.android.api.dto.LoginRequestDTO;
import com.lyft.android.api.dto.PhoneDTO;
import com.lyft.android.api.dto.PhoneRequestDTO;
import com.lyft.android.api.dto.UniversalDTO;
import com.lyft.android.api.dto.UpdateUserRequestBuilder;
import me.lyft.android.ILyftPreferences;
import me.lyft.android.analytics.core.ActionAnalytics;
import me.lyft.android.analytics.studies.OnBoardingAnalytics;
import me.lyft.android.analytics.utils.AnalyticsUtils;
import me.lyft.android.application.IUserProvider;
import me.lyft.android.application.constants.Constants;
import me.lyft.android.application.constants.IConstantsProvider;
import me.lyft.android.application.landing.exceptions.AdditionalAuthRequiredException;
import me.lyft.android.application.landing.exceptions.InvalidPhoneFormatException;
import me.lyft.android.application.landing.exceptions.LandingValidationException;
import me.lyft.android.application.landing.exceptions.TermsNotAcceptedException;
import me.lyft.android.application.landing.exceptions.VerificationCodeTooShortException;
import me.lyft.android.application.payment.IPaymentService;
import me.lyft.android.common.IAppStore;
import me.lyft.android.common.IntegerExtensions;
import me.lyft.android.common.Objects;
import me.lyft.android.common.Strings;
import me.lyft.android.common.Unit;
import me.lyft.android.domain.Phone;
import me.lyft.android.domain.PhoneMapper;
import me.lyft.android.domain.User;
import me.lyft.android.domain.location.Location;
import me.lyft.android.domain.location.LocationMapper;
import me.lyft.android.infrastructure.facebook.FacebookLoginResult;
import me.lyft.android.infrastructure.location.ILocationService;
import me.lyft.android.infrastructure.lyft.ILyftApi;
import me.lyft.android.infrastructure.lyft.PhoneLoginErrorParser;
import me.lyft.android.persistence.landing.ISignUpUserRepository;
import me.lyft.android.persistence.landing.SignupUser;
import me.lyft.android.persistence.payment.IChargeAccountsProvider;
import rx.Notification;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

public class LandingService
  implements ILandingService
{
  private static final String APP_INFO_REVISION = "returnappinfo";
  private static final int MIN_CODE_LENGTH = 4;
  private IAppStore appStore;
  private IChargeAccountsProvider chargeAccountsProvider;
  private IConstantsProvider constantsProvider;
  private final ILocationService locationService;
  private final ILyftApi lyftApi;
  private IPaymentService paymentService;
  private final ILyftPreferences preferences;
  private ISignUpUserRepository signupUserRepository;
  private IUserProvider userProvider;
  
  public LandingService(ISignUpUserRepository paramISignUpUserRepository, IUserProvider paramIUserProvider, ILyftApi paramILyftApi, ILocationService paramILocationService, ILyftPreferences paramILyftPreferences, IPaymentService paramIPaymentService, IChargeAccountsProvider paramIChargeAccountsProvider, IConstantsProvider paramIConstantsProvider, IAppStore paramIAppStore)
  {
    signupUserRepository = paramISignUpUserRepository;
    userProvider = paramIUserProvider;
    lyftApi = paramILyftApi;
    locationService = paramILocationService;
    preferences = paramILyftPreferences;
    paymentService = paramIPaymentService;
    chargeAccountsProvider = paramIChargeAccountsProvider;
    constantsProvider = paramIConstantsProvider;
    appStore = paramIAppStore;
  }
  
  private void forceNewAccount(SignupUser paramSignupUser, PhoneDTO paramPhoneDTO)
  {
    loadAppState(null, paramSignupUser, paramPhoneDTO, null, Boolean.valueOf(true)).onErrorResumeNext(new Func1()
    {
      public Observable<? extends Unit> call(Throwable paramAnonymousThrowable)
      {
        return Observable.error(PhoneLoginErrorParser.parse(paramAnonymousThrowable));
      }
    });
  }
  
  private Observable<Unit> loadAppState()
  {
    return loadAppState(null, null, null, null, null);
  }
  
  private Observable<Unit> loadAppState(final String paramString, final SignupUser paramSignupUser, final PhoneDTO paramPhoneDTO, final AdditionalAuthMethodDTO paramAdditionalAuthMethodDTO, final Boolean paramBoolean)
  {
    Observable localObservable = Observable.just(Unit.create());
    if (userProvider.getUser().isNull()) {
      localObservable = locationService.getLastLocation().flatMap(new Func1()
      {
        public Observable<UniversalDTO> call(Location paramAnonymousLocation)
        {
          LocationDTO localLocationDTO = LocationMapper.toLocationDTO(paramAnonymousLocation);
          paramAnonymousLocation = null;
          String str1 = null;
          String str2 = null;
          Boolean localBoolean = null;
          if (paramSignupUser != null)
          {
            paramAnonymousLocation = paramSignupUser.getFirstName().trim();
            str1 = paramSignupUser.getLastName().trim();
            str2 = paramSignupUser.getEmail().trim();
            localBoolean = Boolean.valueOf(paramSignupUser.hasAgreedToS());
          }
          paramAnonymousLocation = new LoginRequestDTO(paramAnonymousLocation, str1, str2, preferences.getInstallReferrer(), paramPhoneDTO, preferences.getMatId(), localBoolean, localLocationDTO, "returnappinfo", appStore.getAppStoreSource(), paramAdditionalAuthMethodDTO, paramBoolean);
          return lyftApi.createUser(paramString, paramAnonymousLocation);
        }
      }).map(Unit.func1());
    }
    paramString = localObservable;
    if (!chargeAccountsProvider.isInitialized()) {
      paramString = localObservable.flatMap(new Func1()
      {
        public Observable<Unit> call(Unit paramAnonymousUnit)
        {
          return paymentService.refreshChargeAccounts();
        }
      });
    }
    return paramString;
  }
  
  public Observable<Unit> createFacebookUser(FacebookLoginResult paramFacebookLoginResult)
  {
    final ActionAnalytics localActionAnalytics = OnBoardingAnalytics.trackAddFacebook();
    if (paramFacebookLoginResult.isSuccess()) {
      paramFacebookLoginResult = loadAppState(accessToken, null, null, null, null);
    }
    for (;;)
    {
      paramFacebookLoginResult.onErrorResumeNext(new Func1()
      {
        public Observable<Unit> call(Throwable paramAnonymousThrowable)
        {
          return Observable.error(PhoneLoginErrorParser.parse(paramAnonymousThrowable));
        }
      }).doOnEach(new Action1()
      {
        public void call(Notification<? super Unit> paramAnonymousNotification)
        {
          AnalyticsUtils.trackResult(localActionAnalytics, paramAnonymousNotification);
        }
      });
      if (error != null) {
        paramFacebookLoginResult = Observable.error(error);
      } else {
        paramFacebookLoginResult = Observable.empty();
      }
    }
  }
  
  public Observable<Unit> createUser(SignupUser paramSignupUser)
  {
    if (!paramSignupUser.isValid())
    {
      LandingValidationException localLandingValidationException = new LandingValidationException();
      if (!paramSignupUser.validateFirstName()) {
        localLandingValidationException.addField("first_name");
      }
      if (!paramSignupUser.validateLastName()) {
        localLandingValidationException.addField("last_name");
      }
      if (!paramSignupUser.validateEmail()) {
        localLandingValidationException.addField("email");
      }
      return Observable.error(localLandingValidationException);
    }
    signupUserRepository.update(paramSignupUser);
    return Unit.just();
  }
  
  public Observable<Unit> loadUser()
  {
    return loadAppState();
  }
  
  public Observable<Unit> requestVerificationCode(String paramString)
  {
    if (Strings.isNullOrEmpty(paramString)) {
      return Observable.error(new InvalidPhoneFormatException());
    }
    paramString = new PhoneRequestDTO(new PhoneDTO(paramString, null, null, null));
    lyftApi.requestPhoneAuthentication(paramString).onErrorResumeNext(new Func1()
    {
      public Observable<? extends Unit> call(Throwable paramAnonymousThrowable)
      {
        return Observable.error(PhoneLoginErrorParser.parse(paramAnonymousThrowable));
      }
    });
  }
  
  public Observable<Unit> updateExistingUser(SignupUser paramSignupUser)
  {
    if (!paramSignupUser.hasAgreedToS()) {
      return Observable.error(new TermsNotAcceptedException());
    }
    if (!paramSignupUser.isValid())
    {
      localObject = new LandingValidationException();
      if (!paramSignupUser.validateFirstName()) {
        ((LandingValidationException)localObject).addField("first_name");
      }
      if (!paramSignupUser.validateLastName()) {
        ((LandingValidationException)localObject).addField("last_name");
      }
      if (!paramSignupUser.validateEmail()) {
        ((LandingValidationException)localObject).addField("email");
      }
      return Observable.error((Throwable)localObject);
    }
    User localUser = userProvider.getUser();
    if (localUser.hasTermsUrl()) {}
    for (Object localObject = localUser.getTermsUrl();; localObject = (String)constantsProvider.get(Constants.SIGNUP_TERMS_URL))
    {
      paramSignupUser = new UpdateUserRequestBuilder().withTermsUrl((String)localObject).withFirstName(paramSignupUser.getFirstName()).withLastName(paramSignupUser.getLastName()).withEmail(paramSignupUser.getEmail()).build();
      lyftApi.updateUser((String)Objects.firstNonNull(localUser.getId(), ""), paramSignupUser).map(Unit.func1()).onErrorResumeNext(new Func1()
      {
        public Observable<? extends Unit> call(Throwable paramAnonymousThrowable)
        {
          return Observable.error(PhoneLoginErrorParser.parse(paramAnonymousThrowable));
        }
      });
    }
  }
  
  public Observable<Unit> verifyCreditCard(Phone paramPhone, String paramString)
  {
    paramString = new AdditionalAuthMethodDTO("ccLast4", paramString);
    loadAppState(null, null, PhoneMapper.toPhoneDTO(paramPhone), paramString, null).onErrorResumeNext(new Func1()
    {
      public Observable<? extends Unit> call(Throwable paramAnonymousThrowable)
      {
        return Observable.error(PhoneLoginErrorParser.parse(paramAnonymousThrowable));
      }
    });
  }
  
  public Observable<Unit> verifyDriverLicense(Phone paramPhone, String paramString)
  {
    paramString = new AdditionalAuthMethodDTO("driversLicenseNumber", paramString);
    loadAppState(null, null, PhoneMapper.toPhoneDTO(paramPhone), paramString, null).onErrorResumeNext(new Func1()
    {
      public Observable<? extends Unit> call(Throwable paramAnonymousThrowable)
      {
        return Observable.error(PhoneLoginErrorParser.parse(paramAnonymousThrowable));
      }
    });
  }
  
  public Observable<Unit> verifyPhone(String paramString1, final String paramString2, boolean paramBoolean)
  {
    if (paramString2.length() != 4) {
      return Observable.error(new VerificationCodeTooShortException());
    }
    User localUser = userProvider.getUser();
    final SignupUser localSignupUser = signupUserRepository.get();
    paramString2 = new PhoneDTO(paramString1, IntegerExtensions.tryParse(paramString2, 0), null, null);
    if (localUser.isNull()) {}
    for (paramString1 = loadAppState(null, localSignupUser, paramString2, null, Boolean.valueOf(paramBoolean));; paramString1 = lyftApi.updateUser(localUser.getId(), paramString1).map(Unit.func1()))
    {
      paramString1.onErrorResumeNext(new Func1()
      {
        public Observable<? extends Unit> call(Throwable paramAnonymousThrowable)
        {
          if ((PhoneLoginErrorParser.parse(paramAnonymousThrowable) instanceof AdditionalAuthRequiredException)) {
            LandingService.this.forceNewAccount(localSignupUser, paramString2);
          }
          return Observable.error(PhoneLoginErrorParser.parse(paramAnonymousThrowable));
        }
      });
      paramString1 = new UpdateUserRequestBuilder().withPhone(paramString2).withCouponCode(preferences.getInstallReferrer()).build();
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.landing.LandingService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */