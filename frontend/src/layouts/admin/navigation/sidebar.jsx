// import React, { useState } from "react";
// import { ProSidebar, Menu, MenuItem } from "react-pro-sidebar";
// // import "react-pro-sidebar/dist/css/styles.css";
// import { Link } from "react-router-dom";
// import {
//   UserOutlined,
//   LockOutlined,
//   PieChartOutlined,
// } from "@ant-design/icons";
// import { Layout} from "antd";
// import { Box, IconButton, Typography, useTheme } from "@mui/material";
// import { tokens } from "../../../themes/theme";
// import HomeOutlinedIcon from "@mui/icons-material/HomeOutlined";
// import PeopleOutlinedIcon from "@mui/icons-material/PeopleOutlined";
// import ContactsOutlinedIcon from "@mui/icons-material/ContactsOutlined";
// import ReceiptOutlinedIcon from "@mui/icons-material/ReceiptOutlined";
// import PersonOutlinedIcon from "@mui/icons-material/PersonOutlined";
// import CalendarTodayOutlinedIcon from "@mui/icons-material/CalendarTodayOutlined";
// import HelpOutlineOutlinedIcon from "@mui/icons-material/HelpOutlineOutlined";
// import BarChartOutlinedIcon from "@mui/icons-material/BarChartOutlined";
// import PieChartOutlineOutlinedIcon from "@mui/icons-material/PieChartOutlineOutlined";
// import TimelineOutlinedIcon from "@mui/icons-material/TimelineOutlined";
// import MenuOutlinedIcon from "@mui/icons-material/MenuOutlined";
// import MapOutlinedIcon from "@mui/icons-material/MapOutlined";

// const { Sider } = Layout;

// const items = [
//   { key: "dashboard", icon: <PieChartOutlined />, label: "Dashboard" },
//   {
//     key: "authenticate",
//     label: "Authenticate",
//     icon: <LockOutlined />,
//     children: [
//       { key: "manageAccounts", label: "Manage Accounts" },
//       { key: "create", label: "**" },
//     ],
//   },
//   {
//     key: "student",
//     label: "Học Sinh",
//     icon: <UserOutlined />,
//     children: [
//       { key: "listAlls", label: "Danh sách học sinh" },
//       { key: "create", label: "**" },
//     ],
//   },
// ];

// const AppSider = ({ onMenuItemClick, selectedKeys }) => {
//   return (
//     <Sider
//       breakpoint="lg"
//       collapsedWidth="0"
//       onBreakpoint={(broken) => {
//         console.log(broken);
//       }}
//       onCollapse={(collapsed, type) => {
//         console.log(collapsed, type);
//       }}
//     >
//       <div className="demo-logo-vertical" />
//       <Menu
//         theme="dark"
//         mode="inline"
//         defaultSelectedKeys={["dashboard"]}
//         selectedKeys={selectedKeys}
//         items={items}
//         onClick={onMenuItemClick}
//       />
//     </Sider>
//   );
// };

import { useState } from "react";
import { Sidebar, Menu, MenuItem, SubMenu } from "react-pro-sidebar";
import { Box, IconButton, Typography, useTheme } from "@mui/material";
import HomeOutlinedIcon from "@mui/icons-material/HomeOutlined";
import PeopleOutlinedIcon from "@mui/icons-material/PeopleOutlined";
import ContactsOutlinedIcon from "@mui/icons-material/ContactsOutlined";
import ReceiptOutlinedIcon from "@mui/icons-material/ReceiptOutlined";
import PersonOutlinedIcon from "@mui/icons-material/PersonOutlined";
import CalendarTodayOutlinedIcon from "@mui/icons-material/CalendarTodayOutlined";
import HelpOutlineOutlinedIcon from "@mui/icons-material/HelpOutlineOutlined";
import BarChartOutlinedIcon from "@mui/icons-material/BarChartOutlined";
import PieChartOutlineOutlinedIcon from "@mui/icons-material/PieChartOutlineOutlined";
import TimelineOutlinedIcon from "@mui/icons-material/TimelineOutlined";
import MenuOutlinedIcon from "@mui/icons-material/MenuOutlined";
import MapOutlinedIcon from "@mui/icons-material/MapOutlined";
import { tokens } from "../../../themes/theme";

const Item = ({ title, to, icon, selected, setSelected, onClickKey }) => {
  const theme = useTheme();
  const colors = tokens(theme.palette.mode);

  return (
    <MenuItem
      icon={icon}
      style={{ color: colors.grey[100] }}
      active={selected === title}
      onClick={() => {
        setSelected(title);
        onClickKey();
      }}
    >
      <Typography>{title}</Typography>
    </MenuItem>
  );
};

