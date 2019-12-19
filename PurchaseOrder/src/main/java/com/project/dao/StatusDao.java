package com.project.dao;

import java.util.List;

import com.project.model.Status;

public interface StatusDao {
	public boolean addStatus(Status statusObj);

	public boolean updateStatus(String statusName);

	public List<Status> viewStatus();
}