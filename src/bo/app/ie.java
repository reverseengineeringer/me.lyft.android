package bo.app;

import android.graphics.Bitmap;
import android.os.Handler;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

public final class ie
  implements jw, Runnable
{
  final hw a;
  final String b;
  final jm c;
  final ht d;
  final jp e;
  final jq f;
  private final ib g;
  private final id h;
  private final Handler i;
  private final jk j;
  private final jk k;
  private final jk l;
  private final je m;
  private final String n;
  private final ip o;
  private final boolean p;
  private iq q = iq.a;
  
  public ie(ib paramib, id paramid, Handler paramHandler)
  {
    g = paramib;
    h = paramid;
    i = paramHandler;
    a = a;
    j = a.p;
    k = a.s;
    l = a.t;
    m = a.q;
    b = a;
    n = b;
    c = c;
    o = d;
    d = e;
    e = f;
    f = g;
    p = d.s;
  }
  
  private Bitmap a(String paramString)
  {
    int i1 = c.c();
    paramString = new jf(n, paramString, b, o, i1, f(), d);
    return m.a(paramString);
  }
  
  private void a(int paramInt, Throwable paramThrowable)
  {
    if ((p) || (l()) || (h())) {
      return;
    }
    a(new ig(this, paramInt, paramThrowable), false, i, g);
  }
  
  static void a(Runnable paramRunnable, boolean paramBoolean, Handler paramHandler, ib paramib)
  {
    if (paramBoolean)
    {
      paramRunnable.run();
      return;
    }
    if (paramHandler == null)
    {
      d.execute(paramRunnable);
      return;
    }
    paramHandler.post(paramRunnable);
  }
  
  private boolean a()
  {
    AtomicBoolean localAtomicBoolean = g.f;
    if (localAtomicBoolean.get()) {}
    synchronized (g.i)
    {
      if (localAtomicBoolean.get()) {
        jx.a("ImageLoader is paused. Waiting...  [%s]", new Object[] { n });
      }
      try
      {
        g.i.wait();
        jx.a(".. Resume loading [%s]", new Object[] { n });
        return h();
      }
      catch (InterruptedException localInterruptedException)
      {
        jx.d("Task was interrupted [%s]", new Object[] { n });
        return true;
      }
    }
  }
  
  private boolean b()
  {
    if (d.l > 0) {}
    for (int i1 = 1; i1 != 0; i1 = 0)
    {
      jx.a("Delay %d ms before loading...  [%s]", new Object[] { Integer.valueOf(d.l), n });
      try
      {
        Thread.sleep(d.l);
        return h();
      }
      catch (InterruptedException localInterruptedException)
      {
        jx.d("Task was interrupted [%s]", new Object[] { n });
        return true;
      }
    }
    return false;
  }
  
  private Bitmap c()
  {
    for (;;)
    {
      try
      {
        Object localObject1 = a.o.a(b);
        Object localObject3;
        Object localObject4;
        Object localObject5;
        Object localObject6;
        if ((localObject1 != null) && (((File)localObject1).exists()) && (((File)localObject1).length() > 0L))
        {
          jx.a("Load image from disk cache [%s]", new Object[] { n });
          q = iq.b;
          g();
          localObject1 = a(jl.c.b(((File)localObject1).getAbsolutePath()));
          if (localObject1 != null)
          {
            localObject3 = localObject1;
            localObject4 = localObject1;
            localObject5 = localObject1;
            localObject6 = localObject1;
          }
        }
        Object localObject7;
        String str;
        File localFile;
        Object localObject2 = null;
      }
      catch (IllegalStateException localIllegalStateException1)
      {
        try
        {
          if (((Bitmap)localObject1).getWidth() > 0)
          {
            localObject7 = localObject1;
            localObject3 = localObject1;
            localObject4 = localObject1;
            localObject5 = localObject1;
            localObject6 = localObject1;
            if (((Bitmap)localObject1).getHeight() > 0) {}
          }
          else
          {
            localObject3 = localObject1;
            localObject4 = localObject1;
            localObject5 = localObject1;
            localObject6 = localObject1;
            jx.a("Load image from network [%s]", new Object[] { n });
            localObject3 = localObject1;
            localObject4 = localObject1;
            localObject5 = localObject1;
            localObject6 = localObject1;
            q = iq.a;
            localObject3 = localObject1;
            localObject4 = localObject1;
            localObject5 = localObject1;
            localObject6 = localObject1;
            str = b;
            localObject7 = str;
            localObject3 = localObject1;
            localObject4 = localObject1;
            localObject5 = localObject1;
            localObject6 = localObject1;
            if (d.i)
            {
              localObject7 = str;
              localObject3 = localObject1;
              localObject4 = localObject1;
              localObject5 = localObject1;
              localObject6 = localObject1;
              if (d())
              {
                localObject3 = localObject1;
                localObject4 = localObject1;
                localObject5 = localObject1;
                localObject6 = localObject1;
                localFile = a.o.a(b);
                localObject7 = str;
                if (localFile != null)
                {
                  localObject3 = localObject1;
                  localObject4 = localObject1;
                  localObject5 = localObject1;
                  localObject6 = localObject1;
                  localObject7 = jl.c.b(localFile.getAbsolutePath());
                }
              }
            }
            localObject3 = localObject1;
            localObject4 = localObject1;
            localObject5 = localObject1;
            localObject6 = localObject1;
            g();
            localObject3 = localObject1;
            localObject4 = localObject1;
            localObject5 = localObject1;
            localObject6 = localObject1;
            localObject1 = a((String)localObject7);
            if (localObject1 != null)
            {
              localObject3 = localObject1;
              localObject4 = localObject1;
              localObject5 = localObject1;
              localObject6 = localObject1;
              if (((Bitmap)localObject1).getWidth() > 0)
              {
                localObject7 = localObject1;
                localObject3 = localObject1;
                localObject4 = localObject1;
                localObject5 = localObject1;
                localObject6 = localObject1;
                if (((Bitmap)localObject1).getHeight() > 0) {
                  continue;
                }
              }
            }
            localObject3 = localObject1;
            localObject4 = localObject1;
            localObject5 = localObject1;
            localObject6 = localObject1;
            a(im.b, null);
            localObject7 = localObject1;
          }
          return (Bitmap)localObject7;
        }
        catch (Throwable localThrowable2)
        {
          continue;
        }
        catch (OutOfMemoryError localOutOfMemoryError2)
        {
          continue;
        }
        catch (IOException localIOException2)
        {
          continue;
        }
        catch (IllegalStateException localIllegalStateException2)
        {
          continue;
        }
        localIllegalStateException1 = localIllegalStateException1;
        localObject6 = null;
        a(im.c, null);
        return (Bitmap)localObject6;
      }
      catch (ii localii)
      {
        throw localii;
      }
      catch (IOException localIOException1)
      {
        localObject5 = null;
        jx.a(localIOException1);
        a(im.a, localIOException1);
        return (Bitmap)localObject5;
      }
      catch (OutOfMemoryError localOutOfMemoryError1)
      {
        localObject4 = null;
        jx.a(localOutOfMemoryError1);
        a(im.d, localOutOfMemoryError1);
        return (Bitmap)localObject4;
      }
      catch (Throwable localThrowable1)
      {
        localObject3 = null;
        jx.a(localThrowable1);
        a(im.e, localThrowable1);
        return (Bitmap)localObject3;
      }
    }
  }
  
  private boolean d()
  {
    jx.a("Cache image on disk [%s]", new Object[] { n });
    try
    {
      boolean bool = e();
      if (bool)
      {
        int i1 = a.d;
        int i2 = a.e;
        if ((i1 > 0) || (i2 > 0))
        {
          jx.a("Resize image in disk cache [%s]", new Object[] { n });
          Object localObject1 = a.o.a(b);
          if ((localObject1 != null) && (((File)localObject1).exists()))
          {
            Object localObject2 = new ip(i1, i2);
            Object localObject3 = new hu();
            ht localht = d;
            a = a;
            b = b;
            c = c;
            d = d;
            e = e;
            f = f;
            g = g;
            h = h;
            i = i;
            j = j;
            k = k;
            l = l;
            m = m;
            n = n;
            o = o;
            p = p;
            q = q;
            r = r;
            s = s;
            j = io.d;
            localObject3 = ((hu)localObject3).a();
            localObject1 = new jf(n, jl.c.b(((File)localObject1).getAbsolutePath()), b, (ip)localObject2, is.a, f(), (ht)localObject3);
            localObject2 = m.a((jf)localObject1);
            localObject1 = localObject2;
            if (localObject2 != null)
            {
              localObject1 = localObject2;
              if (a.f != null)
              {
                jx.a("Process image before cache on disk [%s]", new Object[] { n });
                localObject2 = a.f.a();
                localObject1 = localObject2;
                if (localObject2 == null)
                {
                  jx.d("Bitmap processor for disk cache returned null [%s]", new Object[] { n });
                  localObject1 = localObject2;
                }
              }
            }
            if (localObject1 != null)
            {
              a.o.a(b, (Bitmap)localObject1);
              ((Bitmap)localObject1).recycle();
            }
          }
        }
      }
      return bool;
    }
    catch (IOException localIOException)
    {
      jx.a(localIOException);
    }
    return false;
  }
  
  private boolean e()
  {
    InputStream localInputStream = f().a(b, d.n);
    if (localInputStream == null)
    {
      jx.d("No stream for image [%s]", new Object[] { n });
      return false;
    }
    try
    {
      boolean bool = a.o.a(b, localInputStream, this);
      return bool;
    }
    finally
    {
      jv.a(localInputStream);
    }
  }
  
  private jk f()
  {
    if (g.g.get()) {
      return k;
    }
    if (g.h.get()) {
      return l;
    }
    return j;
  }
  
  private void g()
  {
    if (i()) {
      throw new ii(this);
    }
    if (j()) {
      throw new ii(this);
    }
  }
  
  private boolean h()
  {
    return (i()) || (j());
  }
  
  private boolean i()
  {
    if (c.e())
    {
      jx.a("ImageAware was collected by GC. Task is cancelled. [%s]", new Object[] { n });
      return true;
    }
    return false;
  }
  
  private boolean j()
  {
    String str = g.a(c);
    if (!n.equals(str)) {}
    for (int i1 = 1; i1 != 0; i1 = 0)
    {
      jx.a("ImageAware is reused for another image. Task is cancelled. [%s]", new Object[] { n });
      return true;
    }
    return false;
  }
  
  private void k()
  {
    if (l()) {
      throw new ii(this);
    }
  }
  
  private boolean l()
  {
    if (Thread.interrupted())
    {
      jx.a("Task was interrupted [%s]", new Object[] { n });
      return true;
    }
    return false;
  }
  
  public final boolean a(int paramInt1, int paramInt2)
  {
    boolean bool = false;
    if (!p) {
      if ((!l()) && (!h())) {
        break label33;
      }
    }
    for (paramInt1 = 0;; paramInt1 = 1)
    {
      if (paramInt1 != 0) {
        bool = true;
      }
      return bool;
      label33:
      if (f != null) {
        a(new if(this, paramInt1, paramInt2), false, i, g);
      }
    }
  }
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_1
    //   2: aload_0
    //   3: invokespecial 437	bo/app/ie:a	()Z
    //   6: ifeq +4 -> 10
    //   9: return
    //   10: aload_0
    //   11: invokespecial 439	bo/app/ie:b	()Z
    //   14: ifne -5 -> 9
    //   17: aload_0
    //   18: getfield 54	bo/app/ie:h	Lbo/app/id;
    //   21: getfield 442	bo/app/id:h	Ljava/util/concurrent/locks/ReentrantLock;
    //   24: astore 5
    //   26: ldc_w 444
    //   29: iconst_1
    //   30: anewarray 4	java/lang/Object
    //   33: dup
    //   34: iconst_0
    //   35: aload_0
    //   36: getfield 90	bo/app/ie:n	Ljava/lang/String;
    //   39: aastore
    //   40: invokestatic 187	bo/app/jx:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   43: aload 5
    //   45: invokevirtual 449	java/util/concurrent/locks/ReentrantLock:isLocked	()Z
    //   48: ifeq +20 -> 68
    //   51: ldc_w 451
    //   54: iconst_1
    //   55: anewarray 4	java/lang/Object
    //   58: dup
    //   59: iconst_0
    //   60: aload_0
    //   61: getfield 90	bo/app/ie:n	Ljava/lang/String;
    //   64: aastore
    //   65: invokestatic 187	bo/app/jx:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   68: aload 5
    //   70: invokevirtual 454	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   73: aload_0
    //   74: invokespecial 247	bo/app/ie:g	()V
    //   77: aload_0
    //   78: getfield 61	bo/app/ie:a	Lbo/app/hw;
    //   81: getfield 457	bo/app/hw:n	Lbo/app/hn;
    //   84: aload_0
    //   85: getfield 90	bo/app/ie:n	Ljava/lang/String;
    //   88: invokeinterface 460 2 0
    //   93: astore 4
    //   95: aload 4
    //   97: ifnull +11 -> 108
    //   100: aload 4
    //   102: invokevirtual 463	android/graphics/Bitmap:isRecycled	()Z
    //   105: ifeq +291 -> 396
    //   108: aload_0
    //   109: invokespecial 465	bo/app/ie:c	()Landroid/graphics/Bitmap;
    //   112: astore_3
    //   113: aload_3
    //   114: ifnonnull +9 -> 123
    //   117: aload 5
    //   119: invokevirtual 468	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   122: return
    //   123: aload_0
    //   124: invokespecial 247	bo/app/ie:g	()V
    //   127: aload_0
    //   128: invokespecial 470	bo/app/ie:k	()V
    //   131: aload_0
    //   132: getfield 101	bo/app/ie:d	Lbo/app/ht;
    //   135: getfield 348	bo/app/ht:o	Lbo/app/js;
    //   138: ifnull +253 -> 391
    //   141: iload_1
    //   142: ifeq +62 -> 204
    //   145: ldc_w 472
    //   148: iconst_1
    //   149: anewarray 4	java/lang/Object
    //   152: dup
    //   153: iconst_0
    //   154: aload_0
    //   155: getfield 90	bo/app/ie:n	Ljava/lang/String;
    //   158: aastore
    //   159: invokestatic 187	bo/app/jx:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   162: aload_0
    //   163: getfield 101	bo/app/ie:d	Lbo/app/ht;
    //   166: getfield 348	bo/app/ht:o	Lbo/app/js;
    //   169: invokeinterface 378 1 0
    //   174: astore 4
    //   176: aload 4
    //   178: astore_3
    //   179: aload 4
    //   181: ifnonnull +23 -> 204
    //   184: ldc_w 474
    //   187: iconst_1
    //   188: anewarray 4	java/lang/Object
    //   191: dup
    //   192: iconst_0
    //   193: aload_0
    //   194: getfield 90	bo/app/ie:n	Ljava/lang/String;
    //   197: aastore
    //   198: invokestatic 196	bo/app/jx:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   201: aload 4
    //   203: astore_3
    //   204: aload_3
    //   205: astore 4
    //   207: aload_3
    //   208: ifnull +54 -> 262
    //   211: aload_3
    //   212: astore 4
    //   214: aload_0
    //   215: getfield 101	bo/app/ie:d	Lbo/app/ht;
    //   218: getfield 329	bo/app/ht:h	Z
    //   221: ifeq +41 -> 262
    //   224: ldc_w 476
    //   227: iconst_1
    //   228: anewarray 4	java/lang/Object
    //   231: dup
    //   232: iconst_0
    //   233: aload_0
    //   234: getfield 90	bo/app/ie:n	Ljava/lang/String;
    //   237: aastore
    //   238: invokestatic 187	bo/app/jx:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   241: aload_0
    //   242: getfield 61	bo/app/ie:a	Lbo/app/hw;
    //   245: getfield 457	bo/app/hw:n	Lbo/app/hn;
    //   248: aload_0
    //   249: getfield 90	bo/app/ie:n	Ljava/lang/String;
    //   252: aload_3
    //   253: invokeinterface 477 3 0
    //   258: pop
    //   259: aload_3
    //   260: astore 4
    //   262: aload 4
    //   264: astore_3
    //   265: aload 4
    //   267: ifnull +75 -> 342
    //   270: aload 4
    //   272: astore_3
    //   273: aload_0
    //   274: getfield 101	bo/app/ie:d	Lbo/app/ht;
    //   277: invokevirtual 478	bo/app/ht:a	()Z
    //   280: ifeq +62 -> 342
    //   283: ldc_w 480
    //   286: iconst_1
    //   287: anewarray 4	java/lang/Object
    //   290: dup
    //   291: iconst_0
    //   292: aload_0
    //   293: getfield 90	bo/app/ie:n	Ljava/lang/String;
    //   296: aastore
    //   297: invokestatic 187	bo/app/jx:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   300: aload_0
    //   301: getfield 101	bo/app/ie:d	Lbo/app/ht;
    //   304: getfield 351	bo/app/ht:p	Lbo/app/js;
    //   307: invokeinterface 378 1 0
    //   312: astore 4
    //   314: aload 4
    //   316: astore_3
    //   317: aload 4
    //   319: ifnonnull +23 -> 342
    //   322: ldc_w 482
    //   325: iconst_1
    //   326: anewarray 4	java/lang/Object
    //   329: dup
    //   330: iconst_0
    //   331: aload_0
    //   332: getfield 90	bo/app/ie:n	Ljava/lang/String;
    //   335: aastore
    //   336: invokestatic 196	bo/app/jx:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   339: aload 4
    //   341: astore_3
    //   342: aload_0
    //   343: invokespecial 247	bo/app/ie:g	()V
    //   346: aload_0
    //   347: invokespecial 470	bo/app/ie:k	()V
    //   350: aload 5
    //   352: invokevirtual 468	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   355: new 484	bo/app/hs
    //   358: dup
    //   359: aload_3
    //   360: aload_0
    //   361: getfield 54	bo/app/ie:h	Lbo/app/id;
    //   364: aload_0
    //   365: getfield 52	bo/app/ie:g	Lbo/app/ib;
    //   368: aload_0
    //   369: getfield 50	bo/app/ie:q	Lbo/app/iq;
    //   372: invokespecial 487	bo/app/hs:<init>	(Landroid/graphics/Bitmap;Lbo/app/id;Lbo/app/ib;Lbo/app/iq;)V
    //   375: aload_0
    //   376: getfield 115	bo/app/ie:p	Z
    //   379: aload_0
    //   380: getfield 56	bo/app/ie:i	Landroid/os/Handler;
    //   383: aload_0
    //   384: getfield 52	bo/app/ie:g	Lbo/app/ib;
    //   387: invokestatic 149	bo/app/ie:a	(Ljava/lang/Runnable;ZLandroid/os/Handler;Lbo/app/ib;)V
    //   390: return
    //   391: iconst_0
    //   392: istore_1
    //   393: goto -252 -> 141
    //   396: aload_0
    //   397: getstatic 489	bo/app/iq:c	Lbo/app/iq;
    //   400: putfield 50	bo/app/ie:q	Lbo/app/iq;
    //   403: ldc_w 491
    //   406: iconst_1
    //   407: anewarray 4	java/lang/Object
    //   410: dup
    //   411: iconst_0
    //   412: aload_0
    //   413: getfield 90	bo/app/ie:n	Ljava/lang/String;
    //   416: aastore
    //   417: invokestatic 187	bo/app/jx:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   420: goto -158 -> 262
    //   423: astore_3
    //   424: aload_0
    //   425: getfield 115	bo/app/ie:p	Z
    //   428: ifne +12 -> 440
    //   431: aload_0
    //   432: invokespecial 139	bo/app/ie:l	()Z
    //   435: istore_2
    //   436: iload_2
    //   437: ifeq +9 -> 446
    //   440: aload 5
    //   442: invokevirtual 468	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   445: return
    //   446: new 493	bo/app/ih
    //   449: dup
    //   450: aload_0
    //   451: invokespecial 494	bo/app/ih:<init>	(Lbo/app/ie;)V
    //   454: iconst_0
    //   455: aload_0
    //   456: getfield 56	bo/app/ie:i	Landroid/os/Handler;
    //   459: aload_0
    //   460: getfield 52	bo/app/ie:g	Lbo/app/ib;
    //   463: invokestatic 149	bo/app/ie:a	(Ljava/lang/Runnable;ZLandroid/os/Handler;Lbo/app/ib;)V
    //   466: goto -26 -> 440
    //   469: astore_3
    //   470: aload 5
    //   472: invokevirtual 468	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   475: aload_3
    //   476: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	477	0	this	ie
    //   1	392	1	i1	int
    //   435	2	2	bool	boolean
    //   112	248	3	localObject1	Object
    //   423	1	3	localii	ii
    //   469	7	3	localObject2	Object
    //   93	247	4	localObject3	Object
    //   24	447	5	localReentrantLock	java.util.concurrent.locks.ReentrantLock
    // Exception table:
    //   from	to	target	type
    //   73	95	423	bo/app/ii
    //   100	108	423	bo/app/ii
    //   108	113	423	bo/app/ii
    //   123	141	423	bo/app/ii
    //   145	176	423	bo/app/ii
    //   184	201	423	bo/app/ii
    //   214	259	423	bo/app/ii
    //   273	314	423	bo/app/ii
    //   322	339	423	bo/app/ii
    //   342	350	423	bo/app/ii
    //   396	420	423	bo/app/ii
    //   73	95	469	finally
    //   100	108	469	finally
    //   108	113	469	finally
    //   123	141	469	finally
    //   145	176	469	finally
    //   184	201	469	finally
    //   214	259	469	finally
    //   273	314	469	finally
    //   322	339	469	finally
    //   342	350	469	finally
    //   396	420	469	finally
    //   424	436	469	finally
    //   446	466	469	finally
  }
}

/* Location:
 * Qualified Name:     bo.app.ie
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */