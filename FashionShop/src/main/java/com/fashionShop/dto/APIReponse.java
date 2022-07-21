package com.fashionShop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class APIReponse<T> {
	int recordCount;
	T response;
	public APIReponse(int recordCount, T response) {
		super();
		this.recordCount = recordCount;
		this.response = response;
	}
	
	
}
