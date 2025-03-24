import * as React from "react";
// import Stack from "@mui/material/Stack";
// import PropTypes from "prop-types";
// import Chip from "@mui/material/Chip";
// import Tooltip from "@mui/material/Tooltip";
// import CheckCircleIcon from "@mui/icons-material/CheckCircle";
// import CloudCircleIcon from "@mui/icons-material/CloudCircle";
import { Typography } from "@mui/material";
import { AppProvider } from "@toolpad/core/AppProvider";
import { DashboardLayout } from "@toolpad/core/DashboardLayout";
import { useDemoRouter } from "@toolpad/core/internal";
import { demoTheme } from "./themes/Theme";
import { NAVIGATION } from "./navigation/Navigation";
import PageContent from "./page/Pagecontent";
import { useSession } from "./navigation/Account";

// function CustomAppTitle() {
//   return (
//     <Stack direction="row" alignItems="center" spacing={2}>
//       <CloudCircleIcon fontSize="large" color="primary" />
//       <Typography variant="h6">My App</Typography>
//       <Chip size="small" label="BETA" color="info" />
//       <Tooltip title="Connected to production">
//         <CheckCircleIcon color="success" fontSize="small" />
//       </Tooltip>
//     </Stack>
//   );
// }

function DashboardLayoutBasic() {
  const router = useDemoRouter("/dashboard");

  const { session, authentication } = useSession();

  return (
    <AppProvider
      session={session}
      authentication={authentication}
      branding={{
        logo: <img src="https://mui.com/static/logo.png" alt="MUI logo" />,
        title: "DASHBOARD",
        homeUrl: "/toolpad/core/introduction",
      }}
      navigation={NAVIGATION}
      router={router}
      theme={demoTheme}
    >
      <DashboardLayout
      // slots={{
      //   appTitle: CustomAppTitle,
      // }}
      >
        <PageContent pathname={router.pathname} />
      </DashboardLayout>
    </AppProvider>
  );
}

export default DashboardLayoutBasic;
