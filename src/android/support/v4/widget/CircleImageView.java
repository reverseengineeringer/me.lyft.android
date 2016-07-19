package android.support.v4.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build.VERSION;
import android.support.v4.view.ViewCompat;
import android.util.DisplayMetrics;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;

class CircleImageView
  extends ImageView
{
  private Animation.AnimationListener mListener;
  private int mShadowRadius;
  
  public CircleImageView(Context paramContext, int paramInt, float paramFloat)
  {
    super(paramContext);
    float f = getContextgetResourcesgetDisplayMetricsdensity;
    int i = (int)(paramFloat * f * 2.0F);
    int j = (int)(1.75F * f);
    int k = (int)(0.0F * f);
    mShadowRadius = ((int)(3.5F * f));
    if (elevationSupported())
    {
      paramContext = new ShapeDrawable(new OvalShape());
      ViewCompat.setElevation(this, 4.0F * f);
    }
    for (;;)
    {
      paramContext.getPaint().setColor(paramInt);
      setBackgroundDrawable(paramContext);
      return;
      paramContext = new ShapeDrawable(new OvalShadow(mShadowRadius, i));
      ViewCompat.setLayerType(this, 1, paramContext.getPaint());
      paramContext.getPaint().setShadowLayer(mShadowRadius, k, j, 503316480);
      i = mShadowRadius;
      setPadding(i, i, i, i);
    }
  }
  
  private boolean elevationSupported()
  {
    return Build.VERSION.SDK_INT >= 21;
  }
  
  public void onAnimationEnd()
  {
    super.onAnimationEnd();
    if (mListener != null) {
      mListener.onAnimationEnd(getAnimation());
    }
  }
  
  public void onAnimationStart()
  {
    super.onAnimationStart();
    if (mListener != null) {
      mListener.onAnimationStart(getAnimation());
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (!elevationSupported()) {
      setMeasuredDimension(getMeasuredWidth() + mShadowRadius * 2, getMeasuredHeight() + mShadowRadius * 2);
    }
  }
  
  public void setAnimationListener(Animation.AnimationListener paramAnimationListener)
  {
    mListener = paramAnimationListener;
  }
  
  public void setBackgroundColor(int paramInt)
  {
    if ((getBackground() instanceof ShapeDrawable)) {
      ((ShapeDrawable)getBackground()).getPaint().setColor(paramInt);
    }
  }
  
  private class OvalShadow
    extends OvalShape
  {
    private int mCircleDiameter;
    private RadialGradient mRadialGradient;
    private Paint mShadowPaint = new Paint();
    
    public OvalShadow(int paramInt1, int paramInt2)
    {
      CircleImageView.access$002(CircleImageView.this, paramInt1);
      mCircleDiameter = paramInt2;
      float f1 = mCircleDiameter / 2;
      float f2 = mCircleDiameter / 2;
      float f3 = mShadowRadius;
      this$1 = Shader.TileMode.CLAMP;
      mRadialGradient = new RadialGradient(f1, f2, f3, new int[] { 1023410176, 0 }, null, CircleImageView.this);
      mShadowPaint.setShader(mRadialGradient);
    }
    
    public void draw(Canvas paramCanvas, Paint paramPaint)
    {
      int i = getWidth();
      int j = getHeight();
      paramCanvas.drawCircle(i / 2, j / 2, mCircleDiameter / 2 + mShadowRadius, mShadowPaint);
      paramCanvas.drawCircle(i / 2, j / 2, mCircleDiameter / 2, paramPaint);
    }
  }
}

/* Location:
 * Qualified Name:     android.support.v4.widget.CircleImageView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */