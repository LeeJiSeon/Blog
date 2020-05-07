package com.blogproject.web.board.service;

import java.util.List;
import java.util.Map;

import com.blogproject.web.board.model.BoardVO;

public interface BoardService {
	public List<BoardVO> getBoardList() throws Exception;
}