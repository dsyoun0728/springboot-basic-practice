package com.springboot.api.dto;

import io.swagger.annotations.ApiModelProperty;

public class MemberDto {

  @ApiModelProperty(value = "이름", required = true)
  private String name;
  @ApiModelProperty(value = "이메일", required = true)
  private String email;
  @ApiModelProperty(value = "회사", required = true)
  private String organization;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getOrganization() {
    return organization;
  }

  public void setOrganization(String organization) {
    this.organization = organization;
  }

  @Override
  public String toString() {
    return "MemberDto{" +
        "name='" + name + '\'' +
        ", email='" + email + '\'' +
        ", organization='" + organization + '\'' +
        "}";
  }
}
