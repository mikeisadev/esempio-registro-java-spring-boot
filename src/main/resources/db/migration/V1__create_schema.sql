
    create table categories (
        id bigint not null auto_increment,
        name varchar(255) not null,
        primary key (id)
    ) engine=InnoDB;

    create table posts (
        created_at datetime(6) not null,
        id bigint not null auto_increment,
        updated_at datetime(6) not null,
        user_id bigint not null,
        content TEXT,
        title varchar(255) not null,
        primary key (id)
    ) engine=InnoDB;

    create table user_roles (
        user_id bigint not null,
        role varchar(255)
    ) engine=InnoDB;

    create table users (
        enabled bit not null,
        id bigint not null auto_increment,
        email varchar(255) not null,
        first_name varchar(255),
        last_name varchar(255),
        password varchar(255) not null,
        primary key (id)
    ) engine=InnoDB;

    alter table categories 
       add constraint UKt8o6pivur7nn124jehx7cygw5 unique (name);

    alter table users 
       add constraint UK6dotkott2kjsp8vw4d0m25fb7 unique (email);

    alter table posts 
       add constraint FK5lidm6cqbc7u4xhqpxm898qme 
       foreign key (user_id) 
       references users (id);

    alter table user_roles 
       add constraint FKhfh9dx7w3ubf1co1vdev94g3f 
       foreign key (user_id) 
       references users (id);

    create table categories (
        id bigint not null auto_increment,
        name varchar(255) not null,
        primary key (id)
    ) engine=InnoDB;

    create table posts (
        created_at datetime(6) not null,
        id bigint not null auto_increment,
        updated_at datetime(6) not null,
        user_id bigint not null,
        content TEXT,
        title varchar(255) not null,
        primary key (id)
    ) engine=InnoDB;

    create table user_roles (
        user_id bigint not null,
        role varchar(255)
    ) engine=InnoDB;

    create table users (
        enabled bit not null,
        id bigint not null auto_increment,
        email varchar(255) not null,
        first_name varchar(255),
        last_name varchar(255),
        password varchar(255) not null,
        primary key (id)
    ) engine=InnoDB;

    alter table categories 
       add constraint UKt8o6pivur7nn124jehx7cygw5 unique (name);

    alter table users 
       add constraint UK6dotkott2kjsp8vw4d0m25fb7 unique (email);

    alter table posts 
       add constraint FK5lidm6cqbc7u4xhqpxm898qme 
       foreign key (user_id) 
       references users (id);

    alter table user_roles 
       add constraint FKhfh9dx7w3ubf1co1vdev94g3f 
       foreign key (user_id) 
       references users (id);

    create table categories (
        id bigint not null auto_increment,
        name varchar(255) not null,
        primary key (id)
    ) engine=InnoDB;

    create table posts (
        created_at datetime(6) not null,
        id bigint not null auto_increment,
        updated_at datetime(6) not null,
        user_id bigint not null,
        content TEXT,
        title varchar(255) not null,
        primary key (id)
    ) engine=InnoDB;

    create table user_roles (
        user_id bigint not null,
        role varchar(255)
    ) engine=InnoDB;

    create table users (
        enabled bit not null,
        id bigint not null auto_increment,
        email varchar(255) not null,
        first_name varchar(255),
        last_name varchar(255),
        password varchar(255) not null,
        primary key (id)
    ) engine=InnoDB;

    alter table categories 
       add constraint UKt8o6pivur7nn124jehx7cygw5 unique (name);

    alter table users 
       add constraint UK6dotkott2kjsp8vw4d0m25fb7 unique (email);

    alter table posts 
       add constraint FK5lidm6cqbc7u4xhqpxm898qme 
       foreign key (user_id) 
       references users (id);

    alter table user_roles 
       add constraint FKhfh9dx7w3ubf1co1vdev94g3f 
       foreign key (user_id) 
       references users (id);
