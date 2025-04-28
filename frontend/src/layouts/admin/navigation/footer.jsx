import React from "react";
import { Layout } from "antd";

const { Footer } = Layout;

const AppFooter = () => {
  return (
    <Footer style={{ textAlign: "center" }}>
      ©{new Date().getFullYear()} Created by Harry Nguyen
    </Footer>
  );
};

export default AppFooter;
