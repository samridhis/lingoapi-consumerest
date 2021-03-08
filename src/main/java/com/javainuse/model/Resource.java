package com.javainuse.model;

import java.util.List;

public class Resource {
    public String resourceType;
    public String id;
    public Meta meta;
    public List<Extension> extension;
    public List<Identifier> identifier;
    public boolean active;
    public List<Name> name;
    public List<Telecom> telecom;
    public List<Address> address;
    public String gender;
}
