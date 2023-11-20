-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('供货商', '1', '1', 'supplier', 'module/supplier/index', 1, 0, 'C', '0', '0', 'module:supplier:list', '#', 'admin', sysdate(), '', null, '供货商菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('供货商查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'module:supplier:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('供货商新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'module:supplier:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('供货商修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'module:supplier:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('供货商删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'module:supplier:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('供货商导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'module:supplier:export',       '#', 'admin', sysdate(), '', null, '');