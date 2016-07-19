package com.squareup.picasso;

import android.graphics.Bitmap;

public abstract interface Transformation
{
  public abstract String key();
  
  public abstract Bitmap transform(Bitmap paramBitmap);
}

/* Location:
 * Qualified Name:     com.squareup.picasso.Transformation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */