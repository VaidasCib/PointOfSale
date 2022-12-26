package dropdatabase.pos.common;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.UUID;

public abstract class Repository<T extends BaseEntity> {
    @PersistenceContext(unitName = "PointOfSalePU")
    protected EntityManager em;

    private final Class<T> type;

    public Repository(Class<T> type) {
        this.type = type;
    }

    @Transactional
    public T newObject() {
        try {
            return type.getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    @Transactional
    public T save(T object) {
        em.persist(object);
        return object;
    }

    @Transactional
    public T update(T object) {
        em.merge(object);
        return object;
    }

    @Transactional
    public T delete(T object) {
        em.remove(object);
        return object;
    }

    @Transactional
    public T delete(UUID uuid) {
        T object = getObject(uuid);
        em.remove(object);
        return object;
    }

    public T getObject(UUID uuid) {
        return em.find(type, uuid);
    }

    public List<T> getList() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<T> cq = cb.createQuery(type);
        Root<T> rootEntry = cq.from(type);
        CriteriaQuery<T> all = cq.select(rootEntry);
        TypedQuery<T> allQuery = em.createQuery(all);
        return allQuery.getResultList();
    }
}
