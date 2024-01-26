import ObjClass.Person;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CreateFile {

    public CreateFile(Person person) throws IOException {
        String nameFromSurname = person.getSurnamePerson().toString();
        String pathFile = "/Users/tationkar/Documents/FullStack/Exception/3rd_DZ_itog/dz_exception_final/src/Files/" + nameFromSurname;

        File f = new File(pathFile);
        if (f.exists()) {
            try (FileWriter fileWriter = new FileWriter(f, true);
                 BufferedWriter bw = new BufferedWriter(fileWriter)) {
                bw.write("\n<" + person.getSurnamePerson().toString() + "><" + person.getNamePerson().toString() + "><" + person.getMiddleName().toString() + "><" + person.getDate_of_Birth().toString() + "><" + person.getPhone_number().toString() + "><" + person.getPersons_gender() + ">");
            }
        } else {
            try (FileWriter fileWriter = new FileWriter(f);
                 BufferedWriter bw = new BufferedWriter(fileWriter)) {
                bw.write("<" + person.getSurnamePerson().toString() + "><" + person.getNamePerson().toString() + "><" + person.getMiddleName().toString() + "><" + person.getDate_of_Birth().toString() + "><" + person.getPhone_number().toString() + "><" + person.getPersons_gender() + ">");
            }
        }
    }
}
