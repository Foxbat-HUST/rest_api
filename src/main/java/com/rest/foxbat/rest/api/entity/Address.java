package com.rest.foxbat.rest.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity(name = "ADDRESS")
public class Address {

    @Id
    private Long id;

    @Column(name = "USER_ID")
    private Long userId;

    @Column(name = "ZIPCODE")
    private String zipCode;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "CREATE_TS")
    private Date createTs;

    @Column(name = "UPDATE_TS")
    private Date updateTs;

    public Address(){

    }

    public Address(Long id, Long userId, String zipCode, String address) {
        this.id = id;
        this.userId = userId;
        this.zipCode = zipCode;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getCreateTs() {
        return createTs;
    }

    public void setCreateTs(Date createTs) {
        this.createTs = createTs;
    }

    public Date getUpdateTs() {
        return updateTs;
    }

    public void setUpdateTs(Date updateTs) {
        this.updateTs = updateTs;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", userId=" + userId +
                ", zipCode='" + zipCode + '\'' +
                ", address='" + address + '\'' +
                ", createTs=" + createTs +
                ", updateTs=" + updateTs +
                '}';
    }
}
