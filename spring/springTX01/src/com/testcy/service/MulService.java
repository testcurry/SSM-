package com.testcy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileNotFoundException;

@Service
public class MulService {

    @Autowired
    private BookService bookService;

    @Transactional
    public void mulTx() throws FileNotFoundException {
        //REQUIRED
        bookService.checkOut("Tom","ISBN-001");

        //REQUIRED  REQUIRES_NEW
        bookService.updatePrice("ISBN-002",998);
        int i=10/0;


    }
}
