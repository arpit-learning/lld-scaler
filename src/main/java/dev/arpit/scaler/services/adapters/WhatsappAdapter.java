package dev.arpit.scaler.services.adapters;

import dev.arpit.scaler.exceptions.SendWhatsappMessageException;
import org.springframework.stereotype.Component;

@Component
public interface WhatsappAdapter {
    void sendWhatsappMessage(String phoneNumber, String message) throws SendWhatsappMessageException;
}
