package me.lyft.android.infrastructure.gcm;

import com.google.firebase.iid.FirebaseInstanceId;

public class GcmIdService
  implements IGcmIdService
{
  public String getToken()
  {
    return FirebaseInstanceId.getInstance().getToken();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.gcm.GcmIdService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */