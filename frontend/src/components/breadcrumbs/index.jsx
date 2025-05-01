import React from "react";
import { HomeOutlined, UserOutlined } from "@ant-design/icons";
import { Breadcrumb } from "antd";

const breadcrumbMap = {
  dashboard: [{ title: "Dashboard" }],
  manageStudents: [
    {
      title: (
        <>
          <UserOutlined />
          <span>Học Sinh</span>
        </>
      ),
    },
    { title: "Danh sách học sinh" },
  ],
  manageAccounts: [
    {
      title: (
        <>
          <UserOutlined />
          <span>Tài khoản</span>
        </>
      ),
    },
    { title: "Danh sách tài khoản" },
  ],
};

const BreadCrumb = ({ selectedMenuItem }) => {
  const getBreadcrumbItems = () => {
    const baseItems = [{ href: "", title: <HomeOutlined /> }];
    const additionalItems = breadcrumbMap[selectedMenuItem] || [];
    return [...baseItems, ...additionalItems];
  };

  return <Breadcrumb items={getBreadcrumbItems()} />;
};

export default BreadCrumb;
