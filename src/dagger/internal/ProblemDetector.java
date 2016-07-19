package dagger.internal;

import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class ProblemDetector
{
  /* Error */
  private static void detectCircularDependencies(Collection<Binding<?>> paramCollection, List<Binding<?>> paramList)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokeinterface 20 1 0
    //   6: astore 4
    //   8: aload 4
    //   10: invokeinterface 26 1 0
    //   15: ifeq +245 -> 260
    //   18: aload 4
    //   20: invokeinterface 30 1 0
    //   25: checkcast 32	dagger/internal/Binding
    //   28: astore_0
    //   29: aload_0
    //   30: invokevirtual 35	dagger/internal/Binding:isCycleFree	()Z
    //   33: ifne -25 -> 8
    //   36: aload_0
    //   37: invokevirtual 38	dagger/internal/Binding:isVisiting	()Z
    //   40: ifeq +131 -> 171
    //   43: aload_1
    //   44: aload_0
    //   45: invokeinterface 44 2 0
    //   50: istore_3
    //   51: new 46	java/lang/StringBuilder
    //   54: dup
    //   55: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   58: ldc 49
    //   60: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: astore 4
    //   65: iload_3
    //   66: istore_2
    //   67: iload_2
    //   68: aload_1
    //   69: invokeinterface 57 1 0
    //   74: if_icmpge +60 -> 134
    //   77: aload 4
    //   79: ldc 59
    //   81: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: iload_2
    //   85: iload_3
    //   86: isub
    //   87: invokevirtual 62	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   90: ldc 64
    //   92: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: aload_1
    //   96: iload_2
    //   97: invokeinterface 68 2 0
    //   102: checkcast 32	dagger/internal/Binding
    //   105: getfield 72	dagger/internal/Binding:provideKey	Ljava/lang/String;
    //   108: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: ldc 74
    //   113: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: aload_1
    //   117: iload_2
    //   118: invokeinterface 68 2 0
    //   123: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   126: pop
    //   127: iload_2
    //   128: iconst_1
    //   129: iadd
    //   130: istore_2
    //   131: goto -64 -> 67
    //   134: aload 4
    //   136: ldc 59
    //   138: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: iconst_0
    //   142: invokevirtual 62	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   145: ldc 64
    //   147: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: aload_0
    //   151: getfield 72	dagger/internal/Binding:provideKey	Ljava/lang/String;
    //   154: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: pop
    //   158: new 79	java/lang/IllegalStateException
    //   161: dup
    //   162: aload 4
    //   164: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   167: invokespecial 86	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   170: athrow
    //   171: aload_0
    //   172: iconst_1
    //   173: invokevirtual 90	dagger/internal/Binding:setVisiting	(Z)V
    //   176: aload_1
    //   177: aload_0
    //   178: invokeinterface 94 2 0
    //   183: pop
    //   184: new 6	dagger/internal/ProblemDetector$ArraySet
    //   187: dup
    //   188: invokespecial 95	dagger/internal/ProblemDetector$ArraySet:<init>	()V
    //   191: astore 5
    //   193: aload_0
    //   194: aload 5
    //   196: aload 5
    //   198: invokevirtual 99	dagger/internal/Binding:getDependencies	(Ljava/util/Set;Ljava/util/Set;)V
    //   201: aload 5
    //   203: aload_1
    //   204: invokestatic 101	dagger/internal/ProblemDetector:detectCircularDependencies	(Ljava/util/Collection;Ljava/util/List;)V
    //   207: aload_0
    //   208: iconst_1
    //   209: invokevirtual 104	dagger/internal/Binding:setCycleFree	(Z)V
    //   212: aload_1
    //   213: aload_1
    //   214: invokeinterface 57 1 0
    //   219: iconst_1
    //   220: isub
    //   221: invokeinterface 107 2 0
    //   226: pop
    //   227: aload_0
    //   228: iconst_0
    //   229: invokevirtual 90	dagger/internal/Binding:setVisiting	(Z)V
    //   232: goto -224 -> 8
    //   235: astore 4
    //   237: aload_1
    //   238: aload_1
    //   239: invokeinterface 57 1 0
    //   244: iconst_1
    //   245: isub
    //   246: invokeinterface 107 2 0
    //   251: pop
    //   252: aload_0
    //   253: iconst_0
    //   254: invokevirtual 90	dagger/internal/Binding:setVisiting	(Z)V
    //   257: aload 4
    //   259: athrow
    //   260: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	261	0	paramCollection	Collection<Binding<?>>
    //   0	261	1	paramList	List<Binding<?>>
    //   66	65	2	i	int
    //   50	37	3	j	int
    //   6	157	4	localObject1	Object
    //   235	23	4	localObject2	Object
    //   191	11	5	localArraySet	ArraySet
    // Exception table:
    //   from	to	target	type
    //   184	212	235	finally
  }
  
  public void detectCircularDependencies(Collection<Binding<?>> paramCollection)
  {
    detectCircularDependencies(paramCollection, new ArrayList());
  }
  
  public void detectProblems(Collection<Binding<?>> paramCollection)
  {
    detectCircularDependencies(paramCollection);
    detectUnusedBinding(paramCollection);
  }
  
  public void detectUnusedBinding(Collection<Binding<?>> paramCollection)
  {
    ArrayList localArrayList = new ArrayList();
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      Binding localBinding = (Binding)paramCollection.next();
      if ((!localBinding.library()) && (!localBinding.dependedOn())) {
        localArrayList.add(localBinding);
      }
    }
    if (!localArrayList.isEmpty())
    {
      paramCollection = new StringBuilder();
      paramCollection.append("You have these unused @Provider methods:");
      int i = 0;
      while (i < localArrayList.size())
      {
        paramCollection.append("\n    ").append(i + 1).append(". ").append(getrequiredBy);
        i += 1;
      }
      paramCollection.append("\n    Set library=true in your module to disable this check.");
      throw new IllegalStateException(paramCollection.toString());
    }
  }
  
  static class ArraySet<T>
    extends AbstractSet<T>
  {
    private final ArrayList<T> list = new ArrayList();
    
    public boolean add(T paramT)
    {
      list.add(paramT);
      return true;
    }
    
    public Iterator<T> iterator()
    {
      return list.iterator();
    }
    
    public int size()
    {
      throw new UnsupportedOperationException();
    }
  }
}

/* Location:
 * Qualified Name:     dagger.internal.ProblemDetector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */