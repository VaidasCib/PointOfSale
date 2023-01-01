package dropdatabase.pos.impl.arrangement.timeslots;

import dropdatabase.pos.common.Service;
import dropdatabase.pos.impl.arrangement.arrangements.dto.ArrangementDto;
import dropdatabase.pos.impl.arrangement.timeslots.dto.TimeslotDto;
import dropdatabase.pos.impl.arrangement.timeslots.dto.TimeslotPostDto;
import dropdatabase.pos.impl.core.user.User;
import dropdatabase.pos.impl.core.user.dto.UserPostDto;
import dropdatabase.pos.impl.employees.shift.dto.ShiftDto;

import javax.inject.Inject;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class TimeslotService extends Service {
    @Inject
    private TimeslotRepository timeslotRepository;

    public void post(TimeslotPostDto timeslotPostDto) {
        Timeslot timeslot = timeslotRepository.newObject();
        getMapper().map(timeslotPostDto, timeslot);
        timeslotRepository.save(timeslot);
    }

    public List<TimeslotDto> getAll() {
        return timeslotRepository.getList().stream().map(timeslot -> getMapper().map(timeslot, TimeslotDto.class)).toList();
    }
    public TimeslotDto getById(UUID timeslotId) {
        return getMapper().map(timeslotRepository.getObject(timeslotId), TimeslotDto.class);
    }

    public void put(UUID timeslotId, TimeslotPostDto timeslotPutDto) {
        Timeslot timeslot = timeslotRepository.getObject(timeslotId);
        getMapper().map(timeslot, timeslotPutDto);
        timeslotRepository.update(timeslot);
    }

    public void delete(UUID timeslotId) {
        timeslotRepository.delete(timeslotId);
    }
}