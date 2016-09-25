package model;

/**
 * Created by Yuriy on 23.09.2016.
 */
public class MainModel {
    public static double round(double numb, int degree){
        numb = numb * degree;
        numb  = Math.round(numb);
        return numb/degree;
    }
//    public static void main(String[] args){
//        System.out.println(MainModel.round(13.455,10));
//    }
}
