package serialization;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lab1.Place;

import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class SerializerJSON implements Serializer {

    @Override
    public List<Place> listFromFile(String fileName) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(new File(fileName), new TypeReference<>() {
            });
        }
        catch (IOException exc) {
            throw new RuntimeException(exc);
        }
    }

    @Override
    public Place fromFile(String fileName){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(new File(fileName), Place.class);
        }
        catch (IOException exc) {
            throw new RuntimeException(exc);
        }
    }

    @Override
    public void toFile(Place place, String fileName){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File(fileName), place);
        }
        catch (IOException exc) {
            throw new RuntimeException(exc);
        }
    }

    @Override
    public void listToFile(List<Place> places, String fileName){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File(fileName), places);
        }
        catch (IOException exc) {
            throw new RuntimeException(exc);
        }
    }

    public static void main(String args[]) {

        Place place = new Place();
        place.setRegionName("Chernivtsi");
        place.setStreetName("Lukiana Kobylytsi");
        place.setHouseNumber("21A");
        Serializer serializer = new SerializerJSON();
        serializer.toFile(place, "lastSeeingPlaceJSON");

        List<Place> places = new ArrayList<>();
        places.add(place);
        place = new Place();
        place.setRegionName("Chernivtsi");
        place.setStreetName("Ruska");
        place.setHouseNumber("88C");
        places.add(place);
        serializer.listToFile(places, "lastSeeingPlacesJSON");

        place = serializer.fromFile("lastSeeingPlaceJSON");
        System.out.println(place);
        places = serializer.listFromFile("lastSeeingPlacesJSON");
        System.out.println(places);
    }
}
