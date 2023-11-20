-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('车辆', '1', '1', 'car', 'module/car/index', 1, 0, 'C', '0', '0', 'module:car:list', '#', 'admin', sysdate(), '', null, '车辆菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('车辆查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'module:car:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('车辆新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'module:car:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('车辆修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'module:car:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('车辆删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'module:car:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('车辆导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'module:car:export',       '#', 'admin', sysdate(), '', null, '');