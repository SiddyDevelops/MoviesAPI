package com.siddydevelops.MoviesAPI.controllers;

import com.siddydevelops.MoviesAPI.entities.Review;
import com.siddydevelops.MoviesAPI.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @CrossOrigin
    @PostMapping
    public ResponseEntity<Review> createReview(@RequestBody Map<String,String> payload) {
        return new ResponseEntity<>(
                reviewService
                        .createReview(
                                payload.get("reviewBody"),
                                payload.get("imdbId")
                        ),
                HttpStatus.CREATED
        );
    }
}
