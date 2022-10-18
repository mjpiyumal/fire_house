package com.fh.fire_house.controller;

import com.fh.fire_house.entity.Bookmark;
import com.fh.fire_house.service.BookmarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class BookmarkController {

    @Autowired
    private BookmarkService bookmarkService;


    @GetMapping(value = "/bookmark")
    public List<Bookmark> getData() {

        String url = "http://demo.dreamsquadgroup.com/test/index.json";
        RestTemplate restTemplate = new RestTemplate();
        Bookmark[] bookmarks = restTemplate.getForObject(url, Bookmark[].class);

        assert bookmarks != null;
        Arrays.stream(bookmarks).forEach(bookmark -> {
            bookmark.setId(bookmark.getId());
            bookmark.setName(bookmark.getName());
            bookmark.setUrl(bookmark.getUrl());
            bookmark.setDescription(bookmark.getDescription());
            bookmark.setStatus(bookmark.getStatus());
            bookmark.setExpiry_date(bookmark.getExpiry_date());

            System.out.println(bookmark.getName());

            bookmarkService.bookmarkInsertion(bookmark);
        });
        return Arrays.asList(bookmarks).stream().peek(System.out::println).collect(Collectors.toList());
    }


    @RequestMapping(value = "bookmark/{id}", method = RequestMethod.DELETE)
    public String deleteBookmarkById(@PathVariable("id") int id) {
        bookmarkService.deleteBookmarkById(id);
        return "Successfully Deleted";
    }

    @RequestMapping(value = "bookmark/update", method = RequestMethod.POST)
    public Bookmark updateBookmark(@RequestBody Bookmark bookmark) {
        return bookmarkService.bookmarkInsertion(bookmark);
    }

    @RequestMapping(value = "bookmark/deleteAll", method = RequestMethod.DELETE)
    public void deleteAllBookmark() {
        bookmarkService.deleteAllBookmark();
    }

    @RequestMapping(value = "bookmark/getAll", method = RequestMethod.GET)
    public List<Bookmark> getAll() {
        return bookmarkService.bookmarkAll();
    }

}
