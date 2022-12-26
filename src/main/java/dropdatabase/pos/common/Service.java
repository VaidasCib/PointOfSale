package dropdatabase.pos.common;

import org.modelmapper.ModelMapper;

public abstract class Service {
    private static ModelMapper modelMapper;

    public ModelMapper getMapper() {
        if (modelMapper == null) {
            modelMapper = new ModelMapper();
            modelMapper.getConfiguration().setAmbiguityIgnored(true);
        }
        return modelMapper;
    }
}
