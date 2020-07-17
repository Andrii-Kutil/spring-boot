package springboot.demo.model.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;
import springboot.demo.model.dto.WordDto;

@Component
public class WordMapper {
    public List<WordDto> convertMapsToDto(Map<String, Long> sortedMap) {
        List<WordDto> wordDtoList = new ArrayList<>();
        for (Map.Entry<String, Long> entry : sortedMap.entrySet()) {
            wordDtoList.add(convertMapToDto(entry));
        }
        return wordDtoList;
    }

    public WordDto convertMapToDto(Map.Entry<String, Long> entry) {
        WordDto wordDto = new WordDto();
        wordDto.setName(entry.getKey());
        wordDto.setAmount(entry.getValue());
        return wordDto;
    }
}
