package com.harrisburgU.search.pojos;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource(value = "classpath:searchPlacesInput.json")
@ConfigurationProperties
public class SearchPlacesRequest {
    private String key;
    private String input;
    private String inputtype;
    private String fields;
    private String locationbias;
    private String location;
    private String radius;
    private String type;
    private String address;

    public String getInput() { return input; }

    public String getInputtype() { return inputtype; }

    public String getFields() {return fields; }

    public String getLocationbias() { return locationbias; }

    public String getKey() { return key; }

    public String getLocation() { return location; }

    public String getRadius() { return radius; }

    public String getType() { return type; }

    public void setInput(String input) { this.input = input; }

    public void setInputtype(String inputtype) { this.inputtype = inputtype; }

    public void setFields(String fields) { this.fields = fields; }

    public void setLocationbias(String locationbias) { this.locationbias = locationbias; }

    public void setKey(String key) { this.key = key; }

    public void setLocation(String location) { this.location = location; }

    public void setRadius(String radius) { this.radius = radius; }

    public void setType(String type) { this.type = type; }

    public void setAddress(String address) { this.address = address; }

    public String getAddress() { return address; }
}
