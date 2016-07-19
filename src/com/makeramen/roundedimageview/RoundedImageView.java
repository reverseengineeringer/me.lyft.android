package com.makeramen.roundedimageview;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.ColorFilter;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

public class RoundedImageView
  extends ImageView
{
  public static final Shader.TileMode DEFAULT_TILE_MODE;
  private static final ImageView.ScaleType[] SCALE_TYPES;
  private ColorStateList borderColor = ColorStateList.valueOf(-16777216);
  private float borderWidth = 0.0F;
  private float cornerRadius = 0.0F;
  private boolean isOval = false;
  private Drawable mBackgroundDrawable;
  private ColorFilter mColorFilter = null;
  private boolean mColorMod = false;
  private Drawable mDrawable;
  private boolean mHasColorFilter = false;
  private int mResource;
  private ImageView.ScaleType mScaleType;
  private boolean mutateBackground = false;
  private Shader.TileMode tileModeX = DEFAULT_TILE_MODE;
  private Shader.TileMode tileModeY = DEFAULT_TILE_MODE;
  
  static
  {
    if (!RoundedImageView.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      DEFAULT_TILE_MODE = Shader.TileMode.CLAMP;
      SCALE_TYPES = new ImageView.ScaleType[] { ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE };
      return;
    }
  }
  
  public RoundedImageView(Context paramContext)
  {
    super(paramContext);
  }
  
  public RoundedImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public RoundedImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.RoundedImageView, paramInt, 0);
    paramInt = paramContext.getInt(R.styleable.RoundedImageView_android_scaleType, -1);
    if (paramInt >= 0) {
      setScaleType(SCALE_TYPES[paramInt]);
    }
    for (;;)
    {
      cornerRadius = paramContext.getDimensionPixelSize(R.styleable.RoundedImageView_riv_corner_radius, -1);
      borderWidth = paramContext.getDimensionPixelSize(R.styleable.RoundedImageView_riv_border_width, -1);
      if (cornerRadius < 0.0F) {
        cornerRadius = 0.0F;
      }
      if (borderWidth < 0.0F) {
        borderWidth = 0.0F;
      }
      borderColor = paramContext.getColorStateList(R.styleable.RoundedImageView_riv_border_color);
      if (borderColor == null) {
        borderColor = ColorStateList.valueOf(-16777216);
      }
      mutateBackground = paramContext.getBoolean(R.styleable.RoundedImageView_riv_mutate_background, false);
      isOval = paramContext.getBoolean(R.styleable.RoundedImageView_riv_oval, false);
      paramInt = paramContext.getInt(R.styleable.RoundedImageView_riv_tile_mode, -2);
      if (paramInt != -2)
      {
        setTileModeX(parseTileMode(paramInt));
        setTileModeY(parseTileMode(paramInt));
      }
      paramInt = paramContext.getInt(R.styleable.RoundedImageView_riv_tile_mode_x, -2);
      if (paramInt != -2) {
        setTileModeX(parseTileMode(paramInt));
      }
      paramInt = paramContext.getInt(R.styleable.RoundedImageView_riv_tile_mode_y, -2);
      if (paramInt != -2) {
        setTileModeY(parseTileMode(paramInt));
      }
      updateDrawableAttrs();
      updateBackgroundDrawableAttrs(true);
      paramContext.recycle();
      return;
      setScaleType(ImageView.ScaleType.FIT_CENTER);
    }
  }
  
  private void applyColorMod()
  {
    if ((mDrawable != null) && (mColorMod))
    {
      mDrawable = mDrawable.mutate();
      if (mHasColorFilter) {
        mDrawable.setColorFilter(mColorFilter);
      }
    }
  }
  
  private static Shader.TileMode parseTileMode(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return Shader.TileMode.CLAMP;
    case 1: 
      return Shader.TileMode.REPEAT;
    }
    return Shader.TileMode.MIRROR;
  }
  
  private Drawable resolveResource()
  {
    Resources localResources = getResources();
    if (localResources == null) {
      return null;
    }
    Object localObject3 = null;
    Object localObject1 = localObject3;
    if (mResource != 0) {}
    try
    {
      localObject1 = localResources.getDrawable(mResource);
      return RoundedDrawable.fromDrawable((Drawable)localObject1);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.w("RoundedImageView", "Unable to find resource: " + mResource, localException);
        mResource = 0;
        Object localObject2 = localObject3;
      }
    }
  }
  
  private void updateAttrs(Drawable paramDrawable)
  {
    if (paramDrawable == null) {}
    for (;;)
    {
      return;
      if ((paramDrawable instanceof RoundedDrawable))
      {
        ((RoundedDrawable)paramDrawable).setScaleType(mScaleType).setCornerRadius(cornerRadius).setBorderWidth(borderWidth).setBorderColor(borderColor).setOval(isOval).setTileModeX(tileModeX).setTileModeY(tileModeY);
        applyColorMod();
        return;
      }
      if ((paramDrawable instanceof LayerDrawable))
      {
        paramDrawable = (LayerDrawable)paramDrawable;
        int i = 0;
        int j = paramDrawable.getNumberOfLayers();
        while (i < j)
        {
          updateAttrs(paramDrawable.getDrawable(i));
          i += 1;
        }
      }
    }
  }
  
  private void updateBackgroundDrawableAttrs(boolean paramBoolean)
  {
    if (mutateBackground)
    {
      if (paramBoolean) {
        mBackgroundDrawable = RoundedDrawable.fromDrawable(mBackgroundDrawable);
      }
      updateAttrs(mBackgroundDrawable);
    }
  }
  
  private void updateDrawableAttrs()
  {
    updateAttrs(mDrawable);
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    invalidate();
  }
  
  public int getBorderColor()
  {
    return borderColor.getDefaultColor();
  }
  
  public ColorStateList getBorderColors()
  {
    return borderColor;
  }
  
  public float getBorderWidth()
  {
    return borderWidth;
  }
  
  public float getCornerRadius()
  {
    return cornerRadius;
  }
  
  public ImageView.ScaleType getScaleType()
  {
    return mScaleType;
  }
  
  public Shader.TileMode getTileModeX()
  {
    return tileModeX;
  }
  
  public Shader.TileMode getTileModeY()
  {
    return tileModeY;
  }
  
  public void setBackground(Drawable paramDrawable)
  {
    setBackgroundDrawable(paramDrawable);
  }
  
  @Deprecated
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    mBackgroundDrawable = paramDrawable;
    updateBackgroundDrawableAttrs(true);
    super.setBackgroundDrawable(mBackgroundDrawable);
  }
  
  public void setBorderColor(int paramInt)
  {
    setBorderColor(ColorStateList.valueOf(paramInt));
  }
  
  public void setBorderColor(ColorStateList paramColorStateList)
  {
    if (borderColor.equals(paramColorStateList)) {
      return;
    }
    if (paramColorStateList != null) {}
    for (;;)
    {
      borderColor = paramColorStateList;
      updateDrawableAttrs();
      updateBackgroundDrawableAttrs(false);
      if (borderWidth <= 0.0F) {
        break;
      }
      invalidate();
      return;
      paramColorStateList = ColorStateList.valueOf(-16777216);
    }
  }
  
  public void setBorderWidth(float paramFloat)
  {
    if (borderWidth == paramFloat) {
      return;
    }
    borderWidth = paramFloat;
    updateDrawableAttrs();
    updateBackgroundDrawableAttrs(false);
    invalidate();
  }
  
  public void setBorderWidth(int paramInt)
  {
    setBorderWidth(getResources().getDimension(paramInt));
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    if (mColorFilter != paramColorFilter)
    {
      mColorFilter = paramColorFilter;
      mHasColorFilter = true;
      mColorMod = true;
      applyColorMod();
      invalidate();
    }
  }
  
  public void setCornerRadius(float paramFloat)
  {
    if (cornerRadius == paramFloat) {
      return;
    }
    cornerRadius = paramFloat;
    updateDrawableAttrs();
    updateBackgroundDrawableAttrs(false);
  }
  
  public void setCornerRadiusDimen(int paramInt)
  {
    setCornerRadius(getResources().getDimension(paramInt));
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    mResource = 0;
    mDrawable = RoundedDrawable.fromBitmap(paramBitmap);
    updateDrawableAttrs();
    super.setImageDrawable(mDrawable);
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    mResource = 0;
    mDrawable = RoundedDrawable.fromDrawable(paramDrawable);
    updateDrawableAttrs();
    super.setImageDrawable(mDrawable);
  }
  
  public void setImageResource(int paramInt)
  {
    if (mResource != paramInt)
    {
      mResource = paramInt;
      mDrawable = resolveResource();
      updateDrawableAttrs();
      super.setImageDrawable(mDrawable);
    }
  }
  
  public void setImageURI(Uri paramUri)
  {
    super.setImageURI(paramUri);
    setImageDrawable(getDrawable());
  }
  
  public void setOval(boolean paramBoolean)
  {
    isOval = paramBoolean;
    updateDrawableAttrs();
    updateBackgroundDrawableAttrs(false);
    invalidate();
  }
  
  public void setScaleType(ImageView.ScaleType paramScaleType)
  {
    assert (paramScaleType != null);
    if (mScaleType != paramScaleType)
    {
      mScaleType = paramScaleType;
      switch (paramScaleType)
      {
      default: 
        super.setScaleType(paramScaleType);
      }
    }
    for (;;)
    {
      updateDrawableAttrs();
      updateBackgroundDrawableAttrs(false);
      invalidate();
      return;
      super.setScaleType(ImageView.ScaleType.FIT_XY);
    }
  }
  
  public void setTileModeX(Shader.TileMode paramTileMode)
  {
    if (tileModeX == paramTileMode) {
      return;
    }
    tileModeX = paramTileMode;
    updateDrawableAttrs();
    updateBackgroundDrawableAttrs(false);
    invalidate();
  }
  
  public void setTileModeY(Shader.TileMode paramTileMode)
  {
    if (tileModeY == paramTileMode) {
      return;
    }
    tileModeY = paramTileMode;
    updateDrawableAttrs();
    updateBackgroundDrawableAttrs(false);
    invalidate();
  }
}

/* Location:
 * Qualified Name:     com.makeramen.roundedimageview.RoundedImageView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */