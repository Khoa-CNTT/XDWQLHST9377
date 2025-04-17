import DashboardIcon from "@mui/icons-material/Dashboard";
import PersonIcon from "@mui/icons-material/Person";
import AppsIcon from "@mui/icons-material/Apps";
import HomeIcon from "@mui/icons-material/Home";
import ReceiptIcon from "@mui/icons-material/Receipt";

export const NavMenu = [
  {
    kind: "header",
    title: "Main",
  },
  {
    segment: "overview",
    title: "Overview",
    icon: <DashboardIcon />,
  },
  {
    kind: "divider",
  },
  {
    kind: "header",
    title: "Analytics",
  },
  {
    segment: "manage",
    title: "Manage",
    icon: <AppsIcon />,
    children: [
      {
        segment: "accounts",
        title: "Accounts",
        icon: <PersonIcon />,
      },
      {
        segment: "students",
        title: "Students",
        icon: <PersonIcon />,
      },
      {
        segment: "parents",
        title: "Parents",
        icon: <PersonIcon />,
      },
      {
        segment: "teachers",
        title: "Teachers",
        icon: <PersonIcon />,
      },
      {
        segment: "classes",
        title: "Classes",
        icon: <HomeIcon />,
      },
    ],
  },
  {
    segment: "bills",
    title: "Bills",
    icon: <ReceiptIcon />,
  },
  {
    kind: "divider",
  },
];
