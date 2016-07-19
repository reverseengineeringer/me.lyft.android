package me.lyft.android.persistence;

import dagger.Module;
import dagger.Provides;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;
import javax.inject.Singleton;
import me.lyft.android.LyftApplication;
import me.lyft.android.application.checkout.ICheckoutSession;
import me.lyft.android.application.cleanup.ICleanupRegistry;
import me.lyft.android.application.payment.IPaymentDefaultsService;
import me.lyft.android.application.payment.PaymentDefaultsService;
import me.lyft.android.domain.passenger.ride.PassengerRideReceipt;
import me.lyft.android.domain.passenger.ridetypes.RequestRideType;
import me.lyft.android.domain.splitfare.SplitFareRequest;
import me.lyft.android.domain.splitfare.SplitFareState;
import me.lyft.android.infrastructure.json.IJsonSerializer;
import me.lyft.android.persistence.checkout.CheckoutStateStorage;
import me.lyft.android.persistence.checkout.ICheckoutStateStorage;
import me.lyft.android.persistence.expensenote.ExpenseNoteStorage;
import me.lyft.android.persistence.expensenotes.IExpenseNoteStorage;
import me.lyft.android.persistence.landing.ISignUpUserRepository;
import me.lyft.android.persistence.landing.SignUpUserRepository;
import me.lyft.android.persistence.landing.SignupUser;
import me.lyft.android.persistence.payment.ChargeAccountsProvider;
import me.lyft.android.persistence.payment.IChargeAccountsProvider;
import me.lyft.android.persistence.rating.IRatingStateStorage;
import me.lyft.android.persistence.rating.RatingStateStorage;
import me.lyft.android.persistence.ride.IPassengerRideReceiptService;
import me.lyft.android.persistence.ride.PassengerRideReceiptService;
import me.lyft.android.persistence.splitfare.ISplitFareRequestRepository;
import me.lyft.android.persistence.splitfare.ISplitFareStateRepository;
import me.lyft.android.persistence.splitfare.SplitFareRequestRepository;
import me.lyft.android.persistence.splitfare.SplitFareStateRepository;

@Module(complete=false, library=true)
public class PersistenceModule
{
  @Provides
  @Singleton
  public IChargeAccountsProvider provideChargeAccountsProvider(ISimpleRepositoryFactory paramISimpleRepositoryFactory)
  {
    Type localType = new PersistenceModule.1(this).getType();
    return new ChargeAccountsProvider(paramISimpleRepositoryFactory.createRepository("charge_accounts", Collections.emptyList(), localType));
  }
  
  @Provides
  @Singleton
  public ICheckoutStateStorage provideCheckoutStateStorage(LyftApplication paramLyftApplication)
  {
    return new CheckoutStateStorage(paramLyftApplication);
  }
  
  @Provides
  @Singleton
  public IPaymentDefaultsService provideDefaultChargeAccountsService(IChargeAccountsProvider paramIChargeAccountsProvider, ICheckoutSession paramICheckoutSession)
  {
    return new PaymentDefaultsService(paramIChargeAccountsProvider, paramICheckoutSession);
  }
  
  @Provides
  @Singleton
  public IExpenseNoteStorage provideExpenseNoteStorage(LyftApplication paramLyftApplication)
  {
    return new ExpenseNoteStorage(paramLyftApplication);
  }
  
  @Provides
  @Singleton
  public IRatingStateStorage provideRatingStateStorage(LyftApplication paramLyftApplication)
  {
    return new RatingStateStorage(paramLyftApplication);
  }
  
  @Provides
  @Singleton
  IPassengerRideReceiptService provideRideFareRepository(ISimpleRepositoryFactory paramISimpleRepositoryFactory)
  {
    return new PassengerRideReceiptService(paramISimpleRepositoryFactory.createRepository("ride_fare", PassengerRideReceipt.empty(), PassengerRideReceipt.class));
  }
  
  @Provides
  @Singleton
  public ISimpleRepository<List<RequestRideType>> provideRideTypeRepository(ISimpleRepositoryFactory paramISimpleRepositoryFactory)
  {
    Type localType = new PersistenceModule.2(this).getType();
    return paramISimpleRepositoryFactory.createRepository("ride_types", Collections.emptyList(), localType);
  }
  
  @Provides
  @Singleton
  public ISignUpUserRepository provideSignUpUserRepository(ISimpleRepositoryFactory paramISimpleRepositoryFactory)
  {
    return new SignUpUserRepository(paramISimpleRepositoryFactory.createRepository("sign_up_user", SignupUser.empty(), SignupUser.class));
  }
  
  @Provides
  @Singleton
  public ISimpleRepositoryFactory provideSimpleRepositoryFactory(LyftApplication paramLyftApplication, IJsonSerializer paramIJsonSerializer, ICleanupRegistry paramICleanupRegistry)
  {
    return new JsonSimpleRepositoryFactory(new SharedPreferencesStorage(paramLyftApplication, "simple_storage"), paramIJsonSerializer, paramICleanupRegistry);
  }
  
  @Provides
  @Singleton
  ISplitFareRequestRepository provideSplitFareRequestRepository(ISimpleRepositoryFactory paramISimpleRepositoryFactory)
  {
    return new SplitFareRequestRepository(paramISimpleRepositoryFactory.createRepository("split_fare_pending_request", SplitFareRequest.empty(), SplitFareRequest.class));
  }
  
  @Provides
  @Singleton
  ISplitFareStateRepository provideSplitFareStateRepository(ISimpleRepositoryFactory paramISimpleRepositoryFactory)
  {
    return new SplitFareStateRepository(paramISimpleRepositoryFactory.createRepository("split_fare_state", SplitFareState.empty(), SplitFareState.class));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.persistence.PersistenceModule
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */