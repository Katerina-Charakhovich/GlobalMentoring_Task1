module jmp.database {
    requires java.sql;
    requires h2;
    requires org.hibernate.orm.core;
    requires java.persistence;
    requires static lombok;
    requires java.naming;
    exports jmp.database.entity;
    exports jmp.database.util;
    exports jmp.database.repository;
    opens jmp.database.entity;
}
