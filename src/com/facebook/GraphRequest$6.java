package com.facebook;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Locale;

class GraphRequest$6
  implements GraphRequest.KeyValueSerializer
{
  GraphRequest$6(GraphRequest paramGraphRequest, ArrayList paramArrayList) {}
  
  public void writeString(String paramString1, String paramString2)
    throws IOException
  {
    val$keysAndValues.add(String.format(Locale.US, "%s=%s", new Object[] { paramString1, URLEncoder.encode(paramString2, "UTF-8") }));
  }
}

/* Location:
 * Qualified Name:     com.facebook.GraphRequest.6
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */