package dropdatabase.pos.impl.core.merchant;

import dropdatabase.pos.common.Service;
import dropdatabase.pos.impl.core.merchant.dto.MerchantDto;
import dropdatabase.pos.impl.core.merchant.dto.MerchantPutDto;

import javax.inject.Inject;
import java.util.UUID;

public class MerchantService extends Service {
    @Inject
    private MerchantRepository merchantRepository;

    public MerchantDto getById(UUID merchantId) {
        return getMapper().map(merchantRepository.getObject(merchantId), MerchantDto.class);
    }

    public void put(UUID merchantId, MerchantPutDto merchantPutDto) {
        Merchant merchant = merchantRepository.getObject(merchantId);
        getMapper().map(merchant, merchantPutDto);
        merchantRepository.update(merchant);
    }
}
