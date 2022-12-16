module jmp.main.service {
    requires jmp.dto;
    requires jmp.database;
    requires org.mapstruct;
    exports jmp.main.service;
    exports jmp.main.service.mapper;
}