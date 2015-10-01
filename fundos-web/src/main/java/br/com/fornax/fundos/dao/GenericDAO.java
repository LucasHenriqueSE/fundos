package br.com.fornax.fundos.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public abstract class GenericDAO {

	@PersistenceContext
	private EntityManager em;

	/**Insere o objeto no banco de dados
	 * @param object
	 */
	public void inserir(Object object) {
		em.persist(object);
	}

	/**Edita o objeto no banco de dados
	 * @param object
	 */
	public void editar(Object object) {
		em.merge(object);
	}

	/**Exclui o objeto do banco de dados
	 * @param object
	 */
	public void excluir(Object object) {
		try {
			Object entity = em.merge(object);
			em.remove(entity);
		} catch (PersistenceException e) {
			e.printStackTrace();
		}
	}

	/**Lista todos os objetos do banco de dados de acordo com a query passada.
	 * @param queryString
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Object> listarTodos(String queryString) {
		Query query = em.createQuery(queryString);
		return query.getResultList();
	}
	
	
	/**Faz uma pesquisa no banco de dados de acordo com o id passado.
	 * @param object
	 * @param id
	 * @return
	 */
	public Object listarPorId(Object object, int id) {
		return em.find(object.getClass(), id);
	}

}
