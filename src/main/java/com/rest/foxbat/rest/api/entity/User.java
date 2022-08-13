package com.rest.foxbat.rest.api.entity;

import com.rest.foxbat.rest.api.dto.UserInfoDto;

import javax.persistence.*;
import java.sql.Date;
@SqlResultSetMapping(
        name = "UserInfoDto.mapping",
        classes = {
                @ConstructorResult(
                        targetClass = UserInfoDto.class,
                        columns = {
                                @ColumnResult(name = "NAME", type = String.class),
                                @ColumnResult(name = "AGE", type = Integer.class),
                                @ColumnResult(name = "EMAIL", type = String.class),
                                @ColumnResult(name = "ZIPCODE", type = String.class),
                                @ColumnResult(name = "ADDRESS", type = String.class)
                        }
                )
        })
@Entity(name = "users")
public class User {
    public User(){

    }

    public User(long id, String name, int age, String email){
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
    }

    @Id
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private Integer age;

    @Column(name = "email")
    private String email;

    @Column(name = "created_at")
    private Date createTs;

    @Column(name = "updated_at")
    private Date updateTs;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", createTs=" + createTs +
                ", updateTs=" + updateTs +
                '}';
    }
}
