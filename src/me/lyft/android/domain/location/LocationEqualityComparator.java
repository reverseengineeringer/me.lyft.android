package me.lyft.android.domain.location;

import me.lyft.android.rx.ReactiveProperty.EqualityComparator;

public class LocationEqualityComparator
  implements ReactiveProperty.EqualityComparator<Location>
{
  public boolean equals(Location paramLocation1, Location paramLocation2)
  {
    if (paramLocation1 == paramLocation2) {
      return true;
    }
    if ((paramLocation1 == null) || (paramLocation2 == null)) {
      return false;
    }
    return paramLocation1.hasSameCoordinates(paramLocation2);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.location.LocationEqualityComparator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */