package jmp.main.service.mapper;

import jmp.database.entity.BankCard;
import jmp.dto.BankCardDto;
import org.mapstruct.Mapper;

import org.mapstruct.factory.Mappers;

@Mapper
public interface BankCardMapper {
    BankCardMapper INSTANCE = Mappers.getMapper(BankCardMapper.class);

    BankCardDto bankCardToBankCardDto(BankCard bankCard);

    BankCard bankCardDtoToBankCard(BankCardDto bankCardDto);
}
