package jmp.main.service;

import jmp.main.service.mapper.SubscriptionMapper;
import jmp.dto.SubscriptionDto;
import jmp.database.repository.SubscriptionRepository;

import java.util.List;
import java.util.stream.Collectors;

public class SubscriptionService {
    SubscriptionMapper subscriptionMapper = SubscriptionMapper.INSTANCE;

    private final SubscriptionRepository subscriptionRepository = new  SubscriptionRepository();
    public void save(SubscriptionDto subscription) {

        subscriptionRepository.save(subscriptionMapper.subscriptionDtoToSubscription(subscription));
    }

    public List<SubscriptionDto> getAll(){
        return subscriptionRepository.getAll().stream().map(subscriptionMapper::subscriptionToSubscriptionDto)
                .collect(Collectors.toList());
    }

    public SubscriptionDto getSubscriptionByCardNumber(String bankCardNumber){
        return subscriptionMapper.subscriptionToSubscriptionDto(subscriptionRepository
                .getSubscriptionByCardNumber(bankCardNumber));
    }

}
