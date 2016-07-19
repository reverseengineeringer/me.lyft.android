package com.crashlytics.android.beta;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

class BuildProperties
{
  public final String buildId;
  public final String packageName;
  public final String versionCode;
  public final String versionName;
  
  BuildProperties(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    versionCode = paramString1;
    versionName = paramString2;
    buildId = paramString3;
    packageName = paramString4;
  }
  
  public static BuildProperties fromProperties(Properties paramProperties)
  {
    return new BuildProperties(paramProperties.getProperty("version_code"), paramProperties.getProperty("version_name"), paramProperties.getProperty("build_id"), paramProperties.getProperty("package_name"));
  }
  
  public static BuildProperties fromPropertiesStream(InputStream paramInputStream)
    throws IOException
  {
    Properties localProperties = new Properties();
    localProperties.load(paramInputStream);
    return fromProperties(localProperties);
  }
}

/* Location:
 * Qualified Name:     com.crashlytics.android.beta.BuildProperties
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */