package com.fh.fire_house.repo;

import com.fh.fire_house.entity.Bookmark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookmarkRepo extends JpaRepository<Bookmark, Integer> {
}
