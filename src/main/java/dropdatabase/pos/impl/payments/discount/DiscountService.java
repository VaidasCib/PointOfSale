package dropdatabase.pos.impl.payments.discount;

import dropdatabase.pos.common.Service;
import dropdatabase.pos.impl.employees.shift.dto.ShiftDto;
import dropdatabase.pos.impl.payments.discount.dto.DiscountDto;
import dropdatabase.pos.impl.payments.discount.dto.DiscountPostDto;
import dropdatabase.pos.impl.payments.taxes.dto.TaxesDto;

import javax.inject.Inject;
import java.util.List;
import java.util.UUID;

public class DiscountService extends Service {
    @Inject
    private DiscountRepository discountRepository;
    public void post(DiscountPostDto discountPostDto) {
        Discount discount = discountRepository.newObject();
        getMapper().map(discountPostDto, discount);
        discountRepository.save(discount);
    }

    public List<DiscountDto> getAll() {
        return discountRepository.getList().stream().map(discount -> getMapper().map(discount, DiscountDto.class)).toList();
    }
    public DiscountDto getById(UUID discountId) {
        return getMapper().map(discountRepository.getObject(discountId), DiscountDto.class);
    }


    public void put(UUID discountId, DiscountPostDto discountPostDto) {
        Discount discount = discountRepository.getObject(discountId);
        getMapper().map(discountPostDto, discount);
        discountRepository.update(discount);
    }
    public void delete(UUID discountId) {
        discountRepository.delete(discountId);
    }
}
