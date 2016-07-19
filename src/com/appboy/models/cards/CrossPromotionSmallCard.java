package com.appboy.models.cards;

import com.appboy.Constants;
import com.appboy.enums.AppStore;
import org.json.JSONObject;

public final class CrossPromotionSmallCard
  extends Card
{
  private static final String j = String.format("%s.%s", new Object[] { Constants.APPBOY_LOG_TAG_PREFIX, CrossPromotionSmallCard.class.getName() });
  private final String k;
  private final String l;
  private final String m;
  private final String n;
  private double o;
  private int p;
  private final double q;
  private final String r;
  private String s;
  private String t;
  private AppStore u;
  private String v;
  
  public CrossPromotionSmallCard(JSONObject paramJSONObject)
  {
    this(paramJSONObject, null, null);
  }
  
  /* Error */
  public CrossPromotionSmallCard(JSONObject paramJSONObject, bo.app.by paramby, bo.app.ex paramex)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: aload_2
    //   3: aload_3
    //   4: invokespecial 57	com/appboy/models/cards/Card:<init>	(Lorg/json/JSONObject;Lbo/app/ch;Lbo/app/ex;)V
    //   7: aload_0
    //   8: aload_1
    //   9: ldc 59
    //   11: invokevirtual 65	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   14: putfield 67	com/appboy/models/cards/CrossPromotionSmallCard:k	Ljava/lang/String;
    //   17: aload_0
    //   18: aload_1
    //   19: ldc 69
    //   21: invokevirtual 65	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   24: putfield 71	com/appboy/models/cards/CrossPromotionSmallCard:l	Ljava/lang/String;
    //   27: aload_0
    //   28: aload_1
    //   29: ldc 73
    //   31: invokevirtual 65	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   34: putfield 75	com/appboy/models/cards/CrossPromotionSmallCard:m	Ljava/lang/String;
    //   37: aload_0
    //   38: aload_1
    //   39: ldc 77
    //   41: invokevirtual 65	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   44: putfield 79	com/appboy/models/cards/CrossPromotionSmallCard:n	Ljava/lang/String;
    //   47: aload_0
    //   48: aload_1
    //   49: ldc 81
    //   51: invokevirtual 85	org/json/JSONObject:getDouble	(Ljava/lang/String;)D
    //   54: putfield 87	com/appboy/models/cards/CrossPromotionSmallCard:o	D
    //   57: aload_0
    //   58: aload_1
    //   59: ldc 89
    //   61: invokevirtual 93	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   64: putfield 95	com/appboy/models/cards/CrossPromotionSmallCard:p	I
    //   67: aload_1
    //   68: ldc 97
    //   70: invokevirtual 101	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   73: ifeq +13 -> 86
    //   76: aload_0
    //   77: aload_1
    //   78: ldc 97
    //   80: invokevirtual 65	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   83: putfield 103	com/appboy/models/cards/CrossPromotionSmallCard:s	Ljava/lang/String;
    //   86: aload_1
    //   87: ldc 105
    //   89: invokevirtual 101	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   92: ifeq +13 -> 105
    //   95: aload_0
    //   96: aload_1
    //   97: ldc 105
    //   99: invokevirtual 65	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   102: putfield 107	com/appboy/models/cards/CrossPromotionSmallCard:t	Ljava/lang/String;
    //   105: aload_0
    //   106: aload_1
    //   107: ldc 109
    //   109: invokevirtual 85	org/json/JSONObject:getDouble	(Ljava/lang/String;)D
    //   112: putfield 111	com/appboy/models/cards/CrossPromotionSmallCard:q	D
    //   115: aload_1
    //   116: ldc 113
    //   118: invokevirtual 101	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   121: ifeq +13 -> 134
    //   124: aload_0
    //   125: aload_1
    //   126: ldc 113
    //   128: invokevirtual 65	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   131: putfield 115	com/appboy/models/cards/CrossPromotionSmallCard:v	Ljava/lang/String;
    //   134: aload_0
    //   135: aload_1
    //   136: ldc 117
    //   138: invokevirtual 65	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   141: putfield 119	com/appboy/models/cards/CrossPromotionSmallCard:r	Ljava/lang/String;
    //   144: aload_1
    //   145: ldc 121
    //   147: invokestatic 127	bo/app/fl:a	(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   150: ifnull +25 -> 175
    //   153: aload_1
    //   154: ldc 121
    //   156: invokestatic 127	bo/app/fl:a	(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   159: astore_1
    //   160: aload_1
    //   161: ifnull +29 -> 190
    //   164: aload_0
    //   165: aload_1
    //   166: invokestatic 132	com/appboy/enums/AppStore:serverStringToEnumString	(Ljava/lang/String;)Ljava/lang/String;
    //   169: invokestatic 136	com/appboy/enums/AppStore:valueOf	(Ljava/lang/String;)Lcom/appboy/enums/AppStore;
    //   172: putfield 138	com/appboy/models/cards/CrossPromotionSmallCard:u	Lcom/appboy/enums/AppStore;
    //   175: return
    //   176: astore_2
    //   177: aload_0
    //   178: dconst_0
    //   179: putfield 87	com/appboy/models/cards/CrossPromotionSmallCard:o	D
    //   182: aload_0
    //   183: iconst_0
    //   184: putfield 95	com/appboy/models/cards/CrossPromotionSmallCard:p	I
    //   187: goto -120 -> 67
    //   190: aload_0
    //   191: getstatic 141	com/appboy/enums/AppStore:GOOGLE_PLAY_STORE	Lcom/appboy/enums/AppStore;
    //   194: putfield 138	com/appboy/models/cards/CrossPromotionSmallCard:u	Lcom/appboy/enums/AppStore;
    //   197: return
    //   198: astore_1
    //   199: getstatic 46	com/appboy/models/cards/CrossPromotionSmallCard:j	Ljava/lang/String;
    //   202: ldc -113
    //   204: aload_1
    //   205: invokestatic 149	com/appboy/support/AppboyLogger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   208: pop
    //   209: aload_0
    //   210: getstatic 141	com/appboy/enums/AppStore:GOOGLE_PLAY_STORE	Lcom/appboy/enums/AppStore;
    //   213: putfield 138	com/appboy/models/cards/CrossPromotionSmallCard:u	Lcom/appboy/enums/AppStore;
    //   216: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	217	0	this	CrossPromotionSmallCard
    //   0	217	1	paramJSONObject	JSONObject
    //   0	217	2	paramby	bo.app.by
    //   0	217	3	paramex	bo.app.ex
    // Exception table:
    //   from	to	target	type
    //   47	67	176	java/lang/Exception
    //   153	160	198	java/lang/Exception
    //   164	175	198	java/lang/Exception
    //   190	197	198	java/lang/Exception
  }
  
  public final AppStore getAppStore()
  {
    return u;
  }
  
  public final String getCaption()
  {
    return m;
  }
  
  public final String getDisplayPrice()
  {
    return v;
  }
  
  public final String getImageUrl()
  {
    return n;
  }
  
  public final String getKindleId()
  {
    return t;
  }
  
  public final String getPackage()
  {
    return s;
  }
  
  public final double getPrice()
  {
    return q;
  }
  
  public final double getRating()
  {
    return o;
  }
  
  public final int getReviewCount()
  {
    return p;
  }
  
  public final String getSubtitle()
  {
    return l;
  }
  
  public final String getTitle()
  {
    return k;
  }
  
  public final String getUrl()
  {
    return r;
  }
  
  public final String toString()
  {
    return "CrossPromotionSmallCard{mId='" + c + '\'' + ", mViewed='" + d + '\'' + ", mCreated='" + f + '\'' + ", mUpdated='" + g + '\'' + ", mTitle='" + k + '\'' + ", mSubtitle='" + l + '\'' + ", mCaption='" + m + '\'' + ", mImageUrl='" + n + '\'' + ", mRating=" + o + ", mReviewCount=" + p + ", mPrice=" + q + ", mPackage=" + s + ", mUrl='" + r + '\'' + ", mAppStore='" + u + '\'' + ", mKindleId='" + t + '\'' + ", mDisplayPrice='" + v + '\'' + "}";
  }
}

/* Location:
 * Qualified Name:     com.appboy.models.cards.CrossPromotionSmallCard
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */