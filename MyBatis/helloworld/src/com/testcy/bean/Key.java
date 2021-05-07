package com.testcy.bean;

public class Key {

    private Integer id;
    private String keyName;
    private Lock lock;

    public Key() {
    }

    public Key(Integer id, String keyName, Lock lock) {
        this.id = id;
        this.keyName = keyName;
        this.lock = lock;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return keyName;
    }

    public void setName(String keyName) {
        this.keyName = keyName;
    }

    public Lock getLock() {
        return lock;
    }

    public void setLock(Lock lock) {
        this.lock = lock;
    }

    @Override
    public String toString() {
        return "Key{" +
                "id=" + id +
                ", name='" + keyName + '\'' +
                ", lock=" + lock +
                '}';
    }
}
