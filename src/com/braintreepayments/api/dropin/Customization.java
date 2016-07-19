package com.braintreepayments.api.dropin;

import java.io.Serializable;

public class Customization
  implements Serializable
{
  private int mActionBarLogo;
  private String mActionBarTitle;
  private String mAmount;
  private String mPrimaryDescription;
  private String mSecondaryDescription;
  private String mSubmitButtonText;
  
  protected int getActionBarLogo()
  {
    return mActionBarLogo;
  }
  
  protected String getActionBarTitle()
  {
    return mActionBarTitle;
  }
  
  protected String getAmount()
  {
    return mAmount;
  }
  
  protected String getPrimaryDescription()
  {
    return mPrimaryDescription;
  }
  
  protected String getSecondaryDescription()
  {
    return mSecondaryDescription;
  }
  
  protected String getSubmitButtonText()
  {
    return mSubmitButtonText;
  }
  
  protected void setActionBarLogo(int paramInt)
  {
    mActionBarLogo = paramInt;
  }
  
  protected void setActionBarTitle(String paramString)
  {
    mActionBarTitle = paramString;
  }
  
  protected void setAmount(String paramString)
  {
    mAmount = paramString;
  }
  
  protected void setPrimaryDescription(String paramString)
  {
    mPrimaryDescription = paramString;
  }
  
  protected void setSecondaryDescription(String paramString)
  {
    mSecondaryDescription = paramString;
  }
  
  protected void setSubmitButtonText(String paramString)
  {
    mSubmitButtonText = paramString;
  }
  
  public static class CustomizationBuilder
  {
    private Customization mCustomization = new Customization();
    
    public CustomizationBuilder actionBarLogo(int paramInt)
    {
      mCustomization.setActionBarLogo(paramInt);
      return this;
    }
    
    public CustomizationBuilder actionBarTitle(String paramString)
    {
      mCustomization.setActionBarTitle(paramString);
      return this;
    }
    
    public CustomizationBuilder amount(String paramString)
    {
      mCustomization.setAmount(paramString);
      return this;
    }
    
    public Customization build()
    {
      return mCustomization;
    }
    
    public CustomizationBuilder primaryDescription(String paramString)
    {
      mCustomization.setPrimaryDescription(paramString);
      return this;
    }
    
    public CustomizationBuilder secondaryDescription(String paramString)
    {
      mCustomization.setSecondaryDescription(paramString);
      return this;
    }
    
    public CustomizationBuilder submitButtonText(String paramString)
    {
      mCustomization.setSubmitButtonText(paramString);
      return this;
    }
  }
}

/* Location:
 * Qualified Name:     com.braintreepayments.api.dropin.Customization
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */