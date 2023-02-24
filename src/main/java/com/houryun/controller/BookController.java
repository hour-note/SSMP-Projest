package com.houryun.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.houryun.controller.utils.Result;
import com.houryun.domain.Book;
import com.houryun.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private IBookService bookService;

    // 获取全部
    @GetMapping
    public Result getAll() {
        List<Book> bookList = bookService.list();
        return new Result(bookList != null,bookList);
    }

    // 根据id进行查询
    @GetMapping("{id}")
    public Result getById(@PathVariable Integer id) throws IOException {
//        if (true) throw new IOException();

        Book book = bookService.getById(id);
        return new Result(book != null,book);
    }

    // 添加
    @PostMapping
    public Result save(@RequestBody Book book) {
        return new Result(bookService.save(book));
    }

    // 根据id进行修改
    @PutMapping
    public Result updateById(@RequestBody Book book) {
        return new Result(bookService.updateById(book));
    }

    // 根据id进行删除
    @DeleteMapping("{id}")
    public Result deleteById(@PathVariable Integer id) {
        return new Result(bookService.removeById(id));
    }

    // 分页查询
    @GetMapping("{current}/{pageSize}")
    public Result getPage(@PathVariable Integer current, @PathVariable Integer pageSize, Book book) {
        IPage<Book> page = bookService.getPage(current, pageSize, book);

        // 如果当前页码值大于最大页码值，那直接返回第一页（1索引）
        if (current > page.getPages()) {
            page = bookService.getPage(1,pageSize, book);
        }

        return new Result(page != null, page);
    }
}
