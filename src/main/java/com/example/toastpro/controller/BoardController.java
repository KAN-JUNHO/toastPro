package com.example.toastpro.controller;


import com.example.toastpro.dto.BoardAttachVO;
import com.example.toastpro.dto.BoardDTO;
import com.example.toastpro.service.BoardService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@Log4j2
@RequestMapping("/api/board/*")
@AllArgsConstructor	
public class BoardController {

		private BoardService service;
		HttpServletRequest request;
		
//		@GetMapping("/list")
//		public void list(Model model) {
//			log.info("list");
//			model.addAttribute("list", service.getList());
//		}
		

		//board 통쨰로 가져옴
		@GetMapping("/list")
		public ResponseEntity<List<BoardDTO>>list(){
			
			BoardDTO boardDTO = new BoardDTO();
			List<BoardDTO> dtos =service.selectList(boardDTO);
			
			if (dtos.size()<1) {
				return ResponseEntity
						.status(HttpStatus.NO_CONTENT)
						.body(null);
			}else {
				return ResponseEntity
						.status(HttpStatus.OK)
						.body(dtos);
			}
			
				
		}
		
		//아이디로 조회함
		@GetMapping("/list/{employeeIdx}")
		public ResponseEntity<List<BoardDTO>> getboard_employeeIdx(@RequestParam("employeeIdx") Long employeeIdx){
			
			List<BoardDTO> boardDTO = service.gets(employeeIdx);
			
			if (boardDTO==null) {
				return ResponseEntity
						.status(HttpStatus.NO_CONTENT)
						.body(null);
			}else {
				return ResponseEntity
						.status(HttpStatus.OK)
						.body(boardDTO);
			}
		}
		
		@PostMapping("/register")
		public BoardDTO board_register(@RequestBody BoardDTO board) {
			log.info("register: " + board);
			board.setEmployeeIdx((Long)request.getSession().getAttribute("employeeIdx"));
			
			service.register(board);
	
			
			return board;
		}
		
//		@GetMapping("/get")
//		public void get(@RequestParam("bno") Long bno, Model model) {
//			log.info("/get");
//			model.addAttribute("board", service.get(bno));
//		}
		
		@PutMapping("/modify")
		public ResponseEntity<BoardDTO>  modify(@RequestBody BoardDTO board) {
			log.info("modify: " + board);
			
			boolean check =service.modify(board);
			if(check == false) {
				// �떎�뙣�떆 409 - �빐�떦 �슂泥��쓽 泥섎━媛� 鍮꾩��땲�뒪 濡쒖쭅�긽 遺덇��뒫�븯嫄곕굹 紐⑥닚�씠 �깮湲� 寃쎌슦
				return ResponseEntity
						.status(HttpStatus.CONFLICT)
						.body(null);
			} else {
				// �꽦怨듭떆 200 - OK
				return ResponseEntity
						.status(HttpStatus.OK)
						.body(board);
			}
		}
		
		@PostMapping("/remove")
		public String remove(@RequestParam("boardIdx") Long boardIdx) {
			log.info("remove: " + boardIdx);
			List<BoardAttachVO> attachList = service.getAttachList(boardIdx);
			if(service.remove(boardIdx)) {
				deleteFiles(attachList);
			}
			return "ok";
		}
		private void deleteFiles(List<BoardAttachVO> attachList) {
		    if (attachList==null||attachList.size()==0) {
		      return;
		    }
		    log.info("delete attach files.......");
		    log.info(attachList);
		    attachList.forEach(attach->{
		      try {
		        Path file = Paths.get("c:/upload/"+attach.getUploadpath()+"/"+attach.getUuid()+"_"+attach.getFileName());
		        Files.deleteIfExists(file);
		        if (Files.probeContentType(file).startsWith("image")) {
		          Path thumbNail = Paths.get("c:/upload/"+attach.getUploadpath()+"/s_"+attach.getUuid()+"_"+attach.getFileName());
		          Files.delete(thumbNail);
		        }
		      }catch (Exception e) {
		        log.error("delete file error : " +e.getMessage());
		      }
		    });
		  }
		@GetMapping(value = "/getAttachList" ,produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<List<BoardAttachVO>> getAttachList(@RequestParam("boardIdx") Long boardIdx){
			return new ResponseEntity<>(service.getAttachList(boardIdx),HttpStatus.OK);
		}
		
		@GetMapping("/{boardIdx}")
	    public ResponseEntity<BoardDTO> getboard_eboardIdx(@PathVariable("boardIdx") Long boardIdx){
	      log.info(boardIdx);
	      BoardDTO board = service.select(boardIdx);
	      
	      if (board==null) {
	        return ResponseEntity
	            .status(HttpStatus.NO_CONTENT)
	            .body(null);
	      }else {
	        return ResponseEntity
	            .status(HttpStatus.OK)
	            .body(board);
	      }
	    }
}
