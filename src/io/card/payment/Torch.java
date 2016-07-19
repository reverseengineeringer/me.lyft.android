package io.card.payment;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.drawable.shapes.RoundRectShape;
import android.util.Log;
import java.util.Arrays;

class Torch
{
  private static final String TAG = Torch.class.getSimpleName();
  private float mHeight;
  private boolean mOn = false;
  private float mWidth;
  
  public Torch(float paramFloat1, float paramFloat2)
  {
    mWidth = paramFloat1;
    mHeight = paramFloat2;
  }
  
  private static Path createBoltPath()
  {
    Path localPath = new Path();
    localPath.moveTo(10.0F, 0.0F);
    localPath.lineTo(0.0F, 11.0F);
    localPath.lineTo(6.0F, 11.0F);
    localPath.lineTo(2.0F, 20.0F);
    localPath.lineTo(13.0F, 8.0F);
    localPath.lineTo(7.0F, 8.0F);
    localPath.lineTo(10.0F, 0.0F);
    localPath.setLastPoint(10.0F, 0.0F);
    Matrix localMatrix = new Matrix();
    localMatrix.postTranslate(-6.5F, -10.0F);
    localMatrix.postScale(0.05F, 0.05F);
    localPath.transform(localMatrix);
    return localPath;
  }
  
  public void draw(Canvas paramCanvas)
  {
    paramCanvas.save();
    paramCanvas.translate(-mWidth / 2.0F, -mHeight / 2.0F);
    Paint localPaint = new Paint();
    localPaint.setColor(-16777216);
    localPaint.setStyle(Paint.Style.STROKE);
    localPaint.setAntiAlias(true);
    localPaint.setStrokeWidth(1.5F);
    Object localObject1 = new Paint();
    ((Paint)localObject1).setStyle(Paint.Style.FILL);
    ((Paint)localObject1).setColor(-1);
    Object localObject2;
    if (mOn)
    {
      ((Paint)localObject1).setAlpha(192);
      localObject2 = new float[8];
      Arrays.fill((float[])localObject2, 5.0F);
      localObject2 = new RoundRectShape((float[])localObject2, null, null);
      ((RoundRectShape)localObject2).resize(mWidth, mHeight);
      ((RoundRectShape)localObject2).draw(paramCanvas, (Paint)localObject1);
      ((RoundRectShape)localObject2).draw(paramCanvas, localPaint);
      localPaint = new Paint();
      localPaint.setStyle(Paint.Style.FILL_AND_STROKE);
      localPaint.setAntiAlias(true);
      if (!mOn) {
        break label254;
      }
      localPaint.setColor(-1);
    }
    for (;;)
    {
      localObject1 = createBoltPath();
      localObject2 = new Matrix();
      float f = 0.8F * mHeight;
      ((Matrix)localObject2).postScale(f, f);
      ((Path)localObject1).transform((Matrix)localObject2);
      paramCanvas.translate(mWidth / 2.0F, mHeight / 2.0F);
      paramCanvas.drawPath((Path)localObject1, localPaint);
      paramCanvas.restore();
      return;
      ((Paint)localObject1).setAlpha(96);
      break;
      label254:
      localPaint.setColor(-16777216);
    }
  }
  
  public void setOn(boolean paramBoolean)
  {
    String str2 = TAG;
    StringBuilder localStringBuilder = new StringBuilder().append("Torch ");
    if (paramBoolean) {}
    for (String str1 = "ON";; str1 = "OFF")
    {
      Log.d(str2, str1);
      mOn = paramBoolean;
      return;
    }
  }
}

/* Location:
 * Qualified Name:     io.card.payment.Torch
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */