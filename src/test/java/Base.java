import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Objects;

import static contants.BaseConstants.*;

@Slf4j
public class Base {
    private static final String PRICE_LOCATOR = "#corePriceDisplay_desktop_feature_div .a-price-whole";

    protected int getPrice(String url) {
        try {
            Document document = Jsoup.connect(url)
                    .userAgent(USER_AGENT)
                    .header(ACCEPT_LANGUAGE, LANGUAGE)
                    .get();

            Elements elements = document.select(PRICE_LOCATOR);
            if (elements.isEmpty()) {
                return -100;
            }

            return parsePrice(Objects.requireNonNull(elements.first()).text());

        } catch (IOException e) {
            throw new IllegalStateException("Connection issue with URL: " + url, e);
        }
    }

    public int parsePrice(String priceString) {
        String cleaned = priceString.replaceAll("\\D", "");
        return Integer.parseInt(cleaned);
    }
}
