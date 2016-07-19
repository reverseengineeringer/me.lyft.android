package com.lyft.android.scissors;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;

public class CropView
  extends ImageView
{
  private static final int MAX_TOUCH_POINTS = 2;
  private Bitmap bitmap;
  private Paint bitmapPaint = new Paint();
  private Extensions extensions;
  private TouchManager touchManager;
  private Matrix transform = new Matrix();
  private Paint viewportPaint = new Paint();
  
  public CropView(Context paramContext)
  {
    super(paramContext);
    initCropView(paramContext, null);
  }
  
  public CropView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initCropView(paramContext, paramAttributeSet);
  }
  
  private void drawBitmap(Canvas paramCanvas)
  {
    transform.reset();
    touchManager.applyPositioningAndScale(transform);
    paramCanvas.drawBitmap(bitmap, transform, bitmapPaint);
  }
  
  private void resetTouchManager()
  {
    int k = 0;
    int j;
    if (bitmap == null)
    {
      i = 1;
      if (i == 0) {
        break label46;
      }
      j = 0;
      label17:
      if (i == 0) {
        break label57;
      }
    }
    label46:
    label57:
    for (int i = k;; i = bitmap.getHeight())
    {
      touchManager.resetFor(j, i, getWidth(), getHeight());
      return;
      i = 0;
      break;
      j = bitmap.getWidth();
      break label17;
    }
  }
  
  public Bitmap crop()
  {
    if (bitmap == null) {
      return null;
    }
    Object localObject = bitmap.getConfig();
    if (localObject == null) {
      localObject = Bitmap.Config.ARGB_8888;
    }
    for (;;)
    {
      int i = touchManager.getViewportHeight();
      localObject = Bitmap.createBitmap(touchManager.getViewportWidth(), i, (Bitmap.Config)localObject);
      Canvas localCanvas = new Canvas((Bitmap)localObject);
      localCanvas.translate(0.0F, -((getBottom() - i) / 2));
      drawBitmap(localCanvas);
      return (Bitmap)localObject;
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    super.dispatchTouchEvent(paramMotionEvent);
    touchManager.onEvent(paramMotionEvent);
    invalidate();
    return true;
  }
  
  public Extensions extensions()
  {
    if (extensions == null) {
      extensions = new Extensions(this);
    }
    return extensions;
  }
  
  public Bitmap getImageBitmap()
  {
    return bitmap;
  }
  
  public int getViewportHeight()
  {
    return touchManager.getViewportHeight();
  }
  
  public int getViewportWidth()
  {
    return touchManager.getViewportWidth();
  }
  
  void initCropView(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramContext = CropViewConfig.from(paramContext, paramAttributeSet);
    touchManager = new TouchManager(2, paramContext);
    bitmapPaint.setFilterBitmap(true);
    viewportPaint.setColor(paramContext.getViewportHeaderFooterColor());
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (bitmap == null) {
      return;
    }
    drawBitmap(paramCanvas);
    int i = getBottom();
    int j = touchManager.getViewportWidth();
    int k = (i - touchManager.getViewportHeight()) / 2;
    paramCanvas.drawRect(0.0F, 0.0F, j, k, viewportPaint);
    paramCanvas.drawRect(0.0F, i - k, j, i, viewportPaint);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    resetTouchManager();
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    bitmap = paramBitmap;
    resetTouchManager();
    invalidate();
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    if ((paramDrawable instanceof BitmapDrawable)) {
      paramDrawable = ((BitmapDrawable)paramDrawable).getBitmap();
    }
    for (;;)
    {
      setImageBitmap(paramDrawable);
      return;
      if (paramDrawable != null) {
        paramDrawable = Utils.asBitmap(paramDrawable, getWidth(), getHeight());
      } else {
        paramDrawable = null;
      }
    }
  }
  
  public void setImageResource(int paramInt)
  {
    if (paramInt > 0) {}
    for (Bitmap localBitmap = BitmapFactory.decodeResource(getResources(), paramInt);; localBitmap = null)
    {
      setImageBitmap(localBitmap);
      return;
    }
  }
  
  public void setImageURI(Uri paramUri)
  {
    extensions().load(paramUri);
  }
  
  public static class Extensions
  {
    private final CropView cropView;
    
    Extensions(CropView paramCropView)
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
}

/* Location:
 * Qualified Name:     com.lyft.android.scissors.CropView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */