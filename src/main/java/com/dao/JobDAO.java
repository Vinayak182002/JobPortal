package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Jobs;

public class JobDAO {

	private Connection conn;

	public JobDAO(Connection conn) {
		super();
		this.conn = conn;
	}
	
	public boolean addJobs(Jobs j)
	{
		boolean f=false;
		
		try {
			
			String sql = "insert into jobs(title,category,status,location) values(?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement( sql ) ;
			ps.setString(1,j.getTitle());
			ps.setString(2,j.getCategory());
			ps.setString(3,j.getStatus());
			ps.setString(4,j.getLocation());
			
			int i=ps.executeUpdate();
			
			if(i==1) {
				f=true;
			}
			
			} 
		catch ( Exception e ) 
		{
			e.printStackTrace();
		}
		return f;
	}
	
	public List<Jobs> getAllJobs()
	{
		List<Jobs> list=new ArrayList<Jobs>();
		Jobs j=null;
		try {
			String sql="select *from jobs order by id desc";
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				j=new Jobs();
				j.setId(rs.getInt(1));
				j.setTitle(rs.getString(2));
				j.setCategory(rs.getString(3));
				j.setStatus(rs.getString(4));
				j.setLocation(rs.getString(5));
				list.add(j);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Jobs> getAllJobsForUser()
	{
		List<Jobs> list=new ArrayList<Jobs>();
		Jobs j=null;
		try {
			String sql="select *from jobs where status=? order by id desc";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1,"Active");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				j=new Jobs();
				j.setId(rs.getInt(1));
				j.setTitle(rs.getString(2));
				j.setCategory(rs.getString(3));
				j.setStatus(rs.getString(4));
				j.setLocation(rs.getString(5));
				list.add(j);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public Jobs getJobById(int id)
	{
		Jobs j=null;
		try {
			String sql="select *from jobs where id=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				j=new Jobs();
				j.setId(rs.getInt(1));
				j.setTitle(rs.getString(2));
				j.setCategory(rs.getString(3));
				j.setStatus(rs.getString(4));
				j.setLocation(rs.getString(5));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return j;
	}
	

	public boolean updateJob(Jobs j) 
	{
		boolean f=false;
		
		try {
			
			String sql = "update jobs set title=?,category=?,status=?,location=? where id=? ";
			PreparedStatement ps = conn.prepareStatement( sql ) ;
			ps.setString(1,j.getTitle());
			ps.setString(2,j.getCategory());
			ps.setString(3,j.getStatus());
			ps.setString(4,j.getLocation());
			ps.setInt(5,j.getId());
			
			int i=ps.executeUpdate();
			
			if(i==1) {
				f=true;
			}
			
			} 
		catch ( Exception e ) 
		{
			e.printStackTrace();
		}
		return f;
	}
	
	public boolean deleteJobs(int id) {
		boolean f=false;
		try {
			String sql="delete from jobs where id=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			System.out.println("Hello!");
			int i=ps.executeUpdate();
			if(i==1) {
				f=true;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return f;
	}
}
