package io.fabric.sdk.android.services.common;

import android.os.Build;
import android.text.TextUtils;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Logger;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

 enum CommonUtils$Architecture
{
  private static final Map<String, Architecture> matcher;
  
  static
  {
    ARM_UNKNOWN = new Architecture("ARM_UNKNOWN", 2);
    PPC = new Architecture("PPC", 3);
    PPC64 = new Architecture("PPC64", 4);
    ARMV6 = new Architecture("ARMV6", 5);
    ARMV7 = new Architecture("ARMV7", 6);
    UNKNOWN = new Architecture("UNKNOWN", 7);
    ARMV7S = new Architecture("ARMV7S", 8);
    ARM64 = new Architecture("ARM64", 9);
    $VALUES = new Architecture[] { X86_32, X86_64, ARM_UNKNOWN, PPC, PPC64, ARMV6, ARMV7, UNKNOWN, ARMV7S, ARM64 };
    matcher = new HashMap(4);
    matcher.put("armeabi-v7a", ARMV7);
    matcher.put("armeabi", ARMV6);
    matcher.put("x86", X86_32);
  }
  
  private CommonUtils$Architecture() {}
  
  static Architecture getValue()
  {
    Object localObject = Build.CPU_ABI;
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      Fabric.getLogger().d("Fabric", "Architecture#getValue()::Build.CPU_ABI returned null or empty");
      localObject = UNKNOWN;
    }
    Architecture localArchitecture;
    do
    {
      return (Architecture)localObject;
      localObject = ((String)localObject).toLowerCase(Locale.US);
      localArchitecture = (Architecture)matcher.get(localObject);
      localObject = localArchitecture;
    } while (localArchitecture != null);
    return UNKNOWN;
  }
}

/* Location:
 * Qualified Name:     io.fabric.sdk.android.services.common.CommonUtils.Architecture
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */