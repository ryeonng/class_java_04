package http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpGetClient {

	public static void main(String[] args) {

		// 자바 기본 코드로 HTTP 요청을 만들어 보자.
		
		// * HTTP 통신을 하기 위한 준비물
		// 서버 주소(경로) 준비.
		String urlString = "https://ryeonng.tistory.com/";
		
		// 1. URL 클래스를 만들어 준다.
		// 2. Connection 객체를 만들어 준다. (URL -> 멤버로 Connection 객체를 뽑을 수 있다.)
		try {
			URL url = new URL(urlString);
			// url.openConnection() 연결 요청 진행
			HttpURLConnection conn = (HttpURLConnection)url.openConnection(); // 다운 캐스팅
			
			// 추가 설정을 할 수 있다.
			// Method 방식 설정(약속) : GET 요청은 해당 서버가 가진 자원을 요청하는 약속
			conn.setRequestMethod("GET");
			
			// HTTP 응답 메시지에서 데이터를 추출할 수 있다.
			int responseCode = conn.getResponseCode();
			System.out.println("HTTP CODE : " + responseCode);

			BufferedReader brIn = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			
			String inputLine;
			StringBuffer responseBuffer = new StringBuffer();
			
			while( (inputLine = brIn.readLine()) != null ) {
				responseBuffer.append(inputLine);
			}
			
			brIn.close();
			
			//System.out.println(responseBuffer.toString());
			String[] strHtmls = responseBuffer.toString().split("\\s");
			System.out.println("index count : " + strHtmls.length);
			
			for(String word : strHtmls) {
				System.out.println(word);
			}
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	} // end of main

}
