package com.blogproject.web.board.service;

import java.util.List;
import java.util.Map;

import com.blogproject.common.Pagination;
import com.blogproject.web.board.model.BoardVO;

public interface BoardService {
	public List<BoardVO> getBoardList(Pagination pagination) throws Exception;
	public void insertBoard(BoardVO boardVO) throws Exception;
	public void updateBoard(BoardVO boardVO) throws Exception;
	public BoardVO getBoardContent(int bid) throws Exception;
	public void deleteBoard(int bid) throws Exception;
	//총 게시글 개수 확인
	public int getBoardListCnt() throws Exception;
}