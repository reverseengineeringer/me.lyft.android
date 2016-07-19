package com.squareup.okhttp;

import okio.Buffer;

public final class FormEncodingBuilder
{
  private static final MediaType CONTENT_TYPE = MediaType.parse("application/x-www-form-urlencoded");
  private final Buffer content = new Buffer();
  
  public FormEncodingBuilder add(String paramString1, String paramString2)
  {
    if (content.size() > 0L) {
      content.writeByte(38);
    }
    HttpUrl.canonicalize(content, paramString1, 0, paramString1.length(), " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, true, true);
    content.writeByte(61);
    HttpUrl.canonicalize(content, paramString2, 0, paramString2.length(), " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, true, true);
    return this;
  }
  
  public FormEncodingBuilder addEncoded(String paramString1, String paramString2)
  {
    if (content.size() > 0L) {
      content.writeByte(38);
    }
    HttpUrl.canonicalize(content, paramString1, 0, paramString1.length(), " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, true, true);
    content.writeByte(61);
    HttpUrl.canonicalize(content, paramString2, 0, paramString2.length(), " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, true, true);
    return this;
  }
  
  public RequestBody build()
  {
    return RequestBody.create(CONTENT_TYPE, content.snapshot());
  }
}

/* Location:
 * Qualified Name:     com.squareup.okhttp.FormEncodingBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */