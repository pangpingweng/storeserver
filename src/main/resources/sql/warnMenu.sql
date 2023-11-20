-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('时间预警', '4420', '1', 'warn', 'module/warn/time', 1, 0, 'C', '0', '0', 'module:warn:list', '#', 'admin', sysdate(), '', null, '报警菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('报警查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'module:warn:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('报警新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'module:warn:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('报警修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'module:warn:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('报警删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'module:warn:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('报警导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'module:warn:export',       '#', 'admin', sysdate(), '', null, '');