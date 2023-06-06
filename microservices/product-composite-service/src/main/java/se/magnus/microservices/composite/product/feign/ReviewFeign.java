package se.magnus.microservices.composite.product.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import se.magnus.api.core.review.Review;

import java.util.List;

@FeignClient(value = "reviews",url = "${app.review-service.host}"+":8080")
public interface ReviewFeign {

    @RequestMapping(method = RequestMethod.GET, value = "/review", produces = "application/json")
    List<Review> getReviews(@RequestParam(value = "productId", required = true) int productId);
}
