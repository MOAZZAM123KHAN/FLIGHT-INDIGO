package com.indigo.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Response {
	private List<?> data;
	private boolean error;
	private String message;
	
}
