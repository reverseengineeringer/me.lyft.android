package me.lyft.android.ui.business.onboard;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import com.lyft.widgets.PagingIndicator;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import me.lyft.android.application.business.BusinessOnboardingAnalytics;
import me.lyft.android.application.enterprise.IEnterpriseService;
import me.lyft.android.common.AppFlow;
import me.lyft.android.common.RxViewController;
import me.lyft.android.errorhandling.IDefaultErrorHandler;
import me.lyft.android.rx.RxUIBinder;
import me.lyft.android.ui.IProgressController;

public class NewUserDescriptionController
  extends RxViewController
{
  private final AppFlow appFlow;
  private final BusinessOnboardingAnalytics businessOnboardingAnalytics;
  private final IEnterpriseService enterpriseService;
  private final IDefaultErrorHandler errorHandler;
  private List<Drawable> iconImageList;
  ImageView iconImageView;
  PagingIndicator pagingIndicatorView;
  private final IProgressController progressController;
  ViewPager viewPager;
  
  @Inject
  public NewUserDescriptionController(AppFlow paramAppFlow, IEnterpriseService paramIEnterpriseService, IProgressController paramIProgressController, IDefaultErrorHandler paramIDefaultErrorHandler, BusinessOnboardingAnalytics paramBusinessOnboardingAnalytics)
  {
    appFlow = paramAppFlow;
    enterpriseService = paramIEnterpriseService;
    progressController = paramIProgressController;
    errorHandler = paramIDefaultErrorHandler;
    businessOnboardingAnalytics = paramBusinessOnboardingAnalytics;
  }
  
  private List<NewUserDescriptionController.DescriptionText> getDescriptionTexts()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new NewUserDescriptionController.DescriptionText(getResources().getString(2131165343), getResources().getString(2131165342)));
    localArrayList.add(new NewUserDescriptionController.DescriptionText(getResources().getString(2131165339), getResources().getString(2131165338)));
    localArrayList.add(new NewUserDescriptionController.DescriptionText(getResources().getString(2131165335), getResources().getString(2131165334)));
    return localArrayList;
  }
  
  private void initializeImageList()
  {
    iconImageList = new ArrayList();
    iconImageList.add(getResources().getDrawable(2130838367));
    iconImageList.add(getResources().getDrawable(2130838269));
    iconImageList.add(getResources().getDrawable(2130838180));
  }
  
  protected int layoutId()
  {
    return 2130903070;
  }
  
  public void onAttach()
  {
    super.onAttach();
    initializeImageList();
    NewUserDescriptionPagerAdapter localNewUserDescriptionPagerAdapter = new NewUserDescriptionPagerAdapter(getDescriptionTexts(), LayoutInflater.from(getView().getContext()));
    viewPager.setAdapter(localNewUserDescriptionPagerAdapter);
    viewPager.addOnPageChangeListener(new NewUserDescriptionController.1(this));
    iconImageView.setImageDrawable((Drawable)iconImageList.get(viewPager.getCurrentItem()));
    pagingIndicatorView.setNumberOfViews(localNewUserDescriptionPagerAdapter.getCount());
    pagingIndicatorView.selectPosition(viewPager.getCurrentItem());
  }
  
  void onGetStartedButtonClick()
  {
    businessOnboardingAnalytics.initializeGetStarted();
    progressController.showProgress();
    binder.bindAsyncCall(enterpriseService.getUserOrganization(), new NewUserDescriptionController.2(this));
  }
  
  void onNotNowButtonClick()
  {
    appFlow.goBack();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.business.onboard.NewUserDescriptionController
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */