package dev.tknapp.philodelight.util;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public final class ObjectMapperUtils {
    
    private ObjectMapperUtils(){}
    
    private static final ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false).findAndRegisterModules();
    
    
    public static ObjectMapper getObjectMapper() {
        return objectMapper;
    }
}
