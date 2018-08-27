create table roles_normalized
(
  id   int auto_increment
    primary key,
  role varchar(20) not null,
  constraint Roles_role_uindex
  unique (role)
);

create table users
(
  username varchar(50) not null
    primary key,
  password varchar(50) not null,
  enabled  tinyint(1)  not null
)
  charset = latin1;

create table authorities
(
  username  varchar(50) not null,
  authority varchar(50) not null,
  constraint authorities_idx_1
  unique (username, authority),
  constraint authorities_ibfk_1
  foreign key (username) references users (username)
)
  charset = latin1;

create table users_normalized
(
  id        int auto_increment
    primary key,
  user_name varchar(20) not null,
  password  varchar(20) not null,
  constraint Users_user_name_uindex
  unique (user_name)
);

create table user_roles
(
  user_id int null,
  role_id int null,
  constraint user_roles_roles_id_fk
  foreign key (role_id) references roles_normalized (id)
    on update cascade
    on delete cascade,
  constraint user_roles_users_id_fk
  foreign key (user_id) references users_normalized (id)
    on update cascade
    on delete cascade
);

