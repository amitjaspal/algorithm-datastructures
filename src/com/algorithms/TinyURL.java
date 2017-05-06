package com.algorithms;

import java.util.HashMap;
import java.util.Map;


public class TinyURL {

  Map<String, String> encodedURL = new HashMap<>();
  Map<String, String> decodedURL = new HashMap<>();
  Map<String, String> uniqueURL = new HashMap<>();
  String HOST_NAME = "http://tinyurl.com/";
  // Encodes a URL to a shortened URL.
  public String encode(String longUrl) {

    String possibleCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    int len = possibleCharacters.length();
    StringBuffer candidateEncoding = null;
    while (candidateEncoding == null || uniqueURL.get(candidateEncoding) != null) {
      candidateEncoding = new StringBuffer();

      for (int i = 0; i < 6; i++) {
        int idx = 0 + (int) (Math.random() * ((len - 0)));
        candidateEncoding.append(possibleCharacters.charAt(idx));
      }
    }
    encodedURL.put(longUrl, candidateEncoding.toString());
    decodedURL.put(HOST_NAME + candidateEncoding.toString(), longUrl);
    uniqueURL.put(candidateEncoding.toString(), "1");
    return HOST_NAME + candidateEncoding.toString();
  }

  // Decodes a shortened URL to its original URL.
  public String decode(String shortUrl) {
    return decodedURL.get(shortUrl);
  }
}
