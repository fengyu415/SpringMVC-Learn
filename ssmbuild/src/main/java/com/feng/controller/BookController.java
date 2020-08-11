package com.feng.controller;

import com.feng.pojo.Books;
import com.feng.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    @Qualifier("BookServiceImpl")
    private BookService bookService;

    @RequestMapping("/allbook")
    public String list(Model model) {
        List<Books> list = bookService.queryAllBook();
        model.addAttribute("list", list);
        return "allbook";
    }

    @RequestMapping("/toaddbook")
    public String add() {

        return "addbook";
    }

    @RequestMapping("/addbook")
    public String add(Books book) {
        int i = bookService.addBook(book);
        return "redirect:/book/allbook";
    }

    @RequestMapping("/toupdatebook")
    public String update(int id,Model model) {
        Books books = bookService.queryBookById(id);
        model.addAttribute("book",books);
        return "updatebook";
    }

    @RequestMapping("/updatebook")
    public String update(Books book,Model model) {
        int i = bookService.updateBook(book);
        return "redirect:/book/allbook";
    }


    @RequestMapping("/del/{bookId}")
    public String deleteBook(@PathVariable("bookId") int id) {
        bookService.deleteBookById(id);
        return "redirect:/book/allbook";
    }

    @RequestMapping("/index")
    public String index(Model model)
    {
        model.addAttribute("list", "2222");
        return "/index.jsp";
    }
}