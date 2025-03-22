import DashboardIcon from "@mui/icons-material/Dashboard";
import BarChartIcon from "@mui/icons-material/BarChart";
import DescriptionIcon from "@mui/icons-material/Description";
import LayersIcon from "@mui/icons-material/Layers";
import PersonIcon from "@mui/icons-material/Person";
import AppsIcon from "@mui/icons-material/Apps";
import HomeIcon from "@mui/icons-material/Home";

export const NAVIGATION = [
  {
    kind: "header",
    title: "Main",
  },
  {
    segment: "dashboard",
    title: "Dashboard",
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
    segment: "integrations",
    title: "Integrations",
    icon: <LayersIcon />,
  },
];
