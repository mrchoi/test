package com.mobilepark.uxcutor.userContentsMap.model;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class UserContentsMap implements Serializable {

	private static final long serialVersionUID = 1L;

	private String user_id;

	private int contents_id;

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public int getContents_id() {
		return contents_id;
	}

	public void setContents_id(int contents_id) {
		this.contents_id = contents_id;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}
}
