-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('投诉', '1', '1', 'complain', 'module/complain/index', 1, 0, 'C', '0', '0', 'module:complain:list', '#', 'admin', sysdate(), '', null, '投诉菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('投诉查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'module:complain:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('投诉新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'module:complain:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('投诉修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'module:complain:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('投诉删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'module:complain:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('投诉导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'module:complain:export',       '#', 'admin', sysdate(), '', null, '');