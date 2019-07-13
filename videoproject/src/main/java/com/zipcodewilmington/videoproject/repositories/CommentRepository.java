package com.zipcodewilmington.videoproject.repositories;


import com.zipcodewilmington.videoproject.models.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long> {
}
