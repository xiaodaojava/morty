DROP TABLE IF EXISTS `oecp_search_main`;
CREATE TABLE `oecp_search_main` (
`id` bigint(32) NOT NULL  COMMENT '主键UUID',
`error_code` varchar(64) COMMENT '错误码',
`error_msg` varchar(1000) COMMENT '错误信息',
`error_desc` varchar(255) COMMENT '错误描述',
`error_tag` bigint(32) COMMENT '错误码标签，对应错误码主键ID',
`create_by` varchar(50) COMMENT '创建人',
`create_date` datetime COMMENT '创建时间',
`update_by` varchar(50) COMMENT '更新人',
`update_date` datetime COMMENT '更新时间',
`remarks` varchar(255) COMMENT '备注信息',
`del_flag` tinyint(1) COMMENT '逻辑删除（0显示；1隐藏）',
PRIMARY KEY (`id`),
INDEX `error_code`(`error_code`) USING BTREE

) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '错误码平台搜索主表' ROW_FORMAT = Dynamic;

DROP TABLE IF EXISTS `oecp_search_sub`;
CREATE TABLE `oecp_search_sub` (
`id` bigint(32) NOT NULL  COMMENT '主键UUID',
`title` varchar(300) COMMENT '案例标题',
`title_for_search` varchar(500) COMMENT '案例分词',
`content_for_search` varchar(2000) COMMENT '内容摘要',
`search_main_id` bigint(32) COMMENT '搜索主表ID，外键',
`case_tag` bigint(32) COMMENT '案例标签，对应案例ID，外键',
`create_by` varchar(50) COMMENT '创建人',
`create_date` datetime COMMENT '创建时间',
`update_by` varchar(50) COMMENT '更新人',
`update_date` datetime COMMENT '更新时间',
`remarks` varchar(255) COMMENT '备注信息',
`del_flag` tinyint(1) COMMENT '逻辑删除（0显示；1隐藏）',
PRIMARY KEY (`id`)

) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '错误码平台搜索子表' ROW_FORMAT = Dynamic;