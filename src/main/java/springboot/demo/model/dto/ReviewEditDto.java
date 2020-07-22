package springboot.demo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReviewEditDto {
    private Long id;
    private int helpfulnessNumerator;
    private int helpfulnessDenominator;
    private int score;
    private String summary;
    private String text;
}
