import React, { useState, useEffect } from "react";
import { Table, Button, Typography, message, Input, Space } from "antd";
import { DeleteFilled, EditFilled, SearchOutlined } from "@ant-design/icons";
import {
  getall,
  deleteAccount,
  create,
  update,
  search,
} from "../../../services/account.service";
import AddStudentDrawer from "../../../components/drawers";
import { debounce } from "lodash";
import EditModal from "../../../components/modal";

const ManageAccounts = () => {
  const [dataSource, setDataSource] = useState([]);
  const [loading, setLoading] = useState(false);
  const [openDrawer, setOpenDrawer] = useState(false);
  const [isModalOpen, setIsModalOpen] = useState(false);
  const [searchText, setSearchText] = useState("");
  const [selectedRowData, setSelectedRowData] = useState(null);

  console.log("***seletedRowData: ", selectedRowData);

  const fetchAccounts = async () => {
    setLoading(true);
    try {
      const res = await getall();
      console.log("**res", res);
      const accounts = res?.data?.rows || [];
      setDataSource(
        accounts.map((item, index) => ({
          key: item.accountId || `account-${index}`,
          ...item,
        }))
      );
    } catch (error) {
      console.error("Failed to fetch accounts:", error);
    } finally {
      setLoading(false);
    }
  };

  const handleEditClick = (record) => {
    setSelectedRowData(record);
    setIsModalOpen(true);
    // console.log("***data row ", record);
  };

  const handleModalClose = () => {
    setIsModalOpen(false);
    setSelectedRowData(null);
  };

  const handleDelete = async (id) => {
    try {
      await deleteAccount(id);
      message.success("Xóa sinh viên thành công!");
      fetchAccounts();
    } catch (error) {
      console.error("Xóa thất bại:", error);
      message.error("Xóa sinh viên thất bại!");
    }
  };

  const handleUpdate = async (updatedData) => {
    try {
      await update({
        id: updatedData.id,
        username: updatedData.username,
        password: updatedData.password,
        role: updatedData.role,
      });
      message.success("Cập nhật sinh viên thành công!");
      fetchAccounts();
      setIsModalOpen(false); // Đóng modal sau khi thành công
      setSelectedRowData(null); // Reset selected row data
    } catch (error) {
      console.error("Cập nhật thất bại:", error);
      message.error("Cập nhật sinh viên thất bại!");
    }
  };

  const handleSearch = async (name) => {
    try {
      const res = await search(name);
      const accounts = res?.data || [];
      setDataSource(
        accounts.map((item, index) => ({
          key: item.accountId || `account-${index}`,
          ...item,
        }))
      );
    } catch (error) {
      console.error("Tìm kiếm thất bại:", error);
    } finally {
      setLoading(false);
    }
  };

  const handleCreate = async (values) => {
    try {
      await create(values);
      message.success("Thêm sinh viên thành công!");
      setOpenDrawer(false);
      fetchAccounts();
    } catch (error) {
      console.error("Thêm thất bại:", error);
      message.error("Thêm sinh viên thất bại!");
    }
  };

  const debouncedSearch = debounce(handleSearch, 5);

  const handleSearchInputChange = (e) => {
    const value = e.target.value;
    setSearchText(value);
    debouncedSearch(value);
  };

  const columns = [
    { title: "Id", dataIndex: "id", key: "id", fixed: "left" },
    { title: "Tên đăng nhập", dataIndex: "username", key: "username" },
    { title: "Mật khẩu", dataIndex: "password", key: "password" },
    { title: "Vai Trò", dataIndex: "role", key: "role" },
    {
      title: "Hành đông",
      key: "action",
      fixed: "right",
      width: 110,
      render: (_, record) => (
        <div style={{ display: "flex", justifyContent: "center", gap: 12 }}>
          <Typography.Link onClick={() => handleDelete(record.id)}>
            <DeleteFilled style={{ fontSize: "18px", color: "red" }} />
          </Typography.Link>
          <Typography.Link onClick={() => handleEditClick(record)}>
            <EditFilled style={{ fontSize: "18px", color: "#1890ff" }} />
          </Typography.Link>
        </div>
      ),
    },
  ];

  const showDrawer = () => {
    setOpenDrawer(true);
  };

  const closeDrawer = () => {
    setOpenDrawer(false);
  };

  useEffect(() => {
    fetchAccounts();
  }, []);

  return (
    <div style={{ width: "100%" }}>
      <div
        style={{
          display: "flex",
          justifyContent: "flex-end",
          marginBottom: "16px",
        }}
      >
        <Space.Compact>
          <Input
            style={{ width: 250 }}
            placeholder="Search Accounts"
            prefix={<SearchOutlined />}
            value={searchText}
            onChange={handleSearchInputChange}
          />
        </Space.Compact>
        <Button
          type="primary"
          onClick={showDrawer}
          style={{ marginLeft: "8px" }}
        >
          Thêm tài khoản
        </Button>
      </div>
      <Table
        columns={columns}
        dataSource={dataSource}
        loading={loading}
        scroll={{ x: 1500 }}
        sticky={{ offsetHeader: 64 }}
        pagination={true}
      />
      <AddStudentDrawer
        open={openDrawer}
        onClose={closeDrawer}
        onCreate={handleCreate}
      />
      <EditModal
        open={isModalOpen}
        handleClose={handleModalClose}
        rowData={selectedRowData}
        onConfirm={handleUpdate}
      />
    </div>
  );
};

export default ManageAccounts;
