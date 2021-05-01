package com.testcy.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(reason = "用户被拒绝登录系统。。。",value = HttpStatus.NOT_ACCEPTABLE)
public class UserNotFoundException extends RuntimeException{

    static final long serialVersionUID = -7034897190745766399L;

}
