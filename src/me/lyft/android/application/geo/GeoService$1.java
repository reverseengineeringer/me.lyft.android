package me.lyft.android.application.geo;

import java.util.concurrent.TimeUnit;
import rx.functions.Func1;

final class GeoService$1
  implements Func1<Long, Long>
{
  public Long call(Long paramLong)
  {
    if (paramLong.longValue() > 0L)
    {
      long l2 = TimeUnit.SECONDS.toMinutes(paramLong.longValue());
      long l1 = l2;
      if (l2 < 1L) {
        l1 = 1L;
      }
      return Long.valueOf(l1);
    }
    return Long.valueOf(0L);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.geo.GeoService.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */