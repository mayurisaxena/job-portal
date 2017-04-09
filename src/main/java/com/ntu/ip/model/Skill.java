package com.ntu.ip.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Skill")
public class Skill {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Skill_Id", columnDefinition = "INTEGER")
	private int id;

	@Column(name = "Skill_Name", columnDefinition = "VARCHAR(50)")
	private String skillName;

	public Skill() {
		super();
	}

	public Skill(String skillName) {
		super();
		this.skillName = skillName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	@Override
    public boolean equals(Object o) {

        if (o == this) return true;
        if (!(o instanceof Skill)) {
            return false;
        }

        Skill skill = (Skill) o;

        return skill.getId() == (this.getId());
    }

    @Override
    public int hashCode() {
        
        return this.getId();
    }
	
}
