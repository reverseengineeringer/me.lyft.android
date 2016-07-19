package com.stripe.model;

public final class EvidenceSubObject
  extends StripeObject
{
  protected String accessActivityLog;
  protected String billingAddress;
  protected String cancellationPolicy;
  protected String cancellationPolicyDisclosure;
  protected String cancellationRebuttal;
  protected String customerCommunication;
  protected String customerEmailAddress;
  protected String customerName;
  protected String customerPurchaseIp;
  protected String customerSignature;
  protected String duplicateChargeDocumentation;
  protected String duplicateChargeExplanation;
  protected String duplicateChargeId;
  protected String productDescription;
  protected String receipt;
  protected String refundPolicy;
  protected String refundPolicyDisclosure;
  protected String refundRefusalExplanation;
  protected String serviceDate;
  protected String serviceDocumentation;
  protected String shippingAddress;
  protected String shippingDate;
  protected String shippingDocumentation;
  protected String shippingTrackingNumber;
  protected String uncategorizedFile;
  protected String uncategorizedText;
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (EvidenceSubObject)paramObject;
      if (accessActivityLog != null)
      {
        if (accessActivityLog.equals(accessActivityLog)) {}
      }
      else {
        while (accessActivityLog != null) {
          return false;
        }
      }
      if (billingAddress != null)
      {
        if (billingAddress.equals(billingAddress)) {}
      }
      else {
        while (billingAddress != null) {
          return false;
        }
      }
      if (cancellationPolicy != null)
      {
        if (cancellationPolicy.equals(cancellationPolicy)) {}
      }
      else {
        while (cancellationPolicy != null) {
          return false;
        }
      }
      if (cancellationPolicyDisclosure != null)
      {
        if (cancellationPolicyDisclosure.equals(cancellationPolicyDisclosure)) {}
      }
      else {
        while (cancellationPolicyDisclosure != null) {
          return false;
        }
      }
      if (cancellationRebuttal != null)
      {
        if (cancellationRebuttal.equals(cancellationRebuttal)) {}
      }
      else {
        while (cancellationRebuttal != null) {
          return false;
        }
      }
      if (customerCommunication != null)
      {
        if (customerCommunication.equals(customerCommunication)) {}
      }
      else {
        while (customerCommunication != null) {
          return false;
        }
      }
      if (customerEmailAddress != null)
      {
        if (customerEmailAddress.equals(customerEmailAddress)) {}
      }
      else {
        while (customerEmailAddress != null) {
          return false;
        }
      }
      if (customerName != null)
      {
        if (customerName.equals(customerName)) {}
      }
      else {
        while (customerName != null) {
          return false;
        }
      }
      if (customerPurchaseIp != null)
      {
        if (customerPurchaseIp.equals(customerPurchaseIp)) {}
      }
      else {
        while (customerPurchaseIp != null) {
          return false;
        }
      }
      if (customerSignature != null)
      {
        if (customerSignature.equals(customerSignature)) {}
      }
      else {
        while (customerSignature != null) {
          return false;
        }
      }
      if (duplicateChargeDocumentation != null)
      {
        if (duplicateChargeDocumentation.equals(duplicateChargeDocumentation)) {}
      }
      else {
        while (duplicateChargeDocumentation != null) {
          return false;
        }
      }
      if (duplicateChargeExplanation != null)
      {
        if (duplicateChargeExplanation.equals(duplicateChargeExplanation)) {}
      }
      else {
        while (duplicateChargeExplanation != null) {
          return false;
        }
      }
      if (duplicateChargeId != null)
      {
        if (duplicateChargeId.equals(duplicateChargeId)) {}
      }
      else {
        while (duplicateChargeId != null) {
          return false;
        }
      }
      if (productDescription != null)
      {
        if (productDescription.equals(productDescription)) {}
      }
      else {
        while (productDescription != null) {
          return false;
        }
      }
      if (receipt != null)
      {
        if (receipt.equals(receipt)) {}
      }
      else {
        while (receipt != null) {
          return false;
        }
      }
      if (refundPolicy != null)
      {
        if (refundPolicy.equals(refundPolicy)) {}
      }
      else {
        while (refundPolicy != null) {
          return false;
        }
      }
      if (refundPolicyDisclosure != null)
      {
        if (refundPolicyDisclosure.equals(refundPolicyDisclosure)) {}
      }
      else {
        while (refundPolicyDisclosure != null) {
          return false;
        }
      }
      if (refundRefusalExplanation != null)
      {
        if (refundRefusalExplanation.equals(refundRefusalExplanation)) {}
      }
      else {
        while (refundRefusalExplanation != null) {
          return false;
        }
      }
      if (serviceDate != null)
      {
        if (serviceDate.equals(serviceDate)) {}
      }
      else {
        while (serviceDate != null) {
          return false;
        }
      }
      if (serviceDocumentation != null)
      {
        if (serviceDocumentation.equals(serviceDocumentation)) {}
      }
      else {
        while (serviceDocumentation != null) {
          return false;
        }
      }
      if (shippingAddress != null)
      {
        if (shippingAddress.equals(shippingAddress)) {}
      }
      else {
        while (shippingAddress != null) {
          return false;
        }
      }
      if (shippingDate != null)
      {
        if (shippingDate.equals(shippingDate)) {}
      }
      else {
        while (shippingDate != null) {
          return false;
        }
      }
      if (shippingDocumentation != null)
      {
        if (shippingDocumentation.equals(shippingDocumentation)) {}
      }
      else {
        while (shippingDocumentation != null) {
          return false;
        }
      }
      if (shippingTrackingNumber != null)
      {
        if (shippingTrackingNumber.equals(shippingTrackingNumber)) {}
      }
      else {
        while (shippingTrackingNumber != null) {
          return false;
        }
      }
      if (uncategorizedFile != null)
      {
        if (uncategorizedFile.equals(uncategorizedFile)) {}
      }
      else {
        while (uncategorizedFile != null) {
          return false;
        }
      }
      if (uncategorizedText == null) {
        break;
      }
    } while (uncategorizedText.equals(uncategorizedText));
    for (;;)
    {
      return false;
      if (uncategorizedText == null) {
        break;
      }
    }
  }
  
  public String getAccessActivityLog()
  {
    return accessActivityLog;
  }
  
  public String getBillingAddress()
  {
    return billingAddress;
  }
  
  public String getCancellationPolicy()
  {
    return cancellationPolicy;
  }
  
  public String getCancellationPolicyDisclosure()
  {
    return cancellationPolicyDisclosure;
  }
  
  public String getCancellationRebuttal()
  {
    return cancellationRebuttal;
  }
  
  public String getCustomerCommunication()
  {
    return customerCommunication;
  }
  
  public String getCustomerEmailAddress()
  {
    return customerEmailAddress;
  }
  
  public String getCustomerName()
  {
    return customerName;
  }
  
  public String getCustomerPurchaseIp()
  {
    return customerPurchaseIp;
  }
  
  public String getCustomerSignature()
  {
    return customerSignature;
  }
  
  public String getDuplicateChargeDocumentation()
  {
    return duplicateChargeDocumentation;
  }
  
  public String getDuplicateChargeExplanation()
  {
    return duplicateChargeExplanation;
  }
  
  public String getDuplicateChargeId()
  {
    return duplicateChargeId;
  }
  
  public String getProductDescription()
  {
    return productDescription;
  }
  
  public String getReceipt()
  {
    return receipt;
  }
  
  public String getRefundPolicy()
  {
    return refundPolicy;
  }
  
  public String getRefundPolicyDisclosure()
  {
    return refundPolicyDisclosure;
  }
  
  public String getRefundRefusalExplanation()
  {
    return refundRefusalExplanation;
  }
  
  public String getServiceDate()
  {
    return serviceDate;
  }
  
  public String getServiceDocumentation()
  {
    return serviceDocumentation;
  }
  
  public String getShippingAddress()
  {
    return shippingAddress;
  }
  
  public String getShippingDate()
  {
    return shippingDate;
  }
  
  public String getShippingDocumentation()
  {
    return shippingDocumentation;
  }
  
  public String getShippingTrackingNumber()
  {
    return shippingTrackingNumber;
  }
  
  public String getUncategorizedFile()
  {
    return uncategorizedFile;
  }
  
  public String getUncategorizedText()
  {
    return uncategorizedText;
  }
  
  public int hashCode()
  {
    int i21 = 0;
    int i;
    int j;
    label33:
    int k;
    label48:
    int m;
    label64:
    int n;
    label80:
    int i1;
    label96:
    int i2;
    label112:
    int i3;
    label128:
    int i4;
    label144:
    int i5;
    label160:
    int i6;
    label176:
    int i7;
    label192:
    int i8;
    label208:
    int i9;
    label224:
    int i10;
    label240:
    int i11;
    label256:
    int i12;
    label272:
    int i13;
    label288:
    int i14;
    label304:
    int i15;
    label320:
    int i16;
    label336:
    int i17;
    label352:
    int i18;
    label368:
    int i19;
    if (productDescription != null)
    {
      i = productDescription.hashCode();
      if (customerName == null) {
        break label571;
      }
      j = customerName.hashCode();
      if (customerEmailAddress == null) {
        break label576;
      }
      k = customerEmailAddress.hashCode();
      if (customerPurchaseIp == null) {
        break label581;
      }
      m = customerPurchaseIp.hashCode();
      if (billingAddress == null) {
        break label587;
      }
      n = billingAddress.hashCode();
      if (receipt == null) {
        break label593;
      }
      i1 = receipt.hashCode();
      if (shippingAddress == null) {
        break label599;
      }
      i2 = shippingAddress.hashCode();
      if (shippingDate == null) {
        break label605;
      }
      i3 = shippingDate.hashCode();
      if (shippingTrackingNumber == null) {
        break label611;
      }
      i4 = shippingTrackingNumber.hashCode();
      if (customerSignature == null) {
        break label617;
      }
      i5 = customerSignature.hashCode();
      if (shippingDocumentation == null) {
        break label623;
      }
      i6 = shippingDocumentation.hashCode();
      if (accessActivityLog == null) {
        break label629;
      }
      i7 = accessActivityLog.hashCode();
      if (serviceDate == null) {
        break label635;
      }
      i8 = serviceDate.hashCode();
      if (serviceDocumentation == null) {
        break label641;
      }
      i9 = serviceDocumentation.hashCode();
      if (customerCommunication == null) {
        break label647;
      }
      i10 = customerCommunication.hashCode();
      if (duplicateChargeId == null) {
        break label653;
      }
      i11 = duplicateChargeId.hashCode();
      if (duplicateChargeExplanation == null) {
        break label659;
      }
      i12 = duplicateChargeExplanation.hashCode();
      if (duplicateChargeDocumentation == null) {
        break label665;
      }
      i13 = duplicateChargeDocumentation.hashCode();
      if (refundPolicy == null) {
        break label671;
      }
      i14 = refundPolicy.hashCode();
      if (refundPolicyDisclosure == null) {
        break label677;
      }
      i15 = refundPolicyDisclosure.hashCode();
      if (refundRefusalExplanation == null) {
        break label683;
      }
      i16 = refundRefusalExplanation.hashCode();
      if (cancellationPolicy == null) {
        break label689;
      }
      i17 = cancellationPolicy.hashCode();
      if (cancellationPolicyDisclosure == null) {
        break label695;
      }
      i18 = cancellationPolicyDisclosure.hashCode();
      if (cancellationRebuttal == null) {
        break label701;
      }
      i19 = cancellationRebuttal.hashCode();
      label384:
      if (uncategorizedText == null) {
        break label707;
      }
    }
    label571:
    label576:
    label581:
    label587:
    label593:
    label599:
    label605:
    label611:
    label617:
    label623:
    label629:
    label635:
    label641:
    label647:
    label653:
    label659:
    label665:
    label671:
    label677:
    label683:
    label689:
    label695:
    label701:
    label707:
    for (int i20 = uncategorizedText.hashCode();; i20 = 0)
    {
      if (uncategorizedFile != null) {
        i21 = uncategorizedFile.hashCode();
      }
      return ((((((((((((((((((((((((i * 31 + j) * 31 + k) * 31 + m) * 31 + n) * 31 + i1) * 31 + i2) * 31 + i3) * 31 + i4) * 31 + i5) * 31 + i6) * 31 + i7) * 31 + i8) * 31 + i9) * 31 + i10) * 31 + i11) * 31 + i12) * 31 + i13) * 31 + i14) * 31 + i15) * 31 + i16) * 31 + i17) * 31 + i18) * 31 + i19) * 31 + i20) * 31 + i21;
      i = 0;
      break;
      j = 0;
      break label33;
      k = 0;
      break label48;
      m = 0;
      break label64;
      n = 0;
      break label80;
      i1 = 0;
      break label96;
      i2 = 0;
      break label112;
      i3 = 0;
      break label128;
      i4 = 0;
      break label144;
      i5 = 0;
      break label160;
      i6 = 0;
      break label176;
      i7 = 0;
      break label192;
      i8 = 0;
      break label208;
      i9 = 0;
      break label224;
      i10 = 0;
      break label240;
      i11 = 0;
      break label256;
      i12 = 0;
      break label272;
      i13 = 0;
      break label288;
      i14 = 0;
      break label304;
      i15 = 0;
      break label320;
      i16 = 0;
      break label336;
      i17 = 0;
      break label352;
      i18 = 0;
      break label368;
      i19 = 0;
      break label384;
    }
  }
  
  public void setAccessActivityLog(String paramString)
  {
    accessActivityLog = paramString;
  }
  
  public void setBillingAddress(String paramString)
  {
    billingAddress = paramString;
  }
  
  public void setCancellationPolicy(String paramString)
  {
    cancellationPolicy = paramString;
  }
  
  public void setCancellationPolicyDisclosure(String paramString)
  {
    cancellationPolicyDisclosure = paramString;
  }
  
  public void setCancellationRebuttal(String paramString)
  {
    cancellationRebuttal = paramString;
  }
  
  public void setCustomerCommunication(String paramString)
  {
    customerCommunication = paramString;
  }
  
  public void setCustomerEmailAddress(String paramString)
  {
    customerEmailAddress = paramString;
  }
  
  public void setCustomerName(String paramString)
  {
    customerName = paramString;
  }
  
  public void setCustomerPurchaseIp(String paramString)
  {
    customerPurchaseIp = paramString;
  }
  
  public void setCustomerSignature(String paramString)
  {
    customerSignature = paramString;
  }
  
  public void setDuplicateChargeDocumentation(String paramString)
  {
    duplicateChargeDocumentation = paramString;
  }
  
  public void setDuplicateChargeExplanation(String paramString)
  {
    duplicateChargeExplanation = paramString;
  }
  
  public void setDuplicateChargeId(String paramString)
  {
    duplicateChargeId = paramString;
  }
  
  public void setProductDescription(String paramString)
  {
    productDescription = paramString;
  }
  
  public void setReceipt(String paramString)
  {
    receipt = paramString;
  }
  
  public void setRefundPolicy(String paramString)
  {
    refundPolicy = paramString;
  }
  
  public void setRefundPolicyDisclosure(String paramString)
  {
    refundPolicyDisclosure = paramString;
  }
  
  public void setRefundRefusalExplanation(String paramString)
  {
    refundRefusalExplanation = paramString;
  }
  
  public void setServiceDate(String paramString)
  {
    serviceDate = paramString;
  }
  
  public void setServiceDocumentation(String paramString)
  {
    serviceDocumentation = paramString;
  }
  
  public void setShippingAddress(String paramString)
  {
    shippingAddress = paramString;
  }
  
  public void setShippingDate(String paramString)
  {
    shippingDate = paramString;
  }
  
  public void setShippingDocumentation(String paramString)
  {
    shippingDocumentation = paramString;
  }
  
  public void setShippingTrackingNumber(String paramString)
  {
    shippingTrackingNumber = paramString;
  }
  
  public void setUncategorizedFile(String paramString)
  {
    uncategorizedFile = paramString;
  }
  
  public void setUncategorizedText(String paramString)
  {
    uncategorizedText = paramString;
  }
}

/* Location:
 * Qualified Name:     com.stripe.model.EvidenceSubObject
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */