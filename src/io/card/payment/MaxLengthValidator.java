package io.card.payment;

class MaxLengthValidator
  extends NonEmptyValidator
  implements Validator
{
  private int maxLength;
  
  MaxLengthValidator(int paramInt)
  {
    maxLength = paramInt;
  }
  
  public boolean isValid()
  {
    return (super.isValid()) && (getValue().length() <= maxLength);
  }
}

/* Location:
 * Qualified Name:     io.card.payment.MaxLengthValidator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */