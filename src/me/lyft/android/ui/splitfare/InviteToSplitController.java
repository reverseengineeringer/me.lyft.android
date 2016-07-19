package me.lyft.android.ui.splitfare;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.Interpolator;
import android.widget.ListView;
import android.widget.TextView;
import com.lyft.rx.MessageBus;
import com.lyft.scoop.HandleBack;
import com.lyft.scoop.Scoop;
import java.util.List;
import javax.inject.Inject;
import me.lyft.android.adapters.ContactsAdapter;
import me.lyft.android.analytics.studies.SplitFareAnalytics;
import me.lyft.android.application.constants.Constants;
import me.lyft.android.application.constants.IConstantsProvider;
import me.lyft.android.application.passenger.IPassengerRideProvider;
import me.lyft.android.application.requestridetypes.IRideTypeMetaService;
import me.lyft.android.common.AppFlow;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.common.Iterables;
import me.lyft.android.common.RxViewController;
import me.lyft.android.common.Unit;
import me.lyft.android.controls.BackButtonToolbar;
import me.lyft.android.controls.Toolbar;
import me.lyft.android.domain.passenger.ride.PassengerRide;
import me.lyft.android.domain.ride.RideType;
import me.lyft.android.domain.splitfare.SplitFareState;
import me.lyft.android.infrastructure.splitfare.ISplitFareService;
import me.lyft.android.persistence.splitfare.ISplitFareStateRepository;
import me.lyft.android.rx.RxUIBinder;
import me.lyft.android.ui.IProgressController;
import me.lyft.android.ui.IViewErrorHandler;
import rx.functions.Action1;

public class InviteToSplitController
  extends RxViewController
  implements HandleBack
{
  private static final int ANIMATION_DURATION = 250;
  private static final int NO_ANIMATION = 0;
  private static final int TRANSLATION_Y = 0;
  private final Interpolator animationInterpolator = new InviteToSplitController.8(this);
  private final AppFlow appFlow;
  private final MessageBus bus;
  private final IConstantsProvider constantsProvider;
  private ContactsAdapter contactsAdapter;
  ListView contactsList;
  private final DialogFlow dialogFlow;
  View emptyView;
  private final int maxContributors;
  final Action1<Unit> onRideUpdated = new InviteToSplitController.4(this);
  private final IProgressController progressController;
  private final IPassengerRideProvider rideProvider;
  View sendInvitesButton;
  private final SplitFareAnalytics splitFareAnalytics;
  private final ISplitFareService splitFareService;
  private final ISplitFareStateRepository splitFareStateRepository;
  TextView splitPaymentFee;
  BackButtonToolbar toolbar;
  final Action1<Integer> toolbarItemClicked = new InviteToSplitController.3(this);
  private final IViewErrorHandler viewErrorHandler;
  
  @Inject
  public InviteToSplitController(AppFlow paramAppFlow, DialogFlow paramDialogFlow, MessageBus paramMessageBus, IConstantsProvider paramIConstantsProvider, IProgressController paramIProgressController, IViewErrorHandler paramIViewErrorHandler, IPassengerRideProvider paramIPassengerRideProvider, ISplitFareService paramISplitFareService, IRideTypeMetaService paramIRideTypeMetaService, ISplitFareStateRepository paramISplitFareStateRepository, SplitFareAnalytics paramSplitFareAnalytics)
  {
    appFlow = paramAppFlow;
    dialogFlow = paramDialogFlow;
    bus = paramMessageBus;
    constantsProvider = paramIConstantsProvider;
    progressController = paramIProgressController;
    viewErrorHandler = paramIViewErrorHandler;
    rideProvider = paramIPassengerRideProvider;
    splitFareService = paramISplitFareService;
    splitFareStateRepository = paramISplitFareStateRepository;
    splitFareAnalytics = paramSplitFareAnalytics;
    maxContributors = (paramIRideTypeMetaService.getMaximumContributorsForRideType(paramIPassengerRideProvider.getPassengerRide().getRideType().getType()) - paramISplitFareStateRepository.getSplitFareState().getInvitedContributorsCount());
  }
  
  private void animateButton(int paramInt1, int paramInt2)
  {
    sendInvitesButton.animate().translationY(paramInt1).setDuration(paramInt2).setInterpolator(animationInterpolator).start();
  }
  
  private boolean hasMaxInvitesBeenHit()
  {
    return contactsAdapter.getCheckedItemCount() >= maxContributors;
  }
  
  private void hideButton(int paramInt)
  {
    animateButton(sendInvitesButton.getHeight(), paramInt);
  }
  
  private void loadContacts()
  {
    binder.bindAsyncCall(splitFareService.observeSplitFareContacts(), new InviteToSplitController.7(this));
  }
  
  private void setListItemChecked(int paramInt)
  {
    if (contactsAdapter.isItemDisabled(paramInt)) {
      return;
    }
    boolean bool = contactsAdapter.isItemChecked(paramInt);
    if (hasMaxInvitesBeenHit()) {
      if (bool) {
        contactsAdapter.toggleChecked(paramInt);
      }
    }
    for (;;)
    {
      contactsAdapter.setHasMaxInvitesBeenHit(hasMaxInvitesBeenHit());
      updateButtonAndTextStates();
      return;
      contactsAdapter.toggleChecked(paramInt);
    }
  }
  
  private void showButton(int paramInt)
  {
    animateButton(0, paramInt);
  }
  
  private void updateButtonAndTextStates()
  {
    updateButtonAndTextStates(250);
  }
  
  private void updateButtonAndTextStates(int paramInt)
  {
    if (contactsAdapter.getCheckedItemCount() > 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      showButton(paramInt);
      return;
    }
    hideButton(paramInt);
  }
  
  protected int layoutId()
  {
    return 2130903259;
  }
  
  public void onAttach()
  {
    super.onAttach();
    contactsAdapter = new ContactsAdapter(getScoop().inflater(getView().getContext()));
    toolbar.clearItems().addItem(2131558456, 2130838338).setTitle(getResources().getString(2131165828));
    splitPaymentFee.setText((CharSequence)constantsProvider.get(Constants.SPLIT_PAYMENT_FEE_TEXT, getResources().getString(2131165542)));
    contactsList.setAdapter(contactsAdapter);
    binder.bindAction(rideProvider.observeRideUpdateEvent(), onRideUpdated);
    binder.bindAction(bus.observe(ContactsSearchDialogView.ContactSelectedEvent.class), new InviteToSplitController.1(this));
    binder.bindAction(toolbar.observeItemClick(), toolbarItemClicked);
    binder.bindAction(toolbar.observeHomeClick(), new InviteToSplitController.2(this));
    loadContacts();
    splitFareAnalytics.trackOpenSplitScreen();
  }
  
  public boolean onBack()
  {
    splitFareAnalytics.trackSplitScreenCancel("back");
    return false;
  }
  
  void onItemClick(int paramInt)
  {
    setListItemChecked(paramInt);
  }
  
  void sendInvites()
  {
    List localList = Iterables.where(contactsAdapter.getCheckedData(), new InviteToSplitController.5(this));
    progressController.showProgress();
    binder.bindAsyncCall(splitFareService.sendInvites(localList), new InviteToSplitController.6(this));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.splitfare.InviteToSplitController
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */