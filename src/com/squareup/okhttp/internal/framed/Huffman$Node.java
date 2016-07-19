package com.squareup.okhttp.internal.framed;

final class Huffman$Node
{
  private final Node[] children;
  private final int symbol;
  private final int terminalBits;
  
  Huffman$Node()
  {
    children = new Node['Ā'];
    symbol = 0;
    terminalBits = 0;
  }
  
  Huffman$Node(int paramInt1, int paramInt2)
  {
    children = null;
    symbol = paramInt1;
    paramInt2 &= 0x7;
    paramInt1 = paramInt2;
    if (paramInt2 == 0) {
      paramInt1 = 8;
    }
    terminalBits = paramInt1;
  }
}

/* Location:
 * Qualified Name:     com.squareup.okhttp.internal.framed.Huffman.Node
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */