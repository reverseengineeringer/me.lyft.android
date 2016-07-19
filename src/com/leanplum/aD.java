package com.leanplum;

import android.app.AlertDialog.Builder;

final class ad
  implements Runnable
{
  ad(aP paramaP, String paramString) {}
  
  public final void run()
  {
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(LeanplumActivityHelper.b);
    localBuilder.setTitle("Leanplum");
    localBuilder.setMessage("Your device is registered to " + a + ".");
    localBuilder.setPositiveButton("OK", new ae(this));
    localBuilder.show();
  }
}

/* Location:
 * Qualified Name:     com.leanplum.ad
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */