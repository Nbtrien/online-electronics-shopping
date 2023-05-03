package com.shopping.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AbstractModel<T> {
	private int id;
	private Timestamp createdAt;
	private Timestamp modifiedAt;
	private int[] ids;

	public int[] getIds() {
		return ids;
	}

	public void setIds(int[] ids) {
		this.ids = ids;
	}

	public List<T> getListResult() {
		return listResult;
	}

	public void setListResult(List<T> listResult) {
		this.listResult = listResult;
	}

	private List<T> listResult = new ArrayList<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Timestamp getModifiedAt() {
		return modifiedAt;
	}

	public void setModifiedAt(Timestamp modifiedAt) {
		this.modifiedAt = modifiedAt;
	}

}
