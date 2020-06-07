package com.blogproject.web.board.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blogproject.common.Pagination;
import com.blogproject.web.board.dao.BoardDAO;
import com.blogproject.web.board.model.BoardVO;
import com.blogproject.web.error.controller.NotFoundException;

@Service
public class BoardServiceImpl implements BoardService {
	@Inject
	private BoardDAO boardDAO;
	
	@Override
	public List<BoardVO> getBoardList(Pagination pagination) throws Exception {
		return boardDAO.getBoardList(pagination);
	}
	
	@Override
	public void insertBoard(BoardVO boardVO) throws Exception {
		boardDAO.insertBoard(boardVO);
	}
	
	@Override
	public void updateBoard(BoardVO boardVO) throws Exception {
		boardDAO.updateBoard(boardVO);
	}
	
	@Transactional
	@Override
	public BoardVO getBoardContent(int bid) throws Exception {
		BoardVO boardVO= new BoardVO();
		
		boardDAO.updateViewCnt(bid);
		boardVO = boardDAO.getBoardContent(bid);
		
//		try {
//			boardVO.setBid(bid);
//			boardVO.setCate_cd("111111111111111111111111111111111");
//			boardDAO.updateBoard(boardVO);
//		} catch(RuntimeException e) {
//			throw new NotFoundException();
//		}
		return boardVO;
	}
	
	@Override
	public void deleteBoard(int bid) throws Exception {
		boardDAO.deleteBoard(bid);
	}
	
	@Override
	public int getBoardListCnt() throws Exception {
		return boardDAO.getBoardListCnt();
	}
}