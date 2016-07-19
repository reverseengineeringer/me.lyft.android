package com.squareup.picasso;

import android.graphics.Bitmap.Config;
import android.net.Uri;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public final class Request
{
  private static final long TOO_LONG_LOG = TimeUnit.SECONDS.toNanos(5L);
  public final boolean centerCrop;
  public final boolean centerInside;
  public final Bitmap.Config config;
  public final boolean hasRotationPivot;
  int id;
  int networkPolicy;
  public final boolean onlyScaleDown;
  public final Picasso.Priority priority;
  public final int resourceId;
  public final float rotationDegrees;
  public final float rotationPivotX;
  public final float rotationPivotY;
  public final String stableKey;
  long started;
  public final int targetHeight;
  public final int targetWidth;
  public final List<Transformation> transformations;
  public final Uri uri;
  
  private Request(Uri paramUri, int paramInt1, String paramString, List<Transformation> paramList, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, float paramFloat1, float paramFloat2, float paramFloat3, boolean paramBoolean4, Bitmap.Config paramConfig, Picasso.Priority paramPriority)
  {
    uri = paramUri;
    resourceId = paramInt1;
    stableKey = paramString;
    if (paramList == null) {}
    for (transformations = null;; transformations = Collections.unmodifiableList(paramList))
    {
      targetWidth = paramInt2;
      targetHeight = paramInt3;
      centerCrop = paramBoolean1;
      centerInside = paramBoolean2;
      onlyScaleDown = paramBoolean3;
      rotationDegrees = paramFloat1;
      rotationPivotX = paramFloat2;
      rotationPivotY = paramFloat3;
      hasRotationPivot = paramBoolean4;
      config = paramConfig;
      priority = paramPriority;
      return;
    }
  }
  
  public Builder buildUpon()
  {
    return new Builder(this, null);
  }
  
  String getName()
  {
    if (uri != null) {
      return String.valueOf(uri.getPath());
    }
    return Integer.toHexString(resourceId);
  }
  
  boolean hasCustomTransformations()
  {
    return transformations != null;
  }
  
  public boolean hasSize()
  {
    return (targetWidth != 0) || (targetHeight != 0);
  }
  
  String logId()
  {
    long l = System.nanoTime() - started;
    if (l > TOO_LONG_LOG) {
      return plainId() + '+' + TimeUnit.NANOSECONDS.toSeconds(l) + 's';
    }
    return plainId() + '+' + TimeUnit.NANOSECONDS.toMillis(l) + "ms";
  }
  
  boolean needsMatrixTransform()
  {
    return (hasSize()) || (rotationDegrees != 0.0F);
  }
  
  boolean needsTransformation()
  {
    return (needsMatrixTransform()) || (hasCustomTransformations());
  }
  
  String plainId()
  {
    return "[R" + id + ']';
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("Request{");
    if (resourceId > 0) {
      localStringBuilder.append(resourceId);
    }
    while ((transformations != null) && (!transformations.isEmpty()))
    {
      Iterator localIterator = transformations.iterator();
      while (localIterator.hasNext())
      {
        Transformation localTransformation = (Transformation)localIterator.next();
        localStringBuilder.append(' ').append(localTransformation.key());
      }
      localStringBuilder.append(uri);
    }
    if (stableKey != null) {
      localStringBuilder.append(" stableKey(").append(stableKey).append(')');
    }
    if (targetWidth > 0) {
      localStringBuilder.append(" resize(").append(targetWidth).append(',').append(targetHeight).append(')');
    }
    if (centerCrop) {
      localStringBuilder.append(" centerCrop");
    }
    if (centerInside) {
      localStringBuilder.append(" centerInside");
    }
    if (rotationDegrees != 0.0F)
    {
      localStringBuilder.append(" rotation(").append(rotationDegrees);
      if (hasRotationPivot) {
        localStringBuilder.append(" @ ").append(rotationPivotX).append(',').append(rotationPivotY);
      }
      localStringBuilder.append(')');
    }
    if (config != null) {
      localStringBuilder.append(' ').append(config);
    }
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public static final class Builder
  {
    private boolean centerCrop;
    private boolean centerInside;
    private Bitmap.Config config;
    private boolean hasRotationPivot;
    private boolean onlyScaleDown;
    private Picasso.Priority priority;
    private int resourceId;
    private float rotationDegrees;
    private float rotationPivotX;
    private float rotationPivotY;
    private String stableKey;
    private int targetHeight;
    private int targetWidth;
    private List<Transformation> transformations;
    private Uri uri;
    
    public Builder(int paramInt)
    {
      setResourceId(paramInt);
    }
    
    public Builder(Uri paramUri)
    {
      setUri(paramUri);
    }
    
    Builder(Uri paramUri, int paramInt, Bitmap.Config paramConfig)
    {
      uri = paramUri;
      resourceId = paramInt;
      config = paramConfig;
    }
    
    private Builder(Request paramRequest)
    {
      uri = uri;
      resourceId = resourceId;
      stableKey = stableKey;
      targetWidth = targetWidth;
      targetHeight = targetHeight;
      centerCrop = centerCrop;
      centerInside = centerInside;
      rotationDegrees = rotationDegrees;
      rotationPivotX = rotationPivotX;
      rotationPivotY = rotationPivotY;
      hasRotationPivot = hasRotationPivot;
      onlyScaleDown = onlyScaleDown;
      if (transformations != null) {
        transformations = new ArrayList(transformations);
      }
      config = config;
      priority = priority;
    }
    
    public Request build()
    {
      if ((centerInside) && (centerCrop)) {
        throw new IllegalStateException("Center crop and center inside can not be used together.");
      }
      if ((centerCrop) && (targetWidth == 0) && (targetHeight == 0)) {
        throw new IllegalStateException("Center crop requires calling resize with positive width and height.");
      }
      if ((centerInside) && (targetWidth == 0) && (targetHeight == 0)) {
        throw new IllegalStateException("Center inside requires calling resize with positive width and height.");
      }
      if (priority == null) {
        priority = Picasso.Priority.NORMAL;
      }
      return new Request(uri, resourceId, stableKey, transformations, targetWidth, targetHeight, centerCrop, centerInside, onlyScaleDown, rotationDegrees, rotationPivotX, rotationPivotY, hasRotationPivot, config, priority, null);
    }
    
    public Builder centerCrop()
    {
      if (centerInside) {
        throw new IllegalStateException("Center crop can not be used after calling centerInside");
      }
      centerCrop = true;
      return this;
    }
    
    public Builder centerInside()
    {
      if (centerCrop) {
        throw new IllegalStateException("Center inside can not be used after calling centerCrop");
      }
      centerInside = true;
      return this;
    }
    
    public Builder clearCenterCrop()
    {
      centerCrop = false;
      return this;
    }
    
    public Builder clearCenterInside()
    {
      centerInside = false;
      return this;
    }
    
    public Builder clearOnlyScaleDown()
    {
      onlyScaleDown = false;
      return this;
    }
    
    public Builder clearResize()
    {
      targetWidth = 0;
      targetHeight = 0;
      centerCrop = false;
      centerInside = false;
      return this;
    }
    
    public Builder clearRotation()
    {
      rotationDegrees = 0.0F;
      rotationPivotX = 0.0F;
      rotationPivotY = 0.0F;
      hasRotationPivot = false;
      return this;
    }
    
    public Builder config(Bitmap.Config paramConfig)
    {
      config = paramConfig;
      return this;
    }
    
    boolean hasImage()
    {
      return (uri != null) || (resourceId != 0);
    }
    
    boolean hasPriority()
    {
      return priority != null;
    }
    
    boolean hasSize()
    {
      return (targetWidth != 0) || (targetHeight != 0);
    }
    
    public Builder onlyScaleDown()
    {
      if ((targetHeight == 0) && (targetWidth == 0)) {
        throw new IllegalStateException("onlyScaleDown can not be applied without resize");
      }
      onlyScaleDown = true;
      return this;
    }
    
    public Builder priority(Picasso.Priority paramPriority)
    {
      if (paramPriority == null) {
        throw new IllegalArgumentException("Priority invalid.");
      }
      if (priority != null) {
        throw new IllegalStateException("Priority already set.");
      }
      priority = paramPriority;
      return this;
    }
    
    public Builder resize(int paramInt1, int paramInt2)
    {
      if (paramInt1 < 0) {
        throw new IllegalArgumentException("Width must be positive number or 0.");
      }
      if (paramInt2 < 0) {
        throw new IllegalArgumentException("Height must be positive number or 0.");
      }
      if ((paramInt2 == 0) && (paramInt1 == 0)) {
        throw new IllegalArgumentException("At least one dimension has to be positive number.");
      }
      targetWidth = paramInt1;
      targetHeight = paramInt2;
      return this;
    }
    
    public Builder rotate(float paramFloat)
    {
      rotationDegrees = paramFloat;
      return this;
    }
    
    public Builder rotate(float paramFloat1, float paramFloat2, float paramFloat3)
    {
      rotationDegrees = paramFloat1;
      rotationPivotX = paramFloat2;
      rotationPivotY = paramFloat3;
      hasRotationPivot = true;
      return this;
    }
    
    public Builder setResourceId(int paramInt)
    {
      if (paramInt == 0) {
        throw new IllegalArgumentException("Image resource ID may not be 0.");
      }
      resourceId = paramInt;
      uri = null;
      return this;
    }
    
    public Builder setUri(Uri paramUri)
    {
      if (paramUri == null) {
        throw new IllegalArgumentException("Image URI may not be null.");
      }
      uri = paramUri;
      resourceId = 0;
      return this;
    }
    
    public Builder stableKey(String paramString)
    {
      stableKey = paramString;
      return this;
    }
    
    public Builder transform(Transformation paramTransformation)
    {
      if (paramTransformation == null) {
        throw new IllegalArgumentException("Transformation must not be null.");
      }
      if (paramTransformation.key() == null) {
        throw new IllegalArgumentException("Transformation key must not be null.");
      }
      if (transformations == null) {
        transformations = new ArrayList(2);
      }
      transformations.add(paramTransformation);
      return this;
    }
    
    public Builder transform(List<? extends Transformation> paramList)
    {
      if (paramList == null) {
        throw new IllegalArgumentException("Transformation list must not be null.");
      }
      int i = 0;
      int j = paramList.size();
      while (i < j)
      {
        transform((Transformation)paramList.get(i));
        i += 1;
      }
      return this;
    }
  }
}

/* Location:
 * Qualified Name:     com.squareup.picasso.Request
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */