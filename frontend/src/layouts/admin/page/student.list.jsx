import React, { useState, useEffect } from "react";
import { Table, Button, Typography, message, Input, Space } from "antd";
import { createStyles } from "antd-style";
import { DeleteFilled, EditFilled, SearchOutlined } from "@ant-design/icons";
import {
  getall,
  deleteStudent,
  create,
  update,
  search,
} from "../../../services/student.service";
import AddStudentDrawer from "../../../components/drawers";
import { debounce } from "lodash";

const ManageStudents = () => {
  const [dataSource, setDataSource] = useState([]);
  const [loading, setLoading] = useState(false);
  const [openDrawer, setOpenDrawer] = useState(false);
  const [searchText, setSearchText] = useState("");

  const fetchStudents = async () => {
    setLoading(true);
    try {
      const res = await getall();
      console.log("**res", res);
      const students = res?.data?.rows || [];
      setDataSource(
        students.map((item, index) => ({
          key: item.studentId || `student-${index}`,
          ...item,
        }))
      );
    } catch (error) {
      console.error("Failed to fetch students:", error);
    } finally {
      setLoading(false);
    }
  };

  const handleDelete = async (id) => {
    try {
      await deleteStudent(id);
      message.success("Xóa sinh viên thành công!");
      fetchStudents();
    } catch (error) {
      console.error("Xóa thất bại:", error);
      message.error("Xóa sinh viên thất bại!");
    }
  };

  const handleUpdate = async (id) => {
    try {
      await update(id);
      message.success("Cập nhật sinh viên thành công!");
      fetchStudents();
    } catch (error) {
      console.error("Cập nhật thất bại:", error);
      message.error("Cập nhật sinh viên thất bại!");
    }
  };

  const handleSearch = async (name) => {
    try {
      const res = await search(name);
      const students = res?.data || [];
      setDataSource(
        students.map((item, index) => ({
          key: item.studentId || `student-${index}`,
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
      fetchStudents();
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
    fetchStudents();
  }, []);

  return (
    <div
      style={{
        display: "flex",
        flexDirection: "column",
        alignItems: "flex-end",
        marginBottom: "16px",
      }}
    >
      <div>
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
          Thêm học sinh
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
export default ManageStudents;
