import React, { useContext, useState } from "react";
import { Layout, Button, Avatar, Dropdown, message } from "antd";
import {
  MenuUnfoldOutlined,
  MenuFoldOutlined,
  MoonOutlined,
  SunOutlined,
  UserOutlined,
  LogoutOutlined,
} from "@ant-design/icons";
import logo from "../../../assets/imgs/small45.png";
import { logout } from "../../../services/auth.service";
import { setLocalData } from "../../../services/localStorage";
import { isLoggedInText } from "../../../utils/constants";
import { Box, IconButton, useTheme } from "@mui/material";
import { ColorModeContext, tokens } from "../../../themes/theme";

import InputBase from "@mui/material/InputBase";
import LightModeOutlinedIcon from "@mui/icons-material/LightModeOutlined";
import DarkModeOutlinedIcon from "@mui/icons-material/DarkModeOutlined";
import NotificationsOutlinedIcon from "@mui/icons-material/NotificationsOutlined";
import SettingsOutlinedIcon from "@mui/icons-material/SettingsOutlined";
import PersonOutlinedIcon from "@mui/icons-material/PersonOutlined";
import SearchIcon from "@mui/icons-material/Search";

const { Header } = Layout;

const AppHeader = () => {
  const theme = useTheme();
  const colors = tokens(theme.palette.mode);
  const [collapsed, setCollapsed] = useState(false);
  const colorMode = useContext(ColorModeContext);
  // const [theme, setTheme] = useState("light");

  const toggleSidebar = () => {
    setCollapsed(!collapsed);
    // Bạn sẽ cần prop `onCollapse` từ Layout component để thực sự thu gọn sidebar
  };

  // const toggleTheme = () => {
  //   setTheme(theme === "light" ? "dark" : "light");
  //   // Ở đây bạn sẽ cần logic để thay đổi theme của toàn ứng dụng
  //   // Ví dụ: thay đổi class của body hoặc sử dụng Context API
  // };

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
    // <Header
    //   className="site-layout-background"
    //   style={{
    //     padding: "0 20px",
    //     display: "flex",
    //     justifyContent: "space-between",
    //     alignItems: "center",
    //   }}
    //   theme={theme}
    // >
    //   <div style={{ display: "flex", alignItems: "center" }}>
    //     <div className="logo" style={{ marginRight: 20 }}>
    //       <img src={logo} />
    //     </div>

    //     <div>
    //       <Button
    //         type="text"
    //         icon={collapsed ? <MenuUnfoldOutlined /> : <MenuFoldOutlined />}
    //         onClick={toggleSidebar}
    //         style={{ marginRight: 16 }}
    //       />
    //     </div>
    //   </div>

    //   <div>
    //     <Button
    //       type="text"
    //       icon={theme === "light" ? <MoonOutlined /> : <SunOutlined />}
    //       onClick={toggleTheme}
    //       style={{ marginRight: 16 }}
    //     />
    //     <Dropdown menu={{ items: menuItems }} placement="bottomRight" arrow>
    //       <Avatar icon={<UserOutlined />} />
    //     </Dropdown>
    //   </div>
    // </Header>
    <Box display="flex" justifyContent="space-between" p={2}>
      {/* SEARCH BAR */}
      <Box
        display="flex"
        backgroundColor={colors.primary[400]}
        borderRadius="3px"
      >
        <InputBase sx={{ ml: 2, flex: 1 }} placeholder="Search" />
        <IconButton type="button" sx={{ p: 1 }}>
          <SearchIcon />
        </IconButton>
      </Box>

      {/* ICONS */}
      <Box display="flex">
        <IconButton onClick={colorMode.toggleColorMode}>
          {theme.palette.mode === "dark" ? (
            <DarkModeOutlinedIcon />
          ) : (
            <LightModeOutlinedIcon />
          )}
        </IconButton>
        <IconButton>
          <NotificationsOutlinedIcon />
        </IconButton>
        <IconButton>
          <SettingsOutlinedIcon />
        </IconButton>
        {/* <IconButton>
          <PersonOutlinedIcon />
        </IconButton> */}
        <Dropdown menu={{ items: menuItems }} placement="bottomRight" arrow>
          <Avatar icon={<UserOutlined />} />
        </Dropdown>
      </Box>
    </Box>
  );
};

export default AppHeader;
