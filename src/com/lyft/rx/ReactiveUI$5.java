package com.lyft.rx;

import rx.functions.Func1;

final class ReactiveUI$5
  implements Func1<Boolean, Boolean>
{
  public Boolean call(Boolean paramBoolean)
  {
    if (!paramBoolean.booleanValue()) {}
    for (boolean bool = true;; bool = false) {
      return Boolean.valueOf(bool);
    }
  }
}

/* Location:
 * Qualified Name:     com.lyft.rx.ReactiveUI.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */