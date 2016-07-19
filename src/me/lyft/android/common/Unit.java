package me.lyft.android.common;

import rx.Observable;
import rx.functions.Func0;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.functions.Func3;
import rx.functions.Func4;
import rx.functions.FuncN;

public final class Unit
{
  private static final Function<Object, Object, Object, Object> FUNCTION = new Function(null);
  private static final FuncN<Unit> FUNC_N = new FuncN()
  {
    public Unit call(Object... paramAnonymousVarArgs)
    {
      return Unit.INSTANCE;
    }
  };
  private static final Unit INSTANCE = new Unit();
  
  public static Unit create()
  {
    return INSTANCE;
  }
  
  public static <A> Func1<A, Unit> func1()
  {
    return FUNCTION;
  }
  
  public static <A, B> Func2<A, B, Unit> func2()
  {
    return FUNCTION;
  }
  
  public static <A, B, C> Func3<A, B, C, Unit> func3()
  {
    return FUNCTION;
  }
  
  public static <A, B, C, D> Func4<A, B, C, D, Unit> func4()
  {
    return FUNCTION;
  }
  
  public static FuncN<Unit> funcN()
  {
    return FUNC_N;
  }
  
  public static Observable<Unit> just()
  {
    return Observable.just(INSTANCE);
  }
  
  private static final class Function<A, B, C, D>
    implements Func0<Unit>, Func1<A, Unit>, Func2<A, B, Unit>, Func3<A, B, C, Unit>, Func4<A, B, C, D, Unit>, FuncN<Unit>
  {
    public Unit call()
    {
      return Unit.INSTANCE;
    }
    
    public Unit call(A paramA)
    {
      return Unit.INSTANCE;
    }
    
    public Unit call(A paramA, B paramB)
    {
      return Unit.INSTANCE;
    }
    
    public Unit call(A paramA, B paramB, C paramC)
    {
      return Unit.INSTANCE;
    }
    
    public Unit call(A paramA, B paramB, C paramC, D paramD)
    {
      return Unit.INSTANCE;
    }
    
    public Unit call(Object... paramVarArgs)
    {
      return Unit.INSTANCE;
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.common.Unit
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */