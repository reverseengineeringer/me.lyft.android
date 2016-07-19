package com.leanplum;

import android.util.Log;
import com.leanplum.callbacks.StartCallback;
import org.json.JSONObject;

final class ai
  implements Runnable
{
  ai(ah paramah, JSONObject paramJSONObject, StartCallback paramStartCallback) {}
  
  public final void run()
  {
    JSONObject localJSONObject = T.b(a);
    if (T.c(localJSONObject)) {
      if (b != null) {
        b.onResponse(true);
      }
    }
    do
    {
      return;
      Log.e("Leanplum", T.d(localJSONObject));
    } while (b == null);
    b.onResponse(false);
  }
}

/* Location:
 * Qualified Name:     com.leanplum.ai
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */