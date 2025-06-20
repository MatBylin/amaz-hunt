package sms;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SmsService {
    private static final String ACCOUNT_SID = System.getenv("TWILIO_ACCOUNT_SID");
    private static final String AUTH_TOKEN = System.getenv("TWILIO_AUTH_TOKEN");

    public static void sendSms(int price, String name) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message.creator(
                        new PhoneNumber(System.getenv("TWILIO_RECEIVER")),
                        new PhoneNumber("+19788006389"),
                        "%s | %s".formatted(price, name))
                .create();

        log.info("SMS sent with SID: {}", message.getSid());
    }
}
