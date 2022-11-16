package serialization;

import lab1.Place;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SerializerTXT implements Serializer {

    private String toString(Place l) {
        return
                "regionName-" + l.getRegionName() + "-" +
                "streetName-" + l.getStreetName() + "-" +
                "houseNumber-" + l.getHouseNumber()
                ;
    }

    private String toString(List<Place> l) {
        String res = "";
        for (int i=0; i<l.size(); i++) {
            res += toString(l.get(i));
            if (i+1 < l.size()) {
                res += ";";
            }
        }
        return res;
    }

    private Place fromString(String s){
        String [] obj = s.split("-");
        Place res = new Place();
        res.setRegionName(obj[1]);
        res.setStreetName(obj[3]);
        res.setHouseNumber(obj[5]);
        return res;
    }

    private  List<Place> fromStringList(String s){
        String [] obj = s.split(";");
        List<Place> res = new ArrayList<>();
        for(String item:obj){
            res.add(fromString(item));
        }
        return res;
    }

    @Override
    public List<Place> listFromFile(String fileName) {
        try (
                FileReader fw = new FileReader(new File(fileName));
                BufferedReader bw = new BufferedReader(fw)) {
            return fromStringList(bw.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Place fromFile(String fileName) {
        try (
                FileReader fw = new FileReader(new File(fileName));
                BufferedReader bw = new BufferedReader(fw)) {
            return fromString(bw.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void toFile(Place place, String fileName) {
        try (
                FileWriter fw = new FileWriter(new File(fileName));
                BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(toString(place));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void listToFile(List<Place> places, String fileName) {
        try(
            FileWriter fw = new FileWriter(fileName);
            BufferedWriter bw = new BufferedWriter(fw)){
            bw.write(toString(places));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String args[]) {

        Place place = new Place();
        place.setRegionName("Chernivtsi");
        place.setStreetName("Golovna");
        place.setHouseNumber("305");
        Serializer serializer = new SerializerTXT();
        serializer.toFile(place, "lastSeeingPlaceTXT");


        List<Place> places = new ArrayList<>();
        places.add(place);
        place = new Place();
        place.setRegionName("Chernivtsi");
        place.setStreetName("Geroiv Maidanu");
        place.setHouseNumber("102B");
        places.add(place);
        serializer.listToFile(places, "lastSeeingPlacesTXT");


        place = serializer.fromFile("lastSeeingPlaceTXT");
        System.out.println(place);
        places = serializer.listFromFile("lastSeeingPlacesTXT");
        System.out.println(places);
    }
}
