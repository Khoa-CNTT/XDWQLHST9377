import React from "react";
import { HomeOutlined, UserOutlined } from "@ant-design/icons";
import { Breadcrumb } from "antd";

const breadcrumbMap = {
  dashboard: [{ title: "Dashboard" }],
  student: [
    {
      title: (
        <>
          <UserOutlined />
          <span>Học Sinh</span>
        </>
      ),
    },
  ],
  listAlls: [
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
