package com.app.registro.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.*;

@Entity
@Table(name="posts")
public class Post {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false, length=255)
	private String title;
	
	@Column(columnDefinition="TEXT")
	private String content;
	
	@CreationTimestamp
	@Column(name="created_at", nullable=false)
	private LocalDateTime createdAt;
	
	@UpdateTimestamp
	@Column(name="updated_at", nullable=false)
	private LocalDateTime updatedAt;
	
	public Post() {}

	public Post(String title, String content) {
		this.title = title;
		this.content = content;
	}

	// SETTERS AND GETTERS
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

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

}
