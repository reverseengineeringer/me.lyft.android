package com.google.gson.stream;

import com.google.gson.internal.JsonReaderInternalAccess;
import com.google.gson.internal.bind.JsonTreeReader;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;

public class JsonReader
  implements Closeable
{
  private static final char[] NON_EXECUTE_PREFIX = ")]}'\n".toCharArray();
  private final char[] buffer = new char['Ѐ'];
  private final Reader in;
  private boolean lenient = false;
  private int limit = 0;
  private int lineNumber = 0;
  private int lineStart = 0;
  private int[] pathIndices;
  private String[] pathNames;
  int peeked = 0;
  private long peekedLong;
  private int peekedNumberLength;
  private String peekedString;
  private int pos = 0;
  private int[] stack = new int[32];
  private int stackSize = 0;
  
  static
  {
    JsonReaderInternalAccess.INSTANCE = new JsonReaderInternalAccess()
    {
      public void promoteNameToValue(JsonReader paramAnonymousJsonReader)
        throws IOException
      {
        if ((paramAnonymousJsonReader instanceof JsonTreeReader))
        {
          ((JsonTreeReader)paramAnonymousJsonReader).promoteNameToValue();
          return;
        }
        int j = peeked;
        int i = j;
        if (j == 0) {
          i = paramAnonymousJsonReader.doPeek();
        }
        if (i == 13)
        {
          peeked = 9;
          return;
        }
        if (i == 12)
        {
          peeked = 8;
          return;
        }
        if (i == 14)
        {
          peeked = 10;
          return;
        }
        throw new IllegalStateException("Expected a name but was " + paramAnonymousJsonReader.peek() + " " + " at line " + paramAnonymousJsonReader.getLineNumber() + " column " + paramAnonymousJsonReader.getColumnNumber() + " path " + paramAnonymousJsonReader.getPath());
      }
    };
  }
  
  public JsonReader(Reader paramReader)
  {
    int[] arrayOfInt = stack;
    int i = stackSize;
    stackSize = (i + 1);
    arrayOfInt[i] = 6;
    pathNames = new String[32];
    pathIndices = new int[32];
    if (paramReader == null) {
      throw new NullPointerException("in == null");
    }
    in = paramReader;
  }
  
  private void checkLenient()
    throws IOException
  {
    if (!lenient) {
      throw syntaxError("Use JsonReader.setLenient(true) to accept malformed JSON");
    }
  }
  
  private void consumeNonExecutePrefix()
    throws IOException
  {
    nextNonWhitespace(true);
    pos -= 1;
    if ((pos + NON_EXECUTE_PREFIX.length > limit) && (!fillBuffer(NON_EXECUTE_PREFIX.length))) {
      return;
    }
    int i = 0;
    for (;;)
    {
      if (i >= NON_EXECUTE_PREFIX.length) {
        break label80;
      }
      if (buffer[(pos + i)] != NON_EXECUTE_PREFIX[i]) {
        break;
      }
      i += 1;
    }
    label80:
    pos += NON_EXECUTE_PREFIX.length;
  }
  
  private boolean fillBuffer(int paramInt)
    throws IOException
  {
    boolean bool2 = false;
    char[] arrayOfChar = buffer;
    lineStart -= pos;
    if (limit != pos)
    {
      limit -= pos;
      System.arraycopy(arrayOfChar, pos, arrayOfChar, 0, limit);
    }
    for (;;)
    {
      pos = 0;
      int i;
      do
      {
        i = in.read(arrayOfChar, limit, arrayOfChar.length - limit);
        bool1 = bool2;
        if (i == -1) {
          break;
        }
        limit += i;
        i = paramInt;
        if (lineNumber == 0)
        {
          i = paramInt;
          if (lineStart == 0)
          {
            i = paramInt;
            if (limit > 0)
            {
              i = paramInt;
              if (arrayOfChar[0] == 65279)
              {
                pos += 1;
                lineStart += 1;
                i = paramInt + 1;
              }
            }
          }
        }
        paramInt = i;
      } while (limit < i);
      boolean bool1 = true;
      return bool1;
      limit = 0;
    }
  }
  
  private boolean isLiteral(char paramChar)
    throws IOException
  {
    switch (paramChar)
    {
    default: 
      return true;
    case '#': 
    case '/': 
    case ';': 
    case '=': 
    case '\\': 
      checkLenient();
    }
    return false;
  }
  
  private int nextNonWhitespace(boolean paramBoolean)
    throws IOException
  {
    char[] arrayOfChar = buffer;
    int i = pos;
    int j = limit;
    for (;;)
    {
      int k = j;
      int m = i;
      if (i == j)
      {
        pos = i;
        if (!fillBuffer(1))
        {
          if (paramBoolean) {
            throw new EOFException("End of input at line " + getLineNumber() + " column " + getColumnNumber());
          }
        }
        else
        {
          m = pos;
          k = limit;
        }
      }
      else
      {
        i = m + 1;
        j = arrayOfChar[m];
        if (j == 10)
        {
          lineNumber += 1;
          lineStart = i;
          j = k;
          continue;
        }
        if ((j == 32) || (j == 13)) {
          break label359;
        }
        if (j == 9)
        {
          j = k;
          continue;
        }
        if (j == 47)
        {
          pos = i;
          if (i == k)
          {
            pos -= 1;
            boolean bool = fillBuffer(2);
            pos += 1;
            if (!bool) {
              return j;
            }
          }
          checkLenient();
          switch (arrayOfChar[pos])
          {
          default: 
            return j;
          case '*': 
            pos += 1;
            if (!skipTo("*/")) {
              throw syntaxError("Unterminated comment");
            }
            i = pos + 2;
            j = limit;
            break;
          case '/': 
            pos += 1;
            skipToEndOfLine();
            i = pos;
            j = limit;
            break;
          }
        }
        if (j == 35)
        {
          pos = i;
          checkLenient();
          skipToEndOfLine();
          i = pos;
          j = limit;
          continue;
        }
        pos = i;
        return j;
      }
      return -1;
      label359:
      j = k;
    }
  }
  
  private String nextQuotedValue(char paramChar)
    throws IOException
  {
    char[] arrayOfChar = buffer;
    StringBuilder localStringBuilder = new StringBuilder();
    do
    {
      int i = pos;
      int m = limit;
      int k = i;
      if (i < m)
      {
        int i1 = i + 1;
        char c = arrayOfChar[i];
        if (c == paramChar)
        {
          pos = i1;
          localStringBuilder.append(arrayOfChar, k, i1 - k - 1);
          return localStringBuilder.toString();
        }
        int n;
        int j;
        if (c == '\\')
        {
          pos = i1;
          localStringBuilder.append(arrayOfChar, k, i1 - k - 1);
          localStringBuilder.append(readEscapeCharacter());
          i = pos;
          n = limit;
          j = i;
        }
        for (;;)
        {
          m = n;
          k = j;
          break;
          n = m;
          i = i1;
          j = k;
          if (c == '\n')
          {
            lineNumber += 1;
            lineStart = i1;
            n = m;
            i = i1;
            j = k;
          }
        }
      }
      localStringBuilder.append(arrayOfChar, k, i - k);
      pos = i;
    } while (fillBuffer(1));
    throw syntaxError("Unterminated string");
  }
  
  private String nextUnquotedValue()
    throws IOException
  {
    Object localObject1 = null;
    int i = 0;
    Object localObject2;
    int j;
    while (pos + i < limit)
    {
      localObject2 = localObject1;
      j = i;
      switch (buffer[(pos + i)])
      {
      default: 
        i += 1;
        break;
      case '#': 
      case '/': 
      case ';': 
      case '=': 
      case '\\': 
        checkLenient();
        j = i;
        localObject2 = localObject1;
      case '\t': 
      case '\n': 
      case '\f': 
      case '\r': 
      case ' ': 
      case ',': 
      case ':': 
      case '[': 
      case ']': 
      case '{': 
      case '}': 
        label188:
        if (localObject2 != null) {
          break label308;
        }
      }
    }
    for (localObject1 = new String(buffer, pos, j);; localObject1 = ((StringBuilder)localObject2).toString())
    {
      pos += j;
      return (String)localObject1;
      if (i < buffer.length)
      {
        localObject2 = localObject1;
        j = i;
        if (!fillBuffer(i + 1)) {
          break label188;
        }
        break;
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = new StringBuilder();
      }
      ((StringBuilder)localObject2).append(buffer, pos, i);
      pos += i;
      j = 0;
      i = 0;
      localObject1 = localObject2;
      if (fillBuffer(1)) {
        break;
      }
      break label188;
      label308:
      ((StringBuilder)localObject2).append(buffer, pos, j);
    }
  }
  
  private int peekKeyword()
    throws IOException
  {
    int i = buffer[pos];
    String str1;
    String str2;
    int k;
    int j;
    if ((i == 116) || (i == 84))
    {
      str1 = "true";
      str2 = "TRUE";
      i = 5;
      k = str1.length();
      j = 1;
    }
    for (;;)
    {
      if (j >= k) {
        break label168;
      }
      if ((pos + j >= limit) && (!fillBuffer(j + 1)))
      {
        return 0;
        if ((i == 102) || (i == 70))
        {
          str1 = "false";
          str2 = "FALSE";
          i = 6;
          break;
        }
        if ((i == 110) || (i == 78))
        {
          str1 = "null";
          str2 = "NULL";
          i = 7;
          break;
        }
        return 0;
      }
      int m = buffer[(pos + j)];
      if ((m != str1.charAt(j)) && (m != str2.charAt(j))) {
        return 0;
      }
      j += 1;
    }
    label168:
    if (((pos + k < limit) || (fillBuffer(k + 1))) && (isLiteral(buffer[(pos + k)]))) {
      return 0;
    }
    pos += k;
    peeked = i;
    return i;
  }
  
  private int peekNumber()
    throws IOException
  {
    char[] arrayOfChar = buffer;
    int i = pos;
    int i3 = limit;
    long l1 = 0L;
    int j = 0;
    int m = 1;
    int i2 = 0;
    int k = 0;
    int i1 = i3;
    int n = i;
    if (i + k == i3)
    {
      if (k == arrayOfChar.length) {
        return 0;
      }
      if (!fillBuffer(k + 1))
      {
        if ((i2 != 2) || (m == 0) || ((l1 == Long.MIN_VALUE) && (j == 0))) {
          break label552;
        }
        if (j == 0) {
          break label544;
        }
      }
    }
    for (;;)
    {
      peekedLong = l1;
      pos += k;
      peeked = 15;
      return 15;
      n = pos;
      i1 = limit;
      char c = arrayOfChar[(n + k)];
      int i4;
      long l2;
      switch (c)
      {
      default: 
        if ((c < '0') || (c > '9'))
        {
          if (!isLiteral(c)) {
            break;
          }
          return 0;
        }
      case '-': 
        if (i2 == 0)
        {
          i4 = 1;
          i = 1;
          l2 = l1;
          i3 = m;
        }
      case '+': 
      case 'E': 
      case 'e': 
      case '.': 
        for (;;)
        {
          k += 1;
          m = i3;
          i3 = i1;
          i2 = i;
          j = i4;
          i = n;
          l1 = l2;
          break;
          if (i2 == 5)
          {
            i = 6;
            i3 = m;
            i4 = j;
            l2 = l1;
          }
          else
          {
            return 0;
            if (i2 == 5)
            {
              i = 6;
              i3 = m;
              i4 = j;
              l2 = l1;
            }
            else
            {
              return 0;
              if ((i2 == 2) || (i2 == 4))
              {
                i = 5;
                i3 = m;
                i4 = j;
                l2 = l1;
              }
              else
              {
                return 0;
                if (i2 == 2)
                {
                  i = 3;
                  i3 = m;
                  i4 = j;
                  l2 = l1;
                }
                else
                {
                  return 0;
                  if ((i2 == 1) || (i2 == 0))
                  {
                    l2 = -(c - '0');
                    i = 2;
                    i3 = m;
                    i4 = j;
                  }
                  else
                  {
                    if (i2 == 2)
                    {
                      if (l1 == 0L) {
                        return 0;
                      }
                      l2 = 10L * l1 - (c - '0');
                      if ((l1 > -922337203685477580L) || ((l1 == -922337203685477580L) && (l2 < l1))) {}
                      for (i = 1;; i = 0)
                      {
                        i3 = m & i;
                        i = i2;
                        i4 = j;
                        break;
                      }
                    }
                    if (i2 == 3)
                    {
                      i = 4;
                      i3 = m;
                      i4 = j;
                      l2 = l1;
                    }
                    else if (i2 != 5)
                    {
                      i3 = m;
                      i = i2;
                      i4 = j;
                      l2 = l1;
                      if (i2 != 6) {}
                    }
                    else
                    {
                      i = 7;
                      i3 = m;
                      i4 = j;
                      l2 = l1;
                    }
                  }
                }
              }
            }
          }
        }
        label544:
        l1 = -l1;
      }
    }
    label552:
    if ((i2 == 2) || (i2 == 4) || (i2 == 7))
    {
      peekedNumberLength = k;
      peeked = 16;
      return 16;
    }
    return 0;
  }
  
  private void push(int paramInt)
  {
    if (stackSize == stack.length)
    {
      arrayOfInt1 = new int[stackSize * 2];
      int[] arrayOfInt2 = new int[stackSize * 2];
      String[] arrayOfString = new String[stackSize * 2];
      System.arraycopy(stack, 0, arrayOfInt1, 0, stackSize);
      System.arraycopy(pathIndices, 0, arrayOfInt2, 0, stackSize);
      System.arraycopy(pathNames, 0, arrayOfString, 0, stackSize);
      stack = arrayOfInt1;
      pathIndices = arrayOfInt2;
      pathNames = arrayOfString;
    }
    int[] arrayOfInt1 = stack;
    int i = stackSize;
    stackSize = (i + 1);
    arrayOfInt1[i] = paramInt;
  }
  
  private char readEscapeCharacter()
    throws IOException
  {
    if ((pos == limit) && (!fillBuffer(1))) {
      throw syntaxError("Unterminated escape sequence");
    }
    char[] arrayOfChar = buffer;
    int i = pos;
    pos = (i + 1);
    char c = arrayOfChar[i];
    switch (c)
    {
    }
    for (;;)
    {
      return c;
      if ((pos + 4 > limit) && (!fillBuffer(4))) {
        throw syntaxError("Unterminated escape sequence");
      }
      c = '\000';
      int j = pos;
      i = j;
      if (i < j + 4)
      {
        int k = buffer[i];
        int m = (char)(c << '\004');
        if ((k >= 48) && (k <= 57)) {
          c = (char)(k - 48 + m);
        }
        for (;;)
        {
          i += 1;
          break;
          if ((k >= 97) && (k <= 102))
          {
            c = (char)(k - 97 + 10 + m);
          }
          else
          {
            if ((k < 65) || (k > 70)) {
              break label267;
            }
            c = (char)(k - 65 + 10 + m);
          }
        }
        label267:
        throw new NumberFormatException("\\u" + new String(buffer, pos, 4));
      }
      pos += 4;
      return c;
      return '\t';
      return '\b';
      return '\n';
      return '\r';
      return '\f';
      lineNumber += 1;
      lineStart = pos;
    }
  }
  
  private void skipQuotedValue(char paramChar)
    throws IOException
  {
    char[] arrayOfChar = buffer;
    do
    {
      int i = pos;
      int j = limit;
      if (i < j)
      {
        int m = i + 1;
        char c = arrayOfChar[i];
        if (c == paramChar)
        {
          pos = m;
          return;
        }
        int k;
        if (c == '\\')
        {
          pos = m;
          readEscapeCharacter();
          i = pos;
          k = limit;
        }
        for (;;)
        {
          j = k;
          break;
          k = j;
          i = m;
          if (c == '\n')
          {
            lineNumber += 1;
            lineStart = m;
            k = j;
            i = m;
          }
        }
      }
      pos = i;
    } while (fillBuffer(1));
    throw syntaxError("Unterminated string");
  }
  
  private boolean skipTo(String paramString)
    throws IOException
  {
    while ((pos + paramString.length() <= limit) || (fillBuffer(paramString.length()))) {
      if (buffer[pos] == '\n')
      {
        lineNumber += 1;
        lineStart = (pos + 1);
        pos += 1;
      }
      else
      {
        int i = 0;
        for (;;)
        {
          if (i >= paramString.length()) {
            break label110;
          }
          if (buffer[(pos + i)] != paramString.charAt(i)) {
            break;
          }
          i += 1;
        }
        label110:
        return true;
      }
    }
    return false;
  }
  
  private void skipToEndOfLine()
    throws IOException
  {
    int i;
    do
    {
      if ((pos < limit) || (fillBuffer(1)))
      {
        char[] arrayOfChar = buffer;
        i = pos;
        pos = (i + 1);
        i = arrayOfChar[i];
        if (i == 10)
        {
          lineNumber += 1;
          lineStart = pos;
        }
      }
      else
      {
        return;
      }
    } while (i != 13);
  }
  
  private void skipUnquotedValue()
    throws IOException
  {
    do
    {
      int i = 0;
      while (pos + i < limit) {
        switch (buffer[(pos + i)])
        {
        default: 
          i += 1;
          break;
        case '#': 
        case '/': 
        case ';': 
        case '=': 
        case '\\': 
          checkLenient();
        case '\t': 
        case '\n': 
        case '\f': 
        case '\r': 
        case ' ': 
        case ',': 
        case ':': 
        case '[': 
        case ']': 
        case '{': 
        case '}': 
          pos += i;
          return;
        }
      }
      pos += i;
    } while (fillBuffer(1));
  }
  
  private IOException syntaxError(String paramString)
    throws IOException
  {
    throw new MalformedJsonException(paramString + " at line " + getLineNumber() + " column " + getColumnNumber() + " path " + getPath());
  }
  
  public void beginArray()
    throws IOException
  {
    int j = peeked;
    int i = j;
    if (j == 0) {
      i = doPeek();
    }
    if (i == 3)
    {
      push(1);
      pathIndices[(stackSize - 1)] = 0;
      peeked = 0;
      return;
    }
    throw new IllegalStateException("Expected BEGIN_ARRAY but was " + peek() + " at line " + getLineNumber() + " column " + getColumnNumber() + " path " + getPath());
  }
  
  public void beginObject()
    throws IOException
  {
    int j = peeked;
    int i = j;
    if (j == 0) {
      i = doPeek();
    }
    if (i == 1)
    {
      push(3);
      peeked = 0;
      return;
    }
    throw new IllegalStateException("Expected BEGIN_OBJECT but was " + peek() + " at line " + getLineNumber() + " column " + getColumnNumber() + " path " + getPath());
  }
  
  public void close()
    throws IOException
  {
    peeked = 0;
    stack[0] = 8;
    stackSize = 1;
    in.close();
  }
  
  int doPeek()
    throws IOException
  {
    int i = stack[(stackSize - 1)];
    if (i == 1)
    {
      stack[(stackSize - 1)] = 2;
      switch (nextNonWhitespace(true))
      {
      default: 
        pos -= 1;
        i = peekKeyword();
        if (i == 0) {
          break;
        }
      }
    }
    int j;
    do
    {
      return i;
      if (i == 2)
      {
        switch (nextNonWhitespace(true))
        {
        case 44: 
        default: 
          throw syntaxError("Unterminated array");
        case 93: 
          peeked = 4;
          return 4;
        }
        checkLenient();
        break;
      }
      if ((i == 3) || (i == 5))
      {
        stack[(stackSize - 1)] = 4;
        if (i == 5) {
          switch (nextNonWhitespace(true))
          {
          default: 
            throw syntaxError("Unterminated object");
          case 125: 
            peeked = 2;
            return 2;
          case 59: 
            checkLenient();
          }
        }
        j = nextNonWhitespace(true);
        switch (j)
        {
        default: 
          checkLenient();
          pos -= 1;
          if (isLiteral((char)j))
          {
            peeked = 14;
            return 14;
          }
          break;
        case 34: 
          peeked = 13;
          return 13;
        case 39: 
          checkLenient();
          peeked = 12;
          return 12;
        case 125: 
          if (i != 5)
          {
            peeked = 2;
            return 2;
          }
          throw syntaxError("Expected name");
        }
        throw syntaxError("Expected name");
      }
      if (i == 4)
      {
        stack[(stackSize - 1)] = 5;
        switch (nextNonWhitespace(true))
        {
        case 58: 
        case 59: 
        case 60: 
        default: 
          throw syntaxError("Expected ':'");
        }
        checkLenient();
        if (((pos >= limit) && (!fillBuffer(1))) || (buffer[pos] != '>')) {
          break;
        }
        pos += 1;
        break;
      }
      if (i == 6)
      {
        if (lenient) {
          consumeNonExecutePrefix();
        }
        stack[(stackSize - 1)] = 7;
        break;
      }
      if (i == 7)
      {
        if (nextNonWhitespace(false) == -1)
        {
          peeked = 17;
          return 17;
        }
        checkLenient();
        pos -= 1;
        break;
      }
      if (i != 8) {
        break;
      }
      throw new IllegalStateException("JsonReader is closed");
      if (i == 1)
      {
        peeked = 4;
        return 4;
      }
      if ((i == 1) || (i == 2))
      {
        checkLenient();
        pos -= 1;
        peeked = 7;
        return 7;
      }
      throw syntaxError("Unexpected value");
      checkLenient();
      peeked = 8;
      return 8;
      peeked = 9;
      return 9;
      peeked = 3;
      return 3;
      peeked = 1;
      return 1;
      j = peekNumber();
      i = j;
    } while (j != 0);
    if (!isLiteral(buffer[pos])) {
      throw syntaxError("Expected value");
    }
    checkLenient();
    peeked = 10;
    return 10;
  }
  
  public void endArray()
    throws IOException
  {
    int j = peeked;
    int i = j;
    if (j == 0) {
      i = doPeek();
    }
    if (i == 4)
    {
      stackSize -= 1;
      int[] arrayOfInt = pathIndices;
      i = stackSize - 1;
      arrayOfInt[i] += 1;
      peeked = 0;
      return;
    }
    throw new IllegalStateException("Expected END_ARRAY but was " + peek() + " at line " + getLineNumber() + " column " + getColumnNumber() + " path " + getPath());
  }
  
  public void endObject()
    throws IOException
  {
    int j = peeked;
    int i = j;
    if (j == 0) {
      i = doPeek();
    }
    if (i == 2)
    {
      stackSize -= 1;
      pathNames[stackSize] = null;
      int[] arrayOfInt = pathIndices;
      i = stackSize - 1;
      arrayOfInt[i] += 1;
      peeked = 0;
      return;
    }
    throw new IllegalStateException("Expected END_OBJECT but was " + peek() + " at line " + getLineNumber() + " column " + getColumnNumber() + " path " + getPath());
  }
  
  int getColumnNumber()
  {
    return pos - lineStart + 1;
  }
  
  int getLineNumber()
  {
    return lineNumber + 1;
  }
  
  public String getPath()
  {
    StringBuilder localStringBuilder = new StringBuilder().append('$');
    int i = 0;
    int j = stackSize;
    if (i < j)
    {
      switch (stack[i])
      {
      }
      for (;;)
      {
        i += 1;
        break;
        localStringBuilder.append('[').append(pathIndices[i]).append(']');
        continue;
        localStringBuilder.append('.');
        if (pathNames[i] != null) {
          localStringBuilder.append(pathNames[i]);
        }
      }
    }
    return localStringBuilder.toString();
  }
  
  public boolean hasNext()
    throws IOException
  {
    int j = peeked;
    int i = j;
    if (j == 0) {
      i = doPeek();
    }
    return (i != 2) && (i != 4);
  }
  
  public final boolean isLenient()
  {
    return lenient;
  }
  
  public boolean nextBoolean()
    throws IOException
  {
    int j = peeked;
    int i = j;
    if (j == 0) {
      i = doPeek();
    }
    int[] arrayOfInt;
    if (i == 5)
    {
      peeked = 0;
      arrayOfInt = pathIndices;
      i = stackSize - 1;
      arrayOfInt[i] += 1;
      return true;
    }
    if (i == 6)
    {
      peeked = 0;
      arrayOfInt = pathIndices;
      i = stackSize - 1;
      arrayOfInt[i] += 1;
      return false;
    }
    throw new IllegalStateException("Expected a boolean but was " + peek() + " at line " + getLineNumber() + " column " + getColumnNumber() + " path " + getPath());
  }
  
  public double nextDouble()
    throws IOException
  {
    int j = peeked;
    int i = j;
    if (j == 0) {
      i = doPeek();
    }
    if (i == 15)
    {
      peeked = 0;
      arrayOfInt = pathIndices;
      i = stackSize - 1;
      arrayOfInt[i] += 1;
      return peekedLong;
    }
    if (i == 16)
    {
      peekedString = new String(buffer, pos, peekedNumberLength);
      pos += peekedNumberLength;
    }
    double d;
    do
    {
      for (;;)
      {
        peeked = 11;
        d = Double.parseDouble(peekedString);
        if ((lenient) || ((!Double.isNaN(d)) && (!Double.isInfinite(d)))) {
          break label341;
        }
        throw new MalformedJsonException("JSON forbids NaN and infinities: " + d + " at line " + getLineNumber() + " column " + getColumnNumber() + " path " + getPath());
        if ((i == 8) || (i == 9))
        {
          if (i == 8) {}
          for (char c = '\'';; c = '"')
          {
            peekedString = nextQuotedValue(c);
            break;
          }
        }
        if (i != 10) {
          break;
        }
        peekedString = nextUnquotedValue();
      }
    } while (i == 11);
    throw new IllegalStateException("Expected a double but was " + peek() + " at line " + getLineNumber() + " column " + getColumnNumber() + " path " + getPath());
    label341:
    peekedString = null;
    peeked = 0;
    int[] arrayOfInt = pathIndices;
    i = stackSize - 1;
    arrayOfInt[i] += 1;
    return d;
  }
  
  public int nextInt()
    throws IOException
  {
    int j = peeked;
    int i = j;
    if (j == 0) {
      i = doPeek();
    }
    int[] arrayOfInt;
    if (i == 15)
    {
      i = (int)peekedLong;
      if (peekedLong != i) {
        throw new NumberFormatException("Expected an int but was " + peekedLong + " at line " + getLineNumber() + " column " + getColumnNumber() + " path " + getPath());
      }
      peeked = 0;
      arrayOfInt = pathIndices;
      j = stackSize - 1;
      arrayOfInt[j] += 1;
      return i;
    }
    if (i == 16)
    {
      peekedString = new String(buffer, pos, peekedNumberLength);
      pos += peekedNumberLength;
    }
    for (;;)
    {
      peeked = 11;
      double d = Double.parseDouble(peekedString);
      i = (int)d;
      if (i != d)
      {
        throw new NumberFormatException("Expected an int but was " + peekedString + " at line " + getLineNumber() + " column " + getColumnNumber() + " path " + getPath());
        if ((i == 8) || (i == 9))
        {
          if (i == 8) {}
          for (char c = '\'';; c = '"')
          {
            peekedString = nextQuotedValue(c);
            try
            {
              i = Integer.parseInt(peekedString);
              peeked = 0;
              arrayOfInt = pathIndices;
              j = stackSize - 1;
              arrayOfInt[j] += 1;
              return i;
            }
            catch (NumberFormatException localNumberFormatException) {}
          }
        }
        else
        {
          throw new IllegalStateException("Expected an int but was " + peek() + " at line " + getLineNumber() + " column " + getColumnNumber() + " path " + getPath());
        }
      }
      else
      {
        peekedString = null;
        peeked = 0;
        arrayOfInt = pathIndices;
        j = stackSize - 1;
        arrayOfInt[j] += 1;
        return i;
      }
    }
  }
  
  public long nextLong()
    throws IOException
  {
    int j = peeked;
    int i = j;
    if (j == 0) {
      i = doPeek();
    }
    int[] arrayOfInt1;
    if (i == 15)
    {
      peeked = 0;
      arrayOfInt1 = pathIndices;
      i = stackSize - 1;
      arrayOfInt1[i] += 1;
      return peekedLong;
    }
    long l;
    if (i == 16)
    {
      peekedString = new String(buffer, pos, peekedNumberLength);
      pos += peekedNumberLength;
      peeked = 11;
      double d = Double.parseDouble(peekedString);
      l = d;
      if (l != d) {
        throw new NumberFormatException("Expected a long but was " + peekedString + " at line " + getLineNumber() + " column " + getColumnNumber() + " path " + getPath());
      }
    }
    else
    {
      if ((i == 8) || (i == 9))
      {
        if (i == 8) {}
        for (char c = '\'';; c = '"')
        {
          peekedString = nextQuotedValue(c);
          try
          {
            l = Long.parseLong(peekedString);
            peeked = 0;
            arrayOfInt1 = pathIndices;
            i = stackSize - 1;
            arrayOfInt1[i] += 1;
            return l;
          }
          catch (NumberFormatException localNumberFormatException) {}
          break;
        }
      }
      throw new IllegalStateException("Expected a long but was " + peek() + " at line " + getLineNumber() + " column " + getColumnNumber() + " path " + getPath());
    }
    peekedString = null;
    peeked = 0;
    int[] arrayOfInt2 = pathIndices;
    i = stackSize - 1;
    arrayOfInt2[i] += 1;
    return l;
  }
  
  public String nextName()
    throws IOException
  {
    int j = peeked;
    int i = j;
    if (j == 0) {
      i = doPeek();
    }
    String str;
    if (i == 14) {
      str = nextUnquotedValue();
    }
    for (;;)
    {
      peeked = 0;
      pathNames[(stackSize - 1)] = str;
      return str;
      if (i == 12)
      {
        str = nextQuotedValue('\'');
      }
      else
      {
        if (i != 13) {
          break;
        }
        str = nextQuotedValue('"');
      }
    }
    throw new IllegalStateException("Expected a name but was " + peek() + " at line " + getLineNumber() + " column " + getColumnNumber() + " path " + getPath());
  }
  
  public void nextNull()
    throws IOException
  {
    int j = peeked;
    int i = j;
    if (j == 0) {
      i = doPeek();
    }
    if (i == 7)
    {
      peeked = 0;
      int[] arrayOfInt = pathIndices;
      i = stackSize - 1;
      arrayOfInt[i] += 1;
      return;
    }
    throw new IllegalStateException("Expected null but was " + peek() + " at line " + getLineNumber() + " column " + getColumnNumber() + " path " + getPath());
  }
  
  public String nextString()
    throws IOException
  {
    int j = peeked;
    int i = j;
    if (j == 0) {
      i = doPeek();
    }
    String str;
    if (i == 10) {
      str = nextUnquotedValue();
    }
    for (;;)
    {
      peeked = 0;
      int[] arrayOfInt = pathIndices;
      i = stackSize - 1;
      arrayOfInt[i] += 1;
      return str;
      if (i == 8)
      {
        str = nextQuotedValue('\'');
      }
      else if (i == 9)
      {
        str = nextQuotedValue('"');
      }
      else if (i == 11)
      {
        str = peekedString;
        peekedString = null;
      }
      else if (i == 15)
      {
        str = Long.toString(peekedLong);
      }
      else
      {
        if (i != 16) {
          break;
        }
        str = new String(buffer, pos, peekedNumberLength);
        pos += peekedNumberLength;
      }
    }
    throw new IllegalStateException("Expected a string but was " + peek() + " at line " + getLineNumber() + " column " + getColumnNumber() + " path " + getPath());
  }
  
  public JsonToken peek()
    throws IOException
  {
    int j = peeked;
    int i = j;
    if (j == 0) {
      i = doPeek();
    }
    switch (i)
    {
    default: 
      throw new AssertionError();
    case 1: 
      return JsonToken.BEGIN_OBJECT;
    case 2: 
      return JsonToken.END_OBJECT;
    case 3: 
      return JsonToken.BEGIN_ARRAY;
    case 4: 
      return JsonToken.END_ARRAY;
    case 12: 
    case 13: 
    case 14: 
      return JsonToken.NAME;
    case 5: 
    case 6: 
      return JsonToken.BOOLEAN;
    case 7: 
      return JsonToken.NULL;
    case 8: 
    case 9: 
    case 10: 
    case 11: 
      return JsonToken.STRING;
    case 15: 
    case 16: 
      return JsonToken.NUMBER;
    }
    return JsonToken.END_DOCUMENT;
  }
  
  public final void setLenient(boolean paramBoolean)
  {
    lenient = paramBoolean;
  }
  
  public void skipValue()
    throws IOException
  {
    int j = 0;
    int i = peeked;
    int k = i;
    if (i == 0) {
      k = doPeek();
    }
    if (k == 3)
    {
      push(1);
      i = j + 1;
    }
    for (;;)
    {
      peeked = 0;
      j = i;
      if (i != 0) {
        break;
      }
      int[] arrayOfInt = pathIndices;
      i = stackSize - 1;
      arrayOfInt[i] += 1;
      pathNames[(stackSize - 1)] = "null";
      return;
      if (k == 1)
      {
        push(3);
        i = j + 1;
      }
      else if (k == 4)
      {
        stackSize -= 1;
        i = j - 1;
      }
      else if (k == 2)
      {
        stackSize -= 1;
        i = j - 1;
      }
      else if ((k == 14) || (k == 10))
      {
        skipUnquotedValue();
        i = j;
      }
      else if ((k == 8) || (k == 12))
      {
        skipQuotedValue('\'');
        i = j;
      }
      else if ((k == 9) || (k == 13))
      {
        skipQuotedValue('"');
        i = j;
      }
      else
      {
        i = j;
        if (k == 16)
        {
          pos += peekedNumberLength;
          i = j;
        }
      }
    }
  }
  
  public String toString()
  {
    return getClass().getSimpleName() + " at line " + getLineNumber() + " column " + getColumnNumber();
  }
}

/* Location:
 * Qualified Name:     com.google.gson.stream.JsonReader
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */