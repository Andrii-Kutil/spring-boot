package springboot.demo.model;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import springboot.demo.util.UseExistingOrGenerateSequenceIdGenerator;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ExistingOrGenerated")
    @GenericGenerator(name = "ExistingOrGenerated", strategy =
            "springboot.demo.util.UseExistingOrGenerateSequenceIdGenerator",
            parameters = {
                    @Parameter(name =
                            UseExistingOrGenerateSequenceIdGenerator.VALUE_PREFIX_PARAMETER,
                            value = "U_"),
                    @Parameter(name =
                            UseExistingOrGenerateSequenceIdGenerator.NUMBER_FORMAT_PARAMETER,
                            value = "%010d")})
    private String userId;
    private String profileName;
    private String password;
    private String email;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles;
}

