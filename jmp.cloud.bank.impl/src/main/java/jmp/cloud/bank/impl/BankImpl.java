package jmp.cloud.bank.impl;

import jmp.bank.api.Bank;
import jmp.dto.BankCardDto;
import jmp.dto.BankCardType;
import jmp.dto.CreditBankCard;
import jmp.dto.DebitBankCard;
import jmp.dto.UserDto;
import jmp.main.service.BankCardService;

import java.util.Random;
import java.util.function.BiFunction;

import static jmp.dto.BankCardType.CREDIT;

public class BankImpl implements Bank {
    private static final BankCardService bankCardService = new BankCardService();

    @Override
    public BankCardDto createBankCard(UserDto user, BankCardType cardType) {
        BiFunction<String, UserDto, BankCardDto> creditCard = CreditBankCard::new;
        BiFunction<String, UserDto, BankCardDto> debitCard = DebitBankCard::new;

        BankCardDto bankCardDto = cardType.equals(CREDIT)
                ? creditCard.apply(getCardNumber(), user)
                : debitCard.apply(getCardNumber(), user);
        bankCardService.save(bankCardDto, cardType);
        return bankCardDto;
    }
    private static String getCardNumber(){
        long min = 1000000000000L; //13 digits inclusive
        long max = 10000000000000L; //14 digits exclusive
        Random random = new Random();
        long number = min+((long)(random.nextDouble()*(max-min)));
        return String.valueOf(number);
    }
}
