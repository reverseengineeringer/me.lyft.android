package com.google.i18n.phonenumbers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AsYouTypeFormatter
{
  private static final Pattern CHARACTER_CLASS_PATTERN;
  private static final Pattern DIGIT_PATTERN = Pattern.compile(" ");
  private static final Pattern ELIGIBLE_FORMAT_PATTERN;
  private static final Phonemetadata.PhoneMetadata EMPTY_METADATA = new Phonemetadata.PhoneMetadata().setInternationalPrefix("NA");
  private static final Pattern NATIONAL_PREFIX_SEPARATORS_PATTERN;
  private static final Pattern STANDALONE_DIGIT_PATTERN;
  private boolean ableToFormat = true;
  private StringBuilder accruedInput = new StringBuilder();
  private StringBuilder accruedInputWithoutFormatting = new StringBuilder();
  private String currentFormattingPattern = "";
  private Phonemetadata.PhoneMetadata currentMetadata;
  private String currentOutput = "";
  private String defaultCountry;
  private Phonemetadata.PhoneMetadata defaultMetadata;
  private String extractedNationalPrefix = "";
  private StringBuilder formattingTemplate = new StringBuilder();
  private boolean inputHasFormatting = false;
  private boolean isCompleteNumber = false;
  private boolean isExpectingCountryCallingCode = false;
  private int lastMatchPosition = 0;
  private StringBuilder nationalNumber = new StringBuilder();
  private int originalPosition = 0;
  private final PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();
  private int positionToRemember = 0;
  private List<Phonemetadata.NumberFormat> possibleFormats = new ArrayList();
  private StringBuilder prefixBeforeNationalNumber = new StringBuilder();
  private RegexCache regexCache = new RegexCache(64);
  private boolean shouldAddSpaceAfterNationalPrefix = false;
  
  static
  {
    CHARACTER_CLASS_PATTERN = Pattern.compile("\\[([^\\[\\]])*\\]");
    STANDALONE_DIGIT_PATTERN = Pattern.compile("\\d(?=[^,}][^,}])");
    ELIGIBLE_FORMAT_PATTERN = Pattern.compile("[-x‐-―−ー－-／  ­​⁠　()（）［］.\\[\\]/~⁓∼～]*(\\$\\d[-x‐-―−ー－-／  ­​⁠　()（）［］.\\[\\]/~⁓∼～]*)+");
    NATIONAL_PREFIX_SEPARATORS_PATTERN = Pattern.compile("[- ]");
  }
  
  AsYouTypeFormatter(String paramString)
  {
    defaultCountry = paramString;
    currentMetadata = getMetadataForRegion(defaultCountry);
    defaultMetadata = currentMetadata;
  }
  
  private boolean ableToExtractLongerNdd()
  {
    boolean bool = false;
    if (extractedNationalPrefix.length() > 0)
    {
      nationalNumber.insert(0, extractedNationalPrefix);
      int i = prefixBeforeNationalNumber.lastIndexOf(extractedNationalPrefix);
      prefixBeforeNationalNumber.setLength(i);
    }
    if (!extractedNationalPrefix.equals(removeNationalPrefixFromNationalNumber())) {
      bool = true;
    }
    return bool;
  }
  
  private String appendNationalNumber(String paramString)
  {
    int i = prefixBeforeNationalNumber.length();
    if ((shouldAddSpaceAfterNationalPrefix) && (i > 0) && (prefixBeforeNationalNumber.charAt(i - 1) != ' '))
    {
      str = String.valueOf(String.valueOf(new String(prefixBeforeNationalNumber)));
      paramString = String.valueOf(String.valueOf(paramString));
      return str.length() + 1 + paramString.length() + str + ' ' + paramString;
    }
    String str = String.valueOf(String.valueOf(prefixBeforeNationalNumber));
    paramString = String.valueOf(String.valueOf(paramString));
    return str.length() + 0 + paramString.length() + str + paramString;
  }
  
  private String attemptToChooseFormattingPattern()
  {
    if (nationalNumber.length() >= 3)
    {
      getAvailableFormats(nationalNumber.toString());
      String str = attemptToFormatAccruedDigits();
      if (str.length() > 0) {
        return str;
      }
      if (maybeCreateNewTemplate()) {}
      for (str = inputAccruedNationalNumber();; str = accruedInput.toString()) {
        return str;
      }
    }
    return appendNationalNumber(nationalNumber.toString());
  }
  
  private String attemptToChoosePatternWithPrefixExtracted()
  {
    ableToFormat = true;
    isExpectingCountryCallingCode = false;
    possibleFormats.clear();
    lastMatchPosition = 0;
    formattingTemplate.setLength(0);
    currentFormattingPattern = "";
    return attemptToChooseFormattingPattern();
  }
  
  private boolean attemptToExtractCountryCallingCode()
  {
    if (nationalNumber.length() == 0) {}
    int i;
    do
    {
      return false;
      localObject = new StringBuilder();
      i = phoneUtil.extractCountryCode(nationalNumber, (StringBuilder)localObject);
    } while (i == 0);
    nationalNumber.setLength(0);
    nationalNumber.append((CharSequence)localObject);
    Object localObject = phoneUtil.getRegionCodeForCountryCode(i);
    if ("001".equals(localObject)) {
      currentMetadata = phoneUtil.getMetadataForNonGeographicalRegion(i);
    }
    for (;;)
    {
      localObject = Integer.toString(i);
      prefixBeforeNationalNumber.append((String)localObject).append(' ');
      extractedNationalPrefix = "";
      return true;
      if (!((String)localObject).equals(defaultCountry)) {
        currentMetadata = getMetadataForRegion((String)localObject);
      }
    }
  }
  
  private boolean attemptToExtractIdd()
  {
    RegexCache localRegexCache = regexCache;
    Object localObject = String.valueOf("\\+|");
    String str = String.valueOf(currentMetadata.getInternationalPrefix());
    if (str.length() != 0) {}
    for (localObject = ((String)localObject).concat(str);; localObject = new String((String)localObject))
    {
      localObject = localRegexCache.getPatternForRegex((String)localObject).matcher(accruedInputWithoutFormatting);
      if (!((Matcher)localObject).lookingAt()) {
        break;
      }
      isCompleteNumber = true;
      int i = ((Matcher)localObject).end();
      nationalNumber.setLength(0);
      nationalNumber.append(accruedInputWithoutFormatting.substring(i));
      prefixBeforeNationalNumber.setLength(0);
      prefixBeforeNationalNumber.append(accruedInputWithoutFormatting.substring(0, i));
      if (accruedInputWithoutFormatting.charAt(0) != '+') {
        prefixBeforeNationalNumber.append(' ');
      }
      return true;
    }
    return false;
  }
  
  private boolean createFormattingTemplate(Phonemetadata.NumberFormat paramNumberFormat)
  {
    String str = paramNumberFormat.getPattern();
    if (str.indexOf('|') != -1) {}
    do
    {
      return false;
      str = CHARACTER_CLASS_PATTERN.matcher(str).replaceAll("\\\\d");
      str = STANDALONE_DIGIT_PATTERN.matcher(str).replaceAll("\\\\d");
      formattingTemplate.setLength(0);
      paramNumberFormat = getFormattingTemplate(str, paramNumberFormat.getFormat());
    } while (paramNumberFormat.length() <= 0);
    formattingTemplate.append(paramNumberFormat);
    return true;
  }
  
  private void getAvailableFormats(String paramString)
  {
    if ((isCompleteNumber) && (currentMetadata.intlNumberFormatSize() > 0)) {}
    for (Object localObject = currentMetadata.intlNumberFormats();; localObject = currentMetadata.numberFormats())
    {
      boolean bool = currentMetadata.hasNationalPrefix();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Phonemetadata.NumberFormat localNumberFormat = (Phonemetadata.NumberFormat)((Iterator)localObject).next();
        if (((!bool) || (isCompleteNumber) || (localNumberFormat.isNationalPrefixOptionalWhenFormatting()) || (PhoneNumberUtil.formattingRuleHasFirstGroupOnly(localNumberFormat.getNationalPrefixFormattingRule()))) && (isFormatEligible(localNumberFormat.getFormat()))) {
          possibleFormats.add(localNumberFormat);
        }
      }
    }
    narrowDownPossibleFormats(paramString);
  }
  
  private String getFormattingTemplate(String paramString1, String paramString2)
  {
    Object localObject = regexCache.getPatternForRegex(paramString1).matcher("999999999999999");
    ((Matcher)localObject).find();
    localObject = ((Matcher)localObject).group();
    if (((String)localObject).length() < nationalNumber.length()) {
      return "";
    }
    return ((String)localObject).replaceAll(paramString1, paramString2).replaceAll("9", " ");
  }
  
  private Phonemetadata.PhoneMetadata getMetadataForRegion(String paramString)
  {
    int i = phoneUtil.getCountryCodeForRegion(paramString);
    paramString = phoneUtil.getRegionCodeForCountryCode(i);
    paramString = phoneUtil.getMetadataForRegion(paramString);
    if (paramString != null) {
      return paramString;
    }
    return EMPTY_METADATA;
  }
  
  private String inputAccruedNationalNumber()
  {
    int j = nationalNumber.length();
    if (j > 0)
    {
      String str = "";
      int i = 0;
      while (i < j)
      {
        str = inputDigitHelper(nationalNumber.charAt(i));
        i += 1;
      }
      if (ableToFormat) {
        return appendNationalNumber(str);
      }
      return accruedInput.toString();
    }
    return prefixBeforeNationalNumber.toString();
  }
  
  private String inputDigitHelper(char paramChar)
  {
    Matcher localMatcher = DIGIT_PATTERN.matcher(formattingTemplate);
    if (localMatcher.find(lastMatchPosition))
    {
      String str = localMatcher.replaceFirst(Character.toString(paramChar));
      formattingTemplate.replace(0, str.length(), str);
      lastMatchPosition = localMatcher.start();
      return formattingTemplate.substring(0, lastMatchPosition + 1);
    }
    if (possibleFormats.size() == 1) {
      ableToFormat = false;
    }
    currentFormattingPattern = "";
    return accruedInput.toString();
  }
  
  private String inputDigitWithOptionToRememberPosition(char paramChar, boolean paramBoolean)
  {
    accruedInput.append(paramChar);
    if (paramBoolean) {
      originalPosition = accruedInput.length();
    }
    if (!isDigitOrLeadingPlusSign(paramChar))
    {
      ableToFormat = false;
      inputHasFormatting = true;
      if (ableToFormat) {
        break label125;
      }
      if (!inputHasFormatting) {
        break label76;
      }
      localObject = accruedInput.toString();
    }
    label76:
    label125:
    String str1;
    String str2;
    do
    {
      return (String)localObject;
      paramChar = normalizeAndAccrueDigitsAndPlusSign(paramChar, paramBoolean);
      break;
      if (attemptToExtractIdd())
      {
        if (attemptToExtractCountryCallingCode()) {
          return attemptToChoosePatternWithPrefixExtracted();
        }
      }
      else if (ableToExtractLongerNdd())
      {
        prefixBeforeNationalNumber.append(' ');
        return attemptToChoosePatternWithPrefixExtracted();
      }
      return accruedInput.toString();
      switch (accruedInputWithoutFormatting.length())
      {
      }
      while (isExpectingCountryCallingCode)
      {
        if (attemptToExtractCountryCallingCode()) {
          isExpectingCountryCallingCode = false;
        }
        localObject = String.valueOf(String.valueOf(prefixBeforeNationalNumber));
        str1 = String.valueOf(String.valueOf(nationalNumber.toString()));
        return ((String)localObject).length() + 0 + str1.length() + (String)localObject + str1;
        return accruedInput.toString();
        if (attemptToExtractIdd())
        {
          isExpectingCountryCallingCode = true;
        }
        else
        {
          extractedNationalPrefix = removeNationalPrefixFromNationalNumber();
          return attemptToChooseFormattingPattern();
        }
      }
      if (possibleFormats.size() <= 0) {
        break label363;
      }
      str2 = inputDigitHelper(paramChar);
      str1 = attemptToFormatAccruedDigits();
      localObject = str1;
    } while (str1.length() > 0);
    narrowDownPossibleFormats(nationalNumber.toString());
    if (maybeCreateNewTemplate()) {
      return inputAccruedNationalNumber();
    }
    if (ableToFormat) {}
    for (Object localObject = appendNationalNumber(str2);; localObject = accruedInput.toString()) {
      return (String)localObject;
    }
    label363:
    return attemptToChooseFormattingPattern();
  }
  
  private boolean isDigitOrLeadingPlusSign(char paramChar)
  {
    return (Character.isDigit(paramChar)) || ((accruedInput.length() == 1) && (PhoneNumberUtil.PLUS_CHARS_PATTERN.matcher(Character.toString(paramChar)).matches()));
  }
  
  private boolean isFormatEligible(String paramString)
  {
    return ELIGIBLE_FORMAT_PATTERN.matcher(paramString).matches();
  }
  
  private boolean isNanpaNumberWithNationalPrefix()
  {
    return (currentMetadata.getCountryCode() == 1) && (nationalNumber.charAt(0) == '1') && (nationalNumber.charAt(1) != '0') && (nationalNumber.charAt(1) != '1');
  }
  
  private boolean maybeCreateNewTemplate()
  {
    Iterator localIterator = possibleFormats.iterator();
    while (localIterator.hasNext())
    {
      Phonemetadata.NumberFormat localNumberFormat = (Phonemetadata.NumberFormat)localIterator.next();
      String str = localNumberFormat.getPattern();
      if (currentFormattingPattern.equals(str)) {
        return false;
      }
      if (createFormattingTemplate(localNumberFormat))
      {
        currentFormattingPattern = str;
        shouldAddSpaceAfterNationalPrefix = NATIONAL_PREFIX_SEPARATORS_PATTERN.matcher(localNumberFormat.getNationalPrefixFormattingRule()).find();
        lastMatchPosition = 0;
        return true;
      }
      localIterator.remove();
    }
    ableToFormat = false;
    return false;
  }
  
  private void narrowDownPossibleFormats(String paramString)
  {
    int i = paramString.length();
    Iterator localIterator = possibleFormats.iterator();
    while (localIterator.hasNext())
    {
      Phonemetadata.NumberFormat localNumberFormat = (Phonemetadata.NumberFormat)localIterator.next();
      if (localNumberFormat.leadingDigitsPatternSize() != 0)
      {
        int j = Math.min(i - 3, localNumberFormat.leadingDigitsPatternSize() - 1);
        if (!regexCache.getPatternForRegex(localNumberFormat.getLeadingDigitsPattern(j)).matcher(paramString).lookingAt()) {
          localIterator.remove();
        }
      }
    }
  }
  
  private char normalizeAndAccrueDigitsAndPlusSign(char paramChar, boolean paramBoolean)
  {
    char c;
    if (paramChar == '+')
    {
      c = paramChar;
      accruedInputWithoutFormatting.append(paramChar);
    }
    for (;;)
    {
      if (paramBoolean) {
        positionToRemember = accruedInputWithoutFormatting.length();
      }
      return c;
      c = Character.forDigit(Character.digit(paramChar, 10), 10);
      accruedInputWithoutFormatting.append(c);
      nationalNumber.append(c);
    }
  }
  
  private String removeNationalPrefixFromNationalNumber()
  {
    int j = 0;
    int i;
    if (isNanpaNumberWithNationalPrefix())
    {
      i = 1;
      prefixBeforeNationalNumber.append('1').append(' ');
      isCompleteNumber = true;
    }
    for (;;)
    {
      Object localObject = nationalNumber.substring(0, i);
      nationalNumber.delete(0, i);
      return (String)localObject;
      i = j;
      if (currentMetadata.hasNationalPrefixForParsing())
      {
        localObject = regexCache.getPatternForRegex(currentMetadata.getNationalPrefixForParsing()).matcher(nationalNumber);
        i = j;
        if (((Matcher)localObject).lookingAt())
        {
          i = j;
          if (((Matcher)localObject).end() > 0)
          {
            isCompleteNumber = true;
            i = ((Matcher)localObject).end();
            prefixBeforeNationalNumber.append(nationalNumber.substring(0, i));
          }
        }
      }
    }
  }
  
  String attemptToFormatAccruedDigits()
  {
    Iterator localIterator = possibleFormats.iterator();
    while (localIterator.hasNext())
    {
      Phonemetadata.NumberFormat localNumberFormat = (Phonemetadata.NumberFormat)localIterator.next();
      Matcher localMatcher = regexCache.getPatternForRegex(localNumberFormat.getPattern()).matcher(nationalNumber);
      if (localMatcher.matches())
      {
        shouldAddSpaceAfterNationalPrefix = NATIONAL_PREFIX_SEPARATORS_PATTERN.matcher(localNumberFormat.getNationalPrefixFormattingRule()).find();
        return appendNationalNumber(localMatcher.replaceAll(localNumberFormat.getFormat()));
      }
    }
    return "";
  }
  
  public void clear()
  {
    currentOutput = "";
    accruedInput.setLength(0);
    accruedInputWithoutFormatting.setLength(0);
    formattingTemplate.setLength(0);
    lastMatchPosition = 0;
    currentFormattingPattern = "";
    prefixBeforeNationalNumber.setLength(0);
    extractedNationalPrefix = "";
    nationalNumber.setLength(0);
    ableToFormat = true;
    inputHasFormatting = false;
    positionToRemember = 0;
    originalPosition = 0;
    isCompleteNumber = false;
    isExpectingCountryCallingCode = false;
    possibleFormats.clear();
    shouldAddSpaceAfterNationalPrefix = false;
    if (!currentMetadata.equals(defaultMetadata)) {
      currentMetadata = getMetadataForRegion(defaultCountry);
    }
  }
  
  public String inputDigit(char paramChar)
  {
    currentOutput = inputDigitWithOptionToRememberPosition(paramChar, false);
    return currentOutput;
  }
}

/* Location:
 * Qualified Name:     com.google.i18n.phonenumbers.AsYouTypeFormatter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */