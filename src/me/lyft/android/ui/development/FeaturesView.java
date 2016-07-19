package me.lyft.android.ui.development;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import butterknife.ButterKnife;
import com.lyft.scoop.dagger.DaggerInjector;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import me.lyft.android.application.features.IFeatureFlagsOverrideManager;
import me.lyft.android.infrastructure.lyft.features.FeatureFlag;

public class FeaturesView
  extends RelativeLayout
{
  @Inject
  IFeatureFlagsOverrideManager featureFlagsManager;
  LinearLayout featuresContainerLayout;
  
  public FeaturesView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DaggerInjector.fromView(this).inject(this);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    Iterator localIterator = featureFlagsManager.getFlags().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (FeatureFlag)localIterator.next();
      localObject = new BooleanSwitcherView(getContext(), (FeatureFlag)localObject);
      featuresContainerLayout.addView((View)localObject);
    }
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    ButterKnife.bind(this);
  }
  
  public void onResetFeaturesClicked()
  {
    featureFlagsManager.resetAllOverrides();
    int j = featuresContainerLayout.getChildCount();
    int i = 0;
    while (i < j)
    {
      if ((featuresContainerLayout.getChildAt(i) instanceof BooleanSwitcherView)) {
        ((BooleanSwitcherView)featuresContainerLayout.getChildAt(i)).updateToggleState();
      }
      i += 1;
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.development.FeaturesView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */