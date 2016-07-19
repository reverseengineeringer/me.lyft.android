package com.leanplum.annotations;

import android.util.Log;
import com.leanplum.Var;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

public class Parser
{
  private static void a(Object paramObject, Class<?> paramClass)
  {
    Field[] arrayOfField = paramClass.getFields();
    int k = arrayOfField.length;
    int i = 0;
    if (i >= k) {
      return;
    }
    Field localField = arrayOfField[i];
    String str;
    int j;
    label64:
    Object localObject;
    if (localField.isAnnotationPresent(Variable.class))
    {
      paramClass = (Variable)localField.getAnnotation(Variable.class);
      str = paramClass.group();
      paramClass = paramClass.name();
      j = 0;
      if (paramClass != null)
      {
        localObject = paramClass;
        if (paramClass.length() != 0) {}
      }
      else
      {
        localObject = localField.getName();
      }
      paramClass = (Class<?>)localObject;
      if (str.length() > 0) {
        paramClass = str + "." + (String)localObject;
      }
      localObject = localField.getType();
      str = ((Class)localObject).toString();
      if (!str.equals("int")) {
        break label212;
      }
      a(paramObject, paramClass, Integer.valueOf(localField.getInt(paramObject)), "integer", localField);
    }
    for (;;)
    {
      i += 1;
      break;
      if (localField.isAnnotationPresent(File.class))
      {
        paramClass = (File)localField.getAnnotation(File.class);
        str = paramClass.group();
        paramClass = paramClass.name();
        j = 1;
        break label64;
        label212:
        if (str.equals("byte"))
        {
          a(paramObject, paramClass, Byte.valueOf(localField.getByte(paramObject)), "integer", localField);
        }
        else if (str.equals("short"))
        {
          a(paramObject, paramClass, Short.valueOf(localField.getShort(paramObject)), "integer", localField);
        }
        else if (str.equals("long"))
        {
          a(paramObject, paramClass, Long.valueOf(localField.getLong(paramObject)), "integer", localField);
        }
        else if (str.equals("char"))
        {
          a(paramObject, paramClass, Character.valueOf(localField.getChar(paramObject)), "integer", localField);
        }
        else if (str.equals("float"))
        {
          a(paramObject, paramClass, Float.valueOf(localField.getFloat(paramObject)), "float", localField);
        }
        else if (str.equals("double"))
        {
          a(paramObject, paramClass, Double.valueOf(localField.getDouble(paramObject)), "float", localField);
        }
        else if (str.equals("boolean"))
        {
          a(paramObject, paramClass, Boolean.valueOf(localField.getBoolean(paramObject)), "bool", localField);
        }
        else if (((Class)localObject).isPrimitive())
        {
          Log.e("Leanplum", "Variable " + paramClass + " is an unsupported primitive type");
        }
        else if (((Class)localObject).isArray())
        {
          Log.e("Leanplum", "Variable " + paramClass + " should be a List instead of an Array");
        }
        else if (((Class)localObject).isAssignableFrom(List.class))
        {
          a(paramObject, paramClass, localField.get(paramObject), "list", localField);
        }
        else if (((Class)localObject).isAssignableFrom(Map.class))
        {
          a(paramObject, paramClass, localField.get(paramObject), "group", localField);
        }
        else
        {
          localObject = localField.get(paramObject);
          if (localObject == null)
          {
            localObject = null;
            label577:
            if (j == 0) {
              break label638;
            }
            paramClass = Var.defineFile(paramClass, (String)localObject);
            if (paramObject == null) {
              break label632;
            }
          }
          label632:
          for (boolean bool = true;; bool = false)
          {
            paramClass.addFileReadyHandler(new b(new WeakReference(paramObject), bool, localField, paramClass));
            break;
            localObject = localObject.toString();
            break label577;
          }
          label638:
          a(paramObject, paramClass, localObject, "string", localField);
        }
      }
    }
  }
  
  private static <T> void a(Object paramObject, String paramString1, T paramT, String paramString2, Field paramField)
  {
    paramString1 = Var.define(paramString1, paramT, paramString2);
    if (paramObject != null) {}
    for (boolean bool = true;; bool = false)
    {
      paramString1.addValueChangedHandler(new a(new WeakReference(paramObject), bool, paramField, paramString1));
      return;
    }
  }
  
  public static void parseVariables(Object... paramVarArgs)
  {
    int j;
    int i;
    do
    {
      try
      {
        j = paramVarArgs.length;
        i = 0;
      }
      catch (Exception paramVarArgs)
      {
        Object localObject;
        Log.e("Leanplum", "Error parsing variables", paramVarArgs);
        return;
      }
      localObject = paramVarArgs[i];
      a(localObject, localObject.getClass());
      i += 1;
    } while (i < j);
  }
  
  public static void parseVariablesForClasses(Class<?>... paramVarArgs)
  {
    int j;
    int i;
    do
    {
      try
      {
        j = paramVarArgs.length;
        i = 0;
      }
      catch (Exception paramVarArgs)
      {
        Log.e("Leanplum", "Error parsing variables", paramVarArgs);
        return;
      }
      a(null, paramVarArgs[i]);
      i += 1;
    } while (i < j);
  }
}

/* Location:
 * Qualified Name:     com.leanplum.annotations.Parser
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */