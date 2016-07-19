package me.lyft.android.domain.invite;

import me.lyft.android.common.INullable;

public class InviteText
  implements INullable
{
  private String benefitsUrl;
  private String emailBody;
  private String emailSubject;
  private String smsBody;
  
  public InviteText(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    emailSubject = paramString1;
    emailBody = paramString2;
    smsBody = paramString3;
    benefitsUrl = paramString4;
  }
  
  public static InviteText empty()
  {
    return NullInviteText.INSTANCE;
  }
  
  public String getBenefitsUrl()
  {
    return benefitsUrl;
  }
  
  public String getEmailBody()
  {
    return emailBody;
  }
  
  public String getEmailSubject()
  {
    return emailSubject;
  }
  
  public String getSmsBody()
  {
    return smsBody;
  }
  
  public boolean isNull()
  {
    return false;
  }
  
  public static class NullInviteText
    extends InviteText
  {
    private static final InviteText INSTANCE = new NullInviteText();
    
    public NullInviteText()
    {
      super("", "", "");
    }
    
    public boolean isNull()
    {
      return true;
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.invite.InviteText
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */