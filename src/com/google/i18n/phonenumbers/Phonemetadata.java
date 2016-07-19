package com.google.i18n.phonenumbers;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.List;

public final class Phonemetadata
{
  public static class NumberFormat
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
  
  public static class PhoneMetadata
    implements Externalizable
  {
    private static final long serialVersionUID = 1L;
    private Phonemetadata.PhoneNumberDesc carrierSpecific_ = null;
    private int countryCode_ = 0;
    private Phonemetadata.PhoneNumberDesc emergency_ = null;
    private Phonemetadata.PhoneNumberDesc fixedLine_ = null;
    private Phonemetadata.PhoneNumberDesc generalDesc_ = null;
    private boolean hasCarrierSpecific;
    private boolean hasCountryCode;
    private boolean hasEmergency;
    private boolean hasFixedLine;
    private boolean hasGeneralDesc;
    private boolean hasId;
    private boolean hasInternationalPrefix;
    private boolean hasLeadingDigits;
    private boolean hasLeadingZeroPossible;
    private boolean hasMainCountryForCode;
    private boolean hasMobile;
    private boolean hasMobileNumberPortableRegion;
    private boolean hasNationalPrefix;
    private boolean hasNationalPrefixForParsing;
    private boolean hasNationalPrefixTransformRule;
    private boolean hasNoInternationalDialling;
    private boolean hasPager;
    private boolean hasPersonalNumber;
    private boolean hasPreferredExtnPrefix;
    private boolean hasPreferredInternationalPrefix;
    private boolean hasPremiumRate;
    private boolean hasSameMobileAndFixedLinePattern;
    private boolean hasSharedCost;
    private boolean hasShortCode;
    private boolean hasStandardRate;
    private boolean hasTollFree;
    private boolean hasUan;
    private boolean hasVoicemail;
    private boolean hasVoip;
    private String id_ = "";
    private String internationalPrefix_ = "";
    private List<Phonemetadata.NumberFormat> intlNumberFormat_ = new ArrayList();
    private String leadingDigits_ = "";
    private boolean leadingZeroPossible_ = false;
    private boolean mainCountryForCode_ = false;
    private boolean mobileNumberPortableRegion_ = false;
    private Phonemetadata.PhoneNumberDesc mobile_ = null;
    private String nationalPrefixForParsing_ = "";
    private String nationalPrefixTransformRule_ = "";
    private String nationalPrefix_ = "";
    private Phonemetadata.PhoneNumberDesc noInternationalDialling_ = null;
    private List<Phonemetadata.NumberFormat> numberFormat_ = new ArrayList();
    private Phonemetadata.PhoneNumberDesc pager_ = null;
    private Phonemetadata.PhoneNumberDesc personalNumber_ = null;
    private String preferredExtnPrefix_ = "";
    private String preferredInternationalPrefix_ = "";
    private Phonemetadata.PhoneNumberDesc premiumRate_ = null;
    private boolean sameMobileAndFixedLinePattern_ = false;
    private Phonemetadata.PhoneNumberDesc sharedCost_ = null;
    private Phonemetadata.PhoneNumberDesc shortCode_ = null;
    private Phonemetadata.PhoneNumberDesc standardRate_ = null;
    private Phonemetadata.PhoneNumberDesc tollFree_ = null;
    private Phonemetadata.PhoneNumberDesc uan_ = null;
    private Phonemetadata.PhoneNumberDesc voicemail_ = null;
    private Phonemetadata.PhoneNumberDesc voip_ = null;
    
    public int getCountryCode()
    {
      return countryCode_;
    }
    
    public Phonemetadata.PhoneNumberDesc getFixedLine()
    {
      return fixedLine_;
    }
    
    public Phonemetadata.PhoneNumberDesc getGeneralDesc()
    {
      return generalDesc_;
    }
    
    public String getInternationalPrefix()
    {
      return internationalPrefix_;
    }
    
    public String getLeadingDigits()
    {
      return leadingDigits_;
    }
    
    public Phonemetadata.PhoneNumberDesc getMobile()
    {
      return mobile_;
    }
    
    public String getNationalPrefixForParsing()
    {
      return nationalPrefixForParsing_;
    }
    
    public String getNationalPrefixTransformRule()
    {
      return nationalPrefixTransformRule_;
    }
    
    public Phonemetadata.PhoneNumberDesc getPager()
    {
      return pager_;
    }
    
    public Phonemetadata.PhoneNumberDesc getPersonalNumber()
    {
      return personalNumber_;
    }
    
    public String getPreferredExtnPrefix()
    {
      return preferredExtnPrefix_;
    }
    
    public Phonemetadata.PhoneNumberDesc getPremiumRate()
    {
      return premiumRate_;
    }
    
    public Phonemetadata.PhoneNumberDesc getSharedCost()
    {
      return sharedCost_;
    }
    
    public Phonemetadata.PhoneNumberDesc getTollFree()
    {
      return tollFree_;
    }
    
    public Phonemetadata.PhoneNumberDesc getUan()
    {
      return uan_;
    }
    
    public Phonemetadata.PhoneNumberDesc getVoicemail()
    {
      return voicemail_;
    }
    
    public Phonemetadata.PhoneNumberDesc getVoip()
    {
      return voip_;
    }
    
    public boolean hasLeadingDigits()
    {
      return hasLeadingDigits;
    }
    
    public boolean hasNationalPrefix()
    {
      return hasNationalPrefix;
    }
    
    public boolean hasNationalPrefixForParsing()
    {
      return hasNationalPrefixForParsing;
    }
    
    public boolean hasPreferredExtnPrefix()
    {
      return hasPreferredExtnPrefix;
    }
    
    public int intlNumberFormatSize()
    {
      return intlNumberFormat_.size();
    }
    
    public List<Phonemetadata.NumberFormat> intlNumberFormats()
    {
      return intlNumberFormat_;
    }
    
    public boolean isSameMobileAndFixedLinePattern()
    {
      return sameMobileAndFixedLinePattern_;
    }
    
    public int numberFormatSize()
    {
      return numberFormat_.size();
    }
    
    public List<Phonemetadata.NumberFormat> numberFormats()
    {
      return numberFormat_;
    }
    
    public void readExternal(ObjectInput paramObjectInput)
      throws IOException
    {
      Object localObject;
      if (paramObjectInput.readBoolean())
      {
        localObject = new Phonemetadata.PhoneNumberDesc();
        ((Phonemetadata.PhoneNumberDesc)localObject).readExternal(paramObjectInput);
        setGeneralDesc((Phonemetadata.PhoneNumberDesc)localObject);
      }
      if (paramObjectInput.readBoolean())
      {
        localObject = new Phonemetadata.PhoneNumberDesc();
        ((Phonemetadata.PhoneNumberDesc)localObject).readExternal(paramObjectInput);
        setFixedLine((Phonemetadata.PhoneNumberDesc)localObject);
      }
      if (paramObjectInput.readBoolean())
      {
        localObject = new Phonemetadata.PhoneNumberDesc();
        ((Phonemetadata.PhoneNumberDesc)localObject).readExternal(paramObjectInput);
        setMobile((Phonemetadata.PhoneNumberDesc)localObject);
      }
      if (paramObjectInput.readBoolean())
      {
        localObject = new Phonemetadata.PhoneNumberDesc();
        ((Phonemetadata.PhoneNumberDesc)localObject).readExternal(paramObjectInput);
        setTollFree((Phonemetadata.PhoneNumberDesc)localObject);
      }
      if (paramObjectInput.readBoolean())
      {
        localObject = new Phonemetadata.PhoneNumberDesc();
        ((Phonemetadata.PhoneNumberDesc)localObject).readExternal(paramObjectInput);
        setPremiumRate((Phonemetadata.PhoneNumberDesc)localObject);
      }
      if (paramObjectInput.readBoolean())
      {
        localObject = new Phonemetadata.PhoneNumberDesc();
        ((Phonemetadata.PhoneNumberDesc)localObject).readExternal(paramObjectInput);
        setSharedCost((Phonemetadata.PhoneNumberDesc)localObject);
      }
      if (paramObjectInput.readBoolean())
      {
        localObject = new Phonemetadata.PhoneNumberDesc();
        ((Phonemetadata.PhoneNumberDesc)localObject).readExternal(paramObjectInput);
        setPersonalNumber((Phonemetadata.PhoneNumberDesc)localObject);
      }
      if (paramObjectInput.readBoolean())
      {
        localObject = new Phonemetadata.PhoneNumberDesc();
        ((Phonemetadata.PhoneNumberDesc)localObject).readExternal(paramObjectInput);
        setVoip((Phonemetadata.PhoneNumberDesc)localObject);
      }
      if (paramObjectInput.readBoolean())
      {
        localObject = new Phonemetadata.PhoneNumberDesc();
        ((Phonemetadata.PhoneNumberDesc)localObject).readExternal(paramObjectInput);
        setPager((Phonemetadata.PhoneNumberDesc)localObject);
      }
      if (paramObjectInput.readBoolean())
      {
        localObject = new Phonemetadata.PhoneNumberDesc();
        ((Phonemetadata.PhoneNumberDesc)localObject).readExternal(paramObjectInput);
        setUan((Phonemetadata.PhoneNumberDesc)localObject);
      }
      if (paramObjectInput.readBoolean())
      {
        localObject = new Phonemetadata.PhoneNumberDesc();
        ((Phonemetadata.PhoneNumberDesc)localObject).readExternal(paramObjectInput);
        setEmergency((Phonemetadata.PhoneNumberDesc)localObject);
      }
      if (paramObjectInput.readBoolean())
      {
        localObject = new Phonemetadata.PhoneNumberDesc();
        ((Phonemetadata.PhoneNumberDesc)localObject).readExternal(paramObjectInput);
        setVoicemail((Phonemetadata.PhoneNumberDesc)localObject);
      }
      if (paramObjectInput.readBoolean())
      {
        localObject = new Phonemetadata.PhoneNumberDesc();
        ((Phonemetadata.PhoneNumberDesc)localObject).readExternal(paramObjectInput);
        setShortCode((Phonemetadata.PhoneNumberDesc)localObject);
      }
      if (paramObjectInput.readBoolean())
      {
        localObject = new Phonemetadata.PhoneNumberDesc();
        ((Phonemetadata.PhoneNumberDesc)localObject).readExternal(paramObjectInput);
        setStandardRate((Phonemetadata.PhoneNumberDesc)localObject);
      }
      if (paramObjectInput.readBoolean())
      {
        localObject = new Phonemetadata.PhoneNumberDesc();
        ((Phonemetadata.PhoneNumberDesc)localObject).readExternal(paramObjectInput);
        setCarrierSpecific((Phonemetadata.PhoneNumberDesc)localObject);
      }
      if (paramObjectInput.readBoolean())
      {
        localObject = new Phonemetadata.PhoneNumberDesc();
        ((Phonemetadata.PhoneNumberDesc)localObject).readExternal(paramObjectInput);
        setNoInternationalDialling((Phonemetadata.PhoneNumberDesc)localObject);
      }
      setId(paramObjectInput.readUTF());
      setCountryCode(paramObjectInput.readInt());
      setInternationalPrefix(paramObjectInput.readUTF());
      if (paramObjectInput.readBoolean()) {
        setPreferredInternationalPrefix(paramObjectInput.readUTF());
      }
      if (paramObjectInput.readBoolean()) {
        setNationalPrefix(paramObjectInput.readUTF());
      }
      if (paramObjectInput.readBoolean()) {
        setPreferredExtnPrefix(paramObjectInput.readUTF());
      }
      if (paramObjectInput.readBoolean()) {
        setNationalPrefixForParsing(paramObjectInput.readUTF());
      }
      if (paramObjectInput.readBoolean()) {
        setNationalPrefixTransformRule(paramObjectInput.readUTF());
      }
      setSameMobileAndFixedLinePattern(paramObjectInput.readBoolean());
      int j = paramObjectInput.readInt();
      int i = 0;
      while (i < j)
      {
        localObject = new Phonemetadata.NumberFormat();
        ((Phonemetadata.NumberFormat)localObject).readExternal(paramObjectInput);
        numberFormat_.add(localObject);
        i += 1;
      }
      j = paramObjectInput.readInt();
      i = 0;
      while (i < j)
      {
        localObject = new Phonemetadata.NumberFormat();
        ((Phonemetadata.NumberFormat)localObject).readExternal(paramObjectInput);
        intlNumberFormat_.add(localObject);
        i += 1;
      }
      setMainCountryForCode(paramObjectInput.readBoolean());
      if (paramObjectInput.readBoolean()) {
        setLeadingDigits(paramObjectInput.readUTF());
      }
      setLeadingZeroPossible(paramObjectInput.readBoolean());
      setMobileNumberPortableRegion(paramObjectInput.readBoolean());
    }
    
    public PhoneMetadata setCarrierSpecific(Phonemetadata.PhoneNumberDesc paramPhoneNumberDesc)
    {
      if (paramPhoneNumberDesc == null) {
        throw new NullPointerException();
      }
      hasCarrierSpecific = true;
      carrierSpecific_ = paramPhoneNumberDesc;
      return this;
    }
    
    public PhoneMetadata setCountryCode(int paramInt)
    {
      hasCountryCode = true;
      countryCode_ = paramInt;
      return this;
    }
    
    public PhoneMetadata setEmergency(Phonemetadata.PhoneNumberDesc paramPhoneNumberDesc)
    {
      if (paramPhoneNumberDesc == null) {
        throw new NullPointerException();
      }
      hasEmergency = true;
      emergency_ = paramPhoneNumberDesc;
      return this;
    }
    
    public PhoneMetadata setFixedLine(Phonemetadata.PhoneNumberDesc paramPhoneNumberDesc)
    {
      if (paramPhoneNumberDesc == null) {
        throw new NullPointerException();
      }
      hasFixedLine = true;
      fixedLine_ = paramPhoneNumberDesc;
      return this;
    }
    
    public PhoneMetadata setGeneralDesc(Phonemetadata.PhoneNumberDesc paramPhoneNumberDesc)
    {
      if (paramPhoneNumberDesc == null) {
        throw new NullPointerException();
      }
      hasGeneralDesc = true;
      generalDesc_ = paramPhoneNumberDesc;
      return this;
    }
    
    public PhoneMetadata setId(String paramString)
    {
      hasId = true;
      id_ = paramString;
      return this;
    }
    
    public PhoneMetadata setInternationalPrefix(String paramString)
    {
      hasInternationalPrefix = true;
      internationalPrefix_ = paramString;
      return this;
    }
    
    public PhoneMetadata setLeadingDigits(String paramString)
    {
      hasLeadingDigits = true;
      leadingDigits_ = paramString;
      return this;
    }
    
    public PhoneMetadata setLeadingZeroPossible(boolean paramBoolean)
    {
      hasLeadingZeroPossible = true;
      leadingZeroPossible_ = paramBoolean;
      return this;
    }
    
    public PhoneMetadata setMainCountryForCode(boolean paramBoolean)
    {
      hasMainCountryForCode = true;
      mainCountryForCode_ = paramBoolean;
      return this;
    }
    
    public PhoneMetadata setMobile(Phonemetadata.PhoneNumberDesc paramPhoneNumberDesc)
    {
      if (paramPhoneNumberDesc == null) {
        throw new NullPointerException();
      }
      hasMobile = true;
      mobile_ = paramPhoneNumberDesc;
      return this;
    }
    
    public PhoneMetadata setMobileNumberPortableRegion(boolean paramBoolean)
    {
      hasMobileNumberPortableRegion = true;
      mobileNumberPortableRegion_ = paramBoolean;
      return this;
    }
    
    public PhoneMetadata setNationalPrefix(String paramString)
    {
      hasNationalPrefix = true;
      nationalPrefix_ = paramString;
      return this;
    }
    
    public PhoneMetadata setNationalPrefixForParsing(String paramString)
    {
      hasNationalPrefixForParsing = true;
      nationalPrefixForParsing_ = paramString;
      return this;
    }
    
    public PhoneMetadata setNationalPrefixTransformRule(String paramString)
    {
      hasNationalPrefixTransformRule = true;
      nationalPrefixTransformRule_ = paramString;
      return this;
    }
    
    public PhoneMetadata setNoInternationalDialling(Phonemetadata.PhoneNumberDesc paramPhoneNumberDesc)
    {
      if (paramPhoneNumberDesc == null) {
        throw new NullPointerException();
      }
      hasNoInternationalDialling = true;
      noInternationalDialling_ = paramPhoneNumberDesc;
      return this;
    }
    
    public PhoneMetadata setPager(Phonemetadata.PhoneNumberDesc paramPhoneNumberDesc)
    {
      if (paramPhoneNumberDesc == null) {
        throw new NullPointerException();
      }
      hasPager = true;
      pager_ = paramPhoneNumberDesc;
      return this;
    }
    
    public PhoneMetadata setPersonalNumber(Phonemetadata.PhoneNumberDesc paramPhoneNumberDesc)
    {
      if (paramPhoneNumberDesc == null) {
        throw new NullPointerException();
      }
      hasPersonalNumber = true;
      personalNumber_ = paramPhoneNumberDesc;
      return this;
    }
    
    public PhoneMetadata setPreferredExtnPrefix(String paramString)
    {
      hasPreferredExtnPrefix = true;
      preferredExtnPrefix_ = paramString;
      return this;
    }
    
    public PhoneMetadata setPreferredInternationalPrefix(String paramString)
    {
      hasPreferredInternationalPrefix = true;
      preferredInternationalPrefix_ = paramString;
      return this;
    }
    
    public PhoneMetadata setPremiumRate(Phonemetadata.PhoneNumberDesc paramPhoneNumberDesc)
    {
      if (paramPhoneNumberDesc == null) {
        throw new NullPointerException();
      }
      hasPremiumRate = true;
      premiumRate_ = paramPhoneNumberDesc;
      return this;
    }
    
    public PhoneMetadata setSameMobileAndFixedLinePattern(boolean paramBoolean)
    {
      hasSameMobileAndFixedLinePattern = true;
      sameMobileAndFixedLinePattern_ = paramBoolean;
      return this;
    }
    
    public PhoneMetadata setSharedCost(Phonemetadata.PhoneNumberDesc paramPhoneNumberDesc)
    {
      if (paramPhoneNumberDesc == null) {
        throw new NullPointerException();
      }
      hasSharedCost = true;
      sharedCost_ = paramPhoneNumberDesc;
      return this;
    }
    
    public PhoneMetadata setShortCode(Phonemetadata.PhoneNumberDesc paramPhoneNumberDesc)
    {
      if (paramPhoneNumberDesc == null) {
        throw new NullPointerException();
      }
      hasShortCode = true;
      shortCode_ = paramPhoneNumberDesc;
      return this;
    }
    
    public PhoneMetadata setStandardRate(Phonemetadata.PhoneNumberDesc paramPhoneNumberDesc)
    {
      if (paramPhoneNumberDesc == null) {
        throw new NullPointerException();
      }
      hasStandardRate = true;
      standardRate_ = paramPhoneNumberDesc;
      return this;
    }
    
    public PhoneMetadata setTollFree(Phonemetadata.PhoneNumberDesc paramPhoneNumberDesc)
    {
      if (paramPhoneNumberDesc == null) {
        throw new NullPointerException();
      }
      hasTollFree = true;
      tollFree_ = paramPhoneNumberDesc;
      return this;
    }
    
    public PhoneMetadata setUan(Phonemetadata.PhoneNumberDesc paramPhoneNumberDesc)
    {
      if (paramPhoneNumberDesc == null) {
        throw new NullPointerException();
      }
      hasUan = true;
      uan_ = paramPhoneNumberDesc;
      return this;
    }
    
    public PhoneMetadata setVoicemail(Phonemetadata.PhoneNumberDesc paramPhoneNumberDesc)
    {
      if (paramPhoneNumberDesc == null) {
        throw new NullPointerException();
      }
      hasVoicemail = true;
      voicemail_ = paramPhoneNumberDesc;
      return this;
    }
    
    public PhoneMetadata setVoip(Phonemetadata.PhoneNumberDesc paramPhoneNumberDesc)
    {
      if (paramPhoneNumberDesc == null) {
        throw new NullPointerException();
      }
      hasVoip = true;
      voip_ = paramPhoneNumberDesc;
      return this;
    }
    
    public void writeExternal(ObjectOutput paramObjectOutput)
      throws IOException
    {
      paramObjectOutput.writeBoolean(hasGeneralDesc);
      if (hasGeneralDesc) {
        generalDesc_.writeExternal(paramObjectOutput);
      }
      paramObjectOutput.writeBoolean(hasFixedLine);
      if (hasFixedLine) {
        fixedLine_.writeExternal(paramObjectOutput);
      }
      paramObjectOutput.writeBoolean(hasMobile);
      if (hasMobile) {
        mobile_.writeExternal(paramObjectOutput);
      }
      paramObjectOutput.writeBoolean(hasTollFree);
      if (hasTollFree) {
        tollFree_.writeExternal(paramObjectOutput);
      }
      paramObjectOutput.writeBoolean(hasPremiumRate);
      if (hasPremiumRate) {
        premiumRate_.writeExternal(paramObjectOutput);
      }
      paramObjectOutput.writeBoolean(hasSharedCost);
      if (hasSharedCost) {
        sharedCost_.writeExternal(paramObjectOutput);
      }
      paramObjectOutput.writeBoolean(hasPersonalNumber);
      if (hasPersonalNumber) {
        personalNumber_.writeExternal(paramObjectOutput);
      }
      paramObjectOutput.writeBoolean(hasVoip);
      if (hasVoip) {
        voip_.writeExternal(paramObjectOutput);
      }
      paramObjectOutput.writeBoolean(hasPager);
      if (hasPager) {
        pager_.writeExternal(paramObjectOutput);
      }
      paramObjectOutput.writeBoolean(hasUan);
      if (hasUan) {
        uan_.writeExternal(paramObjectOutput);
      }
      paramObjectOutput.writeBoolean(hasEmergency);
      if (hasEmergency) {
        emergency_.writeExternal(paramObjectOutput);
      }
      paramObjectOutput.writeBoolean(hasVoicemail);
      if (hasVoicemail) {
        voicemail_.writeExternal(paramObjectOutput);
      }
      paramObjectOutput.writeBoolean(hasShortCode);
      if (hasShortCode) {
        shortCode_.writeExternal(paramObjectOutput);
      }
      paramObjectOutput.writeBoolean(hasStandardRate);
      if (hasStandardRate) {
        standardRate_.writeExternal(paramObjectOutput);
      }
      paramObjectOutput.writeBoolean(hasCarrierSpecific);
      if (hasCarrierSpecific) {
        carrierSpecific_.writeExternal(paramObjectOutput);
      }
      paramObjectOutput.writeBoolean(hasNoInternationalDialling);
      if (hasNoInternationalDialling) {
        noInternationalDialling_.writeExternal(paramObjectOutput);
      }
      paramObjectOutput.writeUTF(id_);
      paramObjectOutput.writeInt(countryCode_);
      paramObjectOutput.writeUTF(internationalPrefix_);
      paramObjectOutput.writeBoolean(hasPreferredInternationalPrefix);
      if (hasPreferredInternationalPrefix) {
        paramObjectOutput.writeUTF(preferredInternationalPrefix_);
      }
      paramObjectOutput.writeBoolean(hasNationalPrefix);
      if (hasNationalPrefix) {
        paramObjectOutput.writeUTF(nationalPrefix_);
      }
      paramObjectOutput.writeBoolean(hasPreferredExtnPrefix);
      if (hasPreferredExtnPrefix) {
        paramObjectOutput.writeUTF(preferredExtnPrefix_);
      }
      paramObjectOutput.writeBoolean(hasNationalPrefixForParsing);
      if (hasNationalPrefixForParsing) {
        paramObjectOutput.writeUTF(nationalPrefixForParsing_);
      }
      paramObjectOutput.writeBoolean(hasNationalPrefixTransformRule);
      if (hasNationalPrefixTransformRule) {
        paramObjectOutput.writeUTF(nationalPrefixTransformRule_);
      }
      paramObjectOutput.writeBoolean(sameMobileAndFixedLinePattern_);
      int j = numberFormatSize();
      paramObjectOutput.writeInt(j);
      int i = 0;
      while (i < j)
      {
        ((Phonemetadata.NumberFormat)numberFormat_.get(i)).writeExternal(paramObjectOutput);
        i += 1;
      }
      j = intlNumberFormatSize();
      paramObjectOutput.writeInt(j);
      i = 0;
      while (i < j)
      {
        ((Phonemetadata.NumberFormat)intlNumberFormat_.get(i)).writeExternal(paramObjectOutput);
        i += 1;
      }
      paramObjectOutput.writeBoolean(mainCountryForCode_);
      paramObjectOutput.writeBoolean(hasLeadingDigits);
      if (hasLeadingDigits) {
        paramObjectOutput.writeUTF(leadingDigits_);
      }
      paramObjectOutput.writeBoolean(leadingZeroPossible_);
      paramObjectOutput.writeBoolean(mobileNumberPortableRegion_);
    }
  }
  
  public static class PhoneMetadataCollection
    implements Externalizable
  {
    private static final long serialVersionUID = 1L;
    private List<Phonemetadata.PhoneMetadata> metadata_ = new ArrayList();
    
    public int getMetadataCount()
    {
      return metadata_.size();
    }
    
    public List<Phonemetadata.PhoneMetadata> getMetadataList()
    {
      return metadata_;
    }
    
    public void readExternal(ObjectInput paramObjectInput)
      throws IOException
    {
      int j = paramObjectInput.readInt();
      int i = 0;
      while (i < j)
      {
        Phonemetadata.PhoneMetadata localPhoneMetadata = new Phonemetadata.PhoneMetadata();
        localPhoneMetadata.readExternal(paramObjectInput);
        metadata_.add(localPhoneMetadata);
        i += 1;
      }
    }
    
    public void writeExternal(ObjectOutput paramObjectOutput)
      throws IOException
    {
      int j = getMetadataCount();
      paramObjectOutput.writeInt(j);
      int i = 0;
      while (i < j)
      {
        ((Phonemetadata.PhoneMetadata)metadata_.get(i)).writeExternal(paramObjectOutput);
        i += 1;
      }
    }
  }
  
  public static class PhoneNumberDesc
    implements Externalizable
  {
    private static final long serialVersionUID = 1L;
    private String exampleNumber_ = "";
    private boolean hasExampleNumber;
    private boolean hasNationalNumberPattern;
    private boolean hasPossibleNumberPattern;
    private String nationalNumberPattern_ = "";
    private String possibleNumberPattern_ = "";
    
    public String getExampleNumber()
    {
      return exampleNumber_;
    }
    
    public String getNationalNumberPattern()
    {
      return nationalNumberPattern_;
    }
    
    public String getPossibleNumberPattern()
    {
      return possibleNumberPattern_;
    }
    
    public boolean hasExampleNumber()
    {
      return hasExampleNumber;
    }
    
    public void readExternal(ObjectInput paramObjectInput)
      throws IOException
    {
      if (paramObjectInput.readBoolean()) {
        setNationalNumberPattern(paramObjectInput.readUTF());
      }
      if (paramObjectInput.readBoolean()) {
        setPossibleNumberPattern(paramObjectInput.readUTF());
      }
      if (paramObjectInput.readBoolean()) {
        setExampleNumber(paramObjectInput.readUTF());
      }
    }
    
    public PhoneNumberDesc setExampleNumber(String paramString)
    {
      hasExampleNumber = true;
      exampleNumber_ = paramString;
      return this;
    }
    
    public PhoneNumberDesc setNationalNumberPattern(String paramString)
    {
      hasNationalNumberPattern = true;
      nationalNumberPattern_ = paramString;
      return this;
    }
    
    public PhoneNumberDesc setPossibleNumberPattern(String paramString)
    {
      hasPossibleNumberPattern = true;
      possibleNumberPattern_ = paramString;
      return this;
    }
    
    public void writeExternal(ObjectOutput paramObjectOutput)
      throws IOException
    {
      paramObjectOutput.writeBoolean(hasNationalNumberPattern);
      if (hasNationalNumberPattern) {
        paramObjectOutput.writeUTF(nationalNumberPattern_);
      }
      paramObjectOutput.writeBoolean(hasPossibleNumberPattern);
      if (hasPossibleNumberPattern) {
        paramObjectOutput.writeUTF(possibleNumberPattern_);
      }
      paramObjectOutput.writeBoolean(hasExampleNumber);
      if (hasExampleNumber) {
        paramObjectOutput.writeUTF(exampleNumber_);
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.google.i18n.phonenumbers.Phonemetadata
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */