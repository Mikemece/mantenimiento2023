import java.util.List;

/**
 * Class representing a person with a name, age and gender
 * @author Miguel Moya
 */
public class Person {
    private final String name;
    private final int age;
    private final String gender;

    /**
     *
     * @param name the name of the person
     * @param age the age o the person
     * @param gender the gender of the person
     */

    public Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String name(){
        return name;
    }

    public int age() {
        return age;
    }

    public String gender() {
        return gender;
    }

    /**
     * Computes the average age of male and female persons in a list and returns in
     * an array of two elements (the first element is the male mean age and the second one is
     * the female mean age)
     * @param persons
     * @return
     */
    public double[] averageAgePerGender(List<Person> persons) {
        double nMale = 0, nFemale = 0;
        double totalAgeMale = 0, totalAgeFemale = 0;
        double averageMale = 0, averageFemale = 0;

        if (persons.isEmpty()) {
            throw new RuntimeException("Lista vacía");
        }
        for (int i = 0; i < persons.size(); i++) {
            if (persons.get(i).gender.toUpperCase().equals("MALE")) {
                nMale++;
                totalAgeMale += persons.get(i).age;
            } else if (persons.get(i).gender.toUpperCase().equals("FEMALE")) {
                nFemale++;
                totalAgeFemale += persons.get(i).age;
            }else{
                throw new RuntimeException("Gender not binary or missing");
            }
        }
        if(nMale>0){
            averageMale=totalAgeMale/nMale;

        }
        if(nFemale>0){
            averageFemale=totalAgeFemale/nFemale;
        }
        double[] result = {averageMale, averageFemale};
        return result;
    }

}
