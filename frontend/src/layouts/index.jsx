import React from "react";
import { Layout } from "antd";
import AppHeader from "./navigation/header";
import AppFooter from "./navigation/footer";
import AppContent from "./navigation/content";
import ManageAccounts from "./page/Accounts";
import AppSider from "./navigation/sidebar";
import BreadCrumb from "../components/breadcrumbs";

const Dashboard = () => {
  return (
    <Layout style={{ minHeight: "100vh", flexDirection: "column" }}>
      <AppHeader />
      <Layout style={{ flexDirection: "row", flex: 1 }}>
        <AppSider />
        <Layout style={{ flexDirection: "column", flex: 1, marginLeft: 0 }}>
          <BreadCrumb />
          <AppContent>
            <ManageAccounts />
          </AppContent>
          <AppFooter style={{ textAlign: "right", padding: "0 16px 24px" }} />
        </Layout>
      </Layout>
    </Layout>
  );
};

export default Dashboard;
