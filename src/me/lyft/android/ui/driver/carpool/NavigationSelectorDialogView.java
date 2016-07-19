package me.lyft.android.ui.driver.carpool;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import butterknife.ButterKnife;
import com.lyft.rx.MessageBus;
import com.lyft.scoop.dagger.DaggerInjector;
import java.util.Arrays;
import javax.inject.Inject;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.navigation.NavigationSettings;
import me.lyft.android.ui.dialogs.DialogContainerView;

public class NavigationSelectorDialogView
  extends DialogContainerView
{
  private final String[] NAVIGATION_LABELS = { getResources().getString(2131165923), getResources().getString(2131165924) };
  @Inject
  MessageBus bus;
  @Inject
  DialogFlow dialogFlow;
  @Inject
  NavigationSettings navigationSettings;
  ListView navigatorsListView;
  private AdapterView.OnItemClickListener onNavigatorSelectedListener = new NavigationSelectorDialogView.1(this);
  private int selectedNavigatorIndex;
  
  public NavigationSelectorDialogView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DaggerInjector.fromView(this).inject(this);
    selectedNavigatorIndex = navigationSettings.getDefaultNavigation();
  }
  
  private void setAndLaunchNavigation()
  {
    dialogFlow.dismiss();
    navigationSettings.changeDefaultNavigation(selectedNavigatorIndex);
    bus.post(NavigationSelectorDialogView.StartNavigationEvent.class);
  }
  
  public void navigate()
  {
    setAndLaunchNavigation();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (!navigationSettings.hasMultipleNavigationApps())
    {
      dialogFlow.dismiss();
      bus.post(NavigationSelectorDialogView.StartNavigationEvent.class);
      return;
    }
    NavigationSelectorDialogView.NavigationItemAdapter localNavigationItemAdapter = new NavigationSelectorDialogView.NavigationItemAdapter(getContext(), Arrays.asList(NAVIGATION_LABELS), selectedNavigatorIndex);
    navigatorsListView.setAdapter(localNavigationItemAdapter);
    navigatorsListView.setOnItemClickListener(onNavigatorSelectedListener);
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    if (isInEditMode()) {
      return;
    }
    ButterKnife.bind(this);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.driver.carpool.NavigationSelectorDialogView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */