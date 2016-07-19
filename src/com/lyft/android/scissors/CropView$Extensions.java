package com.lyft.android.scissors;

public class CropView$Extensions
{
  private final CropView cropView;
  
  CropView$Extensions(CropView paramCropView)
  {
    cropView = paramCropView;
  }
  
  public CropViewExtensions.CropRequest crop()
  {
    return new CropViewExtensions.CropRequest(cropView);
  }
  
  public void load(Object paramObject)
  {
    new CropViewExtensions.LoadRequest(cropView).load(paramObject);
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.scissors.CropView.Extensions
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */