package com.KevinCx.domain.query;

import lombok.Data;

@Data
public class AnimalQuery extends PageQuery{
	private String name;
	private String species;
	private Integer gender;
	private Integer breed;
}
