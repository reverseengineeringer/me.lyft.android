package com.appboy.enums;

public enum ErrorType
{
  static
  {
    BAD_INPUT = new ErrorType("BAD_INPUT", 1);
    NO_DEVICE_IDENTIFIER = new ErrorType("NO_DEVICE_IDENTIFIER", 2);
  }
  
  private ErrorType() {}
}

/* Location:
 * Qualified Name:     com.appboy.enums.ErrorType
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */