package jmp.service.api;

import jmp.dto.BankCardDto;
import jmp.dto.SubscriptionDto;
import jmp.dto.UserDto;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.function.Predicate;

public interface Service {
    void subscribe(BankCardDto bankCard);

    Optional<SubscriptionDto> getSubscriptionByBankCardNumber(String cardNumber);

    List<SubscriptionDto> getSubscriptionsByCondition(Predicate<SubscriptionDto> predicate);

    List<UserDto> getAllUsers();

    default OptionalDouble getAverageUsersAge() {
        var users = getAllUsers();
        return users.stream().mapToLong(user -> ChronoUnit.YEARS.between(user.getBirthday(), LocalDate.now()))
                .average();
    }

    static boolean isPayable(UserDto user) {
        return 18 < ChronoUnit.YEARS.between(user.getBirthday(), LocalDate.now());
    }

}
