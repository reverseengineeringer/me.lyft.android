package com.lyft.scoop;

import android.view.View;
import android.view.ViewGroup;

public class LayoutInflater
{
  public View inflateView(Scoop paramScoop, Screen paramScreen, ViewGroup paramViewGroup)
  {
    return paramScoop.inflate(paramScreen.getLayout().intValue(), paramViewGroup, false);
  }
}

/* Location:
 * Qualified Name:     com.lyft.scoop.LayoutInflater
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */