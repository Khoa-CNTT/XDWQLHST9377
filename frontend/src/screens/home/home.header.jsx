import { CloseOutlined, MenuOutlined } from "@ant-design/icons";
import React, { useState } from "react";
import logo from "../../assets/imgs/small.png";
import { navItems } from "../../utils/constants";
import { useNavigate } from "react-router-dom";
import { logout } from "../../services/auth.service";
import { setLocalData } from "../../services/localStorage";
import { isLoggedInText } from "../../utils/constants";

const HomeHeader = () => {
  const [mobileDrawerOpen, setMobileDrawerOpen] = useState(false);
  const navigate = useNavigate();

  const toggleNavbar = () => {
    setMobileDrawerOpen(!mobileDrawerOpen);
  };

  const handleLoginClick = () => {
    navigate("/login");
  };

  const handleSignOut = async () => {
    try {
      const response = await logout();

      if (response.status === 200) {
        setLocalData(isLoggedInText, false);
        window.location.reload();
        message.success("Đăng xuất thành công!");
      } else {
        const errorData = response.data || { message: "Lỗi không xác định" };
        message.error(`Đăng xuất thất bại: ${errorData.message}`);
      }
    } catch (error) {
      console.error("Lỗi khi gọi API đăng xuất:", error);
      message.error("Đã xảy ra lỗi khi đăng xuất.");
    }
  };

  const handleNavItemClick = (href) => {
    navigate(href);
    setMobileDrawerOpen(false);
  };

  return (
    <nav className="sticky top-0 z-50 py-3 backdrop-blur-lg border-b border-neutral-700/80">
      <div className="container px-4 mx-auto relative text-sm">
        <div className="flex justify-between items-center">
          <div className="flex items-center flex-shrink-0">
            <img className="h-10 w-10 mr-2" src={logo} alt="logo" />
            <span className="text-xl tracking-tight">Tan Khoa</span>
          </div>
          <ul className="hidden lg:flex ml-14 space-x-12">
            {navItems.map((item, index) => (
              <li key={index}>
                <button onClick={() => handleNavItemClick(item.href)}>
                  {item.label}
                </button>
              </li>
            ))}
          </ul>
          <div className="hidden lg:flex justify-center space-x-12 items-center">
            <button
              onClick={handleLoginClick}
              className="bg-gradient-to-r from-orange-500 to-orange-800 rounded-md py-2 px-3"
            >
              Đăng nhập
            </button>
            <button
              onClick={handleSignOut}
              className="bg-gradient-to-r from-orange-500 to-orange-800 rounded-md py-2 px-3"
            >
              Đăng Xuất
            </button>
          </div>
          <div className="lg:hidden md:flex flex-col justify-end">
            <button onClick={toggleNavbar}>
              {mobileDrawerOpen ? <CloseOutlined /> : <MenuOutlined />}
            </button>
          </div>
        </div>
        {mobileDrawerOpen && (
          <div className="fixed right-0 z-20 bg-white w-full p-12 flex flex-col justify-center items-center lg:hidden">
            <ul>
              {navItems.map((item, index) => (
                <li key={index} className="py-4">
                  <button onClick={() => handleNavItemClick(item.href)}>
                    {item.label}
                  </button>
                </li>
              ))}
            </ul>
            <div className="flex space-x-6">
              <button
                onClick={handleLoginClick}
                className="bg-gradiengitt-to-r from-orange-500 to-orange-800 rounded-md py-2 px-3 not-first"
              >
                Đăng nhập
              </button>
            </div>
          </div>
        )}
      </div>
    </nav>
  );
};

export default HomeHeader;
