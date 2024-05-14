package com.in28minutes.springboot.web.model;

import java.util.List;
import java.util.Objects;

public class Survey {
	private String id;
	private String title;
	private String description;
	private List<Question> questions;

	public Survey() {
		super();
	}

	public Survey(String id, String title, String description, List<Question> questions) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.questions = questions;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	@Override
	public String toString() {
		return "Survey [id=" + id + ", title=" + title + ", description=" + description + ", questions=" + questions
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, id, questions, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Survey other = (Survey) obj;
		return Objects.equals(description, other.description) && Objects.equals(id, other.id)
				&& Objects.equals(questions, other.questions) && Objects.equals(title, other.title);
	}

}