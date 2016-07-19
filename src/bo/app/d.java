package bo.app;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewTreeObserver;

final class d
  extends jr
{
  d(c paramc) {}
  
  public final void a(String paramString, View paramView, Bitmap paramBitmap)
  {
    super.a(paramString, paramView, paramBitmap);
    float f = paramBitmap.getHeight();
    if (f == 0.0F) {}
    do
    {
      do
      {
        return;
      } while (a.c);
      f = paramBitmap.getWidth() / f;
      paramString = paramView.getViewTreeObserver();
    } while (!paramString.isAlive());
    paramString.addOnGlobalLayoutListener(new e(this, f));
  }
}

/* Location:
 * Qualified Name:     bo.app.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */