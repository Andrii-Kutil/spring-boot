package springboot.demo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReviewCreateDto {
    private String productId;
    private int helpfulnessNumerator;
    private int helpfulnessDenominator;
    private int score;
    private String summary;
    private String text;
}
