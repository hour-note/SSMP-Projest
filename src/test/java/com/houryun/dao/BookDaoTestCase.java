package com.houryun.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.houryun.domain.Book;
import org.apache.logging.log4j.util.Strings;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookDaoTestCase {
    @Autowired
    private BookDao bookDao;

    @Test
    public void TestGetById() {
        System.out.println(bookDao.selectById(1));
    }

    @Test
    public void TestGetALl() {
        System.out.println(bookDao.selectList(null));
    }

    @Test
    public void TestSave() {
        Book book = new Book();
        book.setName("测试数据111");
        book.setType("测试数据111");
        book.setDescription("测试数据111");
        bookDao.insert(book);
    }

    @Test
    public void TestUpdate() {
        Book book = new Book();
        book.setId(13);
        book.setName("测试数据111222333");
        book.setType("测试数据11122333");
        book.setDescription("测试数据111222333");
        bookDao.updateById(book);
    }

    @Test
    public void TestDelete() {
        bookDao.deleteById(13);
    }


    // 分页查询
    @Test
    public void TestGetPage() {
        IPage<Book> page = new Page<>(0,5);
        bookDao.selectPage(page,null);
    }

    // 条件查询
    @Test
    public void TestGetBy() {
        LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper<>();

        String name = "实战";

        lqw.like(Strings.isNotEmpty(name),Book::getName,name);

        bookDao.selectList(lqw);
    }

}
