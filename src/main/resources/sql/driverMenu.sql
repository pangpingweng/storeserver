-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('司机', '1', '1', 'driver', 'module/driver/index', 1, 0, 'C', '0', '0', 'module:driver:list', '#', 'admin', sysdate(), '', null, '司机菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('司机查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'module:driver:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('司机新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'module:driver:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('司机修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'module:driver:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('司机删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'module:driver:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('司机导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'module:driver:export',       '#', 'admin', sysdate(), '', null, '');