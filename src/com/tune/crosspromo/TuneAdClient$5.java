package com.tune.crosspromo;

import android.net.Uri;
import android.net.Uri.Builder;
import org.json.JSONObject;

final class TuneAdClient$5
  implements Runnable
{
  TuneAdClient$5(TuneAdView paramTuneAdView, JSONObject paramJSONObject) {}
  
  public void run()
  {
    if (TuneAdClient.access$000()) {}
    for (Uri.Builder localBuilder = Uri.parse("http://" + TuneAdClient.access$100() + "/api/v1/ads/event").buildUpon();; localBuilder = Uri.parse("https://" + TuneAdClient.access$200() + ".event." + TuneAdClient.access$100() + "/event").buildUpon())
    {
      localBuilder.appendQueryParameter("action", "close").appendQueryParameter("requestId", val$adView.requestId);
      TuneAdClient.access$300(localBuilder.build().toString(), val$adParams);
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.tune.crosspromo.TuneAdClient.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */