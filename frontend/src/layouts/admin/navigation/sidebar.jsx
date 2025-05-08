import { useState } from "react";
import { Sidebar, Menu, MenuItem, SubMenu } from "react-pro-sidebar";
import { Box, IconButton, Typography, useTheme } from "@mui/material";
import HomeOutlinedIcon from "@mui/icons-material/HomeOutlined";
import PeopleOutlinedIcon from "@mui/icons-material/PeopleOutlined";
import ContactsOutlinedIcon from "@mui/icons-material/ContactsOutlined";
import PersonOutlinedIcon from "@mui/icons-material/PersonOutlined";
import CalendarTodayOutlinedIcon from "@mui/icons-material/CalendarTodayOutlined";
import BarChartOutlinedIcon from "@mui/icons-material/BarChartOutlined";
import PieChartOutlineOutlinedIcon from "@mui/icons-material/PieChartOutlineOutlined";
import TimelineOutlinedIcon from "@mui/icons-material/TimelineOutlined";
import MenuOutlinedIcon from "@mui/icons-material/MenuOutlined";
import MapOutlinedIcon from "@mui/icons-material/MapOutlined";
import { tokens } from "../../../themes/theme";
import logo from "../../../assets/imgs/small45.png";

const Item = ({ title, icon, selected, setSelected, onClickKey }) => {
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
          background: `${colors.primary[400]} !important`,
        },
        ".ps-icon-wrapper": {
          backgroundColor: "transparent !important",
        },
        ".ps-inner-item": {
          padding: "5px 35px 5px 20px !important",
        },
        ".ps-inner-item:hover": {
          color: "#868dfb !important",
        },
        ".ps-menu-item.active": {
          color: "#6870fa !important",
        },
      }}
    >
      <Sidebar collapsed={isCollapsed}>
        <Menu iconShape="square">
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
                <div className="logo" style={{ width: 30, height: 30 }}>
                  <img src={logo} />
                </div>
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
                  Admin
                </Typography>
              </Box>
            </Box>
          )}

          <Box paddingLeft={isCollapsed ? undefined : "10%"}>
            <Item
              title="Tổng quan  "
              to="/admin"
              icon={<HomeOutlinedIcon />}
              selected={selected}
              setSelected={setSelected}
            />
            <SubMenu label="Tài khoản" icon={<PersonOutlinedIcon />}>
              <Item
                title="Quản lý tài khoản"
                to="/manageAccounts"
                icon={<PeopleOutlinedIcon />}
                selected={selected}
                setSelected={setSelected}
                onClickKey={() => onMenuItemClick({ key: "manageAccounts" })}
              />
              {/* <Item
                title="Accounts Information"
                to="/contacts"
                icon={<ContactsOutlinedIcon />}
                selected={selected}
                setSelected={setSelected}
              /> */}
            </SubMenu>

            <SubMenu label="Học sinh">
              <Item
                title="Quản lý học sinh"
                to="/manageStudents"
                icon={<PeopleOutlinedIcon />}
                selected={selected}
                setSelected={setSelected}
                onClickKey={() => onMenuItemClick({ key: "manageStudents" })}
              />
              {/* <Item
                title="Calendar"
                to="/calendar"
                icon={<CalendarTodayOutlinedIcon />}
                selected={selected}
                setSelected={setSelected}
              /> */}
            </SubMenu>

            <SubMenu label="Giáo viên">
              <Item
                title="Quản lý giáo viên"
                to="/manageTeachers"
                // icon={<BarChartOutlinedIcon />}
                selected={selected}
                setSelected={setSelected}
              />
              {/* <Item
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
              /> */}
            </SubMenu>

            <SubMenu label="Phụ huynh">
              <Item
                title="Quản lý phụ huỵnh"
                to="/manageParents"
                // icon={<TimelineOutlinedIcon />}
                selected={selected}
                setSelected={setSelected}
                onClickKey={() => onMenuItemClick({ key: "manageParents" })}
              />
              {/* <Item
                title="Geography Chart"
                to="/geography"
                icon={<MapOutlinedIcon />}
                selected={selected}
                setSelected={setSelected}
              /> */}
            </SubMenu>
          </Box>
        </Menu>
      </Sidebar>
    </Box>
  );
};

export default AppSider;
