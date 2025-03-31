import * as React from "react";
// import { Typography } from "@mui/material";
import { AppProvider } from "@toolpad/core/AppProvider";
import { DashboardLayout } from "@toolpad/core/DashboardLayout";
import { useDemoRouter } from "@toolpad/core/internal";
import { demoTheme } from "../themes/Theme";
import { NavMenu } from "./navigation/SidebarMenu";
import PageContent from "./Pagecontent";
import { useSession } from "../layouts/navigation/LoginAccount";

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
      navigation={NavMenu}
      router={router}
      theme={demoTheme}
    >
      <DashboardLayout>
        <PageContent pathname={router.pathname} />
      </DashboardLayout>
    </AppProvider>
  );
}

export default DashboardLayoutBasic;
