package com.yzeng.enums;

public enum PersonEnums {
	A_PERSON("a",12),
	B_PERSON("b",16),
	C_PERSON("c",22),
	;
	
	private String name;
	private Integer age;
	
	public static PersonEnums getPerson(String key) {
		for(PersonEnums p : PersonEnums.values()) {
			if(p.getName().equals(key)) {
				System.out.println(p.ordinal());
				return p;
			}
		}
		return null;
	}
	
	PersonEnums(String name, Integer age) {
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	@Override  
    public String toString() {  
        return this.age+"_"+this.name;  
    } 
	
}
