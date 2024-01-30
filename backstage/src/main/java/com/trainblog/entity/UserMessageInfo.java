package com.trainblog.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserMessageInfo implements Serializable {

    private String templatecode;

    private String phonenumbers;

    private String templateparam;

    public UserMessageInfo(String templatecode, String phonenumbers, String templateparam) {
        this.templatecode = templatecode;
        this.phonenumbers = phonenumbers;
        this.templateparam = templateparam;
    }
}
