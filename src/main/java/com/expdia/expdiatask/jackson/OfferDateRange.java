/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.expdia.expdiatask.jackson;

/**
 *
 * @author ahmad
 */
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"travelStartDate",
"travelEndDate",
"lengthOfStay"
})
public class OfferDateRange {

@JsonProperty("travelStartDate")
private List<Integer> travelStartDate = null;
@JsonProperty("travelEndDate")
private List<Integer> travelEndDate = null;
@JsonProperty("lengthOfStay")
private Integer lengthOfStay;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("travelStartDate")
public List<Integer> getTravelStartDate() {
return travelStartDate;
}

@JsonProperty("travelStartDate")
public void setTravelStartDate(List<Integer> travelStartDate) {
this.travelStartDate = travelStartDate;
}

@JsonProperty("travelEndDate")
public List<Integer> getTravelEndDate() {
return travelEndDate;
}

@JsonProperty("travelEndDate")
public void setTravelEndDate(List<Integer> travelEndDate) {
this.travelEndDate = travelEndDate;
}

@JsonProperty("lengthOfStay")
public Integer getLengthOfStay() {
return lengthOfStay;
}

@JsonProperty("lengthOfStay")
public void setLengthOfStay(Integer lengthOfStay) {
this.lengthOfStay = lengthOfStay;
}

@JsonAnyGetter
public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

@JsonAnySetter
public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

    @Override
    public String toString() {
        return "OfferDateRange{" + "travelStartDate=" + travelStartDate + ", travelEndDate=" + travelEndDate + ", lengthOfStay=" + lengthOfStay + ", additionalProperties=" + additionalProperties + '}';
    }


}
