package com.nolarity.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="stories")
public class Story {

	@Id
	@Column(name = "story_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	private String createdBy;

	private Date createdAt;

	private String modifiedBy;

	private Date modifiedAt;

	String title;

	String body;

	String notes;

	public Story(String createdBy, Date createdAt, String modifiedBy, Date modifiedAt, String title, String body,
			String notes) {
		super();
		this.createdBy = createdBy;
		this.createdAt = createdAt;
		this.modifiedBy = modifiedBy;
		this.modifiedAt = modifiedAt;
		this.title = title;
		this.body = body;
		this.notes = notes;
	}

	// Set<String> tags;

	
}
