package com.app.entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="pp_info")
public class ProgrammerProjectInfo implements Serializable {

	@EmbeddedId
	private ProgrammerProjectId id;
	
	private String projectName;
	private String programmerName;
}
