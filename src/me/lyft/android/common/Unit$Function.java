package me.lyft.android.common;

import rx.functions.Func0;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.functions.Func3;
import rx.functions.Func4;
import rx.functions.FuncN;

final class Unit$Function<A, B, C, D>
  implements Func0<Unit>, Func1<A, Unit>, Func2<A, B, Unit>, Func3<A, B, C, Unit>, Func4<A, B, C, D, Unit>, FuncN<Unit>
{
  public Unit call()
  {
    return Unit.access$100();
  }
  
  public Unit call(A paramA)
  {
    return Unit.access$100();
  }
  
  public Unit call(A paramA, B paramB)
  {
    return Unit.access$100();
  }
  
  public Unit call(A paramA, B paramB, C paramC)
  {
    return Unit.access$100();
  }
  
  public Unit call(A paramA, B paramB, C paramC, D paramD)
  {
    return Unit.access$100();
  }
  
  public Unit call(Object... paramVarArgs)
  {
    return Unit.access$100();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.common.Unit.Function
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */