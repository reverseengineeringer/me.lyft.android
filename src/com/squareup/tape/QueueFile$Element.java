package com.squareup.tape;

class QueueFile$Element
{
  static final Element NULL = new Element(0, 0);
  final int length;
  final int position;
  
  QueueFile$Element(int paramInt1, int paramInt2)
  {
    position = paramInt1;
    length = paramInt2;
  }
  
  public String toString()
  {
    return getClass().getSimpleName() + "[" + "position = " + position + ", length = " + length + "]";
  }
}

/* Location:
 * Qualified Name:     com.squareup.tape.QueueFile.Element
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */