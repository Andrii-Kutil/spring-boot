package springboot.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import springboot.demo.util.UseExistingOrGenerateSequenceIdGenerator;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ExistingOrGenerated")
    @GenericGenerator(name = "ExistingOrGenerated", strategy =
            "springboot.demo.util.UseExistingOrGenerateSequenceIdGenerator",
            parameters = {
                    @Parameter(name =
                            UseExistingOrGenerateSequenceIdGenerator.VALUE_PREFIX_PARAMETER,
                            value = "P_"),
                    @Parameter(name =
                            UseExistingOrGenerateSequenceIdGenerator.NUMBER_FORMAT_PARAMETER,
                            value = "%010d")})
    private String id;
}
