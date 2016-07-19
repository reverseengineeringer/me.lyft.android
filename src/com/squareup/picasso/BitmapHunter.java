package com.squareup.picasso;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.NetworkInfo;
import android.os.Handler;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

class BitmapHunter
  implements Runnable
{
  private static final Object DECODE_LOCK = new Object();
  private static final RequestHandler ERRORING_HANDLER = new RequestHandler()
  {
    public boolean canHandleRequest(Request paramAnonymousRequest)
    {
      return true;
    }
    
    public RequestHandler.Result load(Request paramAnonymousRequest, int paramAnonymousInt)
      throws IOException
    {
      throw new IllegalStateException("Unrecognized type of request: " + paramAnonymousRequest);
    }
  };
  private static final ThreadLocal<StringBuilder> NAME_BUILDER = new ThreadLocal()
  {
    protected StringBuilder initialValue()
    {
      return new StringBuilder("Picasso-");
    }
  };
  private static final AtomicInteger SEQUENCE_GENERATOR = new AtomicInteger();
  Action action;
  List<Action> actions;
  final Cache cache;
  final Request data;
  final Dispatcher dispatcher;
  Exception exception;
  int exifRotation;
  Future<?> future;
  final String key;
  Picasso.LoadedFrom loadedFrom;
  final int memoryPolicy;
  int networkPolicy;
  final Picasso picasso;
  Picasso.Priority priority;
  final RequestHandler requestHandler;
  Bitmap result;
  int retryCount;
  final int sequence = SEQUENCE_GENERATOR.incrementAndGet();
  final Stats stats;
  
  BitmapHunter(Picasso paramPicasso, Dispatcher paramDispatcher, Cache paramCache, Stats paramStats, Action paramAction, RequestHandler paramRequestHandler)
  {
    picasso = paramPicasso;
    dispatcher = paramDispatcher;
    cache = paramCache;
    stats = paramStats;
    action = paramAction;
    key = paramAction.getKey();
    data = paramAction.getRequest();
    priority = paramAction.getPriority();
    memoryPolicy = paramAction.getMemoryPolicy();
    networkPolicy = paramAction.getNetworkPolicy();
    requestHandler = paramRequestHandler;
    retryCount = paramRequestHandler.getRetryCount();
  }
  
  static Bitmap applyCustomTransformations(final List<Transformation> paramList, Bitmap paramBitmap)
  {
    int i = 0;
    int j = paramList.size();
    for (;;)
    {
      Bitmap localBitmap = paramBitmap;
      Transformation localTransformation;
      if (i < j)
      {
        localTransformation = (Transformation)paramList.get(i);
        try
        {
          localBitmap = localTransformation.transform(paramBitmap);
          if (localBitmap != null) {
            break label165;
          }
          paramBitmap = new StringBuilder().append("Transformation ").append(localTransformation.key()).append(" returned null after ").append(i).append(" previous transformation(s).\n\nTransformation list:\n");
          paramList = paramList.iterator();
          while (paramList.hasNext())
          {
            paramBitmap.append(((Transformation)paramList.next()).key()).append('\n');
            continue;
            return localBitmap;
          }
        }
        catch (RuntimeException paramList)
        {
          Picasso.HANDLER.post(new Runnable()
          {
            public void run()
            {
              throw new RuntimeException("Transformation " + val$transformation.key() + " crashed with exception.", paramList);
            }
          });
          localBitmap = null;
        }
      }
      Picasso.HANDLER.post(new Runnable()
      {
        public void run()
        {
          throw new NullPointerException(val$builder.toString());
        }
      });
      return null;
      label165:
      if ((localBitmap == paramBitmap) && (paramBitmap.isRecycled()))
      {
        Picasso.HANDLER.post(new Runnable()
        {
          public void run()
          {
            throw new IllegalStateException("Transformation " + val$transformation.key() + " returned input Bitmap but recycled it.");
          }
        });
        return null;
      }
      if ((localBitmap != paramBitmap) && (!paramBitmap.isRecycled()))
      {
        Picasso.HANDLER.post(new Runnable()
        {
          public void run()
          {
            throw new IllegalStateException("Transformation " + val$transformation.key() + " mutated input Bitmap but failed to recycle the original.");
          }
        });
        return null;
      }
      paramBitmap = localBitmap;
      i += 1;
    }
  }
  
  private Picasso.Priority computeNewPriority()
  {
    Object localObject1 = Picasso.Priority.LOW;
    int i;
    if ((actions != null) && (!actions.isEmpty()))
    {
      i = 1;
      if ((action == null) && (i == 0)) {
        break label49;
      }
    }
    label49:
    for (int j = 1;; j = 0)
    {
      if (j != 0) {
        break label54;
      }
      return (Picasso.Priority)localObject1;
      i = 0;
      break;
    }
    label54:
    if (action != null) {
      localObject1 = action.getPriority();
    }
    Object localObject2 = localObject1;
    if (i != 0)
    {
      i = 0;
      j = actions.size();
      for (;;)
      {
        localObject2 = localObject1;
        if (i >= j) {
          break;
        }
        Picasso.Priority localPriority = ((Action)actions.get(i)).getPriority();
        localObject2 = localObject1;
        if (localPriority.ordinal() > ((Picasso.Priority)localObject1).ordinal()) {
          localObject2 = localPriority;
        }
        i += 1;
        localObject1 = localObject2;
      }
    }
    return (Picasso.Priority)localObject2;
  }
  
  static Bitmap decodeStream(InputStream paramInputStream, Request paramRequest)
    throws IOException
  {
    Object localObject = new MarkableInputStream(paramInputStream);
    long l = ((MarkableInputStream)localObject).savePosition(65536);
    paramInputStream = RequestHandler.createBitmapOptions(paramRequest);
    boolean bool1 = RequestHandler.requiresInSampleSize(paramInputStream);
    boolean bool2 = Utils.isWebPFile((InputStream)localObject);
    ((MarkableInputStream)localObject).reset(l);
    if (bool2)
    {
      localObject = Utils.toByteArray((InputStream)localObject);
      if (bool1)
      {
        BitmapFactory.decodeByteArray((byte[])localObject, 0, localObject.length, paramInputStream);
        RequestHandler.calculateInSampleSize(targetWidth, targetHeight, paramInputStream, paramRequest);
      }
      paramInputStream = BitmapFactory.decodeByteArray((byte[])localObject, 0, localObject.length, paramInputStream);
    }
    do
    {
      return paramInputStream;
      if (bool1)
      {
        BitmapFactory.decodeStream((InputStream)localObject, null, paramInputStream);
        RequestHandler.calculateInSampleSize(targetWidth, targetHeight, paramInputStream, paramRequest);
        ((MarkableInputStream)localObject).reset(l);
      }
      paramRequest = BitmapFactory.decodeStream((InputStream)localObject, null, paramInputStream);
      paramInputStream = paramRequest;
    } while (paramRequest != null);
    throw new IOException("Failed to decode stream.");
  }
  
  static BitmapHunter forRequest(Picasso paramPicasso, Dispatcher paramDispatcher, Cache paramCache, Stats paramStats, Action paramAction)
  {
    Request localRequest = paramAction.getRequest();
    List localList = paramPicasso.getRequestHandlers();
    int i = 0;
    int j = localList.size();
    while (i < j)
    {
      RequestHandler localRequestHandler = (RequestHandler)localList.get(i);
      if (localRequestHandler.canHandleRequest(localRequest)) {
        return new BitmapHunter(paramPicasso, paramDispatcher, paramCache, paramStats, paramAction, localRequestHandler);
      }
      i += 1;
    }
    return new BitmapHunter(paramPicasso, paramDispatcher, paramCache, paramStats, paramAction, ERRORING_HANDLER);
  }
  
  private static boolean shouldResize(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return (!paramBoolean) || (paramInt1 > paramInt3) || (paramInt2 > paramInt4);
  }
  
  static Bitmap transformResult(Request paramRequest, Bitmap paramBitmap, int paramInt)
  {
    int i4 = paramBitmap.getWidth();
    int i5 = paramBitmap.getHeight();
    boolean bool = onlyScaleDown;
    int m = 0;
    int i6 = 0;
    int i7 = 0;
    int k = 0;
    int j = i4;
    int i = i5;
    Object localObject = new Matrix();
    int n = m;
    int i1 = i7;
    int i2 = j;
    int i3 = i;
    int i8;
    int i9;
    float f1;
    if (paramRequest.needsMatrixTransform())
    {
      i8 = targetWidth;
      i9 = targetHeight;
      f1 = rotationDegrees;
      if (f1 != 0.0F)
      {
        if (!hasRotationPivot) {
          break label289;
        }
        ((Matrix)localObject).setRotate(f1, rotationPivotX, rotationPivotY);
      }
      if (!centerCrop) {
        break label333;
      }
      f1 = i8 / i4;
      f2 = i9 / i5;
      if (f1 <= f2) {
        break label298;
      }
      i = (int)Math.ceil(i5 * (f2 / f1));
      k = (i5 - i) / 2;
      f2 = i9 / i;
      m = j;
      j = i6;
      label186:
      n = j;
      i1 = k;
      i2 = m;
      i3 = i;
      if (shouldResize(bool, i4, i5, i8, i9))
      {
        ((Matrix)localObject).preScale(f1, f2);
        i3 = i;
        i2 = m;
        i1 = k;
        n = j;
      }
    }
    label289:
    label298:
    label333:
    label455:
    do
    {
      do
      {
        if (paramInt != 0) {
          ((Matrix)localObject).preRotate(paramInt);
        }
        localObject = Bitmap.createBitmap(paramBitmap, n, i1, i2, i3, (Matrix)localObject, true);
        paramRequest = paramBitmap;
        if (localObject != paramBitmap)
        {
          paramBitmap.recycle();
          paramRequest = (Request)localObject;
        }
        return paramRequest;
        ((Matrix)localObject).setRotate(f1);
        break;
        m = (int)Math.ceil(i4 * (f1 / f2));
        j = (i4 - m) / 2;
        f1 = i8 / m;
        break label186;
        if (centerInside)
        {
          f1 = i8 / i4;
          f2 = i9 / i5;
          if (f1 < f2) {}
          for (;;)
          {
            n = m;
            i1 = i7;
            i2 = j;
            i3 = i;
            if (!shouldResize(bool, i4, i5, i8, i9)) {
              break;
            }
            ((Matrix)localObject).preScale(f1, f1);
            n = m;
            i1 = i7;
            i2 = j;
            i3 = i;
            break;
            f1 = f2;
          }
        }
        if (i8 != 0) {
          break label455;
        }
        n = m;
        i1 = i7;
        i2 = j;
        i3 = i;
      } while (i9 == 0);
      if (i8 != i4) {
        break label485;
      }
      n = m;
      i1 = i7;
      i2 = j;
      i3 = i;
    } while (i9 == i5);
    label485:
    if (i8 != 0)
    {
      f1 = i8 / i4;
      label498:
      if (i9 == 0) {
        break label583;
      }
    }
    label583:
    for (float f2 = i9 / i5;; f2 = i8 / i4)
    {
      n = m;
      i1 = i7;
      i2 = j;
      i3 = i;
      if (!shouldResize(bool, i4, i5, i8, i9)) {
        break;
      }
      ((Matrix)localObject).preScale(f1, f2);
      n = m;
      i1 = i7;
      i2 = j;
      i3 = i;
      break;
      f1 = i9 / i5;
      break label498;
    }
  }
  
  static void updateThreadName(Request paramRequest)
  {
    paramRequest = paramRequest.getName();
    StringBuilder localStringBuilder = (StringBuilder)NAME_BUILDER.get();
    localStringBuilder.ensureCapacity("Picasso-".length() + paramRequest.length());
    localStringBuilder.replace("Picasso-".length(), localStringBuilder.length(), paramRequest);
    Thread.currentThread().setName(localStringBuilder.toString());
  }
  
  void attach(Action paramAction)
  {
    boolean bool = picasso.loggingEnabled;
    Request localRequest = request;
    if (action == null)
    {
      action = paramAction;
      if (bool)
      {
        if ((actions != null) && (!actions.isEmpty())) {
          break label65;
        }
        Utils.log("Hunter", "joined", localRequest.logId(), "to empty hunter");
      }
    }
    label65:
    do
    {
      return;
      Utils.log("Hunter", "joined", localRequest.logId(), Utils.getLogIdsForHunter(this, "to "));
      return;
      if (actions == null) {
        actions = new ArrayList(3);
      }
      actions.add(paramAction);
      if (bool) {
        Utils.log("Hunter", "joined", localRequest.logId(), Utils.getLogIdsForHunter(this, "to "));
      }
      paramAction = paramAction.getPriority();
    } while (paramAction.ordinal() <= priority.ordinal());
    priority = paramAction;
  }
  
  boolean cancel()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (action == null) {
      if (actions != null)
      {
        bool1 = bool2;
        if (!actions.isEmpty()) {}
      }
      else
      {
        bool1 = bool2;
        if (future != null)
        {
          bool1 = bool2;
          if (future.cancel(false)) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  void detach(Action paramAction)
  {
    boolean bool = false;
    if (action == paramAction)
    {
      action = null;
      bool = true;
    }
    for (;;)
    {
      if ((bool) && (paramAction.getPriority() == priority)) {
        priority = computeNewPriority();
      }
      if (picasso.loggingEnabled) {
        Utils.log("Hunter", "removed", request.logId(), Utils.getLogIdsForHunter(this, "from "));
      }
      return;
      if (actions != null) {
        bool = actions.remove(paramAction);
      }
    }
  }
  
  Action getAction()
  {
    return action;
  }
  
  List<Action> getActions()
  {
    return actions;
  }
  
  Request getData()
  {
    return data;
  }
  
  Exception getException()
  {
    return exception;
  }
  
  String getKey()
  {
    return key;
  }
  
  Picasso.LoadedFrom getLoadedFrom()
  {
    return loadedFrom;
  }
  
  int getMemoryPolicy()
  {
    return memoryPolicy;
  }
  
  Picasso getPicasso()
  {
    return picasso;
  }
  
  Picasso.Priority getPriority()
  {
    return priority;
  }
  
  Bitmap getResult()
  {
    return result;
  }
  
  Bitmap hunt()
    throws IOException
  {
    Object localObject1 = null;
    if (MemoryPolicy.shouldReadFromMemoryCache(memoryPolicy))
    {
      localObject4 = cache.get(key);
      localObject1 = localObject4;
      if (localObject4 != null)
      {
        stats.dispatchCacheHit();
        loadedFrom = Picasso.LoadedFrom.MEMORY;
        if (picasso.loggingEnabled) {
          Utils.log("Hunter", "decoded", data.logId(), "from cache");
        }
        return (Bitmap)localObject4;
      }
    }
    Object localObject4 = data;
    int i;
    if (retryCount == 0)
    {
      i = OFFLINEindex;
      label96:
      networkPolicy = i;
      ??? = requestHandler.load(data, networkPolicy);
      if (??? != null)
      {
        loadedFrom = ((RequestHandler.Result)???).getLoadedFrom();
        exifRotation = ((RequestHandler.Result)???).getExifOrientation();
        localObject4 = ((RequestHandler.Result)???).getBitmap();
        localObject1 = localObject4;
        if (localObject4 == null) {
          localObject4 = ((RequestHandler.Result)???).getStream();
        }
      }
    }
    try
    {
      localObject1 = decodeStream((InputStream)localObject4, data);
      Utils.closeQuietly((InputStream)localObject4);
      localObject4 = localObject1;
      if (localObject1 != null)
      {
        if (picasso.loggingEnabled) {
          Utils.log("Hunter", "decoded", data.logId());
        }
        stats.dispatchBitmapDecoded((Bitmap)localObject1);
        if (!data.needsTransformation())
        {
          localObject4 = localObject1;
          if (exifRotation == 0) {
            break label377;
          }
        }
      }
    }
    finally
    {
      synchronized (DECODE_LOCK)
      {
        if (!data.needsMatrixTransform())
        {
          localObject4 = localObject1;
          if (exifRotation == 0) {}
        }
        else
        {
          localObject1 = transformResult(data, (Bitmap)localObject1, exifRotation);
          localObject4 = localObject1;
          if (picasso.loggingEnabled)
          {
            Utils.log("Hunter", "transformed", data.logId());
            localObject4 = localObject1;
          }
        }
        localObject1 = localObject4;
        if (data.hasCustomTransformations())
        {
          localObject4 = applyCustomTransformations(data.transformations, (Bitmap)localObject4);
          localObject1 = localObject4;
          if (picasso.loggingEnabled)
          {
            Utils.log("Hunter", "transformed", data.logId(), "from custom transformations");
            localObject1 = localObject4;
          }
        }
        localObject4 = localObject1;
        if (localObject1 != null)
        {
          stats.dispatchBitmapTransformed((Bitmap)localObject1);
          localObject4 = localObject1;
        }
        label377:
        return (Bitmap)localObject4;
        i = networkPolicy;
        break label96;
        localObject2 = finally;
        Utils.closeQuietly((InputStream)localObject4);
        throw ((Throwable)localObject2);
      }
    }
  }
  
  boolean isCancelled()
  {
    return (future != null) && (future.isCancelled());
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 112	com/squareup/picasso/BitmapHunter:data	Lcom/squareup/picasso/Request;
    //   4: invokestatic 589	com/squareup/picasso/BitmapHunter:updateThreadName	(Lcom/squareup/picasso/Request;)V
    //   7: aload_0
    //   8: getfield 90	com/squareup/picasso/BitmapHunter:picasso	Lcom/squareup/picasso/Picasso;
    //   11: getfield 420	com/squareup/picasso/Picasso:loggingEnabled	Z
    //   14: ifeq +16 -> 30
    //   17: ldc_w 425
    //   20: ldc_w 591
    //   23: aload_0
    //   24: invokestatic 594	com/squareup/picasso/Utils:getLogIdsForHunter	(Lcom/squareup/picasso/BitmapHunter;)Ljava/lang/String;
    //   27: invokestatic 551	com/squareup/picasso/Utils:log	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   30: aload_0
    //   31: aload_0
    //   32: invokevirtual 596	com/squareup/picasso/BitmapHunter:hunt	()Landroid/graphics/Bitmap;
    //   35: putfield 487	com/squareup/picasso/BitmapHunter:result	Landroid/graphics/Bitmap;
    //   38: aload_0
    //   39: getfield 487	com/squareup/picasso/BitmapHunter:result	Landroid/graphics/Bitmap;
    //   42: ifnonnull +21 -> 63
    //   45: aload_0
    //   46: getfield 92	com/squareup/picasso/BitmapHunter:dispatcher	Lcom/squareup/picasso/Dispatcher;
    //   49: aload_0
    //   50: invokevirtual 602	com/squareup/picasso/Dispatcher:dispatchFailed	(Lcom/squareup/picasso/BitmapHunter;)V
    //   53: invokestatic 409	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   56: ldc_w 604
    //   59: invokevirtual 415	java/lang/Thread:setName	(Ljava/lang/String;)V
    //   62: return
    //   63: aload_0
    //   64: getfield 92	com/squareup/picasso/BitmapHunter:dispatcher	Lcom/squareup/picasso/Dispatcher;
    //   67: aload_0
    //   68: invokevirtual 607	com/squareup/picasso/Dispatcher:dispatchComplete	(Lcom/squareup/picasso/BitmapHunter;)V
    //   71: goto -18 -> 53
    //   74: astore_1
    //   75: aload_1
    //   76: getfield 610	com/squareup/picasso/Downloader$ResponseException:localCacheOnly	Z
    //   79: ifeq +13 -> 92
    //   82: aload_1
    //   83: getfield 613	com/squareup/picasso/Downloader$ResponseException:responseCode	I
    //   86: sipush 504
    //   89: if_icmpeq +8 -> 97
    //   92: aload_0
    //   93: aload_1
    //   94: putfield 477	com/squareup/picasso/BitmapHunter:exception	Ljava/lang/Exception;
    //   97: aload_0
    //   98: getfield 92	com/squareup/picasso/BitmapHunter:dispatcher	Lcom/squareup/picasso/Dispatcher;
    //   101: aload_0
    //   102: invokevirtual 602	com/squareup/picasso/Dispatcher:dispatchFailed	(Lcom/squareup/picasso/BitmapHunter;)V
    //   105: invokestatic 409	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   108: ldc_w 604
    //   111: invokevirtual 415	java/lang/Thread:setName	(Ljava/lang/String;)V
    //   114: return
    //   115: astore_1
    //   116: aload_0
    //   117: aload_1
    //   118: putfield 477	com/squareup/picasso/BitmapHunter:exception	Ljava/lang/Exception;
    //   121: aload_0
    //   122: getfield 92	com/squareup/picasso/BitmapHunter:dispatcher	Lcom/squareup/picasso/Dispatcher;
    //   125: aload_0
    //   126: invokevirtual 616	com/squareup/picasso/Dispatcher:dispatchRetry	(Lcom/squareup/picasso/BitmapHunter;)V
    //   129: invokestatic 409	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   132: ldc_w 604
    //   135: invokevirtual 415	java/lang/Thread:setName	(Ljava/lang/String;)V
    //   138: return
    //   139: astore_1
    //   140: aload_0
    //   141: aload_1
    //   142: putfield 477	com/squareup/picasso/BitmapHunter:exception	Ljava/lang/Exception;
    //   145: aload_0
    //   146: getfield 92	com/squareup/picasso/BitmapHunter:dispatcher	Lcom/squareup/picasso/Dispatcher;
    //   149: aload_0
    //   150: invokevirtual 616	com/squareup/picasso/Dispatcher:dispatchRetry	(Lcom/squareup/picasso/BitmapHunter;)V
    //   153: invokestatic 409	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   156: ldc_w 604
    //   159: invokevirtual 415	java/lang/Thread:setName	(Ljava/lang/String;)V
    //   162: return
    //   163: astore_1
    //   164: new 618	java/io/StringWriter
    //   167: dup
    //   168: invokespecial 619	java/io/StringWriter:<init>	()V
    //   171: astore_2
    //   172: aload_0
    //   173: getfield 96	com/squareup/picasso/BitmapHunter:stats	Lcom/squareup/picasso/Stats;
    //   176: invokevirtual 623	com/squareup/picasso/Stats:createSnapshot	()Lcom/squareup/picasso/StatsSnapshot;
    //   179: new 625	java/io/PrintWriter
    //   182: dup
    //   183: aload_2
    //   184: invokespecial 628	java/io/PrintWriter:<init>	(Ljava/io/Writer;)V
    //   187: invokevirtual 634	com/squareup/picasso/StatsSnapshot:dump	(Ljava/io/PrintWriter;)V
    //   190: aload_0
    //   191: new 141	java/lang/RuntimeException
    //   194: dup
    //   195: aload_2
    //   196: invokevirtual 635	java/io/StringWriter:toString	()Ljava/lang/String;
    //   199: aload_1
    //   200: invokespecial 638	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   203: putfield 477	com/squareup/picasso/BitmapHunter:exception	Ljava/lang/Exception;
    //   206: aload_0
    //   207: getfield 92	com/squareup/picasso/BitmapHunter:dispatcher	Lcom/squareup/picasso/Dispatcher;
    //   210: aload_0
    //   211: invokevirtual 602	com/squareup/picasso/Dispatcher:dispatchFailed	(Lcom/squareup/picasso/BitmapHunter;)V
    //   214: invokestatic 409	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   217: ldc_w 604
    //   220: invokevirtual 415	java/lang/Thread:setName	(Ljava/lang/String;)V
    //   223: return
    //   224: astore_1
    //   225: aload_0
    //   226: aload_1
    //   227: putfield 477	com/squareup/picasso/BitmapHunter:exception	Ljava/lang/Exception;
    //   230: aload_0
    //   231: getfield 92	com/squareup/picasso/BitmapHunter:dispatcher	Lcom/squareup/picasso/Dispatcher;
    //   234: aload_0
    //   235: invokevirtual 602	com/squareup/picasso/Dispatcher:dispatchFailed	(Lcom/squareup/picasso/BitmapHunter;)V
    //   238: invokestatic 409	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   241: ldc_w 604
    //   244: invokevirtual 415	java/lang/Thread:setName	(Ljava/lang/String;)V
    //   247: return
    //   248: astore_1
    //   249: invokestatic 409	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   252: ldc_w 604
    //   255: invokevirtual 415	java/lang/Thread:setName	(Ljava/lang/String;)V
    //   258: aload_1
    //   259: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	260	0	this	BitmapHunter
    //   74	20	1	localResponseException	Downloader.ResponseException
    //   115	3	1	localContentLengthException	NetworkRequestHandler.ContentLengthException
    //   139	3	1	localIOException	IOException
    //   163	37	1	localOutOfMemoryError	OutOfMemoryError
    //   224	3	1	localException	Exception
    //   248	11	1	localObject	Object
    //   171	25	2	localStringWriter	java.io.StringWriter
    // Exception table:
    //   from	to	target	type
    //   0	30	74	com/squareup/picasso/Downloader$ResponseException
    //   30	53	74	com/squareup/picasso/Downloader$ResponseException
    //   63	71	74	com/squareup/picasso/Downloader$ResponseException
    //   0	30	115	com/squareup/picasso/NetworkRequestHandler$ContentLengthException
    //   30	53	115	com/squareup/picasso/NetworkRequestHandler$ContentLengthException
    //   63	71	115	com/squareup/picasso/NetworkRequestHandler$ContentLengthException
    //   0	30	139	java/io/IOException
    //   30	53	139	java/io/IOException
    //   63	71	139	java/io/IOException
    //   0	30	163	java/lang/OutOfMemoryError
    //   30	53	163	java/lang/OutOfMemoryError
    //   63	71	163	java/lang/OutOfMemoryError
    //   0	30	224	java/lang/Exception
    //   30	53	224	java/lang/Exception
    //   63	71	224	java/lang/Exception
    //   0	30	248	finally
    //   30	53	248	finally
    //   63	71	248	finally
    //   75	92	248	finally
    //   92	97	248	finally
    //   97	105	248	finally
    //   116	129	248	finally
    //   140	153	248	finally
    //   164	214	248	finally
    //   225	238	248	finally
  }
  
  boolean shouldRetry(boolean paramBoolean, NetworkInfo paramNetworkInfo)
  {
    if (retryCount > 0) {}
    for (int i = 1; i == 0; i = 0) {
      return false;
    }
    retryCount -= 1;
    return requestHandler.shouldRetry(paramBoolean, paramNetworkInfo);
  }
  
  boolean supportsReplay()
  {
    return requestHandler.supportsReplay();
  }
}

/* Location:
 * Qualified Name:     com.squareup.picasso.BitmapHunter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */