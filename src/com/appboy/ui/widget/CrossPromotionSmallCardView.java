package com.appboy.ui.widget;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.appboy.models.cards.CrossPromotionSmallCard;
import com.appboy.support.StringUtils;
import com.appboy.ui.R.id;
import com.appboy.ui.R.layout;
import com.appboy.ui.R.string;
import com.appboy.ui.actions.GooglePlayAppDetailsAction;
import com.appboy.ui.actions.IAction;
import com.facebook.drawee.view.SimpleDraweeView;
import java.text.NumberFormat;
import java.util.Locale;

public class CrossPromotionSmallCardView
  extends BaseCardView<CrossPromotionSmallCard>
{
  private static final String TAG = String.format("%s.%s", new Object[] { "Appboy", CrossPromotionSmallCardView.class.getName() });
  private final float mAspectRatio = 1.0F;
  private final TextView mCaption = (TextView)findViewById(R.id.com_appboy_cross_promotion_small_card_recommendation_tab);
  private SimpleDraweeView mDrawee;
  private ImageView mImage;
  private final Button mPrice = (Button)findViewById(R.id.com_appboy_cross_promotion_small_card_price);
  private IAction mPriceAction;
  private final TextView mReviewCount = (TextView)findViewById(R.id.com_appboy_cross_promotion_small_card_review_count);
  private final StarRatingView mStarRating = (StarRatingView)findViewById(R.id.com_appboy_cross_promotion_small_card_star_rating);
  private final TextView mSubtitle = (TextView)findViewById(R.id.com_appboy_cross_promotion_small_card_subtitle);
  private final TextView mTitle = (TextView)findViewById(R.id.com_appboy_cross_promotion_small_card_title);
  
  public CrossPromotionSmallCardView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public CrossPromotionSmallCardView(Context paramContext, CrossPromotionSmallCard paramCrossPromotionSmallCard)
  {
    super(paramContext);
    if (canUseFresco()) {
      mDrawee = ((SimpleDraweeView)getProperViewFromInflatedStub(R.id.com_appboy_cross_promotion_small_card_drawee_stub));
    }
    for (;;)
    {
      if (paramCrossPromotionSmallCard != null) {
        setCard(paramCrossPromotionSmallCard);
      }
      return;
      mImage = ((ImageView)getProperViewFromInflatedStub(R.id.com_appboy_cross_promotion_small_card_imageview_stub));
    }
  }
  
  private String getPriceString(double paramDouble)
  {
    if (paramDouble == 0.0D) {
      return mContext.getString(R.string.com_appboy_recommendation_free);
    }
    return NumberFormat.getCurrencyInstance(Locale.US).format(paramDouble);
  }
  
  protected int getLayoutResource()
  {
    return R.layout.com_appboy_cross_promotion_small_card;
  }
  
  public void onSetCard(final CrossPromotionSmallCard paramCrossPromotionSmallCard)
  {
    mTitle.setText(paramCrossPromotionSmallCard.getTitle());
    if ((paramCrossPromotionSmallCard.getSubtitle() == null) || (paramCrossPromotionSmallCard.getSubtitle().toUpperCase(Locale.getDefault()).equals("NULL")))
    {
      mSubtitle.setVisibility(8);
      mCaption.setText(paramCrossPromotionSmallCard.getCaption().toUpperCase(Locale.getDefault()));
      if (paramCrossPromotionSmallCard.getRating() > 0.0D) {
        break label192;
      }
      mReviewCount.setVisibility(8);
      mStarRating.setVisibility(8);
      label89:
      if (StringUtils.isNullOrBlank(paramCrossPromotionSmallCard.getDisplayPrice())) {
        break label238;
      }
      mPrice.setText(paramCrossPromotionSmallCard.getDisplayPrice());
    }
    for (;;)
    {
      mPriceAction = new GooglePlayAppDetailsAction(paramCrossPromotionSmallCard.getPackage(), false, paramCrossPromotionSmallCard.getAppStore(), paramCrossPromotionSmallCard.getKindleId());
      mPrice.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          BaseCardView.handleCardClick(mContext, paramCrossPromotionSmallCard, mPriceAction, CrossPromotionSmallCardView.TAG);
        }
      });
      if (!canUseFresco()) {
        break label256;
      }
      setSimpleDraweeToUrl(mDrawee, paramCrossPromotionSmallCard.getImageUrl(), 1.0F, true);
      return;
      mSubtitle.setText(paramCrossPromotionSmallCard.getSubtitle().toUpperCase(Locale.getDefault()));
      break;
      label192:
      mReviewCount.setText(String.format("(%s)", new Object[] { NumberFormat.getInstance().format(paramCrossPromotionSmallCard.getReviewCount()) }));
      mStarRating.setRating((float)paramCrossPromotionSmallCard.getRating());
      break label89;
      label238:
      mPrice.setText(getPriceString(paramCrossPromotionSmallCard.getPrice()));
    }
    label256:
    setImageViewToUrl(mImage, paramCrossPromotionSmallCard.getImageUrl(), 1.0F);
  }
}

/* Location:
 * Qualified Name:     com.appboy.ui.widget.CrossPromotionSmallCardView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */