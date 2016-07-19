package com.braintreepayments.api.dropin;

public class Customization$CustomizationBuilder
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

/* Location:
 * Qualified Name:     com.braintreepayments.api.dropin.Customization.CustomizationBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */