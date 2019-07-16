USE mybatis;

CREATE TABLE `sys_user`
(
    id            bigint      not null auto_increment comment '用户 ID',
    user_name     varchar(50) not null comment '用户名',
    user_password varchar(50) not null comment '密码',
    user_email    varchar(50) not null comment '邮箱',
    user_info     text comment '简介',
    head_img      blob comment '头像',
    create_time   datetime comment '创建时间',
    primary key (id)
) comment '用户表';

CREATE TABLE `sys_role`
(
    id          bigint      not null auto_increment comment '角色 ID',
    role_name   varchar(50) not null comment '角色名',
    enabled     int comment '有效标志',
    create_by   bigint comment '创建人',
    create_time datetime comment '创建时间',
    primary key (id)
) comment '角色表';

CREATE TABLE `sys_privilege`
(
    id             bigint not null auto_increment comment '权限 ID',
    privilege_name varchar(50) comment '权限名称',
    privilege_url  varchar(200) comment '权限 URL',
    create_time    datetime comment '创建时间',
    primary key (id)
) comment '权限表';

CREATE TABLE `sys_user_role`
(
    user_id bigint comment '用户 ID',
    role_id bigint comment '角色 ID'
) comment '用户角色关系表';

CREATE TABLE `sys_role_privilege`
(
    role_id      bigint comment '角色 ID',
    privilege_id bigint comment '权限 ID'
) comment '角色权限关系表';

INSERT INTO `sys_user`
VALUES (1, 'admin', '123456', 'admin@wj5633.xyz', '管理员', null, now()),
       (1001, 'test', '123456', 'test@wj5633.xyz', '测试用户', null, now());


INSERT INTO `sys_role`
VALUES (1, '管理员', 1, 1, now()),
       (2, '普通用户', 1, 1, now());

INSERT INTO `sys_user_role`
VALUES (1, 1),
       (1, 2),
       (1001, 2);

INSERT INTO `sys_privilege`
VALUES (1, '用户管理', '/users', now()),
       (2, '角色管理', '/roles', now()),
       (3, '系统日志', '/logs', now()),
       (4, '人员维护', '/persons', now()),
       (5, '单位维护', '/companies', now());

INSERT INTO `sys_role_privilege`
VALUES (1, 1),
       (1, 2),
       (1, 3),
       (2, 4),
       (2, 5);















