package jmp.cloud.service.dublicate.impl;

import jmp.dto.BankCardDto;
import jmp.dto.SubscriptionDto;
import jmp.dto.UserDto;
import jmp.main.service.SubscriptionService;
import jmp.main.service.UserService;
import jmp.service.api.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ServiceDublicateImpl implements Service{
    private static final UserService userService = new UserService();

    private static final SubscriptionService subscriptionService = new SubscriptionService();

    @Override
    public void subscribe(BankCardDto bankCard) {
        var subscription = new SubscriptionDto(bankCard.getNumber(), LocalDate.now());
        subscriptionService.save(subscription);
    }

    @Override
    public Optional<SubscriptionDto> getSubscriptionByBankCardNumber(String cardNumber) {
        return Optional.ofNullable(subscriptionService
                .getSubscriptionByCardNumber(cardNumber));
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userService.getAll().stream()
                .collect(Collectors.toUnmodifiableList());
    }


    public List<SubscriptionDto> getSubscriptionsByCondition(Predicate<SubscriptionDto> predicate) {
        return subscriptionService.getAll().stream()
                .filter(predicate).collect(Collectors.toUnmodifiableList());
    }
}
