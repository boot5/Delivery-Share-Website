package kr.spring.notice.service;

import java.util.List;
import java.util.Map;

import kr.spring.notice.domain.NoticeDTO;

public interface NoticeService {
	public List<NoticeDTO> selectList(Map<String,Object> map);
	public int selectRowCount(Map<String,Object> map);
	public void insert(NoticeDTO notice);
	public NoticeDTO selectNotice(Integer noti_num);
	public void updateHit(Integer noti_num);
	public void update(NoticeDTO notice);
	public void delete(Integer noti_num);
}
