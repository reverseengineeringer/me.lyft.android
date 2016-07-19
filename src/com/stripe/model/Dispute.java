package com.stripe.model;

import java.util.List;
import java.util.Map;

public class Dispute
  extends StripeObject
{
  Integer amount;
  String balanceTransaction;
  List<BalanceTransaction> balanceTransactions;
  String charge;
  Long created;
  String currency;
  String evidence;
  EvidenceDetails evidenceDetails;
  Long evidenceDueBy;
  EvidenceSubObject evidenceSubObject;
  Boolean isChargeRefundable;
  Boolean livemode;
  Map<String, String> metadata;
  String reason;
  String status;
  
  public Integer getAmount()
  {
    return amount;
  }
  
  public String getBalanceTransaction()
  {
    return balanceTransaction;
  }
  
  public List<BalanceTransaction> getBalanceTransactions()
  {
    return balanceTransactions;
  }
  
  public String getCharge()
  {
    return charge;
  }
  
  public Long getCreated()
  {
    return created;
  }
  
  public String getCurrency()
  {
    return currency;
  }
  
  public String getEvidence()
  {
    return evidence;
  }
  
  public EvidenceDetails getEvidenceDetails()
  {
    return evidenceDetails;
  }
  
  public Long getEvidenceDueBy()
  {
    return evidenceDueBy;
  }
  
  public EvidenceSubObject getEvidenceSubObject()
  {
    return evidenceSubObject;
  }
  
  public boolean getIsChargeRefundable()
  {
    return isChargeRefundable.booleanValue();
  }
  
  public Boolean getLivemode()
  {
    return livemode;
  }
  
  public Map<String, String> getMetadata()
  {
    return metadata;
  }
  
  public String getReason()
  {
    return reason;
  }
  
  public String getStatus()
  {
    return status;
  }
  
  public void setAmount(Integer paramInteger)
  {
    amount = paramInteger;
  }
  
  public void setBalanceTransaction(String paramString)
  {
    balanceTransaction = paramString;
  }
  
  public void setBalanceTransactions(List<BalanceTransaction> paramList)
  {
    balanceTransactions = paramList;
  }
  
  public void setCharge(String paramString)
  {
    charge = paramString;
  }
  
  public void setCreated(Long paramLong)
  {
    created = paramLong;
  }
  
  public void setCurrency(String paramString)
  {
    currency = paramString;
  }
  
  public void setEvidence(String paramString)
  {
    evidence = paramString;
  }
  
  public void setEvidenceDetails(EvidenceDetails paramEvidenceDetails)
  {
    evidenceDetails = paramEvidenceDetails;
  }
  
  public void setEvidenceDueBy(Long paramLong)
  {
    evidenceDueBy = paramLong;
  }
  
  public void setEvidenceSubObject(EvidenceSubObject paramEvidenceSubObject)
  {
    evidenceSubObject = paramEvidenceSubObject;
  }
  
  public void setIsChargeRefundable(Boolean paramBoolean)
  {
    isChargeRefundable = paramBoolean;
  }
  
  public void setLivemode(Boolean paramBoolean)
  {
    livemode = paramBoolean;
  }
  
  public void setMetadata(Map<String, String> paramMap)
  {
    metadata = paramMap;
  }
  
  public void setReason(String paramString)
  {
    reason = paramString;
  }
  
  public void setStatus(String paramString)
  {
    status = paramString;
  }
}

/* Location:
 * Qualified Name:     com.stripe.model.Dispute
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */