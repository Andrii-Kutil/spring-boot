package springboot.demo.service.impl;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.demo.model.dto.WordDto;
import springboot.demo.model.mapper.WordMapper;
import springboot.demo.service.ReviewService;

@Service
public class SortWords {

    @Autowired
    private WordMapper wordMapper;

    @Autowired
    private ReviewService reviewService;

    public List<WordDto> findMostPopularWords() {
        List<String> allTextFromReviews = reviewService.findAllText();
        Map<String, Long> map = fillMap(allTextFromReviews);
        Map<String, Long> sortedMap = sortByValues(map);
        return wordMapper.convertMapsToDto(sortedMap);
    }

    public Map<String, Long> fillMap(List<String> allTextFromReviews) {
        TreeMap<String, Long> map = new TreeMap<>();
        for (String text : allTextFromReviews) {
            String[] words = text.split(" ");
            for (String word : words) {
                word = word.toLowerCase();
                if (map.containsKey(word)) {
                    map.put(word, map.get(word) + 1);
                } else {
                    map.put(word, 1L);
                }
            }
        }
        return map;
    }

    public <K, V extends Comparable<V>> Map<K, V> sortByValues(final Map<K, V> map) {
        Comparator<K> valueComparator = (k1, k2) -> {
            int compare = map.get(k2).compareTo(map.get(k1));
            if (compare == 0) {
                return 1;
            } else {
                return compare;
            }
        };

        Map<K, V> sortedByValues =
                new TreeMap<>(valueComparator);
        sortedByValues.putAll(map);
        return sortedByValues;
    }
}
