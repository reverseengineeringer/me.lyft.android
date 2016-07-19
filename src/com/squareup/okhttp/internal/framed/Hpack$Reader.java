package com.squareup.okhttp.internal.framed;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import okio.Source;

final class Hpack$Reader
{
  Header[] dynamicTable = new Header[8];
  int dynamicTableByteCount = 0;
  int headerCount = 0;
  private final List<Header> headerList = new ArrayList();
  private int headerTableSizeSetting;
  private int maxDynamicTableByteCount;
  int nextHeaderIndex = dynamicTable.length - 1;
  private final BufferedSource source;
  
  Hpack$Reader(int paramInt, Source paramSource)
  {
    headerTableSizeSetting = paramInt;
    maxDynamicTableByteCount = paramInt;
    source = Okio.buffer(paramSource);
  }
  
  private void adjustDynamicTableByteCount()
  {
    if (maxDynamicTableByteCount < dynamicTableByteCount)
    {
      if (maxDynamicTableByteCount == 0) {
        clearDynamicTable();
      }
    }
    else {
      return;
    }
    evictToRecoverBytes(dynamicTableByteCount - maxDynamicTableByteCount);
  }
  
  private void clearDynamicTable()
  {
    headerList.clear();
    Arrays.fill(dynamicTable, null);
    nextHeaderIndex = (dynamicTable.length - 1);
    headerCount = 0;
    dynamicTableByteCount = 0;
  }
  
  private int dynamicTableIndex(int paramInt)
  {
    return nextHeaderIndex + 1 + paramInt;
  }
  
  private int evictToRecoverBytes(int paramInt)
  {
    int i = 0;
    int k = 0;
    if (paramInt > 0)
    {
      i = dynamicTable.length - 1;
      int j = paramInt;
      paramInt = k;
      while ((i >= nextHeaderIndex) && (j > 0))
      {
        j -= dynamicTable[i].hpackSize;
        dynamicTableByteCount -= dynamicTable[i].hpackSize;
        headerCount -= 1;
        paramInt += 1;
        i -= 1;
      }
      System.arraycopy(dynamicTable, nextHeaderIndex + 1, dynamicTable, nextHeaderIndex + 1 + paramInt, headerCount);
      nextHeaderIndex += paramInt;
      i = paramInt;
    }
    return i;
  }
  
  private ByteString getName(int paramInt)
  {
    if (isStaticHeader(paramInt)) {
      return access$000name;
    }
    return dynamicTable[dynamicTableIndex(paramInt - Hpack.access$000().length)].name;
  }
  
  private void insertIntoDynamicTable(int paramInt, Header paramHeader)
  {
    headerList.add(paramHeader);
    int j = hpackSize;
    int i = j;
    if (paramInt != -1) {
      i = j - dynamicTable[dynamicTableIndex(paramInt)].hpackSize;
    }
    if (i > maxDynamicTableByteCount)
    {
      clearDynamicTable();
      return;
    }
    j = evictToRecoverBytes(dynamicTableByteCount + i - maxDynamicTableByteCount);
    if (paramInt == -1)
    {
      if (headerCount + 1 > dynamicTable.length)
      {
        Header[] arrayOfHeader = new Header[dynamicTable.length * 2];
        System.arraycopy(dynamicTable, 0, arrayOfHeader, dynamicTable.length, dynamicTable.length);
        nextHeaderIndex = (dynamicTable.length - 1);
        dynamicTable = arrayOfHeader;
      }
      paramInt = nextHeaderIndex;
      nextHeaderIndex = (paramInt - 1);
      dynamicTable[paramInt] = paramHeader;
      headerCount += 1;
    }
    for (;;)
    {
      dynamicTableByteCount += i;
      return;
      int k = dynamicTableIndex(paramInt);
      dynamicTable[(paramInt + (k + j))] = paramHeader;
    }
  }
  
  private boolean isStaticHeader(int paramInt)
  {
    return (paramInt >= 0) && (paramInt <= Hpack.access$000().length - 1);
  }
  
  private int readByte()
    throws IOException
  {
    return source.readByte() & 0xFF;
  }
  
