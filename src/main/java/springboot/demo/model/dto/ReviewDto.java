package springboot.demo.model.dto;

import com.opencsv.bean.CsvBindByPosition;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ReviewDto {
    @CsvBindByPosition(position = 1)
    private String productId;
    @CsvBindByPosition(position = 2)
    private String userId;
    @CsvBindByPosition(position = 3)
    private String profileName;
    @CsvBindByPosition(position = 4)
    private String helpfulnessNumerator;
    @CsvBindByPosition(position = 5)
    private String helpfulnessDenominator;
    @CsvBindByPosition(position = 6)
    private String score;
    @CsvBindByPosition(position = 7)
    private String time;
    @CsvBindByPosition(position = 8)
    private String summary;
    @CsvBindByPosition(position = 9)
    private String text;

    public ReviewDto(String productId, String userId, String profileName,
                     String helpfulnessNumerator, String helpfulnessDenominator, String score,
                     String time, String summary, String text) {
        this.productId = productId;
        this.userId = userId;
        this.profileName = profileName;
        this.helpfulnessNumerator = helpfulnessNumerator;
        this.helpfulnessDenominator = helpfulnessDenominator;
        this.score = score;
        this.time = time;
        this.summary = summary;
        this.text = text;
    }
}
