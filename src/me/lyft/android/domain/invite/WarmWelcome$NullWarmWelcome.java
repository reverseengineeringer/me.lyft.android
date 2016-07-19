package me.lyft.android.domain.invite;

class WarmWelcome$NullWarmWelcome
  extends WarmWelcome
{
  private static WarmWelcome INSTANCE = new NullWarmWelcome();
  
  private WarmWelcome$NullWarmWelcome()
  {
    super(null, null, null, null);
  }
  
  public static WarmWelcome getInstance()
  {
    return INSTANCE;
  }
  
  public boolean isNull()
  {
    return true;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.invite.WarmWelcome.NullWarmWelcome
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */