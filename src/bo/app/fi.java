package bo.app;

import android.net.Uri;
import com.appboy.Constants;
import com.appboy.support.AppboyLogger;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public final class fi
{
  private static final String a = String.format("%s.%s", new Object[] { Constants.APPBOY_LOG_TAG_PREFIX, fi.class.getName() });
  
  public static URI a(Uri paramUri)
  {
    try
    {
      URI localURI = new URI(paramUri.toString());
      return localURI;
    }
    catch (URISyntaxException localURISyntaxException)
    {
      AppboyLogger.e(a, String.format("Could not create URI from uri [%s]", new Object[] { paramUri.toString() }));
    }
    return null;
  }
  
  public static URL a(URI paramURI)
  {
    try
    {
      paramURI = new URL(paramURI.toString());
      return paramURI;
    }
    catch (MalformedURLException paramURI)
    {
      AppboyLogger.e(a, String.format("Unable to parse URI [%s]", new Object[] { paramURI.getMessage() }));
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     bo.app.fi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */