package com.google.android.gms.auth.api.signin;

import com.google.android.gms.common.api.Scope;
import java.util.Comparator;

final class GoogleSignInAccount$1
  implements Comparator<Scope>
{
  public int zza(Scope paramScope1, Scope paramScope2)
  {
    return paramScope1.zzaoh().compareTo(paramScope2.zzaoh());
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.api.signin.GoogleSignInAccount.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */