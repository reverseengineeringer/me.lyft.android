package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class ExpressPayDTO
{
  @SerializedName("expressAccount")
  public final ExpressPayAccountDTO expressAccount;
  @SerializedName("lineItems")
  public final List<LineItemDTO> lineItems;
  @SerializedName("payoutInfoText")
  public final String payoutInfoText;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class ExpressPayDTO {\n");
    localStringBuilder.append("  lineItems: ").append(lineItems).append("\n");
    localStringBuilder.append("  payoutInfoText: ").append(payoutInfoText).append("\n");
    localStringBuilder.append("  expressAccount: ").append(expressAccount).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.ExpressPayDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */