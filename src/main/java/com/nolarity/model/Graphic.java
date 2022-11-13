package com.nolarity.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.nolarity.types.GraphicType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "graphics")
public class Graphic {

	@Id
	@Column(name = "graphic_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;

	String createdBy;

	Date createdAt;

	String modifiedBy;

	Date modifiedAt;

	String name;

//	@Enumerated(EnumType.STRING)
//  private GraphicType graphicType;

	private String graphicType;

	String args;
	// saved as JSON Object Literals 
	// '{"title":"Title Text", "subtitle":"Subtitle Text", "tab":"Tab Text"}' 
	// then JSON.parse(args)

	public Graphic(String createdBy, Date createdAt, String modifiedBy, Date modifiedAt, String name,
			String graphicType, String args) {
		super();
		this.createdBy = createdBy;
		this.createdAt = createdAt;
		this.modifiedBy = modifiedBy;
		this.modifiedAt = modifiedAt;
		this.name = name;
		this.graphicType = graphicType;
		this.args = args;
	}
}
