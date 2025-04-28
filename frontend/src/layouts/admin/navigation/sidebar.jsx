import React from "react";
import {
  UserOutlined,
  LockOutlined,
  PieChartOutlined,
} from "@ant-design/icons";
import { Layout, Menu } from "antd";

const { Sider } = Layout;

const items = [
  { key: "dashboard", icon: <PieChartOutlined />, label: "Dashboard" },
  {
    key: "authenticate",
    label: "Authenticate",
    icon: <LockOutlined />,
    children: [
      { key: "manageAccounts", label: "Manage Accounts" },
      { key: "create", label: "**" },
    ],
  },
  {
    key: "student",
    label: "Học Sinh",
    icon: <UserOutlined />,
    children: [
      { key: "listAlls", label: "Danh sách học sinh" },
      { key: "create", label: "**" },
    ],
  },
];

const AppSider = ({ onMenuItemClick, selectedKeys }) => {
  return (
    <Sider
      breakpoint="lg"
      collapsedWidth="0"
      onBreakpoint={(broken) => {
        console.log(broken);
      }}
      onCollapse={(collapsed, type) => {
        console.log(collapsed, type);
      }}
    >
      <div className="demo-logo-vertical" />
      <Menu
        theme="dark"
        mode="inline"
        defaultSelectedKeys={["dashboard"]}
        selectedKeys={selectedKeys}
        items={items}
        onClick={onMenuItemClick}
      />
    </Sider>
  );
};

export default AppSider;
