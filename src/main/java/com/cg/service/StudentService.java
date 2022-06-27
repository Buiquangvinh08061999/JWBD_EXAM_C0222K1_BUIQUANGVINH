package com.cg.service;

import com.cg.dao.StudentDAO;
import com.cg.model.Student;
import com.cg.utils.DBConText;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class StudentService implements IStudentService{

    private static final String SELECT_ALL_STUDENT="SELECT * FROM student;";
    @Override
    public List<Student> findAll() {
        List<Student> list = new ArrayList<>();
        try {
            Connection conn = DBConText.getConnection();
            PreparedStatement ps = conn.prepareCall(SELECT_ALL_STUDENT);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String fullname = rs.getString("fullname");
                String birth= rs.getString("birth");
                String address = rs.getString("address");
                String phone = rs.getString("phone");
                String email = rs.getString("email");
                int classId = rs.getInt("classId");
                list.add(new Student(id,fullname,birth,address,phone,email,classId));

            }
        }catch (SQLException e){
            e.printStackTrace();

        }
        return list;

    }
    private static final String SELECT_ALL=
            "SELECT s.id , s.fullname , s.birth , s.address , s.phone, s.email, c.name " +
            "FROM student AS s " +
            "JOIN classrom AS c " +
            "ON s.classId = c.id;";
    @Override
    public List<StudentDAO> findAllProduct() {
        List<StudentDAO> list = new ArrayList<>();
        try {
            Connection conn = DBConText.getConnection();
            PreparedStatement ps = conn.prepareCall(SELECT_ALL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String fullname = rs.getString("fullname");
                Date birth = rs.getDate("birth");
                String address = rs.getString("address");
                String phone = rs.getString("phone");
                String email = rs.getString("email");
                String name = rs.getString("name");

                list.add(new StudentDAO(id,fullname,birth,address,phone,email,name ));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }


    private static final String DELETE_FROM_STUDENT =
            "DELETE FROM student WHERE id = ?;";
    @Override
    public void deleteId(String id) {
        try {
            Connection conn = DBConText.getConnection();
            PreparedStatement ps = conn.prepareCall(DELETE_FROM_STUDENT);
            ps.setString(1, id);

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private static String INSERT_STUDENT =
            "INSERT INTO student (`fullname`, `birth`, `address`, `phone`, `email`, `classId`)" +
            " VALUES (?, ?, ?, ?, ?, ? );";
    @Override
    public boolean create(Student student) {

        boolean success = false;
        try {
            Connection conn = DBConText.getConnection();
            PreparedStatement ps = conn.prepareCall(INSERT_STUDENT);

            ps.setString(1,student.getFullname());
            ps.setString(2,student.getBirth());
            ps.setString(3,student.getAddress());
            ps.setString(4,student.getPhone());
            ps.setString(5,student.getEmail());
            ps.setInt(6,student.getClassId());

            ps.execute();

            success = true;

        }catch (SQLException e){
            e.printStackTrace();
        }
        return success;
    }

    private static String FIND_STUDENT_BYID ="" +
            " SELECT s.id, s.fullname,s.birth , s.address, s.phone, s.email, s.classId" +
            " FROM student AS s " +
            " WHERE s.id = ?;";
    @Override
    public Student findById(int id) {
        try {
            Connection conn = DBConText.getConnection();
            PreparedStatement ps = conn.prepareCall(FIND_STUDENT_BYID);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new Student(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7));
            }

        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    private static final String UPDATE_BYID_STUDENT=
            "UPDATE student SET fullname =?, birth=?,address=?,phone=?, email=?, classId=? " +
            " WHERE id = ?;";
    @Override
    public boolean update(Student student) {
        boolean success = false;
        try {
            Connection conn = DBConText.getConnection();
            PreparedStatement ps = conn.prepareCall(UPDATE_BYID_STUDENT);

            ps.setString(1,student.getFullname());
            ps.setString(2,student.getBirth());
            ps.setString(3,student.getAddress());
            ps.setString(4,student.getPhone());
            ps.setString(5,student.getEmail());
            ps.setInt(6,student.getClassId());
            ps.setInt(7,student.getId());

            ps.execute();
            success = true;

        }catch (SQLException e){
            e.printStackTrace();
        }
        return success;
    }

    private static final String SEARCH_STUDENT =
            "SELECT s.id , s.fullname , s.birth , s.address , s.phone, s.email, c.name " +
            " FROM student AS s " +
            " JOIN classrom AS c " +
            " ON s.classId = c.id " +
            " WHERE s.fullname LIKE ?;";
    @Override
    public List<StudentDAO> searchStudent(String keyword) {
        List<StudentDAO> list = new ArrayList<>();
        try {
            Connection conn = DBConText.getConnection();
            PreparedStatement ps = conn.prepareCall(SEARCH_STUDENT);

            ps.setString(1, '%' + keyword + '%');

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String fullname = rs.getString("fullname");
                Date birth = rs.getDate("birth");
                String address = rs.getString("address");
                String phone = rs.getString("phone");
                String email = rs.getString("email");
                String name = rs.getString("name");

                list.add(new StudentDAO(id,fullname,birth,address,phone,email,name ));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }
}
