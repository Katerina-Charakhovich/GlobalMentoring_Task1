module jmp.main.service {
    requires jmp.dto;
    requires org.mapstruct;
    requires jmp.database;
    exports jmp.main.service;
    exports jmp.main.service.mapper;
}