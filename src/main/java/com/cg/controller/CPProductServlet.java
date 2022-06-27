package com.cg.controller;


import com.cg.dao.StudentDAO;
import com.cg.model.Student;

import com.cg.service.IStudentService;

import com.cg.service.StudentService;
import com.cg.utils.Validate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name ="CPProductServlet" , urlPatterns = "/product")
public class CPProductServlet extends HttpServlet {
    IStudentService studentService;


    @Override
    public void init() throws ServletException {
        studentService = new StudentService();

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html/charset=UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action){

            case "list":
                showList(request,response);
                break;
            case "delete":
                deleteID(request, response);
                break;
            case "create":
                showCreate(request, response);
                break;
            case "edit":
                showEdit(request, response);
                break;
            default:
                showList(request,response);
                break;
        }
    }


    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/ListStudent.jsp");

        String strKeyword = request.getParameter("keyword");
        if(strKeyword!=null){
            List<StudentDAO> list1 =studentService.searchStudent(strKeyword);
            request.setAttribute("listS",list1);
            dispatcher.forward(request, response);
        }else {

            List<StudentDAO> list = studentService.findAllProduct();
            request.setAttribute("listS", list);
            dispatcher.forward(request, response);
        }

    }
    private void deleteID(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String id = request.getParameter("sid");
        studentService.deleteId(id);

        response.sendRedirect("/product");
    }
    private void showCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/AddStudent.jsp");
        dispatcher.forward(request,response);
    }

    private void showEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/EditStudent.jsp");

        String id = request.getParameter("id");

        Student student = studentService.findById(Integer.parseInt(id));

        if(student!=null){
            request.setAttribute("student", student);
        }

        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html/charset=UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                doCreateProduct(request, response);
                break;
            case "edit":
                doUpdateStudent(request, response);
                break;
        }
    }

    private void doCreateProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/AddStudent.jsp");

        String fullname = request.getParameter("fullname");
        String birth  = request.getParameter("birth");
        String address = request.getParameter("address");
        String phone =request.getParameter("phone");
        String email = request.getParameter("email");
        String classId = request.getParameter("classId");

        List<String> errors = new ArrayList<>();
        boolean isFullName = Validate.isFullNameValid(fullname);
        boolean isPhone = Validate.isPhoneValid(phone);
        boolean isEmail = Validate.isEmailValid(email);

        if(fullname.equals("")){
            errors.add("FullName không được để trống");
        }
        if(birth.equals("")){
            errors.add("Birth không được để trống");
        }
        if(address.equals("")) {
            errors.add("Address không được để trống");
        }
        if(phone.equals("")){
            errors.add("Aphone không được để trống");
        }
        if(email.equals("")){
            errors.add("Email không được để trống");
        }
        if (!isFullName) {
            errors.add("Nhập Fullname sai định dạng(Tên phải viết hoa chữ cái đầu và không chứa kí tự đặt biệt và không dấu)");
        }
        if (!isPhone) {
            errors.add("Phone sai định dạng(Không bao gồm dấu cách,chữ,kí tự đặc biệt,Phone gồm 10 đến 11 số và bắt đầu là số 0 và +84)");
        }
        if (!isEmail) {
            errors.add("Nhập Email sai định dạng (vd: buiquangvinh@gmail.com)");
        }
        boolean success = false;
        if(errors.size() == 0){
            Student student = new Student(fullname,birth,address,phone,email,Integer.parseInt(classId));
            success = studentService.create(student);
        }
        if (success) {
            request.setAttribute("success", true);
        } else {
            errors.add("Thêm mới thất bại");
        }

        if (errors.size() > 0) {
            request.setAttribute("errors", errors);
        }



        dispatcher.forward(request,response);
    }

    private void doUpdateStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("/EditStudent.jsp");

        String id = request.getParameter("id");
        String fullname = request.getParameter("fullname");
        String birth  = request.getParameter("birth");
        String address = request.getParameter("address");
        String phone =request.getParameter("phone");
        String email = request.getParameter("email");
        String classId = request.getParameter("classId");
        List<String> errors = new ArrayList<>();
        boolean isFullName = Validate.isFullNameValid(fullname);
        boolean isPhone = Validate.isPhoneValid(phone);
        boolean isEmail = Validate.isEmailValid(email);

        if(fullname.equals("")){
            errors.add("FullName không được để trống");
        }
        if(birth.equals("")){
            errors.add("Birth không được để trống");
        }
        if(address.equals("")) {
            errors.add("Address không được để trống");
        }
        if(phone.equals("")){
            errors.add("Aphone không được để trống");
        }
        if(email.equals("")){
            errors.add("Email không được để trống");
        }
        if (!isFullName) {
            errors.add("Nhập Fullname sai định dạng(Tên phải viết hoa chữ cái đầu và không chứa kí tự đặt biệt và không dấu)");
        }
        if (!isPhone) {
            errors.add("Phone sai định dạng(Không bao gồm dấu cách,chữ,kí tự đặc biệt,Phone gồm 10 đến 11 số và bắt đầu là số 0 và +84)");
        }
        if (!isEmail) {
            errors.add("Nhập Email sai định dạng (vd: buiquangvinh@gmail.com)");
        }
        boolean success = false;
        if(errors.size() == 0){
            Student student = new Student(Integer.parseInt(id),fullname,birth,address,phone,email,Integer.parseInt(classId));
            success = studentService.update(student);
        }
        if (success) {
            request.setAttribute("success", true);
        } else {
            errors.add("Cập nhật thất bại");
        }

        if (errors.size() > 0) {
            request.setAttribute("errors", errors);
        }





        dispatcher.forward(request,response);

    }
}
