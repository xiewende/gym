package com.xiaoxie.gym.place.util;


/**
 * @create 2020-06-17  12:44
 */
public class ReturnMsg {

    private String successful;
    private String status;
    private String msg;
    private User data;

    public String getSuccessful() {
        return successful;
    }

    public void setSuccessful(String successful) {
        this.successful = successful;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public User getData() {
        return data;
    }

    public void setData(User data) {
        this.data = data;
    }
}
