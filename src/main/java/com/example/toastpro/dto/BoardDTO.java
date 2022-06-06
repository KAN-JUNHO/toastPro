package com.example.toastpro.dto;

import lombok.*;
import org.apache.ibatis.type.Alias;

import java.util.List;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class BoardDTO {
	
	
	
	public BoardDTO(Long employeeIdx, String boardType, String content, String title) {
		super();
		this.employeeIdx = employeeIdx;
		this.boardType = boardType;
		this.content = content;
		this.title = title;
	}


	@NonNull
	private Long boardIdx;
	private Long employeeIdx;
	private String boardType="";
	private String content;

	private String File="";
	
	private String insDate;
	
	private String updDate;
	
	private String state;
	
	private String title;
	private List<BoardAttachVO> attachList;

	
	
}
