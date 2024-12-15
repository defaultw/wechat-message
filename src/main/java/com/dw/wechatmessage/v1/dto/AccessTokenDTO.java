package com.dw.wechatmessage.v1.dto;

// import java.io.Serial;

import java.io.Serializable;

/**
 * TODO
 *
 * @author Default.W
 * @date 2022/8/27
 */

public class AccessTokenDTO implements Serializable {

    // @Serial
    private static final long serialVersionUID = 1L;

    private String access_token;

    private Integer expires_in;

    public String getAccessToken() {
        return access_token;
    }

    public void setAccessToken(String accessToken) {
        access_token = accessToken;
    }

    public Integer getExpiresIn() {
        return expires_in;
    }

    public void setExpiresIn(Integer expiresIn) {
        expires_in = expiresIn;
    }

    @Override
    public String toString() {
        return "AccessTokenDTO{" +
                "access_token='" + access_token + '\'' +
                ", expires_in=" + expires_in +
                '}';
    }
}
