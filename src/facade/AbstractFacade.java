package facade;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import model.Livro;

public abstract class AbstractFacade<T> {

    private Class<T> entityClass;

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;

    }

    protected abstract EntityManager getEntityManager();

    public void create(T entity) {
        // getEntityManager().persist(entity);

        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
        em.close();

    }

    public void edit(T entity) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.merge(entity);
        em.getTransaction().commit();
        em.close();
    }

    public void remove(T entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    public T find(Object id) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.getTransaction().commit();
        T entity = getEntityManager().find(entityClass, id);
        em.close();
        return entity;
    }

    public List<T> findAll() {
        // EntityManager em = getEntityManager();
        //em.getTransaction().begin();
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
        // em.close();

    }

    public List<T> findRange(int[] range) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(range[1] - range[0] + 1);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    public List<T> findAllWithValue(String collumn, String value) {
        EntityManager em = getEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root entity = cq.from(entityClass);
        cq.select(entity).where(cb.like(entity.get(collumn), "%" + value + "%"));
        Query query = em.createQuery(cq);
        List<T> result = query.getResultList();
        return result;
    }

    public List<T> findAllEqualValue(String collumn, String value) {
        EntityManager em = getEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root entity = cq.from(entityClass);
        cq.select(entity).where(cb.equal(entity.get(collumn), value));
        Query query = em.createQuery(cq);
        List<T> result = query.getResultList();
        return result;
    }

    public List<T> findAllWithValue(String collumn1, String value1, String collumn2, String value2) {
//        EntityManager em = getEntityManager();
//        CriteriaBuilder cb = em.getCriteriaBuilder();
//        CriteriaQuery cq = cb.createQuery();
//        Root entity = cq.from(entityClass);
//        cq.select(entity).where(cb.like(entity.get(collumn1), "%" + value1 + "%"));
//        cq.select(entity).where(cb.equal(entity, entity))
//        Query query = em.createQuery(cq);
//        List<T> result = query.getResultList();
//        return result;

        EntityManager em = getEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root e = cq.from(entityClass);
        cq.where(cb.equal(e.get(collumn1), cb.parameter(String.class, "first")),
                cb.equal(e.get(collumn2), cb.parameter(String.class, "last")));
        Query query = em.createQuery(cq);
        query.setParameter("first", value1);
        query.setParameter("last", value2);
        List<T> resultados = query.getResultList();

        return resultados;
    }

    public int count() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }

}
