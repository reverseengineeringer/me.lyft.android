package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class PaymentBreakdownItemDTO
{
  @SerializedName("charges")
  public final List<ChargeDTO> charges;
  @SerializedName("coupons")
  public final List<ChargeDTO> coupons;
  @SerializedName("lineItems")
  public final List<LineItemDTO> lineItems;
  @SerializedName("lineItemsTotal")
  public final LineItemDTO lineItemsTotal;
  @SerializedName("splitPayment")
  public final SplitPaymentDTO splitPayment;
  @SerializedName("title")
  public final String title;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class PaymentBreakdownItemDTO {\n");
    localStringBuilder.append("  title: ").append(title).append("\n");
    localStringBuilder.append("  lineItems: ").append(lineItems).append("\n");
    localStringBuilder.append("  lineItemsTotal: ").append(lineItemsTotal).append("\n");
    localStringBuilder.append("  coupons: ").append(coupons).append("\n");
    localStringBuilder.append("  splitPayment: ").append(splitPayment).append("\n");
    localStringBuilder.append("  charges: ").append(charges).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.PaymentBreakdownItemDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */