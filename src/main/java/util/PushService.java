package util;

import java.nio.charset.Charset;

import org.json.simple.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public class PushService {
	static final String baseUrl = "https://android.googleapis.com/gcm/send";

	public static void SendPush(JSONObject param, String token) {
		RestTemplate restTemplate = new RestTemplate();
		JSONObject parameters = new JSONObject();
		parameters.put("to", token);
		parameters.put("content_available", Boolean.valueOf(true));
		parameters.put("priority", "high");
		parameters.put("data", param);

		restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));
		HttpEntity<?> requestEntity = apiClientHttpEntity("json", parameters.toString());
		restTemplate.exchange(baseUrl, HttpMethod.POST, requestEntity, String.class, new Object[0]);
	}

	private static HttpEntity<?> apiClientHttpEntity(String appType, String params) {
		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.set("Authorization", "key=AIzaSyCuJZDLGW4xr6d-gVNICgx_wf9dfUAHLoo");
		requestHeaders.set("Content-Type", "application/" + appType);
		return new HttpEntity(params, requestHeaders);
	}
}
