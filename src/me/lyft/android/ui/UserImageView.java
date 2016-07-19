package me.lyft.android.ui;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.lyft.scoop.Scoop;
import com.lyft.scoop.dagger.DaggerInjector;
import com.squareup.picasso.RequestCreator;
import javax.inject.Inject;
import me.lyft.android.R.styleable;
import me.lyft.android.common.Objects;
import me.lyft.android.managers.ImageLoader;

public class UserImageView
  extends FrameLayout
{
  @Inject
  ImageLoader imageLoader;
  TextView partySizeTextView;
  ImageView userImageView;
  
  public UserImageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public UserImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.UserImageView);
    boolean bool = paramContext.getBoolean(0, false);
    paramContext.recycle();
    initialize(bool);
  }
  
  private RequestCreator buildPhotoRequestCreator(String paramString)
  {
    return imageLoader.load(paramString).fit().centerInside();
  }
  
  private void initialize(boolean paramBoolean)
  {
    DaggerInjector.fromView(this).inject(this);
    Scoop.fromView(this).inflater(getContext()).inflate(2130903493, this, true);
    ButterKnife.bind(this, this);
    if (paramBoolean)
    {
      setPartyIndicatorDrawable(2130838294);
      setPartyTextSize(2131230729);
    }
  }
  
  public void alignPartySizeCenter(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.setMargins(paramInt1, paramInt2, paramInt3, paramInt4);
    gravity = 81;
    partySizeTextView.setLayoutParams(localLayoutParams);
  }
  
  public void loadPhoto(String paramString)
  {
    buildPhotoRequestCreator(paramString).into(userImageView);
  }
  
  public void loadRoundPhoto(String paramString)
  {
    userImageView.setBackgroundResource(0);
    if (paramString != null)
    {
      buildPhotoRequestCreator(paramString).transform(new CircleTransform()).into(userImageView);
      return;
    }
    imageLoader.load(2130838447).fit().centerInside().transform(new CircleTransform()).into(userImageView);
  }
  
  public void setBackgroundResource(int paramInt)
  {
    userImageView.setBackgroundResource(paramInt);
  }
  
  protected void setPartyIndicatorBackground(int paramInt)
  {
    partySizeTextView.setBackgroundResource(paramInt);
  }
  
  protected void setPartyIndicatorDrawable(int paramInt)
  {
    partySizeTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, paramInt, 0);
  }
  
  protected void setPartyTextSize(int paramInt)
  {
    partySizeTextView.setTextSize(0, getResources().getDimension(paramInt));
  }
  
  public void setUserPartySize(Integer paramInteger)
  {
    boolean bool = true;
    paramInteger = (Integer)Objects.firstNonNull(paramInteger, Integer.valueOf(0));
    if (paramInteger.intValue() > 1) {}
    for (;;)
    {
      showPartyIndicator(bool);
      partySizeTextView.setText(Integer.toString(paramInteger.intValue()));
      return;
      bool = false;
    }
  }
  
  protected void showPartyIndicator(boolean paramBoolean)
  {
    TextView localTextView = partySizeTextView;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localTextView.setVisibility(i);
      return;
    }
  }
  
  public void themeWhite()
  {
    partySizeTextView.setBackgroundColor(getResources().getColor(2131493067));
    partySizeTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, ContextCompat.getDrawable(getContext(), 2130838293), null);
    partySizeTextView.setTextColor(getResources().getColor(2131493083));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.UserImageView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */