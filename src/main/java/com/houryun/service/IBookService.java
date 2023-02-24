package com.houryun.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.houryun.domain.Book;

public interface IBookService extends IService<Book> {

    IPage<Book> getPage(Integer current, Integer pageSize);
    IPage<Book> getPage(Integer current, Integer pageSize, Book book);
}
