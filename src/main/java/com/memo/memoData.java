package com.memo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="memoData")

public class memoData {
	@Id

	//@GeneratedValue(strategy = GenerationType.AUTO)
	@Getter
	@Setter
	@Column(length = 50, nullable = false)
	private String id;

	@Getter
	@Setter
	@Column(length = 200)
	private String Memo;

	@Getter
	@Setter
	@Column
	private Date date;

	/*public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMemo() {
		return Memo;
	}

	public void setMemo(String Memo) {
		this.Memo = Memo;
	}*/

}
