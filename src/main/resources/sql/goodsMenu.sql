-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('货物', '1', '1', 'goods', 'module/goods/index', 1, 0, 'C', '0', '0', 'module:goods:list', '#', 'admin', sysdate(), '', null, '货物菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('货物查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'module:goods:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('货物新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'module:goods:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('货物修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'module:goods:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('货物删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'module:goods:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('货物导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'module:goods:export',       '#', 'admin', sysdate(), '', null, '');