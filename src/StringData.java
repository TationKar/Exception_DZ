import ObjClass.Person;

import java.io.IOException;
import java.io.InputStream;
import java.time.Year;
import java.util.*;

public class StringData {

    Person person = new Person();
    public StringData(String inputStr){
        String tempStr = inputStr.replaceAll("  ", " ");
        List<String> myList = new ArrayList<String>(Arrays.asList(tempStr.split(" ")));
        System.out.println(myList.toString());
        checkArrSz(myList);
        person = parseStr(myList);
        checkPersonField(person);
    }

    private void checkArrSz(List<String> myList){
        if (myList.size()!= 6) throw new RuntimeException("Неверное количество введенных данных: необходимо ввести 6, вы ввели " + myList.size());
    }

    private Person parseStr(List<String> myList){
        //Person person = new Person();
        int counterNames = 0;
        for (int i = 0; i < 6; i++) {
            if (myList.get(i).toString().length() == 1){
                person.setPersons_gender(myList.get(i));
                continue;
            }
            if (myList.get(i).replaceAll("\\D+","").length()==11 ) {
                    person.setPhone_number(Long.parseLong(myList.get(i)));
                continue;
            }
            if (myList.get(i).replaceAll("\\D+","").length()==8 ) {
                person.setDate_of_Birth((myList.get(i)));
                continue;
            }

            if (counterNames < 3) {
                switch (counterNames) {
                    case 0:
                        person.setSurnamePerson((String) myList.get(i));
                        break;
                    case 1:
                        person.setNamePerson((String) myList.get(i));
                        break;
                    case 2:
                        person.setMiddleName((String) myList.get(i));
                        break;
                    default:
                        break;
                }
                counterNames++;
            }
        }
//        System.out.println("Фамилия: " + person.getSurnamePerson().toString());
//        System.out.println("Имя: " + person.getNamePerson().toString());
//        System.out.println("Отчество: " + person.getMiddleName().toString());
//        System.out.println("Номер телефона: " + person.getPhone_number());
//        System.out.println("Пол: " + person.getPersons_gender().toString());
//        System.out.println("Дата рождения: " + person.getDate_of_Birth());
        return person;
    }

    private void checkPersonField(Person person){
        int day = 0;
        int month = 0;
        int year = 0;
        if (person.getSurnamePerson() == null)
            throw new RuntimeException("Нет фамилии, проверьте введенные данные");
        if (person.getNamePerson() == null)
            throw new RuntimeException("Нет имени, проверьте введенные данные");
        if (person.getMiddleName() == null)
            throw new RuntimeException("Нет отчества, проверьте введенные данные");
        if (person.getPhone_number() == null)
            throw new RuntimeException("Нет отчества, проверьте введенные данные");
        if (person.getPhone_number() >= 90000000000L || person.getPhone_number() <= 88000000000L)
            throw new RuntimeException("Некорректный номер телефона");
        if (!person.getPersons_gender().toString().equals("f") && !person.getPersons_gender().toString().equals("m"))
            throw new RuntimeException("Неправильно указан пол");
        day = Integer.parseInt(person.getDate_of_Birth().toString().substring(0,2));
        //System.out.println("day = " + day);
        month = Integer.parseInt(person.getDate_of_Birth().toString().substring(3,5));
        //System.out.println("month = " + month);
        year = Integer.parseInt(person.getDate_of_Birth().toString().substring(6,10));
        //System.out.println("year = " + year);
        if (day >31 || month > 12 || year > Year.now().getValue())
            throw new RuntimeException("Некорректная дата рождения");
    }
}
