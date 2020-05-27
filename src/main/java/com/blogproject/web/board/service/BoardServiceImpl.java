package com.blogproject.web.board.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.blogproject.web.board.dao.BoardDAO;
import com.blogproject.web.board.model.BoardVO;
import com.blogproject.web.error.controller.NotFoundException;

@Service
public class BoardServiceImpl implements BoardService {
	@Inject
	private BoardDAO boardDAO;
	
	@Override
	public List<BoardVO> getBoardList() throws Exception {
		return boardDAO.getBoardList();
	}
	
	@Override
	public void insertBoard(BoardVO boardVO) throws Exception {
		boardDAO.insertBoard(boardVO);
	}
	
	@Override
	public void updateBoard(BoardVO boardVO) throws Exception {
		boardDAO.updateBoard(boardVO);
	}
	
	@Override
	public BoardVO getBoardContent(int bid) throws Exception {
//		boardDAO.updateViewCnt(bid);
//		return boardDAO.getBoardContent(bid);
		BoardVO boardVO= new BoardVO();
		boardDAO.updateViewCnt(bid);
		
		try {
			boardVO.setBid(bid);
			boardVO.setCate_cd("111111111111111111111111111111111");
			boardDAO.updateBoard(boardVO);
		} catch(RuntimeException e) {
			throw new NotFoundException();
		}
		return boardVO;
	}
	
	@Override
	public void deleteBoard(int bid) throws Exception {
		boardDAO.deleteBoard(bid);
	}
}