  private void readIndexedHeader(int paramInt)
    throws IOException
  {
    if (isStaticHeader(paramInt))
    {
      Header localHeader = Hpack.access$000()[paramInt];
      headerList.add(localHeader);
      return;
    }
    int i = dynamicTableIndex(paramInt - Hpack.access$000().length);
    if ((i < 0) || (i > dynamicTable.length - 1)) {
      throw new IOException("Header index too large " + (paramInt + 1));
    }
    headerList.add(dynamicTable[i]);
  }
  
  private void readLiteralHeaderWithIncrementalIndexingIndexedName(int paramInt)
    throws IOException
  {
    insertIntoDynamicTable(-1, new Header(getName(paramInt), readByteString()));
  }
  
  private void readLiteralHeaderWithIncrementalIndexingNewName()
    throws IOException
  {
    insertIntoDynamicTable(-1, new Header(Hpack.access$100(readByteString()), readByteString()));
  }
  
  private void readLiteralHeaderWithoutIndexingIndexedName(int paramInt)
    throws IOException
  {
    ByteString localByteString1 = getName(paramInt);
    ByteString localByteString2 = readByteString();
    headerList.add(new Header(localByteString1, localByteString2));
  }
  
  private void readLiteralHeaderWithoutIndexingNewName()
    throws IOException
  {
    ByteString localByteString1 = Hpack.access$100(readByteString());
    ByteString localByteString2 = readByteString();
    headerList.add(new Header(localByteString1, localByteString2));
  }
  
  public List<Header> getAndResetHeaderList()
  {
    ArrayList localArrayList = new ArrayList(headerList);
    headerList.clear();
    return localArrayList;
  }
  
  void headerTableSizeSetting(int paramInt)
  {
    headerTableSizeSetting = paramInt;
    maxDynamicTableByteCount = paramInt;
    adjustDynamicTableByteCount();
  }
  
  int maxDynamicTableByteCount()
  {
    return maxDynamicTableByteCount;
  }
  
  ByteString readByteString()
    throws IOException
  {
    int j = readByte();
    if ((j & 0x80) == 128) {}
    for (int i = 1;; i = 0)
    {
      j = readInt(j, 127);
      if (i == 0) {
        break;
      }
      return ByteString.of(Huffman.get().decode(source.readByteArray(j)));
    }
    return source.readByteString(j);
  }
  
  void readHeaders()
    throws IOException
  {
    while (!source.exhausted())
    {
      int i = source.readByte() & 0xFF;
      if (i == 128) {
        throw new IOException("index == 0");
      }
      if ((i & 0x80) == 128)
      {
        readIndexedHeader(readInt(i, 127) - 1);
      }
      else if (i == 64)
      {
        readLiteralHeaderWithIncrementalIndexingNewName();
      }
      else if ((i & 0x40) == 64)
      {
        readLiteralHeaderWithIncrementalIndexingIndexedName(readInt(i, 63) - 1);
      }
      else if ((i & 0x20) == 32)
      {
        maxDynamicTableByteCount = readInt(i, 31);
        if ((maxDynamicTableByteCount < 0) || (maxDynamicTableByteCount > headerTableSizeSetting)) {
          throw new IOException("Invalid dynamic table size update " + maxDynamicTableByteCount);
        }
        adjustDynamicTableByteCount();
      }
      else if ((i == 16) || (i == 0))
      {
        readLiteralHeaderWithoutIndexingNewName();
      }
      else
      {
        readLiteralHeaderWithoutIndexingIndexedName(readInt(i, 15) - 1);
      }
    }
  }
  
  int readInt(int paramInt1, int paramInt2)
    throws IOException
  {
    paramInt1 &= paramInt2;
    if (paramInt1 < paramInt2) {
      return paramInt1;
    }
    paramInt1 = 0;
    int i;
    for (;;)
    {
      i = readByte();
      if ((i & 0x80) == 0) {
        break;
      }
      paramInt2 += ((i & 0x7F) << paramInt1);
      paramInt1 += 7;
    }
    return paramInt2 + (i << paramInt1);
  }
}

/* Location:
 * Qualified Name:     com.squareup.okhttp.internal.framed.Hpack.Reader
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */