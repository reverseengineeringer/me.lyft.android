package me.lyft.android.application.geo.routecache;

import java.util.List;
import me.lyft.android.domain.geo.Leg;
import rx.functions.Action1;

class DirectionsCacheDecorator$1
  implements Action1<List<Leg>>
{
  DirectionsCacheDecorator$1(DirectionsCacheDecorator paramDirectionsCacheDecorator, List paramList) {}
  
  public void call(List<Leg> paramList)
  {
    DirectionsCacheDecorator.access$000(this$0).cache(val$route, paramList);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.geo.routecache.DirectionsCacheDecorator.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */