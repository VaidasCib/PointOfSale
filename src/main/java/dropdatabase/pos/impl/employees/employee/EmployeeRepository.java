package dropdatabase.pos.impl.employees.employee;

import dropdatabase.pos.common.Repository;

import javax.ejb.Singleton;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Singleton
public class EmployeeRepository extends Repository<Employee> {
    public EmployeeRepository() {
        super(Employee.class);
    }

    public List<Employee> getList(BigDecimal minSalary, BigDecimal maxSalary, UUID roleId, Boolean onHoliday) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
        Root<Employee> root = criteriaQuery.from(Employee.class);

        List<Predicate> predicates = new ArrayList<>();

        if (minSalary != null) {
            predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("salary"), minSalary));
        }

        if (maxSalary != null) {
            predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("salary"), maxSalary));
        }

        if (roleId != null) {
            predicates.add(criteriaBuilder.equal(root.get("role").get("id"), roleId));
        }

        if (onHoliday != null) {
            predicates.add(criteriaBuilder.equal(root.get("onHoliday"), onHoliday));
        }

        criteriaQuery.where(predicates.toArray(new Predicate[0]));

        TypedQuery<Employee> query = em.createQuery(criteriaQuery);

        return query.getResultList();
    }
}
