import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        Optional<Person> person = Optional.of(new Person());
        String a = getCarInsuranceName(person);
        System.out.println(a);
    }

    public static String getCarInsuranceName(Optional<Person> person) {
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
//        if (person.getCar() == null) {
//            return "Unknown";
//        }
//
//        Car car = person.getCar();
//        if (car == null) {
//            return "Unknown";
//        }
//
//        Insurance insurance = car.getInsurance();
//        if (insurance == null) {
//            return "Unknown";
//        }
//
//        return insurance.getName();

        // optional, flatmap 사용
        return person.flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(Insurance::getName)
                .orElse("Unknown");
    }

    public static void createOptional() {
        // 빈 optional
        Optional<Car> optCar = Optional.empty();

        // null이 아닌 optional
        Optional<Car> optCar2 = Optional.of(new Car());

        // null값으로 optional: car가 null이면 빈 optional 객체 반환
        Optional<Car> optCar3 = Optional.ofNullable(new Car());


        // map으로 optional 값 추출하기
        // optional 미사용
        Insurance insurance = new Insurance();
        String name = null;
        if (insurance != null) {
            name = insurance.getName();
        }

        // optional 사용
        Optional<Insurance> optInsurance = Optional.ofNullable(insurance);
        Optional<String> optName = optInsurance.map(Insurance::getName);


    }
}