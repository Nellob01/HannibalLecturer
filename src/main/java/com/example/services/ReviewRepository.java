package com.example.services;

import com.example.entities.Lecturer;
import com.example.entities.Review;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

/**
 * Created by noelaniekan on 1/14/17.
 */
public interface ReviewRepository extends CrudRepository<Review, Integer>{
    List<Review> findByLecturer(Lecturer lecturer);
}
