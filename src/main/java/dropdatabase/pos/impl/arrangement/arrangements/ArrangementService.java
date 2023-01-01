package dropdatabase.pos.impl.arrangement.arrangements;

import dropdatabase.pos.common.Service;
import dropdatabase.pos.impl.arrangement.arrangements.dto.ArrangementDto;
import dropdatabase.pos.impl.arrangement.arrangements.dto.ArrangementPostDto;
import dropdatabase.pos.impl.arrangement.arrangements.dto.ArrangementPutDto;
import dropdatabase.pos.impl.arrangement.services.Services;
import dropdatabase.pos.impl.arrangement.services.ServicesRepository;
import dropdatabase.pos.impl.arrangement.services.dto.ServicesDto;
import dropdatabase.pos.impl.arrangement.services.dto.ServicesPostDto;
import dropdatabase.pos.impl.arrangement.services.dto.ServicesPutDto;
import dropdatabase.pos.impl.arrangement.timeslots.Timeslot;
import dropdatabase.pos.impl.arrangement.timeslots.TimeslotRepository;
import dropdatabase.pos.impl.employees.employee.EmployeeRepository;
import dropdatabase.pos.impl.employees.shift.Shift;

import javax.inject.Inject;
import java.util.List;
import java.util.UUID;

public class ArrangementService extends Service {
    @Inject
    private ArrangementRepository arrangementRepository;

    @Inject
    private TimeslotRepository timeslotRepository;

    public List<ArrangementDto> getAll() {
        return arrangementRepository.getList().stream().map(arrangement -> getMapper().map(arrangement, ArrangementDto.class)).toList();
    }

    public ArrangementDto getById(UUID arrangementId) {
        return getMapper().map(arrangementRepository.getObject(arrangementId), ArrangementDto.class);
    }

    public void post(ArrangementPostDto arrangementPostDto) {
        Arrangement arrangement = arrangementRepository.newObject();
        getMapper().map(arrangementPostDto, arrangement);
        arrangementRepository.save(arrangement);
    }

    public void put(UUID arrangementId, ArrangementPutDto arrangementPutDto) {
        Arrangement arrangement = arrangementRepository.getObject(arrangementId);
        getMapper().map(arrangementPutDto, arrangement);
        arrangementRepository.update(arrangement);
    }

    public void delete(UUID arrangementId) {
        arrangementRepository.delete(arrangementId);
    }

    public void addTimeslotToArrangement(UUID arrangementId, UUID timeslotId) {
        Arrangement arrangement = arrangementRepository.getObject(arrangementId);
        arrangement.getTimeslotsPresent().add(timeslotRepository.getObject(timeslotId));
        arrangementRepository.update(arrangement);
    }

    public void removeTimeslotFromArrangement(UUID arrangementId, UUID timeslotId) {
        Arrangement arrangement = arrangementRepository.getObject(arrangementId);
        arrangement.getEmployeesPresent().remove(timeslotRepository.getObject(timeslotId));
        arrangementRepository.update(arrangement);
    }
}
