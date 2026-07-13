package com.library;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Exercises 1, 2, 3, 5, 6, 7, 8: Loads the Spring application context and
 * exercises the BookService bean to prove that dependency injection (and,
 * when the AOP context is used, the LoggingAspect) is working correctly.
 *
 * Which behaviour you see depends on which config file is loaded - pass
 * the file name as a program argument, or run with no arguments to use
 * the default applicationContext.xml (setter injection, no AOP).
 *
 * Examples:
 *   java -cp target/classes com.library.LibraryManagementApplication
 *   java -cp target/classes com.library.LibraryManagementApplication applicationContext-constructor.xml
 *   java -cp target/classes com.library.LibraryManagementApplication applicationContext-annotations.xml
 *   java -cp target/classes com.library.LibraryManagementApplication applicationContext-aop.xml
 */
public class LibraryManagementApplication {

    public static void main(String[] args) {
        String configFile = args.length > 0 ? args[0] : "applicationContext.xml";

        System.out.println("Loading Spring context from: " + configFile);

        try (ApplicationContext context = new ClassPathXmlApplicationContext(configFile)) {
            BookService bookService = context.getBean(BookService.class);

            // Exercise 2 & 7: proves BookRepository was injected into BookService.
            List<String> books = bookService.getAllBooks();
            System.out.println("Books currently in the library: " + books);

            // Exercise 3 & 8: triggers LoggingAspect advice (visible only
            // when using applicationContext-aop.xml, since that is the
            // only config that registers the aspect).
            bookService.addBook("Spring Microservices in Action");
            System.out.println("Books after adding a new title: " + bookService.getAllBooks());
        }
    }
}
