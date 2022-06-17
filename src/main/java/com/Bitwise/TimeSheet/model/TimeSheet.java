package com.Bitwise.TimeSheet.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class TimeSheet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int timeSheetId;
	private String month;
	private int year=2022;
	private int week1;
	private int week2;
	private int week3;
	private int week4;
	private int week5;
	private int total;
	
@ManyToOne(cascade = CascadeType.DETACH,fetch = FetchType.EAGER)
@JsonProperty(access = JsonProperty.Access.READ_WRITE)
private Resource resource ;
}
  