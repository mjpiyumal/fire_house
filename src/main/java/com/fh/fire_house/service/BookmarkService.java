package com.fh.fire_house.service;

import com.fh.fire_house.entity.Bookmark;

import java.util.List;

public interface BookmarkService {

    Bookmark bookmarkInsertion(Bookmark bookmark);

    String deleteBookmarkById(Integer id);

    void deleteAllBookmark();

    List<Bookmark> bookmarkAll();

}
