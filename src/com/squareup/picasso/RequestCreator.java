package com.squareup.picasso;

import android.app.Notification;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import android.widget.RemoteViews;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class RequestCreator
{
  private static final AtomicInteger nextId = new AtomicInteger();
  private final Request.Builder data;
  private boolean deferred;
  private Drawable errorDrawable;
  private int errorResId;
  private int memoryPolicy;
  private int networkPolicy;
  private boolean noFade;
  private final Picasso picasso;
  private Drawable placeholderDrawable;
  private int placeholderResId;
  private boolean setPlaceholder = true;
  private Object tag;
  
  RequestCreator()
  {
    picasso = null;
    data = new Request.Builder(null, 0, null);
  }
  
  RequestCreator(Picasso paramPicasso, Uri paramUri, int paramInt)
  {
    if (shutdown) {
      throw new IllegalStateException("Picasso instance already shut down. Cannot submit new requests.");
    }
    picasso = paramPicasso;
    data = new Request.Builder(paramUri, paramInt, defaultBitmapConfig);
  }
  
  private Request createRequest(long paramLong)
  {
    int i = nextId.getAndIncrement();
    Request localRequest1 = data.build();
    id = i;
    started = paramLong;
    boolean bool = picasso.loggingEnabled;
    if (bool) {
      Utils.log("Main", "created", localRequest1.plainId(), localRequest1.toString());
    }
    Request localRequest2 = picasso.transformRequest(localRequest1);
    if (localRequest2 != localRequest1)
    {
      id = i;
      started = paramLong;
      if (bool) {
        Utils.log("Main", "changed", localRequest2.logId(), "into " + localRequest2);
      }
    }
    return localRequest2;
  }
  
  private Drawable getPlaceholderDrawable()
  {
    if (placeholderResId != 0) {
      return picasso.context.getResources().getDrawable(placeholderResId);
    }
    return placeholderDrawable;
  }
  
  private void performRemoteViewInto(RemoteViewsAction paramRemoteViewsAction)
  {
    if (MemoryPolicy.shouldReadFromMemoryCache(memoryPolicy))
    {
      Bitmap localBitmap = picasso.quickMemoryCacheCheck(paramRemoteViewsAction.getKey());
      if (localBitmap != null)
      {
        paramRemoteViewsAction.complete(localBitmap, Picasso.LoadedFrom.MEMORY);
        return;
      }
    }
    if (placeholderResId != 0) {
      paramRemoteViewsAction.setImageResource(placeholderResId);
    }
    picasso.enqueueAndSubmit(paramRemoteViewsAction);
  }
  
  public RequestCreator centerCrop()
  {
    data.centerCrop();
    return this;
  }
  
  public RequestCreator centerInside()
  {
    data.centerInside();
    return this;
  }
  
  public RequestCreator config(Bitmap.Config paramConfig)
  {
    data.config(paramConfig);
    return this;
  }
  
  public RequestCreator error(int paramInt)
  {
    if (paramInt == 0) {
      throw new IllegalArgumentException("Error image resource invalid.");
    }
    if (errorDrawable != null) {
      throw new IllegalStateException("Error image already set.");
    }
    errorResId = paramInt;
    return this;
  }
  
  public RequestCreator error(Drawable paramDrawable)
  {
    if (paramDrawable == null) {
      throw new IllegalArgumentException("Error image may not be null.");
    }
    if (errorResId != 0) {
      throw new IllegalStateException("Error image already set.");
    }
    errorDrawable = paramDrawable;
    return this;
  }
  
  public void fetch()
  {
    fetch(null);
  }
  
  public void fetch(Callback paramCallback)
  {
    long l = System.nanoTime();
    if (deferred) {
      throw new IllegalStateException("Fit cannot be used with fetch.");
    }
    Request localRequest;
    String str;
    if (data.hasImage())
    {
      if (!data.hasPriority()) {
        data.priority(Picasso.Priority.LOW);
      }
      localRequest = createRequest(l);
      str = Utils.createKey(localRequest, new StringBuilder());
      if (picasso.quickMemoryCacheCheck(str) == null) {
        break label139;
      }
      if (picasso.loggingEnabled) {
        Utils.log("Main", "completed", localRequest.plainId(), "from " + Picasso.LoadedFrom.MEMORY);
      }
      if (paramCallback != null) {
        paramCallback.onSuccess();
      }
    }
    return;
    label139:
    paramCallback = new FetchAction(picasso, localRequest, memoryPolicy, networkPolicy, tag, str, paramCallback);
    picasso.submit(paramCallback);
  }
  
  public RequestCreator fit()
  {
    deferred = true;
    return this;
  }
  
  public Bitmap get()
    throws IOException
  {
    long l = System.nanoTime();
    Utils.checkNotMain();
    if (deferred) {
      throw new IllegalStateException("Fit cannot be used with get.");
    }
    if (!data.hasImage()) {
      return null;
    }
    Object localObject = createRequest(l);
    String str = Utils.createKey((Request)localObject, new StringBuilder());
    localObject = new GetAction(picasso, (Request)localObject, memoryPolicy, networkPolicy, tag, str);
    return BitmapHunter.forRequest(picasso, picasso.dispatcher, picasso.cache, picasso.stats, (Action)localObject).hunt();
  }
  
  public void into(ImageView paramImageView)
  {
    into(paramImageView, null);
  }
  
  public void into(ImageView paramImageView, Callback paramCallback)
  {
    long l = System.nanoTime();
    Utils.checkMain();
    if (paramImageView == null) {
      throw new IllegalArgumentException("Target must not be null.");
    }
    if (!data.hasImage())
    {
      picasso.cancelRequest(paramImageView);
      if (setPlaceholder) {
        PicassoDrawable.setPlaceholder(paramImageView, getPlaceholderDrawable());
      }
    }
    Request localRequest;
    String str;
    do
    {
      return;
      if (deferred)
      {
        if (data.hasSize()) {
          throw new IllegalStateException("Fit cannot be used with resize.");
        }
        int i = paramImageView.getWidth();
        int j = paramImageView.getHeight();
        if ((i == 0) || (j == 0))
        {
          if (setPlaceholder) {
            PicassoDrawable.setPlaceholder(paramImageView, getPlaceholderDrawable());
          }
          picasso.defer(paramImageView, new DeferredRequestCreator(this, paramImageView, paramCallback));
          return;
        }
        data.resize(i, j);
      }
      localRequest = createRequest(l);
      str = Utils.createKey(localRequest);
      if (!MemoryPolicy.shouldReadFromMemoryCache(memoryPolicy)) {
        break;
      }
      Bitmap localBitmap = picasso.quickMemoryCacheCheck(str);
      if (localBitmap == null) {
        break;
      }
      picasso.cancelRequest(paramImageView);
      PicassoDrawable.setBitmap(paramImageView, picasso.context, localBitmap, Picasso.LoadedFrom.MEMORY, noFade, picasso.indicatorsEnabled);
      if (picasso.loggingEnabled) {
        Utils.log("Main", "completed", localRequest.plainId(), "from " + Picasso.LoadedFrom.MEMORY);
      }
    } while (paramCallback == null);
    paramCallback.onSuccess();
    return;
    if (setPlaceholder) {
      PicassoDrawable.setPlaceholder(paramImageView, getPlaceholderDrawable());
    }
    paramImageView = new ImageViewAction(picasso, paramImageView, localRequest, memoryPolicy, networkPolicy, errorResId, errorDrawable, str, tag, paramCallback, noFade);
    picasso.enqueueAndSubmit(paramImageView);
  }
  
  public void into(RemoteViews paramRemoteViews, int paramInt1, int paramInt2, Notification paramNotification)
  {
    long l = System.nanoTime();
    if (paramRemoteViews == null) {
      throw new IllegalArgumentException("RemoteViews must not be null.");
    }
    if (paramNotification == null) {
      throw new IllegalArgumentException("Notification must not be null.");
    }
    if (deferred) {
      throw new IllegalStateException("Fit cannot be used with RemoteViews.");
    }
    if ((placeholderDrawable != null) || (placeholderResId != 0) || (errorDrawable != null)) {
      throw new IllegalArgumentException("Cannot use placeholder or error drawables with remote views.");
    }
    Request localRequest = createRequest(l);
    String str = Utils.createKey(localRequest, new StringBuilder());
    performRemoteViewInto(new RemoteViewsAction.NotificationAction(picasso, localRequest, paramRemoteViews, paramInt1, paramInt2, paramNotification, memoryPolicy, networkPolicy, str, tag, errorResId));
  }
  
  public void into(RemoteViews paramRemoteViews, int paramInt, int[] paramArrayOfInt)
  {
    long l = System.nanoTime();
    if (paramRemoteViews == null) {
      throw new IllegalArgumentException("remoteViews must not be null.");
    }
    if (paramArrayOfInt == null) {
      throw new IllegalArgumentException("appWidgetIds must not be null.");
    }
    if (deferred) {
      throw new IllegalStateException("Fit cannot be used with remote views.");
    }
    if ((placeholderDrawable != null) || (placeholderResId != 0) || (errorDrawable != null)) {
      throw new IllegalArgumentException("Cannot use placeholder or error drawables with remote views.");
    }
    Request localRequest = createRequest(l);
    String str = Utils.createKey(localRequest, new StringBuilder());
    performRemoteViewInto(new RemoteViewsAction.AppWidgetAction(picasso, localRequest, paramRemoteViews, paramInt, paramArrayOfInt, memoryPolicy, networkPolicy, str, tag, errorResId));
  }
  
  public void into(Target paramTarget)
  {
    Object localObject = null;
    Request localRequest = null;
    long l = System.nanoTime();
    Utils.checkMain();
    if (paramTarget == null) {
      throw new IllegalArgumentException("Target must not be null.");
    }
    if (deferred) {
      throw new IllegalStateException("Fit cannot be used with a Target.");
    }
    if (!data.hasImage())
    {
      picasso.cancelRequest(paramTarget);
      localObject = localRequest;
      if (setPlaceholder) {
        localObject = getPlaceholderDrawable();
      }
      paramTarget.onPrepareLoad((Drawable)localObject);
      return;
    }
    localRequest = createRequest(l);
    String str = Utils.createKey(localRequest);
    if (MemoryPolicy.shouldReadFromMemoryCache(memoryPolicy))
    {
      Bitmap localBitmap = picasso.quickMemoryCacheCheck(str);
      if (localBitmap != null)
      {
        picasso.cancelRequest(paramTarget);
        paramTarget.onBitmapLoaded(localBitmap, Picasso.LoadedFrom.MEMORY);
        return;
      }
    }
    if (setPlaceholder) {
      localObject = getPlaceholderDrawable();
    }
    paramTarget.onPrepareLoad((Drawable)localObject);
    paramTarget = new TargetAction(picasso, paramTarget, localRequest, memoryPolicy, networkPolicy, errorDrawable, str, tag, errorResId);
    picasso.enqueueAndSubmit(paramTarget);
  }
  
  public RequestCreator memoryPolicy(MemoryPolicy paramMemoryPolicy, MemoryPolicy... paramVarArgs)
  {
    if (paramMemoryPolicy == null) {
      throw new IllegalArgumentException("Memory policy cannot be null.");
    }
    memoryPolicy |= index;
    if (paramVarArgs == null) {
      throw new IllegalArgumentException("Memory policy cannot be null.");
    }
    if (paramVarArgs.length > 0)
    {
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        paramMemoryPolicy = paramVarArgs[i];
        if (paramMemoryPolicy == null) {
          throw new IllegalArgumentException("Memory policy cannot be null.");
        }
        memoryPolicy |= index;
        i += 1;
      }
    }
    return this;
  }
  
  public RequestCreator networkPolicy(NetworkPolicy paramNetworkPolicy, NetworkPolicy... paramVarArgs)
  {
    if (paramNetworkPolicy == null) {
      throw new IllegalArgumentException("Network policy cannot be null.");
    }
    networkPolicy |= index;
    if (paramVarArgs == null) {
      throw new IllegalArgumentException("Network policy cannot be null.");
    }
    if (paramVarArgs.length > 0)
    {
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        paramNetworkPolicy = paramVarArgs[i];
        if (paramNetworkPolicy == null) {
          throw new IllegalArgumentException("Network policy cannot be null.");
        }
        networkPolicy |= index;
        i += 1;
      }
    }
    return this;
  }
  
  public RequestCreator noFade()
  {
    noFade = true;
    return this;
  }
  
  public RequestCreator noPlaceholder()
  {
    if (placeholderResId != 0) {
      throw new IllegalStateException("Placeholder resource already set.");
    }
    if (placeholderDrawable != null) {
      throw new IllegalStateException("Placeholder image already set.");
    }
    setPlaceholder = false;
    return this;
  }
  
  public RequestCreator onlyScaleDown()
  {
    data.onlyScaleDown();
    return this;
  }
  
  public RequestCreator placeholder(int paramInt)
  {
    if (!setPlaceholder) {
      throw new IllegalStateException("Already explicitly declared as no placeholder.");
    }
    if (paramInt == 0) {
      throw new IllegalArgumentException("Placeholder image resource invalid.");
    }
    if (placeholderDrawable != null) {
      throw new IllegalStateException("Placeholder image already set.");
    }
    placeholderResId = paramInt;
    return this;
  }
  
  public RequestCreator placeholder(Drawable paramDrawable)
  {
    if (!setPlaceholder) {
      throw new IllegalStateException("Already explicitly declared as no placeholder.");
    }
    if (placeholderResId != 0) {
      throw new IllegalStateException("Placeholder image already set.");
    }
    placeholderDrawable = paramDrawable;
    return this;
  }
  
  public RequestCreator priority(Picasso.Priority paramPriority)
  {
    data.priority(paramPriority);
    return this;
  }
  
  public RequestCreator resize(int paramInt1, int paramInt2)
  {
    data.resize(paramInt1, paramInt2);
    return this;
  }
  
  public RequestCreator resizeDimen(int paramInt1, int paramInt2)
  {
    Resources localResources = picasso.context.getResources();
    return resize(localResources.getDimensionPixelSize(paramInt1), localResources.getDimensionPixelSize(paramInt2));
  }
  
  public RequestCreator rotate(float paramFloat)
  {
    data.rotate(paramFloat);
    return this;
  }
  
  public RequestCreator rotate(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    data.rotate(paramFloat1, paramFloat2, paramFloat3);
    return this;
  }
  
  @Deprecated
  public RequestCreator skipMemoryCache()
  {
    return memoryPolicy(MemoryPolicy.NO_CACHE, new MemoryPolicy[] { MemoryPolicy.NO_STORE });
  }
  
  public RequestCreator stableKey(String paramString)
  {
    data.stableKey(paramString);
    return this;
  }
  
  public RequestCreator tag(Object paramObject)
  {
    if (paramObject == null) {
      throw new IllegalArgumentException("Tag invalid.");
    }
    if (tag != null) {
      throw new IllegalStateException("Tag already set.");
    }
    tag = paramObject;
    return this;
  }
  
  public RequestCreator transform(Transformation paramTransformation)
  {
    data.transform(paramTransformation);
    return this;
  }
  
  public RequestCreator transform(List<? extends Transformation> paramList)
  {
    data.transform(paramList);
    return this;
  }
  
  RequestCreator unfit()
  {
    deferred = false;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.squareup.picasso.RequestCreator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */