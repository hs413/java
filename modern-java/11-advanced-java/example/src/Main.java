public class Main {

    public static void main(String[] args) {
        Person person = new Person();
        String a = getCarInsuranceName(person);
        System.out.println(a);
    }

    public static String getCarInsuranceName(Person person) {
        // null 에러 발생
        // return person.getCar().getInsurance().getName();

        // null 방지 방법1
//        if (person.getCar() == null) {
//            Car car = person.getCar();
//
//            if (car != null) {
//                Insurance insurance = car.getInsurance();
//                if (insurance != null) {
//                    return insurance.getName();
//                }
//            }
//        }
//        return "Unknown";

        // null 방지 방법2
        if (person.getCar() == null) {
            return "Unknown";
        }

        Car car = person.getCar();
        if (car == null) {
            return "Unknown";
        }

        Insurance insurance = car.getInsurance();
        if (insurance == null) {
            return "Unknown";
        }

        return insurance.getName();
    }
}