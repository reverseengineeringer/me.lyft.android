package com.facebook.appevents;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;

class AppEventStore$MovedClassObjectInputStream
  extends ObjectInputStream
{
  private static final String ACCESS_TOKEN_APP_ID_PAIR_SERIALIZATION_PROXY_V1_CLASS_NAME = "com.facebook.appevents.AppEventsLogger$AccessTokenAppIdPair$SerializationProxyV1";
  private static final String APP_EVENT_SERIALIZATION_PROXY_V1_CLASS_NAME = "com.facebook.appevents.AppEventsLogger$AppEvent$SerializationProxyV1";
  
  public AppEventStore$MovedClassObjectInputStream(InputStream paramInputStream)
    throws IOException
  {
    super(paramInputStream);
  }
  
  protected ObjectStreamClass readClassDescriptor()
    throws IOException, ClassNotFoundException
  {
    ObjectStreamClass localObjectStreamClass2 = super.readClassDescriptor();
    ObjectStreamClass localObjectStreamClass1;
    if (localObjectStreamClass2.getName().equals("com.facebook.appevents.AppEventsLogger$AccessTokenAppIdPair$SerializationProxyV1")) {
      localObjectStreamClass1 = ObjectStreamClass.lookup(AccessTokenAppIdPair.SerializationProxyV1.class);
    }
    do
    {
      return localObjectStreamClass1;
      localObjectStreamClass1 = localObjectStreamClass2;
    } while (!localObjectStreamClass2.getName().equals("com.facebook.appevents.AppEventsLogger$AppEvent$SerializationProxyV1"));
    return ObjectStreamClass.lookup(AppEvent.SerializationProxyV1.class);
  }
}

/* Location:
 * Qualified Name:     com.facebook.appevents.AppEventStore.MovedClassObjectInputStream
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */