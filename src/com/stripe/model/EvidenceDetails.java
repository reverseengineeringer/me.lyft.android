package com.stripe.model;

public final class EvidenceDetails
  extends StripeObject
{
  protected Long dueBy;
  protected Integer submissionCount;
  
  public Long getDueBy()
  {
    return dueBy;
  }
  
  public Integer getSubmissionCount()
  {
    return submissionCount;
  }
  
  public void setDueBy(Long paramLong)
  {
    dueBy = paramLong;
  }
  
  public void setSubmissionCount(Integer paramInteger)
  {
    submissionCount = paramInteger;
  }
}

/* Location:
 * Qualified Name:     com.stripe.model.EvidenceDetails
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */