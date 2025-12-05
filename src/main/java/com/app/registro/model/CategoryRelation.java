package com.app.registro.model;

import com.app.registro.enums.PostTypes;

import jakarta.persistence.*;

@Entity
@Table(name="category_relations")
public class CategoryRelation {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="category_id", nullable=false)
	private Category category;
	
	@Column(name="entity_id", nullable=false)
	private Long entity;
	
	@Enumerated(EnumType.STRING)
	@Column(name="post_type", nullable = false, length = 20)
	private PostTypes postType;
	
	public CategoryRelation() {}

	public CategoryRelation(Category category, Long entity, PostTypes postType) {
		super();
		this.category = category;
		this.entity = entity;
		this.postType = postType;
	}

	/* Getters and setters */
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Long getEntity() {
		return entity;
	}

	public void setEntity(Long entity) {
		this.entity = entity;
	}

	public PostTypes getPostType() {
		return postType;
	}

	public void setPostType(PostTypes postType) {
		this.postType = postType;
	}

	public Long getId() {
		return id;
	}
	
}
