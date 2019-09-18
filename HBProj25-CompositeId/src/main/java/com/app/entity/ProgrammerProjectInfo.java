package com.app.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class ProgrammerProjectInfo implements Serializable {

	private ProgrammerProjectId id;
	private String projectName;
	private String programmerName;
}
