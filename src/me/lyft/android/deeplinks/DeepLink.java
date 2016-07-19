package me.lyft.android.deeplinks;

import android.net.Uri;
import java.util.Map;
import me.lyft.android.common.UriParser;

public class DeepLink
{
  final String action;
  final Map<String, String> params;
  final Uri uri;
  
  public DeepLink(Uri paramUri)
  {
    uri = paramUri;
    action = paramUri.getHost();
    params = UriParser.parseParamsFromUri(paramUri.toString());
  }
  
  public DeepLink(String paramString)
  {
    this(Uri.parse(paramString));
  }
  
  public String getAction()
  {
    return action;
  }
  
  public String getParam(String paramString)
  {
    return (String)params.get(paramString);
  }
  
  public String toString()
  {
    return uri.toString();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.deeplinks.DeepLink
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */