package com.algorithms;

import com.sun.deploy.util.StringUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;


public class SimplifyPath {

  public String simplifyPath(String path) {
    List<String> simplifiedPath = new ArrayList<String>();
    String []tokens = path.split("/");
    for(String token : tokens){
      if(token.length() == 0 || token.equals(".")) continue;
      if(token.equals("..")){
        if(simplifiedPath.size() > 0)
        simplifiedPath.remove(simplifiedPath.size()-1);
      }
      else simplifiedPath.add(token);
    }
    // NOTE the usage of StringUtils.join -> does nothing with empty collection
    //String simplifiedPathString = String.join("/",simplifiedPath, "/");

    StringJoiner sj = new StringJoiner("/");
    for(String s:simplifiedPath) sj.add(s);
    return "/" + sj.toString();
  }
}

