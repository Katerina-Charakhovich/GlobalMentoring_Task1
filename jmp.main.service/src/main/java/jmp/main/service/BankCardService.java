package jmp.main.service;

import jmp.database.entity.BankCard;
import jmp.database.repository.BankCardRepository;
import jmp.dto.BankCardDto;
import jmp.dto.BankCardType;
import jmp.main.service.mapper.BankCardMapper;

import java.util.List;
import java.util.stream.Collectors;

public class BankCardService {
    private final BankCardRepository bankCardRepository = new BankCardRepository();

    private static final BankCardMapper bankCardMapper = BankCardMapper.INSTANCE;

    public void save(BankCardDto bankCardDto, BankCardType bankCardType) {
        BankCard bankCard = bankCardMapper.bankCardDtoToBankCard(bankCardDto);
        bankCard.setCardType(bankCardType.toString());
        bankCardRepository.save(bankCard);
    }

    public List<BankCardDto> getAll() {
       return bankCardRepository.getAll().stream().map(bankCardMapper::bankCardToBankCardDto)
               .collect(Collectors.toList());
    }
}
