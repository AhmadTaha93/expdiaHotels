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
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "hotelInfositeUrl",
    "hotelSearchResultUrl"
})
public class HotelUrls {

    @JsonProperty("hotelInfositeUrl")
    private String hotelInfositeUrl;
    @JsonProperty("hotelSearchResultUrl")
    private String hotelSearchResultUrl;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("hotelInfositeUrl")
    public String getHotelInfositeUrl() {
        return hotelInfositeUrl;
    }

    @JsonProperty("hotelInfositeUrl")
    public void setHotelInfositeUrl(String hotelInfositeUrl) {
        try {
            hotelInfositeUrl = java.net.URLDecoder.decode(hotelInfositeUrl, "UTF-8");
            this.hotelInfositeUrl = hotelInfositeUrl;
        } catch (UnsupportedEncodingException ex) {
            System.out.println("url decode : error" + ex);
            this.hotelInfositeUrl = "";
        }
    }

    @JsonProperty("hotelSearchResultUrl")
    public String getHotelSearchResultUrl() {
        return hotelSearchResultUrl;
    }

    @JsonProperty("hotelSearchResultUrl")
    public void setHotelSearchResultUrl(String hotelSearchResultUrl) {
        try {
            hotelSearchResultUrl = java.net.URLDecoder.decode(hotelSearchResultUrl, "UTF-8");
            this.hotelSearchResultUrl = hotelSearchResultUrl;
        } catch (UnsupportedEncodingException ex) {
            System.out.println("decode hotelSearchResultUrl : " + ex);
            this.hotelSearchResultUrl = "";
        }
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
        return "HotelUrls{" + "hotelInfositeUrl=" + hotelInfositeUrl + ", hotelSearchResultUrl=" + hotelSearchResultUrl + ", additionalProperties=" + additionalProperties + '}';
    }

}
