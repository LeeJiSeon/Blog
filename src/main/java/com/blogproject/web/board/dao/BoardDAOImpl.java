package com.blogproject.web.board.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.blogproject.common.Pagination;
import com.blogproject.web.board.model.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO {
	
	@Inject
	private SqlSession sqlSession;
	
	@Override
	public List<BoardVO> getBoardList(Pagination pagination) throws Exception {
		return sqlSession.selectList("com.blogproject.web.board.boardMapper.getBoardList", pagination);
	}
	
	@Override
	public BoardVO getBoardContent(int bid) throws Exception {
		return sqlSession.selectOne("com.blogproject.web.board.boardMapper.getBoardContent", bid);
	}
	
	@Override
	public int getBoardListCnt() throws Exception {
		return sqlSession.selectOne("com.blogproject.web.board.boardMapper.getBoardListCnt");
	}
	
	@Override
	public int insertBoard(BoardVO boardVO) throws Exception {
		return sqlSession.insert("com.blogproject.web.board.boardMapper.inserBoard", boardVO);
	}
	
	@Override
	public int updateBoard(BoardVO boardVO) throws Exception {
		return sqlSession.update("com.blogproject.web.board.boardMapper.updateBoard", boardVO);
	}
	
	@Override
	public int deleteBoard(int bid) throws Exception {
		return sqlSession.update("com.blogproject.web.board.boardMapper.deleteBoard", bid);
	}
	
	@Override
	public int updateViewCnt(int bid) throws Exception {
		return sqlSession.update("com.blogproject.web.board.boardMapper.updateViewCnt", bid);
	}
	
}