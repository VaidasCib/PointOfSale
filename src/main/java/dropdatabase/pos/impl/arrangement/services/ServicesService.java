package dropdatabase.pos.impl.arrangement.services;

import dropdatabase.pos.common.Service;
import dropdatabase.pos.impl.arrangement.services.dto.*;

import javax.inject.Inject;
import java.util.List;
import java.util.UUID;

public class ServicesService extends Service {
    @Inject
    private ServicesRepository servicesRepository;

    public List<ServicesDto> getAll() {
        return servicesRepository.getList().stream().map(services -> getMapper().map(services, ServicesDto.class)).toList();
    }

    public ServicesDto getById(UUID servicesId) {
        return getMapper().map(servicesRepository.getObject(servicesId), ServicesDto.class);
    }

    public void post(ServicesPostDto servicesPostDto) {
        Services services = servicesRepository.newObject();
        getMapper().map(servicesPostDto, services);
        servicesRepository.save(services);
    }

    public void put(UUID servicesId, ServicesPutDto servicesPutDto) {
        Services services = servicesRepository.getObject(servicesId);
        getMapper().map(servicesPutDto, services);
        servicesRepository.update(services);
    }

    public void delete(UUID serviceId) {
        servicesRepository.delete(serviceId);
    }
}
