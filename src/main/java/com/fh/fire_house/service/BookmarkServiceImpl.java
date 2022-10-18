package com.fh.fire_house.service;

import com.fh.fire_house.entity.Bookmark;
import com.fh.fire_house.repo.BookmarkRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;


@Service
public class BookmarkServiceImpl implements BookmarkService{

    @Autowired
    private BookmarkRepo bookmarkRepo;

    @Override
    public Bookmark bookmarkInsertion(Bookmark bookmark) {
        return bookmarkRepo.save(bookmark);
    }

    @Override
    public String deleteBookmarkById(Integer id) {
        Assert.notNull(id, "Id can not be empty");
        bookmarkRepo.deleteById(id);
        return "Successfully Deleted";
    }

    @Override
    public void deleteAllBookmark() {
        bookmarkRepo.deleteAll();
    }

    @Override
    public List<Bookmark> bookmarkAll() {
        return bookmarkRepo.findAll();
    }

}
