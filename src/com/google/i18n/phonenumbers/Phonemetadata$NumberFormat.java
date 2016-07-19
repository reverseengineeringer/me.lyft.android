package com.google.i18n.phonenumbers;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.List;

public class Phonemetadata$NumberFormat
  implements Externalizable
{
  private static final long serialVersionUID = 1L;
  private String domesticCarrierCodeFormattingRule_ = "";
  private String format_ = "";
  private boolean hasDomesticCarrierCodeFormattingRule;
  private boolean hasFormat;
  private boolean hasNationalPrefixFormattingRule;
  private boolean hasNationalPrefixOptionalWhenFormatting;
  private boolean hasPattern;
  private List<String> leadingDigitsPattern_ = new ArrayList();
  private String nationalPrefixFormattingRule_ = "";
  private boolean nationalPrefixOptionalWhenFormatting_ = false;
  private String pattern_ = "";
  
  public String getDomesticCarrierCodeFormattingRule()
  {
    return domesticCarrierCodeFormattingRule_;
  }
  
  public String getFormat()
  {
    return format_;
  }
  
  public String getLeadingDigitsPattern(int paramInt)
  {
    return (String)leadingDigitsPattern_.get(paramInt);
  }
  
  public String getNationalPrefixFormattingRule()
  {
    return nationalPrefixFormattingRule_;
  }
  
  public String getPattern()
  {
    return pattern_;
  }
  
  public boolean isNationalPrefixOptionalWhenFormatting()
  {
    return nationalPrefixOptionalWhenFormatting_;
  }
  
  public int leadingDigitsPatternSize()
  {
    return leadingDigitsPattern_.size();
  }
  
  public void readExternal(ObjectInput paramObjectInput)
    throws IOException
  {
    setPattern(paramObjectInput.readUTF());
    setFormat(paramObjectInput.readUTF());
    int j = paramObjectInput.readInt();
    int i = 0;
    while (i < j)
    {
      leadingDigitsPattern_.add(paramObjectInput.readUTF());
      i += 1;
    }
    if (paramObjectInput.readBoolean()) {
      setNationalPrefixFormattingRule(paramObjectInput.readUTF());
    }
    if (paramObjectInput.readBoolean()) {
      setDomesticCarrierCodeFormattingRule(paramObjectInput.readUTF());
    }
    setNationalPrefixOptionalWhenFormatting(paramObjectInput.readBoolean());
  }
  
  public NumberFormat setDomesticCarrierCodeFormattingRule(String paramString)
  {
    hasDomesticCarrierCodeFormattingRule = true;
    domesticCarrierCodeFormattingRule_ = paramString;
    return this;
  }
  
  public NumberFormat setFormat(String paramString)
  {
    hasFormat = true;
    format_ = paramString;
    return this;
  }
  
  public NumberFormat setNationalPrefixFormattingRule(String paramString)
  {
    hasNationalPrefixFormattingRule = true;
    nationalPrefixFormattingRule_ = paramString;
    return this;
  }
  
  public NumberFormat setNationalPrefixOptionalWhenFormatting(boolean paramBoolean)
  {
    hasNationalPrefixOptionalWhenFormatting = true;
    nationalPrefixOptionalWhenFormatting_ = paramBoolean;
    return this;
  }
  
  public NumberFormat setPattern(String paramString)
  {
    hasPattern = true;
    pattern_ = paramString;
    return this;
  }
  
  public void writeExternal(ObjectOutput paramObjectOutput)
    throws IOException
  {
    paramObjectOutput.writeUTF(pattern_);
    paramObjectOutput.writeUTF(format_);
    int j = leadingDigitsPatternSize();
    paramObjectOutput.writeInt(j);
    int i = 0;
    while (i < j)
    {
      paramObjectOutput.writeUTF((String)leadingDigitsPattern_.get(i));
      i += 1;
    }
    paramObjectOutput.writeBoolean(hasNationalPrefixFormattingRule);
    if (hasNationalPrefixFormattingRule) {
      paramObjectOutput.writeUTF(nationalPrefixFormattingRule_);
    }
    paramObjectOutput.writeBoolean(hasDomesticCarrierCodeFormattingRule);
    if (hasDomesticCarrierCodeFormattingRule) {
      paramObjectOutput.writeUTF(domesticCarrierCodeFormattingRule_);
    }
    paramObjectOutput.writeBoolean(nationalPrefixOptionalWhenFormatting_);
  }
}

/* Location:
 * Qualified Name:     com.google.i18n.phonenumbers.Phonemetadata.NumberFormat
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */