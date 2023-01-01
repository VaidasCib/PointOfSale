package dropdatabase.pos.impl.arrangement.timeslots;

import dropdatabase.pos.common.Repository;

import javax.ejb.Singleton;

@Singleton
public class TimeslotRepository extends Repository<Timeslot> {
    public TimeslotRepository() {
        super(Timeslot.class);
    }
}