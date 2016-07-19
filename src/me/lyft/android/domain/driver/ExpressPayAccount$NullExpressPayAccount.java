package me.lyft.android.domain.driver;

class ExpressPayAccount$NullExpressPayAccount
  extends ExpressPayAccount
{
  private static final ExpressPayAccount INSTANCE = new NullExpressPayAccount();
  
  public ExpressPayAccount$NullExpressPayAccount()
  {
    super("", "", "", "", false, "");
  }
  
  public boolean isNull()
  {
    return true;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.driver.ExpressPayAccount.NullExpressPayAccount
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */