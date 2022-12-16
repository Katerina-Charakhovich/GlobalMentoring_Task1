module jmp.cloud.bank.impl {
    requires jmp.dto;
    requires jmp.main.service;
    requires transitive jmp.bank.api;
    exports jmp.cloud.bank.impl;
    provides jmp.bank.api.Bank with jmp.cloud.bank.impl.BankImpl;
}