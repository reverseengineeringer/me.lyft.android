package com.leanplum;

import java.util.ArrayList;
import java.util.List;

public class ActionArgs
{
  private List<a<?>> a = new ArrayList();
  
  final List<a<?>> a()
  {
    return a;
  }
  
  public <T> ActionArgs with(String paramString, T paramT)
  {
    a.add(a.a(paramString, paramT));
    return this;
  }
  
  public ActionArgs withAction(String paramString1, String paramString2)
  {
    a.add(a.e(paramString1, paramString2));
    return this;
  }
  
  public ActionArgs withAsset(String paramString1, String paramString2)
  {
    a.add(a.d(paramString1, paramString2));
    return this;
  }
  
  public ActionArgs withColor(String paramString, int paramInt)
  {
    a.add(a.a(paramString, paramInt));
    return this;
  }
  
  public ActionArgs withFile(String paramString1, String paramString2)
  {
    a.add(a.c(paramString1, paramString2));
    return this;
  }
}

/* Location:
 * Qualified Name:     com.leanplum.ActionArgs
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */