package com.lyft.android.scissors;

import android.net.Uri;
import android.widget.ImageView;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import com.squareup.picasso.Transformation;
import java.io.File;

public class PicassoBitmapLoader
  implements BitmapLoader
{
  private final Picasso picasso;
  private final Transformation transformation;
  
  public PicassoBitmapLoader(Picasso paramPicasso, Transformation paramTransformation)
  {
    picasso = paramPicasso;
    transformation = paramTransformation;
  }
  
  public static BitmapLoader createUsing(CropView paramCropView)
  {
    return createUsing(paramCropView, Picasso.with(paramCropView.getContext()));
  }
  
  public static BitmapLoader createUsing(CropView paramCropView, Picasso paramPicasso)
  {
    return new PicassoBitmapLoader(paramPicasso, PicassoFillViewportTransformation.createUsing(paramCropView.getViewportWidth(), paramCropView.getViewportHeight()));
  }
  
  public void load(Object paramObject, ImageView paramImageView)
  {
    if (((paramObject instanceof Uri)) || (paramObject == null)) {
      paramObject = picasso.load((Uri)paramObject);
    }
    for (;;)
    {
      ((RequestCreator)paramObject).skipMemoryCache().transform(transformation).into(paramImageView);
      return;
      if ((paramObject instanceof String))
      {
        paramObject = picasso.load((String)paramObject);
      }
      else if ((paramObject instanceof File))
      {
        paramObject = picasso.load((File)paramObject);
      }
      else
      {
        if (!(paramObject instanceof Integer)) {
          break;
        }
        paramObject = picasso.load(((Integer)paramObject).intValue());
      }
    }
    throw new IllegalArgumentException("Unsupported model " + paramObject);
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.scissors.PicassoBitmapLoader
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */