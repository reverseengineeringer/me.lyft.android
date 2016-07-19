package com.appboy.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.appboy.models.cards.ShortNewsCard;
import com.appboy.ui.R.drawable;
import com.appboy.ui.R.id;
import com.appboy.ui.R.layout;
import com.appboy.ui.actions.ActionFactory;
import com.appboy.ui.actions.IAction;
import com.facebook.drawee.view.SimpleDraweeView;

public class ShortNewsCardView
  extends BaseCardView<ShortNewsCard>
{
  private static final String TAG = String.format("%s.%s", new Object[] { "Appboy", ShortNewsCardView.class.getName() });
  private final float mAspectRatio = 1.0F;
  private IAction mCardAction;
  private final TextView mDescription = (TextView)findViewById(R.id.com_appboy_short_news_card_description);
  private final TextView mDomain = (TextView)findViewById(R.id.com_appboy_short_news_card_domain);
  private SimpleDraweeView mDrawee;
  private ImageView mImage;
  private final TextView mTitle = (TextView)findViewById(R.id.com_appboy_short_news_card_title);
  
  public ShortNewsCardView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ShortNewsCardView(Context paramContext, ShortNewsCard paramShortNewsCard)
  {
    super(paramContext);
    if (canUseFresco()) {
      mDrawee = ((SimpleDraweeView)getProperViewFromInflatedStub(R.id.com_appboy_short_news_card_drawee_stub));
    }
    for (;;)
    {
      if (paramShortNewsCard != null) {
        setCard(paramShortNewsCard);
      }
      safeSetBackground(getResources().getDrawable(R.drawable.com_appboy_card_background));
      return;
      mImage = ((ImageView)getProperViewFromInflatedStub(R.id.com_appboy_short_news_card_imageview_stub));
    }
  }
  
  protected int getLayoutResource()
  {
    return R.layout.com_appboy_short_news_card;
  }
  
  public void onSetCard(final ShortNewsCard paramShortNewsCard)
  {
    mDescription.setText(paramShortNewsCard.getDescription());
    setOptionalTextView(mTitle, paramShortNewsCard.getTitle());
    setOptionalTextView(mDomain, paramShortNewsCard.getDomain());
    mCardAction = ActionFactory.createUriAction(getContext(), paramShortNewsCard.getUrl());
    setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        BaseCardView.handleCardClick(mContext, paramShortNewsCard, mCardAction, ShortNewsCardView.TAG);
      }
    });
    if (canUseFresco())
    {
      setSimpleDraweeToUrl(mDrawee, paramShortNewsCard.getImageUrl(), 1.0F, true);
      return;
    }
    setImageViewToUrl(mImage, paramShortNewsCard.getImageUrl(), 1.0F);
  }
}

/* Location:
 * Qualified Name:     com.appboy.ui.widget.ShortNewsCardView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */