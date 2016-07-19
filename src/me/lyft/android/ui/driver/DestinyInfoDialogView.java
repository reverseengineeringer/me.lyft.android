package me.lyft.android.ui.driver;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.lyft.scoop.dagger.DaggerInjector;
import javax.inject.Inject;
import me.lyft.android.application.constants.Constants;
import me.lyft.android.application.constants.IConstantsProvider;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.ui.dialogs.DialogContainerView;

public class DestinyInfoDialogView
  extends DialogContainerView
{
  ImageView cancelButton;
  @Inject
  IConstantsProvider constantsProvider;
  TextView destinyHeaderLabel;
  TextView destinyHeaderText;
  TextView destinySectionOneLabel;
  TextView destinySectionOneText;
  TextView destinySectionTwoLabel;
  TextView destinySectionTwoText;
  @Inject
  DialogFlow dialogFlow;
  
  public DestinyInfoDialogView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DaggerInjector.fromView(this).inject(this);
  }
  
  private void initView()
  {
    String str = (String)constantsProvider.get(Constants.DESTINY_DIALOG_HEADER_LABEL, getResources().getString(2131165547));
    destinyHeaderLabel.setText(str);
    str = (String)constantsProvider.get(Constants.DESTINY_DIALOG_HEADER_TEXT, getResources().getString(2131165548));
    destinyHeaderText.setText(str);
    str = (String)constantsProvider.get(Constants.DESTINY_DIALOG_SECTION_ONE_LABEL, getResources().getString(2131165549));
    destinySectionOneLabel.setText(str);
    str = (String)constantsProvider.get(Constants.DESTINY_DIALOG_SECTION_ONE_TEXT, getResources().getString(2131165550));
    destinySectionOneText.setText(str);
    str = (String)constantsProvider.get(Constants.DESTINY_DIALOG_SECTION_TWO_LABEL, getResources().getString(2131165551));
    destinySectionTwoLabel.setText(str);
    str = (String)constantsProvider.get(Constants.DESTINY_DIALOG_SECTION_TWO_TEXT, getResources().getString(2131165552));
    destinySectionTwoText.setText(str);
    cancelButton.setOnClickListener(new DestinyInfoDialogView.1(this));
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    ButterKnife.bind(this);
    initView();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.driver.DestinyInfoDialogView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */