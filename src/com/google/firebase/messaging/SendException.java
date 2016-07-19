package com.google.firebase.messaging;

import java.util.Locale;

public final class SendException
  extends Exception
{
  private final int zzbym = zzsk(paramString);
  
  SendException(String paramString)
  {
    super(paramString);
  }
  
  private int zzsk(String paramString)
  {
    if (paramString == null) {
      return 0;
    }
    paramString = paramString.toLowerCase(Locale.US);
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        return 0;
      case 0: 
      case 1: 
        return 1;
        if (paramString.equals("invalid_parameters"))
        {
          i = 0;
          continue;
          if (paramString.equals("missing_to"))
          {
            i = 1;
            continue;
            if (paramString.equals("messagetoobig"))
            {
              i = 2;
              continue;
              if (paramString.equals("service_not_available"))
              {
                i = 3;
                continue;
                if (paramString.equals("toomanymessages")) {
                  i = 4;
                }
              }
            }
          }
        }
        break;
      }
    }
    return 2;
    return 3;
    return 4;
  }
}

/* Location:
 * Qualified Name:     com.google.firebase.messaging.SendException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */