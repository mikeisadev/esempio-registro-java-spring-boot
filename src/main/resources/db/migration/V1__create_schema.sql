
    create table posts (
        created_at datetime(6) not null,
        id bigint not null auto_increment,
        updated_at datetime(6) not null,
        content TEXT,
        title varchar(255) not null,
        primary key (id)
    ) engine=InnoDB;

    create table users (
        id bigint not null auto_increment,
        first_name varchar(255) not null,
        last_name varchar(255) not null,
        primary key (id)
    ) engine=InnoDB;
