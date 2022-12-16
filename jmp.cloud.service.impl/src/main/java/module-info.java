module jmp.cloud.service.impl {
    requires transitive jmp.service.api;
    requires jmp.dto;
    requires jmp.database;
    requires org.mapstruct;
    requires jmp.main.service;
    exports jmp.cloud.service.impl;
    exports jmp.cloud.service.mapper;
    exports jmp.cloud.service.exception;
    provides jmp.service.api.Service with jmp.cloud.service.impl.ServiceImpl;
    uses jmp.cloud.service.impl.ServiceImpl;
}