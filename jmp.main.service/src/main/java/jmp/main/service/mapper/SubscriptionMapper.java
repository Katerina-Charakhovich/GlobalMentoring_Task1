package jmp.main.service.mapper;

import jmp.database.entity.Subscription;
import jmp.dto.SubscriptionDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SubscriptionMapper {

    SubscriptionMapper INSTANCE = Mappers.getMapper(SubscriptionMapper.class);

    SubscriptionDto subscriptionToSubscriptionDto(Subscription subscription);

    Subscription subscriptionDtoToSubscription(SubscriptionDto subscriptionDto);
}
