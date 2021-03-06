package com.google.gson.internal.bind;

import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.internal..Gson.Types;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.internal.Primitives;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class ReflectiveTypeAdapterFactory
  implements TypeAdapterFactory
{
  private final ConstructorConstructor constructorConstructor;
  private final Excluder excluder;
  private final FieldNamingStrategy fieldNamingPolicy;
  
  public ReflectiveTypeAdapterFactory(ConstructorConstructor paramConstructorConstructor, FieldNamingStrategy paramFieldNamingStrategy, Excluder paramExcluder)
  {
    constructorConstructor = paramConstructorConstructor;
    fieldNamingPolicy = paramFieldNamingStrategy;
    excluder = paramExcluder;
  }
  
  private BoundField createBoundField(final Gson paramGson, final Field paramField, String paramString, final TypeToken<?> paramTypeToken, boolean paramBoolean1, boolean paramBoolean2)
  {
    new BoundField(paramString, paramBoolean1, paramBoolean2)
    {
      final TypeAdapter<?> typeAdapter = getFieldAdapter(paramGson, paramField, paramTypeToken);
      
      void read(JsonReader paramAnonymousJsonReader, Object paramAnonymousObject)
        throws IOException, IllegalAccessException
      {
        paramAnonymousJsonReader = typeAdapter.read(paramAnonymousJsonReader);
        if ((paramAnonymousJsonReader != null) || (!val$isPrimitive)) {
          paramField.set(paramAnonymousObject, paramAnonymousJsonReader);
        }
      }
      
      void write(JsonWriter paramAnonymousJsonWriter, Object paramAnonymousObject)
        throws IOException, IllegalAccessException
      {
        paramAnonymousObject = paramField.get(paramAnonymousObject);
        new TypeAdapterRuntimeTypeWrapper(paramGson, typeAdapter, paramTypeToken.getType()).write(paramAnonymousJsonWriter, paramAnonymousObject);
      }
      
      public boolean writeField(Object paramAnonymousObject)
        throws IOException, IllegalAccessException
      {
        if (!serialized) {}
        while (paramField.get(paramAnonymousObject) == paramAnonymousObject) {
          return false;
        }
        return true;
      }
    };
  }
  
  static boolean excludeField(Field paramField, boolean paramBoolean, Excluder paramExcluder)
  {
    return (!paramExcluder.excludeClass(paramField.getType(), paramBoolean)) && (!paramExcluder.excludeField(paramField, paramBoolean));
  }
  
  private Map<String, BoundField> getBoundFields(Gson paramGson, TypeToken<?> paramTypeToken, Class<?> paramClass)
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    if (paramClass.isInterface()) {}
    for (;;)
    {
      return localLinkedHashMap;
      Type localType1 = paramTypeToken.getType();
      while (paramClass != Object.class)
      {
        Field[] arrayOfField = paramClass.getDeclaredFields();
        int k = arrayOfField.length;
        int i = 0;
        if (i < k)
        {
          Field localField = arrayOfField[i];
          boolean bool1 = excludeField(localField, true);
          boolean bool2 = excludeField(localField, false);
          if ((!bool1) && (!bool2)) {}
          Object localObject1;
          do
          {
            i += 1;
            break;
            localField.setAccessible(true);
            Type localType2 = .Gson.Types.resolve(paramTypeToken.getType(), paramClass, localField.getGenericType());
            List localList = getFieldNames(localField);
            localObject1 = null;
            int j = 0;
            while (j < localList.size())
            {
              Object localObject2 = (String)localList.get(j);
              if (j != 0) {
                bool1 = false;
              }
              BoundField localBoundField = (BoundField)localLinkedHashMap.put(localObject2, createBoundField(paramGson, localField, (String)localObject2, TypeToken.get(localType2), bool1, bool2));
              localObject2 = localObject1;
              if (localObject1 == null) {
                localObject2 = localBoundField;
              }
              j += 1;
              localObject1 = localObject2;
            }
          } while (localObject1 == null);
          throw new IllegalArgumentException(localType1 + " declares multiple JSON fields named " + name);
        }
        paramTypeToken = TypeToken.get(.Gson.Types.resolve(paramTypeToken.getType(), paramClass, paramClass.getGenericSuperclass()));
        paramClass = paramTypeToken.getRawType();
      }
    }
  }
  
  static List<String> getFieldName(FieldNamingStrategy paramFieldNamingStrategy, Field paramField)
  {
    SerializedName localSerializedName = (SerializedName)paramField.getAnnotation(SerializedName.class);
    LinkedList localLinkedList = new LinkedList();
    if (localSerializedName == null) {
      localLinkedList.add(paramFieldNamingStrategy.translateName(paramField));
    }
    for (;;)
    {
      return localLinkedList;
      localLinkedList.add(localSerializedName.value());
      paramFieldNamingStrategy = localSerializedName.alternate();
      int j = paramFieldNamingStrategy.length;
      int i = 0;
      while (i < j)
      {
        localLinkedList.add(paramFieldNamingStrategy[i]);
        i += 1;
      }
    }
  }
  
  private List<String> getFieldNames(Field paramField)
  {
    return getFieldName(fieldNamingPolicy, paramField);
  }
  
  public <T> TypeAdapter<T> create(Gson paramGson, TypeToken<T> paramTypeToken)
  {
    Class localClass = paramTypeToken.getRawType();
    if (!Object.class.isAssignableFrom(localClass)) {
      return null;
    }
    return new Adapter(constructorConstructor.get(paramTypeToken), getBoundFields(paramGson, paramTypeToken, localClass));
  }
  
  public boolean excludeField(Field paramField, boolean paramBoolean)
  {
    return excludeField(paramField, paramBoolean, excluder);
  }
  
  TypeAdapter<?> getFieldAdapter(Gson paramGson, Field paramField, TypeToken<?> paramTypeToken)
  {
    paramField = (JsonAdapter)paramField.getAnnotation(JsonAdapter.class);
    if (paramField != null)
    {
      paramField = JsonAdapterAnnotationTypeAdapterFactory.getTypeAdapter(constructorConstructor, paramGson, paramTypeToken, paramField);
      if (paramField != null) {
        return paramField;
      }
    }
    return paramGson.getAdapter(paramTypeToken);
  }
  
  public static final class Adapter<T>
    extends TypeAdapter<T>
  {
    private final Map<String, ReflectiveTypeAdapterFactory.BoundField> boundFields;
    private final ObjectConstructor<T> constructor;
    
    Adapter(ObjectConstructor<T> paramObjectConstructor, Map<String, ReflectiveTypeAdapterFactory.BoundField> paramMap)
    {
      constructor = paramObjectConstructor;
      boundFields = paramMap;
    }
    
    public T read(JsonReader paramJsonReader)
      throws IOException
    {
      if (paramJsonReader.peek() == JsonToken.NULL)
      {
        paramJsonReader.nextNull();
        return null;
      }
      Object localObject1 = constructor.construct();
      try
      {
        paramJsonReader.beginObject();
        for (;;)
        {
          if (!paramJsonReader.hasNext()) {
            break label103;
          }
          localObject2 = paramJsonReader.nextName();
          localObject2 = (ReflectiveTypeAdapterFactory.BoundField)boundFields.get(localObject2);
          if ((localObject2 != null) && (deserialized)) {
            break;
          }
          paramJsonReader.skipValue();
        }
      }
      catch (IllegalStateException paramJsonReader)
      {
        for (;;)
        {
          Object localObject2;
          throw new JsonSyntaxException(paramJsonReader);
          ((ReflectiveTypeAdapterFactory.BoundField)localObject2).read(paramJsonReader, localObject1);
        }
      }
      catch (IllegalAccessException paramJsonReader)
      {
        throw new AssertionError(paramJsonReader);
      }
      label103:
      paramJsonReader.endObject();
      return (T)localObject1;
    }
    
    public void write(JsonWriter paramJsonWriter, T paramT)
      throws IOException
    {
      if (paramT == null)
      {
        paramJsonWriter.nullValue();
        return;
      }
      paramJsonWriter.beginObject();
      try
      {
        Iterator localIterator = boundFields.values().iterator();
        while (localIterator.hasNext())
        {
          ReflectiveTypeAdapterFactory.BoundField localBoundField = (ReflectiveTypeAdapterFactory.BoundField)localIterator.next();
          if (localBoundField.writeField(paramT))
          {
            paramJsonWriter.name(name);
            localBoundField.write(paramJsonWriter, paramT);
          }
        }
        paramJsonWriter.endObject();
      }
      catch (IllegalAccessException paramJsonWriter)
      {
        throw new AssertionError(paramJsonWriter);
      }
    }
  }
  
  static abstract class BoundField
  {
    final boolean deserialized;
    final String name;
    final boolean serialized;
    
    protected BoundField(String paramString, boolean paramBoolean1, boolean paramBoolean2)
    {
      name = paramString;
      serialized = paramBoolean1;
      deserialized = paramBoolean2;
    }
    
    abstract void read(JsonReader paramJsonReader, Object paramObject)
      throws IOException, IllegalAccessException;
    
    abstract void write(JsonWriter paramJsonWriter, Object paramObject)
      throws IOException, IllegalAccessException;
    
    abstract boolean writeField(Object paramObject)
      throws IOException, IllegalAccessException;
  }
}

/* Location:
 * Qualified Name:     com.google.gson.internal.bind.ReflectiveTypeAdapterFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */