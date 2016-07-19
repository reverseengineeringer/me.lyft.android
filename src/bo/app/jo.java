package bo.app;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

public abstract class jo
  implements jm
{
  protected Reference<View> a;
  protected boolean b;
  
  public jo(View paramView)
  {
    this(paramView, (byte)0);
  }
  
  private jo(View paramView, byte paramByte)
  {
    if (paramView == null) {
      throw new IllegalArgumentException("view must not be null");
    }
    a = new WeakReference(paramView);
    b = true;
  }
  
  public int a()
  {
    View localView = (View)a.get();
    ViewGroup.LayoutParams localLayoutParams;
    if (localView != null)
    {
      localLayoutParams = localView.getLayoutParams();
      if ((!b) || (localLayoutParams == null) || (width == -2)) {
        break label71;
      }
    }
    label71:
    for (int i = localView.getWidth();; i = 0)
    {
      int j = i;
      if (i <= 0)
      {
        j = i;
        if (localLayoutParams != null) {
          j = width;
        }
      }
      return j;
      return 0;
    }
  }
  
  protected abstract void a(Bitmap paramBitmap, View paramView);
  
  protected abstract void a(Drawable paramDrawable, View paramView);
  
  public final boolean a(Bitmap paramBitmap)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      View localView = (View)a.get();
      if (localView != null)
      {
        a(paramBitmap, localView);
        return true;
      }
    }
    else
    {
      jx.c("Can't set a bitmap into view. You should call ImageLoader on UI thread for it.", new Object[0]);
    }
    return false;
  }
  
  public final boolean a(Drawable paramDrawable)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      View localView = (View)a.get();
      if (localView != null)
      {
        a(paramDrawable, localView);
        return true;
      }
    }
    else
    {
      jx.c("Can't set a drawable into view. You should call ImageLoader on UI thread for it.", new Object[0]);
    }
    return false;
  }
  
  public int b()
  {
    View localView = (View)a.get();
    ViewGroup.LayoutParams localLayoutParams;
    if (localView != null)
    {
      localLayoutParams = localView.getLayoutParams();
      if ((!b) || (localLayoutParams == null) || (height == -2)) {
        break label71;
      }
    }
    label71:
    for (int i = localView.getHeight();; i = 0)
    {
      int j = i;
      if (i <= 0)
      {
        j = i;
        if (localLayoutParams != null) {
          j = height;
        }
      }
      return j;
      return 0;
    }
  }
  
  public int c()
  {
    return is.b;
  }
  
  public View d()
  {
    return (View)a.get();
  }
  
  public final boolean e()
  {
    return a.get() == null;
  }
  
  public final int f()
  {
    View localView = (View)a.get();
    if (localView == null) {
      return super.hashCode();
    }
    return localView.hashCode();
  }
}

/* Location:
 * Qualified Name:     bo.app.jo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */