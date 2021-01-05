package kr.spring.notice.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.spring.notice.dao.NoticeDAO;
import kr.spring.notice.domain.NoticeDTO;

@Service("noticeService")
public class NoticeServiceImpl implements NoticeService{

	@Resource
	private NoticeDAO noticeDAO;
	
	@Override
	public List<NoticeDTO> selectList(Map<String, Object> map) {
		return noticeDAO.selectList(map);
	}

	@Override
	public int selectRowCount(Map<String, Object> map) {
		return noticeDAO.selectRowCount(map);
	}

	@Override
	public void insert(NoticeDTO notice) {
		noticeDAO.insert(notice);
		
	}

	@Override
	public NoticeDTO selectNotice(Integer noti_num) {
		return noticeDAO.selectNotice(noti_num);
	}

	@Override
	public void updateHit(Integer noti_num) {
		noticeDAO.updateHit(noti_num);
		
	}

	@Override
	public void update(NoticeDTO notice) {
		noticeDAO.update(notice);
		
	}

	@Override
	public void delete(Integer noti_num) {
		noticeDAO.delete(noti_num);
		
	}

}
