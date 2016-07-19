package bo.app;

import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.appboy.Appboy;

final class e
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  e(d paramd, float paramFloat) {}
  
  public final void onGlobalLayout()
  {
    int i = b.a.b.getWidth();
    b.a.b.setLayoutParams(new RelativeLayout.LayoutParams(i, (int)(i / a)));
    Appboy localAppboy = b.a.d;
    Appboy.a(b.a.b.getViewTreeObserver(), this);
  }
}

/* Location:
 * Qualified Name:     bo.app.e
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */