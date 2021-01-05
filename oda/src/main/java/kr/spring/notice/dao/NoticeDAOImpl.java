package kr.spring.notice.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.spring.notice.domain.NoticeDTO;

@Repository("noticeDAO")
public class NoticeDAOImpl implements NoticeDAO {
	
	@Resource
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<NoticeDTO> selectList(Map<String, Object> map) {
		return sqlSession.selectList("selectListNotice", map);
	}

	@Override
	public int selectRowCount(Map<String, Object> map) {
		return sqlSession.selectOne("selectRowCountNotice", map);
	}

	@Override
	public void insert(NoticeDTO notice) {
		sqlSession.insert("insertNotice", notice);
		
	}

	@Override
	public NoticeDTO selectNotice(Integer noti_num) {
		return sqlSession.selectOne("selectNotice", noti_num);
	}

	@Override
	public void updateHit(Integer noti_num) {
		sqlSession.update("updateHitNotice",noti_num);
		
	}

	@Override
	public void update(NoticeDTO notice) {
		sqlSession.update("updateNotice", notice);
		
	}

	@Override
	public void delete(Integer noti_num) {
		sqlSession.delete("deleteNotice", noti_num);
		
	}

}
