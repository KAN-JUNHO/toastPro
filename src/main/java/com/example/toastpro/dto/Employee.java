package com.example.toastpro.dto;

import lombok.*;

import java.util.Date;

public class Employee {

	@Getter	@Setter
	public static class DetailDTO {
		private Long employeeIdx;
		private String companyName;
		private String departmentName;
		private String teamName;
		private String positionName;
		private String dutyName;
		private String name;
		private String enName;
		private String profileImage;
		private String gender;
		private String birthday;
		private String phoneNumber;
		private String email;
		private String address;
		private int salary;
		private int annualLeave;
		private int state;
		private Date hireDate;
		private Date resignationDate;
		private Date insDate;
		private Date updDate;
	}

	@Getter	@Setter
	public static class ListDTO {
		private Long employeeIdx;
		private String companyName;
		private String departmentName;
		private String teamName;
		private String positionName;
		private String dutyName;
		private String name;
		private String enName;
		private String profileImage;
		private String gender;
		private int state;
		private Date hireDate;
		private Date resignationDate;
		private Date insDate;
		private Date updDate;
	}

	// 기본값 관련 수정해야함
	@Getter	@Setter
	public static class InsertDTO {
		private Long employeeIdx;
		private Long companyIdx = 1L;
		private Long departmentIdx = 1L;
		private Long teamIdx = 1L;
		private Long dutyIdx = 1L;
		private Long positionIdx = 1L;
		private Long authorityIdx = 1L;
		private String name = "";
		private String enName = "";
		private String profileImage = "";
		private String gender = "";
		private String birthday = "";
		private String phoneNumber= "";
		private String email= "";
		private String address= "";
		private int salary = 0;
		private int annualLeave = 0;
		private int state = 0;
		private Date hireDate = new Date();
		private Date resignationDate = new Date();
	}

	@Getter	@Setter
	public static class UpdateDTO {
		private Long employeeIdx;
		private Long companyIdx = 1L;
		private Long departmentIdx = 1L;
		private Long teamIdx = 1L;
		private Long dutyIdx = 1L;
		private Long positionIdx = 1L;
		private Long authorityIdx = 1L;
		private String name = "";
		private String enName = "";
		private String profileImage = "";
		private String gender = "";
		private String birthday = "";
		private String phoneNumber= "";
		private String email= "";
		private String address= "";
		private int salary = 0;
		private int annualLeave = 0;
		private int state = 0;
		private Date hireDate = new Date();
		private Date resignationDate = new Date();
	}
}
