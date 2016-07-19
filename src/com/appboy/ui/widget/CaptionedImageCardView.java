package com.appboy.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.appboy.models.cards.CaptionedImageCard;
import com.appboy.ui.R.drawable;
import com.appboy.ui.R.id;
import com.appboy.ui.R.layout;
import com.appboy.ui.actions.ActionFactory;
import com.appboy.ui.actions.IAction;
import com.facebook.drawee.view.SimpleDraweeView;

public class CaptionedImageCardView
  extends BaseCardView<CaptionedImageCard>
{
  private static final String TAG = String.format("%s.%s", new Object[] { "Appboy", CaptionedImageCardView.class.getName() });
  private float mAspectRatio = 1.3333334F;
  private IAction mCardAction;
  private final TextView mDescription;
  private final TextView mDomain;
  private SimpleDraweeView mDrawee;
  private ImageView mImage;
  private final TextView mTitle;
  
  public CaptionedImageCardView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public CaptionedImageCardView(Context paramContext, CaptionedImageCard paramCaptionedImageCard)
  {
    super(paramContext);
    if (canUseFresco()) {
      mDrawee = ((SimpleDraweeView)getProperViewFromInflatedStub(R.id.com_appboy_captioned_image_card_drawee_stub));
    }
    for (;;)
    {
      mTitle = ((TextView)findViewById(R.id.com_appboy_captioned_image_title));
      mDescription = ((TextView)findViewById(R.id.com_appboy_captioned_image_description));
      mDomain = ((TextView)findViewById(R.id.com_appboy_captioned_image_card_domain));
      if (paramCaptionedImageCard != null) {
        setCard(paramCaptionedImageCard);
      }
      safeSetBackground(getResources().getDrawable(R.drawable.com_appboy_card_background));
      return;
      mImage = ((ImageView)getProperViewFromInflatedStub(R.id.com_appboy_captioned_image_card_imageview_stub));
      mImage.setScaleType(ImageView.ScaleType.CENTER_CROP);
      mImage.setAdjustViewBounds(true);
    }
  }
  
  protected int getLayoutResource()
  {
    return R.layout.com_appboy_captioned_image_card;
  }
  
  public void onSetCard(final CaptionedImageCard paramCaptionedImageCard)
  {
    mTitle.setText(paramCaptionedImageCard.getTitle());
    mDescription.setText(paramCaptionedImageCard.getDescription());
    setOptionalTextView(mDomain, paramCaptionedImageCard.getDomain());
    mCardAction = ActionFactory.createUriAction(getContext(), paramCaptionedImageCard.getUrl());
    boolean bool = false;
    if (paramCaptionedImageCard.getAspectRatio() != 0.0F)
    {
      mAspectRatio = paramCaptionedImageCard.getAspectRatio();
      bool = true;
    }
    setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        BaseCardView.handleCardClick(mContext, paramCaptionedImageCard, mCardAction, CaptionedImageCardView.TAG);
      }
    });
    if (canUseFresco())
    {
      setSimpleDraweeToUrl(mDrawee, paramCaptionedImageCard.getImageUrl(), mAspectRatio, bool);
      return;
    }
    setImageViewToUrl(mImage, paramCaptionedImageCard.getImageUrl(), mAspectRatio, bool);
  }
}

/* Location:
 * Qualified Name:     com.appboy.ui.widget.CaptionedImageCardView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */