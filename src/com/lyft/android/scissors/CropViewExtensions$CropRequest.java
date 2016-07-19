package com.lyft.android.scissors;

import android.graphics.Bitmap.CompressFormat;
import java.io.File;
import java.util.concurrent.Future;

public class CropViewExtensions$CropRequest
{
  private final CropView cropView;
  private Bitmap.CompressFormat format = Bitmap.CompressFormat.JPEG;
  private int quality = 100;
  
  CropViewExtensions$CropRequest(CropView paramCropView)
  {
    Utils.checkNotNull(paramCropView, "cropView == null");
    cropView = paramCropView;
  }
  
  public CropRequest format(Bitmap.CompressFormat paramCompressFormat)
  {
    Utils.checkNotNull(paramCompressFormat, "format == null");
    format = paramCompressFormat;
    return this;
  }
  
  public Future<Void> into(File paramFile)
  {
    return Utils.flushToFile(cropView.crop(), format, quality, paramFile);
  }
  
  public CropRequest quality(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= 100)) {}
    for (boolean bool = true;; bool = false)
    {
      Utils.checkArg(bool, "quality must be 0..100");
      quality = paramInt;
      return this;
    }
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.scissors.CropViewExtensions.CropRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */