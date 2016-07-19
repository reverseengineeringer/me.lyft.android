package bolts;

import android.net.Uri;
import java.util.Collections;
import java.util.List;

public class AppLink
{
  private Uri sourceUrl;
  private List<Target> targets;
  private Uri webUrl;
  
  public AppLink(Uri paramUri1, List<Target> paramList, Uri paramUri2)
  {
    sourceUrl = paramUri1;
    paramUri1 = paramList;
    if (paramList == null) {
      paramUri1 = Collections.emptyList();
    }
    targets = paramUri1;
    webUrl = paramUri2;
  }
  
  public static class Target
  {
    private final String appName;
    private final String className;
    private final String packageName;
    private final Uri url;
    
    public Target(String paramString1, String paramString2, Uri paramUri, String paramString3)
    {
      packageName = paramString1;
      className = paramString2;
      url = paramUri;
      appName = paramString3;
    }
  }
}

/* Location:
 * Qualified Name:     bolts.AppLink
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */