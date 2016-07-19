package com.google.i18n.phonenumbers;

import java.io.InputStream;

final class PhoneNumberUtil$1
  implements MetadataLoader
{
  public InputStream loadMetadata(String paramString)
  {
    return PhoneNumberUtil.class.getResourceAsStream(paramString);
  }
}

/* Location:
 * Qualified Name:     com.google.i18n.phonenumbers.PhoneNumberUtil.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */