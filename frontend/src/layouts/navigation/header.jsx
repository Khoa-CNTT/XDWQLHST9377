import React, { useState } from "react";
import { Layout, Button, Avatar, Dropdown, message } from "antd";
import {
  MenuUnfoldOutlined,
  MenuFoldOutlined,
  MoonOutlined,
  SunOutlined,
  UserOutlined,
  LogoutOutlined,
} from "@ant-design/icons";
import logo from "../../assets/imgs/logo45.png";
import { useNavigate } from "react-router-dom";
import { logout } from "../../services/auth.service";
import { setLocalData } from "../../services/localStorage";
import { isLoggedInText } from "../../utils/constants";

const { Header } = Layout;

const AppHeader = () => {
  const [collapsed, setCollapsed] = useState(false);
  const [theme, setTheme] = useState("dark");
  const navigate = useNavigate();

  const toggleSidebar = () => {
    setCollapsed(!collapsed);
    // Bạn sẽ cần prop `onCollapse` từ Layout component để thực sự thu gọn sidebar
  };

  const toggleTheme = () => {
    setTheme(theme === "ligt" ? "dark" : "light");
    // Ở đây bạn sẽ cần logic để thay đổi theme của toàn ứng dụng
    // Ví dụ: thay đổi class của body hoặc sử dụng Context API
  };

  const handleSignOut = async () => {
    try {
      const response = await logout();

      if (response.status === 200) {
        setLocalData(isLoggedInText, false);
        window.location.reload();
        message.success("Đăng xuất thành công!");
      } else {
        const errorData = response.data || { message: "Lỗi không xác định" };
        message.error(`Đăng xuất thất bại: ${errorData.message}`);
      }
    } catch (error) {
      console.error("Lỗi khi gọi API đăng xuất:", error);
      message.error("Đã xảy ra lỗi khi đăng xuất.");
    }
  };

  const menuItems = [
    {
      key: "signout",
      icon: <LogoutOutlined />,
      label: "Đăng xuất",
      onClick: handleSignOut,
    },
  ];

  return (
    <Header
      className="site-layout-background"
      style={{
        padding: "0 20px",
        display: "flex",
        justifyContent: "space-between",
        alignItems: "center",
      }}
      theme={theme}
    >
      <div style={{ display: "flex", alignItems: "center" }}>
        <div className="logo" style={{ marginRight: 20 }}>
          <img src={logo} />
        </div>

        <div>
          <Button
            type="text"
            icon={collapsed ? <MenuUnfoldOutlined /> : <MenuFoldOutlined />}
            onClick={toggleSidebar}
            style={{ marginRight: 16 }}
          />
        </div>
      </div>

      <div>
        <Button
          type="text"
          icon={theme === "light" ? <MoonOutlined /> : <SunOutlined />}
          onClick={toggleTheme}
          style={{ marginRight: 16 }}
        />
        <Dropdown menu={{ items: menuItems }} placement="bottomRight" arrow>
          <Avatar icon={<UserOutlined />} />
        </Dropdown>
      </div>
    </Header>
  );
};

export default AppHeader;
