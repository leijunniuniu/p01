package com.czxy.domain;


import javax.persistence.Id;

public class PCategory {
  @Id
  private String pCid;
  private String pCname;

  public PCategory() {
  }

  public PCategory(String pCid, String pCname) {
    this.pCid = pCid;
    this.pCname = pCname;
  }

  @Override
  public String toString() {
    return "PCategory{" +
            "pCid='" + pCid + '\'' +
            ", pCname='" + pCname + '\'' +
            '}';
  }

  public String getPCid() {
    return pCid;
  }

  public void setPCid(String pCid) {
    this.pCid = pCid;
  }


  public String getPCname() {
    return pCname;
  }

  public void setPCname(String pCname) {
    this.pCname = pCname;
  }

}
