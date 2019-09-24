package com.coxautodev.graphql.tools.example.types;

import java.util.List;

public class Page<T> {

	private List<T> content;

	private long totalElements;

	public Page() {
	}

	public Page(List<T> content, long totalElements) {
		this.content = content;
	}

	public List<T> getContent() {
		return content;
	}

	public void setContent(List<T> content) {
		this.content = content;
	}

	public int getNumberOfElements() {
		return this.getContent().size();
	}

	public long getTotalElements() {
		return this.totalElements;
	}

}
