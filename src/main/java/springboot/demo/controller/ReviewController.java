package springboot.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import springboot.demo.model.Review;
import springboot.demo.model.User;
import springboot.demo.model.dto.ReviewCreateDto;
import springboot.demo.model.dto.ReviewEditDto;
import springboot.demo.model.dto.WordDto;
import springboot.demo.model.mapper.ReviewMapper;
import springboot.demo.service.ProductService;
import springboot.demo.service.ReviewService;
import springboot.demo.service.UserService;
import springboot.demo.service.impl.SortWords;

@RestController
public class ReviewController {

    @Autowired
    private SortWords sortWords;

    @Autowired
    private UserService userService;

    @Autowired
    private ReviewMapper reviewMapper;

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private ProductService productService;

    @GetMapping("/words/most-popular")
    public List<WordDto> findMostPopularWords(
            @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
            @RequestParam(value = "limit", required = false, defaultValue = "1000") Integer limit) {

        List<WordDto> mostPopularWords = sortWords.findMostPopularWords();
        Pageable pageable = PageRequest.of(page, limit);
        int start = (int) pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), mostPopularWords.size());
        return new PageImpl<>(mostPopularWords.subList(start, end),
                pageable, mostPopularWords.size()).getContent();
    }

    @PostMapping("/review/create")
    public Review createReview(@RequestBody ReviewCreateDto reviewtDto) {
        Review review = reviewMapper.getReviewFromReviewCreateDto(reviewtDto);
        review.setProduct(productService.findById(reviewtDto.getProductId()));
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String email = ((UserDetails) principal).getUsername();
        User loggedUser = userService.findByEmail(email);
        review.setUser(loggedUser);
        return reviewService.save(review);
    }

    @PatchMapping("/review/edit")
    public @ResponseBody
    ResponseEntity<String> editReview(@RequestBody ReviewEditDto reviewDto) {
        Review review = reviewService.findById(reviewDto.getId());
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String email = ((UserDetails) principal).getUsername();
        User loggedUser = userService.findByEmail(email);
        if (review.getUser().equals(loggedUser)) {
            reviewService.setReviewInfoById(reviewDto);
            return new ResponseEntity<>("PATCH Response", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Review does not belong to you", HttpStatus.UNAUTHORIZED);
        }
    }

    @DeleteMapping("/review/delete/{id}")
    public Map<String, Boolean> deleteReview(@PathVariable Long id) {
        reviewService.delete(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
