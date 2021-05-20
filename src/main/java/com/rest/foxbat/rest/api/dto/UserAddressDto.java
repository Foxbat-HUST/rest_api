package com.rest.foxbat.rest.api.dto;

public class UserAddressDto {

    private long id;
    private String name;
    private int age;
    private String email;
    private String zipcode;
    private String address;

    public UserAddressDto(long id, String name, int age, String email, String zipcode, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.zipcode = zipcode;
        this.address = address;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "UserAddressDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
