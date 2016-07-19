package com.facebook.login.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.facebook.FacebookException;
import com.facebook.LoggingBehavior;
import com.facebook.R.dimen;
import com.facebook.R.drawable;
import com.facebook.R.styleable;
import com.facebook.internal.ImageDownloader;
import com.facebook.internal.ImageRequest;
import com.facebook.internal.ImageRequest.Builder;
import com.facebook.internal.ImageRequest.Callback;
import com.facebook.internal.ImageResponse;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;

public class ProfilePictureView
  extends FrameLayout
{
  private static final String BITMAP_HEIGHT_KEY = "ProfilePictureView_height";
  private static final String BITMAP_KEY = "ProfilePictureView_bitmap";
  private static final String BITMAP_WIDTH_KEY = "ProfilePictureView_width";
  public static final int CUSTOM = -1;
  private static final boolean IS_CROPPED_DEFAULT_VALUE = true;
  private static final String IS_CROPPED_KEY = "ProfilePictureView_isCropped";
  public static final int LARGE = -4;
  private static final int MIN_SIZE = 1;
  public static final int NORMAL = -3;
  private static final String PENDING_REFRESH_KEY = "ProfilePictureView_refresh";
  private static final String PRESET_SIZE_KEY = "ProfilePictureView_presetSize";
  private static final String PROFILE_ID_KEY = "ProfilePictureView_profileId";
  public static final int SMALL = -2;
  private static final String SUPER_STATE_KEY = "ProfilePictureView_superState";
  public static final String TAG = ProfilePictureView.class.getSimpleName();
  private Bitmap customizedDefaultProfilePicture = null;
  private ImageView image;
  private Bitmap imageContents;
  private boolean isCropped = true;
  private ImageRequest lastRequest;
  private OnErrorListener onErrorListener;
  private int presetSizeType = -1;
  private String profileId;
  private int queryHeight = 0;
  private int queryWidth = 0;
  
  public ProfilePictureView(Context paramContext)
  {
    super(paramContext);
    initialize(paramContext);
  }
  
  public ProfilePictureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initialize(paramContext);
    parseAttributes(paramAttributeSet);
  }
  
  public ProfilePictureView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initialize(paramContext);
    parseAttributes(paramAttributeSet);
  }
  
  private int getPresetSizeInPixels(boolean paramBoolean)
  {
    int i;
    switch (presetSizeType)
    {
    default: 
      return 0;
    case -2: 
      i = R.dimen.com_facebook_profilepictureview_preset_size_small;
    }
    for (;;)
    {
      return getResources().getDimensionPixelSize(i);
      i = R.dimen.com_facebook_profilepictureview_preset_size_normal;
      continue;
      i = R.dimen.com_facebook_profilepictureview_preset_size_large;
      continue;
      if (!paramBoolean) {
        break;
      }
      i = R.dimen.com_facebook_profilepictureview_preset_size_normal;
    }
  }
  
  private void initialize(Context paramContext)
  {
    removeAllViews();
    image = new ImageView(paramContext);
    paramContext = new FrameLayout.LayoutParams(-1, -1);
    image.setLayoutParams(paramContext);
    image.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    addView(image);
  }
  
  private void parseAttributes(AttributeSet paramAttributeSet)
  {
    paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.com_facebook_profile_picture_view);
    setPresetSize(paramAttributeSet.getInt(R.styleable.com_facebook_profile_picture_view_com_facebook_preset_size, -1));
    isCropped = paramAttributeSet.getBoolean(R.styleable.com_facebook_profile_picture_view_com_facebook_is_cropped, true);
    paramAttributeSet.recycle();
  }
  
  private void processResponse(ImageResponse paramImageResponse)
  {
    Bitmap localBitmap;
    Exception localException;
    if (paramImageResponse.getRequest() == lastRequest)
    {
      lastRequest = null;
      localBitmap = paramImageResponse.getBitmap();
      localException = paramImageResponse.getError();
      if (localException == null) {
        break label92;
      }
      paramImageResponse = onErrorListener;
      if (paramImageResponse == null) {
        break label76;
      }
      paramImageResponse.onError(new FacebookException("Error in downloading profile picture for profileId: " + getProfileId(), localException));
    }
    label76:
    label92:
    do
    {
      do
      {
        return;
        Logger.log(LoggingBehavior.REQUESTS, 6, TAG, localException.toString());
        return;
      } while (localBitmap == null);
      setImageBitmap(localBitmap);
    } while (!paramImageResponse.isCachedRedirect());
    sendImageRequest(false);
  }
  
  private void refreshImage(boolean paramBoolean)
  {
    boolean bool = updateImageQueryParameters();
    if ((profileId == null) || (profileId.length() == 0) || ((queryWidth == 0) && (queryHeight == 0))) {
      setBlankProfilePicture();
    }
    while ((!bool) && (!paramBoolean)) {
      return;
    }
    sendImageRequest(true);
  }
  
  private void sendImageRequest(boolean paramBoolean)
  {
    ImageRequest localImageRequest = new ImageRequest.Builder(getContext(), ImageRequest.getProfilePictureUri(profileId, queryWidth, queryHeight)).setAllowCachedRedirects(paramBoolean).setCallerTag(this).setCallback(new ImageRequest.Callback()
    {
      public void onCompleted(ImageResponse paramAnonymousImageResponse)
      {
        ProfilePictureView.this.processResponse(paramAnonymousImageResponse);
      }
    }).build();
    if (lastRequest != null) {
      ImageDownloader.cancelRequest(lastRequest);
    }
    lastRequest = localImageRequest;
    ImageDownloader.downloadAsync(localImageRequest);
  }
  
  private void setBlankProfilePicture()
  {
    if (lastRequest != null) {
      ImageDownloader.cancelRequest(lastRequest);
    }
    if (customizedDefaultProfilePicture == null)
    {
      if (isCropped()) {}
      for (int i = R.drawable.com_facebook_profile_picture_blank_square;; i = R.drawable.com_facebook_profile_picture_blank_portrait)
      {
        setImageBitmap(BitmapFactory.decodeResource(getResources(), i));
        return;
      }
    }
    updateImageQueryParameters();
    setImageBitmap(Bitmap.createScaledBitmap(customizedDefaultProfilePicture, queryWidth, queryHeight, false));
  }
  
  private void setImageBitmap(Bitmap paramBitmap)
  {
    if ((image != null) && (paramBitmap != null))
    {
      imageContents = paramBitmap;
      image.setImageBitmap(paramBitmap);
    }
  }
  
  private boolean updateImageQueryParameters()
  {
    boolean bool2 = true;
    int i = getHeight();
    int j = getWidth();
    if ((j < 1) || (i < 1)) {
      return false;
    }
    int k = getPresetSizeInPixels(false);
    if (k != 0)
    {
      j = k;
      i = k;
    }
    if (j <= i) {
      if (isCropped())
      {
        i = j;
        bool1 = bool2;
        if (j == queryWidth) {
          if (i == queryHeight) {
            break label112;
          }
        }
      }
    }
    label112:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      queryWidth = j;
      queryHeight = i;
      return bool1;
      i = 0;
      break;
      if (isCropped()) {}
      for (j = i;; j = 0) {
        break;
      }
    }
  }
  
  public final OnErrorListener getOnErrorListener()
  {
    return onErrorListener;
  }
  
  public final int getPresetSize()
  {
    return presetSizeType;
  }
  
  public final String getProfileId()
  {
    return profileId;
  }
  
  public final boolean isCropped()
  {
    return isCropped;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    lastRequest = null;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    refreshImage(false);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
    int m = 0;
    int n = View.MeasureSpec.getSize(paramInt2);
    int i1 = View.MeasureSpec.getSize(paramInt1);
    int i = m;
    int k = n;
    int j = paramInt2;
    if (View.MeasureSpec.getMode(paramInt2) != 1073741824)
    {
      i = m;
      k = n;
      j = paramInt2;
      if (height == -2)
      {
        k = getPresetSizeInPixels(true);
        j = View.MeasureSpec.makeMeasureSpec(k, 1073741824);
        i = 1;
      }
    }
    n = i;
    m = i1;
    paramInt2 = paramInt1;
    if (View.MeasureSpec.getMode(paramInt1) != 1073741824)
    {
      n = i;
      m = i1;
      paramInt2 = paramInt1;
      if (width == -2)
      {
        m = getPresetSizeInPixels(true);
        paramInt2 = View.MeasureSpec.makeMeasureSpec(m, 1073741824);
        n = 1;
      }
    }
    if (n != 0)
    {
      setMeasuredDimension(m, k);
      measureChildren(paramInt2, j);
      return;
    }
    super.onMeasure(paramInt2, j);
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (paramParcelable.getClass() != Bundle.class) {
      super.onRestoreInstanceState(paramParcelable);
    }
    do
    {
      return;
      paramParcelable = (Bundle)paramParcelable;
      super.onRestoreInstanceState(paramParcelable.getParcelable("ProfilePictureView_superState"));
      profileId = paramParcelable.getString("ProfilePictureView_profileId");
      presetSizeType = paramParcelable.getInt("ProfilePictureView_presetSize");
      isCropped = paramParcelable.getBoolean("ProfilePictureView_isCropped");
      queryWidth = paramParcelable.getInt("ProfilePictureView_width");
      queryHeight = paramParcelable.getInt("ProfilePictureView_height");
      setImageBitmap((Bitmap)paramParcelable.getParcelable("ProfilePictureView_bitmap"));
    } while (!paramParcelable.getBoolean("ProfilePictureView_refresh"));
    refreshImage(true);
  }
  
  protected Parcelable onSaveInstanceState()
  {
    Parcelable localParcelable = super.onSaveInstanceState();
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("ProfilePictureView_superState", localParcelable);
    localBundle.putString("ProfilePictureView_profileId", profileId);
    localBundle.putInt("ProfilePictureView_presetSize", presetSizeType);
    localBundle.putBoolean("ProfilePictureView_isCropped", isCropped);
    localBundle.putParcelable("ProfilePictureView_bitmap", imageContents);
    localBundle.putInt("ProfilePictureView_width", queryWidth);
    localBundle.putInt("ProfilePictureView_height", queryHeight);
    if (lastRequest != null) {}
    for (boolean bool = true;; bool = false)
    {
      localBundle.putBoolean("ProfilePictureView_refresh", bool);
      return localBundle;
    }
  }
  
  public final void setCropped(boolean paramBoolean)
  {
    isCropped = paramBoolean;
    refreshImage(false);
  }
  
  public final void setDefaultProfilePicture(Bitmap paramBitmap)
  {
    customizedDefaultProfilePicture = paramBitmap;
  }
  
  public final void setOnErrorListener(OnErrorListener paramOnErrorListener)
  {
    onErrorListener = paramOnErrorListener;
  }
  
  public final void setPresetSize(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("Must use a predefined preset size");
    }
    presetSizeType = paramInt;
    requestLayout();
  }
  
  public final void setProfileId(String paramString)
  {
    boolean bool = false;
    if ((Utility.isNullOrEmpty(profileId)) || (!profileId.equalsIgnoreCase(paramString)))
    {
      setBlankProfilePicture();
      bool = true;
    }
    profileId = paramString;
    refreshImage(bool);
  }
  
  public static abstract interface OnErrorListener
  {
    public abstract void onError(FacebookException paramFacebookException);
  }
}

/* Location:
 * Qualified Name:     com.facebook.login.widget.ProfilePictureView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */