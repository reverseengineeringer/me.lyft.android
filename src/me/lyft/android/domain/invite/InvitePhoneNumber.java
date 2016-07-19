package me.lyft.android.domain.invite;

import me.lyft.android.common.INullable;

public class InvitePhoneNumber
  implements INullable
{
  private String label;
  private String phone;
  
  public InvitePhoneNumber(String paramString1, String paramString2)
  {
    phone = paramString1;
    label = paramString2;
  }
  
  public static InvitePhoneNumber empty()
  {
    return NullInvitePhoneNumber.INSTANCE;
  }
  
  public String getLabel()
  {
    return label;
  }
  
  public String getPhone()
  {
    return phone;
  }
  
  public boolean isNull()
  {
    return false;
  }
  
  private static class NullInvitePhoneNumber
    extends InvitePhoneNumber
  {
    private static final InvitePhoneNumber INSTANCE = new NullInvitePhoneNumber();
    
    public NullInvitePhoneNumber()
    {
      super("");
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.invite.InvitePhoneNumber
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */