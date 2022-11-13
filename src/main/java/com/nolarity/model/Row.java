package com.nolarity.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.nolarity.types.RowStatus;
import com.nolarity.types.RowType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="rows")
public class Row {

	@Id
	@Column(name="row_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	private String createdBy;

	private Date createdAt;

	private String modifiedBy;

	private Date modifiedAt;

	private long storyId;

	private String page;

	private String title;

	private String segment;

	private String reader;

	private String writer;

	private Date backTime;

	private Date frontTime;

	private String notes;

//	@Enumerated(EnumType.STRING)
//    private RowType rowType;
//	
//	@Enumerated(EnumType.STRING)
//	private RowStatus rowStatus;

    private String rowType;
	
	private String rowStatus;

	@OneToMany
	@JoinTable(name="row_graphic_join", 
	joinColumns = @JoinColumn(name = "graphic_id"), 
	inverseJoinColumns=@JoinColumn(name = "row_id")) 
	private Set<Graphic> graphics;

	public Row(String createdBy, Date createdAt, String modifiedBy, Date modifiedAt, long storyId, String page,
			String title, String segment, String reader, String writer, Date backTime, Date frontTime, String notes,
			String rowType, String rowStatus, Set<Graphic> graphics) {
		super();
		this.createdBy = createdBy;
		this.createdAt = createdAt;
		this.modifiedBy = modifiedBy;
		this.modifiedAt = modifiedAt;
		this.storyId = storyId;
		this.page = page;
		this.title = title;
		this.segment = segment;
		this.reader = reader;
		this.writer = writer;
		this.backTime = backTime;
		this.frontTime = frontTime;
		this.notes = notes;
		this.rowType = rowType;
		this.rowStatus = rowStatus;
		this.graphics = graphics;
	}

	
}
