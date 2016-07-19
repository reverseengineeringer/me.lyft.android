package me.lyft.android.ui.development;

import android.app.Application;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import javax.inject.Inject;
import me.lyft.android.ILyftPreferences;
import me.lyft.android.adapters.ConfigAdapter;
import me.lyft.android.application.ILogoutService;
import me.lyft.android.common.ActivityController;
import me.lyft.android.common.AppFlow;
import me.lyft.android.common.RxViewController;
import me.lyft.android.infrastructure.activity.SimpleActivityLifecycleCallbacks;
import me.lyft.android.infrastructure.environment.ConfigDTO;
import me.lyft.android.infrastructure.environment.ConfigsDTO;
import me.lyft.android.infrastructure.environment.IEnvironmentService;
import me.lyft.android.infrastructure.environment.IS3Api;
import me.lyft.android.rx.RxUIBinder;
import me.lyft.android.ui.IViewErrorHandler;

public class EnvironmentSwitcherViewController
  extends RxViewController
{
  private final IS3Api IS3Api;
  private final ActivityController activityController;
  private ArrayAdapter<ConfigDTO> adapter;
  private final AppFlow appFlow;
  private ConfigsDTO configs;
  ListView environmentListView;
  private final IEnvironmentService environmentService;
  SimpleActivityLifecycleCallbacks lifecycleCallback;
  private final ILogoutService logoutService;
  private final ILyftPreferences lyftPreferences;
  EditText searchEditText;
  private final IViewErrorHandler viewErrorHandler;
  private TextWatcher watcher = new EnvironmentSwitcherViewController.3(this);
  
  @Inject
  public EnvironmentSwitcherViewController(IS3Api paramIS3Api, ILyftPreferences paramILyftPreferences, ILogoutService paramILogoutService, ActivityController paramActivityController, AppFlow paramAppFlow, IEnvironmentService paramIEnvironmentService, IViewErrorHandler paramIViewErrorHandler)
  {
    IS3Api = paramIS3Api;
    lyftPreferences = paramILyftPreferences;
    logoutService = paramILogoutService;
    activityController = paramActivityController;
    appFlow = paramAppFlow;
    environmentService = paramIEnvironmentService;
    viewErrorHandler = paramIViewErrorHandler;
  }
  
  private void populateList()
  {
    int i = configs.getIndexForApiRoot(lyftPreferences.getApiRoot());
    adapter = new ConfigAdapter(getView().getContext(), 17367055, configs);
    environmentListView.setAdapter(adapter);
    adapter.notifyDataSetChanged();
    environmentListView.requestFocusFromTouch();
    environmentListView.setItemChecked(i, true);
    environmentListView.setOnItemClickListener(new EnvironmentSwitcherViewController.2(this));
  }
  
  private void restartMainActivity(Application paramApplication)
  {
    lifecycleCallback = new EnvironmentSwitcherViewController.4(this, paramApplication);
    paramApplication.registerActivityLifecycleCallbacks(lifecycleCallback);
    activityController.finish();
  }
  
  protected int layoutId()
  {
    return 2130903223;
  }
  
  public void onAttach()
  {
    super.onAttach();
    binder.bindAsyncCall(IS3Api.getConfigs(), new EnvironmentSwitcherViewController.1(this));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.development.EnvironmentSwitcherViewController
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */