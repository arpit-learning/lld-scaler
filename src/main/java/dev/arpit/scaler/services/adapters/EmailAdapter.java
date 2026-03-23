package dev.arpit.scaler.services.adapters;

import dev.arpit.scaler.exceptions.SendEmailException;
import org.springframework.stereotype.Component;

@Component
public interface EmailAdapter {
    void sendEmail(String email, String message) throws SendEmailException;
}
