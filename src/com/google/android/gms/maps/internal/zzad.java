package com.google.android.gms.maps.internal;

import android.os.Bundle;
import android.os.Parcelable;

public final class zzad
{
  public static void zza(Bundle paramBundle, String paramString, Parcelable paramParcelable)
  {
    paramBundle.setClassLoader(zzad.class.getClassLoader());
    Bundle localBundle2 = paramBundle.getBundle("map_state");
    Bundle localBundle1 = localBundle2;
    if (localBundle2 == null) {
      localBundle1 = new Bundle();
    }
    localBundle1.setClassLoader(zzad.class.getClassLoader());
    localBundle1.putParcelable(paramString, paramParcelable);
    paramBundle.putBundle("map_state", localBundle1);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.maps.internal.zzad
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */