package com.facebook.messenger;

import android.net.Uri;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ShareToMessengerParams
{
  public static final Set<String> VALID_EXTERNAL_URI_SCHEMES;
  public static final Set<String> VALID_MIME_TYPES;
  public static final Set<String> VALID_URI_SCHEMES;
  public final Uri externalUri;
  public final String metaData;
  public final String mimeType;
  public final Uri uri;
  
  static
  {
    HashSet localHashSet = new HashSet();
    localHashSet.add("image/*");
    localHashSet.add("image/jpeg");
    localHashSet.add("image/png");
    localHashSet.add("image/gif");
    localHashSet.add("image/webp");
    localHashSet.add("video/*");
    localHashSet.add("video/mp4");
    localHashSet.add("audio/*");
    localHashSet.add("audio/mpeg");
    VALID_MIME_TYPES = Collections.unmodifiableSet(localHashSet);
    localHashSet = new HashSet();
    localHashSet.add("content");
    localHashSet.add("android.resource");
    localHashSet.add("file");
    VALID_URI_SCHEMES = Collections.unmodifiableSet(localHashSet);
    localHashSet = new HashSet();
    localHashSet.add("http");
    localHashSet.add("https");
    VALID_EXTERNAL_URI_SCHEMES = Collections.unmodifiableSet(localHashSet);
  }
  
  ShareToMessengerParams(ShareToMessengerParamsBuilder paramShareToMessengerParamsBuilder)
  {
    uri = paramShareToMessengerParamsBuilder.getUri();
    mimeType = paramShareToMessengerParamsBuilder.getMimeType();
    metaData = paramShareToMessengerParamsBuilder.getMetaData();
    externalUri = paramShareToMessengerParamsBuilder.getExternalUri();
    if (uri == null) {
      throw new NullPointerException("Must provide non-null uri");
    }
    if (mimeType == null) {
      throw new NullPointerException("Must provide mimeType");
    }
    if (!VALID_URI_SCHEMES.contains(uri.getScheme())) {
      throw new IllegalArgumentException("Unsupported URI scheme: " + uri.getScheme());
    }
    if (!VALID_MIME_TYPES.contains(mimeType)) {
      throw new IllegalArgumentException("Unsupported mime-type: " + mimeType);
    }
    if ((externalUri != null) && (!VALID_EXTERNAL_URI_SCHEMES.contains(externalUri.getScheme()))) {
      throw new IllegalArgumentException("Unsupported external uri scheme: " + externalUri.getScheme());
    }
  }
  
  public static ShareToMessengerParamsBuilder newBuilder(Uri paramUri, String paramString)
  {
    return new ShareToMessengerParamsBuilder(paramUri, paramString);
  }
}

/* Location:
 * Qualified Name:     com.facebook.messenger.ShareToMessengerParams
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */