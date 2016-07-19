package com.facebook.share.model;

public class AppGroupCreationContent$Builder
  implements ShareModelBuilder<AppGroupCreationContent, Builder>
{
  private String description;
  private String name;
  private AppGroupCreationContent.AppGroupPrivacy privacy;
  
  public AppGroupCreationContent build()
  {
    return new AppGroupCreationContent(this, null);
  }
  
  public Builder readFrom(AppGroupCreationContent paramAppGroupCreationContent)
  {
    if (paramAppGroupCreationContent == null) {
      return this;
    }
    return setName(paramAppGroupCreationContent.getName()).setDescription(paramAppGroupCreationContent.getDescription()).setAppGroupPrivacy(paramAppGroupCreationContent.getAppGroupPrivacy());
  }
  
  public Builder setAppGroupPrivacy(AppGroupCreationContent.AppGroupPrivacy paramAppGroupPrivacy)
  {
    privacy = paramAppGroupPrivacy;
    return this;
  }
  
  public Builder setDescription(String paramString)
  {
    description = paramString;
    return this;
  }
  
  public Builder setName(String paramString)
  {
    name = paramString;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.facebook.share.model.AppGroupCreationContent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */