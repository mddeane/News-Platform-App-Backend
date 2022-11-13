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

import com.nolarity.types.RundownStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="rundowns")
public class Rundown {

	@Id
	@Column(name="rundown_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	private String createdBy;

	private Date createdAt;

	private String modifiedBy;

	private Date modifiedAt;

	private String title;

	private Date startTime;

	private Date endTIme;

//    @Enumerated(EnumType.STRING)
//    private RundownStatus status;

    private String status;

	@OneToMany
	@JoinTable(name="rundown_row_join", 
	joinColumns = @JoinColumn(name = "rundown_id"), 
	inverseJoinColumns=@JoinColumn(name = "row_id")) 
	private Set<Row> Rows;

	public Rundown(String createdBy, Date createdAt, String modifiedBy, Date modifiedAt, String title, Date startTime,
			Date endTIme, String status, Set<Row> rows) {
		super();
		this.createdBy = createdBy;
		this.createdAt = createdAt;
		this.modifiedBy = modifiedBy;
		this.modifiedAt = modifiedAt;
		this.title = title;
		this.startTime = startTime;
		this.endTIme = endTIme;
		this.status = status;
		Rows = rows;
	}

}
