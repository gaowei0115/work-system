package com.mmc.work.serializable;

/**
 * @packageName：com.mmc.work.serializable
 * @desrciption:
 * @author: gaowei
 * @date： 2018-03-15 15:46
 * @history: (version) author date desc
 */
public class DomainUnSerializable {

    private Long uuid;

    private String userName;

    private String password;

    public DomainUnSerializable() {

    }

    public DomainUnSerializable(Long uuid, String userName, String password) {
        this.uuid = uuid;
        this.userName = userName;
        this.password = password;
    }

    public Long getUuid() {
        return uuid;
    }

    public void setUuid(Long uuid) {
        this.uuid = uuid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "DomainUnSerializable{" +
                "uuid=" + uuid +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
