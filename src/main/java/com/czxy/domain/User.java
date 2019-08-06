package com.czxy.domain;


import javax.persistence.Id;

public class User {
  @Id
  private String uid;
  private String username;
  private String password;
  private String phone;
  private String signature;
  private String hobby;
  private String address;

  public User() {
  }

  public User(String uid, String username, String password, String phone, String signature, String hobby, String address) {
    this.uid = uid;
    this.username = username;
    this.password = password;
    this.phone = phone;
    this.signature = signature;
    this.hobby = hobby;
    this.address = address;
  }

  public String getUid() {
    return uid;
  }

  public void setUid(String uid) {
    this.uid = uid;
  }


  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }


  public String getSignature() {
    return signature;
  }

  public void setSignature(String signature) {
    this.signature = signature;
  }


  public String getHobby() {
    return hobby;
  }

  public void setHobby(String hobby) {
    this.hobby = hobby;
  }


  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  @Override
  public String toString() {
    return "User{" +
            "uid='" + uid + '\'' +
            ", username='" + username + '\'' +
            ", password='" + password + '\'' +
            ", phone='" + phone + '\'' +
            ", signature='" + signature + '\'' +
            ", hobby='" + hobby + '\'' +
            ", address='" + address + '\'' +
            '}';
  }
}
