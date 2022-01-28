package br.com.map.service;

import br.com.map.domain.exception.ApiMapsGeoCodeFileIsEmptyException;
import br.com.map.domain.exception.ApiMapsGeoCodePathNotFoundException;
import br.com.map.utils.ApiMapsGeoCodeConstants;
import br.com.map.utils.ApiMapsGeoCodeUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Properties;

@Service
public class ApiMapsGeoCodeAuthentication {

    private ApiMapsGeoCodeAuthentication() {
    }

    public static Properties getCredential() throws ApiMapsGeoCodePathNotFoundException {
        Properties prop = new Properties();
        InputStream file = null;
        try {
            file = ApiMapsGeoCodeUtils.class.getResource(ApiMapsGeoCodeConstants.PATH).openStream();
            prop.load(file);
            file.close();
        } catch (IOException | NullPointerException e) {
            throw new ApiMapsGeoCodePathNotFoundException("configuration file not found");
        }
        String url = prop.getProperty(ApiMapsGeoCodeConstants.PROP_URL);
        String key = prop.getProperty(ApiMapsGeoCodeConstants.PROP_KEY);
        if (url.length() == 0 || key.length() == 0) {
            throw new ApiMapsGeoCodeFileIsEmptyException("file is empty or notFound key or url");
        }
        return desencrypt(url, key);
    }

    private static Properties desencrypt(String url, String key) {
        Properties prop = new Properties();
        String urlOut = new String(Base64.getDecoder().decode(url), StandardCharsets.UTF_8);
        String keyOut = new String(Base64.getDecoder().decode(key), StandardCharsets.UTF_8);
        prop.setProperty(ApiMapsGeoCodeConstants.PROP_URL, urlOut);
        prop.setProperty(ApiMapsGeoCodeConstants.PROP_KEY, keyOut);

        return prop;
    }
}
