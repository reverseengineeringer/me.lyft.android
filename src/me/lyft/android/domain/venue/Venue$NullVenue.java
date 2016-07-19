package me.lyft.android.domain.venue;

import java.util.Collections;

class Venue$NullVenue
  extends Venue
{
  private static Venue INSTANCE = new NullVenue();
  
  private Venue$NullVenue()
  {
    super("null_venue", null, "", "", Collections.emptyList(), Collections.emptyList(), 0);
  }
  
  static Venue getInstance()
  {
    return INSTANCE;
  }
  
  public boolean isNull()
  {
    return true;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.venue.Venue.NullVenue
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */