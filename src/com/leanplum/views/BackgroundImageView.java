package com.leanplum.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.leanplum.utils.BitmapUtil;
import com.leanplum.utils.SizeUtil;

public class BackgroundImageView
  extends ImageView
{
  private Paint a = new Paint();
  private boolean b;
  private Matrix c = new Matrix();
  private boolean d;
  
  public BackgroundImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public BackgroundImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  public BackgroundImageView(Context paramContext, boolean paramBoolean)
  {
    super(paramContext);
    a();
    b = paramBoolean;
  }
  
  private void a()
  {
    a.setColor(-16711936);
    a.setStrokeWidth(2.0F);
    a.setStyle(Paint.Style.FILL_AND_STROKE);
  }
  
  public Bitmap loadBitmapFromView(View paramView)
  {
    if (paramView.getMeasuredHeight() <= 0) {
      paramView.measure(-2, -2);
    }
    Bitmap localBitmap = Bitmap.createBitmap(paramView.getMeasuredWidth(), paramView.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    paramView.layout(0, 0, paramView.getMeasuredWidth(), paramView.getMeasuredHeight());
    d = true;
    paramView.draw(localCanvas);
    return localBitmap;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (b) {
      return;
    }
    if (d)
    {
      d = false;
      return;
    }
    Bitmap localBitmap = loadBitmapFromView(this);
    paramCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
    paramCanvas.drawBitmap(BitmapUtil.getRoundedCornerBitmap(localBitmap, SizeUtil.dp20), c, a);
  }
}

/* Location:
 * Qualified Name:     com.leanplum.views.BackgroundImageView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */