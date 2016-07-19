package io.card.payment;

class DetectionInfo
{
  public boolean bottomEdge;
  public boolean complete = false;
  public CreditCard detectedCard;
  public int expiry_month;
  public int expiry_year;
  public float focusScore;
  public boolean leftEdge;
  public int[] prediction = new int[16];
  public boolean rightEdge;
  public boolean topEdge;
  
  public DetectionInfo()
  {
    prediction[0] = -1;
    prediction[15] = -1;
    detectedCard = new CreditCard();
  }
  
  CreditCard creditCard()
  {
    String str = new String();
    int i = 0;
    while ((i < 16) && (prediction[i] >= 0) && (prediction[i] < 10))
    {
      str = str + String.valueOf(prediction[i]);
      i += 1;
    }
    detectedCard.cardNumber = str;
    detectedCard.expiryMonth = expiry_month;
    detectedCard.expiryYear = expiry_year;
    return detectedCard;
  }
  
  boolean detected()
  {
    return (topEdge) && (bottomEdge) && (rightEdge) && (leftEdge);
  }
  
  int numVisibleEdges()
  {
    int m = 1;
    int i;
    int j;
    label21:
    int k;
    if (topEdge)
    {
      i = 1;
      if (!bottomEdge) {
        break label51;
      }
      j = 1;
      if (!leftEdge) {
        break label56;
      }
      k = 1;
      label30:
      if (!rightEdge) {
        break label61;
      }
    }
    for (;;)
    {
      return k + (j + i) + m;
      i = 0;
      break;
      label51:
      j = 0;
      break label21;
      label56:
      k = 0;
      break label30;
      label61:
      m = 0;
    }
  }
  
  boolean predicted()
  {
    return complete;
  }
  
  boolean sameEdgesAs(DetectionInfo paramDetectionInfo)
  {
    return (topEdge == topEdge) && (bottomEdge == bottomEdge) && (leftEdge == leftEdge) && (rightEdge == rightEdge);
  }
}

/* Location:
 * Qualified Name:     io.card.payment.DetectionInfo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */