package me.lyft.android.ui.driver.achievements.card;

import android.content.Context;
import android.content.res.Resources;
import android.widget.Button;
import javax.inject.Inject;
import me.lyft.android.application.driver.expresspay.IExpressPayService;
import me.lyft.android.common.AppFlow;
import me.lyft.android.ui.IProgressController;
import me.lyft.android.ui.driver.expresspay.IExpressPayErrorHandler;

public class ExpressPayAchievementCard
  extends LightAchievementCardView
{
  @Inject
  AppFlow appFlow;
  private final String buttonText;
  @Inject
  IExpressPayErrorHandler expressPayErrorHandler;
  @Inject
  IExpressPayService expressPayService;
  Button getPaidButton;
  @Inject
  IProgressController progressController;
  
  public ExpressPayAchievementCard(Context paramContext, String paramString)
  {
    super(paramContext);
    buttonText = paramString;
  }
  
  protected int getLayout()
  {
    return 2130903226;
  }
  
  int getSubtitleColor()
  {
    return getResources().getColor(2131492898);
  }
  
  int getTitleColor()
  {
    return getResources().getColor(2131492898);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    getPaidButton.setText(buttonText);
    getPaidButton.setOnClickListener(new ExpressPayAchievementCard.1(this));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.driver.achievements.card.ExpressPayAchievementCard
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */