package jmp.bank.api;

import jmp.dto.BankCardDto;
import jmp.dto.BankCardType;
import jmp.dto.UserDto;

public interface Bank {
    BankCardDto createBankCard(UserDto user, BankCardType cardType);
}
