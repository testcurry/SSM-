package com.testcy.mapper;

import com.testcy.bean.Lock;

public interface LockMapper {

    //查锁的时候将其所有的钥匙也都查出来
    public Lock getLockById(Integer id);

}
