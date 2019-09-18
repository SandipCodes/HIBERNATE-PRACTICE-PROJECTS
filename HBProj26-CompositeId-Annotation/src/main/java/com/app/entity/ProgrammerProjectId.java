package com.app.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class ProgrammerProjectId implements Serializable{

	private Integer projId;
	private Integer pid;
	
}
