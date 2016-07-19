package me.lyft.android.common;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import rx.functions.Func1;
import rx.functions.Func2;

public class Iterables
{
  public static <TSource, TAccumulate> TAccumulate aggregate(Iterable<TSource> paramIterable, TAccumulate paramTAccumulate, Func2<TAccumulate, TSource, TAccumulate> paramFunc2)
  {
    Preconditions.checkNotNull(paramIterable);
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext()) {
      paramTAccumulate = paramFunc2.call(paramTAccumulate, paramIterable.next());
    }
    return paramTAccumulate;
  }
  
  public static <TSource> TSource aggregate(Iterable<TSource> paramIterable, Func2<TSource, TSource, TSource> paramFunc2)
  {
    Preconditions.checkNotNull(paramIterable);
    Iterator localIterator = paramIterable.iterator();
    Object localObject;
    if (!localIterator.hasNext())
    {
      localObject = null;
      return (TSource)localObject;
    }
    for (paramIterable = localIterator.next();; paramIterable = paramFunc2.call(paramIterable, localIterator.next()))
    {
      localObject = paramIterable;
      if (!localIterator.hasNext()) {
        break;
      }
    }
  }
  
  public static <TSource> boolean contains(Iterable<TSource> paramIterable, Func1<TSource, Boolean> paramFunc1)
  {
    return firstOrDefault(paramIterable, paramFunc1, null) != null;
  }
  
  public static <TSource> boolean equals(Iterable<TSource> paramIterable1, Iterable<TSource> paramIterable2)
  {
    equals(paramIterable1, paramIterable2, new Func2()
    {
      public Boolean call(TSource paramAnonymousTSource1, TSource paramAnonymousTSource2)
      {
        return Boolean.valueOf(Objects.equals(paramAnonymousTSource1, paramAnonymousTSource2));
      }
    });
  }
  
  public static <TSource> boolean equals(Iterable<TSource> paramIterable1, Iterable<TSource> paramIterable2, Func2<TSource, TSource, Boolean> paramFunc2)
  {
    boolean bool = true;
    if ((paramIterable1 == null) || (paramIterable2 == null))
    {
      if (paramIterable1 == paramIterable2) {}
      for (bool = true;; bool = false) {
        return bool;
      }
    }
    paramIterable1 = paramIterable1.iterator();
    paramIterable2 = paramIterable2.iterator();
    while ((paramIterable1.hasNext()) && (paramIterable2.hasNext())) {
      if (!((Boolean)paramFunc2.call(paramIterable1.next(), paramIterable2.next())).booleanValue()) {
        return false;
      }
    }
    if ((!paramIterable1.hasNext()) && (!paramIterable2.hasNext())) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public static <TResult> TResult find(Iterable<TResult> paramIterable, Func1<TResult, Boolean> paramFunc1)
  {
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      Object localObject = paramIterable.next();
      if (((Boolean)paramFunc1.call(localObject)).booleanValue()) {
        return (TResult)localObject;
      }
    }
    return null;
  }
  
  public static <TSource> TSource firstOrDefault(Iterable<TSource> paramIterable)
  {
    Preconditions.checkNotNull(paramIterable);
    Preconditions.checkArgument(paramIterable.iterator().hasNext());
    return (TSource)paramIterable.iterator().next();
  }
  
  public static <T> T firstOrDefault(Iterable<T> paramIterable, T paramT)
  {
    return (T)Iterators.getNext(paramIterable.iterator(), paramT);
  }
  
  public static <TSource> TSource firstOrDefault(Iterable<TSource> paramIterable, Func1<TSource, Boolean> paramFunc1, TSource paramTSource)
  {
    Preconditions.checkNotNull(paramIterable);
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      Object localObject = paramIterable.next();
      if (((Boolean)paramFunc1.call(localObject)).booleanValue()) {
        return (TSource)localObject;
      }
    }
    return paramTSource;
  }
  
  public static <T> T get(Iterable<T> paramIterable, int paramInt)
  {
    Preconditions.checkNotNull(paramIterable);
    if ((paramIterable instanceof List)) {
      return (T)((List)paramIterable).get(paramInt);
    }
    return (T)Iterators.get(paramIterable.iterator(), paramInt);
  }
  
  public static <TSource> TSource last(Iterable<TSource> paramIterable)
  {
    Preconditions.checkNotNull(paramIterable);
    Preconditions.checkArgument(paramIterable.iterator().hasNext());
    Iterator localIterator = paramIterable.iterator();
    for (paramIterable = null; localIterator.hasNext(); paramIterable = localIterator.next()) {}
    return paramIterable;
  }
  
  public static <TSource, TResult> List<TResult> map(Iterable<TSource> paramIterable, Func1<TSource, TResult> paramFunc1)
  {
    Preconditions.checkNotNull(paramIterable);
    paramIterable = paramIterable.iterator();
    ArrayList localArrayList = new ArrayList();
    while (paramIterable.hasNext()) {
      localArrayList.add(paramFunc1.call(paramIterable.next()));
    }
    return localArrayList;
  }
  
  public static <TResult> TResult min(Iterable<TResult> paramIterable, Func1<TResult, Double> paramFunc1)
  {
    double d1 = Double.MAX_VALUE;
    Object localObject = null;
    Iterator localIterator = paramIterable.iterator();
    paramIterable = (Iterable<TResult>)localObject;
    while (localIterator.hasNext())
    {
      localObject = localIterator.next();
      double d2 = ((Double)paramFunc1.call(localObject)).doubleValue();
      if (Double.compare(d2, d1) < 0)
      {
        d1 = d2;
        paramIterable = (Iterable<TResult>)localObject;
      }
    }
    return paramIterable;
  }
  
  public static <TResult> List<TResult> repeat(Iterable<TResult> paramIterable, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramIterable.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(localIterator.next());
    }
    int i = 0;
    while (i < paramInt)
    {
      localIterator = paramIterable.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(localIterator.next());
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public static <TSource> List<TSource> skip(Iterable<TSource> paramIterable, int paramInt)
  {
    Preconditions.checkNotNull(paramIterable);
    paramIterable = paramIterable.iterator();
    ArrayList localArrayList = new ArrayList();
    while ((paramInt > 0) && (paramIterable.hasNext()))
    {
      paramIterable.next();
      paramInt -= 1;
    }
    while (paramIterable.hasNext()) {
      localArrayList.add(paramIterable.next());
    }
    return localArrayList;
  }
  
  public static <TSource> List<TSource> take(Iterable<TSource> paramIterable, int paramInt)
  {
    Preconditions.checkNotNull(paramIterable);
    paramIterable = paramIterable.iterator();
    ArrayList localArrayList = new ArrayList();
    while ((paramInt > 0) && (paramIterable.hasNext()))
    {
      localArrayList.add(paramIterable.next());
      paramInt -= 1;
    }
    return localArrayList;
  }
  
  public static <TSource> List<TSource> takeWhile(Iterable<TSource> paramIterable, Func1<TSource, Boolean> paramFunc1)
  {
    Preconditions.checkNotNull(paramIterable);
    Preconditions.checkNotNull(paramFunc1);
    ArrayList localArrayList = new ArrayList();
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      Object localObject = paramIterable.next();
      if (((Boolean)paramFunc1.call(localObject)).booleanValue()) {
        localArrayList.add(localObject);
      }
    }
    return localArrayList;
  }
  
  public static <T> List<T> where(Iterable<T> paramIterable, Func1<T, Boolean> paramFunc1)
  {
    Preconditions.checkNotNull(paramIterable);
    Preconditions.checkNotNull(paramFunc1);
    paramIterable = paramIterable.iterator();
    ArrayList localArrayList = new ArrayList();
    while (paramIterable.hasNext())
    {
      Object localObject = paramIterable.next();
      if (((Boolean)paramFunc1.call(localObject)).booleanValue()) {
        localArrayList.add(localObject);
      }
    }
    return localArrayList;
  }
  
  public static <TFirst, TSecond, TResult> List<TResult> zip(Iterable<TFirst> paramIterable, Iterable<TSecond> paramIterable1, Func2<TFirst, TSecond, TResult> paramFunc2)
  {
    Preconditions.checkNotNull(paramIterable);
    Preconditions.checkNotNull(paramIterable1);
    paramIterable = paramIterable.iterator();
    paramIterable1 = paramIterable1.iterator();
    ArrayList localArrayList = new ArrayList();
    while ((paramIterable.hasNext()) && (paramIterable1.hasNext())) {
      localArrayList.add(paramFunc2.call(paramIterable.next(), paramIterable1.next()));
    }
    return localArrayList;
  }
  
  static class Iterators
  {
    static int advance(Iterator<?> paramIterator, int paramInt)
    {
      Preconditions.checkNotNull(paramIterator);
      if (paramInt >= 0) {}
      int i;
      for (boolean bool = true;; bool = false)
      {
        Preconditions.checkArgument(bool, "numberToAdvance must be nonnegative");
        i = 0;
        while ((i < paramInt) && (paramIterator.hasNext()))
        {
          paramIterator.next();
          i += 1;
        }
      }
      return i;
    }
    
    static void checkNonnegative(int paramInt)
    {
      if (paramInt < 0) {
        throw new IndexOutOfBoundsException("position (" + paramInt + ") must not be negative");
      }
    }
    
    static <T> T get(Iterator<T> paramIterator, int paramInt)
    {
      checkNonnegative(paramInt);
      int i = advance(paramIterator, paramInt);
      if (!paramIterator.hasNext()) {
        throw new IndexOutOfBoundsException("position (" + paramInt + ") must be less than the number of elements that remained (" + i + ")");
      }
      return (T)paramIterator.next();
    }
    
    static <T> T getNext(Iterator<? extends T> paramIterator, T paramT)
    {
      if (paramIterator.hasNext()) {
        paramT = paramIterator.next();
      }
      return paramT;
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.common.Iterables
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */