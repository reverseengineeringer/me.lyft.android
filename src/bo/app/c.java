package bo.app;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import com.appboy.Appboy;
import java.util.Map;
import java.util.concurrent.Executor;

public final class c
  implements Runnable
{
  public c(Appboy paramAppboy, String paramString, ImageView paramImageView, boolean paramBoolean) {}
  
  public final void run()
  {
    int i = 0;
    Object localObject2 = Uri.parse(a).toString();
    Object localObject3 = Appboy.c(d);
    Object localObject1 = b;
    d locald = new d(this);
    jn localjn = new jn((ImageView)localObject1);
    if (b == null) {
      throw new IllegalStateException("ImageLoader must be init with configuration before using");
    }
    Object localObject4 = b.r;
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      c.b(localjn);
      localjn.d();
      if ((e != null) || (b != 0)) {
        i = 1;
      }
      if (i != 0)
      {
        localObject1 = b.a;
        if (b != 0)
        {
          localObject1 = ((Resources)localObject1).getDrawable(b);
          localjn.a((Drawable)localObject1);
        }
      }
      for (;;)
      {
        locald.a((String)localObject2, localjn.d(), null);
        return;
        localObject1 = e;
        break;
        localjn.a(null);
      }
    }
    localObject1 = b;
    Object localObject5 = a.getDisplayMetrics();
    int j = b;
    i = j;
    if (j <= 0) {
      i = widthPixels;
    }
    int k = c;
    j = k;
    if (k <= 0) {
      j = heightPixels;
    }
    localObject5 = jt.a(localjn, new ip(i, j));
    String str = (String)localObject2 + "_" + a + "x" + b;
    c.e.put(Integer.valueOf(localjn.f()), str);
    localjn.d();
    localObject1 = b.n.a(str);
    if ((localObject1 != null) && (!((Bitmap)localObject1).isRecycled()))
    {
      jx.a("Load image from memory cache [%s]", new Object[] { str });
      if (((ht)localObject4).a())
      {
        localObject2 = new id((String)localObject2, localjn, (ip)localObject5, str, (ht)localObject4, locald, c.a((String)localObject2));
        localObject1 = new ij(c, (Bitmap)localObject1, (id)localObject2, hv.a((ht)localObject4));
        if (s)
        {
          ((ij)localObject1).run();
          return;
        }
        localObject2 = c;
        ((ib)localObject2).a();
        c.execute((Runnable)localObject1);
        return;
      }
      localObject3 = q;
      localObject4 = iq.c;
      ((jg)localObject3).a((Bitmap)localObject1, localjn);
      locald.a((String)localObject2, localjn.d(), (Bitmap)localObject1);
      return;
    }
    if ((d != null) || (a != 0))
    {
      i = 1;
      if (i == 0) {
        break label679;
      }
      localObject1 = b.a;
      if (a == 0) {
        break label669;
      }
      localObject1 = ((Resources)localObject1).getDrawable(a);
      label588:
      localjn.a((Drawable)localObject1);
    }
    for (;;)
    {
      localObject1 = new id((String)localObject2, localjn, (ip)localObject5, str, (ht)localObject4, locald, c.a((String)localObject2));
      localObject1 = new ie(c, (id)localObject1, hv.a((ht)localObject4));
      if (!s) {
        break label699;
      }
      ((ie)localObject1).run();
      return;
      i = 0;
      break;
      label669:
      localObject1 = d;
      break label588;
      label679:
      if (g) {
        localjn.a(null);
      }
    }
    label699:
    localObject2 = c;
    d.execute(new ic((ib)localObject2, (ie)localObject1));
  }
}

/* Location:
 * Qualified Name:     bo.app.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */