package com.parviz.dao;

import java.sql.*;
import com.parviz.model.Student;

public class StudentDao {
	
	Connection con;
	
	public void connect() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/test1?serverTimezone=UTC", 
					"root", "12061");
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public Student getStudent(int id) {
		
		Student s = new Student();
		
		try {
			
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from students where st_id="+id);
			
			if(rs.next()) {
				s.setId(rs.getInt(1));
				s.setName(rs.getString(2));
				s.setCity(rs.getString(3));
			}
			
			return s;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public void addStudent(Student s) {
		
		String sql = "insert into students values(?,?,?)";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, s.getId());
			st.setString(2, s.getName());
			st.setString(3, s.getCity());
			if(st.execute()) {
				System.out.println("Student added successfully");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void showAll() {
		
		String sql = "select * from students";
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				System.out.println(rs.getInt(1)+". "+rs.getString(2)+" - "+rs.getString(3));
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
