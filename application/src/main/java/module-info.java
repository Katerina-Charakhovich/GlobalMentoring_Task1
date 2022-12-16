module application {
    requires jmp.cloud.service.impl;
    requires jmp.cloud.bank.impl;
    requires jmp.dto;
    requires java.sql;
    requires jmp.database;
    requires jmp.main.service;
    uses jmp.cloud.service.impl.ServiceImpl;
}