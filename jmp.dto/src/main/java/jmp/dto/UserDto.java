package jmp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@AllArgsConstructor
@ToString
@Getter
@Setter
public class UserDto {
    private String name;
    private String surname;
    private LocalDate birthday;
}
