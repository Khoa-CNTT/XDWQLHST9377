import React from "react";
import { HomeOutlined, UserOutlined } from "@ant-design/icons";
import { Breadcrumb } from "antd";
const BreadCrumb = () => (
  <Breadcrumb
    items={[
      {
        href: "",
        title: <HomeOutlined />,
      },
      {
        href: "",
        title: (
          <>
            <UserOutlined />
            <span>Application List</span>
          </>
        ),
      },
      {
        title: "Application",
      },
    ]}
  />
);
export default BreadCrumb;
