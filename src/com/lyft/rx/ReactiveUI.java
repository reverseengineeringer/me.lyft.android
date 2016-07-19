package com.lyft.rx;

import java.util.Arrays;
import me.lyft.android.common.Unit;
import rx.Observable;
import rx.functions.Func1;
import rx.functions.FuncN;

public class ReactiveUI
{
  public static Observable<Boolean> and(Observable<Boolean>... paramVarArgs)
  {
    Observable.combineLatest(Arrays.asList(paramVarArgs), new FuncN()
    {
      public Boolean call(Object... paramAnonymousVarArgs)
      {
        int j = paramAnonymousVarArgs.length;
        int i = 0;
        while (i < j)
        {
          if (!((Boolean)paramAnonymousVarArgs[i]).booleanValue()) {
            return Boolean.valueOf(false);
          }
          i += 1;
        }
        return Boolean.valueOf(true);
      }
    });
  }
  
  public static <T1, T2, T3> Observable<Unit> any(Observable<T1> paramObservable, Observable<T2> paramObservable1, Observable<T3> paramObservable2)
  {
    return Observable.combineLatest(paramObservable, paramObservable1, paramObservable2, Unit.func3());
  }
  
  public static Observable<Unit> any(Observable<?>... paramVarArgs)
  {
    return Observable.combineLatest(Arrays.asList(paramVarArgs), Unit.funcN());
  }
  
  public static Observable<Unit> isFalse(Observable<Boolean> paramObservable)
  {
    paramObservable.filter(new Func1()
    {
      public Boolean call(Boolean paramAnonymousBoolean)
      {
        if (!paramAnonymousBoolean.booleanValue()) {}
        for (boolean bool = true;; bool = false) {
          return Boolean.valueOf(bool);
        }
      }
    }).map(Unit.func1());
  }
  
  public static Observable<Unit> isTrue(Observable<Boolean> paramObservable)
  {
    paramObservable.filter(new Func1()
    {
      public Boolean call(Boolean paramAnonymousBoolean)
      {
        return paramAnonymousBoolean;
      }
    }).map(Unit.func1());
  }
  
  public static Observable<Boolean> not(Observable<Boolean> paramObservable)
  {
    paramObservable.map(new Func1()
    {
      public Boolean call(Boolean paramAnonymousBoolean)
      {
        if (!paramAnonymousBoolean.booleanValue()) {}
        for (boolean bool = true;; bool = false) {
          return Boolean.valueOf(bool);
        }
      }
    });
  }
}

/* Location:
 * Qualified Name:     com.lyft.rx.ReactiveUI
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */