package com.appboy.ui.widget;

import android.content.Context;
import com.appboy.Constants;
import com.appboy.models.cards.Card;
import com.appboy.support.AppboyLogger;
import com.appboy.ui.R.layout;

public class DefaultCardView
  extends BaseCardView<Card>
{
  private static final String TAG = String.format("%s.%s", new Object[] { Constants.APPBOY_LOG_TAG_PREFIX, DefaultCardView.class.getName() });
  
  public DefaultCardView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public DefaultCardView(Context paramContext, Card paramCard)
  {
    super(paramContext);
    if (paramCard != null) {
      setCard(paramCard);
    }
  }
  
  protected int getLayoutResource()
  {
    return R.layout.com_appboy_default_card;
  }
  
  public void onSetCard(Card paramCard)
  {
    AppboyLogger.w(TAG, "onSetCard called for blank view with: " + paramCard.toString());
  }
}

/* Location:
 * Qualified Name:     com.appboy.ui.widget.DefaultCardView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */