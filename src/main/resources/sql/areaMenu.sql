-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('分区', '1', '1', 'area', 'module/area/index', 1, 0, 'C', '0', '0', 'module:area:list', '#', 'admin', sysdate(), '', null, '分区菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('分区查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'module:area:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('分区新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'module:area:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('分区修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'module:area:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('分区删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'module:area:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('分区导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'module:area:export',       '#', 'admin', sysdate(), '', null, '');