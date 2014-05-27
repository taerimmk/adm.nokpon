package com.june.app.board.repository.jpa;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.june.app.board.model.BoardMaster;
import com.june.app.board.repository.BoardMasterRepository;

@Repository
public class BoardMasterRepositoryImpl implements BoardMasterRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	@Cacheable(value = "bbsMst")
	@SuppressWarnings("unchecked")
	public Collection<BoardMaster> boardMasterListAll() {
		Query query = this.em
				.createQuery("SELECT boardMaster FROM BoardMaster boardMaster WHERE boardMaster.useYn ='Y'");
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<BoardMaster> boardMasterList(BoardMaster vo) {

		int pageSize = vo.getPageSize();
		int pageNumber = (int) vo.getPageIndex();

		String queryString = "SELECT boardMaster FROM BoardMaster boardMaster ORDER BY boardMaster.regiDate desc";
		Query query = this.em.createQuery(queryString);
		query.setFirstResult((pageNumber - 1) * pageSize);
		query.setMaxResults(pageSize);

		return query.getResultList();
	}

	@Override
	public long boardMasterListCnt(BoardMaster vo) {

		String queryString = "SELECT count(*) FROM BoardMaster boardMaster ";
		Query query = this.em.createQuery(queryString);
		Long count = (Long) query.getSingleResult();
		return count;

	}

	@Override
	public void save(BoardMaster vo) {
		if (vo.getBbsId() == null) {
			this.em.persist(vo);
		} else {
			this.em.merge(vo);
			this.em.flush();
		}
	}

}
