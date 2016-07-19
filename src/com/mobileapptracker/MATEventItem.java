package com.mobileapptracker;

import java.util.HashMap;
import org.json.JSONObject;

public class MATEventItem
{
  public String attribute_sub1;
  public String attribute_sub2;
  public String attribute_sub3;
  public String attribute_sub4;
  public String attribute_sub5;
  public String itemname;
  public int quantity;
  public double revenue;
  public double unitPrice;
  
  public JSONObject toJSON()
  {
    HashMap localHashMap = new HashMap();
    if (itemname != null) {
      localHashMap.put("item", itemname);
    }
    localHashMap.put("quantity", Integer.toString(quantity));
    localHashMap.put("unit_price", Double.toString(unitPrice));
    if (revenue != 0.0D) {
      localHashMap.put("revenue", Double.toString(revenue));
    }
    if (attribute_sub1 != null) {
      localHashMap.put("attribute_sub1", attribute_sub1);
    }
    if (attribute_sub2 != null) {
      localHashMap.put("attribute_sub2", attribute_sub2);
    }
    if (attribute_sub3 != null) {
      localHashMap.put("attribute_sub3", attribute_sub3);
    }
    if (attribute_sub4 != null) {
      localHashMap.put("attribute_sub4", attribute_sub4);
    }
    if (attribute_sub5 != null) {
      localHashMap.put("attribute_sub5", attribute_sub5);
    }
    return new JSONObject(localHashMap);
  }
}

/* Location:
 * Qualified Name:     com.mobileapptracker.MATEventItem
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */