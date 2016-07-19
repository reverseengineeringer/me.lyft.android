package com.kochava.android.tracker;

import com.kochava.android.util.Logging;

class Feature$4
  extends Thread
{
  Feature$4(Feature paramFeature) {}
  
  public void run()
  {
    try
    {
      Feature.access$102(Feature.access$200(this$0));
      Logging.Log("ADID retrevial finished and gathered if available.");
      return;
    }
    catch (Error localError)
    {
      Logging.LogError("*****NOTICE***** \nAn error has occured when trying to gather the Google Advertising Id. Please make sure you have the Google Play Services Library integrated in your app! \n*****NOTICE*****");
      Logging.LogError("" + localError.toString());
    }
  }
}

/* Location:
 * Qualified Name:     com.kochava.android.tracker.Feature.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */