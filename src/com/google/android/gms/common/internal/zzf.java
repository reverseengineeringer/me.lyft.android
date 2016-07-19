package com.google.android.gms.common.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public abstract class zzf
{
  public static final zzf xC = zza("\t\n\013\f\r     　 ᠎ ").zza(zza(' ', ' '));
  public static final zzf xD = zza("\t\n\013\f\r     　").zza(zza(' ', ' ')).zza(zza(' ', ' '));
  public static final zzf xE = zza('\000', '');
  public static final zzf xF;
  public static final zzf xG = zza('\t', '\r').zza(zza('\034', ' ')).zza(zzc(' ')).zza(zzc('᠎')).zza(zza(' ', ' ')).zza(zza(' ', '​')).zza(zza(' ', ' ')).zza(zzc(' ')).zza(zzc('　'));
  public static final zzf xH = new zzf()
  {
    public boolean zzd(char paramAnonymousChar)
    {
      return Character.isDigit(paramAnonymousChar);
    }
  };
  public static final zzf xI = new zzf()
  {
    public boolean zzd(char paramAnonymousChar)
    {
      return Character.isLetter(paramAnonymousChar);
    }
  };
  public static final zzf xJ = new zzf()
  {
    public boolean zzd(char paramAnonymousChar)
    {
      return Character.isLetterOrDigit(paramAnonymousChar);
    }
  };
  public static final zzf xK = new zzf()
  {
    public boolean zzd(char paramAnonymousChar)
    {
      return Character.isUpperCase(paramAnonymousChar);
    }
  };
  public static final zzf xL = new zzf()
  {
    public boolean zzd(char paramAnonymousChar)
    {
      return Character.isLowerCase(paramAnonymousChar);
    }
  };
  public static final zzf xM = zza('\000', '\037').zza(zza('', ''));
  public static final zzf xN = zza('\000', ' ').zza(zza('', ' ')).zza(zzc('­')).zza(zza('؀', '؃')).zza(zza("۝܏ ឴឵᠎")).zza(zza(' ', '‏')).zza(zza(' ', ' ')).zza(zza(' ', '⁤')).zza(zza('⁪', '⁯')).zza(zzc('　')).zza(zza(55296, 63743)).zza(zza("﻿￹￺￻"));
  public static final zzf xO = zza('\000', 'ӹ').zza(zzc('־')).zza(zza('א', 'ת')).zza(zzc('׳')).zza(zzc('״')).zza(zza('؀', 'ۿ')).zza(zza('ݐ', 'ݿ')).zza(zza('฀', '๿')).zza(zza('Ḁ', '₯')).zza(zza('℀', '℺')).zza(zza(64336, 65023)).zza(zza(65136, 65279)).zza(zza(65377, 65500));
  public static final zzf xP = new zzf()
  {
    public zzf zza(zzf paramAnonymouszzf)
    {
      zzab.zzaa(paramAnonymouszzf);
      return this;
    }
    
    public boolean zzb(CharSequence paramAnonymousCharSequence)
    {
      zzab.zzaa(paramAnonymousCharSequence);
      return true;
    }
    
    public boolean zzd(char paramAnonymousChar)
    {
      return true;
    }
  };
  public static final zzf xQ = new zzf()
  {
    public zzf zza(zzf paramAnonymouszzf)
    {
      return (zzf)zzab.zzaa(paramAnonymouszzf);
    }
    
    public boolean zzb(CharSequence paramAnonymousCharSequence)
    {
      return paramAnonymousCharSequence.length() == 0;
    }
    
    public boolean zzd(char paramAnonymousChar)
    {
      return false;
    }
  };
  
  static
  {
    zzf localzzf = zza('0', '9');
    char[] arrayOfChar = "٠۰߀०০੦૦୦௦౦೦൦๐໐༠၀႐០᠐᥆᧐᭐᮰᱀᱐꘠꣐꤀꩐０".toCharArray();
    int j = arrayOfChar.length;
    int i = 0;
    while (i < j)
    {
      char c = arrayOfChar[i];
      localzzf = localzzf.zza(zza(c, (char)(c + '\t')));
      i += 1;
    }
    xF = localzzf;
  }
  
  public static zzf zza(char paramChar1, final char paramChar2)
  {
    if (paramChar2 >= paramChar1) {}
    for (boolean bool = true;; bool = false)
    {
      zzab.zzbn(bool);
      new zzf()
      {
        public boolean zzd(char paramAnonymousChar)
        {
          return (xU <= paramAnonymousChar) && (paramAnonymousChar <= paramChar2);
        }
      };
    }
  }
  
  public static zzf zza(CharSequence paramCharSequence)
  {
    switch (paramCharSequence.length())
    {
    default: 
      paramCharSequence = paramCharSequence.toString().toCharArray();
      Arrays.sort(paramCharSequence);
      new zzf()
      {
        public boolean zzd(char paramAnonymousChar)
        {
          return Arrays.binarySearch(zzf.this, paramAnonymousChar) >= 0;
        }
      };
    case 0: 
      return xQ;
    case 1: 
      return zzc(paramCharSequence.charAt(0));
    }
    new zzf()
    {
      public boolean zzd(char paramAnonymousChar)
      {
        return (paramAnonymousChar == xR) || (paramAnonymousChar == xS);
      }
    };
  }
  
  public static zzf zzc(char paramChar)
  {
    new zzf()
    {
      public zzf zza(zzf paramAnonymouszzf)
      {
        if (paramAnonymouszzf.zzd(xW)) {
          return paramAnonymouszzf;
        }
        return super.zza(paramAnonymouszzf);
      }
      
      public boolean zzd(char paramAnonymousChar)
      {
        return paramAnonymousChar == xW;
      }
    };
  }
  
  public zzf zza(zzf paramzzf)
  {
    return new zza(Arrays.asList(new zzf[] { this, (zzf)zzab.zzaa(paramzzf) }));
  }
  
  public boolean zzb(CharSequence paramCharSequence)
  {
    int i = paramCharSequence.length() - 1;
    while (i >= 0)
    {
      if (!zzd(paramCharSequence.charAt(i))) {
        return false;
      }
      i -= 1;
    }
    return true;
  }
  
  public abstract boolean zzd(char paramChar);
  
  private static class zza
    extends zzf
  {
    List<zzf> xX;
    
    zza(List<zzf> paramList)
    {
      xX = paramList;
    }
    
    public zzf zza(zzf paramzzf)
    {
      ArrayList localArrayList = new ArrayList(xX);
      localArrayList.add((zzf)zzab.zzaa(paramzzf));
      return new zza(localArrayList);
    }
    
    public boolean zzd(char paramChar)
    {
      Iterator localIterator = xX.iterator();
      while (localIterator.hasNext()) {
        if (((zzf)localIterator.next()).zzd(paramChar)) {
          return true;
        }
      }
      return false;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.internal.zzf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */