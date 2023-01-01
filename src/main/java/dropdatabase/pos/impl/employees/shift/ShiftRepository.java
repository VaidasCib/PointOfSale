package dropdatabase.pos.impl.employees.shift;

import dropdatabase.pos.common.Repository;

import javax.ejb.Singleton;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Singleton
public class ShiftRepository extends Repository<Shift> {
    public ShiftRepository() {
        super(Shift.class);
    }
    public List<Shift> getList(Date minDate, Date maxDate, Boolean stateHoliday, String weekDay) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Shift> criteriaQuery = criteriaBuilder.createQuery(Shift.class);
        Root<Shift> root = criteriaQuery.from(Shift.class);

        List<Predicate> predicates = new ArrayList<>();
        if (minDate != null) {
            predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("shiftDate"), minDate));
        }
        if (maxDate != null) {
            predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("shiftDate"), maxDate));
        }
        if (stateHoliday != null) {
            predicates.add(criteriaBuilder.equal(root.get("stateHoliday"), stateHoliday));
        }
        if (weekDay != null) {
            predicates.add(criteriaBuilder.equal(root.get("weekDay"), weekDay));
        }
        criteriaQuery.where(predicates.toArray(new Predicate[0]));

        TypedQuery<Shift> query = em.createQuery(criteriaQuery);

        return query.getResultList();
    }
}
