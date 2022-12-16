package jmp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@AllArgsConstructor
@ToString
@Getter
@Setter
@Builder
public class SubscriptionDto {
    String bankCard;
    LocalDate startDate;

    public SubscriptionDto(String bankcard) {
        this.bankCard = bankcard;
        this.startDate = LocalDate.now();
    }
}
