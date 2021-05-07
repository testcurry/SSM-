package com.testcy.bean;

public class Lock {

    private Integer id;
    private String lockName;

    public Lock() {
    }

    public Lock(Integer id, String lockName) {
        this.id = id;
        this.lockName = lockName;
    }

    public Integer getId() {
        return id;
    }

    public String getLockName() {
        return lockName;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setLockName(String lockName) {
        this.lockName = lockName;
    }

    @Override
    public String toString() {
        return "Lock{" +
                "id=" + id +
                ", lockName='" + lockName + '\'' +
                '}';
    }
}
