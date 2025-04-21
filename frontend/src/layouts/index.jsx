import React, { useState } from "react";
import { Layout } from "antd";
import AppHeader from "./navigation/header";
import AppFooter from "./navigation/footer";
import AppContent from "./navigation/content";
import ManageAccounts from "./page/Accounts";
import AppSider from "./navigation/sidebar";
import BreadCrumb from "../components/breadcrumbs";
import ManageStudents from "./page/Students";

const { Content } = Layout;

const componentMap = {
  dashboard: () => (
    <div
      className="site-layout-background"
      style={{ padding: 24, minHeight: 360 }}
    >
      Dashboard Content
    </div>
  ),
  listAlls: () => <ManageStudents />,
};

const Dashboard = () => {
  const [selectedMenuItem, setSelectedMenuItem] = useState("dashboard");

  const handleMenuItemClick = (e) => {
    setSelectedMenuItem(e.key);
  };

  const renderContent = () => {
    const ComponentToRender = componentMap[selectedMenuItem];
    return ComponentToRender ? (
      <ComponentToRender />
    ) : (
      <div
        className="site-layout-background"
        style={{ padding: 24, minHeight: 360 }}
      >
        {selectedMenuItem} Content {/* Fallback nếu không tìm thấy component */}
      </div>
    );
  };

  return (
    <Layout style={{ minHeight: "100vh", flexDirection: "column" }}>
      <AppHeader />
      <Layout style={{ flexDirection: "row", flex: 1 }}>
        <AppSider
          onMenuItemClick={handleMenuItemClick}
          selectedKeys={[selectedMenuItem]}
        />
        <Layout style={{ flexDirection: "column", flex: 1, marginLeft: 0 }}>
          <BreadCrumb selectedMenuItem={selectedMenuItem} />
          <AppContent>{renderContent()}</AppContent>
          <AppFooter style={{ textAlign: "right", padding: "0 16px 24px" }} />
        </Layout>
      </Layout>
    </Layout>
  );
};

export default Dashboard;
