package com.threatmetrix.TrustDefenderMobile;

import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

class TDConfiguration
{
  private static final String TAG = StringUtils.getLogTag(TDConfiguration.class);
  public long disableOptions = 0L;
  public long enableOptions = 0L;
  public final ArrayList<URI> ex_paths = new ArrayList();
  public final ArrayList<String> jb_paths = new ArrayList();
  public String w = "";
  
  private void parseEX(XmlPullParser paramXmlPullParser)
    throws XmlPullParserException, IOException
  {
    int i = paramXmlPullParser.next();
    Object localObject1 = "";
    Object localObject2;
    if (i != 1) {
      switch (i)
      {
      case 1: 
      default: 
        Log.d(TAG, "Found unexpected event type: " + i);
        localObject2 = localObject1;
      }
    }
    for (;;)
    {
      i = paramXmlPullParser.next();
      localObject1 = localObject2;
      break;
      Log.d(TAG, "Found start document tag unexpectedly");
      localObject2 = localObject1;
      continue;
      localObject2 = paramXmlPullParser.getName();
      continue;
      localObject2 = localObject1;
      if (paramXmlPullParser.getName().equals("EX"))
      {
        return;
        localObject2 = localObject1;
        if (localObject1 != null)
        {
          Object localObject3;
          if (((String)localObject1).equals("E"))
          {
            try
            {
              ex_paths.add(new URI(paramXmlPullParser.getText()));
              localObject2 = localObject1;
            }
            catch (URISyntaxException localURISyntaxException)
            {
              Log.e(TAG, "Failed to parse E into URI", localURISyntaxException);
              localObject3 = localObject1;
            }
          }
          else
          {
            Log.d(TAG, "Found tag content unexpectedly: " + (String)localObject1);
            localObject3 = localObject1;
          }
        }
      }
    }
  }
  
  private void parsePS(XmlPullParser paramXmlPullParser)
    throws XmlPullParserException, IOException
  {
    int i = paramXmlPullParser.next();
    Object localObject1 = "";
    Object localObject2;
    if (i != 1) {
      switch (i)
      {
      case 1: 
      default: 
        Log.d(TAG, "Found unexpected event type: " + i);
        localObject2 = localObject1;
      }
    }
    for (;;)
    {
      i = paramXmlPullParser.next();
      localObject1 = localObject2;
      break;
      Log.d(TAG, "Found start document tag unexpectedly");
      localObject2 = localObject1;
      continue;
      localObject2 = paramXmlPullParser.getName();
      continue;
      localObject2 = localObject1;
      if (paramXmlPullParser.getName().equals("PS"))
      {
        return;
        localObject2 = localObject1;
        if (localObject1 != null) {
          if (((String)localObject1).equals("P"))
          {
            jb_paths.add(paramXmlPullParser.getText());
            localObject2 = localObject1;
          }
          else
          {
            Log.d(TAG, "Found tag content unexpectedly: " + (String)localObject1);
            localObject2 = localObject1;
          }
        }
      }
    }
  }
  
  public boolean isUsable()
  {
    return (w != null) && (!w.isEmpty());
  }
  
  public void parseConfigFromStream(InputStream paramInputStream)
  {
    InputStream localInputStream = null;
    for (;;)
    {
      XmlPullParser localXmlPullParser;
      try
      {
        localXmlPullParser = XmlPullParserFactory.newInstance().newPullParser();
        localXmlPullParser.setInput(new InputStreamReader(paramInputStream));
        i = localXmlPullParser.getEventType();
      }
      catch (IOException paramInputStream)
      {
        Log.e(TAG, "IO Error", paramInputStream);
        return;
        if (!localXmlPullParser.getName().equals("EX")) {
          break label125;
        }
        parseEX(localXmlPullParser);
        paramInputStream = localInputStream;
        continue;
      }
      catch (XmlPullParserException paramInputStream)
      {
        Log.e(TAG, "XML Parse Error", paramInputStream);
        return;
      }
      int i = localXmlPullParser.next();
      localInputStream = paramInputStream;
      if (localXmlPullParser.getName().equals("PS"))
      {
        parsePS(localXmlPullParser);
        paramInputStream = localInputStream;
      }
      else
      {
        label125:
        paramInputStream = localXmlPullParser.getName();
        continue;
        paramInputStream = localInputStream;
        if (localInputStream != null) {
          if (localInputStream.equals("w"))
          {
            w = localXmlPullParser.getText();
            paramInputStream = localInputStream;
          }
          else if (localInputStream.equals("O"))
          {
            enableOptions = Long.valueOf(localXmlPullParser.getText()).longValue();
            paramInputStream = localInputStream;
          }
          else
          {
            paramInputStream = localInputStream;
            if (localInputStream.equals("D"))
            {
              disableOptions = Long.valueOf(localXmlPullParser.getText()).longValue();
              paramInputStream = localInputStream;
              continue;
              if (i != 1)
              {
                paramInputStream = localInputStream;
                switch (i)
                {
                case 0: 
                case 1: 
                case 2: 
                case 4: 
                default: 
                  paramInputStream = localInputStream;
                  break;
                case 3: 
                  paramInputStream = null;
                }
              }
            }
          }
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.threatmetrix.TrustDefenderMobile.TDConfiguration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */