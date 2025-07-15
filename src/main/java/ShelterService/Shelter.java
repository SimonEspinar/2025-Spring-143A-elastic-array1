package ShelterService;

public class Shelter {
    /*
    store the records of Pets {Cats, Dogs}
    using the elastic array
     */

    ElasticArray<Pet> pets;

    /*
    increase the age of each pet by 1 every year
     */

    public void increaseAge() {
        for (int i = 0; i < pets.getCapacity(); i++) {
            Pet pet = pets.read(i);
            pet.setAge(pet.getAge() + 1);
        }
    }
}