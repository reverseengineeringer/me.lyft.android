package com.stripe.model;

public class Summary
  extends StripeObject
{
  Integer adjustmentCount;
  Integer adjustmentGross;
  Integer chargeCount;
  Integer chargeFees;
  Integer chargeGross;
  Integer net;
  Integer refundCount;
  Integer refundFees;
  Integer refundGross;
  Integer validationCount;
  Integer validationFees;
  
  public Integer getAdjustmentCount()
  {
    return adjustmentCount;
  }
  
  public Integer getAdjustmentGross()
  {
    return adjustmentGross;
  }
  
  public Integer getChargeCount()
  {
    return chargeCount;
  }
  
  public Integer getChargeFees()
  {
    return chargeFees;
  }
  
  public Integer getChargeGross()
  {
    return chargeGross;
  }
  
  public Integer getNet()
  {
    return net;
  }
  
  public Integer getRefundCount()
  {
    return refundCount;
  }
  
  public Integer getRefundFees()
  {
    return refundFees;
  }
  
  public Integer getRefundGross()
  {
    return refundGross;
  }
  
  public Integer getValidationCount()
  {
    return validationCount;
  }
  
  public Integer getValidationFees()
  {
    return validationFees;
  }
  
  public void set(Integer paramInteger)
  {
    net = paramInteger;
  }
  
  public void setAdjustmentCount(Integer paramInteger)
  {
    adjustmentCount = paramInteger;
  }
  
  public void setAdjustmentGross(Integer paramInteger)
  {
    adjustmentGross = paramInteger;
  }
  
  public void setChargeCount(Integer paramInteger)
  {
    chargeCount = paramInteger;
  }
  
  public void setChargeFees(Integer paramInteger)
  {
    chargeFees = paramInteger;
  }
  
  public void setChargeGross(Integer paramInteger)
  {
    chargeGross = paramInteger;
  }
  
  public void setRefundCount(Integer paramInteger)
  {
    refundCount = paramInteger;
  }
  
  public void setRefundFees(Integer paramInteger)
  {
    refundFees = paramInteger;
  }
  
  public void setRefundGross(Integer paramInteger)
  {
    refundGross = paramInteger;
  }
  
  public void setValidationCount(Integer paramInteger)
  {
    validationCount = paramInteger;
  }
  
  public void setValidationFees(Integer paramInteger)
  {
    validationFees = paramInteger;
  }
}

/* Location:
 * Qualified Name:     com.stripe.model.Summary
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */