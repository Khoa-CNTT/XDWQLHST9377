import React from "react";
import { Layout } from "antd";
import { theme } from "antd";

const { Content } = Layout;

const AppContent = ({ children }) => {
  const {
    token: { colorBgContainer, borderRadiusLG },
  } = theme.useToken();

  return (
    <Content style={{ margin: "24px 16px 0", overflowX: "hidden" }}>
      <div
        style={{
          padding: 24,
          minHeight: 360,
          background: colorBgContainer,
          borderRadius: borderRadiusLG,
          maxWidth: "1200px", // hoặc 100%, hoặc 90vw
          margin: "0 auto", // căn giữa
          overflowX: "auto", // phòng trường hợp có bảng rộng
        }}
      >
        {children}
      </div>
    </Content>
  );
};

export default AppContent;
