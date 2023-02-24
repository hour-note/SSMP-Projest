package com.houryun.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.houryun.domain.Book;
import org.apache.logging.log4j.util.Strings;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookServiceTestCase {
    @Autowired
    private IBookService bookService;

    @Test
    public void TestGetById() {
        bookService.getById(13);
    }

    @Test
    public void TestGetALl() {
        System.out.println(bookService.list());
    }

    @Test
    public void TestSave() {
        Book book = new Book();
        book.setName("测试数据111");
        book.setType("测试数据111");
        book.setDescription("测试数据111");
        bookService.save(book);
    }

    @Test
    public void TestUpdate() {
        Book book = new Book();
        book.setId(14);
        book.setName("测试数据111222333");
        book.setType("测试数据11122333");
        book.setDescription("测试数据111222333");
        boolean flag = bookService.updateById(book);

        System.out.println(flag);
    }

    @Test
    public void TestDelete() {
        bookService.removeById(13);
    }


    // 分页查询
    @Test
    public void TestGetPage() {
        IPage<Book> page = new Page<>(0,5);
        bookService.page(page);

        // 起始页数
        System.out.println(page.getCurrent());
        // 每页多少条
        System.out.println(page.getSize());
        // 共三页
        System.out.println(page.getPages());
        // 总条数
        System.out.println(page.getTotal());
        // 数据
        System.out.println(page.getRecords());
    }

    // 条件查询
    @Test
    public void TestGetBy() {
        LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper<>();

        String name = "实战";

        lqw.like(Strings.isNotEmpty(name),Book::getName,name);

        IPage<Book> page = new Page<>(0,5);

        IPage<Book> bookIPage = bookService.page(page, lqw);

        // 起始页数
        System.out.println(bookIPage.getCurrent());
        // 每页多少条
        System.out.println(bookIPage.getSize());
        // 共三页
        System.out.println(bookIPage.getPages());
        // 总条数
        System.out.println(bookIPage.getTotal());
        // 数据
        System.out.println(bookIPage.getRecords());
    }
}
