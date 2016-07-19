package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.view.View;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.zzvy;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class zzg
{
  private final Account aP;
  private final String cb;
  private final Set<Scope> rN;
  private final int rP;
  private final View rQ;
  private final String rR;
  private final Set<Scope> xY;
  private final Map<Api<?>, zza> xZ;
  private final zzvy ya;
  private Integer yb;
  
  public zzg(Account paramAccount, Set<Scope> paramSet, Map<Api<?>, zza> paramMap, int paramInt, View paramView, String paramString1, String paramString2, zzvy paramzzvy)
  {
    aP = paramAccount;
    if (paramSet == null) {}
    for (paramAccount = Collections.EMPTY_SET;; paramAccount = Collections.unmodifiableSet(paramSet))
    {
      rN = paramAccount;
      paramAccount = paramMap;
      if (paramMap == null) {
        paramAccount = Collections.EMPTY_MAP;
      }
      xZ = paramAccount;
      rQ = paramView;
      rP = paramInt;
      cb = paramString1;
      rR = paramString2;
      ya = paramzzvy;
      paramAccount = new HashSet(rN);
      paramSet = xZ.values().iterator();
      while (paramSet.hasNext()) {
        paramAccount.addAll(nextdY);
      }
    }
    xY = Collections.unmodifiableSet(paramAccount);
  }
  
  public static zzg zzcd(Context paramContext)
  {
    return new GoogleApiClient.Builder(paramContext).zzaoe();
  }
  
  public Account getAccount()
  {
    return aP;
  }
  
  @Deprecated
  public String getAccountName()
  {
    if (aP != null) {
      return aP.name;
    }
    return null;
  }
  
  public Account zzaru()
  {
    if (aP != null) {
      return aP;
    }
    return new Account("<<default account>>", "com.google");
  }
  
  public Set<Scope> zzasf()
  {
    return rN;
  }
  
  public Set<Scope> zzasg()
  {
    return xY;
  }
  
  public Map<Api<?>, zza> zzash()
  {
    return xZ;
  }
  
  public String zzasi()
  {
    return cb;
  }
  
  public String zzasj()
  {
    return rR;
  }
  
  public zzvy zzasl()
  {
    return ya;
  }
  
  public Integer zzasm()
  {
    return yb;
  }
  
  public void zzc(Integer paramInteger)
  {
    yb = paramInteger;
  }
  
  public static final class zza
  {
    public final Set<Scope> dY;
    public final boolean yc;
    
    public zza(Set<Scope> paramSet, boolean paramBoolean)
    {
      zzab.zzaa(paramSet);
      dY = Collections.unmodifiableSet(paramSet);
      yc = paramBoolean;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.internal.zzg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */