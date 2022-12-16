package jmp.cloud.bank.impl;

import jmp.bank.api.Bank;
import jmp.dto.BankCardDto;
import jmp.dto.BankCardType;
import jmp.dto.CreditBankCard;
import jmp.dto.DebitBankCard;
import jmp.dto.UserDto;
import jmp.main.service.BankCardService;

import java.util.Random;

public class BankImpl implements Bank {
    private static final BankCardService bankCardService = new BankCardService();
    @Override
    public BankCardDto createBankCard(UserDto user, BankCardType cardType) {
        switch (cardType) {
            case CREDIT: {
                CreditBankCard creditBankCard = new CreditBankCard( getCardNumber(),user);
                bankCardService.save(creditBankCard,cardType);
                return creditBankCard;
            }
            case DEBIT: {
                DebitBankCard debitBankCard = new DebitBankCard( getCardNumber(),user);
                bankCardService.save(debitBankCard,cardType);
                return debitBankCard;
            }
            default:
                return null;
        }
    }
    private static String getCardNumber(){
        long min = 1000000000000L; //13 digits inclusive
        long max = 10000000000000L; //14 digits exclusive
        Random random = new Random();
        long number = min+((long)(random.nextDouble()*(max-min)));
        return String.valueOf(number);
    }
}
