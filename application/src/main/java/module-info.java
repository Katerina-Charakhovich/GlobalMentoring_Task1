module application {
    requires jmp.cloud.service.impl;
    requires jmp.cloud.service.dublicate.impl;
    requires jmp.cloud.bank.impl;
    requires jmp.dto;
    requires java.sql;
    requires jmp.database;
    requires jmp.main.service;
    uses jmp.service.api.Service;
}