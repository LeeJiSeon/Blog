package com.blogproject.web.board.dao;

import java.util.List;

//import com.blogproject.common.Pagination;
import com.blogproject.common.Search;
import com.blogproject.web.board.model.BoardVO;

public interface BoardDAO {
	public List<BoardVO> getBoardList(Search search) throws Exception;
	public BoardVO getBoardContent(int bid) throws Exception;
	public int getBoardListCnt(Search search) throws Exception;
	public int insertBoard(BoardVO boardVO) throws Exception;
	public int updateBoard(BoardVO boardVO) throws Exception;
	public int deleteBoard(int bid) throws Exception;
	public int updateViewCnt(int bid) throws Exception;
}