const AppSider = ({ onMenuItemClick }) => {
  const theme = useTheme();
  const colors = tokens(theme.palette.mode);
  const [isCollapsed, setIsCollapsed] = useState(false);
  const [selected, setSelected] = useState("Dashboard");

  return (
    <Box
      sx={{
        ".ps-sidebar-inner": {
          background: `${colors.primary[400]} !important`, // Đây là nơi thay đổi màu nền của Sidebar
        },
        ".ps-icon-wrapper": {
          backgroundColor: "transparent !important", // Đảm bảo các icon không có nền
        },
        ".ps-inner-item": {
          padding: "5px 35px 5px 20px !important", // Điều chỉnh padding cho các item
        },
        ".ps-inner-item:hover": {
          // Đảm bảo hover có màu
          color: "#868dfb !important",
        },
        ".ps-menu-item.active": {
          // Đảm bảo item đang active có màu đặc biệt
          color: "#6870fa !important",
        },
      }}
    >
      <Sidebar collapsed={isCollapsed}>
        <Menu iconShape="square">
          {/* LOGO AND MENU ICON */}
          <MenuItem
            onClick={() => setIsCollapsed(!isCollapsed)}
            icon={isCollapsed ? <MenuOutlinedIcon /> : undefined}
            style={{
              margin: "10px 0 20px 0",
              color: colors.grey[100],
            }}
          >
            {!isCollapsed && (
              <Box
                display="flex"
                justifyContent="space-between"
                alignItems="center"
                ml="15px"
              >
                <Typography variant="h3" color={colors.grey[100]}>
                  ADMIN
                </Typography>
                <IconButton onClick={() => setIsCollapsed(!isCollapsed)}>
                  <MenuOutlinedIcon />
                </IconButton>
              </Box>
            )}
          </MenuItem>

          {!isCollapsed && (
            <Box mb="25px">
              <Box
                display="flex"
                justifyContent="center"
                alignItems="center"
              ></Box>
              <Box textAlign="center">
                <Typography
                  variant="h2"
                  color={colors.grey[100]}
                  fontWeight="bold"
                  sx={{ m: "10px 0 0 0" }}
                >
                  Harry Nguyen
                </Typography>
                <Typography variant="h5" color={colors.greenAccent[500]}>
                  VP Fancy Admin
                </Typography>
              </Box>
            </Box>
          )}

          <Box paddingLeft={isCollapsed ? undefined : "10%"}>
            <Item
              title="Dashboard"
              to="/admin"
              icon={<HomeOutlinedIcon />}
              selected={selected}
              setSelected={setSelected}
            />
            <SubMenu label="Accounts" icon={<PersonOutlinedIcon />}>
              <Item
                title="Manage Account"
                to="/team"
                icon={<PeopleOutlinedIcon />}
                selected={selected}
                setSelected={setSelected}
                onClickKey={() => onMenuItemClick({ key: "manageAccounts" })}
              />
              <Item
                title="Accounts Information"
                to="/contacts"
                icon={<ContactsOutlinedIcon />}
                selected={selected}
                setSelected={setSelected}
              />
            </SubMenu>

            <SubMenu label="Students">
              <Item
                title="Manage Student"
                to="/form"
                icon={<PeopleOutlinedIcon />}
                selected={selected}
                setSelected={setSelected}
                onClickKey={() => onMenuItemClick({ key: "manageStudents" })}
              />
              <Item
                title="Calendar"
                to="/calendar"
                icon={<CalendarTodayOutlinedIcon />}
                selected={selected}
                setSelected={setSelected}
              />
            </SubMenu>

            <SubMenu label="Teachers">
              <Item
                title="Bar Chart"
                to="/bar"
                icon={<BarChartOutlinedIcon />}
                selected={selected}
                setSelected={setSelected}
              />
              <Item
                title="Pie Chart"
                to="/pie"
                icon={<PieChartOutlineOutlinedIcon />}
                selected={selected}
                setSelected={setSelected}
              />
              <Item
                title="Line Chart"
                to="/line"
                icon={<TimelineOutlinedIcon />}
                selected={selected}
                setSelected={setSelected}
              />
              <Item
                title="Geography Chart"
                to="/geography"
                icon={<MapOutlinedIcon />}
                selected={selected}
                setSelected={setSelected}
              />
            </SubMenu>
          </Box>
        </Menu>
      </Sidebar>
    </Box>
  );
};

export default AppSider;
