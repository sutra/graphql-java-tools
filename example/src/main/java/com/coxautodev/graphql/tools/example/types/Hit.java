package com.coxautodev.graphql.tools.example.types;

import java.io.Serializable;
import java.util.Map;

public class Hit<T> implements Serializable {

	private static final long serialVersionUID = 2018112701L;

	private T source;
	private float score;
	private Map<String, String[]> highlight;

	public Hit() {
		this(null, 1f);
	}

	public Hit(T source) {
		this(source, 1f);
	}

	public Hit(T source, float score) {
		this.source = source;
		this.score = score;
	}

	public T getSource() {
		return source;
	}

	public void setSource(T source) {
		this.source = source;
	}

	public float getScore() {
		return score;
	}

	public void setScore(float score) {
		this.score = score;
	}

	public Map<String, String[]> getHighlight() {
		return highlight;
	}

	public void setHighlight(Map<String, String[]> highlight) {
		this.highlight = highlight;
	}

}
