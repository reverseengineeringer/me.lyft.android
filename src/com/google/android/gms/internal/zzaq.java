package com.google.android.gms.internal;

import android.content.Context;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public abstract class zzaq
  extends zzao
{
  private static final String TAG = zzaq.class.getSimpleName();
  private static long startTime = 0L;
  protected static volatile zzax zzaey = null;
  private static Method zzafo;
  static boolean zzafq = false;
  protected static final Object zzaft = new Object();
  protected boolean zzafn = false;
  protected String zzafp;
  protected boolean zzafr = false;
  protected boolean zzafs = false;
  
  protected zzaq(Context paramContext, String paramString)
  {
    super(paramContext);
    zzafp = paramString;
    zzafn = false;
  }
  
  protected zzaq(Context paramContext, String paramString, boolean paramBoolean)
  {
    super(paramContext);
    zzafp = paramString;
    zzafn = paramBoolean;
  }
  
  static List<Long> zza(zzax paramzzax, MotionEvent paramMotionEvent, DisplayMetrics paramDisplayMetrics)
    throws zzaw
  {
    zzafo = paramzzax.zzc(zzav.zzcc(), zzav.zzcd());
    if ((zzafo == null) || (paramMotionEvent == null)) {
      throw new zzaw();
    }
    try
    {
      paramzzax = (ArrayList)zzafo.invoke(null, new Object[] { paramMotionEvent, paramDisplayMetrics });
      return paramzzax;
    }
    catch (IllegalAccessException paramzzax)
    {
      throw new zzaw(paramzzax);
    }
    catch (InvocationTargetException paramzzax)
    {
      throw new zzaw(paramzzax);
    }
  }
  
  protected static void zza(Context paramContext, boolean paramBoolean)
  {
    try
    {
      if (!zzafq)
      {
        startTime = Calendar.getInstance().getTime().getTime() / 1000L;
        zzaey = zzb(paramContext, paramBoolean);
        zzafq = true;
      }
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  private static void zza(zzax paramzzax)
  {
    List localList = Collections.singletonList(Context.class);
    paramzzax.zza(zzav.zzbo(), zzav.zzbp(), localList);
    paramzzax.zza(zzav.zzbm(), zzav.zzbn(), localList);
    paramzzax.zza(zzav.zzby(), zzav.zzbz(), localList);
    paramzzax.zza(zzav.zzbw(), zzav.zzbx(), localList);
    paramzzax.zza(zzav.zzbg(), zzav.zzbh(), localList);
    paramzzax.zza(zzav.zzbe(), zzav.zzbf(), localList);
    paramzzax.zza(zzav.zzbc(), zzav.zzbd(), localList);
    paramzzax.zza(zzav.zzbs(), zzav.zzbt(), localList);
    paramzzax.zza(zzav.zzba(), zzav.zzbb(), localList);
    localList = Arrays.asList(new Class[] { MotionEvent.class, DisplayMetrics.class });
    paramzzax.zza(zzav.zzcc(), zzav.zzcd(), localList);
    paramzzax.zza(zzav.zzbk(), zzav.zzbl(), Collections.emptyList());
    paramzzax.zza(zzav.zzca(), zzav.zzcb(), Collections.emptyList());
    paramzzax.zza(zzav.zzbu(), zzav.zzbv(), Collections.emptyList());
    paramzzax.zza(zzav.zzbi(), zzav.zzbj(), Collections.emptyList());
    paramzzax.zza(zzav.zzbq(), zzav.zzbr(), Collections.emptyList());
  }
  
  protected static zzax zzb(Context paramContext, boolean paramBoolean)
  {
    if (zzaey == null) {}
    synchronized (zzaft)
    {
      if (zzaey == null)
      {
        paramContext = zzax.zza(paramContext, zzav.getKey(), zzav.zzaz(), paramBoolean);
        zza(paramContext);
        zzaey = paramContext;
      }
      return zzaey;
    }
  }
  
  protected void zza(zzax paramzzax, zzae.zza paramzza)
  {
    if (paramzzax.zzce() == null) {
      return;
    }
    zza(zzb(paramzzax, paramzza));
  }
  
  protected void zza(List<Callable<Void>> paramList)
  {
    if (zzaey == null) {}
    ExecutorService localExecutorService;
    do
    {
      return;
      localExecutorService = zzaey.zzce();
    } while ((localExecutorService == null) || (paramList.isEmpty()));
    try
    {
      localExecutorService.invokeAll(paramList, ((Long)zzdc.zzbbh.get()).longValue(), TimeUnit.MILLISECONDS);
      return;
    }
    catch (InterruptedException paramList)
    {
      Log.d(TAG, String.format("class methods got exception: %s", new Object[] { zzay.zza(paramList) }));
    }
  }
  
  protected List<Callable<Void>> zzb(zzax paramzzax, zzae.zza paramzza)
  {
    int i = paramzzax.zzau();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new zzbb(paramzzax, zzav.zzbo(), zzav.zzbp(), paramzza, i, 27));
    localArrayList.add(new zzbg(paramzzax, zzav.zzbk(), zzav.zzbl(), paramzza, startTime, i, 25));
    localArrayList.add(new zzbl(paramzzax, zzav.zzbu(), zzav.zzbv(), paramzza, i, 1));
    localArrayList.add(new zzbm(paramzzax, zzav.zzbw(), zzav.zzbx(), paramzza, i, 31));
    localArrayList.add(new zzbn(paramzzax, zzav.zzca(), zzav.zzcb(), paramzza, i, 33));
    localArrayList.add(new zzba(paramzzax, zzav.zzby(), zzav.zzbz(), paramzza, i, 29));
    localArrayList.add(new zzbe(paramzzax, zzav.zzbg(), zzav.zzbh(), paramzza, i, 5));
    localArrayList.add(new zzbk(paramzzax, zzav.zzbs(), zzav.zzbt(), paramzza, i, 12));
    localArrayList.add(new zzaz(paramzzax, zzav.zzba(), zzav.zzbb(), paramzza, i, 3));
    localArrayList.add(new zzbd(paramzzax, zzav.zzbe(), zzav.zzbf(), paramzza, i, 34));
    localArrayList.add(new zzbc(paramzzax, zzav.zzbc(), zzav.zzbd(), paramzza, i, 35));
    if (((Boolean)zzdc.zzbbl.get()).booleanValue()) {
      localArrayList.add(new zzbf(paramzzax, zzav.zzbi(), zzav.zzbj(), paramzza, i, 44));
    }
    if (((Boolean)zzdc.zzbbo.get()).booleanValue()) {
      localArrayList.add(new zzbj(paramzzax, zzav.zzbq(), zzav.zzbr(), paramzza, i, 22));
    }
    return localArrayList;
  }
  
  protected zzae.zza zzc(Context paramContext)
  {
    zzae.zza localzza = new zzae.zza();
    if (!TextUtils.isEmpty(zzafp)) {
      zzcs = zzafp;
    }
    paramContext = zzb(paramContext, zzafn);
    paramContext.zzct();
    zza(paramContext, localzza);
    paramContext.zzcu();
    return localzza;
  }
  
  protected List<Callable<Void>> zzc(zzax paramzzax, zzae.zza paramzza)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramzzax.zzce() == null) {
      return localArrayList;
    }
    int i = paramzzax.zzau();
    localArrayList.add(new zzbi(paramzzax, paramzza));
    localArrayList.add(new zzbl(paramzzax, zzav.zzbu(), zzav.zzbv(), paramzza, i, 1));
    localArrayList.add(new zzbg(paramzzax, zzav.zzbk(), zzav.zzbl(), paramzza, startTime, i, 25));
    if (((Boolean)zzdc.zzbbm.get()).booleanValue()) {
      localArrayList.add(new zzbf(paramzzax, zzav.zzbi(), zzav.zzbj(), paramzza, i, 44));
    }
    localArrayList.add(new zzaz(paramzzax, zzav.zzba(), zzav.zzbb(), paramzza, i, 3));
    if (((Boolean)zzdc.zzbbp.get()).booleanValue()) {
      localArrayList.add(new zzbj(paramzzax, zzav.zzbq(), zzav.zzbr(), paramzza, i, 22));
    }
    return localArrayList;
  }
  
  protected zzae.zza zzd(Context paramContext)
  {
    zzae.zza localzza = new zzae.zza();
    if (!TextUtils.isEmpty(zzafp)) {
      zzcs = zzafp;
    }
    paramContext = zzb(paramContext, zzafn);
    paramContext.zzct();
    zzd(paramContext, localzza);
    paramContext.zzcu();
    return localzza;
  }
  
  /* Error */
  protected void zzd(zzax paramzzax, zzae.zza paramzza)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_1
    //   3: aload_0
    //   4: getfield 408	com/google/android/gms/internal/zzaq:zzafd	Landroid/view/MotionEvent;
    //   7: aload_0
    //   8: getfield 412	com/google/android/gms/internal/zzaq:zzafl	Landroid/util/DisplayMetrics;
    //   11: invokestatic 414	com/google/android/gms/internal/zzaq:zza	(Lcom/google/android/gms/internal/zzax;Landroid/view/MotionEvent;Landroid/util/DisplayMetrics;)Ljava/util/List;
    //   14: astore 5
    //   16: aload_2
    //   17: aload 5
    //   19: iconst_0
    //   20: invokeinterface 417 2 0
    //   25: checkcast 272	java/lang/Long
    //   28: putfield 421	com/google/android/gms/internal/zzae$zza:zzdf	Ljava/lang/Long;
    //   31: aload_2
    //   32: aload 5
    //   34: iconst_1
    //   35: invokeinterface 417 2 0
    //   40: checkcast 272	java/lang/Long
    //   43: putfield 424	com/google/android/gms/internal/zzae$zza:zzdg	Ljava/lang/Long;
    //   46: aload 5
    //   48: iconst_2
    //   49: invokeinterface 417 2 0
    //   54: checkcast 272	java/lang/Long
    //   57: invokevirtual 275	java/lang/Long:longValue	()J
    //   60: lconst_0
    //   61: lcmp
    //   62: iflt +18 -> 80
    //   65: aload_2
    //   66: aload 5
    //   68: iconst_2
    //   69: invokeinterface 417 2 0
    //   74: checkcast 272	java/lang/Long
    //   77: putfield 427	com/google/android/gms/internal/zzae$zza:zzdh	Ljava/lang/Long;
    //   80: aload_2
    //   81: aload 5
    //   83: iconst_3
    //   84: invokeinterface 417 2 0
    //   89: checkcast 272	java/lang/Long
    //   92: putfield 430	com/google/android/gms/internal/zzae$zza:zzdv	Ljava/lang/Long;
    //   95: aload_2
    //   96: aload 5
    //   98: iconst_4
    //   99: invokeinterface 417 2 0
    //   104: checkcast 272	java/lang/Long
    //   107: putfield 433	com/google/android/gms/internal/zzae$zza:zzdw	Ljava/lang/Long;
    //   110: aload_0
    //   111: getfield 436	com/google/android/gms/internal/zzaq:zzaff	J
    //   114: lconst_0
    //   115: lcmp
    //   116: ifle +14 -> 130
    //   119: aload_2
    //   120: aload_0
    //   121: getfield 436	com/google/android/gms/internal/zzaq:zzaff	J
    //   124: invokestatic 440	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   127: putfield 443	com/google/android/gms/internal/zzae$zza:zzea	Ljava/lang/Long;
    //   130: aload_0
    //   131: getfield 446	com/google/android/gms/internal/zzaq:zzafg	J
    //   134: lconst_0
    //   135: lcmp
    //   136: ifle +14 -> 150
    //   139: aload_2
    //   140: aload_0
    //   141: getfield 446	com/google/android/gms/internal/zzaq:zzafg	J
    //   144: invokestatic 440	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   147: putfield 449	com/google/android/gms/internal/zzae$zza:zzdz	Ljava/lang/Long;
    //   150: aload_0
    //   151: getfield 452	com/google/android/gms/internal/zzaq:zzafh	J
    //   154: lconst_0
    //   155: lcmp
    //   156: ifle +14 -> 170
    //   159: aload_2
    //   160: aload_0
    //   161: getfield 452	com/google/android/gms/internal/zzaq:zzafh	J
    //   164: invokestatic 440	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   167: putfield 455	com/google/android/gms/internal/zzae$zza:zzdy	Ljava/lang/Long;
    //   170: aload_0
    //   171: getfield 458	com/google/android/gms/internal/zzaq:zzafi	J
    //   174: lconst_0
    //   175: lcmp
    //   176: ifle +14 -> 190
    //   179: aload_2
    //   180: aload_0
    //   181: getfield 458	com/google/android/gms/internal/zzaq:zzafi	J
    //   184: invokestatic 440	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   187: putfield 461	com/google/android/gms/internal/zzae$zza:zzeb	Ljava/lang/Long;
    //   190: aload_0
    //   191: getfield 464	com/google/android/gms/internal/zzaq:zzafj	J
    //   194: lconst_0
    //   195: lcmp
    //   196: ifle +14 -> 210
    //   199: aload_2
    //   200: aload_0
    //   201: getfield 464	com/google/android/gms/internal/zzaq:zzafj	J
    //   204: invokestatic 440	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   207: putfield 467	com/google/android/gms/internal/zzae$zza:zzed	Ljava/lang/Long;
    //   210: aload_0
    //   211: getfield 471	com/google/android/gms/internal/zzaq:zzafe	Ljava/util/LinkedList;
    //   214: invokevirtual 476	java/util/LinkedList:size	()I
    //   217: iconst_1
    //   218: isub
    //   219: istore 4
    //   221: iload 4
    //   223: ifle +102 -> 325
    //   226: aload_2
    //   227: iload 4
    //   229: anewarray 478	com/google/android/gms/internal/zzae$zza$zza
    //   232: putfield 482	com/google/android/gms/internal/zzae$zza:zzee	[Lcom/google/android/gms/internal/zzae$zza$zza;
    //   235: iload_3
    //   236: iload 4
    //   238: if_icmpge +87 -> 325
    //   241: aload_1
    //   242: aload_0
    //   243: getfield 471	com/google/android/gms/internal/zzaq:zzafe	Ljava/util/LinkedList;
    //   246: iload_3
    //   247: invokevirtual 483	java/util/LinkedList:get	(I)Ljava/lang/Object;
    //   250: checkcast 186	android/view/MotionEvent
    //   253: aload_0
    //   254: getfield 412	com/google/android/gms/internal/zzaq:zzafl	Landroid/util/DisplayMetrics;
    //   257: invokestatic 414	com/google/android/gms/internal/zzaq:zza	(Lcom/google/android/gms/internal/zzax;Landroid/view/MotionEvent;Landroid/util/DisplayMetrics;)Ljava/util/List;
    //   260: astore 5
    //   262: new 478	com/google/android/gms/internal/zzae$zza$zza
    //   265: dup
    //   266: invokespecial 484	com/google/android/gms/internal/zzae$zza$zza:<init>	()V
    //   269: astore 6
    //   271: aload 6
    //   273: aload 5
    //   275: iconst_0
    //   276: invokeinterface 417 2 0
    //   281: checkcast 272	java/lang/Long
    //   284: putfield 485	com/google/android/gms/internal/zzae$zza$zza:zzdf	Ljava/lang/Long;
    //   287: aload 6
    //   289: aload 5
    //   291: iconst_1
    //   292: invokeinterface 417 2 0
    //   297: checkcast 272	java/lang/Long
    //   300: putfield 486	com/google/android/gms/internal/zzae$zza$zza:zzdg	Ljava/lang/Long;
    //   303: aload_2
    //   304: getfield 482	com/google/android/gms/internal/zzae$zza:zzee	[Lcom/google/android/gms/internal/zzae$zza$zza;
    //   307: iload_3
    //   308: aload 6
    //   310: aastore
    //   311: iload_3
    //   312: iconst_1
    //   313: iadd
    //   314: istore_3
    //   315: goto -80 -> 235
    //   318: astore 5
    //   320: aload_2
    //   321: aconst_null
    //   322: putfield 482	com/google/android/gms/internal/zzae$zza:zzee	[Lcom/google/android/gms/internal/zzae$zza$zza;
    //   325: aload_0
    //   326: aload_0
    //   327: aload_1
    //   328: aload_2
    //   329: invokevirtual 488	com/google/android/gms/internal/zzaq:zzc	(Lcom/google/android/gms/internal/zzax;Lcom/google/android/gms/internal/zzae$zza;)Ljava/util/List;
    //   332: invokevirtual 250	com/google/android/gms/internal/zzaq:zza	(Ljava/util/List;)V
    //   335: return
    //   336: astore 5
    //   338: goto -228 -> 110
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	341	0	this	zzaq
    //   0	341	1	paramzzax	zzax
    //   0	341	2	paramzza	zzae.zza
    //   1	314	3	i	int
    //   219	20	4	j	int
    //   14	276	5	localList	List
    //   318	1	5	localzzaw1	zzaw
    //   336	1	5	localzzaw2	zzaw
    //   269	40	6	localzza	zzae.zza.zza
    // Exception table:
    //   from	to	target	type
    //   210	221	318	com/google/android/gms/internal/zzaw
    //   226	235	318	com/google/android/gms/internal/zzaw
    //   241	311	318	com/google/android/gms/internal/zzaw
    //   2	80	336	com/google/android/gms/internal/zzaw
    //   80	110	336	com/google/android/gms/internal/zzaw
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzaq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */