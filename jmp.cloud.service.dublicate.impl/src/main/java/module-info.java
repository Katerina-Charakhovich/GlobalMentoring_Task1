module jmp.cloud.service.dublicate.impl {
    exports jmp.cloud.service.dublicate.impl;
    requires transitive jmp.service.api;
    requires jmp.dto;
    requires jmp.database;
    requires org.mapstruct;
    requires jmp.main.service;
  //  exports jmp.cloud.service.dublicate.impl;
    provides jmp.service.api.Service with jmp.cloud.service.dublicate.impl.ServiceDublicateImpl;
    uses jmp.cloud.service.dublicate.impl.ServiceDublicateImpl;
}