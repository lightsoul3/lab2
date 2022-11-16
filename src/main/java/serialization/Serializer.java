package serialization;

import lab1.Place;

import java.util.List;


public interface Serializer {

    List<Place> listFromFile(String fileName);

    Place fromFile(String fileName);

    void toFile(Place place, String fileName);

    void listToFile(List<Place> places, String fileName);

}
