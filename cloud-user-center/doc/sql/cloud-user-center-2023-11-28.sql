CREATE TABLE `sys_dept` (
                            `id` varchar(64) NOT NULL  COMMENT '部门id',
                            `parent_id` varchar(64) DEFAULT '0' COMMENT '父部门id',
                            `code` varchar(50)  DEFAULT NULL COMMENT '部门编码',
                            `dept_name` varchar(500)  DEFAULT NULL COMMENT '部门名称',
                            `leader` varchar(20)  DEFAULT NULL COMMENT '负责人',
                            `phone` varchar(11)  DEFAULT NULL COMMENT '联系电话',
                            `email` varchar(50)  DEFAULT NULL COMMENT '邮箱',
                            `status` char(1)  DEFAULT '0' COMMENT '部门状态（0正常 1停用）',
                            `del_flag` char(1)  DEFAULT '0' COMMENT '删除标志（0代表存在 1代表删除）',
                            `create_by` varchar(64) DEFAULT NULL COMMENT '创建者',
                            `create_by_name` datetime DEFAULT NULL COMMENT '创建者名称',
                            `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                            `update_by` varchar(64)  DEFAULT NULL COMMENT '更新者',
                            `update_by_name` datetime DEFAULT NULL COMMENT '更新者名称',
                            `update_time` datetime DEFAULT NULL COMMENT '更新时间',
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4  COMMENT='部门表';



CREATE TABLE `sys_menu` (
                            `id` varchar(64) NOT NULL  COMMENT '菜单ID',
                            `menu_name` varchar(100)  NOT NULL COMMENT '菜单名称',
                            `parent_id` varchar(64) DEFAULT '0' COMMENT '父菜单ID',
                            `order_num` int DEFAULT '0' COMMENT '显示顺序',
                            `path` varchar(200)  DEFAULT NULL COMMENT '路由地址',
                            `query` varchar(255)  DEFAULT NULL COMMENT '路由参数',
                            `component` varchar(255)  DEFAULT NULL COMMENT '组件路径',
                            `frame` int DEFAULT '1' COMMENT '是否为外链（0是 1否）',
                            `cache` int DEFAULT '0' COMMENT '是否缓存（0缓存 1不缓存）',
                            `menu_type` char(1)  DEFAULT 'C' COMMENT '菜单类型（M目录 C菜单 F按钮）',
                            `visible` char(1) DEFAULT '0' COMMENT '菜单状态（0显示 1隐藏）',
                            `status` char(1)  DEFAULT '0' COMMENT '菜单状态（0正常 1停用）',
                            `perms` varchar(100)  DEFAULT NULL COMMENT '权限标识',
                            `icon` varchar(100)  DEFAULT '#' COMMENT '菜单图标',
                            `del_flag` char(1)  DEFAULT '0' COMMENT '删除标志（0代表存在 1代表删除）',
                            `create_by` varchar(64) DEFAULT NULL COMMENT '创建者',
                            `create_by_name` datetime DEFAULT NULL COMMENT '创建者名称',
                            `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                            `update_by` varchar(64)  DEFAULT NULL COMMENT '更新者',
                            `update_by_name` datetime DEFAULT NULL COMMENT '更新者名称',
                            `update_time` datetime DEFAULT NULL COMMENT '更新时间',
                            `remark` varchar(500)  DEFAULT NULL COMMENT '备注',
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4  COMMENT='菜单权限表';




CREATE TABLE `sys_role` (
                            `id` varchar(64)  NOT NULL  COMMENT '角色ID',
                            `role_name` varchar(100)  NOT NULL COMMENT '角色名称',
                            `role_key` varchar(100)  NOT NULL COMMENT '角色权限字符串',
                            `role_sort` int NOT NULL COMMENT '显示顺序',
                            `data_scope` char(1)  DEFAULT '1' COMMENT '数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）',
                            `del_flag` char(1)  DEFAULT '0' COMMENT '删除标志（0代表存在 1代表删除）',
                            `create_by` varchar(64) DEFAULT NULL COMMENT '创建者',
                            `create_by_name` datetime DEFAULT NULL COMMENT '创建者名称',
                            `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                            `update_by` varchar(64)  DEFAULT NULL COMMENT '更新者',
                            `update_by_name` datetime DEFAULT NULL COMMENT '更新者名称',
                            `update_time` datetime DEFAULT NULL COMMENT '更新时间',
                            `remark` varchar(500)  DEFAULT NULL COMMENT '备注',
                            PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4  COMMENT='角色信息表';



CREATE TABLE `sys_role_dept` (
                                 `id` varchar(64) NOT NULL COMMENT 'id',
                                 `role_id` bigint NOT NULL COMMENT '角色ID',
                                 `dept_id` bigint NOT NULL COMMENT '部门ID',
                                 `create_by` varchar(64) DEFAULT NULL COMMENT '创建者',
                                 `create_by_name` datetime DEFAULT NULL COMMENT '创建者名称',
                                 `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                                 `update_by` varchar(64)  DEFAULT NULL COMMENT '更新者',
                                 `update_by_name` datetime DEFAULT NULL COMMENT '更新者名称',
                                 `update_time` datetime DEFAULT NULL COMMENT '更新时间',
                                 PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4  COMMENT='角色和部门关联表';



CREATE TABLE `sys_role_menu` (
                                 `id` varchar(64) NOT NULL  COMMENT 'id',
                                 `role_id` varchar(64) NOT NULL COMMENT '角色ID',
                                 `menu_id` varchar(64) NOT NULL COMMENT '菜单ID',
                                 `create_by` varchar(64) DEFAULT NULL COMMENT '创建者',
                                 `create_by_name` datetime DEFAULT NULL COMMENT '创建者名称',
                                 `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                                 `update_by` varchar(64)  DEFAULT NULL COMMENT '更新者',
                                 `update_by_name` datetime DEFAULT NULL COMMENT '更新者名称',
                                 `update_time` datetime DEFAULT NULL COMMENT '更新时间',
                                 PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4  COMMENT='角色和菜单关联表';



CREATE TABLE `sys_user` (
                            `id` varchar(64) NOT NULL  COMMENT '用户ID',
                            `dept_id` varchar(64) DEFAULT NULL COMMENT '部门ID',
                            `user_name` varchar(100)  NOT NULL COMMENT '用户账号',
                            `nick_name` varchar(100)  NOT NULL COMMENT '用户昵称',
                            `user_type` varchar(2)  DEFAULT '0' COMMENT '用户类型（0:系统用户）',
                            `email` varchar(100)  DEFAULT NULL COMMENT '用户邮箱',
                            `phone_number` varchar(80)  DEFAULT NULL COMMENT '手机号码',
                            `sex` char(1)  DEFAULT '0' COMMENT '用户性别（0男 1女 2未知）',
                            `avatar` varchar(256)  DEFAULT NULL COMMENT '头像地址',
                            `password` varchar(100)  DEFAULT NULL COMMENT '密码',
                            `status` char(1)  DEFAULT '0' COMMENT '帐号状态（0正常 1停用）',
                            `login_ip` varchar(50)  DEFAULT NULL COMMENT '最后登录IP',
                            `login_date` datetime DEFAULT NULL COMMENT '最后登录时间',
                            `salt` varchar(50)  DEFAULT NULL COMMENT '盐值',
                            `remark` varchar(500)  DEFAULT NULL COMMENT '备注',
                            `del_flag` char(1)  DEFAULT '0' COMMENT '删除标志（0代表存在 1代表删除）',
                            `create_by` varchar(64) DEFAULT NULL COMMENT '创建者',
                            `create_by_name` datetime DEFAULT NULL COMMENT '创建者名称',
                            `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                            `update_by` varchar(64)  DEFAULT NULL COMMENT '更新者',
                            `update_by_name` datetime DEFAULT NULL COMMENT '更新者名称',
                            `update_time` datetime DEFAULT NULL COMMENT '更新时间',
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4  COMMENT='用户信息表';



CREATE TABLE `sys_user_role` (
                                 `id` bigint NOT NULL AUTO_INCREMENT COMMENT '部门id',
                                 `user_id` bigint NOT NULL COMMENT '用户ID',
                                 `role_id` bigint NOT NULL COMMENT '角色ID',
                                 `del_flag` char(1)  DEFAULT '0' COMMENT '删除标志（0代表存在 1代表删除）',
                                 `create_by` varchar(64) DEFAULT NULL COMMENT '创建者',
                                 `create_by_name` datetime DEFAULT NULL COMMENT '创建者名称',
                                 `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                                 `update_by` varchar(64)  DEFAULT NULL COMMENT '更新者',
                                 `update_by_name` datetime DEFAULT NULL COMMENT '更新者名称',
                                 `update_time` datetime DEFAULT NULL COMMENT '更新时间',
                                 PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4  COMMENT='用户和角色关联表';