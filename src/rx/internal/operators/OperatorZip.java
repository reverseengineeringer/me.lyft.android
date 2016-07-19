package rx.internal.operators;

import rx.Observable;
import rx.Observable.Operator;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Func2;
import rx.functions.Func3;
import rx.functions.Func4;
import rx.functions.Func5;
import rx.functions.Func6;
import rx.functions.Func7;
import rx.functions.Func8;
import rx.functions.Func9;
import rx.functions.FuncN;
import rx.functions.Functions;

public final class OperatorZip<R>
  implements Observable.Operator<R, Observable<?>[]>
{
  final FuncN<? extends R> zipFunction;
  
  public OperatorZip(Func2 paramFunc2)
  {
    zipFunction = Functions.fromFunc(paramFunc2);
  }
  
  public OperatorZip(Func3 paramFunc3)
  {
    zipFunction = Functions.fromFunc(paramFunc3);
  }
  
  public OperatorZip(Func4 paramFunc4)
  {
    zipFunction = Functions.fromFunc(paramFunc4);
  }
  
  public OperatorZip(Func5 paramFunc5)
  {
    zipFunction = Functions.fromFunc(paramFunc5);
  }
  
  public OperatorZip(Func6 paramFunc6)
  {
    zipFunction = Functions.fromFunc(paramFunc6);
  }
  
  public OperatorZip(Func7 paramFunc7)
  {
    zipFunction = Functions.fromFunc(paramFunc7);
  }
  
  public OperatorZip(Func8 paramFunc8)
  {
    zipFunction = Functions.fromFunc(paramFunc8);
  }
  
  public OperatorZip(Func9 paramFunc9)
  {
    zipFunction = Functions.fromFunc(paramFunc9);
  }
  
  public OperatorZip(FuncN<? extends R> paramFuncN)
  {
    zipFunction = paramFuncN;
  }
  
  public Subscriber<? super Observable[]> call(Subscriber<? super R> paramSubscriber)
  {
    Object localObject = new OperatorZip.Zip(paramSubscriber, zipFunction);
    OperatorZip.ZipProducer localZipProducer = new OperatorZip.ZipProducer((OperatorZip.Zip)localObject);
    localObject = new OperatorZip.ZipSubscriber(this, paramSubscriber, (OperatorZip.Zip)localObject, localZipProducer);
    paramSubscriber.add((Subscription)localObject);
    paramSubscriber.setProducer(localZipProducer);
    return (Subscriber<? super Observable[]>)localObject;
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorZip
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */