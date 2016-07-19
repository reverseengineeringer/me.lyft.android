package com.devicecollector.collectors;

import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;

class WebCollectorTask$1$2
  extends WebChromeClient
{
  WebCollectorTask$1$2(WebCollectorTask.1 param1) {}
  
  public boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
  {
    return WebCollectorTask.access$600(this$1.this$0, paramConsoleMessage);
  }
}

/* Location:
 * Qualified Name:     com.devicecollector.collectors.WebCollectorTask.1.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */