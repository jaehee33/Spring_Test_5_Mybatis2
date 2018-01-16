package com.iu.qna;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.iu.board.BoardDAO;
import com.iu.board.BoardDTO;

@Repository
public class QnaDAO implements BoardDAO {
	
	@Inject
	private SqlSession sqlsession;
	private final String NAMESPACE="QnaMapper.";

	@Override
	public List<BoardDTO> selectList() throws Exception {
		return sqlsession.selectList(NAMESPACE+"selectList");
	}

	@Override
	public BoardDTO selectOne(int num) throws Exception {
		return sqlsession.selectOne(NAMESPACE+"selectOne", num);
	}

	@Override
	public int insert(BoardDTO boardDTO) throws Exception {
		return sqlsession.insert(NAMESPACE+"insert", boardDTO);
	}

	@Override
	public int update(BoardDTO boardDTO) throws Exception {
		return sqlsession.update(NAMESPACE+"update", boardDTO);
	}

	@Override
	public int delete(int num) throws Exception {
		return sqlsession.delete(NAMESPACE+"delete", num);
	}
	public int replyup(BoardDTO boardDTO) throws Exception{
		return sqlsession.update(NAMESPACE+"replyup", boardDTO);
	}
	public int replyin(BoardDTO boardDTO) throws Exception{
		return sqlsession.insert(NAMESPACE+"replyin", boardDTO);
	}
}
