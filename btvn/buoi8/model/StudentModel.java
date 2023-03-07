package nganttt.btvn.buoi8.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentModel {
    private String firstName, lastName, email, gender, mobile, day, month, year, subject, hobbies, fileName, address, state, city;
}
