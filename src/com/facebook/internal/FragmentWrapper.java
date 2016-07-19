package com.facebook.internal;

import android.app.Activity;
import android.content.Intent;

public class FragmentWrapper
{
  private android.app.Fragment nativeFragment;
  private android.support.v4.app.Fragment supportFragment;
  
  public FragmentWrapper(android.app.Fragment paramFragment)
  {
    Validate.notNull(paramFragment, "fragment");
    nativeFragment = paramFragment;
  }
  
  public FragmentWrapper(android.support.v4.app.Fragment paramFragment)
  {
    Validate.notNull(paramFragment, "fragment");
    supportFragment = paramFragment;
  }
  
  public final Activity getActivity()
  {
    if (supportFragment != null) {
      return supportFragment.getActivity();
    }
    return nativeFragment.getActivity();
  }
  
  public android.app.Fragment getNativeFragment()
  {
    return nativeFragment;
  }
  
  public android.support.v4.app.Fragment getSupportFragment()
  {
    return supportFragment;
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    if (supportFragment != null)
    {
      supportFragment.startActivityForResult(paramIntent, paramInt);
      return;
    }
    nativeFragment.startActivityForResult(paramIntent, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.facebook.internal.FragmentWrapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */