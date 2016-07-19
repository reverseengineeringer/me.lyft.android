package me.lyft.android.ui.settings;

import android.content.res.Resources;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.lyft.widgets.Toggle;
import javax.inject.Inject;
import me.lyft.android.ILyftPreferences;
import me.lyft.android.application.IUserProvider;
import me.lyft.android.common.RxViewController;
import me.lyft.android.controls.Toolbar;
import me.lyft.android.domain.User;
import me.lyft.android.navigation.NavigationSettings;
import me.lyft.android.navigation.WazeNavigation;
import me.lyft.android.rx.RxUIBinder;
import rx.functions.Action1;

public class NavigationSettingsController
  extends RxViewController
{
  Toggle autoNavigationToggle;
  View autoNavigationToggleLayout;
  Toggle autoSwitchBackToggle;
  @Inject
  ILyftPreferences lyftPreferences;
  @Inject
  NavigationSettings navigationSettings;
  ListView navigatorsListView;
  private final Action1<Boolean> onAutoNavigationToggleChanged = new NavigationSettingsController.2(this);
  private final Action1<Boolean> onAutoSwitchBackToggleChanged = new NavigationSettingsController.3(this);
  private AdapterView.OnItemClickListener onNavigatorSelectedListener = new NavigationSettingsController.1(this);
  Toolbar toolbar;
  @Inject
  IUserProvider userProvider;
  @Inject
  WazeNavigation wazeNavigation;
  
  protected int layoutId()
  {
    return 2130903298;
  }
  
  public void onAttach()
  {
    int i = 0;
    super.onAttach();
    toolbar.setTitle(getResources().getString(2131165922));
    Object localObject = getResources().getString(2131165923);
    String str = getResources().getString(2131165924);
    localObject = new ArrayAdapter(getView().getContext(), 2130903455, 2131558937, new String[] { localObject, str });
    navigatorsListView.setAdapter((ListAdapter)localObject);
    navigatorsListView.setOnItemClickListener(onNavigatorSelectedListener);
    boolean bool = userProvider.getUser().isApprovedDriver();
    localObject = autoNavigationToggleLayout;
    if (bool) {}
    for (;;)
    {
      ((View)localObject).setVisibility(i);
      navigatorsListView.setItemChecked(navigationSettings.getDefaultNavigation(), true);
      autoNavigationToggle.setChecked(lyftPreferences.isAutoNavigationEnabled());
      binder.bindAction(autoNavigationToggle.observeChange(), onAutoNavigationToggleChanged);
      autoSwitchBackToggle.setChecked(lyftPreferences.isAutoSwitchBackEnabled());
      binder.bindAction(autoSwitchBackToggle.observeChange(), onAutoSwitchBackToggleChanged);
      return;
      i = 8;
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.settings.NavigationSettingsController
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */