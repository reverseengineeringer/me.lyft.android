package me.lyft.android.domain.driver;

import java.util.List;

public class ExpressPayCard
  extends Card
{
  private String buttonText;
  
  public ExpressPayCard(Card.Style paramStyle, String paramString1, String paramString2, String paramString3, List<Dial> paramList, String paramString4, String paramString5)
  {
    super(paramStyle, paramString1, paramString2, paramString3, paramList, paramString5);
    buttonText = paramString4;
  }
  
  public String getButtonText()
  {
    return buttonText;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.driver.ExpressPayCard
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */