import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;
import sms.SmsService;

import java.util.Map;

@Slf4j
public class AmazonTest extends Base {

    @Test
    public void amazonTest() {
        Map<String, String> urls = Map.of(
                "Orient RA-AR0004S10B", "https://www.amazon.pl/Orient-Zegarek-dzie%C5%84-RA-AR0004S10B-swobodny/dp/B0DB76FTNL/ref=sr_1_13?dib=eyJ2IjoiMSJ9.0BSEhPh-yBn8u4QGC3EuoWRSN-0fpLHQoarm2T47ClnknZinEFp0Ab94B-K2HXB7c4ACZLJl9stMQneBPL1E3lhMlThmB67MQX1w4KdBYN5DPtyf9jiaNmyK0DjFyOkTARuCfOLbU_8KD0-keUBwZRJYBy-3M5iAeQQxEPGNFsUAi5Guy4akMPfxUhWjsrkB38kts9qPjTmnn93iG8xH1mIDu7-GzsYfH5PZuH7l5_lgnKlVYpqIYTD2_EjnuA-Y5KIhYawHPH61cLLRmWi1FXxDbiV4HH1YcFOwHbT64o0.OYbz1wmaMbsSp9maCP76XKc6K3_zXShKuNqTD6cgELM&dib_tag=se&qid=1747765781&refinements=p_4%3AOrient&s=fashion&sr=1-13",
                "Orient RA-AR0005Y10B", "https://www.amazon.pl/Orient-Zegarek-RA-AR0005Y10B-Br%C4%85zowy-swobodny/dp/B07PTQSTSG/ref=sr_1_4?__mk_pl_PL=%C3%85M%C3%85%C5%BD%C3%95%C3%91&crid=3MLWPL5JT5UMJ&dib=eyJ2IjoiMSJ9.zTLMN5T8vXV-LDlbnucbg1inUabaR4NQaFCwadasCug4H91bxDMW6BxiZQCa3Oy80n7ZuVfMTBxfi18JBAzBtOuRVo_arCht5_ivDxss_TE.MmHpX5FruIjI9eK6lOU_Wz5BurSPeOxVorc7hAzviHo&dib_tag=se&keywords=RA-AR0004S10B&qid=1747765661&sprefix=ra-ar0004s10b%2Caps%2C104&sr=8-4"
        );
        for (Map.Entry<String, String> entry : urls.entrySet()) {
            String watchName = entry.getKey();
            String watchUrl = entry.getValue();
            int amazonPrice = getPrice(watchUrl);

            log.info("Watch: {} | Price: {} zł", watchName, amazonPrice);

            if (amazonPrice < 800) {
                SmsService.sendSms(amazonPrice, watchName);
            } else {
                log.info("Sms not sended");
            }
            log.info("---");
        }
    }
}
