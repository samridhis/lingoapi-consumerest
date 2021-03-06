package com.javainuse.model;

import lombok.Data;

import java.util.Date;
import java.util.List;

// import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
// import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
/* ObjectMapper om = new ObjectMapper();
Root root = om.readValue(myJsonString), Root.class); */

@Data
public class Meta {
    public Date lastUpdated;
    public String versionId;
    public List<String> profile;
}
