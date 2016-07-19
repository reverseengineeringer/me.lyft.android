package com.appboy.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.appboy.models.cards.BannerImageCard;
import com.appboy.support.AppboyLogger;
import com.appboy.ui.R.drawable;
import com.appboy.ui.R.id;
import com.appboy.ui.R.layout;
import com.appboy.ui.actions.ActionFactory;
import com.appboy.ui.actions.IAction;
import com.facebook.drawee.view.SimpleDraweeView;

public class BannerImageCardView
  extends BaseCardView<BannerImageCard>
{
  private static final String TAG = String.format("%s.%s", new Object[] { "Appboy", BannerImageCardView.class.getName() });
  private float mAspectRatio = 6.0F;
  private IAction mCardAction;
  private SimpleDraweeView mDrawee;
  private ImageView mImage;
  
  public BannerImageCardView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public BannerImageCardView(Context paramContext, BannerImageCard paramBannerImageCard)
  {
    super(paramContext);
    if (canUseFresco()) {
      mDrawee = ((SimpleDraweeView)getProperViewFromInflatedStub(R.id.com_appboy_banner_image_card_drawee_stub));
    }
    for (;;)
    {
      if (paramBannerImageCard != null) {
        setCard(paramBannerImageCard);
      }
      safeSetBackground(getResources().getDrawable(R.drawable.com_appboy_card_background));
      return;
      mImage = ((ImageView)getProperViewFromInflatedStub(R.id.com_appboy_banner_image_card_imageview_stub));
      mImage.setScaleType(ImageView.ScaleType.CENTER_CROP);
      mImage.setAdjustViewBounds(true);
    }
  }
  
  protected int getLayoutResource()
  {
    return R.layout.com_appboy_banner_image_card;
  }
  
  public void onSetCard(final BannerImageCard paramBannerImageCard)
  {
    boolean bool = false;
    if (paramBannerImageCard.getAspectRatio() != 0.0F)
    {
      mAspectRatio = paramBannerImageCard.getAspectRatio();
      bool = true;
    }
    if (canUseFresco()) {
      setSimpleDraweeToUrl(mDrawee, paramBannerImageCard.getImageUrl(), mAspectRatio, bool);
    }
    for (;;)
    {
      mCardAction = ActionFactory.createUriAction(getContext(), paramBannerImageCard.getUrl());
      setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          if (mCardAction != null)
          {
            AppboyLogger.d(BannerImageCardView.TAG, String.format("Logged click for card %s", new Object[] { paramBannerImageCard.getId() }));
            paramBannerImageCard.logClick();
            mCardAction.execute(mContext);
          }
        }
      });
      return;
      setImageViewToUrl(mImage, paramBannerImageCard.getImageUrl(), mAspectRatio, bool);
    }
  }
}

/* Location:
 * Qualified Name:     com.appboy.ui.widget.BannerImageCardView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */