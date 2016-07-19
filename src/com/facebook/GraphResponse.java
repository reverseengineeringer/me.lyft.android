package com.facebook;

import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class GraphResponse
{
  private static final String BODY_KEY = "body";
  private static final String CODE_KEY = "code";
  public static final String NON_JSON_RESPONSE_PROPERTY = "FACEBOOK_NON_JSON_RESULT";
  private static final String RESPONSE_LOG_TAG = "Response";
  public static final String SUCCESS_KEY = "success";
  private final HttpURLConnection connection;
  private final FacebookRequestError error;
  private final JSONObject graphObject;
  private final JSONArray graphObjectArray;
  private final String rawResponse;
  private final GraphRequest request;
  
  GraphResponse(GraphRequest paramGraphRequest, HttpURLConnection paramHttpURLConnection, FacebookRequestError paramFacebookRequestError)
  {
    this(paramGraphRequest, paramHttpURLConnection, null, null, null, paramFacebookRequestError);
  }
  
  GraphResponse(GraphRequest paramGraphRequest, HttpURLConnection paramHttpURLConnection, String paramString, JSONArray paramJSONArray)
  {
    this(paramGraphRequest, paramHttpURLConnection, paramString, null, paramJSONArray, null);
  }
  
  GraphResponse(GraphRequest paramGraphRequest, HttpURLConnection paramHttpURLConnection, String paramString, JSONObject paramJSONObject)
  {
    this(paramGraphRequest, paramHttpURLConnection, paramString, paramJSONObject, null, null);
  }
  
  GraphResponse(GraphRequest paramGraphRequest, HttpURLConnection paramHttpURLConnection, String paramString, JSONObject paramJSONObject, JSONArray paramJSONArray, FacebookRequestError paramFacebookRequestError)
  {
    request = paramGraphRequest;
    connection = paramHttpURLConnection;
    rawResponse = paramString;
    graphObject = paramJSONObject;
    graphObjectArray = paramJSONArray;
    error = paramFacebookRequestError;
  }
  
  static List<GraphResponse> constructErrorResponses(List<GraphRequest> paramList, HttpURLConnection paramHttpURLConnection, FacebookException paramFacebookException)
  {
    int j = paramList.size();
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      localArrayList.add(new GraphResponse((GraphRequest)paramList.get(i), paramHttpURLConnection, new FacebookRequestError(paramHttpURLConnection, paramFacebookException)));
      i += 1;
    }
    return localArrayList;
  }
  
  private static GraphResponse createResponseFromObject(GraphRequest paramGraphRequest, HttpURLConnection paramHttpURLConnection, Object paramObject1, Object paramObject2)
    throws JSONException
  {
    Object localObject = paramObject1;
    if ((paramObject1 instanceof JSONObject))
    {
      paramObject1 = (JSONObject)paramObject1;
      paramObject2 = FacebookRequestError.checkResponseAndCreateError((JSONObject)paramObject1, paramObject2, paramHttpURLConnection);
      if (paramObject2 != null)
      {
        if ((((FacebookRequestError)paramObject2).getErrorCode() == 190) && (Utility.isCurrentAccessToken(paramGraphRequest.getAccessToken()))) {
          AccessToken.setCurrentAccessToken(null);
        }
        return new GraphResponse(paramGraphRequest, paramHttpURLConnection, (FacebookRequestError)paramObject2);
      }
      paramObject1 = Utility.getStringPropertyAsJSON((JSONObject)paramObject1, "body", "FACEBOOK_NON_JSON_RESULT");
      if ((paramObject1 instanceof JSONObject)) {
        return new GraphResponse(paramGraphRequest, paramHttpURLConnection, paramObject1.toString(), (JSONObject)paramObject1);
      }
      if ((paramObject1 instanceof JSONArray)) {
        return new GraphResponse(paramGraphRequest, paramHttpURLConnection, paramObject1.toString(), (JSONArray)paramObject1);
      }
      localObject = JSONObject.NULL;
    }
    if (localObject == JSONObject.NULL) {
      return new GraphResponse(paramGraphRequest, paramHttpURLConnection, localObject.toString(), (JSONObject)null);
    }
    throw new FacebookException("Got unexpected object type in response, class: " + localObject.getClass().getSimpleName());
  }
  
  private static List<GraphResponse> createResponsesFromObject(HttpURLConnection paramHttpURLConnection, List<GraphRequest> paramList, Object paramObject)
    throws FacebookException, JSONException
  {
    int j = paramList.size();
    ArrayList localArrayList = new ArrayList(j);
    Object localObject1 = paramObject;
    GraphRequest localGraphRequest;
    if (j == 1) {
      localGraphRequest = (GraphRequest)paramList.get(0);
    }
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("body", paramObject);
        if (paramHttpURLConnection == null) {
          continue;
        }
        i = paramHttpURLConnection.getResponseCode();
        localJSONObject.put("code", i);
        localObject1 = new JSONArray();
        ((JSONArray)localObject1).put(localJSONObject);
      }
      catch (JSONException localJSONException1)
      {
        localArrayList.add(new GraphResponse(localGraphRequest, paramHttpURLConnection, new FacebookRequestError(paramHttpURLConnection, localJSONException1)));
        Object localObject2 = paramObject;
        continue;
      }
      catch (IOException localIOException)
      {
        localArrayList.add(new GraphResponse(localGraphRequest, paramHttpURLConnection, new FacebookRequestError(paramHttpURLConnection, localIOException)));
        Object localObject3 = paramObject;
        continue;
        localObject3 = (JSONArray)localObject3;
        int i = 0;
        if (i >= ((JSONArray)localObject3).length()) {
          break label327;
        }
        localGraphRequest = (GraphRequest)paramList.get(i);
        try
        {
          localArrayList.add(createResponseFromObject(localGraphRequest, paramHttpURLConnection, ((JSONArray)localObject3).get(i), paramObject));
          i += 1;
        }
        catch (JSONException localJSONException2)
        {
          localArrayList.add(new GraphResponse(localGraphRequest, paramHttpURLConnection, new FacebookRequestError(paramHttpURLConnection, localJSONException2)));
          continue;
        }
        catch (FacebookException localFacebookException)
        {
          localArrayList.add(new GraphResponse(localGraphRequest, paramHttpURLConnection, new FacebookRequestError(paramHttpURLConnection, localFacebookException)));
          continue;
        }
      }
      if (((localObject1 instanceof JSONArray)) && (((JSONArray)localObject1).length() == j)) {
        continue;
      }
      throw new FacebookException("Unexpected number of results");
      i = 200;
    }
    label327:
    return localArrayList;
  }
  
  static List<GraphResponse> createResponsesFromStream(InputStream paramInputStream, HttpURLConnection paramHttpURLConnection, GraphRequestBatch paramGraphRequestBatch)
    throws FacebookException, JSONException, IOException
  {
    paramInputStream = Utility.readStreamToString(paramInputStream);
    Logger.log(LoggingBehavior.INCLUDE_RAW_RESPONSES, "Response", "Response (raw)\n  Size: %d\n  Response:\n%s\n", new Object[] { Integer.valueOf(paramInputStream.length()), paramInputStream });
    return createResponsesFromString(paramInputStream, paramHttpURLConnection, paramGraphRequestBatch);
  }
  
  static List<GraphResponse> createResponsesFromString(String paramString, HttpURLConnection paramHttpURLConnection, GraphRequestBatch paramGraphRequestBatch)
    throws FacebookException, JSONException, IOException
  {
    paramHttpURLConnection = createResponsesFromObject(paramHttpURLConnection, paramGraphRequestBatch, new JSONTokener(paramString).nextValue());
    Logger.log(LoggingBehavior.REQUESTS, "Response", "Response\n  Id: %s\n  Size: %d\n  Responses:\n%s\n", new Object[] { paramGraphRequestBatch.getId(), Integer.valueOf(paramString.length()), paramHttpURLConnection });
    return paramHttpURLConnection;
  }
  
  /* Error */
  static List<GraphResponse> fromHttpConnection(HttpURLConnection paramHttpURLConnection, GraphRequestBatch paramGraphRequestBatch)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 7
    //   6: aconst_null
    //   7: astore_2
    //   8: aload_2
    //   9: astore 4
    //   11: aload 6
    //   13: astore 5
    //   15: aload 7
    //   17: astore_3
    //   18: aload_0
    //   19: invokevirtual 175	java/net/HttpURLConnection:getResponseCode	()I
    //   22: sipush 400
    //   25: if_icmplt +41 -> 66
    //   28: aload_2
    //   29: astore 4
    //   31: aload 6
    //   33: astore 5
    //   35: aload 7
    //   37: astore_3
    //   38: aload_0
    //   39: invokevirtual 253	java/net/HttpURLConnection:getErrorStream	()Ljava/io/InputStream;
    //   42: astore_2
    //   43: aload_2
    //   44: astore 4
    //   46: aload_2
    //   47: astore 5
    //   49: aload_2
    //   50: astore_3
    //   51: aload_2
    //   52: aload_0
    //   53: aload_1
    //   54: invokestatic 255	com/facebook/GraphResponse:createResponsesFromStream	(Ljava/io/InputStream;Ljava/net/HttpURLConnection;Lcom/facebook/GraphRequestBatch;)Ljava/util/List;
    //   57: astore 6
    //   59: aload_2
    //   60: invokestatic 259	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   63: aload 6
    //   65: areturn
    //   66: aload_2
    //   67: astore 4
    //   69: aload 6
    //   71: astore 5
    //   73: aload 7
    //   75: astore_3
    //   76: aload_0
    //   77: invokevirtual 262	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   80: astore_2
    //   81: goto -38 -> 43
    //   84: astore_2
    //   85: aload 4
    //   87: astore_3
    //   88: getstatic 237	com/facebook/LoggingBehavior:REQUESTS	Lcom/facebook/LoggingBehavior;
    //   91: ldc 20
    //   93: ldc_w 264
    //   96: iconst_1
    //   97: anewarray 4	java/lang/Object
    //   100: dup
    //   101: iconst_0
    //   102: aload_2
    //   103: aastore
    //   104: invokestatic 220	com/facebook/internal/Logger:log	(Lcom/facebook/LoggingBehavior;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   107: aload 4
    //   109: astore_3
    //   110: aload_1
    //   111: aload_0
    //   112: aload_2
    //   113: invokestatic 266	com/facebook/GraphResponse:constructErrorResponses	(Ljava/util/List;Ljava/net/HttpURLConnection;Lcom/facebook/FacebookException;)Ljava/util/List;
    //   116: astore_0
    //   117: aload 4
    //   119: invokestatic 259	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   122: aload_0
    //   123: areturn
    //   124: astore_2
    //   125: aload 5
    //   127: astore_3
    //   128: getstatic 237	com/facebook/LoggingBehavior:REQUESTS	Lcom/facebook/LoggingBehavior;
    //   131: ldc 20
    //   133: ldc_w 264
    //   136: iconst_1
    //   137: anewarray 4	java/lang/Object
    //   140: dup
    //   141: iconst_0
    //   142: aload_2
    //   143: aastore
    //   144: invokestatic 220	com/facebook/internal/Logger:log	(Lcom/facebook/LoggingBehavior;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   147: aload 5
    //   149: astore_3
    //   150: aload_1
    //   151: aload_0
    //   152: new 138	com/facebook/FacebookException
    //   155: dup
    //   156: aload_2
    //   157: invokespecial 269	com/facebook/FacebookException:<init>	(Ljava/lang/Throwable;)V
    //   160: invokestatic 266	com/facebook/GraphResponse:constructErrorResponses	(Ljava/util/List;Ljava/net/HttpURLConnection;Lcom/facebook/FacebookException;)Ljava/util/List;
    //   163: astore_0
    //   164: aload 5
    //   166: invokestatic 259	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   169: aload_0
    //   170: areturn
    //   171: astore_0
    //   172: aload_3
    //   173: invokestatic 259	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   176: aload_0
    //   177: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	178	0	paramHttpURLConnection	HttpURLConnection
    //   0	178	1	paramGraphRequestBatch	GraphRequestBatch
    //   7	74	2	localInputStream1	InputStream
    //   84	29	2	localFacebookException	FacebookException
    //   124	33	2	localException	Exception
    //   17	156	3	localObject1	Object
    //   9	109	4	localInputStream2	InputStream
    //   13	152	5	localObject2	Object
    //   1	69	6	localList	List
    //   4	70	7	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   18	28	84	com/facebook/FacebookException
    //   38	43	84	com/facebook/FacebookException
    //   51	59	84	com/facebook/FacebookException
    //   76	81	84	com/facebook/FacebookException
    //   18	28	124	java/lang/Exception
    //   38	43	124	java/lang/Exception
    //   51	59	124	java/lang/Exception
    //   76	81	124	java/lang/Exception
    //   18	28	171	finally
    //   38	43	171	finally
    //   51	59	171	finally
    //   76	81	171	finally
    //   88	107	171	finally
    //   110	117	171	finally
    //   128	147	171	finally
    //   150	164	171	finally
  }
  
  public final HttpURLConnection getConnection()
  {
    return connection;
  }
  
  public final FacebookRequestError getError()
  {
    return error;
  }
  
  public final JSONArray getJSONArray()
  {
    return graphObjectArray;
  }
  
  public final JSONObject getJSONObject()
  {
    return graphObject;
  }
  
  public String getRawResponse()
  {
    return rawResponse;
  }
  
  public GraphRequest getRequest()
  {
    return request;
  }
  
  public GraphRequest getRequestForPagedResults(PagingDirection paramPagingDirection)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    JSONObject localJSONObject;
    if (graphObject != null)
    {
      localJSONObject = graphObject.optJSONObject("paging");
      localObject1 = localObject2;
      if (localJSONObject != null) {
        if (paramPagingDirection != PagingDirection.NEXT) {
          break label55;
        }
      }
    }
    label55:
    for (localObject1 = localJSONObject.optString("next"); Utility.isNullOrEmpty((String)localObject1); localObject1 = localJSONObject.optString("previous")) {
      return null;
    }
    if ((localObject1 != null) && (((String)localObject1).equals(request.getUrlForSingleRequest()))) {
      return null;
    }
    try
    {
      paramPagingDirection = new GraphRequest(request.getAccessToken(), new URL((String)localObject1));
      return paramPagingDirection;
    }
    catch (MalformedURLException paramPagingDirection) {}
    return null;
  }
  
  public String toString()
  {
    for (;;)
    {
      try
      {
        localObject = Locale.US;
        if (connection == null) {
          continue;
        }
        i = connection.getResponseCode();
        localObject = String.format((Locale)localObject, "%d", new Object[] { Integer.valueOf(i) });
      }
      catch (IOException localIOException)
      {
        Object localObject;
        int i;
        String str = "unknown";
        continue;
      }
      return "{Response: " + " responseCode: " + (String)localObject + ", graphObject: " + graphObject + ", error: " + error + "}";
      i = 200;
    }
  }
  
  public static enum PagingDirection
  {
    NEXT,  PREVIOUS;
    
    private PagingDirection() {}
  }
}

/* Location:
 * Qualified Name:     com.facebook.GraphResponse
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */