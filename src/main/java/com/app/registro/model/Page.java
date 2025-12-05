package com.app.registro.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.*;

import com.app.registro.model.*;

@Entity
@Table(name="pages")
public class Page {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false, length=255)
	private String title;
	
	@Column(columnDefinition="TEXT")
	private String content;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="author_id", nullable=false)
	private User author;

	@CreationTimestamp
	@Column(name="created_at", nullable=false)
	private LocalDateTime createdAt;
	
	@UpdateTimestamp
	@Column(name="updated_at", nullable=false)
	private LocalDateTime updatedAt;
	
	public Page() {}

	public Page(String title, String content) {
		super();
		this.title = title;
		this.content = content;
	}

	// SETTERS AND GETTERS
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

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
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

	public Long getId() {
		return id;
	}

}
