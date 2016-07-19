package com.appboy.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.appboy.Constants;
import com.appboy.support.AppboyLogger;
import com.appboy.ui.R.drawable;
import java.util.ArrayList;
import java.util.List;

public class StarRatingView
  extends LinearLayout
{
  private static final int MAX_NUMBER_OF_STARS = 5;
  private static final String TAG = String.format("%s.%s", new Object[] { Constants.APPBOY_LOG_TAG_PREFIX, StarRatingView.class.getName() });
  private float mRating = 0.0F;
  private List<ImageView> mStarRating;
  
  public StarRatingView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setOrientation(0);
    mStarRating = new ArrayList(5);
    int i = 0;
    while (i < 5)
    {
      paramAttributeSet = new ImageView(paramContext);
      paramAttributeSet.setTag(Integer.valueOf(0));
      addView(paramAttributeSet, new ViewGroup.LayoutParams(-2, -2));
      mStarRating.add(paramAttributeSet);
      i += 1;
    }
    setRating(mRating);
  }
  
  List<ImageView> getImageViewList()
  {
    return mStarRating;
  }
  
  public float getRating()
  {
    return mRating;
  }
  
  public boolean setRating(float paramFloat)
  {
    boolean bool = true;
    if ((paramFloat < 0.0F) || (paramFloat > 5.0F))
    {
      AppboyLogger.e(TAG, String.format("Unable to set rating to %f. Rating must be between 0 and %d", new Object[] { Float.valueOf(paramFloat), Integer.valueOf(5) }));
      bool = false;
    }
    int k;
    do
    {
      return bool;
      mRating = paramFloat;
      k = (int)Math.floor(mRating);
      int j = (int)Math.ceil(mRating);
      int i = 0;
      while (i < k)
      {
        localImageView = (ImageView)mStarRating.get(i);
        localImageView.setTag(Integer.valueOf(R.drawable.com_appboy_rating_full_star));
        localImageView.setImageResource(R.drawable.com_appboy_rating_full_star);
        i += 1;
      }
      i = j;
      while (i < mStarRating.size())
      {
        localImageView = (ImageView)mStarRating.get(i);
        localImageView.setTag(Integer.valueOf(R.drawable.com_appboy_rating_empty_star));
        localImageView.setImageResource(R.drawable.com_appboy_rating_empty_star);
        i += 1;
      }
      paramFloat -= k;
    } while (paramFloat <= 0.0F);
    ImageView localImageView = (ImageView)mStarRating.get(k);
    if (paramFloat < 0.25F)
    {
      localImageView.setTag(Integer.valueOf(R.drawable.com_appboy_rating_empty_star));
      localImageView.setImageResource(R.drawable.com_appboy_rating_empty_star);
      return true;
    }
    if (paramFloat < 0.75F)
    {
      localImageView.setTag(Integer.valueOf(R.drawable.com_appboy_rating_half_star));
      localImageView.setImageResource(R.drawable.com_appboy_rating_half_star);
      return true;
    }
    localImageView.setTag(Integer.valueOf(R.drawable.com_appboy_rating_full_star));
    localImageView.setImageResource(R.drawable.com_appboy_rating_full_star);
    return true;
  }
}

/* Location:
 * Qualified Name:     com.appboy.ui.widget.StarRatingView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */