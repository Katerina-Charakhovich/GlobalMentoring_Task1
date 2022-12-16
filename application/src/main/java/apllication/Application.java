package apllication;

import jmp.bank.api.Bank;
import jmp.cloud.bank.impl.BankImpl;
import jmp.cloud.service.exception.ServiceException;
import jmp.cloud.service.impl.ServiceImpl;
import jmp.dto.BankCardDto;
import jmp.dto.BankCardType;
import jmp.dto.SubscriptionDto;
import jmp.dto.UserDto;
import jmp.main.service.BankCardService;
import jmp.main.service.SubscriptionService;
import jmp.main.service.UserService;
import jmp.service.api.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.ServiceLoader;
import java.util.function.Predicate;

public class Application {
    public static void main(String[] args) {
        UserService userService = new UserService();
        SubscriptionService subscriptionService = new SubscriptionService();
        BankCardService bankCardService = new BankCardService();
        Service service = new ServiceImpl();
//        Service service = ServiceLoader
//                .load(ServiceImpl.class)
//                .findFirst().orElseThrow(RuntimeException::new);

        var user = new UserDto("Yana", "Bahdanovich", LocalDate.parse("1980-05-05"));
        var user1 = new UserDto("James", "Smith", LocalDate.parse("2015-05-05"));
        userService.save(user);
        userService.save(user1);
        List<UserDto> users = service.getAllUsers();
        System.out.println(users);

        Bank bank = new BankImpl();
        var creditCard = bank.createBankCard(user, BankCardType.CREDIT);
        var debitCard = bank.createBankCard(user1, BankCardType.DEBIT);
        List<BankCardDto> cards = Arrays.asList(creditCard, debitCard);
        cards.forEach(service::subscribe);
        System.out.println(bankCardService.getAll());



        //Task 18.
        OptionalDouble averageUsersAge = service.getAverageUsersAge();
        System.out.println("Task 18.Average users age:" + averageUsersAge);

        // Task 19.
        System.out.println("Task 19." + user.getName() + " is payable:" + Service.isPayable(user));
        System.out.println("Task 19." + user1.getName() + " is payable:" + Service.isPayable(user1));

        //Task 21
        try {
            SubscriptionDto subscription = service.getSubscriptionByBankCardNumber("111111111")
                    .orElseThrow(ServiceException::new);
            System.out.println(subscription);
        } catch (ServiceException ex) {
            System.out.println("Task 21.Custom exception" + ex.getStackTrace());
        }
        // Task 22.
        Predicate<SubscriptionDto> cardNumberEqualsPredicate = c -> c.getBankCard().contains("1");
        System.out.println("Task 21.Predicate" + service.getSubscriptionsByCondition(cardNumberEqualsPredicate));
    }
}