package me.lyft.android.domain.invite;

public class Invite
{
  private final String cardDescription;
  private final String cardTitle;
  private final String clipboardContent;
  private final String emailContent;
  private final String emailSubject;
  private final String smsContent;
  
  public Invite(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    emailSubject = paramString1;
    emailContent = paramString2;
    smsContent = paramString3;
    clipboardContent = paramString4;
    cardTitle = paramString5;
    cardDescription = paramString6;
  }
  
  public String getCardDescription()
  {
    return cardDescription;
  }
  
  public String getCardTitle()
  {
    return cardTitle;
  }
  
  public String getClipboardContent()
  {
    return clipboardContent;
  }
  
  public String getEmailContent()
  {
    return emailContent;
  }
  
  public String getEmailSubject()
  {
    return emailSubject;
  }
  
  public String getSmsContent()
  {
    return smsContent;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.invite.Invite
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */