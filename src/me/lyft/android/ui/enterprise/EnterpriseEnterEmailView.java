package me.lyft.android.ui.enterprise;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.view.GestureDetectorCompat;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.lyft.scoop.HandleBack;
import com.lyft.scoop.Screen;
import com.lyft.scoop.dagger.DaggerInjector;
import com.lyft.widgets.AdvancedEditText;
import com.lyft.widgets.LowerCaseTextWatcher;
import com.lyft.widgets.SimpleTextWatcher;
import javax.inject.Inject;
import me.lyft.android.application.constants.Constants;
import me.lyft.android.application.constants.IConstantsProvider;
import me.lyft.android.application.enterprise.IEnterpriseService;
import me.lyft.android.common.AppFlow;
import me.lyft.android.common.EmailUtils;
import me.lyft.android.common.Strings;
import me.lyft.android.controls.Toolbar;
import me.lyft.android.domain.enterprise.Organization;
import me.lyft.android.domain.enterprise.OrganizationJoinDetails;
import me.lyft.android.domain.enterprise.UserOrganization;
import me.lyft.android.providers.ContactsProvider;
import me.lyft.android.rx.Binder;
import me.lyft.android.ui.IProgressController;
import me.lyft.android.ui.MainScreensRouter;
import me.lyft.android.ui.SlideMenuController;
import me.lyft.android.utils.Keyboard;
import rx.Observable;

public class EnterpriseEnterEmailView
  extends LinearLayout
  implements HandleBack
{
  @Inject
  AppFlow appFlow;
  Binder binder;
  @Inject
  IConstantsProvider constantsProvider;
  @Inject
  ContactsProvider contactsProvider;
  AdvancedEditText emailEditText;
  TextView enterpriseDescription;
  @Inject
  IEnterpriseErrorHandler enterpriseErrorHandler;
  ScrollView enterpriseScrollView;
  @Inject
  IEnterpriseService enterpriseService;
  Button enterpriseSubmitButton;
  TextView enterpriseTitle;
  private GestureDetectorCompat gestureDetectorCompat;
  TextView inlineErrorTxt;
  @Inject
  MainScreensRouter mainScreensRouter;
  private final EnterpriseScreens.EnterpriseEnterEmailScreen params;
  @Inject
  IProgressController progressController;
  @Inject
  SlideMenuController slideMenuController;
  private SimpleTextWatcher textChangedListener = new EnterpriseEnterEmailView.7(this);
  Toolbar toolbar;
  private UserOrganization userOrganization;
  
  public EnterpriseEnterEmailView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DaggerInjector.fromView(this).inject(this);
    params = ((EnterpriseScreens.EnterpriseEnterEmailScreen)Screen.fromView(this));
  }
  
  private void setContentViewProperties()
  {
    Object localObject = params.getUserOrganization().getOrganization().getJoinDetails();
    String str = ((OrganizationJoinDetails)localObject).getJoinHeader();
    localObject = ((OrganizationJoinDetails)localObject).getJoinDescription();
    enterpriseTitle.setText(Strings.firstNonEmpty(new String[] { str, (String)constantsProvider.get(Constants.ORGANIZATION_JOIN_HEADER), getResources().getString(2131165693) }));
    enterpriseDescription.setText(Strings.firstNonEmpty(new String[] { localObject, (String)constantsProvider.get(Constants.ORGANIZATION_JOIN_DESCRIPTION), getResources().getString(2131165682) }));
    emailEditText.addTextChangedListener(new LowerCaseTextWatcher());
    emailEditText.setValidationMessageView(inlineErrorTxt);
    enterpriseScrollView.getViewTreeObserver().addOnGlobalLayoutListener(new EnterpriseEnterEmailView.4(this));
    gestureDetectorCompat = new GestureDetectorCompat(getContext(), new EnterpriseEnterEmailView.MyGestureListener(this));
  }
  
  private void verifyEmail()
  {
    String str = emailEditText.getEditableText().toString();
    if (!EmailUtils.validateEmail(str))
    {
      enterpriseErrorHandler.handleEmailError(new Throwable("Client detected Invalid email format"), inlineErrorTxt, emailEditText, false);
      return;
    }
    progressController.disableUI();
    progressController.showProgress();
    binder.bind(enterpriseService.createUserOrganization(str).flatMap(new EnterpriseEnterEmailView.5(this)), new EnterpriseEnterEmailView.6(this, str));
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    setContentViewProperties();
    toolbar.setTitle(getContext().getString(2131166167));
    enterpriseSubmitButton.setOnClickListener(new EnterpriseEnterEmailView.1(this));
    binder = Binder.attach(this);
    binder.bind(toolbar.observeHomeClick(), new EnterpriseEnterEmailView.2(this));
    emailEditText.addTextChangedListener(textChangedListener);
    Keyboard.showKeyboard(emailEditText);
    gestureDetectorCompat.setOnDoubleTapListener(new EnterpriseEnterEmailView.MyGestureListener(this));
    enterpriseScrollView.setOnTouchListener(new EnterpriseEnterEmailView.3(this));
    slideMenuController.enableMenu();
  }
  
  public boolean onBack()
  {
    mainScreensRouter.resetToHomeScreen();
    return true;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    slideMenuController.disableMenu();
    emailEditText.removeTextChangedListener(textChangedListener);
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    ButterKnife.bind(this);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.enterprise.EnterpriseEnterEmailView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */