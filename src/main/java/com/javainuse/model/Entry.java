package com.javainuse.model;

import lombok.Data;

@Data
public class Entry {
    public String fullUrl;
    public Resource resource;
    public Search search;
}
