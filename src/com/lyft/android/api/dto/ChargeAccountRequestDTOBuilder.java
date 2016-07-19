package com.lyft.android.api.dto;

public class ChargeAccountRequestDTOBuilder
{
  private Boolean _default;
  private String chargeToken;
  private String clientPaymentMethod;
  private Boolean defaultBusiness;
  private String label;
  private String labelType;
  private String nonce;
  private String token;
  
  public ChargeAccountRequestDTO build()
  {
    return new ChargeAccountRequestDTO(clientPaymentMethod, token, _default, defaultBusiness, labelType, label, nonce, chargeToken);
  }
  
  public ChargeAccountRequestDTOBuilder withChargeToken(String paramString)
  {
    chargeToken = paramString;
    return this;
  }
  
  public ChargeAccountRequestDTOBuilder withClientPaymentMethod(String paramString)
  {
    clientPaymentMethod = paramString;
    return this;
  }
  
  public ChargeAccountRequestDTOBuilder withDefault(Boolean paramBoolean)
  {
    _default = paramBoolean;
    return this;
  }
  
  public ChargeAccountRequestDTOBuilder withDefaultBusiness(Boolean paramBoolean)
  {
    defaultBusiness = paramBoolean;
    return this;
  }
  
  public ChargeAccountRequestDTOBuilder withLabel(String paramString)
  {
    label = paramString;
    return this;
  }
  
  public ChargeAccountRequestDTOBuilder withNonce(String paramString)
  {
    nonce = paramString;
    return this;
  }
  
  public ChargeAccountRequestDTOBuilder withToken(String paramString)
  {
    token = paramString;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.ChargeAccountRequestDTOBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */