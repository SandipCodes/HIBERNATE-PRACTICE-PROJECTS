package com.app.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name="event_tab")

@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
public class Event implements Serializable{

	@Id
	@GeneratedValue
	
	private Integer id;
	private String name;
	private Date doe;
	private Integer pax;
	private String location;
	
	
}
