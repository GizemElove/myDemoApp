
package com.mycompany.app;
import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;

import spark.template.mustache.MustacheTemplateEngine;

public class App

{

public static String calculateGrades(String[] names,Integer[] mid1,Integer[] mid2,Integer[] finals){
    if(names == null){
      return "names null";
    }
    if(mid1 == null){
      return "mid1 null";
    }
    if(mid2 == null){
      return "mid2 null";
    }
    if(finals == null){
      return "finals null";
    }
		if(names.length != mid1.length || names.length != mid2.length || names.length != finals.length){
			return "error";
		}
    String result = "";
		for(int i= 0 ; i < names.length ; i++)
		{
      if(names[i] == ""){
        continue;
      }
      if(!names[i].equals("")){
				result =   result + "," + (0.4 * finals[i] + 0.3 * mid1[i] + 0.3 * mid2[i]) +" ";
		}
    }
		
		return result;
	}
    public static boolean search(ArrayList<Integer> array, int e) {

      System.out.println("inside search");

      if (array == null) return false;

      for (int elt : array) {

        if (elt == e) return true;

      }

      return false;

    }

    public static void main(String[] args) {

        port(getHerokuAssignedPort());

        get("/", (req, res) -> "Hello, World");

        post("/compute", (req, res) -> {


          String namesStr = req.queryParams("names");
          String mid1Str = req.queryParams("mid1");
          String mid2Str = req.queryParams("mid2");
          String finalsStr = req.queryParams("finals");

         String[] nameArr = namesStr.split(",");
         int size = nameArr.length;
         String[] temp = mid1Str.split(",");

         Integer[] mid1Arr = new Integer[size];
         for(int i = 0 ; i < size ; i++){
           if(temp[i].equals("")){
             mid1Arr[i] = 0;
           }else{
             mid1Arr[i] = Integer.parseInt(temp[i]);
           }
         }

         temp = mid2Str.split(",");

         Integer[] mid2Arr = new Integer[size];
         for(int i = 0 ; i < size ; i++){
          if(temp[i].equals("")){
             mid2Arr[i] = 0;
           }else{
             mid2Arr[i] = Integer.parseInt(temp[i]);
           }
         }

        temp = finalsStr.split(",");

         Integer[] finalsArr = new Integer[size];
         for(int i = 0 ; i < size ; i++){
           if(temp[i].equals("")){
             finalsArr[i] = 0;
           }else{
             finalsArr[i] = Integer.parseInt(temp[i]);
           }
         }

         
         Map map = new HashMap();

          map.put("grades", calculateGrades(nameArr,mid1Arr,mid2Arr,finalsArr));
          map.put("names", namesStr);

          return new ModelAndView(map, "compute.mustache");

        }, new MustacheTemplateEngine());


        get("/compute",

            (rq, rs) -> {

              Map map = new HashMap();

              map.put("grades", "");
             map.put("names",  "");

              return new ModelAndView(map, "compute.mustache");

            },

            new MustacheTemplateEngine());

    }

    static int getHerokuAssignedPort() {

        ProcessBuilder processBuilder = new ProcessBuilder();

        if (processBuilder.environment().get("PORT") != null) {

            return Integer.parseInt(processBuilder.environment().get("PORT"));

        }

        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)

    }

}