package com.lyft.rx;

import rx.functions.FuncN;

final class ReactiveUI$3
  implements FuncN<Boolean>
{
  public Boolean call(Object... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      if (!((Boolean)paramVarArgs[i]).booleanValue()) {
        return Boolean.valueOf(false);
      }
      i += 1;
    }
    return Boolean.valueOf(true);
  }
}

/* Location:
 * Qualified Name:     com.lyft.rx.ReactiveUI.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */