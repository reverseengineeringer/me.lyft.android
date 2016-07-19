package com.crashlytics.android.answers;

import io.fabric.sdk.android.services.concurrency.internal.Backoff;
import java.util.Random;

class RandomBackoff
  implements Backoff
{
  final Backoff backoff;
  final double jitterPercent;
  final Random random;
  
  public RandomBackoff(Backoff paramBackoff, double paramDouble)
  {
    this(paramBackoff, paramDouble, new Random());
  }
  
  public RandomBackoff(Backoff paramBackoff, double paramDouble, Random paramRandom)
  {
    if ((paramDouble < 0.0D) || (paramDouble > 1.0D)) {
      throw new IllegalArgumentException("jitterPercent must be between 0.0 and 1.0");
    }
    if (paramBackoff == null) {
      throw new NullPointerException("backoff must not be null");
    }
    if (paramRandom == null) {
      throw new NullPointerException("random must not be null");
    }
    backoff = paramBackoff;
    jitterPercent = paramDouble;
    random = paramRandom;
  }
  
  public long getDelayMillis(int paramInt)
  {
    return (randomJitter() * backoff.getDelayMillis(paramInt));
  }
  
  double randomJitter()
  {
    double d = 1.0D - jitterPercent;
    return (1.0D + jitterPercent - d) * random.nextDouble() + d;
  }
}

/* Location:
 * Qualified Name:     com.crashlytics.android.answers.RandomBackoff
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */