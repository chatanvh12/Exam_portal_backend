package com.exam.Examserver.entity;

import java.util.HashSet;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Quiz {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long qId;
	private String title;
	private boolean active = false;
	private String description;
	private String maxMark;
	private String numberOfQuestion;

	@ManyToOne(cascade=CascadeType.MERGE)
	private Category category;
	
	@OneToMany(mappedBy = "quiz",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<Question> question=new HashSet<>();

	public Category getCategory() {
		return category;
	}

	public Quiz() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public void setCategory(Category category) {
		this.category = category;
	}

	public Set<Question> getQuestion() {
		return question;
	}

	public void setQuestion(Set<Question> question) {
		this.question = question;
	}

	public Long getqId() {
		return qId;
	}

	public void setqId(Long qId) {
		this.qId = qId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMaxMark() {
		return maxMark;
	}

	public void setMaxMark(String maxMark) {
		this.maxMark = maxMark;
	}

	public String getNumberOfQuestion() {
		return numberOfQuestion;
	}

	public void setNumberOfQuestion(String numberOfQuestion) {
		this.numberOfQuestion = numberOfQuestion;
	}

}
