package com.example.easynotes;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "notes")
@EntityListeners(AuditingEntityListener.class) // filds "CreatedDate" y "LastModifiedDate" automatically get populated
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, 
allowGetters = true) // Ignore those values but they can be in the Json response
public class Note{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Define primary key with auto increment 
	Long id;
	
	@NotBlank
	String title;
	
	@NotBlank
	String content;
	
	@Column(nullable = false, updatable = false) // Define column's properties
	@Temporal(TemporalType.TIMESTAMP) // Converts date objects from java to compatible database type
	@CreatedDate
	Date createdAt;
	
	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	Date updatedAt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

}
