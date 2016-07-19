package me.lyft.android.ui.landing;

import android.content.res.Resources;
import android.view.View;
import android.widget.ListView;
import com.lyft.rx.MessageBus;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import me.lyft.android.adapters.CountryAdapter;
import me.lyft.android.analytics.core.ActionAnalytics;
import me.lyft.android.analytics.studies.OnBoardingAnalytics;
import me.lyft.android.application.features.IFeaturesProvider;
import me.lyft.android.application.system.ICountryRepository;
import me.lyft.android.common.AppFlow;
import me.lyft.android.common.RxViewController;
import me.lyft.android.controls.Toolbar;
import me.lyft.android.domain.system.Country;

public class CountryPickerController
  extends RxViewController
{
  private final AppFlow appFlow;
  ListView countryListView;
  private final ICountryRepository countryRepository;
  private boolean didSelectCountry = false;
  private final IFeaturesProvider featuresProvider;
  private final MessageBus messageBus;
  private ActionAnalytics selectCountryAnalytics;
  private Country selectedCountry;
  Toolbar toolbar;
  
  @Inject
  public CountryPickerController(MessageBus paramMessageBus, AppFlow paramAppFlow, ICountryRepository paramICountryRepository, IFeaturesProvider paramIFeaturesProvider)
  {
    messageBus = paramMessageBus;
    appFlow = paramAppFlow;
    countryRepository = paramICountryRepository;
    featuresProvider = paramIFeaturesProvider;
  }
  
  private void initCountryPicker()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new Country("AU", getResources().getString(2131165306), true));
    localArrayList.add(new Country("CA", getResources().getString(2131165357), true));
    localArrayList.add(new Country("CN", getResources().getString(2131165452), true));
    localArrayList.add(new Country("FR", getResources().getString(2131165721), true));
    localArrayList.add(new Country("GB", getResources().getString(2131166392), true));
    localArrayList.add(new Country("IN", getResources().getString(2131165777), true));
    localArrayList.add(new Country("JP", getResources().getString(2131165837), true));
    localArrayList.add(new Country("MX", getResources().getString(2131165918), true));
    localArrayList.add(new Country("US", getResources().getString(2131166401), true));
    localArrayList.addAll(countryRepository.getSupportedCountries());
    CountryAdapter localCountryAdapter = new CountryAdapter(getView().getContext(), localArrayList, false);
    countryListView.setAdapter(localCountryAdapter);
    countryListView.setDividerHeight(0);
    countryListView.setOnItemClickListener(new CountryPickerController.1(this, localArrayList));
  }
  
  protected int layoutId()
  {
    return 2130903133;
  }
  
  public void onAttach()
  {
    super.onAttach();
    toolbar.showTitle().setTitle(getResources().getString(2131165858));
    initCountryPicker();
    selectCountryAnalytics = OnBoardingAnalytics.trackSelectCountry();
  }
  
  public void onDetach()
  {
    super.onDetach();
    if (didSelectCountry)
    {
      selectCountryAnalytics.trackSuccess(selectedCountry.getCountryCode());
      return;
    }
    selectCountryAnalytics.trackCanceled();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.landing.CountryPickerController
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */