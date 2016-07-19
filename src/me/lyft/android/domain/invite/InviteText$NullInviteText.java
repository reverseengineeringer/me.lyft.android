package me.lyft.android.domain.invite;

public class InviteText$NullInviteText
  extends InviteText
{
  private static final InviteText INSTANCE = new NullInviteText();
  
  public InviteText$NullInviteText()
  {
    super("", "", "", "");
  }
  
  public boolean isNull()
  {
    return true;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.invite.InviteText.NullInviteText
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */