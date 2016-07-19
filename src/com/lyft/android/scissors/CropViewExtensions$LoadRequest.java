package com.lyft.android.scissors;

public class CropViewExtensions$LoadRequest
{
  private BitmapLoader bitmapLoader;
  private final CropView cropView;
  
  CropViewExtensions$LoadRequest(CropView paramCropView)
  {
    Utils.checkNotNull(paramCropView, "cropView == null");
    cropView = paramCropView;
  }
  
  public void load(Object paramObject)
  {
    if (bitmapLoader == null) {
      bitmapLoader = CropViewExtensions.resolveBitmapLoader(cropView);
    }
    bitmapLoader.load(paramObject, cropView);
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.scissors.CropViewExtensions.LoadRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */