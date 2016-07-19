package android.support.v4.graphics.drawable;

import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;

public final class DrawableCompat
{
  static final DrawableImpl IMPL = new BaseDrawableImpl();
  
  static
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 23)
    {
      IMPL = new MDrawableImpl();
      return;
    }
    if (i >= 21)
    {
      IMPL = new LollipopDrawableImpl();
      return;
    }
    if (i >= 19)
    {
      IMPL = new KitKatDrawableImpl();
      return;
    }
    if (i >= 17)
    {
      IMPL = new JellybeanMr1DrawableImpl();
      return;
    }
    if (i >= 11)
    {
      IMPL = new HoneycombDrawableImpl();
      return;
    }
    if (i >= 5)
    {
      IMPL = new EclairDrawableImpl();
      return;
    }
  }
  
  public static boolean isAutoMirrored(Drawable paramDrawable)
  {
    return IMPL.isAutoMirrored(paramDrawable);
  }
  
  public static void setLayoutDirection(Drawable paramDrawable, int paramInt)
  {
    IMPL.setLayoutDirection(paramDrawable, paramInt);
  }
  
  static class BaseDrawableImpl
    implements DrawableCompat.DrawableImpl
  {
    public boolean isAutoMirrored(Drawable paramDrawable)
    {
      return false;
    }
    
    public void setLayoutDirection(Drawable paramDrawable, int paramInt) {}
  }
  
  static abstract interface DrawableImpl
  {
    public abstract boolean isAutoMirrored(Drawable paramDrawable);
    
    public abstract void setLayoutDirection(Drawable paramDrawable, int paramInt);
  }
  
  static class EclairDrawableImpl
    extends DrawableCompat.BaseDrawableImpl
  {}
  
  static class HoneycombDrawableImpl
    extends DrawableCompat.EclairDrawableImpl
  {}
  
  static class JellybeanMr1DrawableImpl
    extends DrawableCompat.HoneycombDrawableImpl
  {
    public void setLayoutDirection(Drawable paramDrawable, int paramInt)
    {
      DrawableCompatJellybeanMr1.setLayoutDirection(paramDrawable, paramInt);
    }
  }
  
  static class KitKatDrawableImpl
    extends DrawableCompat.JellybeanMr1DrawableImpl
  {
    public boolean isAutoMirrored(Drawable paramDrawable)
    {
      return DrawableCompatKitKat.isAutoMirrored(paramDrawable);
    }
  }
  
  static class LollipopDrawableImpl
    extends DrawableCompat.KitKatDrawableImpl
  {}
  
  static class MDrawableImpl
    extends DrawableCompat.LollipopDrawableImpl
  {
    public void setLayoutDirection(Drawable paramDrawable, int paramInt)
    {
      DrawableCompatApi23.setLayoutDirection(paramDrawable, paramInt);
    }
  }
}

/* Location:
 * Qualified Name:     android.support.v4.graphics.drawable.DrawableCompat
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */