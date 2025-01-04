package org.prateek.BehaviouralPatterns.IteratorPattern;


import com.sun.source.tree.Tree;

import java.util.*;

public class BookCollectionV3 implements Iterable<Book>{
    private Set<Book> books = new TreeSet<>();

    public void addBook(Book book){
        books.add(book);
    }

    @Override
    public Iterator<Book> iterator() {
        return books.iterator();
    }
}