package lab1;


import java.util.Objects;
import java.time.LocalDate;

/**
 * class "Vanished" with fields: <b>type, sex, name,
 * birthDate, missDate
 * finderPhoneNumber - phone number <b>
 *
 * @author User
 * @version 1.0
 */

public class Vanished {

    enum Type {ANIMAL, HUMAN}

    enum Sex {MALE, FEMALE}

    ;
    private Type type;
    private Sex sex;
    private String name;
    private LocalDate birthDate;
    private LocalDate missDate;
    private Place place;
    private String finderPhoneNumber;

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDate getMissDate() {
        return missDate;
    }

    public void setMissDate(LocalDate missDate) {
        this.missDate = missDate;
    }

    public Place getLastSeeingPlace() {
        return place;
    }

    public void setLastSeeingPlace(Place place) {
        this.place = place;
    }

    public String getFinderPhoneNumber() {
        return finderPhoneNumber;
    }

    public void setFinderPhoneNumber(String finderPhoneNumber) {
        this.finderPhoneNumber = finderPhoneNumber;
    }

    /**
     * Overridden function of comparison an instance of
     * the class "Vanished" and an instance of the class "Object"
     *
     * @return returns the boolean value of the comparison
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vanished)) return false;
        Vanished vanished = (Vanished) o;
        return getType() == vanished.getType() && getSex() == vanished.getSex() && Objects.equals(getName(), vanished.getName()) && getBirthDate().equals(vanished.getBirthDate());
    }

    /**
     * Overridden function of obtaining the hash code
     *
     * @return returns the numeric value of the hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(getType(), getSex(), getName(), getBirthDate());
    }

    /**
     * Overridden function of obtaining a string representation of
     * an instance of a class "Vanished"
     *
     * @return returns the string representation
     */
    @Override
    public String toString() {
        return "Vanished{" +
                "type=" + type +
                ", sex=" + sex +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", missDate=" + missDate +
                ", lastSeeingPlace=" + place +
                ", finderPhoneNumber='" + finderPhoneNumber + '\'' +
                '}';
    }

    /**
     * Class "Builder" with fields: vanished
     *
     * @author User
     * @version 1.0
     */
    public static class Builder {
        private Vanished vanished;

        public Builder() {
            vanished = new Vanished();
        }

        /**
         * Setter type designation
         *
         * @param type - type of vanished
         * @return returns current object
         */
        public Builder setType(Type type) {
            vanished.type = type;
            return this;
        }

        /**
         * Setter sex designation
         *
         * @param sex - sex of vanished
         * @return returns current object
         */
        public Builder setSex(Sex sex) {
            vanished.sex = sex;
            return this;
        }

        /**
         * Setter sex designation
         *
         * @param name - sex of vanished
         * @return returns current object
         */
        public Builder setName(String name) {
            vanished.name = name;
            return this;
        }

        /**
         * Setter sex designation
         *
         * @param birthDate - birth date of vanished
         * @return returns current object
         */
        public Builder setBirthDate(LocalDate birthDate) {
            vanished.birthDate = birthDate;
            return this;
        }

        /**
         * Setter sex designation
         *
         * @param missDate - miss date of vanished
         * @return returns current object
         */
        public Builder setMissDate(LocalDate missDate) {
            vanished.missDate = missDate;
            return this;
        }

        /**
         * Setter sex designation
         *
         * @param place - last place of seeing of vanished
         * @return returns current object
         */
        public Builder setLastSeeingPlace(Place place) {
            vanished.place = place;
            return this;
        }

        /**
         * Setter sex designation
         *
         * @param finderPhoneNumber - finder`s phone number
         * @return returns current object
         */
        public Builder setfinderPhoneNumber(String finderPhoneNumber) {
            vanished.finderPhoneNumber = finderPhoneNumber;
            return this;
        }

        /**
         * Function of creating an object of class "Vanished"
         * @return returns new object of class "Vanished"
         */
        public Vanished build() {
            return vanished;
        }
    }


    public static void main(String args[]) {
    }
}
