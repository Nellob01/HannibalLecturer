package com.example.controllers;

import com.example.entities.Lecturer;
import com.example.entities.Review;
import com.example.services.LecturerRepository;
import com.example.services.ReviewRepository;
import org.h2.tools.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.*;
import java.util.Iterator;

/**
 * Created by noelaniekan on 1/14/17.
 */
@RestController
public class HannibalLecturerController {
    @Autowired
    LecturerRepository lecturers;

    @Autowired
    ReviewRepository reviews;

    Server uidb = null;


    @PostConstruct
    public void init() throws SQLException {
        uidb = Server.createWebServer().start();
    }

    @PreDestroy
    public void destroy(){
        uidb.stop();
    }

    @RequestMapping(path = "/lectures", method = RequestMethod.GET)
    public Iterable<Lecturer> getLecturers () {
        return lecturers.findAll();
    }
    @RequestMapping(path = "/lectures", method = RequestMethod.POST)
    public void createLecturer (String name, String topic, String image, HttpServletResponse response) {
        System.out.println(name);
        System.out.println(topic);
        System.out.println(image);
        System.out.println(response);
        Lecturer lecturer = new Lecturer(name, topic, image);
        System.out.println(lecturer);
        lecturers.save(lecturer);
    }
    @RequestMapping(path = "/reviews", method = RequestMethod.GET)
    public Iterable<Review> getReviews (int lecturerId) {
        Lecturer lecturer = lecturers.findOne(lecturerId);
        return reviews.findByLecturer(lecturer);
    }
    @RequestMapping(path = "/reviews", method = RequestMethod.POST)
    public void createReview (String author, String text, boolean isGood,int lectureId, HttpServletResponse response) {
        System.out.println(author);
        System.out.println(text);
        System.out.println(isGood);
        System.out.println(lectureId);
        System.out.println(response);
        Lecturer lecturer = lecturers.findOne(lectureId);
        System.out.println(lecturer);
        Review review = new Review(author, text, isGood, lecturer);
        System.out.println(review);
        reviews.save(review);





    }

}
