package springboot.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springboot.demo.model.dto.WordDto;
import springboot.demo.service.impl.SortWords;

@RestController
public class ReviewController {

    @Autowired
    private SortWords sortWords;

    @GetMapping("/words/most-popular")
    private List<WordDto> findMostPopularWords(
            @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
            @RequestParam(value = "limit", required = false, defaultValue = "1000") Integer limit) {

        List<WordDto> mostPopularWords = sortWords.findMostPopularWords();
        Pageable pageable = PageRequest.of(page, limit);
        int start = (int) pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), mostPopularWords.size());
        return new PageImpl<>(mostPopularWords.subList(start, end),
                pageable, mostPopularWords.size()).getContent();
    }
}
