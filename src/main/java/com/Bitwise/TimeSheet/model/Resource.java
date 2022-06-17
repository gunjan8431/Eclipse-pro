package com.Bitwise.TimeSheet.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Resource {
   @Id
  
	private int resourceId;
	private String resourceName;
	private String team;
	
	@OneToMany(cascade = CascadeType.ALL)
	
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private List<TimeSheet> timesheet; 
}
