package com.aarves.bluepages.usecase.interactors;

import com.aarves.bluepages.entities.Review;
import com.aarves.bluepages.entities.User;

import java.util.List;

public interface ReviewRepository {
    int addReview(Review review);
    void deleteReview(Review review);

    Review getReview(int reviewId);
    List<Review> getReviewsByUser(User user);
    List<Review> getReviewsByLocation(int locationId);
}
