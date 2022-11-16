package serialization;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import lab1.Place;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SerializerXML implements Serializer{
    @Override
    public List<Place> listFromFile(String fileName) {
        XmlMapper xmlMapper = new XmlMapper();
        try {
            return xmlMapper.readValue(new File(fileName), new TypeReference<>() {});
        }
        catch (IOException exc) {
            throw new RuntimeException(exc);
        }
    }

    @Override
    public Place fromFile(String fileName){
        XmlMapper xmlMapper = new XmlMapper();
        try {
            return xmlMapper.readValue(new File(fileName), Place.class);
        }
        catch (IOException exc) {
            throw new RuntimeException(exc);
        }
    }

    @Override
    public void toFile(Place place, String fileName){
        XmlMapper xmlMapper = new XmlMapper();
        try {
            xmlMapper.writeValue(new File(fileName), place);
        }
        catch (IOException exc) {
            throw new RuntimeException(exc);
        }
    }

    @Override
    public void listToFile(List<Place> places, String fileName){
        XmlMapper xmlMapper = new XmlMapper();
        try {
            xmlMapper.writeValue(new File(fileName), places);
        }
        catch (IOException exc) {
            throw new RuntimeException(exc);
        }
    }

    public static void main(String args[]) {

        Place place = new Place();
        place.setRegionName("Chernivtsi");
        place.setStreetName("Ukrainska");
        place.setHouseNumber("305");
        Serializer serializer = new SerializerXML();
        serializer.toFile(place, "lastSeeingPlaceXML");

        List<Place> places = new ArrayList<>();
        places.add(place);
        place = new Place();
        place.setRegionName("Chernivtsi");
        place.setStreetName("Geroiv Maidanu");
        place.setHouseNumber("102B");
        places.add(place);
        serializer.listToFile(places, "lastSeeingPlacesXML");

        place = serializer.fromFile("lastSeeingPlaceXML");
        System.out.println(place);
        places = serializer.listFromFile("lastSeeingPlacesXML");
        System.out.println(places);
    }

}
