package springboot.demo.controller;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springboot.demo.service.impl.SortWords;

@RestController
public class ReviewController {

    @Autowired
    private SortWords sortWords;

    @GetMapping("/words/most-popular")
    private Map<String, Long> findMostPopularWords() {
        return sortWords.findMostPopularWords();
    }
}
