-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('仓库', '1', '1', 'store', 'module/store/index', 1, 0, 'C', '0', '0', 'module:store:list', '#', 'admin', sysdate(), '', null, '仓库菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('仓库查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'module:store:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('仓库新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'module:store:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('仓库修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'module:store:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('仓库删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'module:store:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('仓库导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'module:store:export',       '#', 'admin', sysdate(), '', null, '');