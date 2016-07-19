package me.lyft.android.ui.development;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.lyft.scoop.dagger.DaggerInjector;
import com.lyft.widgets.Toggle;
import javax.inject.Inject;
import me.lyft.android.application.features.IFeatureFlagsOverrideManager;
import me.lyft.android.application.features.IFeaturesProvider;
import me.lyft.android.infrastructure.lyft.features.FeatureFlag;
import me.lyft.android.rx.Binder;

public class BooleanSwitcherView
  extends LinearLayout
{
  TextView featureDate;
  TextView featureDescriptionTextView;
  @Inject
  IFeatureFlagsOverrideManager featureFlagsManager;
  TextView featureNameTextView;
  Toggle featureToggle;
  TextView featureUrlTextView;
  @Inject
  IFeaturesProvider featuresProvider;
  private final FeatureFlag flag;
  View removeButton;
  
  public BooleanSwitcherView(Context paramContext, FeatureFlag paramFeatureFlag)
  {
    super(paramContext);
    flag = paramFeatureFlag;
    DaggerInjector.fromView(this).inject(this);
    LayoutInflater.from(paramContext).inflate(2130903053, this, true);
    ButterKnife.bind(this);
    setOrientation(1);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    updateToggleState();
    featureNameTextView.setText(flag.getKey());
    featureDate.setText(flag.getDate());
    featureDescriptionTextView.setText(flag.getDescription());
    featureUrlTextView.setText(flag.getStoryUrl());
    Binder.attach(this).bind(featureToggle.observeChange(), new BooleanSwitcherView.1(this));
    removeButton.setOnClickListener(new BooleanSwitcherView.2(this));
  }
  
  public void updateToggleState()
  {
    if (featureFlagsManager.hasManualOverride(flag)) {
      removeButton.setVisibility(0);
    }
    for (;;)
    {
      featureToggle.setChecked(featuresProvider.isEnabled(flag), false);
      return;
      removeButton.setVisibility(4);
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.development.BooleanSwitcherView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */