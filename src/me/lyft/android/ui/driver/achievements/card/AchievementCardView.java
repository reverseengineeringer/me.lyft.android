package me.lyft.android.ui.driver.achievements.card;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.lyft.scoop.Scoop;
import com.lyft.scoop.dagger.DaggerInjector;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import me.lyft.android.domain.driver.Dial;
import me.lyft.android.rx.Binder;
import me.lyft.android.ui.driver.achievements.dials.DialView;
import me.lyft.android.utils.WebBrowser;

public abstract class AchievementCardView
  extends FrameLayout
{
  Binder binder;
  CardView cardView;
  List<Dial> dials;
  LinearLayout dialsLayoutView;
  ImageView infoImageView;
  TextView subtitleTextView;
  TextView titleTextView;
  @Inject
  WebBrowser webBrowser;
  
  public AchievementCardView(Context paramContext)
  {
    super(paramContext);
    initialize();
  }
  
  public AchievementCardView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initialize();
  }
  
  private void initialize()
  {
    DaggerInjector.fromView(this).inject(this);
    Scoop.fromView(this).inflater(getContext()).inflate(getLayout(), this, true);
    ButterKnife.bind(this);
    cardView.setCardBackgroundColor(getBackgroundColor());
    titleTextView.setTextColor(getTitleColor());
    subtitleTextView.setTextColor(getSubtitleColor());
    infoImageView.setImageDrawable(getInfoIcon());
  }
  
  abstract int getBackgroundColor();
  
  abstract int getBackgroundDialColor();
  
  abstract int getDialColor();
  
  abstract Drawable getGoalMetIcon();
  
  public int getGradientEndColor()
  {
    return -1;
  }
  
  public int getGradientStartColor()
  {
    return -1;
  }
  
  abstract Drawable getInfoIcon();
  
  protected int getLayout()
  {
    return 2130903041;
  }
  
  abstract int getSubtitleColor();
  
  abstract int getTitleColor();
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    binder = Binder.attach(this);
  }
  
  void openDriverStatsWebPage(String paramString)
  {
    webBrowser.open(paramString);
  }
  
  public void setDials(List<Dial> paramList)
  {
    dials = paramList;
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      DialView localDialView = DialView.create((Dial)paramList.next(), getContext());
      localDialView.setProgressTextColor(getTitleColor());
      localDialView.setTitleTextColor(getTitleColor());
      localDialView.setSubtitleTextColor(getSubtitleColor());
      localDialView.setProgressColor(getDialColor());
      localDialView.setBackgroundProgressColor(getBackgroundDialColor());
      localDialView.setGradientProgressColors(getGradientStartColor(), getGradientEndColor());
      localDialView.setGoalMetIcon(getGoalMetIcon());
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, -1, 1.0F);
      gravity = 1;
      localDialView.setLayoutParams(localLayoutParams);
      dialsLayoutView.addView(localDialView);
    }
  }
  
  public void setInfoUrl(String paramString)
  {
    infoImageView.setOnClickListener(new AchievementCardView.1(this, paramString));
  }
  
  public void setSubtitle(String paramString)
  {
    subtitleTextView.setVisibility(0);
    subtitleTextView.setText(paramString);
  }
  
  public void setTitle(String paramString)
  {
    titleTextView.setText(paramString);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.driver.achievements.card.AchievementCardView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */