import React, { useState, useEffect } from "react";
import { Table, Button, Typography, message, Input, Space } from "antd";
import { DeleteFilled, EditFilled, SearchOutlined } from "@ant-design/icons";
import {
  getall,
  create,
  search,
  deleteParent,
} from "../../../services/parent.service";
import AddStudentDrawer from "../../../components/drawers";
import { debounce } from "lodash";

const ManageParents = () => {
  const [dataSource, setDataSource] = useState([]);
  const [loading, setLoading] = useState(false);
  const [openDrawer, setOpenDrawer] = useState(false);
  const [searchText, setSearchText] = useState("");

  const fetchParents = async () => {
    setLoading(true);
    try {
      const res = await getall();
      console.log("**res", res);
      const parents = res?.data?.rows || [];
      setDataSource(
        parents.map((item, index) => ({
          key: item.parentId || `parent-${index}`,
          ...item,
        }))
      );
    } catch (error) {
      console.error("Failed to fetch parents:", error);
    } finally {
      setLoading(false);
    }
  };

  const handleDelete = async (id) => {
    try {
      await deleteParent(id);
      message.success("Xóa phụ huynh thành công!");
      fetchParents();
    } catch (error) {
      console.error("Xóa thất bại:", error);
      message.error("Xóa phụ huynh thất bại!");
    }
  };

  //   const handleUpdate = async (id) => {
  //     try {
  //       await update(id);
  //       message.success("Cập nhật sinh viên thành công!");
  //       fetchStudents();
  //     } catch (error) {
  //       console.error("Cập nhật thất bại:", error);
  //       message.error("Cập nhật sinh viên thất bại!");
  //     }
  //   };

  const handleSearch = async (name) => {
    try {
      const res = await search(name);
      const parents = res?.data || [];
      setDataSource(
        parents.map((item, index) => ({
          key: item.parentId || `parent-${index}`,
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
      message.success("Thêm phụ huynh thành công!");
      setOpenDrawer(false);
      fetchParents();
    } catch (error) {
      console.error("Thêm thất bại:", error);
      message.error("Thêm phụ huynh thất bại!");
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
    { title: "Họ tên", dataIndex: "name", key: "name" },
    { title: "Số điện thoại", dataIndex: "phoneNumber", key: "phoneNumber" },
    { title: "Email", dataIndex: "email", key: "email" },
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
          <Typography.Link>
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
    fetchParents();
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
            style={{ width: "70%" }}
            placeholder="Tìm kiếm"
            prefix={<SearchOutlined />}
            value={searchText}
            onChange={handleSearchInputChange}
          />
        </Space.Compact>
        <Button
          type="primary"
          icon={<SearchOutlined />}
          style={{ marginBottom: "8px" }}
          onClick={showDrawer}
        >
          Thêm phụ huynh
        </Button>
      </div>
      <Table
        columns={columns}
        dataSource={dataSource}
        scroll={{ x: 1500 }}
        sticky={{ offsetHeader: 64 }}
        pagination={true}
        loading={loading}
      />
      <AddStudentDrawer
        open={openDrawer}
        onClose={closeDrawer}
        onCreate={handleCreate}
      />
    </div>
  );
};
export default ManageParents;
