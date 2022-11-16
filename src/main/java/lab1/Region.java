package lab1;

import java.util.List;
import java.util.Objects;

/**
 * class "Region" with fields: <b> nameOfRegion,
 * square - km^2, numberOfPeople, numberOfAnimal, list of vanished <b>
 * @author User
 * @version 1.0
 */

public class Region { //місце да бачили новий клас де параметр регіон
    private String regionName;
    private float square;
    private int peopleNumber;
    private int animalNumber;
    private List<Vanished> vanished;

    public String getRegionName() {
        return regionName;
    }

    public float getSquare() {
        return square;
    }

    public int getPeopleNumber() {
        return peopleNumber;
    }

    public int getAnimalNumber() {
        return animalNumber;
    }

    public List<Vanished> getVanished() {
        return vanished;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public void setSquare(float square) {
        this.square = square;
    }

    public void setPeopleNumber(int peopleNumber) {
        this.peopleNumber = peopleNumber;
    }

    public void setAnimalNumber(int animalNumber) {
        this.animalNumber = animalNumber;
    }

    public void setVanished(List<Vanished> vanished) {
        this.vanished = vanished;
    }

    /**
     * Overridden function of comparison an instance of
     * the class "Region" and an instance of the class "Object"
     * @return returns the boolean value of the comparison
     */
    @Override
    public boolean equals(Object o) { //without animal and people
        if (this == o) return true;
        if (!(o instanceof Region)) return false;
        Region region = (Region) o;
        return getSquare() == region.getSquare() && getRegionName().equals(region.getRegionName());
    }

    /**
     * Overridden function of obtaining the hash code
     * @return returns the numeric value of the hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(getRegionName(), getSquare());
    }

    /**
     *  Overridden function of obtaining a string representation of
     *  an instance of a class "Region"
     *  @return returns the string representation
     */
    @Override
    public String toString() {
        return "Region{" +
                "nameOfRegion='" + regionName + '\'' +
                ", squeare=" + square +
                ", numberOfPeople=" + peopleNumber +
                ", numberOfAnimal=" + animalNumber +
                ", vanished=" + vanished +
                '}';
    }

    /**
     * Class "Builder" with fields: region
     * @author User
     * @version 1.0
     */
    public static class Builder{
        private Region region;
        public Builder(){
            region = new Region();
        }

        /**
         * Setter name designation
         * @param regionName - name of region
         * @return returns current object
         */
        public Builder setRegionName(String regionName){
            region.regionName = regionName;
            return this;
        }
        /**
         * Setter square designation
         * @param square -square of region
         * @return returns current object
         */
        public Builder setSquare(float square){
            region.square = square;
            return this;
        }
        /**
         * Setter number of people designation
         * @param peopleNumber - number of people of region
         * @return returns current object
         */
        public Builder setPeopleNumber(int peopleNumber){
            region.peopleNumber = peopleNumber;
            return this;
        }
        /**
         * Setter number of animal designation
         * @param animalNumber -number of animal of region
         * @return returns current object
         */
        public Builder setAnimalNumber(int animalNumber){
            region.animalNumber = animalNumber;
            return this;
        }
        /**
         * Setter list of vanished designation
         * @param vanished - list of vanished of region
         * @return returns current object
         */
        public Builder setVanished(List<Vanished> vanished){
            region.vanished = vanished;
            return this;
        }

        /**
         * Function of creating an object of class "Region"
         * @return returns new object of class "Region"
         */
        public Region build(){
            return region;
        }
    }

    public static void main(String args[]) {
    }
}
