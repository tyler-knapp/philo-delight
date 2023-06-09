package dev.tknapp.philodelight.login.pipeline;

import dev.tknapp.philodelight.login.model.RegistrationRequest;
import dev.tknapp.philodelight.login.model.RegistrationResponse;

public interface RegistrationPipeline {
   
   RegistrationResponse registerAccount(RegistrationRequest request);
}
