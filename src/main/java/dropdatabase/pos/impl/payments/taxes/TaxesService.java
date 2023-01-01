package dropdatabase.pos.impl.payments.taxes;

import dropdatabase.pos.common.Service;
import dropdatabase.pos.impl.employees.role.Role;
import dropdatabase.pos.impl.employees.role.dto.RolePostDto;
import dropdatabase.pos.impl.payments.taxes.dto.TaxesDto;
import dropdatabase.pos.impl.payments.taxes.dto.TaxesPostDto;


import javax.inject.Inject;
import java.util.List;
import java.util.UUID;

public class TaxesService extends Service {
    @Inject
    private TaxesRepository taxesRepository;
    public void post(TaxesPostDto taxesPostDto) {
        Taxes taxes = taxesRepository.newObject();
        getMapper().map(taxesPostDto, taxes);
        taxesRepository.save(taxes);
    }
    public List<TaxesDto> getAll() {
        return taxesRepository.getList().stream().map(taxes -> getMapper().map(taxes, TaxesDto.class)).toList();
    }
    public void put(UUID taxId, TaxesPostDto taxesPostDto) {
        Taxes taxes = taxesRepository.getObject(taxId);
        getMapper().map(taxesPostDto, taxes);
        taxesRepository.update(taxes);
    }
    public void delete(UUID taxId) {
        taxesRepository.delete(taxId);
    }
}