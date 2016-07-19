package com.facebook;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.internal.ImageRequest;
import com.facebook.internal.Utility;
import com.facebook.internal.Utility.GraphMeRequestWithCacheCallback;
import com.facebook.internal.Validate;
import org.json.JSONException;
import org.json.JSONObject;

public final class Profile
  implements Parcelable
{
  public static final Parcelable.Creator<Profile> CREATOR = new Parcelable.Creator()
  {
    public Profile createFromParcel(Parcel paramAnonymousParcel)
    {
      return new Profile(paramAnonymousParcel, null);
    }
    
    public Profile[] newArray(int paramAnonymousInt)
    {
      return new Profile[paramAnonymousInt];
    }
  };
  private static final String FIRST_NAME_KEY = "first_name";
  private static final String ID_KEY = "id";
  private static final String LAST_NAME_KEY = "last_name";
  private static final String LINK_URI_KEY = "link_uri";
  private static final String MIDDLE_NAME_KEY = "middle_name";
  private static final String NAME_KEY = "name";
  private final String firstName;
  private final String id;
  private final String lastName;
  private final Uri linkUri;
  private final String middleName;
  private final String name;
  
  private Profile(Parcel paramParcel)
  {
    id = paramParcel.readString();
    firstName = paramParcel.readString();
    middleName = paramParcel.readString();
    lastName = paramParcel.readString();
    name = paramParcel.readString();
    paramParcel = paramParcel.readString();
    if (paramParcel == null) {}
    for (paramParcel = null;; paramParcel = Uri.parse(paramParcel))
    {
      linkUri = paramParcel;
      return;
    }
  }
  
  public Profile(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, Uri paramUri)
  {
    Validate.notNullOrEmpty(paramString1, "id");
    id = paramString1;
    firstName = paramString2;
    middleName = paramString3;
    lastName = paramString4;
    name = paramString5;
    linkUri = paramUri;
  }
  
  Profile(JSONObject paramJSONObject)
  {
    id = paramJSONObject.optString("id", null);
    firstName = paramJSONObject.optString("first_name", null);
    middleName = paramJSONObject.optString("middle_name", null);
    lastName = paramJSONObject.optString("last_name", null);
    name = paramJSONObject.optString("name", null);
    paramJSONObject = paramJSONObject.optString("link_uri", null);
    if (paramJSONObject == null) {}
    for (paramJSONObject = (JSONObject)localObject;; paramJSONObject = Uri.parse(paramJSONObject))
    {
      linkUri = paramJSONObject;
      return;
    }
  }
  
  public static void fetchProfileForCurrentAccessToken()
  {
    AccessToken localAccessToken = AccessToken.getCurrentAccessToken();
    if (localAccessToken == null)
    {
      setCurrentProfile(null);
      return;
    }
    Utility.getGraphMeRequestWithCacheAsync(localAccessToken.getToken(), new Utility.GraphMeRequestWithCacheCallback()
    {
      public void onFailure(FacebookException paramAnonymousFacebookException) {}
      
      public void onSuccess(JSONObject paramAnonymousJSONObject)
      {
        String str1 = paramAnonymousJSONObject.optString("id");
        if (str1 == null) {
          return;
        }
        String str6 = paramAnonymousJSONObject.optString("link");
        String str2 = paramAnonymousJSONObject.optString("first_name");
        String str3 = paramAnonymousJSONObject.optString("middle_name");
        String str4 = paramAnonymousJSONObject.optString("last_name");
        String str5 = paramAnonymousJSONObject.optString("name");
        if (str6 != null) {}
        for (paramAnonymousJSONObject = Uri.parse(str6);; paramAnonymousJSONObject = null)
        {
          Profile.setCurrentProfile(new Profile(str1, str2, str3, str4, str5, paramAnonymousJSONObject));
          return;
        }
      }
    });
  }
  
  public static Profile getCurrentProfile()
  {
    return ProfileManager.getInstance().getCurrentProfile();
  }
  
  public static void setCurrentProfile(Profile paramProfile)
  {
    ProfileManager.getInstance().setCurrentProfile(paramProfile);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return true;
              if (!(paramObject instanceof Profile)) {
                return false;
              }
              paramObject = (Profile)paramObject;
              if ((!id.equals(id)) || (firstName != null)) {
                break;
              }
            } while (firstName == null);
            return false;
            if ((!firstName.equals(firstName)) || (middleName != null)) {
              break;
            }
          } while (middleName == null);
          return false;
          if ((!middleName.equals(middleName)) || (lastName != null)) {
            break;
          }
        } while (lastName == null);
        return false;
        if ((!lastName.equals(lastName)) || (name != null)) {
          break;
        }
      } while (name == null);
      return false;
      if ((!name.equals(name)) || (linkUri != null)) {
        break;
      }
    } while (linkUri == null);
    return false;
    return linkUri.equals(linkUri);
  }
  
  public String getFirstName()
  {
    return firstName;
  }
  
  public String getId()
  {
    return id;
  }
  
  public String getLastName()
  {
    return lastName;
  }
  
  public Uri getLinkUri()
  {
    return linkUri;
  }
  
  public String getMiddleName()
  {
    return middleName;
  }
  
  public String getName()
  {
    return name;
  }
  
  public Uri getProfilePictureUri(int paramInt1, int paramInt2)
  {
    return ImageRequest.getProfilePictureUri(id, paramInt1, paramInt2);
  }
  
  public int hashCode()
  {
    int j = id.hashCode() + 527;
    int i = j;
    if (firstName != null) {
      i = j * 31 + firstName.hashCode();
    }
    j = i;
    if (middleName != null) {
      j = i * 31 + middleName.hashCode();
    }
    i = j;
    if (lastName != null) {
      i = j * 31 + lastName.hashCode();
    }
    j = i;
    if (name != null) {
      j = i * 31 + name.hashCode();
    }
    i = j;
    if (linkUri != null) {
      i = j * 31 + linkUri.hashCode();
    }
    return i;
  }
  
  JSONObject toJSONObject()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("id", id);
      localJSONObject.put("first_name", firstName);
      localJSONObject.put("middle_name", middleName);
      localJSONObject.put("last_name", lastName);
      localJSONObject.put("name", name);
      if (linkUri != null) {
        localJSONObject.put("link_uri", linkUri.toString());
      }
      return localJSONObject;
    }
    catch (JSONException localJSONException) {}
    return null;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(id);
    paramParcel.writeString(firstName);
    paramParcel.writeString(middleName);
    paramParcel.writeString(lastName);
    paramParcel.writeString(name);
    if (linkUri == null) {}
    for (String str = null;; str = linkUri.toString())
    {
      paramParcel.writeString(str);
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.facebook.Profile
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */