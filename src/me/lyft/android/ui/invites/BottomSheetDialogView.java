package me.lyft.android.ui.invites;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.widget.ViewDragHelper;
import android.support.v4.widget.ViewDragHelper.Callback;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.LinearLayout;
import butterknife.ButterKnife;
import com.lyft.scoop.HandleBack;
import com.lyft.scoop.Screen;
import com.lyft.scoop.dagger.DaggerInjector;
import java.util.List;
import javax.inject.Inject;
import me.lyft.android.analytics.core.ExperimentAnalytics;
import me.lyft.android.analytics.core.IntentAnalytics;
import me.lyft.android.analytics.core.definitions.Experiment;
import me.lyft.android.analytics.studies.InviteFriendsAnalytics;
import me.lyft.android.application.IUserProvider;
import me.lyft.android.application.constants.IConstantsProvider;
import me.lyft.android.common.ActivityController;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.infrastructure.device.IDevice;
import me.lyft.android.rx.Binder;
import me.lyft.android.rx.ViewExtensions;
import me.lyft.android.ui.dialogs.Toast;
import rx.Observable;
import rx.functions.Action1;

public class BottomSheetDialogView
  extends FrameLayout
  implements HandleBack
{
  private static final int ANIM_IN_DURATION = 350;
  private static final int ANIM_OUT_DURATION = 350;
  private static final float CONTAINER_BACKGROUND_ALPHA = 0.2F;
  private static final int DRAWER_CONTAINER_OFFSET_PX = 200;
  @Inject
  ActivityController activityController;
  private final BottomSheetViewAdapter adapter;
  private final Interpolator attachInterpolator = new OvershootInterpolator();
  View backgroundView;
  private Binder binder;
  GridView bottomSheet;
  LinearLayout bottomSheetContainer;
  final ViewDragHelper.Callback callback = new BottomSheetDialogView.3(this);
  @Inject
  IConstantsProvider constantsProvider;
  private final Interpolator detachInterpolator = new DecelerateInterpolator();
  @Inject
  IDevice device;
  @Inject
  DialogFlow dialogFlow;
  private final ViewDragHelper dragHelper;
  private boolean isAddedToWindow = false;
  private boolean isRemoving = false;
  final Action1<List<ShareItemProvider.ShareItem>> onListItemsLoaded = new BottomSheetDialogView.2(this);
  private final InviteDialogs.SocialSheet params;
  @Inject
  ReferralTrackingService referralTrackingService;
  private IntentAnalytics shareInvitesIntent = InviteFriendsAnalytics.createShareInvitesIntent();
  private final ShareItemProvider shareItemProvider;
  @Inject
  SocialIntentProvider socialIntentProvider;
  @Inject
  IUserProvider userProvider;
  
  public BottomSheetDialogView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DaggerInjector.fromView(this).inject(this);
    params = ((InviteDialogs.SocialSheet)Screen.fromView(this));
    shareItemProvider = new ShareItemProvider.Builder().build(getResources(), userProvider, constantsProvider);
    adapter = new BottomSheetViewAdapter(LayoutInflater.from(paramContext));
    dragHelper = ViewDragHelper.create(this, 1.0F, callback);
  }
  
  void animateOut()
  {
    if ((isAddedToWindow) && (!isRemoving))
    {
      isRemoving = true;
      ViewCompat.animate(backgroundView).alpha(0.0F).setDuration(350L).start();
      ViewCompat.animate(bottomSheetContainer).translationY(ViewCompat.getTranslationY(bottomSheetContainer) + bottomSheetContainer.getHeight() - 200.0F).setDuration(350L).setInterpolator(detachInterpolator).setListener(new BottomSheetDialogView.4(this)).start();
    }
  }
  
  public void computeScroll()
  {
    super.computeScroll();
    if (dragHelper.continueSettling(true)) {
      ViewCompat.postInvalidateOnAnimation(this);
    }
  }
  
  void copyReferralCodeToClipboard()
  {
    ClipboardUtil.copyToClipboard(getContext(), shareItemProvider.getCopyShareItem().shareText);
    dialogFlow.show(new Toast(getResources().getString(2131165476)));
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    shareInvitesIntent.trackInitiation();
    binder = Binder.attach(this);
    binder.bind(shareItemProvider.observeInstalledShareItems(device).toList(), onListItemsLoaded);
    binder.bind(ViewExtensions.onLoadedObservable(bottomSheetContainer), new BottomSheetDialogView.1(this));
  }
  
  public boolean onBack()
  {
    shareInvitesIntent.trackCanceled("tap_back");
    animateOut();
    return true;
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    ButterKnife.bind(this, this);
    bottomSheet.setAdapter(adapter);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return dragHelper.shouldInterceptTouchEvent(paramMotionEvent);
  }
  
  void onItemClick()
  {
    shareInvitesIntent.trackCanceled("tap_background");
    animateOut();
  }
  
  void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (ShareItemProvider.ShareItem)paramAdapterView.getItemAtPosition(paramInt);
    if (paramAdapterView == shareItemProvider.getCopyShareItem())
    {
      shareInvitesIntent.trackSuccess(name);
      copyReferralCodeToClipboard();
      referralTrackingService.didShare();
    }
    for (;;)
    {
      animateOut();
      return;
      try
      {
        ExperimentAnalytics.trackExposure(Experiment.PG_INVITE_TEXT_V2);
        InviteFriendsAnalytics.displayShowInviteText();
        paramView = socialIntentProvider.createShareIntent(paramAdapterView);
        activityController.startActivity(paramView);
        shareInvitesIntent.trackSuccess(name);
        referralTrackingService.didShare();
      }
      catch (Exception paramAdapterView)
      {
        paramAdapterView = getResources().getString(2131165302);
        shareInvitesIntent.trackFailure(paramAdapterView);
        dialogFlow.show(new Toast(paramAdapterView));
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    dragHelper.processTouchEvent(paramMotionEvent);
    return true;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.invites.BottomSheetDialogView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */